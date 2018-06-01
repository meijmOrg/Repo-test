package com.yh.hr.component.flow.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 抄送记录信息BO
 * @author meijm
 *@createDate 2018-03-24
 */
public class CarbonCopy extends BaseBo{

	
	private static final long serialVersionUID = 1L;
	private java.lang.String  	ccId;	//主键
	private java.lang.String	ccActId;	//活动ID
	private java.lang.String  	ccUser;	//抄送人
	private java.lang.String 	ccFlowId;//所属流程
	private java.util.Date	    ccTime;	//抄送时间
	private java.lang.String	ccCreateUser;	//经办人
	private java.lang.String  	ccRead;	//查看状态
	private java.util.Date 	    ccReadTime;//查看时间
	private java.lang.String    ccTitle;//抄送标题
	private java.lang.String    ccFileID;//文档实体编号
	private java.lang.String	ccProcessID;//活动处理记录
	private java.lang.String    ccExplain;//查看意见
	public java.lang.String getCcId() {
		return ccId;
	}
	public void setCcId(java.lang.String ccId) {
		this.ccId = ccId;
	}
	public java.lang.String getCcActId() {
		return ccActId;
	}
	public void setCcActId(java.lang.String ccActId) {
		this.ccActId = ccActId;
	}
	public java.lang.String getCcUser() {
		return ccUser;
	}
	public void setCcUser(java.lang.String ccUser) {
		this.ccUser = ccUser;
	}
	public java.lang.String getCcFlowId() {
		return ccFlowId;
	}
	public void setCcFlowId(java.lang.String ccFlowId) {
		this.ccFlowId = ccFlowId;
	}
	public java.util.Date getCcTime() {
		return ccTime;
	}
	public void setCcTime(java.util.Date ccTime) {
		this.ccTime = ccTime;
	}
	public java.lang.String getCcCreateUser() {
		return ccCreateUser;
	}
	public void setCcCreateUser(java.lang.String ccCreateUser) {
		this.ccCreateUser = ccCreateUser;
	}
	public java.lang.String getCcRead() {
		return ccRead;
	}
	public void setCcRead(java.lang.String ccRead) {
		this.ccRead = ccRead;
	}
	public java.util.Date getCcReadTime() {
		return ccReadTime;
	}
	public void setCcReadTime(java.util.Date ccReadTime) {
		this.ccReadTime = ccReadTime;
	}
	public java.lang.String getCcTitle() {
		return ccTitle;
	}
	public void setCcTitle(java.lang.String ccTitle) {
		this.ccTitle = ccTitle;
	}
	public java.lang.String getCcFileID() {
		return ccFileID;
	}
	public void setCcFileID(java.lang.String ccFileID) {
		this.ccFileID = ccFileID;
	}
	public java.lang.String getCcProcessID() {
		return ccProcessID;
	}
	public void setCcProcessID(java.lang.String ccProcessID) {
		this.ccProcessID = ccProcessID;
	}
	public java.lang.String getCcExplain() {
		return ccExplain;
	}
	public void setCcExplain(java.lang.String ccExplain) {
		this.ccExplain = ccExplain;
	}
	
}