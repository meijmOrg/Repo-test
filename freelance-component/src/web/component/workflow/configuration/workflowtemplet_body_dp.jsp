<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.yh.component.workflow.utils.WorkFlowConfigurationUtil"%>
<%@taglib uri="dictionary.tld" prefix="dictionary" %>
<%@taglib uri="c.tld" prefix="c"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.lang.*"%>
<!--
 * @function    模板信息body页面
 * @page name   workflowTemplet_body_dp.jsp
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
$(function(){
	debugger
	//遍历form 根据字段类别和字段状态 显示or隐藏div
	if('${workflowConfigurationForm.dpList}'!='[]'){
		$.each($.parseJSON('${workflowConfigurationForm.dpList}'),function(i,json){
			console.log(json.dpName);
			if(json.dpState == '1'){
				$("#"+json.dpName).css('display','block'); 
				$("#"+json.dpName+" dt").html(json.dpDescription+"："); 
				}else if(json.dpState == '2'){
					$("#"+json.dpName).css('display','none'); 
					}
			});
		}
});
</script>
</head>

<body>
		<input type="hidden" name="templateId" value="${workflowConfigurationForm.templateId }"/>
		<div class="modal-row01">
			<dl>
	            <dt><b class="Required">* </b>模板名称：</dt>
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
		<div class="modal-row01">
			<dl>
				<dt><b class="Required">* </b>模板分类：</dt>
				<dd>
					<label><dictionary:dicItemSelect id="templateType" name="templateType" styleClass="modal_select" emptyText="<%=WorkFlowConfigurationUtil.EMPTY_SELECT %>" selected="${workflowConfigurationForm.templateType}" dicTypeCode="<%=WorkFlowConfigurationUtil.YHRS4003%>" />
						 </label>
				</dd>
			</dl>
		</div>
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
		<div class="modal-row01" id="bak_1">
			<dl>
				<dt></dt>
				<dd>
					<label><input type="text" id="bak1" name="bak1" class="modal_iput" value="${workflowConfigurationForm.bak1}" maxlength="300" /></label>
				</dd>
			</dl>
		</div>
</body>
</html>