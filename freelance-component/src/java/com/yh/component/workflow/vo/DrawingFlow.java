package com.yh.component.workflow.vo;

import java.util.ArrayList;
import java.util.List;

public class DrawingFlow{

	private List<DrawingBaseInfo> dbiList = new ArrayList<DrawingBaseInfo>(); // 活动
	private List<DrawingFlowRule> dfrList = new ArrayList<DrawingFlowRule>(); // 规则
	private String templateId; // 模板Id
	private String flowId; // 流程ID
	private String flowName; // 流程名称
	private String flowType; // 流程类型
	private Long flowOrgOid;
	private String flowOrgName;
	public List<DrawingBaseInfo> getDbiList() {
		return dbiList;
	}
	public void setDbiList(List<DrawingBaseInfo> dbiList) {
		this.dbiList = dbiList;
	}
	public List<DrawingFlowRule> getDfrList() {
		return dfrList;
	}
	public void setDfrList(List<DrawingFlowRule> dfrList) {
		this.dfrList = dfrList;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	public Long getFlowOrgOid() {
		return flowOrgOid;
	}
	public void setFlowOrgOid(Long flowOrgOid) {
		this.flowOrgOid = flowOrgOid;
	}
	public String getFlowOrgName() {
		return flowOrgName;
	}
	public void setFlowOrgName(String flowOrgName) {
		this.flowOrgName = flowOrgName;
	}
	
}
