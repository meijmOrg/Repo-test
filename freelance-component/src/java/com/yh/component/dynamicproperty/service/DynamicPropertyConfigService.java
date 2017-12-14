package com.yh.component.dynamicproperty.service;

import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.platform.core.exception.ServiceException;
/**
 * @desc 功能字段配置Service
 * @author liul
 * @createDate 2017-11-09
 */
public interface DynamicPropertyConfigService {

	/**
	 * 启用/停用 功能字段
	 * @param dpId
	 * @throws ServiceException
	 */
	public void doDynamicPropertyAvailable(String dpId,String status)throws ServiceException;
	/**
	 * 修改字段含义
	 * @param dynamicPropertyDto
	 * @throws ServiceException
	 */
	public void updateDpDescription(DynamicPropertyDTO dynamicPropertyDto)throws ServiceException;


}
