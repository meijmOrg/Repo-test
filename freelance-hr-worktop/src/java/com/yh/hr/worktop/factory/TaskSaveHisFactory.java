package com.yh.hr.worktop.factory;

import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.service.YhfTaskManageService;
import com.yh.hr.component.flow.service.impl.YhFlowComponentAbstractServiceImpl;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.SpringBeanUtil;

/**
 *	业务保存历史数据创建工厂- Factory
 *	@author		meijm
 *	@created	2018-06-25
 */
public class TaskSaveHisFactory
{
	private final static String PREFIX_HISTASK = "saveHis";	// 历史数据保存
	
	/**
	 *	历史数据保存
	 *	@param	YhFlowComponentDTO			事项信息
	 *	@return YhFlowComponentService		
	 *	@throws ServiceException
	 */
	public static YhfTaskManageService getBizSaveHisService(YhFlowComponentDTO dto) throws ServiceException
	{
		String beanId = PREFIX_HISTASK + dto.getTaskFlag();
		YhFlowComponentAbstractServiceImpl YhFlowComponentAbstractServiceImpl = (YhFlowComponentAbstractServiceImpl) SpringBeanUtil.getBean(beanId);
		YhFlowComponentAbstractServiceImpl.setYhFlowComponentDTO(dto);
		return (YhfTaskManageService) YhFlowComponentAbstractServiceImpl;
	}
}