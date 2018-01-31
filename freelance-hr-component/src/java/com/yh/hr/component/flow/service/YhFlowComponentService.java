package com.yh.hr.component.flow.service;

import java.util.List;
import java.util.Map;

import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.platform.core.exception.ServiceException;

public interface YhFlowComponentService {

	/**
	 * 根据模板Id获取活动单元和用户集合
	 * @param templateId
	 * @return
	 * @throws ServiceException
	 */
	public Map<String, List<WorkflowActivityDTO>> goUserListPartial(String templateId) throws ServiceException;

}
