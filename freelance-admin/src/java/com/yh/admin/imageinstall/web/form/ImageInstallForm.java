package com.yh.admin.imageinstall.web.form;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

/**
 * @description 系统外观设置form
 * @author meijm
 * @created 2017-9-16
 * @version 1.0
 */
public class ImageInstallForm extends ValidatorForm
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private java.lang.String subSystemCode;
    /**
     *logo图片
     **/
	private FormFile logoPhotoPath;
    /**
     *logo图片扩展名
     **/
	private java.lang.String logoPhotoType;
	/**
     *BANNER图片
     **/
	private FormFile bannerPhotoPath;
    /**
     *BANNER图片扩展名
     **/
	private java.lang.String bannerPhotoType;
    /**
     *CreatedByCode
     **/
	private java.lang.String createBy;
    /**
     *CreatedByName
     **/
	private java.lang.String createName;
    /**
     *CreatedDate
     **/
	private java.util.Date createDate;
    /**
     *UpdatedByCode
     **/
	private java.lang.String updateBy;
    /**
     *UpdatedByName
     **/
	private java.lang.String updateName;
    /**
     *UpdatedDate
     **/
	private java.util.Date updateDate;
	public java.lang.String getSubSystemCode() {
		return subSystemCode;
	}
	public void setSubSystemCode(java.lang.String subSystemCode) {
		this.subSystemCode = subSystemCode;
	}
	public FormFile getLogoPhotoPath() {
		return logoPhotoPath;
	}
	public void setLogoPhotoPath(FormFile logoPhotoPath) {
		this.logoPhotoPath = logoPhotoPath;
	}
	public java.lang.String getLogoPhotoType() {
		return logoPhotoType;
	}
	public void setLogoPhotoType(java.lang.String logoPhotoType) {
		this.logoPhotoType = logoPhotoType;
	}
	public FormFile getBannerPhotoPath() {
		return bannerPhotoPath;
	}
	public void setBannerPhotoPath(FormFile bannerPhotoPath) {
		this.bannerPhotoPath = bannerPhotoPath;
	}
	public java.lang.String getBannerPhotoType() {
		return bannerPhotoType;
	}
	public void setBannerPhotoType(java.lang.String bannerPhotoType) {
		this.bannerPhotoType = bannerPhotoType;
	}
	public java.lang.String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}
	public java.lang.String getCreateName() {
		return createName;
	}
	public void setCreateName(java.lang.String createName) {
		this.createName = createName;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.lang.String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}
	public java.lang.String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

}
