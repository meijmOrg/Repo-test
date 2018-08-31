package com.yh.hr.worktop.factory;

import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.service.YhfTaskManageService;
import com.yh.hr.component.flow.service.impl.YhFlowComponentAbstractServiceImpl;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.SpringBeanUtil;

/**
 *	业务加签事项创建工厂- Factory
 *	@author		meijm
 *	@created	2018-08-17
 */
public class TaskSighFactory
{
	private final static String PREFIX_SIGHTASK = "sighTask";	// 加签
	
	/**
	 *	业务事项创建
	*	@param	YhFlowComponentDTO			事项信息
	 *	@return YhFlowComponentService		
	 *	@throws ServiceException
	 */
	public static YhfTaskManageService getBizSighWorktopService(YhFlowComponentDTO dto) throws ServiceException
	{
		String beanId = PREFIX_SIGHTASK + dto.getTaskFlag();
		YhFlowComponentAbstractServiceImpl YhFlowComponentAbstractServiceImpl = (YhFlowComponentAbstractServiceImpl) SpringBeanUtil.getBean(beanId);
		YhFlowComponentAbstractServiceImpl.setYhFlowComponentDTO(dto);
		return (YhfTaskManageService) YhFlowComponentAbstractServiceImpl;
	}
}