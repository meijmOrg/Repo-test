/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-12-08
**/
package com.yh.hr.info.ver.unit.comm.dto;

/*
 * 历次增资信息DTO
 * huanglm
 */
public class VerPbPreviousRaisesDTO {

	private java.lang.Long pbPreviousRaisesOid;//主键
	private java.lang.Long personOid;//personOid

	private java.lang.String previousRaisesmessage;//增资信息
	private java.lang.String remark;//备注
		
	private java.lang.String createdByCode;//CreatedByCode
	private java.lang.String createdByName;//CreatedByName
	private java.util.Date createdDate;//CreatedDate
	private java.lang.String updatedByCode;//UpdatedByCode
	private java.lang.String updatedByName;//UpdatedByName
	private java.util.Date updatedDate;//UpdatedDate
	

	public java.lang.Long getPersonOid() {
		return personOid;
	}
	public void setPersonOid(java.lang.Long personOid) {
		this.personOid = personOid;
	}

	public java.lang.Long getPbPreviousRaisesOid() {
		return pbPreviousRaisesOid;
	}
	public void setPbPreviousRaisesOid(java.lang.Long pbPreviousRaisesOid) {
		this.pbPreviousRaisesOid = pbPreviousRaisesOid;
	}
	public java.lang.String getPreviousRaisesmessage() {
		return previousRaisesmessage;
	}
	public void setPreviousRaisesmessage(java.lang.String previousRaisesmessage) {
		this.previousRaisesmessage = previousRaisesmessage;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.String getCreatedByCode() {
		return createdByCode;
	}
	public void setCreatedByCode(java.lang.String createdByCode) {
		this.createdByCode = createdByCode;
	}
	public java.lang.String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(java.lang.String createdByName) {
		this.createdByName = createdByName;
	}
	public java.util.Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}
	public java.lang.String getUpdatedByCode() {
		return updatedByCode;
	}
	public void setUpdatedByCode(java.lang.String updatedByCode) {
		this.updatedByCode = updatedByCode;
	}
	public java.lang.String getUpdatedByName() {
		return updatedByName;
	}
	public void setUpdatedByName(java.lang.String updatedByName) {
		this.updatedByName = updatedByName;
	}
	public java.util.Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(java.util.Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
