package com.yh.component.workflow.vo;


public class DrawingBaseInfo{

	private String type; //  actType 活动单元类型-开始、结束、常规活动
	private String id; // actId
	private DrawingBaseInfoText text; // actName 活动单元名称
	private DrawingBaseInfoAttr attr; // 坐标
	private DrawingBaseInfoRuleProps ruleProps; // 活动属性
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DrawingBaseInfoText getText() {
		return text;
	}
	public void setText(DrawingBaseInfoText text) {
		this.text = text;
	}
	public DrawingBaseInfoAttr getAttr() {
		return attr;
	}
	public void setAttr(DrawingBaseInfoAttr attr) {
		this.attr = attr;
	}
	public DrawingBaseInfoRuleProps getRuleProps() {
		return ruleProps;
	}
	public void setRuleProps(DrawingBaseInfoRuleProps ruleProps) {
		this.ruleProps = ruleProps;
	}
	
}
