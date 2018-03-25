package com.yh.component.workflow.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 任务基本信息Bo
 * @author meijm
 *@createDate 2018-2-9
 */
public class Task extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 40590100609461068L;
	private java.lang.String  	taskId;	//主键
	private java.lang.String	flowId;	//任务所属流程ID
	private java.lang.String	ruleId;	//所属流程规则ID
	private java.lang.String	fileId;	//所属文档实体ID
	private java.lang.Long		deptId;	//所属部门ID
	private java.lang.String	taskCurrentActId;	//当前活动单元ID
	private java.lang.String	taskPreActId;	//上一步活动单元
	private java.lang.String	taskNextActId;	//下一步活动单元
	private java.lang.String	taskUser;	//当前活动处理人ID
	private java.lang.String	taskName;	//任务名称
	private java.util.Date    	taskSendTime;// 任务发送时间
	private java.lang.String	taskSendUser;	//任务发送人
	private java.lang.String	taskCoordination;	//协同状态
	private java.lang.String	taskSign;	//加签（标识任务是否属于加签，若是加签则不可以协同）
	private java.lang.Long		taskConunterSign;	//是否会签
	public java.lang.String getTaskId() {
		return taskId;
	}
	public void setTaskId(java.lang.String taskId) {
		this.taskId = taskId;
	}
	public java.lang.String getFlowId() {
		return flowId;
	}
	public void setFlowId(java.lang.String flowId) {
		this.flowId = flowId;
	}
	public java.lang.String getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.String ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.String getFileId() {
		return fileId;
	}
	public void setFileId(java.lang.String fileId) {
		this.fileId = fileId;
	}
	public java.lang.Long getDeptId() {
		return deptId;
	}
	public void setDeptId(java.lang.Long deptId) {
		this.deptId = deptId;
	}
	public java.lang.String getTaskCurrentActId() {
		return taskCurrentActId;
	}
	public void setTaskCurrentActId(java.lang.String taskCurrentActId) {
		this.taskCurrentActId = taskCurrentActId;
	}
	public java.lang.String getTaskPreActId() {
		return taskPreActId;
	}
	public void setTaskPreActId(java.lang.String taskPreActId) {
		this.taskPreActId = taskPreActId;
	}
	public java.lang.String getTaskNextActId() {
		return taskNextActId;
	}
	public void setTaskNextActId(java.lang.String taskNextActId) {
		this.taskNextActId = taskNextActId;
	}
	public java.lang.String getTaskUser() {
		return taskUser;
	}
	public void setTaskUser(java.lang.String taskUser) {
		this.taskUser = taskUser;
	}
	public java.lang.String getTaskName() {
		return taskName;
	}
	public void setTaskName(java.lang.String taskName) {
		this.taskName = taskName;
	}
	public java.util.Date getTaskSendTime() {
		return taskSendTime;
	}
	public void setTaskSendTime(java.util.Date taskSendTime) {
		this.taskSendTime = taskSendTime;
	}
	public java.lang.String getTaskSendUser() {
		return taskSendUser;
	}
	public void setTaskSendUser(java.lang.String taskSendUser) {
		this.taskSendUser = taskSendUser;
	}
	public java.lang.String getTaskCoordination() {
		return taskCoordination;
	}
	public void setTaskCoordination(java.lang.String taskCoordination) {
		this.taskCoordination = taskCoordination;
	}
	public java.lang.String getTaskSign() {
		return taskSign;
	}
	public void setTaskSign(java.lang.String taskSign) {
		this.taskSign = taskSign;
	}
	public java.lang.Long getTaskConunterSign() {
		return taskConunterSign;
	}
	public void setTaskConunterSign(java.lang.Long taskConunterSign) {
		this.taskConunterSign = taskConunterSign;
	}

}
