﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.yh.platform.core.constant.Constant"%>
<%@ page import="com.yh.hr.res.dictionary.DicConstants"%>
<%@ include file="/include/jsp_headers.jsp"%>

<!--
 * @function    特殊授权情况新增页面
 * @page name   /hrinfo/ver/verPb_PbSpeciaAuth_create.jsp
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-14
-->






<!DOCTYPE html>
<html lang="cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>特殊授权情况新增页面</title>
    <script type="text/javascript" src="hrinfo/ver/unit/comm/pbspeciaauthinfo/js/check_pbspeciaauth_info.js"></script>
	<script type="text/javascript" src="js/comm/customJs.js"></script>
		<script>
        $(document).ready(function(){
            initAuthType();
        })
    </script>
</head>

<body>

<form id="speciaAuthForm" class="form-inline" action="createPbSpeciaAuth.do?method=create" method="post" onsubmit="return false">
<div id="transaction_modal_box" class="transaction_modal_box">
    <div class="modal-dialog-container">
        <div class="md-title">
            特殊授权情况&gt;新增
            <a href="#" class="md-close close-popdown"></a>
        </div>
        <div class="md-error" style="display: none">
	        <p>以下信息有误,请重新输入</p>
	      </div>
        <div class="md-main-content">
	    <input type="hidden" id="personOid" name="personOid" value="${personOid}" />
            <input type="hidden" id="url_id" value="${urlId}" />
        	<div class="md-units md-three-column clearfix"> 
        	<dl class="updown-dl">   
                    <dt><b class="Required">* </b>权限类型：</dt>
			<dd>
				<!-- <label><input type="text" name="authType" class="modal_iput" maxlength="100" /></label> -->
				<label><dictionary:dicItemSelect name="authType" styleClass="modal_select" onchange="changeAuthType(this.value);" selected="${pbSpeciaAuthForm.authType}" emptyText="<%=Constant.EMPTY_SELECT %>" dicTypeCode="<%=DicConstants.YHRS0120%>"/></label>
			</dd>
                 </dl>
        	<dl class="updown-dl">   
                    <dt><b class="Required">* </b>授权级别：</dt>
			<dd>
			<label>
				<input type="text" class="modal_iput" name="authLevelName" readonly="readonly"  id="authLevel" value='<dictionary:viewDicItemName dicTypeCode="<%=DicConstants.YHRS0119%>" dicItemCode="${pbSpeciaAuthForm.authLevel}" />' onclick="min_Dic.min_Dictionary(this,'<%=DicConstants.YHRS0119%>','','',null,null,['bottom','left'],true)" />
				<html:hidden name="pbSpeciaAuthForm" property="authLevel" />
				<a class="md-unit-clear" onclick="$(this).siblings('input').val('')"></a>
				<!-- <label><input type="text" name="authLevel" class="modal_iput" maxlength="100" /></label> -->
				<%--  <label><dictionary:dicItemSelect id="authLevel" name="authLevel" styleClass="modal_select" selected="${pbSpeciaAuthForm.authLevel}" emptyText="<%=Constant.EMPTY_SELECT %>" include='<dictionary:viewDicItemName  dicTypeCode="<%=DicConstants.YHRS0119%>"/>' dicTypeCode="<%=DicConstants.YHRS0119%>"/></label> --%>
				</label>
			</dd>
                 </dl>
        	<dl class="updown-dl">   
                    <dt><b class="Required">* </b>授权状态：</dt>
			<dd>
				<!-- <label><input type="text" name="authStatus" class="modal_iput" maxlength="100" /></label> -->
				<label><dictionary:dicItemSelect name="authStatus" styleClass="modal_select" selected="${pbSpeciaAuthForm.authStatus}" emptyText="<%=Constant.EMPTY_SELECT %>" dicTypeCode="<%=DicConstants.YHRS0121%>"/></label>
			</dd>
                 </dl>
		        <dl class="updown-dl">   
		            <dt><b class="Required">* </b>授权时间：</dt>
					<dd>
						<label><input type="text" id="authDateStr" name="authDateStr" class="modal_iput" maxlength="100" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" /></label>
					</dd>
                 </dl>
        	<dl class="updown-dl">   
                    <dt>取消授权时间：</dt>
			<dd>
				<label><input type="text" id="cancelAuthDateStr" name="cancelAuthDateStr" class="modal_iput" maxlength="100" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" /></label>
			</dd>
                 </dl>
		<dl class="updown-remark">
                    <dt>备注：</dt>
			<dd>
				<label><textarea name="remark" maxlength="1000"></textarea></label>
			</dd>
                 </dl>

    </div>
     </div>
   </div>
   <div class="modal-footer">
      <button id="saveSpeciaAuth" type="button" class="btn btn-primary">保　存</button>
      <button type="button" class="btn btn-default close-popdown" data-dismiss="modal">取　消</button>
    </div>
    </div>
    
</form>
</body>
</html>