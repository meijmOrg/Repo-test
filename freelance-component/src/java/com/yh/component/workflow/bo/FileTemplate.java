package com.yh.component.workflow.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 模板信息BO
 * @author liul
 *@createDate 2017-11-16
 */
public class FileTemplate extends BaseBo{

	
	private static final long serialVersionUID = 1L;
	private java.lang.String  	templateId;	//主键
	private java.lang.String	templateName;	//模板名称	
	private java.lang.String  	templateCode;	//编码
	private java.lang.String 	templateIsUniversal;//是否通用模板
	private java.lang.String	templateType;	//模板类别
	private java.lang.String	templateCreatePage;	//创建页面
	private java.lang.String  	templateEditPage;	//编辑页面
	private java.lang.String 	templateInfoPage;//详细页面
	private java.lang.String    templateFlowPage;//流程页面
	private java.lang.String    templateReportPage;//报表页面
	private java.util.Date		templateCreateDate;//创建时间
	private java.lang.String    templateCreateUserName;//创建人
	private java.util.Date		templateModifyDate;//最新修改时间
	private java.lang.String    templateModifyUserName;//最近修改人
	private java.lang.String    templateDescription;//模板描述
	public java.lang.String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(java.lang.String templateId) {
		this.templateId = templateId;
	}
	public java.lang.String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(java.lang.String templateName) {
		this.templateName = templateName;
	}
	public java.lang.String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(java.lang.String templateCode) {
		this.templateCode = templateCode;
	}
	public java.lang.String getTemplateIsUniversal() {
		return templateIsUniversal;
	}
	public void setTemplateIsUniversal(java.lang.String templateIsUniversal) {
		this.templateIsUniversal = templateIsUniversal;
	}
	public java.lang.String getTemplateType() {
		return templateType;
	}
	public void setTemplateType(java.lang.String templateType) {
		this.templateType = templateType;
	}
	public java.lang.String getTemplateCreatePage() {
		return templateCreatePage;
	}
	public void setTemplateCreatePage(java.lang.String templateCreatePage) {
		this.templateCreatePage = templateCreatePage;
	}
	public java.lang.String getTemplateEditPage() {
		return templateEditPage;
	}
	public void setTemplateEditPage(java.lang.String templateEditPage) {
		this.templateEditPage = templateEditPage;
	}
	public java.lang.String getTemplateInfoPage() {
		return templateInfoPage;
	}
	public void setTemplateInfoPage(java.lang.String templateInfoPage) {
		this.templateInfoPage = templateInfoPage;
	}
	public java.lang.String getTemplateFlowPage() {
		return templateFlowPage;
	}
	public void setTemplateFlowPage(java.lang.String templateFlowPage) {
		this.templateFlowPage = templateFlowPage;
	}
	public java.lang.String getTemplateReportPage() {
		return templateReportPage;
	}
	public void setTemplateReportPage(java.lang.String templateReportPage) {
		this.templateReportPage = templateReportPage;
	}
	public java.util.Date getTemplateCreateDate() {
		return templateCreateDate;
	}
	public void setTemplateCreateDate(java.util.Date templateCreateDate) {
		this.templateCreateDate = templateCreateDate;
	}
	public java.lang.String getTemplateCreateUserName() {
		return templateCreateUserName;
	}
	public void setTemplateCreateUserName(java.lang.String templateCreateUserName) {
		this.templateCreateUserName = templateCreateUserName;
	}
	public java.util.Date getTemplateModifyDate() {
		return templateModifyDate;
	}
	public void setTemplateModifyDate(java.util.Date templateModifyDate) {
		this.templateModifyDate = templateModifyDate;
	}
	public java.lang.String getTemplateModifyUserName() {
		return templateModifyUserName;
	}
	public void setTemplateModifyUserName(java.lang.String templateModifyUserName) {
		this.templateModifyUserName = templateModifyUserName;
	}
	public java.lang.String getTemplateDescription() {
		return templateDescription;
	}
	public void setTemplateDescription(java.lang.String templateDescription) {
		this.templateDescription = templateDescription;
	}
	
}