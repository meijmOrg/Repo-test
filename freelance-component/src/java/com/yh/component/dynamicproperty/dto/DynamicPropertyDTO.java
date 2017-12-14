package com.yh.component.dynamicproperty.dto;
/**
 * 动态字段控制表DTO
 * @author liul
 *@createDate 2017-10-31
 */
public class DynamicPropertyDTO {

	private java.lang.Long  	dpId;	//主键
	private java.lang.String	dpName;	//字段名称
	private java.lang.String  	dpDescription;	//字段含义
	private java.lang.String	dpType;	//字段类型
	private java.lang.String	dpCategory;	//字段类别
	private java.lang.String  	dpState;	//字段状态
	private java.lang.String 	dpCode;//字段编码
	private java.util.Date 		dpTime;//
	public java.lang.Long getDpId() {
		return dpId;
	}
	public void setDpId(java.lang.Long dpId) {
		this.dpId = dpId;
	}
	public java.lang.String getDpName() {
		return dpName;
	}
	public void setDpName(java.lang.String dpName) {
		this.dpName = dpName;
	}
	public java.lang.String getDpDescription() {
		return dpDescription;
	}
	public void setDpDescription(java.lang.String dpDescription) {
		this.dpDescription = dpDescription;
	}
	public java.lang.String getDpType() {
		return dpType;
	}
	public void setDpType(java.lang.String dpType) {
		this.dpType = dpType;
	}
	public java.lang.String getDpCategory() {
		return dpCategory;
	}
	public void setDpCategory(java.lang.String dpCategory) {
		this.dpCategory = dpCategory;
	}
	public java.lang.String getDpState() {
		return dpState;
	}
	public void setDpState(java.lang.String dpState) {
		this.dpState = dpState;
	}
	
	public java.lang.String getDpCode() {
		return dpCode;
	}
	public void setDpCode(java.lang.String dpCode) {
		this.dpCode = dpCode;
	}
	public java.util.Date getDpTime() {
		return dpTime;
	}
	public void setDpTime(java.util.Date dpTime) {
		this.dpTime = dpTime;
	}

}
