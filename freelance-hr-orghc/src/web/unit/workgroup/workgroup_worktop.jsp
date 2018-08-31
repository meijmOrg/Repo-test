<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<%@ page import="com.yh.hr.res.dictionary.DicConstants"%>
<%@ page import="com.yh.platform.core.constant.Constant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0" />
<title>科室管理右侧工作台</title>
<%@ include file="/include/js_css_base_include.jsp"%>
<link href="hspszhphtml/css/components/handle_btn.css" rel="stylesheet"
	type="text/css" />
<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="hrcomponent/orgselectjs/selectOrgWorktop.js"></script>
<script type="text/javascript" src="js/comm/dictionary.js"></script>
<script type="text/javascript" src="hrworktop/flow/selectUnit.js"></script>
<script type="text/javascript">
	var orgOid = "${orgOid}";
	var unitOid = "${unitOid}";
	var worktop = null;
	$(document).ready(function() {
		var pageNo = '${param.pageNo}' == '' ? 1 : '${param.pageNo}';
		var limit = '${param.limit}' == '' ? 30 : '${param.limit}';
		worktop = new Worktop([
				{
					xtype : 'Xtable',
					xname : 'grid',
					url : 'listWorkGroup.do?method=listWorkGroup&orgOid=' + orgOid,
					lengthMenu : [ 30, 50, 100 ],
					start : pageNo,
					iPageLength : limit,
					paginationType : 'input',
					el : '#verPersonId',
					rowNumber : true,
					/* checkbox : true, */
					singleCheck : true,
					columns : [ {
						header : '小组名称',
						field : 'wpName',
						width : 80
					}, {
						header : '科室',
						field : 'wpDepName',
						width : 80
					} ,{
						header : '小组描述',
						field : 'wpDescription',
						width : 80
					}, {
						header : '创建人',
						field : 'wpCreateUser',
						width : 80
					}]
				}, {
					xtype : 'QueryForm',//属性对应的构造函数
					xname : 'form',//属性名
					el : '#fr_wsid'
				}, {
					xtype: 'Toolbar',//属性对应的构造函数
          xname: 'tbar',
          tbar: '#handel-button',
          fbar: '#fr_fbar',
          buttons: {
        	  'add': function() {
                  Widget.openContent('goCreateWorkGroup.do?method=goCreateWorkGroup&orgOid='+ orgOid+"&unitOid="+unitOid);
              },
              'revoke-one': function(grid,record,worktop) {
                  var selectRow = [record];
                 
                  if (selectRow[0].data.wpId) {
                    MessageBox.yes('提示', '请确认是否删除记录？', function() {
                      $.post("deleteWorkGroup.do?method=deleteWorkGroup", {
                    	  wpId : selectRow[0].data.wpId
                      }, function(data) {
                          debugger;
                        if (data.success) {
                          MessageBox.message('提示', "删除成功!", function() {
                              worktop.form.goQuery();
                          });
                        }
                      }, 'json');
                    });
                  }
                },
              'update': function(grid,record,worktop) {
                var rows = [record];
           	 
           	  var wpId= rows[0].data.wpId;
                 Widget.openContent('goUpdateWorkGroup.do?method=goUpdateWorkGroup&wpId=' + wpId)
              },
              'view': function(grid,record,worktop) {
                var rows = [record];
                if (rows.length == 0) {
                  MessageBox.alert('提示', "请选择一条记录再操作");
                }else if(rows.length>1){
                  MessageBox.alert('提示','您选择了'+rows.length+'条记录,请仅选择一条记录再操作！');
                } else {
                  var orgOid = rows[0].data.orgOid;
                  Widget.openContent('goViewWorkGroup.do?method=goUpdateWorkGroup&wpId=' + wpId ,function(){
                  	worktop.form.goQuery();
                  })
                }
              }
              
            }
  		}
	]);

		$(window).resize(
				function() {
					worktop.grid.wrap.find('.ct').height(
							$(window).height()
									- $('.current-position').outerHeight(true)
									- $(".search-content").outerHeight(true)
									- $("#nav_tab").outerHeight(true)
									- $("#handel-button").outerHeight(true) - 60);//48(分页48)
				}).resize(); 

		worktop.form.goQuery();
	});
		
</script>
</head>
<body style="overflow: hidden;" >
	<!--右边整体-->
	<div id="right" class="personBycp">
 <div class="search-content">
		<div class="search-include mrb-40 clearfix">
			<form id="fr_wsid" action="#" method="post">
				<dl class='search-unit' >
					<dt class="search-unit-dt">小组名称：</dt>
					<dd class="search-unit-dd">
						<label>
							<input type="text" name="wpName" id="wpName" maxlength="100"/>
						</label>
					</dd>
				</dl>
				
				 <dl class="search-unit search-btns">
				 <dt><button class="btn_search">查询</button></dt>
				  </dl>
			</form>
		</div>
		</div>
		<div class='handle-btn-group'>
			<!-- 操作按钮-->
			<div class="handle-btn clearfix" id="handel-button">
				<button class="btn-add btn-left-icon btn-default" button-click="add">新增</button>
			</div>
			<!-- 列表内容展示-->
			<table id="verPersonId" class="x-table sortable ellipsis striped hover personBycp"></table>
		</div>
	</div>
		<!-- 列表内容展示-->
   
		<div id="fr_fbar" style="display:none;" class="handel-float" ><!-- class="handel_float" -->
	    <em></em>
	    <span></span>
	    <button class="btn-modify btn-left-icon btn-default" button-click="update">修改</button>
	   <!--  <button class="btn-look btn-left-icon btn-default" button-click="view">查看</button> -->
          <button class="btn-delete btn-left-icon btn-default" button-click="revoke-one">删除</button>
	  </div>
</body>
