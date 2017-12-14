package com.yh.component.dynamicproperty.facade;

import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.service.DynamicPropertyConfigService;
import com.yh.platform.core.exception.ServiceException;

public class DynamicPropertyConfigFacade {
	private DynamicPropertyConfigService dynamicPropertyConfigService;
	public void setDynamicPropertyConfigService(
			DynamicPropertyConfigService dynamicPropertyConfigService) {
		this.dynamicPropertyConfigService = dynamicPropertyConfigService;
	}
	/**
	 * 启用/停用 功能字段
	 * @param dpId
	 * @throws ServiceException
	 */
	public void doDynamicPropertyAvailable(String dpId,String status) throws ServiceException {
		// TODO Auto-generated method stub
		dynamicPropertyConfigService.doDynamicPropertyAvailable(dpId,status);
	}
	/**
	 * 修改字段含义
	 * @param dynamicPropertyDto
	 * @throws ServiceException
	 */
	public void updateDpDescription(DynamicPropertyDTO dynamicPropertyDto) throws ServiceException{
		// TODO Auto-generated method stub
		dynamicPropertyConfigService.updateDpDescription(dynamicPropertyDto);
	}

}
