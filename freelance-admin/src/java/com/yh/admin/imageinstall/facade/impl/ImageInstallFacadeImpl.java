package com.yh.admin.imageinstall.facade.impl;

import com.yh.admin.imageinstall.dto.ImageInstallDTO;
import com.yh.admin.imageinstall.facade.ImageInstallFacade;
import com.yh.admin.imageinstall.service.ImageInstallService;
import com.yh.platform.core.exception.ServiceException;

/**
 * @description 系统外观设置FacadeImpl
 * @author meijm
 * @created 2017-9-16
 * @version 1.0
 */
public class ImageInstallFacadeImpl implements ImageInstallFacade {
	
	private ImageInstallService imageInstallService;

	public void setImageInstallService(ImageInstallService imageInstallService) {
		this.imageInstallService = imageInstallService;
	}

	/**
     * 新增或更新系统外观（Logo和Banner）
     * @param imageInstallDTO
     * @return
     * @throws ServiceException
     */
	public void update(ImageInstallDTO imageInstallDTO) throws ServiceException {
		imageInstallService.update(imageInstallDTO);
	}
	
	/**
     * 根据systemCode获取imageinstall信息（Logo和Banner）
     * @param systemCode
     * @return
     * @throws ServiceException
     */
    public ImageInstallDTO get(String systemCode) throws ServiceException{
    	return imageInstallService.get(systemCode);
    }
    
    /**
     * 获取系统id
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public String getSystemCode() throws ServiceException{
		return imageInstallService.getSystemCode();
	}
}
