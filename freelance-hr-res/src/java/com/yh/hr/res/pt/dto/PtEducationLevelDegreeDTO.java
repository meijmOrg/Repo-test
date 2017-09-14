/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.res.pt.dto;

import com.yh.platform.core.util.DateUtil;


public class PtEducationLevelDegreeDTO {

    /**
     *主键ID
     **/
	private java.lang.Long educationLevelOid;
    /**
     *BizPersonOid
     **/
	private java.lang.Long bizPersonOid;
    /**
     *基础OID
     **/
	private java.lang.Long baseEducationLevelOid;
    /**
     *学校名称
     **/
	private java.lang.String schoolName;
    /**
     *学校描述
     **/
	private java.lang.String schoolDesc;
    /**
     *所在院系
     **/
	private java.lang.String academyName;
    /**
     *院系描述
     **/
	private java.lang.String academyDesc;
    /**
     *学习形式
     **/
	private java.lang.String studyTypeCode;
    /**
     *学制（年）
     **/
	private java.lang.String eductionalSystem;
    /**
     *入学日期
     **/
	private java.util.Date schoolEnrollDate;
    /**
     *入学日期
     **/
	private java.lang.String schoolEnrollDateStr;
    /**
     *毕（肄）业日期
     **/
	private java.util.Date graduateDate;
    /**
     *毕（肄）业日期
     **/
	private java.lang.String graduateDateStr;
    /**
     *教育类别
     **/
	private java.lang.String eduType;
    /**
     *学历
     **/
	private java.lang.String educationCode;
    /**
     *所学专业
     **/
	private java.lang.String majorCode;
    /**
     *专业描述
     **/
	private java.lang.String majorNameCode;
    /**
     *学历证书号码
     **/
	private java.lang.String educationCertificate;
    /**
     *学历等级
     **/
	private java.lang.String educationLevel;
    /**
     *学历等级描述
     **/
	private java.lang.String educationLevelName;
    /**
     *是否当前最高学历标识

     **/
	private java.lang.String isHighestEducationLevel;
    /**
     *学位
     **/
	private java.lang.String degreeCode;
    /**
     *学位证书号码
     **/
	private java.lang.String degreeCertificateCode;
    /**
     *学位授予日期
     **/
	private java.util.Date degreeGrantDate;
    /**
     *学位授予日期
     **/
	private java.lang.String degreeGrantDateStr;
    /**
     *学位授予单位
     **/
	private java.lang.String degreeGrantUnit;
    /**
     *学位授予国家
     **/
	private java.lang.String degreeGrantCountryCode;
    /**
     *是否最高学位

     **/
	private java.lang.String isHighestDegree;
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

	public PtEducationLevelDegreeDTO() {}

    public PtEducationLevelDegreeDTO(java.lang.Long educationLevelOid) {
        this.educationLevelOid = educationLevelOid;
    }

	public void setEducationLevelOid(java.lang.Long educationLevelOid){
		this.educationLevelOid = educationLevelOid;
	}

	public java.lang.Long getEducationLevelOid(){
		return this.educationLevelOid;
	}

	public java.lang.Long getBizPersonOid() {
		return bizPersonOid;
	}

	public void setBizPersonOid(java.lang.Long bizPersonOid) {
		this.bizPersonOid = bizPersonOid;
	}

	public java.lang.Long getBaseEducationLevelOid() {
		return baseEducationLevelOid;
	}

	public void setBaseEducationLevelOid(java.lang.Long baseEducationLevelOid) {
		this.baseEducationLevelOid = baseEducationLevelOid;
	}

	public void setSchoolName(java.lang.String schoolName){
		this.schoolName = schoolName;
	}

	public java.lang.String getSchoolName(){
		return this.schoolName;
	}

	public void setSchoolDesc(java.lang.String schoolDesc){
		this.schoolDesc = schoolDesc;
	}

	public java.lang.String getSchoolDesc(){
		return this.schoolDesc;
	}

	public void setAcademyName(java.lang.String academyName){
		this.academyName = academyName;
	}

	public java.lang.String getAcademyName(){
		return this.academyName;
	}

	public void setAcademyDesc(java.lang.String academyDesc){
		this.academyDesc = academyDesc;
	}

	public java.lang.String getAcademyDesc(){
		return this.academyDesc;
	}

	public void setStudyTypeCode(java.lang.String studyTypeCode){
		this.studyTypeCode = studyTypeCode;
	}

	public java.lang.String getStudyTypeCode(){
		return this.studyTypeCode;
	}

	public void setEductionalSystem(java.lang.String eductionalSystem){
		this.eductionalSystem = eductionalSystem;
	}

	public java.lang.String getEductionalSystem(){
		return this.eductionalSystem;
	}

	public void setSchoolEnrollDate(java.util.Date schoolEnrollDate){
		this.schoolEnrollDate = schoolEnrollDate;
		this.schoolEnrollDateStr =DateUtil.formatDate(schoolEnrollDate);
	}

	public java.util.Date getSchoolEnrollDate(){
		return this.schoolEnrollDate;
	}

	public void setGraduateDate(java.util.Date graduateDate){
		this.graduateDate = graduateDate;
		this.graduateDateStr =DateUtil.formatDate(graduateDate);
	}

	public java.util.Date getGraduateDate(){
		return this.graduateDate;
	}

	public void setEduType(java.lang.String eduType){
		this.eduType = eduType;
	}

	public java.lang.String getEduType(){
		return this.eduType;
	}

	public void setEducationCode(java.lang.String educationCode){
		this.educationCode = educationCode;
	}

	public java.lang.String getEducationCode(){
		return this.educationCode;
	}

	public void setMajorCode(java.lang.String majorCode){
		this.majorCode = majorCode;
	}

	public java.lang.String getMajorCode(){
		return this.majorCode;
	}

	public void setMajorNameCode(java.lang.String majorNameCode){
		this.majorNameCode = majorNameCode;
	}

	public java.lang.String getMajorNameCode(){
		return this.majorNameCode;
	}

	public void setEducationCertificate(java.lang.String educationCertificate){
		this.educationCertificate = educationCertificate;
	}

	public java.lang.String getEducationCertificate(){
		return this.educationCertificate;
	}

	public void setEducationLevel(java.lang.String educationLevel){
		this.educationLevel = educationLevel;
	}

	public java.lang.String getEducationLevel(){
		return this.educationLevel;
	}

	public void setEducationLevelName(java.lang.String educationLevelName){
		this.educationLevelName = educationLevelName;
	}

	public java.lang.String getEducationLevelName(){
		return this.educationLevelName;
	}

	public void setIsHighestEducationLevel(java.lang.String isHighestEducationLevel){
		this.isHighestEducationLevel = isHighestEducationLevel;
	}

	public java.lang.String getIsHighestEducationLevel(){
		return this.isHighestEducationLevel;
	}

	public void setDegreeCode(java.lang.String degreeCode){
		this.degreeCode = degreeCode;
	}

	public java.lang.String getDegreeCode(){
		return this.degreeCode;
	}

	public void setDegreeCertificateCode(java.lang.String degreeCertificateCode){
		this.degreeCertificateCode = degreeCertificateCode;
	}

	public java.lang.String getDegreeCertificateCode(){
		return this.degreeCertificateCode;
	}

	public void setDegreeGrantDate(java.util.Date degreeGrantDate){
		this.degreeGrantDate = degreeGrantDate;
		this.degreeGrantDateStr =DateUtil.formatDate(degreeGrantDate);
	}

	public java.util.Date getDegreeGrantDate(){
		return this.degreeGrantDate;
	}

	public void setDegreeGrantUnit(java.lang.String degreeGrantUnit){
		this.degreeGrantUnit = degreeGrantUnit;
	}

	public java.lang.String getDegreeGrantUnit(){
		return this.degreeGrantUnit;
	}

	public void setDegreeGrantCountryCode(java.lang.String degreeGrantCountryCode){
		this.degreeGrantCountryCode = degreeGrantCountryCode;
	}

	public java.lang.String getDegreeGrantCountryCode(){
		return this.degreeGrantCountryCode;
	}

	public void setIsHighestDegree(java.lang.String isHighestDegree){
		this.isHighestDegree = isHighestDegree;
	}

	public java.lang.String getIsHighestDegree(){
		return this.isHighestDegree;
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

	public java.lang.String getSchoolEnrollDateStr() {
		return schoolEnrollDateStr;
	}

	public void setSchoolEnrollDateStr(java.lang.String schoolEnrollDateStr) {
		this.schoolEnrollDateStr = schoolEnrollDateStr;
		this.schoolEnrollDate =DateUtil.parseDate(schoolEnrollDateStr);
	}

	public java.lang.String getGraduateDateStr() {
		return graduateDateStr;
	}

	public void setGraduateDateStr(java.lang.String graduateDateStr) {
		this.graduateDateStr = graduateDateStr;
		this.graduateDate =DateUtil.parseDate(graduateDateStr);
	}

	public java.lang.String getDegreeGrantDateStr() {
		return degreeGrantDateStr;
	}

	public void setDegreeGrantDateStr(java.lang.String degreeGrantDateStr) {
		this.degreeGrantDateStr = degreeGrantDateStr;
		this.degreeGrantDate =DateUtil.parseDate(degreeGrantDateStr);
	}
}