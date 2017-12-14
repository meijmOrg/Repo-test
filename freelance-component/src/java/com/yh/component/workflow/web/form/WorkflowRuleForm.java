package com.yh.component.workflow.web.form;

import org.apache.struts.action.ActionForm;


/**
 * 流程规则信息Form
 * @author liul
 *@createDate 2017-11-29
 */
public class WorkflowRuleForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2635328054370876449L;
	private java.lang.Long  	ruleId;	//主键
	private java.lang.Long		baseInfoId;	//流程基本信息ID
	private java.lang.String  	ruleName;	//规则名称
	private java.lang.String	ruleIndex;	//规则序号
	private java.lang.String	preActivity;	//前置活动
	private java.lang.String  	succeedActivity;	//后置活动
	private java.lang.String 	ruleType;//规则类型
	public java.lang.Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.Long ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.Long getBaseInfoId() {
		return baseInfoId;
	}
	public void setBaseInfoId(java.lang.Long baseInfoId) {
		this.baseInfoId = baseInfoId;
	}
	public java.lang.String getRuleName() {
		return ruleName;
	}
	public void setRuleName(java.lang.String ruleName) {
		this.ruleName = ruleName;
	}
	public java.lang.String getRuleIndex() {
		return ruleIndex;
	}
	public void setRuleIndex(java.lang.String ruleIndex) {
		this.ruleIndex = ruleIndex;
	}
	public java.lang.String getPreActivity() {
		return preActivity;
	}
	public void setPreActivity(java.lang.String preActivity) {
		this.preActivity = preActivity;
	}
	public java.lang.String getSucceedActivity() {
		return succeedActivity;
	}
	public void setSucceedActivity(java.lang.String succeedActivity) {
		this.succeedActivity = succeedActivity;
	}
	public java.lang.String getRuleType() {
		return ruleType;
	}
	public void setRuleType(java.lang.String ruleType) {
		this.ruleType = ruleType;
	}

}
