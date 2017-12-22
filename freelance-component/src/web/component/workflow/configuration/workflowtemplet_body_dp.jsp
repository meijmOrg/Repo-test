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
<script type="text/javascript">
</script>
</head>

<body>
		<input type="hidden" name="templateId" value="${workflowConfigurationForm.templateId }"/>
		<div class="modal-row01">
			<dl>
	            <dt><b class="Required">* </b>模板名称</dt>
	            <dd>
					<label><input type="text" name="templateName" class="modal_iput" id="templateName" value="${workflowConfigurationForm.templateName }" maxlength="100"/> </label>
	            </dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>模板编码：</dt>
				<dd>
					<label><input type="text" id="templateCode" name="templateCode" class="modal_iput" value="${workflowConfigurationForm.templateCode}" maxlength="100" /> </label>
				</dd>
			</dl>
		</div>
		<%-- <dl>
			<dt><b class="Required">* </b>模板分类：</dt>
			<dd>
				<label><dictionary:dicItemSelect id="templateType" name="templateType" styleClass="modal_select" emptyText="<%=WorkFlowConfigurationUtil.EMPTY_SELECT %>" selected="${workflowConfigurationForm.templateType}" dicTypeCode="<%=WorkFlowConfigurationUtil.%>" /> </label>
			</dd>
		</dl> --%>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>新增页面：</dt>
				<dd>
					<label><input type="text" id="templateCreatePage" name="templateCreatePage" class="modal_iput" value="${workflowConfigurationForm.templateCreatePage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>编辑页面：</dt>
				<dd>
					<label><input type="text" id="templateEditPage" name="templateEditPage" class="modal_iput" value="${workflowConfigurationForm.templateEditPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>详细页面：</dt>
				<dd>
					<label><input type="text" id="templateInfoPage" name="templateInfoPage" class="modal_iput" value="${workflowConfigurationForm.templateInfoPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>流程页面：</dt>
				<dd>
					<label><input type="text" id="templateFlowPage" name="templateFlowPage" class="modal_iput" value="${workflowConfigurationForm.templateFlowPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>报表页面：</dt>
				<dd>
					<label><input type="text" id="templateReportPage" name="templateReportPage" class="modal_iput" value="${workflowConfigurationForm.templateReportPage}" maxlength="100" />格式:/Controller/Action  </label>
				</dd>
			</dl>
		</div>
</body>
</html>