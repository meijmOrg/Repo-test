(function() {
	$('.mho_left_menu_tree li').click(function(e) {
		e.stopPropagation();
		$(this).children('ul').slideToggle();
	});
	
	$('#toggleLeft').click(function() {
		if($(this).find('i.fa').hasClass('fa-arrow-left')) {
			$('.mho_left_menu').animate({'left': '-200px'});
			$('.mho_center').animate({'left': '0'});
			$(this).find('i.fa').addClass('fa-arrow-right').removeClass('fa-arrow-left');
		}else {
			$('.mho_left_menu').animate({'left': '0'});
			$('.mho_center').animate({'left': '200px'});
			$(this).find('i.fa').addClass('fa-arrow-left').removeClass('fa-arrow-right');
		}
	});
	$('#backward').click(function() {
		$('.mho_center_tabs').scrollLeft($('.mho_center_tabs')[0].scrollLeft-100);
	});
	$('#forward').click(function() {
		$('.mho_center_tabs').scrollLeft($('.mho_center_tabs')[0].scrollLeft+100);
	});

	function onClickTab($tab) {
		var href = $tab.attr('data-href');
		$('#mho_main_frame').attr('src', href);
		$('.mho_center_tabs li').removeClass('mho_selected');
		$tab.closest('li').addClass('mho_selected');
	}
	
	$('.mho_center_tabs li a').click(function() {
		onClickTab($(this));
	});

	$('.mho_left_menu_tree li a[data-href]').click(function() {
		var href = $(this).attr('data-href');
		var text = $(this).text();
		var $a = $('.mho_center_tabs li a[data-href="'+href+'"]');
		if($a.length > 0) {
			$a.click();
		}else {
			var $li = $('<li><a href="javascript:void(0);" data-href="'+href+'">'+text+'</a><i class="fa fa-remove"></i></li>')
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
}());