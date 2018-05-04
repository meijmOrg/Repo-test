package com.yh.hr.component.flow.dto;


public class YhFlowComponentDTO{
	private java.lang.String 	isSend;//是否发送短信
	private java.lang.String	messageContent;	//自定义提醒短信内容
	private java.lang.String 	nextUserList;//下一步选中的用户集合
	private java.lang.String 	otherUserList;//其他步骤选中的用户集合
	
	private java.lang.String	templateId;	//模板主键
	private java.lang.String	templateCode;	//模板Code
	private java.lang.String	fileCode;	//文档Code
	private java.lang.String	fileTitle;	//文件标题
	private java.lang.String	fileKeyWord;	//文档描述
	private java.lang.String	fileEmergencyLevel;	//紧急程度
	private java.lang.String	fileSecurityRate;	//文档密级
	
	private java.lang.String	flowId;	//任务所属流程ID
	private java.lang.String	ruleId;	//所属流程规则ID
	private java.lang.Long		deptId;	//所属部门ID
	private java.lang.String	taskCurrentActId;	//当前活动单元ID
	private java.lang.String	taskPreActId;	//上一步活动单元
	private java.lang.String	taskName;	//任务名称
	private java.lang.String	taskCoordination;	//协同状态
	private java.lang.String	taskSign;	//加签（标识任务是否属于加签，若是加签则不可以协同）
	private java.lang.Long		taskConunterSign;	//是否会签
	
	private java.lang.String	taskFromUser;	//任务来自用户
	private java.lang.String	taskSendNextUser;	//任务下一步用户
	private java.lang.String	taskProcessResult;	//处理结果
	private java.lang.String	taskProcessExplain;	//处理意见
	
	public java.lang.String getIsSend() {
		return isSend;
	}
	public void setIsSend(java.lang.String isSend) {
		this.isSend = isSend;
	}
	public java.lang.String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(java.lang.String messageContent) {
		this.messageContent = messageContent;
	}
	public java.lang.String getNextUserList() {
		return nextUserList;
	}
	public void setNextUserList(java.lang.String nextUserList) {
		this.nextUserList = nextUserList;
	}
	public java.lang.String getOtherUserList() {
		return otherUserList;
	}
	public void setOtherUserList(java.lang.String otherUserList) {
		this.otherUserList = otherUserList;
	}
	public java.lang.String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(java.lang.String templateId) {
		this.templateId = templateId;
	}
	public java.lang.String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(java.lang.String templateCode) {
		this.templateCode = templateCode;
	}
	public java.lang.String getFileCode() {
		return fileCode;
	}
	public void setFileCode(java.lang.String fileCode) {
		this.fileCode = fileCode;
	}
	public java.lang.String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(java.lang.String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public java.lang.String getFileKeyWord() {
		return fileKeyWord;
	}
	public void setFileKeyWord(java.lang.String fileKeyWord) {
		this.fileKeyWord = fileKeyWord;
	}
	public java.lang.String getFileEmergencyLevel() {
		return fileEmergencyLevel;
	}
	public void setFileEmergencyLevel(java.lang.String fileEmergencyLevel) {
		this.fileEmergencyLevel = fileEmergencyLevel;
	}
	public java.lang.String getFileSecurityRate() {
		return fileSecurityRate;
	}
	public void setFileSecurityRate(java.lang.String fileSecurityRate) {
		this.fileSecurityRate = fileSecurityRate;
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
	public java.lang.String getTaskName() {
		return taskName;
	}
	public void setTaskName(java.lang.String taskName) {
		this.taskName = taskName;
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
	public java.lang.String getTaskFromUser() {
		return taskFromUser;
	}
	public void setTaskFromUser(java.lang.String taskFromUser) {
		this.taskFromUser = taskFromUser;
	}
	public java.lang.String getTaskSendNextUser() {
		return taskSendNextUser;
	}
	public void setTaskSendNextUser(java.lang.String taskSendNextUser) {
		this.taskSendNextUser = taskSendNextUser;
	}
	public java.lang.String getTaskProcessResult() {
		return taskProcessResult;
	}
	public void setTaskProcessResult(java.lang.String taskProcessResult) {
		this.taskProcessResult = taskProcessResult;
	}
	public java.lang.String getTaskProcessExplain() {
		return taskProcessExplain;
	}
	public void setTaskProcessExplain(java.lang.String taskProcessExplain) {
		this.taskProcessExplain = taskProcessExplain;
	}
	
}
