package com.yh.component.workflow.vo;

import java.util.ArrayList;
import java.util.List;

public class DrawingFlow{

	private List<DrawingBaseInfo> dbiList = new ArrayList<DrawingBaseInfo>(); // 活动
	private List<DrawingFlowRule> dfrList = new ArrayList<DrawingFlowRule>(); // 规则
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

}
