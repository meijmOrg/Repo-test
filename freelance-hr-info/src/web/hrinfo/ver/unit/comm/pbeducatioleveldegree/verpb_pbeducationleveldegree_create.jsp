﻿﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.yh.platform.core.constant.Constant"%>
<%@ page import="com.yh.hr.res.dictionary.DicConstants"%>
<%@ include file="/include/jsp_headers.jsp"%>

<!--
 * @function    PbEducationLevelDegree新增页面
 * @page name   /hrinfo/ver/verPb_PbEducationLevelDegree_create.jsp
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-14
-->
<!DOCTYPE html>
<html lang="cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学历学位信息新增页面</title>
<script type="text/javascript" src="hrinfo/ver/unit/comm/pbeducatioleveldegree/js/check_education_info.js"></script>
<script type="text/javascript" src="js/comm/customJs.js"></script>
</head>

<body>
	<form id="educationLevelDegreeForm" class="form-inline" action="createPbEducationLevelDegree.do?method=create" method="post" onsubmit="return false">
		<div id="transaction_modal_box" class="transaction_modal_box">
			<div class="modal-dialog-container">
				<div class="md-title">
					学历学位信息&gt;新增 <a href="#" class="md-close close-popdown"></a>
				</div>
				<div class="md-error" style="display: none">
					<p>以下信息有误,请重新输入</p>
				</div>
				<div class="md-main-content">
					<input type="hidden" id="personOid" name="personOid" value="${personOid}" /> <input type="hidden" id="url_id" value="${urlId}" />

					<div class="md-units md-three-column">
						<dl class="updown-dl">
							<dt>
								<b class="Required">* </b>学校名称：
							</dt>
							<dd>
								<label><input type="text" name="schoolName" class="modal_iput" maxlength="100" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>
								<b class="Required"> </b>所在院系：
							</dt>
							<dd>
								<label><input type="textarea" name="academyName" class="modal_iput" maxlength="50" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>
								<b class="Required">* </b>学习形式：
							</dt>
							<dd>
								<label> <dictionary:dicItemSelect id="studyTypeCode" name="studyTypeCode" styleClass="modal_select" emptyText="<%=Constant.EMPTY_SELECT %>" dicTypeCode="<%=DicConstants.YHRS0042%>" /> </label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>
								<b class="Required"> </b>学制（年）：
							</dt>
							<dd>
								<label><input type="text" name="eductionalSystem" class="modal_iput" maxlength="20" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>
								<b class="Required">* </b>入学日期：
							</dt>
							<dd>
								<label><input type="text" id="schoolEnrollDateStr" name="schoolEnrollDateStr" class="modal_iput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>
								<b class="Required">* </b>毕（肄）业日期：
							</dt>
							<dd>
								<label><input type="text" id="graduateDateStr" name="graduateDateStr" class="modal_iput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>
								<b class="Required">* </b>教育类别：
							</dt>
							<dd>
								<label><dictionary:dicItemSelect id="eduType" name="eduType" styleClass="modal_select" emptyText="<%=Constant.EMPTY_SELECT %>" dicTypeCode="<%=DicConstants.YHRS0043%>" onchange="changeEduType(this.value)" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>
								<b class="Required">* </b>学历：
							</dt>
							<dd>
								<label> <input type="text" id="educationCode" name="educationCodeName" readonly="readonly" class="modal_iput" value='<dictionary:viewDicItemName dicTypeCode="<%=DicConstants.YHRS0039%>" dicItemCode="${pbEducationLevelDegreeForm.educationCode}" />' onclick="min_Dic.min_Dictionary(this,'<%=DicConstants.YHRS0039%>','','','',changeEducationLevel);"> 
								<input type="hidden" id="educationCodeId" name="educationCode" value="${pbEducationLevelDegreeForm.educationCode}" /> 
								<a class="md-unit-clear" onclick="$(this).siblings('input').val('')"></a>
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>
								<b class="Required educationcodevalidate">* </b>所学专业：
							</dt>
							<dd>
								<label><input type="text" id="majorCode" name="majorCode" class="modal_iput" maxlength="20" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>学历证书号码：</dt>
							<dd>
								<label><input type="text" id="educationCertificate" name="educationCertificate" class="modal_iput" maxlength="20" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>学历等级：</dt>
							<dd>
								<label> 
								<input type="text" id="educationLevelName" name="educationLevelName" readonly="readonly" value="${pbEducationLevelDegreeForm.educationLevelName}" class="modal_iput" /> 
								<input type="hidden" id="educationLevel" name="educationLevel" readonly="readonly" value="${pbEducationLevelDegreeForm.educationLevel}" /> 
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt><b class="Required">* </b>学位：</dt>
							<dd>
								<label><dictionary:dicItemSelect id="degreeCode" name="degreeCode" styleClass="modal_select" emptyText="<%=Constant.EMPTY_SELECT %>" dicTypeCode="<%=DicConstants.YHRS0040%>" onchange="changeEducationLevel();" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>学位证书号码：</dt>
							<dd>
								<label><input type="text" id="degreeCertificateCode" name="degreeCertificateCode" class="modal_iput" maxlength="20" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>学位授予日期：</dt>
							<dd>
								<label><input type="text" ID="degreeGrantDateStr" name="degreeGrantDateStr" class="modal_iput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>学位授予单位：</dt>
							<dd>
								<label><input type="textarea" name="degreeGrantUnit" class="modal_iput" maxlength="100" />
								</label>
							</dd>
						</dl>
						<dl class="updown-dl">
							<dt>学位授予国家：</dt>
							<dd>
								<label> <input type="text" id="degreeGrantCountryCode" name="degreeGrantCountryCodeName" readonly="readonly" class="modal_iput" value='<dictionary:viewDicItemName dicTypeCode="<%=DicConstants.YHRS0005%>" dicItemCode="${pbEducationLevelDegreeForm.degreeGrantCountryCode}" />' onclick="min_Dic.min_Dictionary(this,'<%=DicConstants.YHRS0005%>');"> 
								<input type="hidden" id="degreeGrantCountryCodeId" name="degreeGrantCountryCode" value="${pbEducationLevelDegreeForm.degreeGrantCountryCode}" /> 
								<a class="md-unit-clear" onclick="$(this).siblings('input').val('')"></a>
								</label>
							</dd>
						</dl>
						<dl class="updown-remark">
							<dt title="备注">备注：</dt>
							<dd style="width: 83%;">
								<label> <textarea id="remark" name="remark" rows="3" maxlength="1000"></textarea> </label>
							</dd>
						</dl>
					</div>
				</div>
				<div class="md-btn">
					<button id="saveEducationLevelDegree" type="button" class="md-btn-save">保 存</button>
					<button type="button" class="md-btn-cancel close-popdown" data-dismiss="modal">取 消</button>
				</div>
			</div>
		</div>
	</form>



	<%-- <div id="showmodal" class="modal-content">
<form id="educationLevelDegreeForm" class="form-inline" action="createPbEducationLevelDegree.do?method=create" method="post" onsubmit="return false">

    <div class="modal-header">
        <button type="button" class="close close-popdown" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">学历学位信息&gt;新增</h4>
    </div>

	<div class="modal-body">
        	<input type="hidden" id="personOid" name="personOid" value="${personOid}" />
            <input type="hidden" id="url_id" value="${urlId}" />
        	<div class="modal-wrong" style="display: none">
                <ol class="titwrong"><embed src="img/index/jg.svg" width="20" height="20" top="0" type="image/svg+xml" class="ico"/> 以下信息有误，请重新输入！</ol>
                <ol class="wroglist">
                    <logic:messagesPresent>
                        <html:messages id="error">
                            <li><bean:write name="error" /></li>
                        </html:messages>
                    </logic:messagesPresent>
                </ol>
            </div>
        	<div class="modal-row03">   <!--三列 -->
        	<dl>   
                    <dt><b class="Required">* </b>学校名称：</dt>
			<dd>
				<label><input type="text" name="schoolName" class="modal_iput" maxlength="100" /></label>
			</dd>
                 </dl>
        	<dl>   
                    <dt><b class="Required">  </b>所在院系：</dt>
			<dd>
				<label><input type="textarea" name="academyName" class="modal_iput" maxlength="50" /></label>
			</dd>
                 </dl>
                 <dl>   
                    <dt><b class="Required">* </b>学习形式：</dt>
			<dd>
				<label>
					<dictionary:dicItemSelect id="studyTypeCode" name="studyTypeCode" styleClass="modal_select" emptyText="<%=Constant.EMPTY_SELECT %>" dicTypeCode="<%=DicConstants.YHRS0042%>"/>
				</label>
			</dd>
                 </dl>
            </div>
        	<div class="modal-row03">   <!--三列 -->
        	
        	<dl>   
                    <dt><b class="Required">  </b>学制（年）：</dt>
			<dd>
				<label><input type="text" name="eductionalSystem" class="modal_iput" maxlength="20" /></label>
			</dd>
                 </dl>
                 
                 <dl>   
                    <dt><b class="Required">* </b>入学日期：</dt>
			<dd>
				<label><input type="text" id="schoolEnrollDateStr" name="schoolEnrollDateStr" class="modal_iput"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" /></label>
			</dd>
                 </dl>

		<dl>   
                    <dt><b class="Required">* </b>毕（肄）业日期：</dt>
			<dd>
				<label><input type="text" id="graduateDateStr" name="graduateDateStr" class="modal_iput"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" /></label>
			</dd>
                 </dl>
            </div>
            
            
            
        	<div class="modal-row03">   <!--三列 -->
        	<dl>   
                    <dt><b class="Required">* </b>教育类别：</dt>
			<dd>
				<label><dictionary:dicItemSelect id="eduType" name="eduType" styleClass="modal_select" emptyText="<%=Constant.EMPTY_SELECT %>" dicTypeCode="<%=DicConstants.YHRS0043%>" onchange="changeEduType(this.value)"/></label>
			</dd>
                 </dl>
                 <dl>   
                    <dt><b class="Required">  </b>学历：</dt>
			<dd>
				<label>
					<input type="text" id="educationCode" name="educationCodeName" readonly="readonly" class="modal_iput" value='<dictionary:viewDicItemName dicTypeCode="<%=DicConstants.YHRS0039%>" dicItemCode="${pbEducationLevelDegreeForm.educationCode}" />' onclick="min_Dic.min_Dictionary(this,'<%=DicConstants.YHRS0039%>','',changeEducationLevel);" >
					<input type="hidden" id="educationCodeId" name="educationCode" value="${pbEducationLevelDegreeForm.educationCode}"/>
				</label>
			</dd>
                 </dl>
        	<dl>   
                    <dt><b class="Required educationcodevalidate">* </b>所学专业：</dt>
			<dd>
				<label><input type="text" id="majorCode" name="majorCode" class="modal_iput" maxlength="20" /></label>
			</dd>
                 </dl>
            </div>
        	<div class="modal-row03">   <!--三列 -->
        	<dl>   
                    <dt>学历证书号码：</dt>
			<dd>
				<label><input type="text" id="educationCertificate" name="educationCertificate" class="modal_iput" maxlength="20" /></label>
			</dd>
                 </dl>
        	<dl>   
                    <dt>学历等级：</dt>
			<dd>
				<label>
						<input type="text" id="educationLevelName" name="educationLevelName" readonly="readonly" value="${pbEducationLevelDegreeForm.educationLevelName}" class="modal_iput"/>
						<input type="hidden" id="educationLevel" name="educationLevel" readonly="readonly" value="${pbEducationLevelDegreeForm.educationLevel}"/>
				</label>
			</dd>
                 </dl>
        	<dl>   
                    <dt>学位：</dt>
			<dd>
				<label><dictionary:dicItemSelect id="degreeCode" name="degreeCode" styleClass="modal_select" emptyText="<%=Constant.EMPTY_SELECT %>" dicTypeCode="<%=DicConstants.YHRS0040%>" onchange="changeEducationLevel();"/></label>
			</dd>
                 </dl>
                 </div>
        	<div class="modal-row03">   <!--三列 -->
        	<dl>   
                    <dt>学位证书号码：</dt>
			<dd>
				<label><input type="text" id="degreeCertificateCode" name="degreeCertificateCode" class="modal_iput" maxlength="20" /></label>
			</dd>
                 </dl>
                 <dl>   
                    <dt>学位授予日期：</dt>
			<dd>
				<label><input type="text" ID="degreeGrantDateStr" name="degreeGrantDateStr" class="modal_iput"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" /></label>
			</dd>
                 </dl>
            
        	<dl>   
                    <dt>学位授予单位：</dt>
			<dd>
				<label><input type="textarea" name="degreeGrantUnit" class="modal_iput" maxlength="100" /></label>
			</dd>
                 </dl>
                 </div>
        	<div class="modal-row03">   <!--三列 -->
        	<dl>   
                    <dt>学位授予国家：</dt>
			<dd>
				<label>
					<input type="text" id="degreeGrantCountryCode" name="degreeGrantCountryCodeName" readonly="readonly" class="modal_iput" value='<dictionary:viewDicItemName dicTypeCode="<%=DicConstants.YHRS0005%>" dicItemCode="${pbEducationLevelDegreeForm.degreeGrantCountryCode}" />' onclick="min_Dic.min_Dictionary(this,'<%=DicConstants.YHRS0005%>');" >
					<input type="hidden" id="degreeGrantCountryCodeId" name="degreeGrantCountryCode" value="${pbEducationLevelDegreeForm.degreeGrantCountryCode}"/>
				</label>
			</dd>
                 </dl>
                 
            </div>
            <div class="modal-row03">   <!--三列 -->
            	<dl> 
                  <dt title="备注">备注：</dt>
					 <dd style="width:83%;">
						 <label >
						 	<textarea id="remark" name="remark" rows="3"  class="modal_textarea" maxlength="1000"></textarea>
						 </label>                            
					</dd>
			   </dl>
            </div>
    </div>
   
    <div class="modal-footer">
    	<button id="saveEducationLevelDegree" type="button" class="btn btn-primary">保　存</button>
    	<button type="button" class="btn btn-default close-popdown" data-dismiss="modal">取　消</button>
    </div>
    
    <div style="clear: both"></div>
    
</form>
</div> --%>
</body>
</html>