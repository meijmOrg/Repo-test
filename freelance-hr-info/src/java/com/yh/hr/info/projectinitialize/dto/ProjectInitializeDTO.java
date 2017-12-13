package com.yh.hr.info.projectinitialize.dto;


/**
 * @description 项目初始化dto
 * @author meijm
 * @created 2017-9-19
 * @version 1.0
 */
public class ProjectInitializeDTO
{
	
	private java.lang.Long customerOid;//主键id
	private java.lang.String licenseCode;//License码
	private java.lang.String newLicenseCode;//License码
    /**
     *客户简称
     **/
	private java.lang.String customerName;
    /**
     *单位地址
     **/
	private java.lang.String address;
	private java.lang.String phone;//单位电话
	private java.lang.String contacter;//单位负责人
	private java.lang.String contactType;//负责人联系方式
	private java.lang.String startStatus;//启动状态
	private java.lang.String remark;//备注
	public java.lang.Long getCustomerOid() {
		return customerOid;
	}
	public void setCustomerOid(java.lang.Long customerOid) {
		this.customerOid = customerOid;
	}
	public java.lang.String getLicenseCode() {
		return licenseCode;
	}
	public void setLicenseCode(java.lang.String licenseCode) {
		this.licenseCode = licenseCode;
	}
	public java.lang.String getNewLicenseCode() {
		return newLicenseCode;
	}
	public void setNewLicenseCode(java.lang.String newLicenseCode) {
		this.newLicenseCode = newLicenseCode;
	}
	public java.lang.String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(java.lang.String customerName) {
		this.customerName = customerName;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getPhone() {
		return phone;
	}
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	public java.lang.String getContacter() {
		return contacter;
	}
	public void setContacter(java.lang.String contacter) {
		this.contacter = contacter;
	}
	
	public java.lang.String getContactType() {
		return contactType;
	}
	public void setContactType(java.lang.String contactType) {
		this.contactType = contactType;
	}
	public java.lang.String getStartStatus() {
		return startStatus;
	}
	public void setStartStatus(java.lang.String startStatus) {
		this.startStatus = startStatus;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
}
