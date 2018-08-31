package com.yh.hr.biz.vacation.dto;

import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.platform.core.util.DateUtil;

public class YhfVacationDTO extends YhFlowComponentDTO{

	private java.lang.String 	vacationId;//
	private java.lang.String	staffId;	//
	private java.lang.String 	userId;//用户ID
	private java.lang.String 	userName;//用户名称
	private java.util.Date 	    beginTime;//请假开始时间
	private java.lang.String 	beginTimeStr;//请假开始时间
	private java.util.Date 		endTime;//请假结束时间
	private java.lang.String 	endTimeStr;//请假结束时间
	private java.lang.String 	reason;//请假原因
	public java.lang.String getVacationId() {
		return vacationId;
	}
	public void setVacationId(java.lang.String vacationId) {
		this.vacationId = vacationId;
	}
	public java.lang.String getStaffId() {
		return staffId;
	}
	public void setStaffId(java.lang.String staffId) {
		this.staffId = staffId;
	}
	public java.lang.String getUserId() {
		return userId;
	}
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	public java.lang.String getUserName() {
		return userName;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	public java.util.Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
		this.beginTimeStr = DateUtil.formatDate(beginTime);
	}
	public java.lang.String getBeginTimeStr() {
		return beginTimeStr;
	}
	public void setBeginTimeStr(java.lang.String beginTimeStr) {
		this.beginTimeStr = beginTimeStr;
		this.beginTime = DateUtil.parseDate(beginTimeStr);
	}
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
		this.endTimeStr = DateUtil.formatDate(endTime);
	}
	public java.lang.String getEndTimeStr() {
		return endTimeStr;
	}
	public void setEndTimeStr(java.lang.String endTimeStr) {
		this.endTimeStr = endTimeStr;
		this.endTime = DateUtil.parseDate(endTimeStr);
	}
	public java.lang.String getReason() {
		return reason;
	}
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}
	
}
