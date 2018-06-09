package com.yh.hr.component.flow.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 
 * @ClassName: CoordinationTask 
 * @Description: 协同任务Bo
 * @author: liul
 * @date: 2018-6-1 上午10:54:24
 */
public class CoordinationTask extends BaseBo{
	
	private static final long serialVersionUID = -7275974847239668419L;
	private java.lang.String 	ctId; // 协同任务ID
	private java.lang.String  	ctName;	// 协同任务名称
	private java.lang.String	ctDoUser;	// 接收人ID
	private java.lang.String  	ctSendUser;	// 发送人
	private java.util.Date 		ctSendTime;// 发送时间
	private java.lang.String	ctTaskId;	// 所属任务ID
	private java.lang.String	ctFlowId;	// 所属流程ID
	private java.lang.String  	ctActId;	// 所属活动ID
	private java.lang.String 	ctEntityId;// 所属文档ID
	private java.lang.String    ctActName;// 所属活动名称
	public java.lang.String getCtId() {
		return ctId;
	}
	public void setCtId(java.lang.String ctId) {
		this.ctId = ctId;
	}
	public java.lang.String getCtName() {
		return ctName;
	}
	public void setCtName(java.lang.String ctName) {
		this.ctName = ctName;
	}
	public java.lang.String getCtDoUser() {
		return ctDoUser;
	}
	public void setCtDoUser(java.lang.String ctDoUser) {
		this.ctDoUser = ctDoUser;
	}
	public java.lang.String getCtSendUser() {
		return ctSendUser;
	}
	public void setCtSendUser(java.lang.String ctSendUser) {
		this.ctSendUser = ctSendUser;
	}
	public java.util.Date getCtSendTime() {
		return ctSendTime;
	}
	public void setCtSendTime(java.util.Date ctSendTime) {
		this.ctSendTime = ctSendTime;
	}
	public java.lang.String getCtTaskId() {
		return ctTaskId;
	}
	public void setCtTaskId(java.lang.String ctTaskId) {
		this.ctTaskId = ctTaskId;
	}
	public java.lang.String getCtFlowId() {
		return ctFlowId;
	}
	public void setCtFlowId(java.lang.String ctFlowId) {
		this.ctFlowId = ctFlowId;
	}
	public java.lang.String getCtActId() {
		return ctActId;
	}
	public void setCtActId(java.lang.String ctActId) {
		this.ctActId = ctActId;
	}
	public java.lang.String getCtEntityId() {
		return ctEntityId;
	}
	public void setCtEntityId(java.lang.String ctEntityId) {
		this.ctEntityId = ctEntityId;
	}
	public java.lang.String getCtActName() {
		return ctActName;
	}
	public void setCtActName(java.lang.String ctActName) {
		this.ctActName = ctActName;
	}
	
}