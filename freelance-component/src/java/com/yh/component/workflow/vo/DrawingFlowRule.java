package com.yh.component.workflow.vo;

import com.alibaba.fastjson.JSONArray;


public class DrawingFlowRule{
	
	private String id; // 
	private String from;
	private String to;
	private JSONArray dot;
	private DrawingFlowRuleText text;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public JSONArray getDot() {
		return dot;
	}
	public void setDot(JSONArray dot) {
		this.dot = dot;
	}
	public DrawingFlowRuleText getText() {
		return text;
	}
	public void setText(DrawingFlowRuleText text) {
		this.text = text;
	}

}
