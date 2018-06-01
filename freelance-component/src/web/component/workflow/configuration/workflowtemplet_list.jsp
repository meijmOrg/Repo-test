<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/jsp_headers.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0"/>
<title>模板管理页面</title>
<%-- <%@ include file="/include/js_css_admin_include.jsp"%> --%>
	<%@ include file="/include/js_css_base_include.jsp"%>
<style type="text/css">
.left_wfc {
    float: left;
    width: 50%;
    background-color: #fff;
    height:100%;
}
.right_content_wfc {
    background-color: #fff;
    float:left;
    margin-right: 20px;
    width:48%;
}
</style>
</head>
<body>
<div class="sitemap">
    <ul style="float: left">
        <li>当前位置：</li>
        <li><a href="#">基础信息管理&gt;</a></li>
        <li><a href="#">信息管理 &gt;</a></li>
        <li><a href="#">模板管理</a></li>
    </ul>
    <div class="go_back"><a href="javascript:void(0);" onclick="goback();"><span style="font-family: sans-serif;"><< </span>返回</a></div>
    <div style="clear: both"></div>
</div>
	<!--左导航-->
	<div class="left_wfc" >
	    <div>
	    	<table class="x-table sortable ellipsis striped hover" id='systemPosition'></table>
		</div> 
		<div style="clear: both"></div>
	</div> 
	<!--中间主体内容-->
	<div class="right_content_wfc" style="height: auto; padding-bottom: 0px;">
		<div id="sp_fbar" style="display: block;">
		<em></em><span></span>
		<button class="btn_add" onclick="addTemplet()">新增</button>
		<button class="btn_add" onclick="updateTemplet()">修改</button>
		<button class="btn_delete" onclick="deleteTemplet()">删除</button>
		<button class="btn_add" onclick="goFlowProcedure()">流程过程</button>
	</div>
	<div id="right_wfc"></div>
	</div>
</body>
<script type="text/javascript">
var worktop = null;
$(document).ready(function() {
	
	worktop = new Worktop([
		{
			xtype:'Xtable',
			xname:'grid',
			url: 'listWorkflowTemplet.do?method=listWorkflowTemplet',
			lengthMenu:[30,50,100],
			paginationType: 'input',
			rowNumber: true,
			el:'#systemPosition', 
			checkbox: true,
			singleCheck: true,
			columns: [
				{header:'模板名称', field:'templateName', width:150,render:function(record, rowIndex, row){
					var templateId = worktop.grid.store.params.templateId;
					var records = worktop.grid.selectModel.getSelectRows();
					if(templateId == null || templateId == ''){
						if(records.length == 0 && rowIndex.index == 0){
							var row = this.tbody.find('tr[rowIndex='+rowIndex.index+']');
							row.addClass('selected').find('input.cbm').prop('checked',true);
							$("#right_wfc").load('goViewWorkflowTemplet.do?method=goViewWorkflowTemplet',{"templetId":rowIndex.data.templateId});
							}
						}else{
							if(records.length == 0 && rowIndex.data.templateId == templateId){
								var row = this.tbody.find('tr[rowIndex='+rowIndex.index+']');
								row.addClass('selected').find('input.cbm').prop('checked',true);
								$("#right_wfc").load('goViewWorkflowTemplet.do?method=goViewWorkflowTemplet',{"templetId":rowIndex.data.templateId});
								}
							}
					
					return record;
					}},
				{header:'模板编码', field:'templateCode', width:150},
				{header:'模板分类', field:'templateType', width:150}		
				]
		}
	]);
	
	$(worktop.grid.selectModel.selectRow).click(function(){
		var records = worktop.grid.selectModel.getSelectRows();
		if(records.length == 1){
			$("#right_wfc").load('goViewWorkflowTemplet.do?method=goViewWorkflowTemplet',{"templetId":records[0].data.templateId});
			}
	});
	$(window).resize(function(){
		worktop.grid.wrap.find('.ct').height(
			$(window).height() 
			- $('.sitemap').outerHeight(true)
			- 48
			);//48(分页48)
	}).resize();
	worktop.grid.store.load({
		params: {start:0, limit: worktop.grid.page.limit}
	});
});
function goback(){
	HistoryRegister.go("goBackUrl");
}
function updateTemplet(){
	var records = worktop.grid.selectModel.getSelectRows();
	if(records.length == 0){
		MessageBox.alert('提示', '请选中一条记录');
	}else if(records.length == 1){
		Widget.openContent("goUpdateWorkflowTemplet.do?method=goUpdateTemplet&templetId="+records[0].data.templateId,function(){
			worktop.grid.store.load({
				params: {start:0, limit: worktop.grid.page.limit}
			});
		});
	}
}
function deleteTemplet(){
	var records = worktop.grid.selectModel.getSelectRows();
	if(records.length == 0){
		MessageBox.alert('提示', '请选中一条记录');
	}else if(records.length == 1){
		MessageBox.yes('提示','请确认是否删除?', function(){
			$.get("deleteWorkflowTemplet.do?method=deleteTemplet&templetId="+records[0].data.templateId,function(data){
						worktop.grid.store.load({
							params: {start:0, limit: worktop.grid.page.limit}
						});
			},'json')
		})
	}
}
function addTemplet(){
	var records = worktop.grid.selectModel.getSelectRows();
	var templateId = '';
	if(records.length != 0){
		templateId = records[0].data.templateId;
		}
	Widget.openContent("goInsertWorkflowTemplet.do?method=goInsertTemplet&templateId="+templateId,function(){
		worktop.grid.store.load({
			params: {start:0, limit: worktop.grid.page.limit}
		});
	});
}
function goFlowProcedure(){
	Widget.openContent("goFlowProcedureMainPage.do?method=goFlowProcedureMainPage");
}
</script>
</html>