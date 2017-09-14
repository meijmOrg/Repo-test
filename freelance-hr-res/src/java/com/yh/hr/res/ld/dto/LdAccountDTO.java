/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-08-22
**/
package com.yh.hr.res.ld.dto;

/**
 * 领导职数账户DTO
 * @author liuhw
 * 2016-8-24
 */
public class LdAccountDTO{
    /**
     *主建
     **/
	private java.lang.Long accountOid;
    /**
     *账户名称
     **/
	private java.lang.String accountName;
    /**
     *账户类型：1：单位，2区：3内设机构，99其它等
     **/
	private java.lang.String accountType;
    /**
     *账户代码 可为OID
     **/
	private java.lang.String accountCode;
    /**
     *创建人Code
     **/
	private java.lang.String createdByCode;
    /**
     *创建人名称
     **/
	private java.lang.String createdByName;
    /**
     *创建日期
     **/
	private java.util.Date createdDate;

	public LdAccountDTO() {}

    public LdAccountDTO(java.lang.Long accountOid) {
        this.accountOid = accountOid;
    }

	public void setAccountOid(java.lang.Long accountOid){
		this.accountOid = accountOid;
	}

	public java.lang.Long getAccountOid(){
		return this.accountOid;
	}

	public void setAccountName(java.lang.String accountName){
		this.accountName = accountName;
	}

	public java.lang.String getAccountName(){
		return this.accountName;
	}

	public void setAccountType(java.lang.String accountType){
		this.accountType = accountType;
	}

	public java.lang.String getAccountType(){
		return this.accountType;
	}

	public void setAccountCode(java.lang.String accountCode){
		this.accountCode = accountCode;
	}

	public java.lang.String getAccountCode(){
		return this.accountCode;
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
