/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-11-08
**/
package com.yh.component.upload.dto;

public class UploadFileDetailDTO {

	private java.lang.Long  	fileOid;	//FileOid
	private java.lang.Long  	uploadFileOid;	//UploadFileOid
	private java.lang.String	fileName;	//文件名称
	private java.lang.String	fileNameTarget;	//服务器上文件名称
	private java.lang.String	fileType;	//文件类型
	private java.lang.String	path;	//文件位置（全路径）
	private java.lang.String	createdByCode;	//CreatedByCode
	private java.lang.String	createdByName;	//CreatedByName
	private java.util.Date  	createdDate;	//CreatedDate

	public UploadFileDetailDTO() {
		
	}

	public void setFileOid(java.lang.Long fileOid){
		this.fileOid = fileOid;
	}

	public java.lang.Long getFileOid(){
		return this.fileOid;
	}

	public void setUploadFileOid(java.lang.Long uploadFileOid){
		this.uploadFileOid = uploadFileOid;
	}

	public java.lang.Long getUploadFileOid(){
		return this.uploadFileOid;
	}

	public void setFileName(java.lang.String fileName){
		this.fileName = fileName;
	}

	public java.lang.String getFileName(){
		return this.fileName;
	}

	public void setFileNameTarget(java.lang.String fileNameTarget){
		this.fileNameTarget = fileNameTarget;
	}

	public java.lang.String getFileNameTarget(){
		return this.fileNameTarget;
	}

	public void setFileType(java.lang.String fileType){
		this.fileType = fileType;
	}

	public java.lang.String getFileType(){
		return this.fileType;
	}

	public void setPath(java.lang.String path){
		this.path = path;
	}

	public java.lang.String getPath(){
		return this.path;
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
