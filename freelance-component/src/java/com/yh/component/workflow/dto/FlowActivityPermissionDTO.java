package com.yh.component.workflow.dto;


import java.util.ArrayList;

import com.yh.component.workflow.bo.FlowActivityPerCombination;
import com.yh.platform.core.bo.BaseBo;

/**
 * 流程活动信息-权限控制DTO
 * @author liul
 *@createDate 2017-12-29
 */
public class FlowActivityPermissionDTO extends BaseBo{

	private static final long serialVersionUID = -5874863888823810395L;
	private java.lang.String apId;//活动单元权限配置唯一ID
	private java.lang.String actId;//活动单元ID
	private java.lang.String apCancoordination;//是否可以协同
	private java.lang.String apCanFinish;//是否可以结束
	private java.lang.String apCanSkip;//是否允许跳过
	private java.lang.String apCanCarbanCopy;//是否允许抄送
	private java.lang.String apCanRetroactive;//是否允许补签
	private java.lang.String apUserType;//操作者组合方式
	
	private java.util.List<FlowActivityPerCombination> pcList = new ArrayList<FlowActivityPerCombination>();
	public java.lang.String getApId() {
		return apId;
	}
	public void setApId(java.lang.String apId) {
		this.apId = apId;
	}
	public java.lang.String getActId() {
		return actId;
	}
	public void setActId(java.lang.String actId) {
		this.actId = actId;
	}
	public java.lang.String getApCancoordination() {
		return apCancoordination;
	}
	public void setApCancoordination(java.lang.String apCancoordination) {
		this.apCancoordination = apCancoordination;
	}
	public java.lang.String getApCanFinish() {
		return apCanFinish;
	}
	public void setApCanFinish(java.lang.String apCanFinish) {
		this.apCanFinish = apCanFinish;
	}
	public java.lang.String getApCanSkip() {
		return apCanSkip;
	}
	public void setApCanSkip(java.lang.String apCanSkip) {
		this.apCanSkip = apCanSkip;
	}
	public java.lang.String getApCanCarbanCopy() {
		return apCanCarbanCopy;
	}
	public void setApCanCarbanCopy(java.lang.String apCanCarbanCopy) {
		this.apCanCarbanCopy = apCanCarbanCopy;
	}
	public java.lang.String getApCanRetroactive() {
		return apCanRetroactive;
	}
	public void setApCanRetroactive(java.lang.String apCanRetroactive) {
		this.apCanRetroactive = apCanRetroactive;
	}
	public java.lang.String getApUserType() {
		return apUserType;
	}
	public void setApUserType(java.lang.String apUserType) {
		this.apUserType = apUserType;
	}
	public java.util.List<FlowActivityPerCombination> getPcList() {
		return pcList;
	}
	public void setPcList(java.util.List<FlowActivityPerCombination> pcList) {
		this.pcList = pcList;
	}
	
}
