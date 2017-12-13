package com.yh.admin.imageinstall.service;

import com.yh.admin.imageinstall.dto.ImageInstallDTO;
import com.yh.platform.core.exception.ServiceException;

/**
 * @description 系统外观设置Service
 * @author meijm
 * @created 2017-9-16
 * @version 1.0
 */
public interface ImageInstallService {

	/**
     * 新增或更新系统外观（Logo和Banner）
     * @param imageInstallDTO
     * @return
     * @throws ServiceException
     */
	void update(ImageInstallDTO imageInstallDTO) throws ServiceException;
	
	/**
     * 根据systemCode获取imageinstall信息（Logo和Banner）
     * @param systemCode
     * @return
     * @throws ServiceException
     */
    public ImageInstallDTO get(String systemCode) throws ServiceException;
    
    /**
     * 获取系统id
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public String getSystemCode() throws ServiceException;

}
