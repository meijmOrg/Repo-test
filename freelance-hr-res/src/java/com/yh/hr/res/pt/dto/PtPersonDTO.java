/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-10-09
**/
package com.yh.hr.res.pt.dto;

public class PtPersonDTO {

	private java.lang.Long  	bizPersonOid;	//BizPersonOid
	private java.lang.Long  	personOid;	//人员主键
	private java.lang.Long  	taskOid;	//TaskOid
	private java.lang.String	name;	//姓名
	private java.lang.String	idCode;	//证件类别代码YHRS0002
	private java.lang.String	idNo;	//证件号码
	private java.lang.String	englishName;	//外文姓名
	private java.lang.String	alternativeName;	//曾用名
	private java.lang.String	sexCode;	//性别代码YHRS0001
	private java.util.Date  	birthday;	//出生日期
	private java.lang.String	peopleCode;	//民族代码国籍为中国时必填YHRS0004
	private java.lang.String	nationalityCode;	//国籍代码YHRS0005
	private java.lang.String	ancestorPlaceCode;	//籍贯代码国籍为中国时必填YHRS0006
	private java.lang.String	birthplaceCode;	//出生地代码国籍为中国时必填YHRS0006
	private java.lang.String	hukouPlaceCode;	//户口所在地代码国籍为中国时必填YHRS0006
	private java.lang.String	healthStatusCode;	//健康状况代码YHRS0007
	private java.lang.String	marriageStatusCode;	//婚姻状况代码YHRS0008
	private java.lang.String	email;	//个人email地址
	private java.lang.String	mobilePhone;	//移动电话
	private java.lang.String	officePhone;	//办公电话
	private java.lang.Long  	unitOid;	//人员所在单位
	private java.lang.String	unitName;	//UnitName
	private java.lang.Long  	deptOid;	//人员所在内设机构
	private java.lang.String	deptName;	//内设机构名称
	private java.lang.String	personStatus;	//人员状态YHRS0009
	private java.lang.String	personType;	//人员类别YHRS0010
	private java.lang.String	flagOfHkmctwChineseCode;	//港澳台侨属标识YHRS0011
	private java.lang.String	protTechFlag;	//是否专业技术人员标识YHRS0003
	private java.lang.String	exportFlag;	//是否专家标志YHRS0003
	private java.lang.String	doctorFlag;	//是否博士后研究人员YHRS0003
	private java.lang.String	isAbordExpert;	//是否海外专家YHRS0003
	private java.lang.String	isStudyAbordExpert;	//是否留学回国专家
	private java.lang.String	isComesChinaExpert;	//是否来华定居专家YHRS0003
	private java.lang.String	isVeteran;	//是否退役军人标识YHRS0003
	private java.lang.String	isAllocation;	//是否军转安置干部YHRS0003
	private java.lang.String	isCadre;	//是否干部身份YHRS0003
	private java.lang.String    isSz;
	private java.lang.String	dPositionType;	//编制类型YHRS0012
	private java.lang.String	bankpoll;	//经费形式YHRS0013
	private java.lang.Long  	orderView;	//人员排序号
	private java.util.Date  	inGbDate;	//进入干部队伍日期
	private java.util.Date  	cadreChangeDate;	//干部身份转正日期
	private java.lang.String	inGbApproveDept;	//进入干部队伍审批部门
	private java.lang.String	inGbApproveArchive;	//进入干部队伍审批文号
	private java.lang.String	inGbId;	//进入干部队伍前身份YHRS0010
	private java.lang.String	firstEnterSyType;	//最初进入事业单位方式YHRS0110
	private java.lang.String	hobby;	//Hobby
	private java.util.Date  	allocationApproveDate;	//军转干部安置批准日期
	private java.lang.String	politicStatusCode;	//政治面貌
	private java.util.Date  	joinPoliticDate;	//参加党派时间
	private java.lang.String	createdByCode;	//CreatedByCode
	private java.lang.String	createdByName;	//CreatedByName
	private java.util.Date  	createdDate;	//CreatedDate
	private java.lang.String	updatedByCode;	//UpdatedByCode
	private java.lang.String	updatedByName;	//UpdatedByName
	private java.util.Date  	updatedDate;	//UpdatedDate
	private java.lang.String	hireCause;	//聘用条件
	private java.lang.String	address;	//家庭住址
	private java.lang.String	isProbation;	//是否试用期人员
	private java.lang.Integer	probationTerm;	//试用期限
	private java.lang.String    postalcode;  //邮编
	
	private java.lang.String 	personCode;//工号
	private java.lang.Long 		hireDeptOid;//部门Oid
	private java.lang.String 	hireDeptName;//部门名称

	private java.lang.String hisPositionName; //岗位名称(院内)
	/**
     *EntryCurrentUnitType
     **/
	private java.lang.String entryCurrentUnitType;
    /**
     *EntryCurrentUnitDate
     **/
	private java.util.Date entryCurrentUnitDate;
	/**
	 * 参加工作时间
	 */
	private java.util.Date startWorkDate; 
	
	private java.lang.String emergContact;
    /**
     *EmergPhone
     **/
	private java.lang.String emergPhone;
	/**
     *LevelCode
     **/
	private java.lang.String levelCode;
	
	public PtPersonDTO() {
		
	}

	public void setBizPersonOid(java.lang.Long bizPersonOid){
		this.bizPersonOid = bizPersonOid;
	}

	public java.lang.Long getBizPersonOid(){
		return this.bizPersonOid;
	}

	public void setPersonOid(java.lang.Long personOid){
		this.personOid = personOid;
	}

	public java.lang.Long getPersonOid(){
		return this.personOid;
	}

	public void setTaskOid(java.lang.Long taskOid){
		this.taskOid = taskOid;
	}

	public java.lang.Long getTaskOid(){
		return this.taskOid;
	}

	public void setName(java.lang.String name){
		this.name = name;
	}

	public java.lang.String getName(){
		return this.name;
	}

	public void setIdCode(java.lang.String idCode){
		this.idCode = idCode;
	}

	public java.lang.String getIdCode(){
		return this.idCode;
	}

	public void setIdNo(java.lang.String idNo){
		this.idNo = idNo;
	}

	public java.lang.String getIdNo(){
		return this.idNo;
	}

	public void setEnglishName(java.lang.String englishName){
		this.englishName = englishName;
	}

	public java.lang.String getEnglishName(){
		return this.englishName;
	}

	public void setAlternativeName(java.lang.String alternativeName){
		this.alternativeName = alternativeName;
	}

	public java.lang.String getAlternativeName(){
		return this.alternativeName;
	}

	public void setSexCode(java.lang.String sexCode){
		this.sexCode = sexCode;
	}

	public java.lang.String getSexCode(){
		return this.sexCode;
	}

	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}

	public java.util.Date getBirthday(){
		return this.birthday;
	}

	public void setPeopleCode(java.lang.String peopleCode){
		this.peopleCode = peopleCode;
	}

	public java.lang.String getPeopleCode(){
		return this.peopleCode;
	}

	public void setNationalityCode(java.lang.String nationalityCode){
		this.nationalityCode = nationalityCode;
	}

	public java.lang.String getNationalityCode(){
		return this.nationalityCode;
	}

	public void setAncestorPlaceCode(java.lang.String ancestorPlaceCode){
		this.ancestorPlaceCode = ancestorPlaceCode;
	}

	public java.lang.String getAncestorPlaceCode(){
		return this.ancestorPlaceCode;
	}

	public void setBirthplaceCode(java.lang.String birthplaceCode){
		this.birthplaceCode = birthplaceCode;
	}

	public java.lang.String getBirthplaceCode(){
		return this.birthplaceCode;
	}

	public void setHukouPlaceCode(java.lang.String hukouPlaceCode){
		this.hukouPlaceCode = hukouPlaceCode;
	}

	public java.lang.String getHukouPlaceCode(){
		return this.hukouPlaceCode;
	}

	public void setHealthStatusCode(java.lang.String healthStatusCode){
		this.healthStatusCode = healthStatusCode;
	}

	public java.lang.String getHealthStatusCode(){
		return this.healthStatusCode;
	}

	public void setMarriageStatusCode(java.lang.String marriageStatusCode){
		this.marriageStatusCode = marriageStatusCode;
	}

	public java.lang.String getMarriageStatusCode(){
		return this.marriageStatusCode;
	}

	public void setEmail(java.lang.String email){
		this.email = email;
	}

	public java.lang.String getEmail(){
		return this.email;
	}

	public void setMobilePhone(java.lang.String mobilePhone){
		this.mobilePhone = mobilePhone;
	}

	public java.lang.String getMobilePhone(){
		return this.mobilePhone;
	}

	public void setOfficePhone(java.lang.String officePhone){
		this.officePhone = officePhone;
	}

	public java.lang.String getOfficePhone(){
		return this.officePhone;
	}

	public void setUnitOid(java.lang.Long unitOid){
		this.unitOid = unitOid;
	}

	public java.lang.Long getUnitOid(){
		return this.unitOid;
	}

	public void setUnitName(java.lang.String unitName){
		this.unitName = unitName;
	}

	public java.lang.String getUnitName(){
		return this.unitName;
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

	public void setPersonStatus(java.lang.String personStatus){
		this.personStatus = personStatus;
	}

	public java.lang.String getPersonStatus(){
		return this.personStatus;
	}

	public void setPersonType(java.lang.String personType){
		this.personType = personType;
	}

	public java.lang.String getPersonType(){
		return this.personType;
	}

	public void setFlagOfHkmctwChineseCode(java.lang.String flagOfHkmctwChineseCode){
		this.flagOfHkmctwChineseCode = flagOfHkmctwChineseCode;
	}

	public java.lang.String getFlagOfHkmctwChineseCode(){
		return this.flagOfHkmctwChineseCode;
	}

	public void setProtTechFlag(java.lang.String protTechFlag){
		this.protTechFlag = protTechFlag;
	}

	public java.lang.String getProtTechFlag(){
		return this.protTechFlag;
	}

	public void setExportFlag(java.lang.String exportFlag){
		this.exportFlag = exportFlag;
	}

	public java.lang.String getExportFlag(){
		return this.exportFlag;
	}

	public void setDoctorFlag(java.lang.String doctorFlag){
		this.doctorFlag = doctorFlag;
	}

	public java.lang.String getDoctorFlag(){
		return this.doctorFlag;
	}

	public void setIsAbordExpert(java.lang.String isAbordExpert){
		this.isAbordExpert = isAbordExpert;
	}

	public java.lang.String getIsAbordExpert(){
		return this.isAbordExpert;
	}

	public void setIsStudyAbordExpert(java.lang.String isStudyAbordExpert){
		this.isStudyAbordExpert = isStudyAbordExpert;
	}

	public java.lang.String getIsStudyAbordExpert(){
		return this.isStudyAbordExpert;
	}

	public void setIsComesChinaExpert(java.lang.String isComesChinaExpert){
		this.isComesChinaExpert = isComesChinaExpert;
	}

	public java.lang.String getIsComesChinaExpert(){
		return this.isComesChinaExpert;
	}

	public void setIsVeteran(java.lang.String isVeteran){
		this.isVeteran = isVeteran;
	}

	public java.lang.String getIsVeteran(){
		return this.isVeteran;
	}

	public void setIsAllocation(java.lang.String isAllocation){
		this.isAllocation = isAllocation;
	}

	public java.lang.String getIsAllocation(){
		return this.isAllocation;
	}

	public void setIsCadre(java.lang.String isCadre){
		this.isCadre = isCadre;
	}

	public java.lang.String getIsCadre(){
		return this.isCadre;
	}

	public java.lang.String getdPositionType() {
		return dPositionType;
	}

	public void setdPositionType(java.lang.String dPositionType) {
		this.dPositionType = dPositionType;
	}

	public void setBankpoll(java.lang.String bankpoll){
		this.bankpoll = bankpoll;
	}

	public java.lang.String getBankpoll(){
		return this.bankpoll;
	}

	public void setOrderView(java.lang.Long orderView){
		this.orderView = orderView;
	}

	public java.lang.Long getOrderView(){
		return this.orderView;
	}

	public void setInGbDate(java.util.Date inGbDate){
		this.inGbDate = inGbDate;
	}

	public java.util.Date getInGbDate(){
		return this.inGbDate;
	}

	public void setCadreChangeDate(java.util.Date cadreChangeDate){
		this.cadreChangeDate = cadreChangeDate;
	}

	public java.util.Date getCadreChangeDate(){
		return this.cadreChangeDate;
	}

	public void setInGbApproveDept(java.lang.String inGbApproveDept){
		this.inGbApproveDept = inGbApproveDept;
	}

	public java.lang.String getInGbApproveDept(){
		return this.inGbApproveDept;
	}

	public void setInGbApproveArchive(java.lang.String inGbApproveArchive){
		this.inGbApproveArchive = inGbApproveArchive;
	}

	public java.lang.String getInGbApproveArchive(){
		return this.inGbApproveArchive;
	}

	public void setInGbId(java.lang.String inGbId){
		this.inGbId = inGbId;
	}

	public java.lang.String getInGbId(){
		return this.inGbId;
	}

	public void setFirstEnterSyType(java.lang.String firstEnterSyType){
		this.firstEnterSyType = firstEnterSyType;
	}

	public java.lang.String getFirstEnterSyType(){
		return this.firstEnterSyType;
	}

	public void setHobby(java.lang.String hobby){
		this.hobby = hobby;
	}

	public java.lang.String getHobby(){
		return this.hobby;
	}

	public void setAllocationApproveDate(java.util.Date allocationApproveDate){
		this.allocationApproveDate = allocationApproveDate;
	}

	public java.util.Date getAllocationApproveDate(){
		return this.allocationApproveDate;
	}

	public void setPoliticStatusCode(java.lang.String politicStatusCode){
		this.politicStatusCode = politicStatusCode;
	}

	public java.lang.String getPoliticStatusCode(){
		return this.politicStatusCode;
	}

	public void setJoinPoliticDate(java.util.Date joinPoliticDate){
		this.joinPoliticDate = joinPoliticDate;
	}

	public java.util.Date getJoinPoliticDate(){
		return this.joinPoliticDate;
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

	public java.lang.String getHireCause() {
		return hireCause;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setHireCause(java.lang.String hireCause) {
		this.hireCause = hireCause;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	
	public java.lang.String getIsProbation() {
		return isProbation;
	}

	public java.lang.Integer getProbationTerm() {
		return probationTerm;
	}

	public void setIsProbation(java.lang.String isProbation) {
		this.isProbation = isProbation;
	}

	public void setProbationTerm(java.lang.Integer probationTerm) {
		this.probationTerm = probationTerm;
	}

	public java.lang.String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(java.lang.String postalcode) {
		this.postalcode = postalcode;
	}

	public java.lang.String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(java.lang.String personCode) {
		this.personCode = personCode;
	}

	public java.lang.Long getHireDeptOid() {
		return hireDeptOid;
	}

	public void setHireDeptOid(java.lang.Long hireDeptOid) {
		this.hireDeptOid = hireDeptOid;
	}

	public java.lang.String getHireDeptName() {
		return hireDeptName;
	}

	public void setHireDeptName(java.lang.String hireDeptName) {
		this.hireDeptName = hireDeptName;
	}

	public void setHisPositionName(java.lang.String hisPositionName) {
		this.hisPositionName = hisPositionName;
	}

	public java.lang.String getHisPositionName() {
		return hisPositionName;
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

	public java.util.Date getStartWorkDate() {
		return startWorkDate;
	}

	public void setStartWorkDate(java.util.Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	public java.lang.String getIsSz() {
		return isSz;
	}

	public void setIsSz(java.lang.String isSz) {
		this.isSz = isSz;
	}

	public java.lang.String getEmergContact() {
		return emergContact;
	}

	public void setEmergContact(java.lang.String emergContact) {
		this.emergContact = emergContact;
	}

	public java.lang.String getEmergPhone() {
		return emergPhone;
	}

	public void setEmergPhone(java.lang.String emergPhone) {
		this.emergPhone = emergPhone;
	}

	public java.lang.String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(java.lang.String levelCode) {
		this.levelCode = levelCode;
	}


}
