package com.yh.component.workflow.bo;


import com.yh.platform.core.bo.BaseBo;

/**
 * 流程活动信息-权限控制-权限组合Bo
 * @author liul
 *@createDate 2017-12-28
 */
public class FlowActivityPerCombination extends BaseBo{

	private static final long serialVersionUID = 5516682228051455311L;
	private java.lang.String pcId;//权限组合唯一ID
	private java.lang.String apId;//活动权限唯一ID
	private java.lang.String pcType;//组合类别-部门、小组、角色、岗位、职务、职务等级（表名）
	private java.lang.String pcFieldId;//组合值ID（表字段名）
	private java.lang.String pcFieldValue;//组合字段值（字段值）
	public java.lang.String getPcId() {
		return pcId;
	}
	public void setPcId(java.lang.String pcId) {
		this.pcId = pcId;
	}
	public java.lang.String getApId() {
		return apId;
	}
	public void setApId(java.lang.String apId) {
		this.apId = apId;
	}
	public java.lang.String getPcType() {
		return pcType;
	}
	public void setPcType(java.lang.String pcType) {
		this.pcType = pcType;
	}
	public java.lang.String getPcFieldId() {
		return pcFieldId;
	}
	public void setPcFieldId(java.lang.String pcFieldId) {
		this.pcFieldId = pcFieldId;
	}
	public java.lang.String getPcFieldValue() {
		return pcFieldValue;
	}
	public void setPcFieldValue(java.lang.String pcFieldValue) {
		this.pcFieldValue = pcFieldValue;
	}
	
}
