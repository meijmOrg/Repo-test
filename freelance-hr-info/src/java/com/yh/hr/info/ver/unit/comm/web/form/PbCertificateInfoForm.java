/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.info.ver.unit.comm.web.form;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.validator.ValidatorForm;

import com.yh.platform.core.util.DateUtil;

public class PbCertificateInfoForm extends ValidatorForm {
	private static final long serialVersionUID = 110119120L;

	private java.lang.Long certificateOid;
	private java.lang.Long personOid;
	private java.lang.String certificateNo;
	private java.lang.String approveOrganName;
	private java.util.Date approvedDate;
    private String approvedDateStr;
	private java.util.Date issuedDate;
    private String issuedDateStr;
	private java.lang.String scopeCode;
	private java.lang.String certificateUnit;
	private java.util.Date certificateBeginDate;
    private String certificateBeginDateStr;
	private java.util.Date certificateEndDate;
    private String certificateEndDateStr;
	private java.lang.String cancelFlag;
	private java.util.Date cancelDate;
    private String cancelDateStr;
	private java.lang.String remark;
	private java.lang.String createBy;
	private java.lang.String createName;
	private java.util.Date createDate;
    private String createDateStr;
	private java.lang.String updateBy;
	private java.lang.String updateName;
	private java.util.Date updateDate;
    private String updateDateStr;

	public PbCertificateInfoForm() {}

    public void setCertificateOid(java.lang.Long certificateOid){
		this.certificateOid = certificateOid;
	}

	public java.lang.Long getCertificateOid(){
		return this.certificateOid;
	}
    public void setPersonOid(java.lang.Long personOid){
		this.personOid = personOid;
	}

	public java.lang.Long getPersonOid(){
		return this.personOid;
	}
    public void setCertificateNo(java.lang.String certificateNo){
		this.certificateNo = certificateNo;
	}

	public java.lang.String getCertificateNo(){
		return this.certificateNo;
	}
    public void setApproveOrganName(java.lang.String approveOrganName){
		this.approveOrganName = approveOrganName;
	}

	public java.lang.String getApproveOrganName(){
		return this.approveOrganName;
	}
    public void setApprovedDate(java.util.Date approvedDate){
		this.approvedDate = approvedDate;
		if(null != approvedDate){
			this.approvedDateStr = DateUtil.format(approvedDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getApprovedDate(){
		return this.approvedDate;
	}
    public void setApprovedDateStr(String approvedDateStr){
        this.approvedDateStr = approvedDateStr;
        if(StringUtils.isNotEmpty(approvedDateStr)){
               this.approvedDate = DateUtil.parse(approvedDateStr, "yyyy-MM-dd");
        }
    }

    public String getApprovedDateStr(){
        return this.approvedDateStr;
    }
    public void setIssuedDate(java.util.Date issuedDate){
		this.issuedDate = issuedDate;
		if(null != issuedDate){
			this.issuedDateStr = DateUtil.format(issuedDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getIssuedDate(){
		return this.issuedDate;
	}
    public void setIssuedDateStr(String issuedDateStr){
        this.issuedDateStr = issuedDateStr;
        if(StringUtils.isNotEmpty(issuedDateStr)){
               this.issuedDate = DateUtil.parse(issuedDateStr, "yyyy-MM-dd");
        }
    }

    public String getIssuedDateStr(){
        return this.issuedDateStr;
    }
    public void setScopeCode(java.lang.String scopeCode){
		this.scopeCode = scopeCode;
	}

	public java.lang.String getScopeCode(){
		return this.scopeCode;
	}
    public void setCertificateUnit(java.lang.String certificateUnit){
		this.certificateUnit = certificateUnit;
	}

	public java.lang.String getCertificateUnit(){
		return this.certificateUnit;
	}
    public void setCertificateBeginDate(java.util.Date certificateBeginDate){
		this.certificateBeginDate = certificateBeginDate;
		if(null != certificateBeginDate){
			this.certificateBeginDateStr = DateUtil.format(certificateBeginDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getCertificateBeginDate(){
		return this.certificateBeginDate;
	}
    public void setCertificateBeginDateStr(String certificateBeginDateStr){
        this.certificateBeginDateStr = certificateBeginDateStr;
        if(StringUtils.isNotEmpty(certificateBeginDateStr)){
               this.certificateBeginDate = DateUtil.parse(certificateBeginDateStr, "yyyy-MM-dd");
        }
    }

    public String getCertificateBeginDateStr(){
        return this.certificateBeginDateStr;
    }
    public void setCertificateEndDate(java.util.Date certificateEndDate){
		this.certificateEndDate = certificateEndDate;
		if(null != certificateEndDate){
			this.certificateEndDateStr = DateUtil.format(certificateEndDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getCertificateEndDate(){
		return this.certificateEndDate;
	}
    public void setCertificateEndDateStr(String certificateEndDateStr){
        this.certificateEndDateStr = certificateEndDateStr;
        if(StringUtils.isNotEmpty(certificateEndDateStr)){
               this.certificateEndDate = DateUtil.parse(certificateEndDateStr, "yyyy-MM-dd");
        }
    }

    public String getCertificateEndDateStr(){
        return this.certificateEndDateStr;
    }
    public void setCancelFlag(java.lang.String cancelFlag){
		this.cancelFlag = cancelFlag;
	}

	public java.lang.String getCancelFlag(){
		return this.cancelFlag;
	}
    public void setCancelDate(java.util.Date cancelDate){
		this.cancelDate = cancelDate;
		if(null != cancelDate){
			this.cancelDateStr = DateUtil.format(cancelDate, "yyyy-MM-dd");
         }
	}

	public java.util.Date getCancelDate(){
		return this.cancelDate;
	}
    public void setCancelDateStr(String cancelDateStr){
        this.cancelDateStr = cancelDateStr;
        if(StringUtils.isNotEmpty(cancelDateStr)){
               this.cancelDate = DateUtil.parse(cancelDateStr, "yyyy-MM-dd");
        }
    }

    public String getCancelDateStr(){
        return this.cancelDateStr;
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
	public void resetForm() {
		this.certificateOid = null;
		this.personOid = null;
		this.certificateNo = null;
		this.approveOrganName = null;
		this.approvedDate = null;
        this.approvedDateStr = null;
		this.issuedDate = null;
        this.issuedDateStr = null;
		this.scopeCode = null;
		this.certificateUnit = null;
		this.certificateBeginDate = null;
        this.certificateBeginDateStr = null;
		this.certificateEndDate = null;
        this.certificateEndDateStr = null;
		this.cancelFlag = null;
		this.cancelDate = null;
        this.cancelDateStr = null;
		this.remark = null;
		this.createBy = null;
		this.createName = null;
		this.createDate = null;
        this.createDateStr = null;
		this.updateBy = null;
		this.updateName = null;
		this.updateDate = null;
        this.updateDateStr = null;
	}

}
