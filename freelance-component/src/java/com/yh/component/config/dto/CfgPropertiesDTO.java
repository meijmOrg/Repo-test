/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-12-21
**/
package com.yh.component.config.dto;

public class CfgPropertiesDTO {

	private java.lang.Long  	cfgPropertiesOid;	//主键
	private java.lang.String	cfgPropertiesType;	//所属模块代码 1：业务办理 2：信息管理（校核）（单位、人员）3：工资管理 4：岗位管理 5：系统管理 6：报表 99：其他
	private java.lang.String	cfgPropertiesCode;	//配置项的KEY值
	private java.lang.String	cfgPropertiesValue;	//配置项的VALUE值
	private java.lang.String	cfgPropertiesDesc;	//配置项的描述
	private java.lang.String	isActive;	//是否激活
	private java.lang.String	createdByCode;	//创建者CODE
	private java.lang.String	createdByName;	//创建者
	private java.util.Date  	createdDate;	//创建时间

	public CfgPropertiesDTO() {
		
	}

	public void setCfgPropertiesOid(java.lang.Long cfgPropertiesOid){
		this.cfgPropertiesOid = cfgPropertiesOid;
	}

	public java.lang.Long getCfgPropertiesOid(){
		return this.cfgPropertiesOid;
	}

	public void setCfgPropertiesType(java.lang.String cfgPropertiesType){
		this.cfgPropertiesType = cfgPropertiesType;
	}

	public java.lang.String getCfgPropertiesType(){
		return this.cfgPropertiesType;
	}

	public void setCfgPropertiesCode(java.lang.String cfgPropertiesCode){
		this.cfgPropertiesCode = cfgPropertiesCode;
	}

	public java.lang.String getCfgPropertiesCode(){
		return this.cfgPropertiesCode;
	}

	public void setCfgPropertiesValue(java.lang.String cfgPropertiesValue){
		this.cfgPropertiesValue = cfgPropertiesValue;
	}

	public java.lang.String getCfgPropertiesValue(){
		return this.cfgPropertiesValue;
	}

	public void setCfgPropertiesDesc(java.lang.String cfgPropertiesDesc){
		this.cfgPropertiesDesc = cfgPropertiesDesc;
	}

	public java.lang.String getCfgPropertiesDesc(){
		return this.cfgPropertiesDesc;
	}

	public void setIsActive(java.lang.String isActive){
		this.isActive = isActive;
	}

	public java.lang.String getIsActive(){
		return this.isActive;
	}

	public void setCreatedByCode(java.lang.String createdByCode){
		this.createdByCode = createdByCode;
	}

	public java.lang.String getCreatedByCode(){
		return this.createdByCode;
	}

	public void setCreatedByName(java.lang.String createdByName){
		this.createdByName = createdByName;
	}

	public java.lang.String getCreatedByName(){
		return this.createdByName;
	}

	public void setCreatedDate(java.util.Date createdDate){
		this.createdDate = createdDate;
	}

	public java.util.Date getCreatedDate(){
		return this.createdDate;
	}

}
