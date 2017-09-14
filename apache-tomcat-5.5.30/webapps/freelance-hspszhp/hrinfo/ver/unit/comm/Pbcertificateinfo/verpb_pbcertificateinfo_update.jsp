﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.yh.platform.core.constant.Constant"%>
<%@ page import="com.yh.hr.res.dictionary.DicConstants"%>
<%@ include file="/include/jsp_headers.jsp"%>

<!--
 * @function    PbCertificateInfo修改页面
 * @page name   /hrinfo/ver/unit/comm/pbCertificateInfo/verpb_pbCertificateInfo_update.jsp
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-14
-->




<!DOCTYPE html>
<html lang="cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PbCertificateInfo修改页面</title>
<script type="text/javascript"
	src="hrinfo/ver/unit/comm/Pbcertificateinfo/check_pbCertificateInfo_info.js"></script>
<script type="text/javascript" src="js/comm/customJs.js"></script>
</head>
<script>
$(function() {
	if('${pbCertificateInfoForm.cancelFlag}'==1) {
		$('#cancleDateStr-wrapper').show();
	}else if('${pbCertificateInfoForm.cancelFlag}'==0) {
		$('#cancleDateStr-wrapper').hide();
	}
	//var cancleDateStr = $('#cancelDateStr').val();
	$('#cancelFlag').change(function() {
		if($(this).val()==1) {
			//$('#cancelDateStr').val(cancleDateStr);
			$('#cancelDateStr').val('');
			$('#cancleDateStr-wrapper').show();
		}else {
			//cancleDateStr = $('#cancelDateStr').val();
			$('#cancelDateStr').val('');
			$('#cancleDateStr-wrapper').hide();
		}
	});
});
</script>
<body>
<form id="CertificateInfoForm" class="form-inline" action="updatePbCertificateInfo.do?method=update" method="post" onsubmit="return false">
  <div id="transaction_modal_box" class="transaction_modal_box">
    <div class="modal-dialog-container">
      <div class="md-title">执业注册信息&gt;修改<a href="#" class="md-close close-popdown"></a></div>
      <div class="md-error" style="display: none">
        <p>以下信息有误,请重新输入</p>
      </div>
      <div class="md-main-content">
				<input type="hidden" id="certificateOid" name="certificateOid" value="${pbCertificateInfoForm.certificateOid}" />
			  <input type="hidden" id="personOid" name="personOid" value="${pbCertificateInfoForm.personOid}" />
			  <input type="hidden" id="url_id" value="${urlId}" />
        <div class="md-units md-three-column clearfix">
					<dl class="updown-dl">
						<dt>
							<b class="Required">* </b>执业注册证书编号：
						</dt>
						<dd>
							<label><input type="textarea" id="certificateNo"
								name="certificateNo" class="modal_iput"
								value="${pbCertificateInfoForm.certificateNo}" maxlength="50" />
							</label>
						</dd>
					</dl>
					<dl class="updown-dl">
						<dt>发证机构：</dt>
						<dd>
							<label><input type="textarea" id="approveOrganName"
								name="approveOrganName" class="modal_iput"
								value="${pbCertificateInfoForm.approveOrganName}"
								maxlength="100" />
							</label>
						</dd>
					</dl>
					<dl class="updown-dl">
						<dt>审批日期：</dt>
						<dd>
							<label><input type="text" id="approvedDateStr"
								name="approvedDateStr" class="modal_iput"
								value="${pbCertificateInfoForm.approvedDateStr}" readonly="true"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
							</label>
						</dd>
					</dl>
					<dl class="updown-dl">
						<dt>签发日期：</dt>
						<dd>
							<label><input type="text" id="issuedDateStr"
								name="issuedDateStr" class="modal_iput"
								value="${pbCertificateInfoForm.issuedDateStr}" readonly="true"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
							</label>
						</dd>
					</dl>
					<dl class="updown-dl">
						<dt>执业范围：</dt>
						<dd>
							<label><input type="text" id="scopeCode" name="scopeCode"
								class="modal_iput" value="${pbCertificateInfoForm.scopeCode}"
								maxlength="20" />
							</label>
						</dd>
					</dl>
					<dl class="updown-dl">
						<dt>执业地点：</dt>
						<dd>
							<label><input type="textarea" id="certificateUnit"
								name="certificateUnit" class="modal_iput"
								value="${pbCertificateInfoForm.certificateUnit}" maxlength="100" />
							</label>
						</dd>
					</dl>
					<dl class="updown-dl">
						<dt>注册日期：</dt>
						<dd>
							<label><input type="text" id="certificateBeginDateStr"
								name="certificateBeginDateStr" class="modal_iput"
								value="${pbCertificateInfoForm.certificateBeginDateStr}"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
							</label>
						</dd>
					</dl>
					<dl class="updown-dl">
						<dt>注册有效截止日期：</dt>
						<dd>
							<label><input type="text" id="certificateEndDateStr"
								name="certificateEndDateStr" class="modal_iput"
								value="${pbCertificateInfoForm.certificateEndDateStr}"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
							</label>
						</dd>
					</dl>
					<dl class="updown-dl">
						<dt>
							<b class="Required">* </b>是否注销：
						</dt>
						<dd>
							<label> <dictionary:dicItemSelect id="cancelFlag"
									name="cancelFlag" styleClass="modal_select"
									selected="${pbCertificateInfoForm.cancelFlag}"
									dicTypeCode="<%=DicConstants.YHRS0003%>" emptyText="--请选择--" />
							</label>
						</dd>
					</dl>
					<dl id="cancleDateStr-wrapper">
						<dt>注销日期：</dt>
						<dd>
							<label><input type="text" id="cancelDateStr"
								name="cancelDateStr" class="modal_iput"
								value="${pbCertificateInfoForm.cancelDateStr}" readonly="true"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
							</label>
						</dd>
					</dl>
					<dl class="updown-remark">
						<dt>备注：</dt>
						<dd style="width: 83%;">
							<label><textarea rows="3" id="remark" name="remark"
									maxlength="1000">${pbCertificateInfoForm.remark}</textarea>
							</label>
						</dd>
					</dl>
          <div class="clear"></div>
          </div>
        </div>
    </div>
    <div class="md-btn">
      <button id="saveCertificateInfo" type="button" class="md-btn-save">保  存</button>
      <button type="button" class="md-btn-cancel close-popdown" data-dismiss="modal">取 消</button>
    </div>
  </div>
</form>
</body>
</html>