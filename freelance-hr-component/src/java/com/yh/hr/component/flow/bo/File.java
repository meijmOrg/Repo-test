package com.yh.hr.component.flow.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 文档基本信息Bo
 * @author meijm
 *@createDate 2018-2-7
 */
public class File extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7931044742371660486L;
	private java.lang.String  	fileId;	//主键
	private java.lang.String	templateId;	//模板主键
	private java.lang.String	templateCode;	//模板Code
	private java.lang.String	fileCode;	//文档Code
	private java.lang.String	fileTitle;	//文件标题
	private java.lang.String	fileKeyWord;	//文档描述
	private java.lang.String	fileFlowStatus;	//流程处理状态
	private java.util.Date    	createDate;// 文档创建时间
	private java.lang.String	createUserID;	//文档创建人ID
	private java.lang.String	createUserName;	//文档创建人姓名
	private java.lang.Long		createDepartID;	//文档创建部门
	private java.lang.String	fileEmergencyLevel;	//紧急程度
	private java.lang.String	fileSecurityRate;	//文档密级
	private java.lang.String	bak1;	//备注字段1
	private java.lang.String	bak2;	//备注字段2
	private java.lang.String	bak3;	//备注字段3
	private java.util.Date    	bak4;// 备注字段4
	private java.util.Date    	bak5;// 备注字段5
	private java.lang.String	bak6;	//备注字段6
	private java.lang.String	bak7;	//备注字段7
	private java.lang.Double    bak8;	//备注字段8
	private java.lang.Double    bak9;	//备注字段9
	private java.lang.Long	    bak10;	//备注字段10
	public java.lang.String getFileId() {
		return fileId;
	}
	public void setFileId(java.lang.String fileId) {
		this.fileId = fileId;
	}
	public java.lang.String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(java.lang.String templateId) {
		this.templateId = templateId;
	}
	public java.lang.String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(java.lang.String templateCode) {
		this.templateCode = templateCode;
	}
	public java.lang.String getFileCode() {
		return fileCode;
	}
	public void setFileCode(java.lang.String fileCode) {
		this.fileCode = fileCode;
	}
	public java.lang.String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(java.lang.String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public java.lang.String getFileKeyWord() {
		return fileKeyWord;
	}
	public void setFileKeyWord(java.lang.String fileKeyWord) {
		this.fileKeyWord = fileKeyWord;
	}
	public java.lang.String getFileFlowStatus() {
		return fileFlowStatus;
	}
	public void setFileFlowStatus(java.lang.String fileFlowStatus) {
		this.fileFlowStatus = fileFlowStatus;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.lang.String getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(java.lang.String createUserID) {
		this.createUserID = createUserID;
	}
	public java.lang.String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(java.lang.String createUserName) {
		this.createUserName = createUserName;
	}
	public java.lang.Long getCreateDepartID() {
		return createDepartID;
	}
	public void setCreateDepartID(java.lang.Long createDepartID) {
		this.createDepartID = createDepartID;
	}
	public java.lang.String getFileEmergencyLevel() {
		return fileEmergencyLevel;
	}
	public void setFileEmergencyLevel(java.lang.String fileEmergencyLevel) {
		this.fileEmergencyLevel = fileEmergencyLevel;
	}
	public java.lang.String getFileSecurityRate() {
		return fileSecurityRate;
	}
	public void setFileSecurityRate(java.lang.String fileSecurityRate) {
		this.fileSecurityRate = fileSecurityRate;
	}
	public java.lang.String getBak1() {
		return bak1;
	}
	public void setBak1(java.lang.String bak1) {
		this.bak1 = bak1;
	}
	public java.lang.String getBak2() {
		return bak2;
	}
	public void setBak2(java.lang.String bak2) {
		this.bak2 = bak2;
	}
	public java.lang.String getBak3() {
		return bak3;
	}
	public void setBak3(java.lang.String bak3) {
		this.bak3 = bak3;
	}
	public java.util.Date getBak4() {
		return bak4;
	}
	public void setBak4(java.util.Date bak4) {
		this.bak4 = bak4;
	}
	public java.util.Date getBak5() {
		return bak5;
	}
	public void setBak5(java.util.Date bak5) {
		this.bak5 = bak5;
	}
	public java.lang.String getBak6() {
		return bak6;
	}
	public void setBak6(java.lang.String bak6) {
		this.bak6 = bak6;
	}
	public java.lang.String getBak7() {
		return bak7;
	}
	public void setBak7(java.lang.String bak7) {
		this.bak7 = bak7;
	}
	public java.lang.Double getBak8() {
		return bak8;
	}
	public void setBak8(java.lang.Double bak8) {
		this.bak8 = bak8;
	}
	public java.lang.Double getBak9() {
		return bak9;
	}
	public void setBak9(java.lang.Double bak9) {
		this.bak9 = bak9;
	}
	public java.lang.Long getBak10() {
		return bak10;
	}
	public void setBak10(java.lang.Long bak10) {
		this.bak10 = bak10;
	}
	
}
