/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-11-08
**/
package com.yh.component.upload.dto;

public class UploadFileDTO {

	private java.lang.Long  	uploadFileOid;	//主键
	private java.lang.String	refCode;	//来源代码
	private java.lang.Long  	refOid;	//来源OID
	private java.lang.String	createdByCode;	//CreatedByCode
	private java.lang.String	createdByName;	//CreatedByName
	private java.util.Date  	createdDate;	//CreatedDate

	public UploadFileDTO() {
		
	}

	public void setUploadFileOid(java.lang.Long uploadFileOid){
		this.uploadFileOid = uploadFileOid;
	}

	public java.lang.Long getUploadFileOid(){
		return this.uploadFileOid;
	}

	public void setRefCode(java.lang.String refCode){
		this.refCode = refCode;
	}

	public java.lang.String getRefCode(){
		return this.refCode;
	}

	public void setRefOid(java.lang.Long refOid){
		this.refOid = refOid;
	}

	public java.lang.Long getRefOid(){
		return this.refOid;
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

}
