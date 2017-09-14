/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.res.pt.dto;

import org.apache.commons.lang.StringUtils;

import com.yh.platform.core.util.DateUtil;


public class PtEducationTrainingInfoDTO {

	private Long bizPersonOid;
	private Long baseEducationTrainingOid;
	
	private java.lang.Long educationTrainingOid;
	private java.lang.String educationTrainingKinkCode;
	private java.lang.String trainingStatus;
	private java.lang.String trainingUnitName;
	private java.lang.String trainingType;
	private java.lang.String trainingName;
	private java.lang.String trainingContent;
	private java.util.Date trainingBeginDate;
    private String trainingBeginDateStr;
	private java.util.Date trainingEndDate;
    private String trainingEndDateStr;
	private java.lang.String trainingGrade;
	private java.lang.String trainingResult;
	private java.lang.String isAbroadStatus;
	private java.lang.String approveOfficeName;
	private java.util.Date approveDate;
    private String approveDateStr;
	private java.lang.String remark;
	private java.lang.String createBy;
	private java.lang.String createName;
	private java.util.Date createDate;
    private String createDateStr;
	private java.lang.String updateBy;
	private java.lang.String updateName;
	private java.util.Date updateDate;
    private String updateDateStr;

    public Long getBizPersonOid() {
		return bizPersonOid;
	}

	public void setBizPersonOid(Long bizPersonOid) {
		this.bizPersonOid = bizPersonOid;
	}

	public Long getBaseEducationTrainingOid() {
		return baseEducationTrainingOid;
	}

	public void setBaseEducationTrainingOid(Long baseEducationTrainingOid) {
		this.baseEducationTrainingOid = baseEducationTrainingOid;
	}

	public void setEducationTrainingOid(java.lang.Long educationTrainingOid){
		this.educationTrainingOid = educationTrainingOid;
	}

	public java.lang.Long getEducationTrainingOid(){
		return this.educationTrainingOid;
	}
    public void setEducationTrainingKinkCode(java.lang.String educationTrainingKinkCode){
		this.educationTrainingKinkCode = educationTrainingKinkCode;
	}

	public java.lang.String getEducationTrainingKinkCode(){
		return this.educationTrainingKinkCode;
	}
    public void setTrainingStatus(java.lang.String trainingStatus){
		this.trainingStatus = trainingStatus;
	}

	public java.lang.String getTrainingStatus(){
		return this.trainingStatus;
	}
    public void setTrainingUnitName(java.lang.String trainingUnitName){
		this.trainingUnitName = trainingUnitName;
	}

	public java.lang.String getTrainingUnitName(){
		return this.trainingUnitName;
	}
    public void setTrainingType(java.lang.String trainingType){
		this.trainingType = trainingType;
	}

	public java.lang.String getTrainingType(){
		return this.trainingType;
	}
    public void setTrainingName(java.lang.String trainingName){
		this.trainingName = trainingName;
	}

	public java.lang.String getTrainingName(){
		return this.trainingName;
	}
    public void setTrainingContent(java.lang.String trainingContent){
		this.trainingContent = trainingContent;
	}

	public java.lang.String getTrainingContent(){
		return this.trainingContent;
	}
    public void setTrainingBeginDate(java.util.Date trainingBeginDate){
		this.trainingBeginDate = trainingBeginDate;
		if(null != trainingBeginDate){
			this.trainingBeginDateStr = DateUtil.format(trainingBeginDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getTrainingBeginDate(){
		return this.trainingBeginDate;
	}
    public void setTrainingBeginDateStr(String trainingBeginDateStr){
        this.trainingBeginDateStr = trainingBeginDateStr;
        if(StringUtils.isNotEmpty(trainingBeginDateStr)){
               this.trainingBeginDate = DateUtil.parse(trainingBeginDateStr, "yyyy-MM-dd");
        }
    }

    public String getTrainingBeginDateStr(){
        return this.trainingBeginDateStr;
    }
    public void setTrainingEndDate(java.util.Date trainingEndDate){
		this.trainingEndDate = trainingEndDate;
		if(null != trainingEndDate){
			this.trainingEndDateStr = DateUtil.format(trainingEndDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getTrainingEndDate(){
		return this.trainingEndDate;
	}
    public void setTrainingEndDateStr(String trainingEndDateStr){
        this.trainingEndDateStr = trainingEndDateStr;
        if(StringUtils.isNotEmpty(trainingEndDateStr)){
               this.trainingEndDate = DateUtil.parse(trainingEndDateStr, "yyyy-MM-dd");
        }
    }

    public String getTrainingEndDateStr(){
        return this.trainingEndDateStr;
    }
    public void setTrainingGrade(java.lang.String trainingGrade){
		this.trainingGrade = trainingGrade;
	}

	public java.lang.String getTrainingGrade(){
		return this.trainingGrade;
	}
    public void setTrainingResult(java.lang.String trainingResult){
		this.trainingResult = trainingResult;
	}

	public java.lang.String getTrainingResult(){
		return this.trainingResult;
	}
    public void setIsAbroadStatus(java.lang.String isAbroadStatus){
		this.isAbroadStatus = isAbroadStatus;
	}

	public java.lang.String getIsAbroadStatus(){
		return this.isAbroadStatus;
	}
    public void setApproveOfficeName(java.lang.String approveOfficeName){
		this.approveOfficeName = approveOfficeName;
	}

	public java.lang.String getApproveOfficeName(){
		return this.approveOfficeName;
	}
    public void setApproveDate(java.util.Date approveDate){
		this.approveDate = approveDate;
		if(null != approveDate){
			this.approveDateStr = DateUtil.format(approveDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getApproveDate(){
		return this.approveDate;
	}
    public void setApproveDateStr(String approveDateStr){
        this.approveDateStr = approveDateStr;
        if(StringUtils.isNotEmpty(approveDateStr)){
               this.approveDate = DateUtil.parse(approveDateStr, "yyyy-MM-dd");
        }
    }

    public String getApproveDateStr(){
        return this.approveDateStr;
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

}
