/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2017-07-11
**/
package com.yh.hr.res.im.dto;

public class ImDicTypeMappingDTO {

	private java.lang.Long  	dicTypeMappingOid;	//主键OID
	private java.lang.String	databaseColumnCode;	//数据库字段代码
	private java.lang.String	dicTypeCode;	//字典类型代码
	private java.lang.String	dicTypeName;	//字典类型名称
	private java.lang.String	modalType;	//字典值展示方式	1：下拉框	2：模态框
	private java.lang.String	effectiveFlag;	//生效标识	1：生效	0：失效
	private java.lang.String	remark;	//备注

	public ImDicTypeMappingDTO() {
		
	}

	public void setDicTypeMappingOid(java.lang.Long dicTypeMappingOid){
		this.dicTypeMappingOid = dicTypeMappingOid;
	}

	public java.lang.Long getDicTypeMappingOid(){
		return this.dicTypeMappingOid;
	}

	public void setDatabaseColumnCode(java.lang.String databaseColumnCode){
		this.databaseColumnCode = databaseColumnCode;
	}

	public java.lang.String getDatabaseColumnCode(){
		return this.databaseColumnCode;
	}

	public void setDicTypeCode(java.lang.String dicTypeCode){
		this.dicTypeCode = dicTypeCode;
	}

	public java.lang.String getDicTypeCode(){
		return this.dicTypeCode;
	}

	public void setDicTypeName(java.lang.String dicTypeName){
		this.dicTypeName = dicTypeName;
	}

	public java.lang.String getDicTypeName(){
		return this.dicTypeName;
	}

	public void setModalType(java.lang.String modalType){
		this.modalType = modalType;
	}

	public java.lang.String getModalType(){
		return this.modalType;
	}

	public void setEffectiveFlag(java.lang.String effectiveFlag){
		this.effectiveFlag = effectiveFlag;
	}

	public java.lang.String getEffectiveFlag(){
		return this.effectiveFlag;
	}

	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}

	public java.lang.String getRemark(){
		return this.remark;
	}

}
