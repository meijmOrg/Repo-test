package com.yh.component.workflow.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板管理DTO
 * @author liul
 *@createDate 2017-11-16
 */
public class WorkflowConfigurationDTO {

	private java.lang.String  	templateId;	//主键
	private java.lang.String	templateName;	//模板名称	
	private java.lang.String  	templateCode;	//编码
	private java.lang.String 	templateIsUniversal;//是否通用模板
	private java.lang.String	templateType;	//模板类别
	private java.lang.String	templateCreatePage;	//创建页面
	private java.lang.String  	templateEditPage;	//编辑页面
	private java.lang.String 	templateInfoPage;//详细页面
	private java.lang.String    templateFlowPage;//流程页面
	private java.lang.String    templateReportPage;//报表页面
	private java.util.Date		templateCreateDate;//创建时间
	private java.lang.String    templateCreateUserName;//创建人
	private java.util.Date		templateModifyDate;//最新修改时间
	private java.lang.String    templateModifyUserName;//最近修改人
	private java.lang.String    templateDescription;//模板描述
	private java.lang.String bak1;//扩展字段
	
	private java.lang.String  	flowId;	//主键
	private java.lang.String	flowName;	//流程名称	
	private java.lang.String	flowType;	//流程类型：专属流程和通用流程
	private java.lang.Long 		flowOrgOid;//流程所属部门，若是通用流程，则保存0，若是专属流程保存部门ID
	private java.lang.String    flowOrgName;//所属部门名称
	private java.lang.String    flowCreateUserName;// 流程创建人
	private java.lang.String    flowCreateUserID;// 流程创建人ID
	private java.util.Date    	flowCreateDate;//  流程创建时间
	private java.lang.String    flowModifyUserName;// 流程最近修改人姓名
	private java.lang.String    flowModifyUserID;// 流程最近修改人 ID
	private java.util.Date    	flowModifyDate;// 流程最近修改时间
	
	private java.lang.Long 		tfForbidden;//停用Or启用，默认启用，用于后期扩展
	private List<WorkflowBaseInfoDTO> baseInfoList = new ArrayList<WorkflowBaseInfoDTO>();
	private List<WorkflowActivityDTO> activityList = new ArrayList<WorkflowActivityDTO>();
	private List<WorkflowRuleDTO> ruleList = new ArrayList<WorkflowRuleDTO>();
	public java.lang.String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(java.lang.String templateId) {
		this.templateId = templateId;
	}
	public java.lang.String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(java.lang.String templateName) {
		this.templateName = templateName;
	}
	public java.lang.String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(java.lang.String templateCode) {
		this.templateCode = templateCode;
	}
	public java.lang.String getTemplateIsUniversal() {
		return templateIsUniversal;
	}
	public void setTemplateIsUniversal(java.lang.String templateIsUniversal) {
		this.templateIsUniversal = templateIsUniversal;
	}
	public java.lang.String getTemplateType() {
		return templateType;
	}
	public void setTemplateType(java.lang.String templateType) {
		this.templateType = templateType;
	}
	public java.lang.String getTemplateCreatePage() {
		return templateCreatePage;
	}
	public void setTemplateCreatePage(java.lang.String templateCreatePage) {
		this.templateCreatePage = templateCreatePage;
	}
	public java.lang.String getTemplateEditPage() {
		return templateEditPage;
	}
	public void setTemplateEditPage(java.lang.String templateEditPage) {
		this.templateEditPage = templateEditPage;
	}
	public java.lang.String getTemplateInfoPage() {
		return templateInfoPage;
	}
	public void setTemplateInfoPage(java.lang.String templateInfoPage) {
		this.templateInfoPage = templateInfoPage;
	}
	public java.lang.String getTemplateFlowPage() {
		return templateFlowPage;
	}
	public void setTemplateFlowPage(java.lang.String templateFlowPage) {
		this.templateFlowPage = templateFlowPage;
	}
	public java.lang.String getTemplateReportPage() {
		return templateReportPage;
	}
	public void setTemplateReportPage(java.lang.String templateReportPage) {
		this.templateReportPage = templateReportPage;
	}
	public java.util.Date getTemplateCreateDate() {
		return templateCreateDate;
	}
	public void setTemplateCreateDate(java.util.Date templateCreateDate) {
		this.templateCreateDate = templateCreateDate;
	}
	public java.lang.String getTemplateCreateUserName() {
		return templateCreateUserName;
	}
	public void setTemplateCreateUserName(java.lang.String templateCreateUserName) {
		this.templateCreateUserName = templateCreateUserName;
	}
	public java.util.Date getTemplateModifyDate() {
		return templateModifyDate;
	}
	public void setTemplateModifyDate(java.util.Date templateModifyDate) {
		this.templateModifyDate = templateModifyDate;
	}
	public java.lang.String getTemplateModifyUserName() {
		return templateModifyUserName;
	}
	public void setTemplateModifyUserName(java.lang.String templateModifyUserName) {
		this.templateModifyUserName = templateModifyUserName;
	}
	public java.lang.String getTemplateDescription() {
		return templateDescription;
	}
	public void setTemplateDescription(java.lang.String templateDescription) {
		this.templateDescription = templateDescription;
	}
	public java.lang.String getFlowId() {
		return flowId;
	}
	public void setFlowId(java.lang.String flowId) {
		this.flowId = flowId;
	}
	public java.lang.String getFlowName() {
		return flowName;
	}
	public void setFlowName(java.lang.String flowName) {
		this.flowName = flowName;
	}
	public java.lang.String getFlowType() {
		return flowType;
	}
	public void setFlowType(java.lang.String flowType) {
		this.flowType = flowType;
	}
	public java.lang.Long getFlowOrgOid() {
		return flowOrgOid;
	}
	public void setFlowOrgOid(java.lang.Long flowOrgOid) {
		this.flowOrgOid = flowOrgOid;
	}
	public java.lang.String getFlowOrgName() {
		return flowOrgName;
	}
	public void setFlowOrgName(java.lang.String flowOrgName) {
		this.flowOrgName = flowOrgName;
	}
	public java.lang.String getFlowCreateUserName() {
		return flowCreateUserName;
	}
	public void setFlowCreateUserName(java.lang.String flowCreateUserName) {
		this.flowCreateUserName = flowCreateUserName;
	}
	public java.lang.String getFlowCreateUserID() {
		return flowCreateUserID;
	}
	public void setFlowCreateUserID(java.lang.String flowCreateUserID) {
		this.flowCreateUserID = flowCreateUserID;
	}
	public java.util.Date getFlowCreateDate() {
		return flowCreateDate;
	}
	public void setFlowCreateDate(java.util.Date flowCreateDate) {
		this.flowCreateDate = flowCreateDate;
	}
	public java.lang.String getFlowModifyUserName() {
		return flowModifyUserName;
	}
	public void setFlowModifyUserName(java.lang.String flowModifyUserName) {
		this.flowModifyUserName = flowModifyUserName;
	}
	public java.lang.String getFlowModifyUserID() {
		return flowModifyUserID;
	}
	public void setFlowModifyUserID(java.lang.String flowModifyUserID) {
		this.flowModifyUserID = flowModifyUserID;
	}
	public java.util.Date getFlowModifyDate() {
		return flowModifyDate;
	}
	public void setFlowModifyDate(java.util.Date flowModifyDate) {
		this.flowModifyDate = flowModifyDate;
	}
	public List<WorkflowBaseInfoDTO> getBaseInfoList() {
		return baseInfoList;
	}
	public void setBaseInfoList(List<WorkflowBaseInfoDTO> baseInfoList) {
		this.baseInfoList = baseInfoList;
	}
	public List<WorkflowActivityDTO> getActivityList() {
		return activityList;
	}
	public void setActivityList(List<WorkflowActivityDTO> activityList) {
		this.activityList = activityList;
	}
	public List<WorkflowRuleDTO> getRuleList() {
		return ruleList;
	}
	public void setRuleList(List<WorkflowRuleDTO> ruleList) {
		this.ruleList = ruleList;
	}
	public java.lang.Long getTfForbidden() {
		return tfForbidden;
	}
	public void setTfForbidden(java.lang.Long tfForbidden) {
		this.tfForbidden = tfForbidden;
	}
	public java.lang.String getBak1() {
		return bak1;
	}
	public void setBak1(java.lang.String bak1) {
		this.bak1 = bak1;
	}

}
