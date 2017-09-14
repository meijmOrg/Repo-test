/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.res.pb.bo;

import com.yh.platform.core.bo.BaseBo;

public class PbSyGwEmployInfo extends BaseBo {
	private static final long serialVersionUID = 2515516587055227706L;

    /**
     *主键
     **/
	private java.lang.Long syGwEmployOid;
    /**
     *PersonOid
     **/
	private java.lang.Long personOid;
    /**
     *聘任单位名称
     **/
	private java.lang.String dutyUnitName;
    /**
     *聘任单位OID
     **/
	private java.lang.Long dutyUnitOid;
    /**
     *内设机构名称
     **/
	private java.lang.String deptName;
    /**
     *内设机构OID
     **/
	private java.lang.Long deptOid;
    /**
     *岗位聘任状态
     **/
	private java.lang.String positioningStatus;
    /**
     *岗位类别
     **/
	private java.lang.String positionType;
    /**
     *岗位级别
     **/
	private java.lang.String positionLevel;
    /**
     *岗位名称
     **/
	private java.lang.String positionName;
    /**
     *岗位聘任开始时间
     **/
	private java.util.Date beginDate;
    /**
     *岗位聘任拟截止时间
     **/
	private java.util.Date endDate;
    /**
     *岗位聘任实际截止时间
     **/
	private java.util.Date endDateActual;
    /**
     *是否主岗位
     **/
	private java.lang.String isMPosition;
    /**
     *备注
     **/
	private java.lang.String remark;
    /**
     *职务类型
     **/
	private java.lang.String dutyRecordType;
	/**
     *职务属性
     **/
	private java.lang.String dutyAttribute;
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

	public PbSyGwEmployInfo() {}

    public PbSyGwEmployInfo(java.lang.Long syGwEmployOid) {
        this.syGwEmployOid = syGwEmployOid;
    }

	public void setSyGwEmployOid(java.lang.Long syGwEmployOid){
		this.syGwEmployOid = syGwEmployOid;
	}

	public java.lang.Long getSyGwEmployOid(){
		return this.syGwEmployOid;
	}

	public void setPersonOid(java.lang.Long personOid){
		this.personOid = personOid;
	}

	public java.lang.Long getPersonOid(){
		return this.personOid;
	}

	public void setDutyUnitName(java.lang.String dutyUnitName){
		this.dutyUnitName = dutyUnitName;
	}

	public java.lang.String getDutyUnitName(){
		return this.dutyUnitName;
	}

	public void setDutyUnitOid(java.lang.Long dutyUnitOid){
		this.dutyUnitOid = dutyUnitOid;
	}

	public java.lang.Long getDutyUnitOid(){
		return this.dutyUnitOid;
	}

	public void setDeptName(java.lang.String deptName){
		this.deptName = deptName;
	}

	public java.lang.String getDeptName(){
		return this.deptName;
	}

	public void setDeptOid(java.lang.Long deptOid){
		this.deptOid = deptOid;
	}

	public java.lang.Long getDeptOid(){
		return this.deptOid;
	}

	public void setPositioningStatus(java.lang.String positioningStatus){
		this.positioningStatus = positioningStatus;
	}

	public java.lang.String getPositioningStatus(){
		return this.positioningStatus;
	}

	public void setPositionType(java.lang.String positionType){
		this.positionType = positionType;
	}

	public java.lang.String getPositionType(){
		return this.positionType;
	}

	public void setPositionLevel(java.lang.String positionLevel){
		this.positionLevel = positionLevel;
	}

	public java.lang.String getPositionLevel(){
		return this.positionLevel;
	}

	public void setPositionName(java.lang.String positionName){
		this.positionName = positionName;
	}

	public java.lang.String getPositionName(){
		return this.positionName;
	}

	public void setBeginDate(java.util.Date beginDate){
		this.beginDate = beginDate;
	}

	public java.util.Date getBeginDate(){
		return this.beginDate;
	}

	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}

	public java.util.Date getEndDate(){
		return this.endDate;
	}

	public void setEndDateActual(java.util.Date endDateActual){
		this.endDateActual = endDateActual;
	}

	public java.util.Date getEndDateActual(){
		return this.endDateActual;
	}

	public void setIsMPosition(java.lang.String isMPosition){
		this.isMPosition = isMPosition;
	}

	public java.lang.String getIsMPosition(){
		return this.isMPosition;
	}

	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}

	public java.lang.String getRemark(){
		return this.remark;
	}

	public void setDutyRecordType(java.lang.String dutyRecordType){
		this.dutyRecordType = dutyRecordType;
	}

	public java.lang.String getDutyRecordType(){
		return this.dutyRecordType;
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

	public void setDutyAttribute(java.lang.String dutyAttribute) {
		this.dutyAttribute = dutyAttribute;
	}

	public java.lang.String getDutyAttribute() {
		return dutyAttribute;
	}

}
