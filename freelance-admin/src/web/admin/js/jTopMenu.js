
var jTopMenu = (function($, window){
	
	// 菜单结构要求说明：
	// url为#，表示无连接，为父项菜单，否则视为可跳转的菜单（子项）
	// 菜单结构目前仅支持3层
	// 从后台获取菜单结构，渲染到指定div（菜单为完整结构，不是逐步加载）
	// html结构固定（参照静态页面）
	
	// 渲染规则
	// # 代表无连接，通常#代表是一个父类菜单，（没有location的，建议写成#）
	// 菜单结构下，全部为#，则这一个菜单结构不会构建（由于权限控制，没有任何子菜单的权限，那么这个顶部菜单、二级菜单都不会渲染，如果配置的菜单结构全部为#，也不会渲染出来）
	
	var jMenu;//菜单DIV
	
	//加入动画效果，源代码是ui提供
	function initAnimationAction() {
		var timer_dd1 = null;
	    // 点击淡入淡出
	    $('.navigation-down-inner dl dd').click(function(){
	        if(!timer_dd1){
	            clearTimeout(timer_dd1);
	            setTimeout(function(){
	                $('.navigation-down').slideUp(500);//淡出
	            },200);
	        }else{
	            timer_dd1 = setTimeout(function(){
	                $('.navigation-down').slideUp(500);//淡出
	            },200);
	        }
	    })
	    $('.navigation-down-inner dl dd').click(function(){
	        if(!timer_dd1){
	            clearTimeout(timer_dd1);
	            setTimeout(function(){
	                $('.navigation-down').slideUp(500);//淡出
	            },200);
	        }else{
	            timer_dd1 = setTimeout(function(){
	                $('.navigation-down').slideUp(500);//淡出
	            },200);
	        }
	    })
	    $('.head-nav ul li').mousemove(function(){
	        $('.navigation-down').slideDown();//淡入
	    })
		
		var qcloud={};
        $('[_t_nav]').hover(function(){
            var _nav = $(this).attr('_t_nav');
            clearTimeout( qcloud[ _nav + '_timer' ] );
            qcloud[ _nav + '_timer' ] = setTimeout(function(){
                $('[_t_nav]').each(function(){
                    $(this)[ _nav == $(this).attr('_t_nav') ? 'addClass':'removeClass' ]('h-nav-linkactive');
                });
                $('#'+_nav).stop(true,true).slideDown(200);
            }, 150);
        },function(){
            var _nav = $(this).attr('_t_nav');
            clearTimeout( qcloud[ _nav + '_timer' ] );
            qcloud[ _nav + '_timer' ] = setTimeout(function(){
                $('[_t_nav]').removeClass('h-nav-linkactive');
                $('#'+_nav).stop(true,true).slideUp(200);
            }, 150);
        });
	}
	function onClickTab($tab) {
		var href = $tab.attr('url');
		$('#mho_main_frame').attr('src', href);
		$('.mho_center_tabs li').removeClass('mho_selected');
		$tab.closest('li').addClass('mho_selected');
	}
	$('.mho_center_tabs li a').click(function() {
		onClickTab($(this));
	});
	//加入事件支持，jViewer为外部iframe的封装对象
	function initClickAction(menu,jViewer) {
		
		menu.find('[url]').click(function(){
			var href = $(this).attr('url');
			var text = $(this).text();
			var $a = $('.mho_center_tabs li a[url="'+href+'"]');
			if($a.length > 0) {
				jViewer.go($(this).attr('url'));
				$('.mho_center_tabs li').removeClass('mho_selected');
				$a.closest('li').addClass('mho_selected');
			}else {
				var $li = $('<li><a href="javascript:void(0);" url="'+href+'">'+text+'</a><i class="fa fa-remove"></i></li>')
					.appendTo($('.mho_center_tabs'));
				$li.find('a').click(function() {
					onClickTab($li.find('a'))
				}).click();
				$li.find('i.fa.fa-remove').click(function() {
					if( $(this).closest('li').hasClass('mho_selected') ) {
						$(this).closest('li').prev('li').find('a').click().end().end().remove();
					}else {
						$(this).closest('li').remove();
					}
				});
			}
			
		});
		/*$('._jChildMenu').find('[url]').click(function(){
			jViewer.go($(this).attr('url'));
		});*/
	}
	
	//查询并构建
	function listMenuTree(id,jViewer) {
		jMenu = $(id);//包含菜单的上层DIV
		//var jMenuDiv = jMenu.find('._jTopMenu');//要求第一级菜单需要加上 _jTopMenu 样式标记
		//var jMenuChildDiv = $('._jChildMenu');//要求子菜单区域需要加上 _jChildMenu 样式标记
		
		$.get('listSysMenuTree.do?method=listSysMenuTree', function(data) {
			if (data) {
				var jMenuBuffer = [];
				var jMenuChildBuffer = [];
				//构建一级菜单
				$.each(data, function(index , top){
					var buffL1 = [];
					
					var childMenuHtml = buildChildMenu(top);
					
					if (childMenuHtml) {
						jMenuChildBuffer.push(childMenuHtml);
						
						buffL1.push($.format('<li class="menu22">', top));
						buffL1.push($.format('<a   href="javascript:void(0)" >{name}</a>', top));
						buffL1.push(childMenuHtml);
						buffL1.push('</li>');
					}
					else if (top.location && top.location != '#') {
							
						buffL1.push($.format('<li class="menu22">', top));
						buffL1.push($.format('<a  href="javascript:void(0)" url="{location}">{name}</a>', top));
						buffL1.push('</li>');
					}
					
					jMenuBuffer.push(buffL1.join(''));
					
				});
				$(".mho_left_menu_tree").html(jMenuBuffer.join(''));
				$('.mho_left_menu_tree li').click(function(e) {
		   			e.stopPropagation();
		   			$(this).children('ul').slideToggle();
		   		});;
				/*jMenuDiv.html(jMenuBuffer.join(''));
				jMenuChildDiv.html(jMenuChildBuffer.join(''));
				
				
				initAnimationAction(jMenu);
				*/
		   		initClickAction(jMenu,jViewer);
				jMenu.find('[url]:first').click();//跳转到第一个菜单
			}
		}, 'json');
	}
	
	//构建二级菜单
	function buildChildMenu(top) {
		var buffL2 = [];//二级菜单
		
		if (top.children && top.children.length > 0) {
			//二级菜单
			buffL2.push($.format('<ul>', top));
			//buffL2.push('  <div class="navigation-down-inner">');
			
			var jMenuL2 = [];//<dl><dt>L2</dt><dd>L3</dd><dd>L3</dd></dl> <dl><dt>L2</dt><dd>L3</dd><dd>L3</dd></dl>
			
			//构建二级菜单，则构建第二级菜单
			$.each(top.children, function() {
				
				var temp = ['<li>'];
				
				//如果有第三级菜单，则构建第三级菜单
				if (this.children && this.children.length > 0) {
					var buffL3 = ['<ul>'];
					
					for (var i=0; i<this.children.length; i++) {
						//第三级菜单
						if (this.children[i].location && this.children[i].location != '#') {
							buffL3.push($.format('<li><a href="javascript:void(0)" url="{location}">{name}</a></li>', this.children[i]));
						}
					}
					buffL3.push('</ul>');
					//有三级菜单，二级菜单 就要放到dt里面去
					if (buffL3.length > 0) {
						temp.push($.format('<a href="javascript:void(0)">{name}</a>', this));
						temp.push(buffL3.join(''));//三级菜单追加到二级菜单下
					}
					else {
						//没有三级菜单（无权限），则去除该二级菜单
						temp = null;
						return true;//跳出第二层菜单循环
					}
				} 
				// 没有三级菜单情况下，如果有location，则加入菜单
				else if (this.location && this.location != '#') {
					temp.push($.format('<a href="javascript:void(0)" url={location}>{name}</a>', this));
				} 
				//数据不符要求
				else {
					return true;//跳出第二层菜单循环
				}
				
				//存在有效的三级菜单，或有效的location才组装
				temp.push('</li>');
				jMenuL2.push(temp.join(''));
			});
			
			if (jMenuL2.length > 0) {
				buffL2.push(jMenuL2.join(''));
			//	buffL2.push('</div>');
				buffL2.push('</ul>');
				
				return buffL2.join('');
			}
		}
		
		return null;
	}
	
	return {
		init: listMenuTree
	}
	
})(jQuery, window);