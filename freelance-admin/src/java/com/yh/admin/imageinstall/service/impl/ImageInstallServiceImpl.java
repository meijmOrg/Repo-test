package com.yh.admin.imageinstall.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.yh.admin.imageinstall.bo.ImageInstall;
import com.yh.admin.imageinstall.dto.ImageInstallDTO;
import com.yh.admin.imageinstall.queryhelper.ImageInstallQueryHelper;
import com.yh.admin.imageinstall.service.ImageInstallService;
import com.yh.admin.util.SystemConstants;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.web.UserContext;

/**
 * @description 系统外观设置ServiceImpl
 * @author meijm
 * @created 2017-9-16
 * @version 1.0
 */
public class ImageInstallServiceImpl implements ImageInstallService {

	/**
     * 新增或更新系统外观（Logo和Banner）
     * @param imageInstallDTO
     * @return
     * @throws ServiceException
     */
	public void update(ImageInstallDTO imageInstallDTO) throws ServiceException {
		try {
			byte[] lgbs = null;
			byte[] banbs = null;
			String fileName = "";
			String fileName2 = "";
			String systemCode = imageInstallDTO.getSubSystemCode();
			String flag = imageInstallDTO.getFlag();
			if(StringUtils.isEmpty(systemCode)){
				systemCode = SystemConstants.SYSTEM_HR;//默认系统code
			}
			ImageInstall imageInstall = DaoUtil.get(ImageInstall.class,systemCode);
			FormFile logo = imageInstallDTO.getLogoPhotoPath();
			FormFile banner = imageInstallDTO.getBannerPhotoPath();
			if("logo".equals(flag)){//只上传logo
				if (logo != null)
	            {
	                lgbs = logo.getFileData();
	                if (lgbs.length > 0)
	                {
	                    if (!isValidFile(logo.getFileName())) {
	                        throw new ServiceException(null, "照片类型不正确!");
	                    }

	                    int fileSize = logo.getFileSize();
	                    if (fileSize > 500 * 1024) {
	                        throw new ServiceException(null, "上传照片超过了"+500+"k");
	                    }

	                    fileName = logo.getFileName();
	                    int i = fileName.lastIndexOf(".");
	                    fileName = fileName.substring(i + 1);
	                }
	            }
			}else if("banner".equals(flag)){//只上传banner
				if (banner != null)
	            {
	                banbs = banner.getFileData();
	                if (banbs.length > 0)
	                {
	                    if (!isValidFile(banner.getFileName())) {
	                        throw new ServiceException(null, "照片类型不正确!");
	                    }

	                    int fileSize = banner.getFileSize();
	                    if (fileSize > 500 * 1024) {
	                        throw new ServiceException(null, "上传照片超过了"+500+"k");
	                    }

	                    fileName2 = banner.getFileName();
	                    int i = fileName2.lastIndexOf(".");
	                    fileName2 = fileName2.substring(i + 1);
	                }
	            }
			}else{
	            if (logo != null&&banner != null)
	            {
	                lgbs = logo.getFileData();
	                banbs = banner.getFileData();
	                if (lgbs.length > 0&&banbs.length > 0)
	                {
	                    if (!isValidFile(logo.getFileName())||!isValidFile(banner.getFileName())) {
	                        throw new ServiceException(null, "照片类型不正确!");
	                    }
	
	                    int fileSize = logo.getFileSize();
	                    int fileSize2 = banner.getFileSize();
	                    if (fileSize > 500 * 1024||fileSize2 > 500 * 1024) {
	                        throw new ServiceException(null, "上传照片超过了"+500+"k");
	                    }
	
	                    fileName = logo.getFileName();
	                    fileName2 = banner.getFileName();
	                    int i = fileName.lastIndexOf(".");
	                    int j = fileName2.lastIndexOf(".");
	                    fileName = fileName.substring(i + 1);
	                    fileName2 = fileName2.substring(j + 1);
	                }
	            }
			}
            if (null==imageInstall)//没有就新增
            {
            	imageInstall = new ImageInstall();
            	imageInstall.setLogoPhotoType(fileName.toLowerCase());
            	imageInstall.setBannerPhotoType(fileName2.toLowerCase());
            	imageInstall.setSubSystemCode(systemCode);;
            	imageInstall.setLogoPhotoPath(lgbs);
            	imageInstall.setBannerPhotoPath(banbs);
            	imageInstall.setCreateBy(UserContext.getLoginUserID());
            	imageInstall.setCreateName(UserContext.getLoginUserName());
            	imageInstall.setCreateDate(DateUtil.now());
            	imageInstall.save();
            	ImageInstall imageInstall1 = DaoUtil.get(ImageInstall.class,systemCode);
                System.out.println(imageInstall1);
            }
            else
            {
//            	imageInstall.setSubSystemCode(systemCode);
            	if("logo".equals(flag)){
            		imageInstall.setLogoPhotoPath(lgbs);
            		imageInstall.setLogoPhotoType(fileName.toLowerCase());
            	}else if("banner".equals(flag)){
            		imageInstall.setBannerPhotoPath(banbs);
            		imageInstall.setBannerPhotoType(fileName2.toLowerCase());
            	}else{
            		imageInstall.setLogoPhotoPath(lgbs);
            		imageInstall.setBannerPhotoPath(banbs);
            		imageInstall.setLogoPhotoType(fileName.toLowerCase());
            		imageInstall.setBannerPhotoType(fileName2.toLowerCase());
            	}
            	imageInstall.setUpdateBy(UserContext.getLoginUserID());
            	imageInstall.setUpdateName(UserContext.getLoginUserName());
            	imageInstall.setUpdateDate(DateUtil.now());
            	imageInstall.update();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(null,e.getMessage());
        }
	}
	
	/**
     * 验证上传的文件格式
     */
    private boolean isValidFile(String fileName)
    {
        String[] validFiles = { "gif", "jpg", "jpeg", "jpe", "tif", "tiff", "png", "bmp", "dib" };
        boolean ret = false;
        for (int i = 0; i < validFiles.length; i++)
        {
            if (fileName.toLowerCase().endsWith(validFiles[i]))
            {
                ret = true;
                break;
            }
        }
        return ret;
    }
    
    /**
     * 根据systemCode获取imageinstall信息（Logo和Banner）
     * @param systemCode
     * @return
     * @throws ServiceException
     */
    public ImageInstallDTO get(String systemCode) throws ServiceException{
    	ImageInstallDTO dto = new ImageInstallDTO();
    	ImageInstall imageInstall = DaoUtil.get(ImageInstall.class,systemCode);
    	if(null == imageInstall){
    		return null;
    	}else{
    		dto.setSubSystemCode(systemCode);
    		dto.setLogoPhotoPathB(imageInstall.getLogoPhotoPath());
    		dto.setBannerPhotoPathB(imageInstall.getBannerPhotoPath());
    		dto.setLogoPhotoType(imageInstall.getLogoPhotoType());
    		dto.setBannerPhotoType(imageInstall.getBannerPhotoType());
    		return dto;
    	}
    }
    
    /**
     * 获取系统id
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public String getSystemCode() throws ServiceException{
		return ImageInstallQueryHelper.getSystemCode();
	}
}
