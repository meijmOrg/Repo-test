/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-13
**/
package com.yh.hr.res.pb.bo;

import com.yh.platform.core.bo.BaseBo;

public class PbRetrieInfo extends BaseBo {
	private static final long serialVersionUID = 2515516587055227706L;

    /**
     *PersonOid
     **/
	private java.lang.Long personOid;
    /**
     *离退类别
     **/
	private java.lang.String retrieTypeCode;
    /**
     *离退日期
     **/
	private java.util.Date retrieDate;
    /**
     *提前退休原因
     **/
	private java.lang.String retrieReason;
    /**
     *离退后享受待遇级别
     **/
	private java.lang.String retireTreatmentLevelCode;
    /**
     *离退后享受待遇类别
     **/
	private java.lang.String retireTreatmentTypeCode;
    /**
     *离退休费比例
     **/
	private java.lang.Double retireFeeRatio;
    /**
     *离退休补助比例
     **/
	private java.lang.Double retireAllowanceRatio;
    /**
     *离退休费支付单位
     **/
	private java.lang.String retirtPaymentUnit;
    /**
     *离退休后管理单位
     **/
	private java.lang.String retireManageUnit;
    /**
     *离退休批准机关
     **/
	private java.lang.String retritApproveUnit;
    /**
     *离退休批准文号
     **/
	private java.lang.String retrieApproveFileno;
    /**
     *离退休证号
     **/
	private java.lang.String retireNo;
    /**
     *有害工种增加工龄
     **/
	private java.lang.Long serviceYearsAdded;
    /**
     *特殊贡献比例
     **/
	private java.lang.Double specialContributionRatio;
    /**
     *特殊贡献标志
     **/
	private java.lang.String specialContributionFlag;
    /**
     *归侨加发比例
     **/
	private java.lang.Double returnedOverseasChiScale;
    /**
     *归国华侨标志
     **/
	private java.lang.String returnedOverseasFlag;
    /**
     *是否终身无子女YHRS0003
     **/
	private java.lang.String isNoChildForLife;
    /**
     *审批类型
     **/
	private java.lang.String approvalType;
    /**
     *审查部门
     **/
	private java.lang.String approvalUnit;
    /**
     *符合条例
     **/
	private java.lang.String compliedClause;
    /**
     *计生奖励
     **/
	private java.lang.String familyPlanningAward;
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

	public PbRetrieInfo() {}

    public PbRetrieInfo(java.lang.Long personOid) {
        this.personOid = personOid;
    }

	public void setPersonOid(java.lang.Long personOid){
		this.personOid = personOid;
	}

	public java.lang.Long getPersonOid(){
		return this.personOid;
	}

	public void setRetrieTypeCode(java.lang.String retrieTypeCode){
		this.retrieTypeCode = retrieTypeCode;
	}

	public java.lang.String getRetrieTypeCode(){
		return this.retrieTypeCode;
	}

	public void setRetrieDate(java.util.Date retrieDate){
		this.retrieDate = retrieDate;
	}

	public java.util.Date getRetrieDate(){
		return this.retrieDate;
	}

	public void setRetrieReason(java.lang.String retrieReason){
		this.retrieReason = retrieReason;
	}

	public java.lang.String getRetrieReason(){
		return this.retrieReason;
	}

	public void setRetireTreatmentLevelCode(java.lang.String retireTreatmentLevelCode){
		this.retireTreatmentLevelCode = retireTreatmentLevelCode;
	}

	public java.lang.String getRetireTreatmentLevelCode(){
		return this.retireTreatmentLevelCode;
	}

	public void setRetireTreatmentTypeCode(java.lang.String retireTreatmentTypeCode){
		this.retireTreatmentTypeCode = retireTreatmentTypeCode;
	}

	public java.lang.String getRetireTreatmentTypeCode(){
		return this.retireTreatmentTypeCode;
	}

	public void setRetireFeeRatio(java.lang.Double retireFeeRatio){
		this.retireFeeRatio = retireFeeRatio;
	}

	public java.lang.Double getRetireFeeRatio(){
		return this.retireFeeRatio;
	}

	public void setRetireAllowanceRatio(java.lang.Double retireAllowanceRatio){
		this.retireAllowanceRatio = retireAllowanceRatio;
	}

	public java.lang.Double getRetireAllowanceRatio(){
		return this.retireAllowanceRatio;
	}

	public void setRetirtPaymentUnit(java.lang.String retirtPaymentUnit){
		this.retirtPaymentUnit = retirtPaymentUnit;
	}

	public java.lang.String getRetirtPaymentUnit(){
		return this.retirtPaymentUnit;
	}

	public void setRetireManageUnit(java.lang.String retireManageUnit){
		this.retireManageUnit = retireManageUnit;
	}

	public java.lang.String getRetireManageUnit(){
		return this.retireManageUnit;
	}

	public void setRetritApproveUnit(java.lang.String retritApproveUnit){
		this.retritApproveUnit = retritApproveUnit;
	}

	public java.lang.String getRetritApproveUnit(){
		return this.retritApproveUnit;
	}

	public void setRetrieApproveFileno(java.lang.String retrieApproveFileno){
		this.retrieApproveFileno = retrieApproveFileno;
	}

	public java.lang.String getRetrieApproveFileno(){
		return this.retrieApproveFileno;
	}

	public void setRetireNo(java.lang.String retireNo){
		this.retireNo = retireNo;
	}

	public java.lang.String getRetireNo(){
		return this.retireNo;
	}

	public void setServiceYearsAdded(java.lang.Long serviceYearsAdded){
		this.serviceYearsAdded = serviceYearsAdded;
	}

	public java.lang.Long getServiceYearsAdded(){
		return this.serviceYearsAdded;
	}

	public void setSpecialContributionRatio(java.lang.Double specialContributionRatio){
		this.specialContributionRatio = specialContributionRatio;
	}

	public java.lang.Double getSpecialContributionRatio(){
		return this.specialContributionRatio;
	}

	public void setSpecialContributionFlag(java.lang.String specialContributionFlag){
		this.specialContributionFlag = specialContributionFlag;
	}

	public java.lang.String getSpecialContributionFlag(){
		return this.specialContributionFlag;
	}

	public void setReturnedOverseasChiScale(java.lang.Double returnedOverseasChiScale){
		this.returnedOverseasChiScale = returnedOverseasChiScale;
	}

	public java.lang.Double getReturnedOverseasChiScale(){
		return this.returnedOverseasChiScale;
	}

	public void setReturnedOverseasFlag(java.lang.String returnedOverseasFlag){
		this.returnedOverseasFlag = returnedOverseasFlag;
	}

	public java.lang.String getReturnedOverseasFlag(){
		return this.returnedOverseasFlag;
	}

	public void setIsNoChildForLife(java.lang.String isNoChildForLife){
		this.isNoChildForLife = isNoChildForLife;
	}

	public java.lang.String getIsNoChildForLife(){
		return this.isNoChildForLife;
	}

	public void setApprovalType(java.lang.String approvalType){
		this.approvalType = approvalType;
	}

	public java.lang.String getApprovalType(){
		return this.approvalType;
	}

	public void setApprovalUnit(java.lang.String approvalUnit){
		this.approvalUnit = approvalUnit;
	}

	public java.lang.String getApprovalUnit(){
		return this.approvalUnit;
	}

	public void setCompliedClause(java.lang.String compliedClause){
		this.compliedClause = compliedClause;
	}

	public java.lang.String getCompliedClause(){
		return this.compliedClause;
	}

	public void setFamilyPlanningAward(java.lang.String familyPlanningAward){
		this.familyPlanningAward = familyPlanningAward;
	}

	public java.lang.String getFamilyPlanningAward(){
		return this.familyPlanningAward;
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