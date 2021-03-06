﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.yh.platform.core.constant.Constant"%>
<%@ page import="com.yh.hr.res.dictionary.DicConstants"%>
<%@ include file="/include/jsp_headers.jsp"%>

<!--
 * @function    JhcPbInjuryInfo信息查看页面
 * @page name   /hrinfo/view/view_ver_jhcPbInjuryInfo_show.jsp
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-14
-->



<!DOCTYPE html>
<html lang="cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工伤信息查看页面</title>
<style type="text/css">
dd {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>

<body>

	<%-- <div id="showmodal" class="modal-content">

    <div class="modal-header">
        <button type="button" class="close close-popdown" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">工伤信息&gt;查看</h4>
    </div>
    
    <form id="viewJhcPbInjuryInfo" action="#" method="post">
    <div class="wrong" style="display:none;"><embed src="img/index/jg.svg" width="20" height="20" top="-5" type="image/svg+xml"/></div>
	<div class="sys_list">
	    <div class="col_float">
			<dl class="data-unit-dl">   
	                	<dt>受伤日期：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="hurtDateStr" />'><bean:write name="pbInjuryInfoForm" property="hurtDateStr" />&nbsp;</label>
				</dd>
			</dl>
	        <dl class="data-unit-dl">   
	                	<dt>认定单位：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="judgeOrgan" />'><bean:write name="pbInjuryInfoForm" property="judgeOrgan" />&nbsp;</label>
				</dd>
			</dl>
	        <dl class="data-unit-dl">   
	                	<dt>创建人名称：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="createName" />'><bean:write name="pbInjuryInfoForm" property="createName" />&nbsp;</label>
				</dd>
			</dl>
	        <dl class="data-unit-dl">   
	                	<dt>修改人名称：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="updateName" />'><bean:write name="pbInjuryInfoForm" property="updateName" />&nbsp;</label>
				</dd>
			</dl>
		</div>		
	    <div class="col_float">
	        <dl class="data-unit-dl">   
	                	<dt>伤残等级：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="hurtLevel" />'><bean:write name="pbInjuryInfoForm" property="hurtLevel" />&nbsp;</label>
				</dd>
			</dl>
	        <dl class="data-unit-dl">   
	                	<dt>备注：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="remark" />'><bean:write name="pbInjuryInfoForm" property="remark" />&nbsp;</label>
				</dd>
			</dl>
			<dl class="data-unit-dl">   
	                	<dt>创建时间：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="createDateStr" />'><bean:write name="pbInjuryInfoForm" property="createDateStr" />&nbsp;</label>
				</dd>
			</dl>
			<dl class="data-unit-dl">   
	                	<dt>修改时间：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="updateDateStr" />'><bean:write name="pbInjuryInfoForm" property="updateDateStr" />&nbsp;</label>
				</dd>
			</dl>
		</div>		
	    <div class="col_float">
	        <dl class="data-unit-dl">   
	                	<dt>认定公函：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="congizanceLetter" />'><bean:write name="pbInjuryInfoForm" property="congizanceLetter" />&nbsp;</label>
				</dd>
			</dl>
	        <dl class="data-unit-dl">   
	                	<dt>创建人ID：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="createBy" />'><bean:write name="pbInjuryInfoForm" property="createBy" />&nbsp;</label>
				</dd>
			</dl>
	        <dl class="data-unit-dl">   
	                	<dt>修改人ID：</dt>
				<dd>
					<label title='<bean:write name="pbInjuryInfoForm" property="updateBy" />'><bean:write name="pbInjuryInfoForm" property="updateBy" />&nbsp;</label>
				</dd>
			</dl>
		</div>		
    </div>
    <div style="clear: both"></div>
    </form>
    
    <div class="modal-footer">
        <button type="button" class="btn btn-primary close-popdown">返　回</button>
   	</div>
   	
</div> --%>
	<form id="pbResumeInfoForm" action="#" method="post">
		<div id="transaction_modal_box" class="transaction_modal_box">
			<div class="modal-dialog-container">
				<div class="md-title">
					工伤信息&gt;查看 <a href="#" class="md-close close-popdown"></a>
				</div>
				<div class="md-main-content">
					<div class="md-units md-three-column clearfix">
						<dl class="data-unit-dl">
							<dt>受伤日期：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="hurtDateStr" />'><bean:write name="pbInjuryInfoForm" property="hurtDateStr" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl">
							<dt>伤残等级：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="hurtLevel" />'><bean:write name="pbInjuryInfoForm" property="hurtLevel" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl">
							<dt>认定公函：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="congizanceLetter" />'><bean:write name="pbInjuryInfoForm" property="congizanceLetter" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl">
							<dt>认定单位：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="judgeOrgan" />'><bean:write name="pbInjuryInfoForm" property="judgeOrgan" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl updown-remark">
							<dt>备注：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="remark" />'><bean:write name="pbInjuryInfoForm" property="remark" />&nbsp;</label>
							</dd>
						</dl>
						<%-- <dl class="data-unit-dl">
							<dt>创建人名称：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="createName" />'><bean:write name="pbInjuryInfoForm" property="createName" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl">
							<dt>创建时间：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="createDateStr" />'><bean:write name="pbInjuryInfoForm" property="createDateStr" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl">
							<dt>创建人ID：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="createBy" />'><bean:write name="pbInjuryInfoForm" property="createBy" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl">
							<dt>修改人名称：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="updateName" />'><bean:write name="pbInjuryInfoForm" property="updateName" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl">
							<dt>修改时间：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="updateDateStr" />'><bean:write name="pbInjuryInfoForm" property="updateDateStr" />&nbsp;</label>
							</dd>
						</dl>
						<dl class="data-unit-dl">
							<dt>修改人ID：</dt>
							<dd>
								<label title='<bean:write name="pbInjuryInfoForm" property="updateBy" />'><bean:write name="pbInjuryInfoForm" property="updateBy" />&nbsp;</label>
							</dd>
						</dl> --%>
					</div>
				</div>
				<div class="md-btn">
					<button type="button" class="md-btn-cancel close-popdown" data-dismiss="modal" button-click="widget-close">关 闭</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>