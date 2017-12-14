package com.yh.component.workflow.web.form;

import org.apache.struts.action.ActionForm;


/**
 * 流程活动信息Form
 * @author liul
 *@createDate 2017-11-29
 */
public class WorkflowActivityForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.Long  	activityId;	//主键
	private java.lang.Long		baseInfoId;	//流程基本信息ID
	private java.lang.String  	activityName;	//活动名称
	private java.lang.String	activityIndex;	//活动序号
	private java.lang.String	preRegulation;	//前置规则
	private java.lang.String  	succeedRegulation;	//后置规则
	private java.lang.String 	activityType;//活动类型
	private java.lang.String    backMode;//退回方式
	private java.lang.String	endMode;//结束方式
	private java.lang.String    defaultAuditContent;//默认审核内容
	public java.lang.Long getActivityId() {
		return activityId;
	}
	public void setActivityId(java.lang.Long activityId) {
		this.activityId = activityId;
	}
	public java.lang.Long getBaseInfoId() {
		return baseInfoId;
	}
	public void setBaseInfoId(java.lang.Long baseInfoId) {
		this.baseInfoId = baseInfoId;
	}
	public java.lang.String getActivityName() {
		return activityName;
	}
	public void setActivityName(java.lang.String activityName) {
		this.activityName = activityName;
	}
	public java.lang.String getActivityIndex() {
		return activityIndex;
	}
	public void setActivityIndex(java.lang.String activityIndex) {
		this.activityIndex = activityIndex;
	}
	public java.lang.String getPreRegulation() {
		return preRegulation;
	}
	public void setPreRegulation(java.lang.String preRegulation) {
		this.preRegulation = preRegulation;
	}
	public java.lang.String getSucceedRegulation() {
		return succeedRegulation;
	}
	public void setSucceedRegulation(java.lang.String succeedRegulation) {
		this.succeedRegulation = succeedRegulation;
	}
	public java.lang.String getActivityType() {
		return activityType;
	}
	public void setActivityType(java.lang.String activityType) {
		this.activityType = activityType;
	}
	public java.lang.String getBackMode() {
		return backMode;
	}
	public void setBackMode(java.lang.String backMode) {
		this.backMode = backMode;
	}
	public java.lang.String getEndMode() {
		return endMode;
	}
	public void setEndMode(java.lang.String endMode) {
		this.endMode = endMode;
	}
	public java.lang.String getDefaultAuditContent() {
		return defaultAuditContent;
	}
	public void setDefaultAuditContent(java.lang.String defaultAuditContent) {
		this.defaultAuditContent = defaultAuditContent;
	}

}
