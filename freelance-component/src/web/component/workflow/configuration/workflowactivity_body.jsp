<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>

<!--
 * @function    模板信息body页面
 * @page name   workflowTemplet_body.jsp
 * @author      liul
 * @created     2017/11/29
 * @version     1.0
-->
<!DOCTYPE html>
<html lang="cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板信息页面</title>
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}

#cen_right_top{width:720px;margin:40px auto 0 auto;}
#cen_right_top .active{background:url(component/workflow/configuration/images/qiehuan.jpg) no-repeat;color:#F3F3F3;}
#cen_right_top h3{line-height:35px;text-align:center;float:left;height:35px;width:182px;margin::0px;padding:0px;background-color:#F3F3F3;font-size:14px;color:#333333;font-weight:lighter;cursor:pointer;}
#cen_right_top div{font-size:14px;display:none;clear:both;height:100px;padding:20px 0px 0px 20px;border-top-width:medium;border-top-style:solid;border-top-color:#A0603D;}
</style>
</head>

<body class="modal-body">
<div id="cen_right_top">
	<h3 class="active" onclick="changeTab(0)">a</h3>
	<h3  onclick="changeTab(1)">b</h3>
	<h3  onclick="changeTab(2)">c</h3>
	<div style="display:block">aaaa</div>
	<div>bbbb</div>
	<div>cccc</div>
</div>
</body>
</html>