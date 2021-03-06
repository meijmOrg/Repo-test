/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-13
**/
package com.yh.hr.res.pb.bo;

import com.yh.platform.core.bo.BaseBo;

public class PbReviewInfo extends BaseBo {
	private static final long serialVersionUID = 2515516587055227706L;

    /**
     *业务库考核OID
     **/
	private java.lang.Long reviewOid;
    /**
     *PersonOid
     **/
	private java.lang.Long personOid;
    /**
     *考核类别
     **/
	private java.lang.String reviewTypeCode;
    /**
     *考核类别描述
     **/
	private java.lang.String reviewTypeName;
    /**
     *考核年度
     **/
	private java.util.Date reviewYear;
    /**
     *考核结论code
     **/
	private java.lang.Long reviewResultCode;
    /**
     *考核结论描述
     **/
	private java.lang.String reviewResultDesc;
    /**
     *考核日期
     **/
	private java.util.Date reviewDate;
    /**
     *考核时所在单位
     **/
	private java.lang.String reviewUnitOid;
    /**
     *备注
     **/
	private java.lang.String remark;
    /**
     *创建人ID
     **/
	private java.lang.String createBy;
    /**
     *创建人名称
     **/
	private java.lang.String createName;
    /**
     *创建时间
     **/
	private java.util.Date createDate;
    /**
     *修改人ID
     **/
	private java.lang.String updateBy;
    /**
     *修改人名称
     **/
	private java.lang.String updateName;
    /**
     *修改时间
     **/
	private java.util.Date updateDate;

	public PbReviewInfo() {}

    public PbReviewInfo(java.lang.Long reviewOid) {
        this.reviewOid = reviewOid;
    }

	public void setReviewOid(java.lang.Long reviewOid){
		this.reviewOid = reviewOid;
	}

	public java.lang.Long getReviewOid(){
		return this.reviewOid;
	}

	public void setPersonOid(java.lang.Long personOid){
		this.personOid = personOid;
	}

	public java.lang.Long getPersonOid(){
		return this.personOid;
	}

	public void setReviewTypeCode(java.lang.String reviewTypeCode){
		this.reviewTypeCode = reviewTypeCode;
	}

	public java.lang.String getReviewTypeCode(){
		return this.reviewTypeCode;
	}

	public void setReviewTypeName(java.lang.String reviewTypeName){
		this.reviewTypeName = reviewTypeName;
	}

	public java.lang.String getReviewTypeName(){
		return this.reviewTypeName;
	}

	public void setReviewYear(java.util.Date reviewYear){
		this.reviewYear = reviewYear;
	}

	public java.util.Date getReviewYear(){
		return this.reviewYear;
	}

	public void setReviewResultCode(java.lang.Long reviewResultCode){
		this.reviewResultCode = reviewResultCode;
	}

	public java.lang.Long getReviewResultCode(){
		return this.reviewResultCode;
	}

	public void setReviewResultDesc(java.lang.String reviewResultDesc){
		this.reviewResultDesc = reviewResultDesc;
	}

	public java.lang.String getReviewResultDesc(){
		return this.reviewResultDesc;
	}

	public void setReviewDate(java.util.Date reviewDate){
		this.reviewDate = reviewDate;
	}

	public java.util.Date getReviewDate(){
		return this.reviewDate;
	}

	public void setReviewUnitOid(java.lang.String reviewUnitOid){
		this.reviewUnitOid = reviewUnitOid;
	}

	public java.lang.String getReviewUnitOid(){
		return this.reviewUnitOid;
	}

	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}

	public java.lang.String getRemark(){
		return this.remark;
	}

	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}

	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}

	public java.lang.String getCreateName(){
		return this.createName;
	}

	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}

	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}

	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}

	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}

	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

}
