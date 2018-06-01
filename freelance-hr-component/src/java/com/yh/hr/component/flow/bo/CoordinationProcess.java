package com.yh.hr.component.flow.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 
 * @ClassName: CoordinationProcess 
 * @Description: 协同任务进程BO
 * @author: liul
 * @date: 2018-6-1 上午11:04:25
 */
public class CoordinationProcess extends BaseBo{

	private static final long serialVersionUID = 6376055207571887749L;
	private java.lang.String  	cpId;	//协同任务进程唯一 ID
	private java.lang.String	cpName;	//协同任务名称
	private java.lang.String  	cpCtId;	//协同任务ID
	private java.lang.String 	cpSendUser;//发送人
	private java.lang.String	cpDoUser;	//协同任务处理人ID
	private java.lang.String	cpExplain;	//协同处理意见
	private java.util.Date  	cpSendTime;	//发送时间
	private java.util.Date 	    cpDoTime;//协同任务处理时间
	private java.lang.String    cpFlowId;//所属流程 ID
	private java.lang.String    cpActId;//所属活动单元
	private java.lang.String	cpEntityId;//所属文档ID
	public java.lang.String getCpId() {
		return cpId;
	}
	public void setCpId(java.lang.String cpId) {
		this.cpId = cpId;
	}
	public java.lang.String getCpName() {
		return cpName;
	}
	public void setCpName(java.lang.String cpName) {
		this.cpName = cpName;
	}
	public java.lang.String getCpCtId() {
		return cpCtId;
	}
	public void setCpCtId(java.lang.String cpCtId) {
		this.cpCtId = cpCtId;
	}
	public java.lang.String getCpSendUser() {
		return cpSendUser;
	}
	public void setCpSendUser(java.lang.String cpSendUser) {
		this.cpSendUser = cpSendUser;
	}
	public java.lang.String getCpDoUser() {
		return cpDoUser;
	}
	public void setCpDoUser(java.lang.String cpDoUser) {
		this.cpDoUser = cpDoUser;
	}
	public java.lang.String getCpExplain() {
		return cpExplain;
	}
	public void setCpExplain(java.lang.String cpExplain) {
		this.cpExplain = cpExplain;
	}
	public java.util.Date getCpSendTime() {
		return cpSendTime;
	}
	public void setCpSendTime(java.util.Date cpSendTime) {
		this.cpSendTime = cpSendTime;
	}
	public java.util.Date getCpDoTime() {
		return cpDoTime;
	}
	public void setCpDoTime(java.util.Date cpDoTime) {
		this.cpDoTime = cpDoTime;
	}
	public java.lang.String getCpFlowId() {
		return cpFlowId;
	}
	public void setCpFlowId(java.lang.String cpFlowId) {
		this.cpFlowId = cpFlowId;
	}
	public java.lang.String getCpActId() {
		return cpActId;
	}
	public void setCpActId(java.lang.String cpActId) {
		this.cpActId = cpActId;
	}
	public java.lang.String getCpEntityId() {
		return cpEntityId;
	}
	public void setCpEntityId(java.lang.String cpEntityId) {
		this.cpEntityId = cpEntityId;
	}
	
}