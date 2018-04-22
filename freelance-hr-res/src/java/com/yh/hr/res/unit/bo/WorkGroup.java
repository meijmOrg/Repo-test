package com.yh.hr.res.unit.bo;


import com.yh.platform.core.bo.BaseBo;

/**
 * 小组Bo
 * @author meijm
 *@createDate 2018-04-22
 */
public class WorkGroup extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8171760620224594628L;
	private java.lang.String wpId;//小组唯一ID
	private java.lang.String wpName;//小组名称
	private java.lang.String wpDescription;//描述
	private java.lang.String wpDepId;//隶属部门
	private java.util.Date   wpCreateDate;//创建时间
	private java.lang.String wpCreateUser;//创建人
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
	
}
