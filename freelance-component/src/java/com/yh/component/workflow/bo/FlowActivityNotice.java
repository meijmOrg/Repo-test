package com.yh.component.workflow.bo;


import com.yh.platform.core.bo.BaseBo;

/**
 * 流程活动信息-任务通知Bo
 * @author liul
 *@createDate 2017-12-28
 */
public class FlowActivityNotice extends BaseBo{

	private static final long serialVersionUID = 8184900217416222436L;
	private java.lang.String anId;//任务通知设置唯一ID
	private java.lang.String actId;//活动单元唯一ID
	private java.lang.String anType;//任务通知类别
	private java.lang.Double anState;//启动状态
	private java.lang.String anContent;//通知内容
	private java.lang.String anMode;//通知方式
	public java.lang.String getAnId() {
		return anId;
	}
	public void setAnId(java.lang.String anId) {
		this.anId = anId;
	}
	public java.lang.String getActId() {
		return actId;
	}
	public void setActId(java.lang.String actId) {
		this.actId = actId;
	}
	public java.lang.String getAnType() {
		return anType;
	}
	public void setAnType(java.lang.String anType) {
		this.anType = anType;
	}
	public java.lang.Double getAnState() {
		return anState;
	}
	public void setAnState(java.lang.Double anState) {
		this.anState = anState;
	}
	public java.lang.String getAnContent() {
		return anContent;
	}
	public void setAnContent(java.lang.String anContent) {
		this.anContent = anContent;
	}
	public java.lang.String getAnMode() {
		return anMode;
	}
	public void setAnMode(java.lang.String anMode) {
		this.anMode = anMode;
	}
	
}
