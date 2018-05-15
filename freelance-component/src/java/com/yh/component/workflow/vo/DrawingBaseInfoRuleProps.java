package com.yh.component.workflow.vo;

import com.alibaba.fastjson.JSONArray;


public class DrawingBaseInfoRuleProps{

	private String activityName; // act_name  活动单元名称
	private String activityNo; // 
	private String activityType; // act_type  活动单元类型-开始、结束、常规活动
	private String backWay; // act_back_type  退回方式
	private String content; // act_audit_content 默认审核内容
	private String allowSynergy; // ap_can_coordination 是否可以协同
	private String allowEnd; //  ap_can_finish 是否可以结束
	private String allowCountersign; //  ap_can_skip是否允许跳过
	private String allowCopy; // ap_can_carban_copy是否允许抄送
	private String allowRetroactive; // ap_can_retroactive是否允许补签
	private String handlers; // ap_user_type操作者组合方式
	private JSONArray orgInfo; // 部门
	private JSONArray groupInfo; // 小组
	private JSONArray roleInfo; // 角色
	private Boolean isMessage; // 任务创建人通知是否开启
	private String isMessageTemp; // 任务创建人通知消息内容
	private Boolean isMessageNext; // 下一处理人通知是否开启
	private String isMessageTempNext; // 下一处理人通知消息内容
	private Boolean isMessageHistory; // 历史处理人通知是否开启
	private String isMessageTempHistory; // 历史处理人通知消息内容
	private Boolean notification; // 通知是否开启（手机短信）
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getBackWay() {
		return backWay;
	}
	public void setBackWay(String backWay) {
		this.backWay = backWay;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAllowSynergy() {
		return allowSynergy;
	}
	public void setAllowSynergy(String allowSynergy) {
		this.allowSynergy = allowSynergy;
	}
	public String getAllowEnd() {
		return allowEnd;
	}
	public void setAllowEnd(String allowEnd) {
		this.allowEnd = allowEnd;
	}
	public String getAllowCountersign() {
		return allowCountersign;
	}
	public void setAllowCountersign(String allowCountersign) {
		this.allowCountersign = allowCountersign;
	}
	public String getAllowCopy() {
		return allowCopy;
	}
	public void setAllowCopy(String allowCopy) {
		this.allowCopy = allowCopy;
	}
	public String getAllowRetroactive() {
		return allowRetroactive;
	}
	public void setAllowRetroactive(String allowRetroactive) {
		this.allowRetroactive = allowRetroactive;
	}
	public String getHandlers() {
		return handlers;
	}
	public void setHandlers(String handlers) {
		this.handlers = handlers;
	}
	public JSONArray getOrgInfo() {
		return orgInfo;
	}
	public void setOrgInfo(JSONArray orgInfo) {
		this.orgInfo = orgInfo;
	}
	public JSONArray getGroupInfo() {
		return groupInfo;
	}
	public void setGroupInfo(JSONArray groupInfo) {
		this.groupInfo = groupInfo;
	}
	public JSONArray getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(JSONArray roleInfo) {
		this.roleInfo = roleInfo;
	}
	public Boolean getIsMessage() {
		return isMessage;
	}
	public void setIsMessage(Boolean isMessage) {
		this.isMessage = isMessage;
	}
	public String getIsMessageTemp() {
		return isMessageTemp;
	}
	public void setIsMessageTemp(String isMessageTemp) {
		this.isMessageTemp = isMessageTemp;
	}
	public Boolean getIsMessageNext() {
		return isMessageNext;
	}
	public void setIsMessageNext(Boolean isMessageNext) {
		this.isMessageNext = isMessageNext;
	}
	public String getIsMessageTempNext() {
		return isMessageTempNext;
	}
	public void setIsMessageTempNext(String isMessageTempNext) {
		this.isMessageTempNext = isMessageTempNext;
	}
	public Boolean getIsMessageHistory() {
		return isMessageHistory;
	}
	public void setIsMessageHistory(Boolean isMessageHistory) {
		this.isMessageHistory = isMessageHistory;
	}
	public String getIsMessageTempHistory() {
		return isMessageTempHistory;
	}
	public void setIsMessageTempHistory(String isMessageTempHistory) {
		this.isMessageTempHistory = isMessageTempHistory;
	}
	public Boolean getNotification() {
		return notification;
	}
	public void setNotification(Boolean notification) {
		this.notification = notification;
	}
	
}
