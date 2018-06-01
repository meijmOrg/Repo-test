package com.yh.hr.component.annex.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 
 * @ClassName: CoordinationAnnex 
 * @Description: 协同附件BO
 * @author: liul
 * @date: 2018-6-1 下午04:09:53
 */
public class CoordinationAnnex extends BaseBo{

	private static final long serialVersionUID = 1241787005740165022L;
	private java.lang.String  	caId;	//协同附件唯一ID
	private java.lang.String	caName;	//协同附件名称
	private java.lang.String  	caFilePath;	//协同附件路径
	private java.lang.String 	caLoadUser;//协同附件上传人
	private java.util.Date	caDoTime;	//协同附件上传时间
	private java.lang.String	caCtId;	//协同附件所属任务ID
	private java.lang.String	caActId;	//协同附件所属活动单元
	public java.lang.String getCaId() {
		return caId;
	}
	public void setCaId(java.lang.String caId) {
		this.caId = caId;
	}
	public java.lang.String getCaName() {
		return caName;
	}
	public void setCaName(java.lang.String caName) {
		this.caName = caName;
	}
	public java.lang.String getCaFilePath() {
		return caFilePath;
	}
	public void setCaFilePath(java.lang.String caFilePath) {
		this.caFilePath = caFilePath;
	}
	public java.lang.String getCaLoadUser() {
		return caLoadUser;
	}
	public void setCaLoadUser(java.lang.String caLoadUser) {
		this.caLoadUser = caLoadUser;
	}
	public java.util.Date getCaDoTime() {
		return caDoTime;
	}
	public void setCaDoTime(java.util.Date caDoTime) {
		this.caDoTime = caDoTime;
	}
	public java.lang.String getCaCtId() {
		return caCtId;
	}
	public void setCaCtId(java.lang.String caCtId) {
		this.caCtId = caCtId;
	}
	public java.lang.String getCaActId() {
		return caActId;
	}
	public void setCaActId(java.lang.String caActId) {
		this.caActId = caActId;
	}
	
}