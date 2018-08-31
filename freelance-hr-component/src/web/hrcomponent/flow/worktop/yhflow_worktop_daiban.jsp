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
<title>业务工作台</title>
<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet" type="text/css"/>
<%-- <%@ include file="/include/js_css_admin_include.jsp"%> --%>
<%@ include file="/include/js_css_base_include.jsp"%>
<script type="text/javascript">
var worktop = null;
$(document).ready(function(){
	worktop = new Worktop([
		{
			xtype:'Xtable',
			xname:'grid',
			url: 'listBusinessInfo.do?method=listBusinessInfo&dataType=daiban',
			rowNumber: true,
			checkbox: true,
			start : '${param.pageNo}'==''?1:'${param.pageNo}',
			iPageLength: '${param.limit}'==''?30:'${param.limit}',
			singleCheck: false,
			columns: [
				{header:'任务名称', field:'task_name', width:80 ,render:
					function(v,r){
					return $.format("<a  onclick=goFlowProcedure('"+r.data.file_ID+"','"+r.data.task_id+"')  style=color:green>{0}</a>",v);
				}
				},
				{header:'流程处理状态', field:'file_Flow_Status', width:80},
				{header:'发送人', field:'send_user', width:80},
				{header:'发送时间', field:'send_time', width:80}
			]
		},
		{
			xtype: 'QueryForm',//属性对应的构造函数
			xname: 'form',//属性名
			el:'#fr_wsid'
		},
		{
			xtype: 'Toolbar',//属性对应的构造函数
			xname: 'tbar',
			//tbar: '#fr_tbar',
			//fbar: '#fr_fbar',
			buttons: {
				 'goFlowProcedure': function(){
					 var rows = worktop.grid.selectModel.getSelectRows();
					 if (rows.length != 1) {
							MessageBox.alert('提示', "请选择一条记录再操作");
					 }else{
						 var fileId = rows[0].data.file_ID;
						 var templateId = rows[0].data.template_Id;
						 Widget.openContent("goFlowProcedureMainPage.do?method=goFlowProcedureMainPage&fileId="+fileId+"&templateId="+templateId,function(){
							 worktop.form.goQuery();
						 });
					 }
				}
			} 
		}    
	]);
	
	$(window).resize(function(){
		worktop.grid.wrap.find('.ct').height(
			$(window).height() 
			- $('.sitemap').outerHeight(true)
			//- worktop.form.el.parent().outerHeight(true) //form 没有高度
			- (worktop.tbar.ct ? worktop.tbar.ct.outerHeight(true) : 0)
			- 48
			);//48(分页48)
	}).resize();
	
	worktop.form.goQuery();
});
function goback(){
	HistoryRegister.go("goHomepage");
};
/* function goFlowProcedure(fileId,taskId){
	Widget.openContent("goFlowProcedureMainPage.do?method=goFlowProcedureMainPage&fileId="+fileId+"&taskId="+taskId);
} */
</script>
</head>
<body  style="overflow-x: hidden;">
<div class="sitemap">
      当前位置：
        <span>业务办理 </span>
        <div class="go_back"><a href="javascript:void(0);" onclick="goback();"><span style="font-family: sans-serif;"><< </span>返回</a></div>
    <div style="clear: both"></div>
</div>
<div>
	<div class='handle-btn-group'>
		<!-- 操作按钮 -->
		<div class="handle-btn clearfix" id="fr_tbar">
			<button class="btn-add btn-left-icon btn-default check_transaction_popdown" button-click="add">新增</button>
			<button class="btn-delete btn-left-icon btn-default" button-click="delete">删除</button>
			<button class="btn_add" button-click="goFlowProcedure">流程过程</button>
	    </div>
		<!-- 列表内容展示-->
		<table class="x-table sortable ellipsis striped hover"></table>
	</div>
	
	<!--浮动操作列表
	<div id="fr_fbar" style="display:none;" class="handel-float" >
	    <em></em>
	    <span></span>
	    <button class="btn-modify btn-left-icon btn-default" button-click="update">修改</button>
	    <button class="btn-look btn-left-icon btn-default" button-click="show">查看</button>
	</div>-->
</div>
</body>

</html>