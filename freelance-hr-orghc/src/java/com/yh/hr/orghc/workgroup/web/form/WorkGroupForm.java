/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-09-02
**/
package com.yh.hr.orghc.workgroup.web.form;

import org.apache.struts.validator.ValidatorForm;

public class WorkGroupForm extends ValidatorForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7012094001342780445L;
	private java.lang.String wpId;//小组唯一ID
	private java.lang.String wpName;//小组名称
	private java.lang.String wpDescription;//描述
	private java.lang.String wpDepId;//隶属部门
	private java.lang.String wpDepName;//隶属部门
	private java.util.Date   wpCreateDate;//创建时间
	private java.lang.String wpCreateUser;//创建人
	private java.lang.String wpStatus;//小组状态
	public java.lang.String getWpId() {
		return wpId;
	}
	public void setWpId(java.lang.String wpId) {
		this.wpId = wpId;
	}
	public java.lang.String getWpName() {
		return wpName;
	}
	public void setWpName(java.lang.String wpName) {
		this.wpName = wpName;
	}
	public java.lang.String getWpDescription() {
		return wpDescription;
	}
	public void setWpDescription(java.lang.String wpDescription) {
		this.wpDescription = wpDescription;
	}
	public java.lang.String getWpDepId() {
		return wpDepId;
	}
	public void setWpDepId(java.lang.String wpDepId) {
		this.wpDepId = wpDepId;
	}
	public java.util.Date getWpCreateDate() {
		return wpCreateDate;
	}
	public void setWpCreateDate(java.util.Date wpCreateDate) {
		this.wpCreateDate = wpCreateDate;
	}
	public java.lang.String getWpCreateUser() {
		return wpCreateUser;
	}
	public void setWpCreateUser(java.lang.String wpCreateUser) {
		this.wpCreateUser = wpCreateUser;
	}
	public java.lang.String getWpStatus() {
		return wpStatus;
	}
	public void setWpStatus(java.lang.String wpStatus) {
		this.wpStatus = wpStatus;
	}
	public java.lang.String getWpDepName() {
		return wpDepName;
	}
	public void setWpDepName(java.lang.String wpDepName) {
		this.wpDepName = wpDepName;
	}
	
	
}
