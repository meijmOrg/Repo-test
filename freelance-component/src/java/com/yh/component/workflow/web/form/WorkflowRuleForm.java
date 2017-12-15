package com.yh.component.workflow.web.form;

import org.apache.struts.action.ActionForm;


/**
 * 流程规则信息Form
 * @author liul
 *@createDate 2017-11-29
 */
public class WorkflowRuleForm extends ActionForm{

	private static final long serialVersionUID = -4896429300799106563L;
	private java.lang.String  	ruleId;	//主键
	private java.lang.String	flowId;	//流程基本信息ID
	private java.lang.String  	ruleName;	//规则名称
	private java.lang.Double	ruleOrder;	//规则序号
	private java.lang.String  	ruleCondition;	// 规则构造流转条件
	private java.lang.String	ruleBeginActId;	//前置活动
	private java.lang.String  	ruleEndActId;	//后置活动
	private java.lang.String 	ruleType;//规则类型
	private java.lang.String  	ruleSysType;	// 规则系统类型
	public java.lang.String getRuleId() {
		return ruleId;
	}
	public void setRuleId(java.lang.String ruleId) {
		this.ruleId = ruleId;
	}
	public java.lang.String getFlowId() {
		return flowId;
	}
	public void setFlowId(java.lang.String flowId) {
		this.flowId = flowId;
	}
	public java.lang.String getRuleName() {
		return ruleName;
	}
	public void setRuleName(java.lang.String ruleName) {
		this.ruleName = ruleName;
	}
	public java.lang.Double getRuleOrder() {
		return ruleOrder;
	}
	public void setRuleOrder(java.lang.Double ruleOrder) {
		this.ruleOrder = ruleOrder;
	}
	public java.lang.String getRuleCondition() {
		return ruleCondition;
	}
	public void setRuleCondition(java.lang.String ruleCondition) {
		this.ruleCondition = ruleCondition;
	}
	public java.lang.String getRuleBeginActId() {
		return ruleBeginActId;
	}
	public void setRuleBeginActId(java.lang.String ruleBeginActId) {
		this.ruleBeginActId = ruleBeginActId;
	}
	public java.lang.String getRuleEndActId() {
		return ruleEndActId;
	}
	public void setRuleEndActId(java.lang.String ruleEndActId) {
		this.ruleEndActId = ruleEndActId;
	}
	public java.lang.String getRuleType() {
		return ruleType;
	}
	public void setRuleType(java.lang.String ruleType) {
		this.ruleType = ruleType;
	}
	public java.lang.String getRuleSysType() {
		return ruleSysType;
	}
	public void setRuleSysType(java.lang.String ruleSysType) {
		this.ruleSysType = ruleSysType;
	}

}
