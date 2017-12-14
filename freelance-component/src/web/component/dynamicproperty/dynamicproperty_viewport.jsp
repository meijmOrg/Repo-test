<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0"/>
<title>字段列表</title>
<%-- <%@ include file="/include/js_css_admin_include.jsp"%> --%>
<script type="text/javascript">

var worktop_dynamic = null;
$(document).ready(function(){
	worktop_dynamic = new Worktop([
		{
			xtype:'Xtable',
			xname:'grid',
			url: 'getPropertyList.do?method=getDynamicPropertyList&dpCode=${dpCode}',
			rowNumber: true,
			start : '1',
			iPageLength:'30',
			columns: [
				{header:'操作', css:'operation', type: 'html', width:50, render: 
					function(v,r){
						var dpId=r.data.dpId;
						var dpCode=r.data.dpCode;
						return $.format('<a  onclick="deleteDp('+dpId+',"'+dpCode+'")"  style="color:green">删除</a>', r.data);
					}
				},
				{header:'字段名称', field:'dpName', width:80},
				{header:'字段类型', field:'dpType', width:80},
				{header:'字段含义', field:'dpDescription', width:80},
				{header:'字段类别', field:'dpCategory', width:80},
				{header:'字段状态', field:'dpState', width:80},
				{header:'字段编码', field:'dpCode', width:80}
			]
		},
		{
			xtype: 'QueryForm',//属性对应的构造函数
			xname: 'dynamicForm'//属性名
			/*  el:'#fr_wsid'  */
		}
	]);
	
     $(window).resize(function(){
		worktop_dynamic.grid.wrap.find('.ct').height(
				$('#messageTabWarning').height()-$('.page_foot').height()-48
			);//48(分页48)
	}).resize().unbind();
     worktop_dynamic.dynamicForm.goQuery();
});
function deleteDp(dpId,dpCode){
	if(dpId){
		MessageBox.yes('提示','请确认是否删除?', function(){
			$.ajax({
				url : 'deleteDynamicProperty.do?method=deleteDynamicProperty',
				data : {dpId:dpId},
				dataType : 'json',
				type:'POST',
				error : function(){
					MessageBox.alert('提示',"删除失败，请重新操作！");
				},
				success : function(data) {
					if(data.success==true){
						goToTableProperty(dpCode);
					    goToDynamicProperty(dpCode);
					}else{
						MessageBox.alert("提示","刪除失敗！");
					}
				}
			});
		})
		
	}
}
</script>
</head>
<body style="overflow-x: hidden;">
<div>
	<!-- 列表内容展示-->
	<table class="x-table sortable ellipsis striped hover"></table>
</div>
</body>
