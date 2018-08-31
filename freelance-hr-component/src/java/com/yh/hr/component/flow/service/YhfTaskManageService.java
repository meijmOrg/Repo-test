package com.yh.hr.component.flow.service;

import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.platform.core.exception.ServiceException;

public interface YhfTaskManageService {

	/**
	 * 提交流程（确定）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitFlowStart(YhFlowComponentDTO dto) throws ServiceException;
	
	/**
	 * 表单数据暂存
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void saveTemporaryStorage() throws ServiceException;
	
	/**
	 * 历史数据
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void saveHistoryData() throws ServiceException;
	
	/**
	 * 加签(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitSighUsers(YhFlowComponentDTO dto) throws ServiceException;
	
}
