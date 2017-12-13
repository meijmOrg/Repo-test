<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0"/>
<title>客户列表</title>
<%@ include file="/include/js_css_admin_include.jsp"%>
<script type="text/javascript">
var worktop = null;
$(document).ready(function(){
	worktop = new Worktop([
		{
			xtype:'Xtable',
			xname:'grid',
			url: 'listCustomerInfo.do?method=listCustomerInfo',
			rowNumber: true,
// 			checkbox: true,
// 			singleCheck: false,
			columns: [
				{header:'License码', field:'licenseCode', width:100},
				{header:'客户简称', field:'customerName', width:80},
				{header:'单位地址', field:'address', width:80},
				{header:'单位电话', field:'phone', width:80},
				{header:'单位负责人', field:'contacter', width:80},
				{header:'联系电话', field:'contactType', width:80},
				{header:'启动状态', field:'startStatus', width:80},
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
			tbar: '#fr_tbar',
			fbar: '#fr_fbar',
			buttons: {
				'add': function(){
					 Widget.openContent("goCustomerCreate.do?method=goCustomerCreate",
							function(){
							worktop.form.goQuery();
						    }); 
				},
				'update': function(grid,record,worktop){
					 Widget.openContent("goCustomerUpdate.do?method=goCustomerUpdate&customerOid="+record.data.customerOid,
							function(){
							worktop.form.goQuery();
						    }); 
				}
			} 
		}    
	]);
	
	$(window).resize(function(){
		worktop.grid.wrap.find('.ct').height(
			$(window).height() 
			- $('.sitemap').outerHeight(true)
			- worktop.form.el.parent().outerHeight(true) //form 没有高度
			- (worktop.tbar.ct ? worktop.tbar.ct.outerHeight(true) : 0)
			- 48
			);//48(分页48)
	}).resize();
	worktop.form.goQuery();
});
</script>
</head>
<body style="overflow-x: hidden;">
<div>
	<div class="sitemap" style="padding-bottom: 10px;">
		<ul>
			<li>当前位置：</li>
			<li>系统管理<span class="spanColor"> > </span></li>
			<li>项目初始化<span class="spanColor"></span></li>
		</ul>
		<div style="clear: both"></div>
	</div>
	<div class="search search-horizontal-small">
		<form id="fr_wsid" action="#" method="post">
			<dl class="search-horizontal">
	            <dt>客户简称：</dt>
	            <dd><label><input type="text" name="customerName" value="${param.customerName}"/></label></dd>
	        </dl>
			<button style="float: left" class="btn_search" button-click="query">查询</button>
		</form>
		<div style="clear: both"></div>
	</div>
	<!-- 操作按钮 -->
	<div class="handel" id="fr_tbar">
		<button class="btn_add" button-click="add">启动配置</button>
	</div>
	<!-- 列表内容展示-->
	<table class="x-table sortable ellipsis striped hover"></table>
	<!--浮动操作列表-->
	<div id="fr_fbar" style="display: none;" class="handel_float">
		<em></em><span></span>
		<button class="btn_add" button-click="update">修改配置</button>
	</div>
</div>
</body>
