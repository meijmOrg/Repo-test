package com.yh.hr.worktop.service.impl;

import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.service.YhfTaskManageService;
import com.yh.hr.worktop.factory.TaskCreatedFactory;
import com.yh.hr.worktop.factory.TaskSaveHisFactory;
import com.yh.hr.worktop.factory.TaskSaveTempFactory;
import com.yh.hr.worktop.factory.TaskSighFactory;
import com.yh.platform.core.exception.ServiceException;


public class YhfTaskManageServiceImpl 
{
	/**
	 * 创建业务事项
	 * @param YhFlowComponentDTO
	 * @throws ServiceException
	 */
	public static void createBizVacationInfo(YhFlowComponentDTO dto)throws ServiceException
	{
		YhfTaskManageService YhfTaskManageService = TaskCreatedFactory.getBizCreateWorktopService(dto);
		YhfTaskManageService.submitFlowStart(dto);
	}
	
	/**
	 * 业务事项加签
	 * @param YhFlowComponentDTO
	 * @throws ServiceException
	 */
	public static void submitSighUsers(YhFlowComponentDTO dto)throws ServiceException
	{
		YhfTaskManageService YhfTaskManageService = TaskSighFactory.getBizSighWorktopService(dto);
		YhfTaskManageService.submitSighUsers(dto);
	}
	
	/**
	 * 表单暂存
	 * @param YhFlowComponentDTO
	 * @throws ServiceException
	 */
	public static void saveTemporaryStorage(YhFlowComponentDTO dto)throws ServiceException
	{
		YhfTaskManageService YhfTaskManageService = TaskSaveTempFactory.getBizSaveTempService(dto);
		YhfTaskManageService.saveTemporaryStorage();
	}
	
	/**
	 * 保存历史数据
	 * @param YhFlowComponentDTO
	 * @throws ServiceException
	 */
	public static void saveHisVacationInfo(YhFlowComponentDTO dto)throws ServiceException
	{
		YhfTaskManageService YhfTaskManageService = TaskSaveHisFactory.getBizSaveHisService(dto);
		YhfTaskManageService.saveHistoryData();;
	}
	
}
