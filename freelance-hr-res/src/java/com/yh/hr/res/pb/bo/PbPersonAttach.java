/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-19
**/
package com.yh.hr.res.pb.bo;

import com.yh.platform.core.bo.BaseBo;

public class PbPersonAttach extends BaseBo {
	private static final long serialVersionUID = 2515516587055227706L;

    /**
     *PersonOid
     **/
	private java.lang.Long personOid;
    /**
     *是否双肩挑
     **/
	private java.lang.String isTwoDuty;
    /**
     *岗位起始时间
     **/
	private java.util.Date positionDate;
    /**
     *主岗位名称
     **/
	private java.lang.String mPositionName;
    /**
     *现聘岗位类别（主）YHRS0022
     **/
	private java.lang.String mPositionType;
    /**
     *现聘岗位级别（主）YHRS0023
     **/
	private java.lang.String mPositionLevel;
    /**
     *现聘岗位级别起始时间（主）
     **/
	private java.util.Date mPositionLevelDate;
    /**
     *辅岗位名称
     **/
	private java.lang.String sPositionName;
    /**
     *现聘岗位类别（副）YHRS0022
     **/
	private java.lang.String sPositionType;
    /**
     *现聘岗位级别（副）YHRS0023
     **/
	private java.lang.String sPositionLevel;
    /**
     *现聘岗位级别起始时间（副）
     **/
	private java.util.Date sPositionLevelDate;
    /**
     *全日制最高学校名称
     **/
	private java.lang.String ftSchoolName;
    /**
     *全日制最高专业名称
     **/
	private java.lang.String ftMajorName;
    /**
     *全日制最高学历代码YHRS0039
     **/
	private java.lang.String ftEducationLevelCode;
    /**
     *全日制最高学位代码YHRS0040
     **/
	private java.lang.String ftDegreeCode;
    /**
     *在职最高学校名称
     **/
	private java.lang.String ojSchoolName;
    /**
     *在职最高专业名称
     **/
	private java.lang.String ojMajorName;
    /**
     *在职最高学历代码YHRS0039
     **/
	private java.lang.String ojEducationLevelCode;
    /**
     *在职最高学位代码YHRS0040
     **/
	private java.lang.String ojDegreeCode;
    /**
     *护士层级
     **/
	private java.lang.String levelCode;
    /**
     *专业技术资格证书编号
     **/
	private java.lang.String profCertificateNo;
    /**
     *专业技术资格名称
     **/
	private java.lang.String profTechName;
    /**
     *专业技术资格等级
     **/
	private java.lang.String profTechLevel;
    /**
     *职务级别起始时间
     **/
	private java.lang.String specialityName;
    /**
     *专业技术资格取得日期
     **/
	private java.util.Date profProcureDate;
    /**
     *职业资格证书编号
     **/
	private java.lang.String certificateNo;
    /**
     *职业资格名称
     **/
	private java.lang.String qualificationsName;
    /**
     *职（执）业资格等级
     **/
	private java.lang.String qualificationsLevelCode;
    /**
     *职业（工种）名称
     **/
	private java.lang.String skillWorkCode;
    /**
     *职业资格取得日期
     **/
	private java.util.Date procureDate;
    /**
     *政治面貌
     **/
	private java.lang.String politicStatusCode;
    /**
     *岗位聘任状态
     **/
	private java.lang.String hisPositionStatus;
    /**
     *岗位类别
     **/
	private java.lang.String hisPositionType;
    /**
     *岗位级别
     **/
	private java.lang.String hisPositionLevel;
    /**
     *岗位名称
     **/
	private java.lang.String hisPositionName;
    /**
     *岗位聘任开始时间
     **/
	private java.util.Date hisBeginDate;
	
	private java.lang.String hisDutyAttribute;
	/**
	 * 所聘职称编码YHRS0117
	 */
	private java.lang.String appointProfTitleCode;
	/**
     *执业资格类型
     **/
	private java.lang.String qualificationsType;
	
	/**
     * 现任职务
     **/
	private java.lang.String dutyName;
	/**
     * 现任职务开始时间
     **/
	private java.util.Date startDate;
	/**
     * 现任职务所在部门
     **/
	private java.lang.Long dutyDeptOid;
	
	/**
	 * 最高学历代码YHRS0039
	 */
	private java.lang.String educationLevelCode;
	
	/**
	 * 最高学位代码YHRS0040
	 */
	private java.lang.String degreeCode;
	
	 /**
     *EntryCurrentUnitType
     **/
	private java.lang.String entryCurrentUnitType;
    /**
     *EntryCurrentUnitDate
     **/
	private java.util.Date entryCurrentUnitDate;
	
	 /**
     *减员类型：1-辞职；2-辞退；3-调离；4-开除
     **/
	private java.lang.String personOutType;
    /**
     *离开日期
     **/
	private java.util.Date outDate;
	
	/**
     *死亡时间
     **/
	private java.util.Date deathDate;
    /**
     *死亡原因类别
     **/
	private java.lang.String deathType;
	
	 /**
     *离退类别
     **/
	private java.lang.String retrieTypeCode;
    /**
     *离退日期
     **/
	private java.util.Date retrieDate;

	public PbPersonAttach() {}
    
    public java.lang.String getQualificationsType() {
		return qualificationsType;
	}

	public void setQualificationsType(java.lang.String qualificationsType) {
		this.qualificationsType = qualificationsType;
	}

	public PbPersonAttach(java.lang.Long personOid) {
        this.personOid = personOid;
    }

	public void setPersonOid(java.lang.Long personOid){
		this.personOid = personOid;
	}

	public java.lang.Long getPersonOid(){
		return this.personOid;
	}

	public void setIsTwoDuty(java.lang.String isTwoDuty){
		this.isTwoDuty = isTwoDuty;
	}

	public java.lang.String getIsTwoDuty(){
		return this.isTwoDuty;
	}

	public void setPositionDate(java.util.Date positionDate){
		this.positionDate = positionDate;
	}

	public java.util.Date getPositionDate(){
		return this.positionDate;
	}

	public void setmPositionName(java.lang.String mPositionName){
		this.mPositionName = mPositionName;
	}

	public java.lang.String getmPositionName(){
		return this.mPositionName;
	}

	public void setmPositionType(java.lang.String mPositionType){
		this.mPositionType = mPositionType;
	}

	public java.lang.String getmPositionType(){
		return this.mPositionType;
	}

	public void setmPositionLevel(java.lang.String mPositionLevel){
		this.mPositionLevel = mPositionLevel;
	}

	public java.lang.String getmPositionLevel(){
		return this.mPositionLevel;
	}

	public void setmPositionLevelDate(java.util.Date mPositionLevelDate){
		this.mPositionLevelDate = mPositionLevelDate;
	}

	public java.util.Date getmPositionLevelDate(){
		return this.mPositionLevelDate;
	}

	public void setsPositionName(java.lang.String sPositionName){
		this.sPositionName = sPositionName;
	}

	public java.lang.String getsPositionName(){
		return this.sPositionName;
	}

	public void setsPositionType(java.lang.String sPositionType){
		this.sPositionType = sPositionType;
	}

	public java.lang.String getsPositionType(){
		return this.sPositionType;
	}

	public void setsPositionLevel(java.lang.String sPositionLevel){
		this.sPositionLevel = sPositionLevel;
	}

	public java.lang.String getsPositionLevel(){
		return this.sPositionLevel;
	}

	public void setsPositionLevelDate(java.util.Date sPositionLevelDate){
		this.sPositionLevelDate = sPositionLevelDate;
	}

	public java.util.Date getsPositionLevelDate(){
		return this.sPositionLevelDate;
	}

	public void setFtSchoolName(java.lang.String ftSchoolName){
		this.ftSchoolName = ftSchoolName;
	}

	public java.lang.String getFtSchoolName(){
		return this.ftSchoolName;
	}

	public void setFtMajorName(java.lang.String ftMajorName){
		this.ftMajorName = ftMajorName;
	}

	public java.lang.String getFtMajorName(){
		return this.ftMajorName;
	}

	public void setFtEducationLevelCode(java.lang.String ftEducationLevelCode){
		this.ftEducationLevelCode = ftEducationLevelCode;
	}

	public java.lang.String getFtEducationLevelCode(){
		return this.ftEducationLevelCode;
	}

	public void setFtDegreeCode(java.lang.String ftDegreeCode){
		this.ftDegreeCode = ftDegreeCode;
	}

	public java.lang.String getFtDegreeCode(){
		return this.ftDegreeCode;
	}

	public void setOjSchoolName(java.lang.String ojSchoolName){
		this.ojSchoolName = ojSchoolName;
	}

	public java.lang.String getOjSchoolName(){
		return this.ojSchoolName;
	}

	public void setOjMajorName(java.lang.String ojMajorName){
		this.ojMajorName = ojMajorName;
	}

	public java.lang.String getOjMajorName(){
		return this.ojMajorName;
	}

	public void setOjEducationLevelCode(java.lang.String ojEducationLevelCode){
		this.ojEducationLevelCode = ojEducationLevelCode;
	}

	public java.lang.String getOjEducationLevelCode(){
		return this.ojEducationLevelCode;
	}

	public void setOjDegreeCode(java.lang.String ojDegreeCode){
		this.ojDegreeCode = ojDegreeCode;
	}

	public java.lang.String getOjDegreeCode(){
		return this.ojDegreeCode;
	}

	public void setLevelCode(java.lang.String levelCode){
		this.levelCode = levelCode;
	}

	public java.lang.String getLevelCode(){
		return this.levelCode;
	}

	public void setProfCertificateNo(java.lang.String profCertificateNo){
		this.profCertificateNo = profCertificateNo;
	}

	public java.lang.String getProfCertificateNo(){
		return this.profCertificateNo;
	}

	public void setProfTechName(java.lang.String profTechName){
		this.profTechName = profTechName;
	}

	public java.lang.String getProfTechName(){
		return this.profTechName;
	}

	public void setProfTechLevel(java.lang.String profTechLevel){
		this.profTechLevel = profTechLevel;
	}

	public java.lang.String getProfTechLevel(){
		return this.profTechLevel;
	}

	public void setSpecialityName(java.lang.String specialityName){
		this.specialityName = specialityName;
	}

	public java.lang.String getSpecialityName(){
		return this.specialityName;
	}

	public void setProfProcureDate(java.util.Date profProcureDate){
		this.profProcureDate = profProcureDate;
	}

	public java.util.Date getProfProcureDate(){
		return this.profProcureDate;
	}

	public void setCertificateNo(java.lang.String certificateNo){
		this.certificateNo = certificateNo;
	}

	public java.lang.String getCertificateNo(){
		return this.certificateNo;
	}

	public void setQualificationsName(java.lang.String qualificationsName){
		this.qualificationsName = qualificationsName;
	}

	public java.lang.String getQualificationsName(){
		return this.qualificationsName;
	}

	public void setQualificationsLevelCode(java.lang.String qualificationsLevelCode){
		this.qualificationsLevelCode = qualificationsLevelCode;
	}

	public java.lang.String getQualificationsLevelCode(){
		return this.qualificationsLevelCode;
	}

	public void setSkillWorkCode(java.lang.String skillWorkCode){
		this.skillWorkCode = skillWorkCode;
	}

	public java.lang.String getSkillWorkCode(){
		return this.skillWorkCode;
	}

	public void setProcureDate(java.util.Date procureDate){
		this.procureDate = procureDate;
	}

	public java.util.Date getProcureDate(){
		return this.procureDate;
	}

	public void setPoliticStatusCode(java.lang.String politicStatusCode){
		this.politicStatusCode = politicStatusCode;
	}

	public java.lang.String getPoliticStatusCode(){
		return this.politicStatusCode;
	}

	public void setHisPositionStatus(java.lang.String hisPositionStatus){
		this.hisPositionStatus = hisPositionStatus;
	}

	public java.lang.String getHisPositionStatus(){
		return this.hisPositionStatus;
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

	public void setHisPositionName(java.lang.String hisPositionName){
		this.hisPositionName = hisPositionName;
	}

	public java.lang.String getHisPositionName(){
		return this.hisPositionName;
	}

	public void setHisBeginDate(java.util.Date hisBeginDate){
		this.hisBeginDate = hisBeginDate;
	}

	public java.util.Date getHisBeginDate(){
		return this.hisBeginDate;
	}

	public java.lang.String getAppointProfTitleCode() {
		return appointProfTitleCode;
	}

	public void setAppointProfTitleCode(java.lang.String appointProfTitleCode) {
		this.appointProfTitleCode = appointProfTitleCode;
	}

	public void setDutyName(java.lang.String dutyName) {
		this.dutyName = dutyName;
	}

	public java.lang.String getDutyName() {
		return dutyName;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setDutyDeptOid(java.lang.Long dutyDeptOid) {
		this.dutyDeptOid = dutyDeptOid;
	}

	public java.lang.Long getDutyDeptOid() {
		return dutyDeptOid;
	}

	public java.lang.String getEducationLevelCode() {
		return educationLevelCode;
	}

	public void setEducationLevelCode(java.lang.String educationLevelCode) {
		this.educationLevelCode = educationLevelCode;
	}

	public java.lang.String getDegreeCode() {
		return degreeCode;
	}

	public void setDegreeCode(java.lang.String degreeCode) {
		this.degreeCode = degreeCode;
	}

	public java.lang.String getEntryCurrentUnitType() {
		return entryCurrentUnitType;
	}

	public void setEntryCurrentUnitType(java.lang.String entryCurrentUnitType) {
		this.entryCurrentUnitType = entryCurrentUnitType;
	}

	public java.util.Date getEntryCurrentUnitDate() {
		return entryCurrentUnitDate;
	}

	public void setEntryCurrentUnitDate(java.util.Date entryCurrentUnitDate) {
		this.entryCurrentUnitDate = entryCurrentUnitDate;
	}

	public java.lang.String getPersonOutType() {
		return personOutType;
	}

	public void setPersonOutType(java.lang.String personOutType) {
		this.personOutType = personOutType;
	}

	public java.util.Date getOutDate() {
		return outDate;
	}

	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}

	public java.util.Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(java.util.Date deathDate) {
		this.deathDate = deathDate;
	}

	public java.lang.String getDeathType() {
		return deathType;
	}

	public void setDeathType(java.lang.String deathType) {
		this.deathType = deathType;
	}

	public java.lang.String getRetrieTypeCode() {
		return retrieTypeCode;
	}

	public void setRetrieTypeCode(java.lang.String retrieTypeCode) {
		this.retrieTypeCode = retrieTypeCode;
	}

	public java.util.Date getRetrieDate() {
		return retrieDate;
	}

	public void setRetrieDate(java.util.Date retrieDate) {
		this.retrieDate = retrieDate;
	}

	public java.lang.String getHisDutyAttribute() {
		return hisDutyAttribute;
	}

	public void setHisDutyAttribute(java.lang.String hisDutyAttribute) {
		this.hisDutyAttribute = hisDutyAttribute;
	}
}