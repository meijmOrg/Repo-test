/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-08-23
**/
package com.yh.admin.bo;

import com.yh.platform.core.bo.BaseBo;

public class SubSystem extends BaseBo {
	private static final long serialVersionUID = 5889743215741951331L;
	
	private java.lang.String	subSystemCode;	//系统名称
	private java.lang.String	subSystemName;	//子系统名称
	private java.lang.String	subSystemDesc;	//子系统描述
	private java.lang.String	subSystemLocation;	//子系统路径
	private java.lang.Long	orderOfView;	//显示顺序

	public SubSystem() {
		
	}

	public void setSubSystemCode(java.lang.String subSystemCode){
		this.subSystemCode = subSystemCode;
	}

	public java.lang.String getSubSystemCode(){
		return this.subSystemCode;
	}

	public void setSubSystemName(java.lang.String subSystemName){
		this.subSystemName = subSystemName;
	}

	public java.lang.String getSubSystemName(){
		return this.subSystemName;
	}

	public void setSubSystemDesc(java.lang.String subSystemDesc){
		this.subSystemDesc = subSystemDesc;
	}

	public java.lang.String getSubSystemDesc(){
		return this.subSystemDesc;
	}

	public void setSubSystemLocation(java.lang.String subSystemLocation){
		this.subSystemLocation = subSystemLocation;
	}

	public java.lang.String getSubSystemLocation(){
		return this.subSystemLocation;
	}

	public void setOrderOfView(java.lang.Long orderOfView){
		this.orderOfView = orderOfView;
	}

	public java.lang.Long getOrderOfView(){
		return this.orderOfView;
	}

}
