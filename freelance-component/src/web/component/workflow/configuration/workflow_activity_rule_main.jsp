<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%@taglib uri="dictionary.tld" prefix="dictionary" %>
<%@taglib uri="c.tld" prefix="c"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head lang="l">
    <meta charset="UTF-8">
    <title>流程设置</title>
	<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/comm/customJs.js"></script>
    <%-- <%@ include file="/include/js_css_admin_include.jsp"%> --%>
    <%@ include file="/include/js_css_base_include.jsp"%>
    
    <style>
    	.floatDiv{float:left;}
    </style>
   	<script type="text/javascript">
function goback(){
	HistoryRegister.go("goWorkflowConfigurationUpdate");
}
function sendData(data){
	$.ajax({   										 
		url : 'updateWorkflowBaseInfo.do?method=updateFlow',
		data : '',
		dataType : 'json',
		type:'POST',
		error : function(){
			MessageBox.alert('提示',"操作失败，请重新操作！");
		},
		success : function(data) {
			if(data.success==true){
				worktop_dynamic.dynamicForm.goQuery();
			}else{
				MessageBox.alert("提示","操作失败,请重新操作！");
			}
		}
	});
	
}
</script>
</head>
<body>
<div class="sitemap">
    <ul style="float: left">
        <li>当前位置：</li>
        <li><a href="#">基础信息管理&gt;</a></li>
        <li><a href="#">信息管理 &gt;</a></li>
        <li><a href="#">模板管理&gt;</a></li>
        <li><a href="#">新建流程</a></li>
    </ul>
    <div class="go_back"><a href="javascript:void(0);" onclick="goback();"><span style="font-family: sans-serif;"><< </span>返回</a></div>
    <div style="clear: both"></div>
</div>
<div class="md-main-content">
	        <jsp:include page="/component/workflow/configuration/drawing/demo.html"></jsp:include>    
        	</div>
</body>

</html>