package com.yh.component.workflow.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * 模板流程关系表Bo
 * @author liul
 *@createDate 2017-12-14
 */
public class TemplateFlow extends BaseBo{

	private static final long serialVersionUID = -6416318501893867760L;
	private java.lang.String  	tfId;	//主键
	private java.lang.String	templateId;	//模板ID	
	private java.lang.String	flowId;	//流程唯一ID
	private java.lang.Long 		tfForbidden;//停用Or启用，默认启用，用于后期扩展
	public java.lang.String getTfId() {
		return tfId;
	}
	public void setTfId(java.lang.String tfId) {
		this.tfId = tfId;
	}
	public java.lang.String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(java.lang.String templateId) {
		this.templateId = templateId;
	}
	public java.lang.String getFlowId() {
		return flowId;
	}
	public void setFlowId(java.lang.String flowId) {
		this.flowId = flowId;
	}
	public java.lang.Long getTfForbidden() {
		return tfForbidden;
	}
	public void setTfForbidden(java.lang.Long tfForbidden) {
		this.tfForbidden = tfForbidden;
	}
	
}
