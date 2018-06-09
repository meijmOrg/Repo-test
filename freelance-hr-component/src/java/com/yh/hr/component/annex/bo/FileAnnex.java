package com.yh.hr.component.annex.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 附件BO
 * @author liul
 *@createDate 2018-5-8
 */
public class FileAnnex extends BaseBo{

	private static final long serialVersionUID = -4612054442510055721L;
	private java.lang.String  	faId;	//附件唯一ID
	private java.lang.String	fileId;	//文档唯一ID	
	private java.lang.String  	faName;	//附件名称
	private java.lang.String 	faPath;//附件路径
	private java.lang.String	faUserName;	//上传人
	private java.util.Date	faDate;	//上传时间
	public java.lang.String getFaId() {
		return faId;
	}
	public void setFaId(java.lang.String faId) {
		this.faId = faId;
	}
	public java.lang.String getFileId() {
		return fileId;
	}
	public void setFileId(java.lang.String fileId) {
		this.fileId = fileId;
	}
	public java.lang.String getFaName() {
		return faName;
	}
	public void setFaName(java.lang.String faName) {
		this.faName = faName;
	}
	public java.lang.String getFaPath() {
		return faPath;
	}
	public void setFaPath(java.lang.String faPath) {
		this.faPath = faPath;
	}
	public java.lang.String getFaUserName() {
		return faUserName;
	}
	public void setFaUserName(java.lang.String faUserName) {
		this.faUserName = faUserName;
	}
	public java.util.Date getFaDate() {
		return faDate;
	}
	public void setFaDate(java.util.Date faDate) {
		this.faDate = faDate;
	}
	
}