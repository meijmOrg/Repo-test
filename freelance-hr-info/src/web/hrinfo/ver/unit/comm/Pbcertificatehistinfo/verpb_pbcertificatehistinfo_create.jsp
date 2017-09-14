﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.yh.platform.core.constant.Constant"%>
<%@ page import="com.yh.hr.res.dictionary.DicConstants"%>
<%@ include file="/include/jsp_headers.jsp"%>

<!--
 * @function    PbCertificateHistInfo新增页面
 * @page name   /hrinfo/ver/verPb_PbCertificateHistInfo_create.jsp
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-14
-->






<!DOCTYPE html>
<html lang="cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>执业注册历史信息新增页面</title>
    <script type="text/javascript" src="hrinfo/ver/unit/comm/Pbcertificatehistinfo/check_pbCertificateHistInfo_info.js"></script>
	<script type="text/javascript" src="js/comm/customJs.js"></script>
</head>

<body>
<form id="CertificateHistInfoForm" class="form-inline" action="createPbCertificateHistInfo.do?method=create" method="post" onsubmit="return false">
  <div id="transaction_modal_box" class="transaction_modal_box">
    <div class="modal-dialog-container">
        <div class="md-title">执业注册历史信息&gt;新增<a href="#" class="md-close close-popdown"></a></div>
        <div class="md-error" style="display: none">
	        <p>以下信息有误,请重新输入</p>
	      </div>
        <div class="md-main-content">
          <input type="hidden" id="personOid" name="personOid" value="${personOid}" />
          <input type="hidden" id="url_id" value="${urlId}" />
          <div class="md-units md-three-column clearfix">
            <dl class="updown-dl">   
              <dt>注册类型：</dt>
              <dd>
	              <label>
	                <dictionary:dicItemSelect name="certificateType" styleClass="modal_select"
	                  dicTypeCode="<%=DicConstants.YHRS0118%>" emptyText="--请选择--" />
	              </label>
              </dd>
            </dl>
            <dl class="updown-dl">   
              <dt>注册日期：</dt>
							<dd>
							  <label><input type="text" name="certificateBeginDateStr" class="modal_iput"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" /></label>
							</dd>
            </dl>
            <dl class="updown-dl">   
              <dt>注册有效截止日期：</dt>
							<dd>
							  <label><input type="text" name="certificateEndDateStr" class="modal_iput"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" /></label>
							</dd>
            </dl>
            <div class="clear"></div>
          </div>
        </div>
    </div>
    <div class="md-btn">
      <button id="saveCertificateHistInfo" type="button" class="md-btn-save">保  存</button>
      <button type="button" class="md-btn-cancel close-popdown" data-dismiss="modal">取 消</button>
    </div>
  </div>
</form>
</body>
</html>