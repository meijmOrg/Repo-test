package com.yh.component.workflow.dto;

import java.util.ArrayList;


/**
 * 流程活动信息DTO
 * @author liul
 *@createDate 2017-11-27
 */
public class WorkflowActivityDTO{

	private java.lang.String  	actId;	//主键
	private java.lang.String	flowId;	//流程基本信息ID
	private java.lang.String  	actName;	//活动名称
	private java.lang.Integer	actOrder;	//活动序号
	private java.lang.String  	actOrderStr;	//活动序号
	private java.lang.String	actResult;	// 活动结果
	private java.lang.String	actBeginRuleId;	//前置规则
	private java.lang.String  	actEndRuleId;	//后置规则
	private java.lang.String 	actType;//活动单元类型-开始、结束、常规活动
	private java.lang.String    actBackType;//退回方式
	private java.lang.String	actFinishType;//结束方式
	private java.lang.String    actAuditContent;//默认审核内容
	
	private java.lang.String  	tfId;	//主键
	private java.lang.String	templateId;	//模板ID	
	private java.lang.Long 		tfForbidden;//停用Or启用，默认启用，用于后期扩展
	
	private java.util.List<FlowActivityNoticeDTO>			anList = new ArrayList<FlowActivityNoticeDTO>();
	private java.util.List<FlowActivityPermissionDTO>	apList = new ArrayList<FlowActivityPermissionDTO>();
	private java.util.List<PermissionUsersDTO>	puList = new ArrayList<PermissionUsersDTO>();
	public java.lang.String getActId() {
		return actId;
	}
	public void setActId(java.lang.String actId) {
		this.actId = actId;
	}
	public java.lang.String getFlowId() {
		return flowId;
	}
	public void setFlowId(java.lang.String flowId) {
		this.flowId = flowId;
	}
	public java.lang.String getActName() {
		return actName;
	}
	public void setActName(java.lang.String actName) {
		this.actName = actName;
	}
	public java.lang.Integer getActOrder() {
		return actOrder;
	}
	public void setActOrder(java.lang.Integer actOrder) {
		this.actOrder = actOrder;
	}
	public java.lang.String getActOrderStr() {
		return actOrderStr;
	}
	public void setActOrderStr(java.lang.String actOrderStr) {
		this.actOrderStr = actOrderStr;
	}
	public java.lang.String getActResult() {
		return actResult;
	}
	public void setActResult(java.lang.String actResult) {
		this.actResult = actResult;
	}
	public java.lang.String getActBeginRuleId() {
		return actBeginRuleId;
	}
	public void setActBeginRuleId(java.lang.String actBeginRuleId) {
		this.actBeginRuleId = actBeginRuleId;
	}
	public java.lang.String getActEndRuleId() {
		return actEndRuleId;
	}
	public void setActEndRuleId(java.lang.String actEndRuleId) {
		this.actEndRuleId = actEndRuleId;
	}
	public java.lang.String getActType() {
		return actType;
	}
	public void setActType(java.lang.String actType) {
		this.actType = actType;
	}
	public java.lang.String getActBackType() {
		return actBackType;
	}
	public void setActBackType(java.lang.String actBackType) {
		this.actBackType = actBackType;
	}
	public java.lang.String getActFinishType() {
		return actFinishType;
	}
	public void setActFinishType(java.lang.String actFinishType) {
		this.actFinishType = actFinishType;
	}
	public java.lang.String getActAuditContent() {
		return actAuditContent;
	}
	public void setActAuditContent(java.lang.String actAuditContent) {
		this.actAuditContent = actAuditContent;
	}
	public java.lang.String getTfId() {
		return tfId;
	}
	public void setTfId(java.lang.String tfId) {
		this.tfId = tfId;
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
	public java.util.List<FlowActivityNoticeDTO> getAnList() {
		return anList;
	}
	public void setAnList(java.util.List<FlowActivityNoticeDTO> anList) {
		this.anList = anList;
	}
	public java.util.List<FlowActivityPermissionDTO> getApList() {
		return apList;
	}
	public void setApList(java.util.List<FlowActivityPermissionDTO> apList) {
		this.apList = apList;
	}
	public java.util.List<PermissionUsersDTO> getPuList() {
		return puList;
	}
	public void setPuList(java.util.List<PermissionUsersDTO> puList) {
		this.puList = puList;
	}

}
