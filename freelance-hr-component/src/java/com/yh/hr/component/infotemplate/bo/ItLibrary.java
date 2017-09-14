/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-08-31
**/
package com.yh.hr.component.infotemplate.bo;

import com.yh.platform.core.bo.BaseBo;

public class ItLibrary extends BaseBo {
	private static final long serialVersionUID = -4976099694129894793L;
	
	private java.lang.Long		libraryOid;	//主键
	private java.lang.String	infoName;	//查看或修改信息名称
	private java.lang.String	infoUrl;	//查看或修改信息URL
	private java.lang.String	isActive;	//是否有效：YHRS0003，0、否；1、是
	private java.lang.String	createdByCode;	//CreatedByCode
	private java.lang.String	createdByName;	//CreatedByName
	private java.util.Date		createdDate;	//CreatedDate
	private java.lang.String	updatedByCode;	//UpdatedByCode
	private java.lang.String	updatedByName;	//UpdatedByName
	private java.util.Date		updatedDate;	//UpdatedDate

	public ItLibrary() {
		
	}

	public void setLibraryOid(java.lang.Long libraryOid){
		this.libraryOid = libraryOid;
	}

	public java.lang.Long getLibraryOid(){
		return this.libraryOid;
	}

	public void setInfoName(java.lang.String infoName){
		this.infoName = infoName;
	}

	public java.lang.String getInfoName(){
		return this.infoName;
	}

	public void setInfoUrl(java.lang.String infoUrl){
		this.infoUrl = infoUrl;
	}

	public java.lang.String getInfoUrl(){
		return this.infoUrl;
	}

	public void setIsActive(java.lang.String isActive){
		this.isActive = isActive;
	}

	public java.lang.String getIsActive(){
		return this.isActive;
	}

	public void setCreatedByCode(java.lang.String createdByCode){
		this.createdByCode = createdByCode;
	}

	public java.lang.String getCreatedByCode(){
		return this.createdByCode;
	}

	public void setCreatedByName(java.lang.String createdByName){
		this.createdByName = createdByName;
	}

	public java.lang.String getCreatedByName(){
		return this.createdByName;
	}

	public void setCreatedDate(java.util.Date createdDate){
		this.createdDate = createdDate;
	}

	public java.util.Date getCreatedDate(){
		return this.createdDate;
	}

	public void setUpdatedByCode(java.lang.String updatedByCode){
		this.updatedByCode = updatedByCode;
	}

	public java.lang.String getUpdatedByCode(){
		return this.updatedByCode;
	}

	public void setUpdatedByName(java.lang.String updatedByName){
		this.updatedByName = updatedByName;
	}

	public java.lang.String getUpdatedByName(){
		return this.updatedByName;
	}

	public void setUpdatedDate(java.util.Date updatedDate){
		this.updatedDate = updatedDate;
	}

	public java.util.Date getUpdatedDate(){
		return this.updatedDate;
	}

}
