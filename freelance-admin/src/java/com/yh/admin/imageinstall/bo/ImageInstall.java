package com.yh.admin.imageinstall.bo;

import com.yh.platform.core.bo.BaseBo;

/**
 * @description 系统外观设置bo
 * @author meijm
 * @created 2017-9-16
 * @version 1.0
 */
public class ImageInstall extends BaseBo implements java.io.Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -720374874122438022L;
	
	private java.lang.String subSystemCode;
    /**
     *logo图片
     **/
	private byte[] logoPhotoPath;
    /**
     *logo图片扩展名
     **/
	private java.lang.String logoPhotoType;
	/**
     *BANNER图片
     **/
	private byte[] bannerPhotoPath;
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

	public ImageInstall() {
		
	}

	public java.lang.String getSubSystemCode() {
		return subSystemCode;
	}

	public void setSubSystemCode(java.lang.String subSystemCode) {
		this.subSystemCode = subSystemCode;
	}

	public byte[] getLogoPhotoPath() {
		return logoPhotoPath;
	}

	public void setLogoPhotoPath(byte[] logoPhotoPath) {
		this.logoPhotoPath = logoPhotoPath;
	}

	public java.lang.String getLogoPhotoType() {
		return logoPhotoType;
	}

	public void setLogoPhotoType(java.lang.String logoPhotoType) {
		this.logoPhotoType = logoPhotoType;
	}

	public byte[] getBannerPhotoPath() {
		return bannerPhotoPath;
	}

	public void setBannerPhotoPath(byte[] bannerPhotoPath) {
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
