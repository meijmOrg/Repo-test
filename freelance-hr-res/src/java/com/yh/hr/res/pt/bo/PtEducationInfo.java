/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-10-09
**/
package com.yh.hr.res.pt.bo;

import com.yh.platform.core.bo.BaseBo;

public class PtEducationInfo extends BaseBo {
	private static final long serialVersionUID = -8051670278882651759L;

	private java.lang.Long  	ptEducationOid;	//主键OID
	private java.lang.Long  	bizPersonOid;	//BizPersonOid
	private java.lang.Long  	educationOid;	//基础库记录OID
	private java.lang.String	schoolName;	//学校
	private java.lang.String	academyName;	//所在院系
	private java.lang.String	academyDesc;	//院系描述
	private java.lang.String	majorName;	//专业名称
	private java.util.Date  	schoolEnrollDate;	//入学日期
	private java.util.Date  	graduateDate;	//毕（肄）业日期
	private java.lang.String	eductionalSystem;	//学制（年）
	private java.lang.String	studyTypeCode;	//学习形式YHRS0042
	private java.lang.String	eduTypeCode;	//教育类别YHRS0043
	private java.lang.String	educationCode;	//学历YHRS0039
	private java.lang.String	educationCertificate;	//学历证书号码
	private java.lang.String	educationLevelCode;	//学历等级YHRS0041
	private java.lang.String	isHighestEducationLevel;	//是否当前最高学历标识YHRS0003
	private java.lang.String	degreeCode;	//学位YHRS0040
	private java.lang.String	degreeCertificateNo;	//学位证书号码
	private java.util.Date  	degreeGrantDate;	//学位授予日期
	private java.lang.String	degreeGrantUnit;	//学位授予单位
	private java.lang.String	degreeGrantCountryCode;	//学位授予国家YHRS0005
	private java.lang.String	isHighestDegree;	//是否最高学位YHRS0003
	private java.lang.String	remark;	//备注
	private java.lang.String	schoolType;	//院校类别YHRS9003
	private java.lang.String	createdByCode;	//CreatedByCode
	private java.lang.String	createdByName;	//CreatedByName
	private java.util.Date  	createdDate;	//CreatedDate
	private java.lang.String	updatedByCode;	//UpdatedByCode
	private java.lang.String	updatedByName;	//UpdatedByName
	private java.util.Date  	updatedDate;	//UpdatedDate

	public PtEducationInfo() {
		
	}

	public void setPtEducationOid(java.lang.Long ptEducationOid){
		this.ptEducationOid = ptEducationOid;
	}

	public java.lang.Long getPtEducationOid(){
		return this.ptEducationOid;
	}

	public void setBizPersonOid(java.lang.Long bizPersonOid){
		this.bizPersonOid = bizPersonOid;
	}

	public java.lang.Long getBizPersonOid(){
		return this.bizPersonOid;
	}

	public void setEducationOid(java.lang.Long educationOid){
		this.educationOid = educationOid;
	}

	public java.lang.Long getEducationOid(){
		return this.educationOid;
	}

	public void setSchoolName(java.lang.String schoolName){
		this.schoolName = schoolName;
	}

	public java.lang.String getSchoolName(){
		return this.schoolName;
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

	public void setMajorName(java.lang.String majorName){
		this.majorName = majorName;
	}

	public java.lang.String getMajorName(){
		return this.majorName;
	}

	public void setSchoolEnrollDate(java.util.Date schoolEnrollDate){
		this.schoolEnrollDate = schoolEnrollDate;
	}

	public java.util.Date getSchoolEnrollDate(){
		return this.schoolEnrollDate;
	}

	public void setGraduateDate(java.util.Date graduateDate){
		this.graduateDate = graduateDate;
	}

	public java.util.Date getGraduateDate(){
		return this.graduateDate;
	}

	public void setEductionalSystem(java.lang.String eductionalSystem){
		this.eductionalSystem = eductionalSystem;
	}

	public java.lang.String getEductionalSystem(){
		return this.eductionalSystem;
	}

	public void setStudyTypeCode(java.lang.String studyTypeCode){
		this.studyTypeCode = studyTypeCode;
	}

	public java.lang.String getStudyTypeCode(){
		return this.studyTypeCode;
	}

	public void setEduTypeCode(java.lang.String eduTypeCode){
		this.eduTypeCode = eduTypeCode;
	}

	public java.lang.String getEduTypeCode(){
		return this.eduTypeCode;
	}

	public void setEducationCode(java.lang.String educationCode){
		this.educationCode = educationCode;
	}

	public java.lang.String getEducationCode(){
		return this.educationCode;
	}

	public void setEducationCertificate(java.lang.String educationCertificate){
		this.educationCertificate = educationCertificate;
	}

	public java.lang.String getEducationCertificate(){
		return this.educationCertificate;
	}

	public void setEducationLevelCode(java.lang.String educationLevelCode){
		this.educationLevelCode = educationLevelCode;
	}

	public java.lang.String getEducationLevelCode(){
		return this.educationLevelCode;
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

	public void setDegreeCertificateNo(java.lang.String degreeCertificateNo){
		this.degreeCertificateNo = degreeCertificateNo;
	}

	public java.lang.String getDegreeCertificateNo(){
		return this.degreeCertificateNo;
	}

	public void setDegreeGrantDate(java.util.Date degreeGrantDate){
		this.degreeGrantDate = degreeGrantDate;
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

	public void setSchoolType(java.lang.String schoolType){
		this.schoolType = schoolType;
	}

	public java.lang.String getSchoolType(){
		return this.schoolType;
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

	public void setUpdatedByCode(java.lang.String updatedByCode){
		this.updatedByCode = updatedByCode;
	}

	public java.lang.String getUpdatedByCode(){
		return this.updatedByCode;
	}

	public void setUpdatedByName(java.lang.String updatedByName){
		this.updatedByName = updatedByName;
	}

	public java.lang.String getUpdatedByName(){
		return this.updatedByName;
	}

	public void setUpdatedDate(java.util.Date updatedDate){
		this.updatedDate = updatedDate;
	}

	public java.util.Date getUpdatedDate(){
		return this.updatedDate;
	}

}