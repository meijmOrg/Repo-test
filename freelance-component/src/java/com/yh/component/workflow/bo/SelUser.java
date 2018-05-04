package com.yh.component.workflow.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 选择办理人保存Bo
 * @author meijm
 *@createDate 2018-4-28
 */
public class SelUser extends BaseBo{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -749882218277287824L;
	private java.lang.String  	selUserId;	//主键
	private java.lang.String  	fileId;	//文档ID
	private java.lang.String	actId;	//活动单元ID
	private java.lang.String	userId;	//用户ID，以，分割
	
	public java.lang.String getSelUserId() {
		return selUserId;
	}
	public void setSelUserId(java.lang.String selUserId) {
		this.selUserId = selUserId;
	}
	public java.lang.String getFileId() {
		return fileId;
	}
	public void setFileId(java.lang.String fileId) {
		this.fileId = fileId;
	}
	public java.lang.String getActId() {
		return actId;
	}
	public void setActId(java.lang.String actId) {
		this.actId = actId;
	}
	public java.lang.String getUserId() {
		return userId;
	}
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
}
