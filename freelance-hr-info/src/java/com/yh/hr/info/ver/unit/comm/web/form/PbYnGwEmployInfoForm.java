/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.info.ver.unit.comm.web.form;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.ValidatorForm;

import com.yh.platform.core.util.DateUtil;

public class PbYnGwEmployInfoForm extends ValidatorForm {
	private static final long serialVersionUID = 110119120L;

	private java.lang.Long ynGwEmployOid;
	private java.lang.Long personOid;
	private Long unitOid;
	private java.lang.Long deptOid;
	private java.lang.String deptName;
	private java.lang.String hisPositionStatus;
	private java.lang.String hisWorkType;
	private java.lang.String hisPositionType;
	private java.lang.String hisPositionLevel;
	private java.lang.String hisPositionOid;        //岗位名称代码
	private java.lang.String hisPositionName;
	private java.util.Date hisBeginDate;
    private String hisBeginDateStr;
	private java.util.Date endDate;
    private String endDateStr;
	private java.util.Date endDateActual;
    private String endDateActualStr;
	private java.lang.String remark;
	private java.lang.String createBy;
	private java.lang.String createName;
	private java.util.Date createDate;
    private String createDateStr;
	private java.lang.String updateBy;
	private java.lang.String updateName;
	private java.util.Date updateDate;
    private String updateDateStr;
	private java.lang.String hisWorkTypeName;
	private java.lang.String hisPositionTypeName;
	private java.lang.String hisPositionLevelName;

	/**
	 * 职务属性
	 */
	private java.lang.String hisDutyAttribute;
	
	/**
	 * 是否兼职	0：否	1：是
	 */
	private java.lang.String isPartTime;
	/**
	 * 所聘职称编码YHRS0117
	 */
	private java.lang.String appointProfTitleCode;
	/**
	 * 所聘职称
	 */
	private java.lang.String appointProfTitleName;
	
	public PbYnGwEmployInfoForm() {}

    public void setYnGwEmployOid(java.lang.Long ynGwEmployOid){
		this.ynGwEmployOid = ynGwEmployOid;
	}

	public java.lang.Long getYnGwEmployOid(){
		return this.ynGwEmployOid;
	}
    public void setPersonOid(java.lang.Long personOid){
		this.personOid = personOid;
	}

	public java.lang.Long getPersonOid(){
		return this.personOid;
	}
	
    public Long getUnitOid() {
		return unitOid;
	}

	public void setUnitOid(Long unitOid) {
		this.unitOid = unitOid;
	}

	public void setDeptOid(java.lang.Long deptOid){
		this.deptOid = deptOid;
	}

	public java.lang.Long getDeptOid(){
		return this.deptOid;
	}
    public void setDeptName(java.lang.String deptName){
		this.deptName = deptName;
	}

	public java.lang.String getDeptName(){
		return this.deptName;
	}
    public void setHisPositionStatus(java.lang.String hisPositionStatus){
		this.hisPositionStatus = hisPositionStatus;
	}

	public java.lang.String getHisPositionStatus(){
		return this.hisPositionStatus;
	}
    public void setHisWorkType(java.lang.String hisWorkType){
		this.hisWorkType = hisWorkType;
	}

	public java.lang.String getHisWorkType(){
		return this.hisWorkType;
	}
    public void setHisPositionType(java.lang.String hisPositionType){
		this.hisPositionType = hisPositionType;
	}

	public java.lang.String getHisPositionType(){
		return this.hisPositionType;
	}
    public void setHisPositionLevel(java.lang.String hisPositionLevel){
		this.hisPositionLevel = hisPositionLevel;
	}

	public java.lang.String getHisPositionLevel(){
		return this.hisPositionLevel;
	}
	
    public java.lang.String getHisPositionOid() {
		return hisPositionOid;
	}

	public void setHisPositionOid(java.lang.String hisPositionOid) {
		this.hisPositionOid = hisPositionOid;
	}

	public void setHisPositionName(java.lang.String hisPositionName){
		this.hisPositionName = hisPositionName;
	}

	public java.lang.String getHisPositionName(){
		return this.hisPositionName;
	}
    public void setHisBeginDate(java.util.Date hisBeginDate){
		this.hisBeginDate = hisBeginDate;
		if(null != hisBeginDate){
			this.hisBeginDateStr = DateUtil.format(hisBeginDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getHisBeginDate(){
		return this.hisBeginDate;
	}
    public void setHisBeginDateStr(String hisBeginDateStr){
        this.hisBeginDateStr = hisBeginDateStr;
        if(StringUtils.isNotEmpty(hisBeginDateStr)){
               this.hisBeginDate = DateUtil.parse(hisBeginDateStr, "yyyy-MM-dd");
        }
    }

    public String getHisBeginDateStr(){
        return this.hisBeginDateStr;
    }
    public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
		if(null != endDate){
			this.endDateStr = DateUtil.format(endDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getEndDate(){
		return this.endDate;
	}
    public void setEndDateStr(String endDateStr){
        this.endDateStr = endDateStr;
        if(StringUtils.isNotEmpty(endDateStr)){
               this.endDate = DateUtil.parse(endDateStr, "yyyy-MM-dd");
        }
    }

    public String getEndDateStr(){
        return this.endDateStr;
    }
    public void setEndDateActual(java.util.Date endDateActual){
		this.endDateActual = endDateActual;
		if(null != endDateActual){
			this.endDateActualStr = DateUtil.format(endDateActual, "yyyy-MM-dd");
         }
	}

	public java.util.Date getEndDateActual(){
		return this.endDateActual;
	}
    public void setEndDateActualStr(String endDateActualStr){
        this.endDateActualStr = endDateActualStr;
        if(StringUtils.isNotEmpty(endDateActualStr)){
               this.endDateActual = DateUtil.parse(endDateActualStr, "yyyy-MM-dd");
        }
    }

    public String getEndDateActualStr(){
        return this.endDateActualStr;
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
		if(null != createDate){
			this.createDateStr = DateUtil.format(createDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getCreateDate(){
		return this.createDate;
	}
    public void setCreateDateStr(String createDateStr){
        this.createDateStr = createDateStr;
        if(StringUtils.isNotEmpty(createDateStr)){
               this.createDate = DateUtil.parse(createDateStr, "yyyy-MM-dd");
        }
    }

    public String getCreateDateStr(){
        return this.createDateStr;
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
		if(null != updateDate){
			this.updateDateStr = DateUtil.format(updateDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}
    public void setUpdateDateStr(String updateDateStr){
        this.updateDateStr = updateDateStr;
        if(StringUtils.isNotEmpty(updateDateStr)){
               this.updateDate = DateUtil.parse(updateDateStr, "yyyy-MM-dd");
        }
    }
    public String getUpdateDateStr(){
        return this.updateDateStr;
    }
    
	public java.lang.String getHisWorkTypeName() {
		return hisWorkTypeName;
	}

	public void setHisWorkTypeName(java.lang.String hisWorkTypeName) {
		this.hisWorkTypeName = hisWorkTypeName;
	}

	public java.lang.String getHisPositionTypeName() {
		return hisPositionTypeName;
	}

	public void setHisPositionTypeName(java.lang.String hisPositionTypeName) {
		this.hisPositionTypeName = hisPositionTypeName;
	}

	public java.lang.String getHisPositionLevelName() {
		return hisPositionLevelName;
	}

	public void setHisPositionLevelName(java.lang.String hisPositionLevelName) {
		this.hisPositionLevelName = hisPositionLevelName;
	}

	public java.lang.String getHisDutyAttribute() {
		return hisDutyAttribute;
	}

	public void setHisDutyAttribute(java.lang.String hisDutyAttribute) {
		this.hisDutyAttribute = hisDutyAttribute;
	}

	public java.lang.String getIsPartTime() {
		return isPartTime;
	}

	public void setIsPartTime(java.lang.String isPartTime) {
		this.isPartTime = isPartTime;
	}

	public java.lang.String getAppointProfTitleCode() {
		return appointProfTitleCode;
	}

	public void setAppointProfTitleCode(java.lang.String appointProfTitleCode) {
		this.appointProfTitleCode = appointProfTitleCode;
	}

	public java.lang.String getAppointProfTitleName() {
		return appointProfTitleName;
	}

	public void setAppointProfTitleName(java.lang.String appointProfTitleName) {
		this.appointProfTitleName = appointProfTitleName;
	}
	
	public void resetForm() {
		this.ynGwEmployOid = null;
		this.personOid = null;
		this.deptOid = null;
		this.deptName = null;
		this.hisPositionStatus = null;
		this.hisWorkType = null;
		this.hisPositionType = null;
		this.hisPositionLevel = null;
		this.hisPositionName = null;
		this.hisBeginDate = null;
        this.hisBeginDateStr = null;
        this.hisDutyAttribute=null;
		this.endDate = null;
        this.endDateStr = null;
		this.endDateActual = null;
        this.endDateActualStr = null;
		this.remark = null;
		this.createBy = null;
		this.createName = null;
		this.createDate = null;
        this.createDateStr = null;
		this.updateBy = null;
		this.updateName = null;
		this.updateDate = null;
        this.updateDateStr = null;
        
        this.isPartTime = null;
    	this.appointProfTitleCode = null;
    	this.appointProfTitleName = null;
	}

}
