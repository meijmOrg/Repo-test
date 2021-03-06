/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10 
 */
package com.yh.hr.res.pb.dto;

import org.apache.commons.lang.StringUtils;

import com.yh.platform.core.util.DateUtil;


public class PbCertificateHistInfoDTO {

	private java.lang.Long certificateHistOid;        //主键OID
	private java.lang.Long personOid;        //PersonOid
	private java.lang.String certificateType;        //注册类型
	private java.util.Date certificateBeginDate;        //注册日期
	private String certificateBeginDateStr;
	private java.util.Date certificateEndDate;        //注册有效截止日期
	private String certificateEndDateStr;
	private java.lang.String createBy;        //创建人ID
	private java.lang.String createName;        //创建人名称
	private java.util.Date createDate;        //创建时间
	private String createDateStr;
	private java.lang.String updateBy;        //修改人ID
	private java.lang.String updateName;        //修改人名称
	private java.util.Date updateDate;        //修改时间
	private String updateDateStr;

	public void setCertificateHistOid(java.lang.Long certificateHistOid){
		this.certificateHistOid = certificateHistOid;
	}

	public java.lang.Long getCertificateHistOid(){
		return this.certificateHistOid;
	}
	public void setPersonOid(java.lang.Long personOid){
		this.personOid = personOid;
	}

	public java.lang.Long getPersonOid(){
		return this.personOid;
	}
	public void setCertificateType(java.lang.String certificateType){
		this.certificateType = certificateType;
	}

	public java.lang.String getCertificateType(){
		return this.certificateType;
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