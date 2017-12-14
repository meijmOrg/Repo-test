package com.yh.component.workflow.web.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;

/**
 * 动态字段控制表Form
 * @author liul
 *@createDate 2017-11-16
 */
public class WorkflowConfigurationForm extends ActionForm{

	private static final long serialVersionUID = 3096645104798285337L;
	private java.lang.Long  	templetId;	//主键 
	private java.lang.String	templetName;	//模板名称	
	private java.lang.String  	templetCode;	//编码
	private java.lang.String	templetType;	//模板分类
	private java.lang.String	flowProcessPage;	//流程处理页面
	private java.lang.String  	synergyProcessPage;	//协同处理页面
	private java.lang.String 	documentEditPage;//文档编辑页面
	private java.lang.String    documentDetailPage;//文档详细页面
	private java.lang.String    documentPrintPage;//文档打印页面
	private List<WorkflowBaseInfoDTO> baseInfoList = new ArrayList<WorkflowBaseInfoDTO>();
	public java.lang.Long getTempletId() {
		return templetId;
	}
	public void setTempletId(java.lang.Long templetId) {
		this.templetId = templetId;
	}
	public java.lang.String getTempletName() {
		return templetName;
	}
	public void setTempletName(java.lang.String templetName) {
		this.templetName = templetName;
	}
	public java.lang.String getTempletCode() {
		return templetCode;
	}
	public void setTempletCode(java.lang.String templetCode) {
		this.templetCode = templetCode;
	}
	public java.lang.String getTempletType() {
		return templetType;
	}
	public void setTempletType(java.lang.String templetType) {
		this.templetType = templetType;
	}
	public java.lang.String getFlowProcessPage() {
		return flowProcessPage;
	}
	public void setFlowProcessPage(java.lang.String flowProcessPage) {
		this.flowProcessPage = flowProcessPage;
	}
	public java.lang.String getSynergyProcessPage() {
		return synergyProcessPage;
	}
	public void setSynergyProcessPage(java.lang.String synergyProcessPage) {
		this.synergyProcessPage = synergyProcessPage;
	}
	public java.lang.String getDocumentEditPage() {
		return documentEditPage;
	}
	public void setDocumentEditPage(java.lang.String documentEditPage) {
		this.documentEditPage = documentEditPage;
	}
	public java.lang.String getDocumentDetailPage() {
		return documentDetailPage;
	}
	public void setDocumentDetailPage(java.lang.String documentDetailPage) {
		this.documentDetailPage = documentDetailPage;
	}
	public java.lang.String getDocumentPrintPage() {
		return documentPrintPage;
	}
	public void setDocumentPrintPage(java.lang.String documentPrintPage) {
		this.documentPrintPage = documentPrintPage;
	}
	public List<WorkflowBaseInfoDTO> getBaseInfoList() {
		return baseInfoList;
	}
	public void setBaseInfoList(List<WorkflowBaseInfoDTO> baseInfoList) {
		this.baseInfoList = baseInfoList;
	}

}
