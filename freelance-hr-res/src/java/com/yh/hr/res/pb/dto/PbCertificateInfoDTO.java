/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10 
 */
package com.yh.hr.res.pb.dto;

import org.apache.commons.lang.StringUtils;

import com.yh.platform.core.util.DateUtil;


public class PbCertificateInfoDTO {

	private java.lang.Long certificateOid;        //主键OID
	private java.lang.Long personOid;        //PersonOid
	private java.lang.String certificateNo;        //执业注册证书编号
	private java.lang.String approveOrganName;        //发证机构
	private java.util.Date approvedDate;        //审批日期
	private String approvedDateStr;
	private java.util.Date issuedDate;        //签发日期
	private String issuedDateStr;
	private java.lang.String scopeCode;        //执业范围
	private java.lang.String certificateUnit;        //执业地点
	private java.util.Date certificateBeginDate;        //当前注册日期
	private String certificateBeginDateStr;
	private java.util.Date certificateEndDate;        //当前注册有效截止日期
	private String certificateEndDateStr;
	private java.lang.String cancelFlag;        //是否注销
	private java.util.Date cancelDate;        //注销日期
	private String cancelDateStr;
	private java.lang.String remark;        //备注
	private java.lang.String createBy;        //创建人ID
	private java.lang.String createName;        //创建人名称
	private java.util.Date createDate;        //创建时间
	private String createDateStr;
	private java.lang.String updateBy;        //修改人ID
	private java.lang.String updateName;        //修改人名称
	private java.util.Date updateDate;        //修改时间
	private String updateDateStr;

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
}