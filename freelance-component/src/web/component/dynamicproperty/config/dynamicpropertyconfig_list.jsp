<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<%@page import="com.yh.component.dynamicproperty.util.DynamicPropertyUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0"/>
<title>字段列表</title>
<%-- <%@ include file="/include/js_css_admin_include.jsp"%> --%>
<%@ include file="/include/js_css_base_include.jsp"%>
<script type="text/javascript">
$(function() {
    var dpCode = $("#dpCode").find("option:selected")[0].value;
    goToDynamicProperty(dpCode);
});
function changeDpCode(obj){
    goToDynamicProperty(obj.value);
}
var worktop_dynamic = null;
function goToDynamicProperty(dpCode){

	worktop_dynamic = new Worktop([
		{
			xtype:'Xtable',
			xname:'grid',
			url: 'getPropertyList.do?method=getDynamicPropertyList&config=Y&dpCode='+dpCode,
			rowNumber: true,
			start : '${param.pageNo}'==''?1:'${param.pageNo}',
			iPageLength: '${param.limit}'==''?30:'${param.limit}',
			columns: [
				{header:'操作', css:'operation', type: 'html', width:50, render: 
					function(v,r){
						var dpId=r.data.dpId;
						var dpState=r.data.dpStateCode;
						if(dpState=='1'){
							return $.format("<a  onclick=doDpAvailiable('"+dpId+"','"+dpState+"') style=color:green>停用</a>", r.data);
							}else{
								return $.format("<a  onclick=doDpAvailiable('"+dpId+"','"+dpState+"') style=color:green>启用</a>", r.data);
								}
						
						
					}
				},
				{header:'字段名称', field:'dpName', width:80},
				{header:'字段类型', field:'dpType', width:80},
				{header:'字段含义', field:'dpDescription',render:function(v,r){
						var	dpId = r.data.dpId;
						var dpDescription = r.data.dpDescription;
						return $.format("<a  onclick=updateDescription('"+dpId+"','"+dpDescription+"')  style=color:green>{0}</a>",v);
					},width:80},
				{header:'字段类别', field:'dpCategory', width:80},
				{header:'字段状态', field:'dpState', width:80},
				{header:'字段编码', field:'dpCodeName', width:80}
			]
		},
		{
			xtype: 'QueryForm',//属性对应的构造函数
			xname: 'dynamicForm',//属性名
			el:'#fr_wsid'
		}
	]);
	
	$(window).resize(function(){
		worktop_dynamic.grid.wrap.find('.ct').height(
			$(window).height() 
			- $('.sitemap').outerHeight(true)
			- worktop_dynamic.dynamicForm.el.parent().outerHeight(true) //form 没有高度
			- 48
			);//48(分页48)
	}).resize();
     worktop_dynamic.dynamicForm.goQuery();
}

function doDpAvailiable(dpId,dpState){
	var params = {};
	params.dpId = dpId;
	params.status = dpState;
	if(dpId){
		//MessageBox.yes('提示','请确认是否删除?', function(){
			$.ajax({   										 
				url : 'doDynamicPropertyAvailable.do?method=doDynamicPropertyAvailable',
				data : params,
				dataType : 'json',
				type:'POST',
				error : function(){
					MessageBox.alert('提示',"操作失败，请重新操作！");
				},
				success : function(data) {
					if(data.success==true){
						worktop_dynamic.dynamicForm.goQuery();
					}else{
						MessageBox.alert("提示","操作失敗,请重新操作！");
					}
				}
			});
		//})
		
	}
}
function updateDescription(dpId,dpDescription){
	debugger
		 Widget.openContent("goUpdateDpDescription.do?method=goUpdateDpDescription&dpId="+dpId+"&dpDescription="+dpDescription,
				function(){
			 		worktop_dynamic.dynamicForm.goQuery();
			    }); 
}
</script>
</head>
<body style="overflow-x: hidden;">
<div>
	<div class="sitemap" style="padding-bottom: 10px;">
		<ul>
			<li>当前位置：</li>
			<li>基础信息管理<span class="spanColor"> > </span></li>
			<li>信息管理<span class="spanColor"> > </span></li>
			<li>功能字段配置</li>
		</ul>
		<div style="clear: both"></div>
	</div>
	<div class="search">
	<form id="fr_wsid" action="#" method="post">
	<dl class='search-horizontal' style='margin-right:10%'>
				<dt>动态管理编码：</dt>
				 <dd>
				 	<label>
				 		<dictionary:dicItemSelect dicTypeCode="<%=DynamicPropertyUtil.YHRS3003 %>"  id="dpCode" name="dpCode" onchange="changeDpCode(this)" />
				 	</label>
				 </dd>
			</dl>
						</form>
						<div style="clear: both"></div>
						</div>
	<!-- 列表内容展示-->
	<table class="x-table sortable ellipsis striped hover"></table>
</div>
</body>
