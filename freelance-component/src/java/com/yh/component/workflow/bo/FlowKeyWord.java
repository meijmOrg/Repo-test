package com.yh.component.workflow.bo;


import com.yh.platform.core.bo.BaseBo;

/**
 * 关键字Bo
 * @author liul
 *@createDate 2017-12-28
 */
public class FlowKeyWord extends BaseBo{

	private static final long serialVersionUID = -7490431685119519323L;
	private java.lang.String kwId;//关键字唯一ID
	private java.lang.String kwCode;//关键字编码
	private java.lang.String kwDescription;//关键字描述
	private java.lang.String kwType;//关键字类型
	private java.lang.String kwStatus;//关键字状态
	public java.lang.String getKwId() {
		return kwId;
	}
	public void setKwId(java.lang.String kwId) {
		this.kwId = kwId;
	}
	public java.lang.String getKwCode() {
		return kwCode;
	}
	public void setKwCode(java.lang.String kwCode) {
		this.kwCode = kwCode;
	}
	public java.lang.String getKwDescription() {
		return kwDescription;
	}
	public void setKwDescription(java.lang.String kwDescription) {
		this.kwDescription = kwDescription;
	}
	public java.lang.String getKwType() {
		return kwType;
	}
	public void setKwType(java.lang.String kwType) {
		this.kwType = kwType;
	}
	public java.lang.String getKwStatus() {
		return kwStatus;
	}
	public void setKwStatus(java.lang.String kwStatus) {
		this.kwStatus = kwStatus;
	}
	
}
