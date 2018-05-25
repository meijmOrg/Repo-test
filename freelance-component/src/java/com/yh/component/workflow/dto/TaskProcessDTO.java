package com.yh.component.workflow.dto;


/**
 * 
 * @ClassName: TaskProcessDTO 
 * @Description: 任务处理进程信息
 * @author: liul
 * @date: 2018-5-25 上午11:14:46
 */
public class TaskProcessDTO{

	private java.lang.String  	taskProcessId;	//主键
	private java.lang.String	taskId;	//任务ID
	private java.lang.String	flowId;	//所属流程ID
	private java.lang.String	actId;	//所属活动ID
	private java.lang.String	ruleId;	//所属规则ID
	private java.lang.String	fileId;	//所属文档ID
	private java.util.Date    	taskProcessDoTime;// 处理时间
	private java.lang.String	taskProcessUser;	//处理人
	private java.lang.String	taskProcessResult;	//处理结果
	private java.lang.String	taskProcessExplain;	//处理意见
	private java.lang.Long		deptId;	//所属部门
	private java.lang.String   	taskProcessName;// 处理任务名称
	private java.lang.String	taskProcessType;	//处理类型
	private java.lang.Long		isSkip;	//是否跳过
	private java.lang.String	skipUser;	//跳过者用户 ID
	private java.util.Date		taskProcessSignTime;	//补签时间
	private java.lang.String	actName;	//处理活动名称
	private java.util.Date		taskStartTime;	//任务开始时间
	private java.util.Date		taskEndTime;	//任务结束时间
	private java.lang.String	taskFromUser;	//任务来自用户
	private java.lang.String	taskSendNextUser;	//任务下一步用户
	public java.lang.String getTaskProcessId() {
		return taskProcessId;
	}
	public void setTaskProcessId(java.lang.String taskProcessId) {
		this.taskProcessId = taskProcessId;
	}
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
	public java.lang.String getActId() {
		return actId;
	}
	public void setActId(java.lang.String actId) {
		this.actId = actId;
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
	public java.util.Date getTaskProcessDoTime() {
		return taskProcessDoTime;
	}
	public void setTaskProcessDoTime(java.util.Date taskProcessDoTime) {
		this.taskProcessDoTime = taskProcessDoTime;
	}
	public java.lang.String getTaskProcessUser() {
		return taskProcessUser;
	}
	public void setTaskProcessUser(java.lang.String taskProcessUser) {
		this.taskProcessUser = taskProcessUser;
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
	public java.lang.Long getDeptId() {
		return deptId;
	}
	public void setDeptId(java.lang.Long deptId) {
		this.deptId = deptId;
	}
	public java.lang.String getTaskProcessName() {
		return taskProcessName;
	}
	public void setTaskProcessName(java.lang.String taskProcessName) {
		this.taskProcessName = taskProcessName;
	}
	public java.lang.String getTaskProcessType() {
		return taskProcessType;
	}
	public void setTaskProcessType(java.lang.String taskProcessType) {
		this.taskProcessType = taskProcessType;
	}
	public java.lang.Long getIsSkip() {
		return isSkip;
	}
	public void setIsSkip(java.lang.Long isSkip) {
		this.isSkip = isSkip;
	}
	public java.lang.String getSkipUser() {
		return skipUser;
	}
	public void setSkipUser(java.lang.String skipUser) {
		this.skipUser = skipUser;
	}
	public java.util.Date getTaskProcessSignTime() {
		return taskProcessSignTime;
	}
	public void setTaskProcessSignTime(java.util.Date taskProcessSignTime) {
		this.taskProcessSignTime = taskProcessSignTime;
	}
	public java.lang.String getActName() {
		return actName;
	}
	public void setActName(java.lang.String actName) {
		this.actName = actName;
	}
	public java.util.Date getTaskStartTime() {
		return taskStartTime;
	}
	public void setTaskStartTime(java.util.Date taskStartTime) {
		this.taskStartTime = taskStartTime;
	}
	public java.util.Date getTaskEndTime() {
		return taskEndTime;
	}
	public void setTaskEndTime(java.util.Date taskEndTime) {
		this.taskEndTime = taskEndTime;
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

}
