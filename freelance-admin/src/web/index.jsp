<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<%@page import="com.yh.platform.core.web.UserContext"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0" />
    <title>医院人事管理系统</title>
   <%@ include file="/include/js_css_base_include.jsp"%> 
    <link rel="stylesheet" href="component/front_transform/mho.css">
    <link rel="stylesheet" href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">

    <script src="admin/js/jTopMenu.js" type="text/javascript"></script>
    <script type="text/javascript">
    $(function(){
    	$.get("checkPasswordForUpdate.do?method=checkPsw",function(data){
    		if(data&&data=="OK") {
	 			Widget.openContent("goUsersDefaultPasswordUpdatePage.do?method=goUsersDefaultPasswordUpdatePage");
    			$("#headerMenuId ._jTopMenu,#headerMenuId #updatepassword,iframe[name=szghrsmain]").hide();
    		}
    	});
    	
    	$('[button-click=downDoc]').click(function(){
    		MessageBox.openWindow('downFile.do?method=downFile&fileName=help.rar');
    	});
    	$('.mho_left_menu_tree li').click(function(e) {
    		e.stopPropagation();
    		$(this).children('ul').slideToggle();
    	});
    })
    
    </script>
 </head>
<body>
	<div class="mho">
	<nav class="mho_nav" id="mho_nav">
		<div class="mho_nav_logo">
			<img src="yhhtml/img/logo.png">
		</div>
		<div class="mho_nav_tools">
		</div>
	</nav>
	<div class="mho_main">
		<div class="mho_left_menu" id="menuId">
			<div class="mho_person">
				<table>
					<tr>
						<td class="mho_person_img">
							<img src="yhhtml/img/person.png">
						</td>
						<td class="mho_person_info">
							<p><%= UserContext.getLoginUserID()%></p>
						</td>
					</tr>
				</table>
			</div>
			<ul class="mho_left_menu_tree">
			</ul>
		</div>
		<div class="mho_center">
			<div class="mho_center_left_tools">
				<a href="javascript:void(0)" id="toggleLeft"><i class="fa fa-arrow-left"></i></a>
			</div>
			<ul class="mho_center_tabs">
				<li class="mho_selected"><a href="javascript:void(0);" url="goHomepage.do?method=goHomepage">首页</a></li>
			</ul>
			<div class="mho_center_right_tools">
				<a href="javascript:void(0)" id="backward"><i class="fa fa-backward"></i></a>
				<a href="javascript:void(0)" id="forward"><i class="fa fa-forward"></i></a>
			</div>
			<iframe id="mho_main_frame" class="mho_center_main" name="szghrsmain" style="width:100%;height:100%;border:0;">
			</iframe>
		</div>
	</div>
</div>
<script type="text/javascript">
    $('#logoutId').click(function(){
		MessageAction.yeah('是否要退出系统？', function(){
			window.location.href = 'logout.do?method=logout';
		})
	});
    $('#updatepassword').click(function(){
		Widget.openContent("goUsersPasswordUpdatePage.do?method=goUsersPasswordUpdatePage");
	});
   	var jViewer = (function($, window, document){
   		var $frame = $('iframe[name=szghrsmain]');
   		
   		 $(window).resize(function(){
   			$frame.height($(window).height() - $('#mho_nav ').outerHeight(true)-40);//头部菜单
   		}).resize();
   		 
   		return {
   			go: function(url) {
   				$frame.attr('src', url+"&_ts="+(new Date().getTime()));
   			}
   		}
   	})(jQuery, window, document);
   	
   	//初始化事件
   	$(function(){
   		jTopMenu.init('#menuId',jViewer);
   	}); 
</script>
<script src="yhhtml/index/index.js"></script>
</body>
</html>