<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.yh.platform.core.constant.Constant"%>
<%@ page import="com.yh.component.workflow.utils.WorkFlowConfigurationUtil"%>
<%-- <%@ include file="/include/jsp_headers.jsp"%>
 --%>
<!--
 * @function    模板信息body页面
 * @page name   workflowTemplet_body.jsp
 * @author      liul
 * @created     2017/11/29
 * @version     1.0
-->
<!DOCTYPE html>
<html lang="cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="/include/js_css_base_include.jsp"%>
    <script type="text/javascript" src="component/workflow/configuration/js/CheckWorkflowTemplet.js"></script>
<title>模板信息页面</title>
</head>

<body>
		<div class="modal-row01">
			<dl>
	            <dt><b class="Required">* </b>模板名称</dt>
	            <dd>
					<label><input type="text" name="templetName" class="modal_iput" id="templetName" value="${workflowConfigurationForm.templetName }" maxlength="100"/> </label>
	            </dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>模板编码：</dt>
				<dd>
					<label><input type="text" id="templetCode" name="templetCode" class="modal_iput" value="${workflowConfigurationForm.templetCode}" maxlength="100" /> </label>
				</dd>
			</dl>
		</div>
		<%-- <dl>
			<dt><b class="Required">* </b>模板分类：</dt>
			<dd>
				<label><dictionary:dicItemSelect id="templetType" name="templetType" styleClass="modal_select" emptyText="<%=WorkFlowConfigurationUtil.EMPTY_SELECT %>" selected="${workflowConfigurationForm.templetType}" dicTypeCode="<%=WorkFlowConfigurationUtil.%>" /> </label>
			</dd>
		</dl> --%>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>流程处理页面：</dt>
				<dd>
					<label><input type="text" id="flowProcessPage" name="flowProcessPage" class="modal_iput" value="${workflowConfigurationForm.flowProcessPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>协同处理页面：</dt>
				<dd>
					<label><input type="text" id="synergyProcessPage" name="synergyProcessPage" class="modal_iput" value="${workflowConfigurationForm.synergyProcessPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>文档编辑页面：</dt>
				<dd>
					<label><input type="text" id="documentEditPage" name="documentEditPage" class="modal_iput" value="${workflowConfigurationForm.documentEditPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>文档详细页面：</dt>
				<dd>
					<label><input type="text" id="documentDetailPage" name="documentDetailPage" class="modal_iput" value="${workflowConfigurationForm.documentDetailPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>文档打印页面：</dt>
				<dd>
					<label><input type="text" id="documentPrintPage" name="documentPrintPage" class="modal_iput" value="${workflowConfigurationForm.documentPrintPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
</body>
</html>