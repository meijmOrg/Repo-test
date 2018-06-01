package com.yh.component.workflow.dto;
/**
 * 流程基本信息DTO
 * @author liul
 *@createDate 2017-11-17
 */
public class WorkflowBaseInfoDTO {

	private java.lang.String  	flowId;	//主键
	private java.lang.String	flowName;	//流程名称	
	private java.lang.String	flowType;	//流程类型：专属流程和通用流程
	private java.lang.Long 		flowOrgOid=this.orgOid;//流程所属部门，若是通用流程，则保存0，若是专属流程保存部门ID
	private java.lang.String    flowOrgName=this.orgName;//所属部门名称
	private java.lang.Long 		orgOid;
	private java.lang.String    orgName;
	private java.lang.String    flowCreateUserName;// 流程创建人
	private java.lang.String    flowCreateUserID;// 流程创建人ID
	private java.util.Date    	flowCreateDate;//  流程创建时间
	private java.lang.String    flowModifyUserName;// 流程最近修改人姓名
	private java.lang.String    flowModifyUserID;// 流程最近修改人 ID
	private java.util.Date    	flowModifyDate;// 流程最近修改时间
	private java.lang.String	flowData;
	
	private java.lang.String	templateId;	//模板ID	
	private java.lang.Long 		tfForbidden;//停用Or启用，默认启用，用于后期扩展
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
	public java.lang.String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(java.lang.String templateId) {
		this.templateId = templateId;
	}
	public java.lang.Long getTfForbidden() {
		return tfForbidden;
	}
	public void setTfForbidden(java.lang.Long tfForbidden) {
		this.tfForbidden = tfForbidden;
	}
	public java.lang.Long getOrgOid() {
		return orgOid;
	}
	public void setOrgOid(java.lang.Long orgOid) {
		this.orgOid = orgOid;
		this.setFlowOrgOid(orgOid);
	}
	public java.lang.String getOrgName() {
		return orgName;
	}
	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
		this.setFlowOrgName(orgName);
	}
	public java.lang.String getFlowData() {
		return flowData;
	}
	public void setFlowData(java.lang.String flowData) {
		this.flowData = flowData;
	}

}
