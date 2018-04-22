package com.yh.hr.res.unit.dto;

/**
 * 小组DTO
 * @author halfsummer
 * 2018年04月22日19:10:03
 */
public class WorkGroupDTO {
	
	private java.lang.String wpId;//小组唯一ID
	private java.lang.String wpName;//小组名称
	private java.lang.String wpDescription;//描述
	private java.lang.String wpDepId;//隶属部门
	private java.lang.String wpStatus;//小组状态
	private java.util.Date   wpCreateDate;//创建时间
	private java.lang.String wpCreateUser;//创建人
	
	public WorkGroupDTO() {
		
	}
	
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
	
	public java.lang.String getWpStatus() {
		return wpStatus;
	}

	public void setWpStatus(java.lang.String wpStatus) {
		this.wpStatus = wpStatus;
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
	
}
