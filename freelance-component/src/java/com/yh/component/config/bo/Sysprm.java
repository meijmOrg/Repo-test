package com.yh.component.config.bo;

import com.yh.platform.core.bo.BaseBo;

public class Sysprm extends BaseBo implements java.io.Serializable{

	private static final long serialVersionUID = 548091461955815046L;
	private String sysConfName;
	private String sysConfDesc;
	private String sysConfValue;

	public Sysprm() {
	}

	public String getSysConfName() {
		return sysConfName;
	}

	public void setSysConfName(String sysConfName) {
		this.sysConfName = sysConfName;
	}

	public String getSysConfDesc() {
		return sysConfDesc;
	}

	public void setSysConfDesc(String sysConfDesc) {
		this.sysConfDesc = sysConfDesc;
	}

	public String getSysConfValue() {
		return sysConfValue;
	}

	public void setSysConfValue(String sysConfValue) {
		this.sysConfValue = sysConfValue;
	}


}