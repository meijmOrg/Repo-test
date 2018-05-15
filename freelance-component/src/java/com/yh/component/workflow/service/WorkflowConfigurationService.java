package com.yh.component.workflow.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
import com.yh.component.workflow.vo.DrawingFlow;
import com.yh.platform.core.exception.ServiceException;

/**
 * @desc 流程-模板管理Service
 * @author liul
 * @createDate 2017-11-15
 */
public interface WorkflowConfigurationService {
	/**
	 * 获取模板列表
	 * @param ttb
	 * @return
	 * @throws ServiceException
	 */
	List<JSONObject> listWorkflowTemplet(TableTagBean ttb) throws ServiceException;
	/**
	 * 根据模板ID获取模板信息
	 * @param templetId
	 * @return
	 * @throws ServiceException
	 */
	WorkflowConfigurationDTO getTempletInfo(String templetId) throws ServiceException;
	/**
	 * 根据流程ID获取流程信息
	 * @param baseInfoId
	 * @return
	 * @throws ServiceException
	 */
	WorkflowConfigurationDTO getBaseFlowInfo(String baseInfoId) throws ServiceException;
	/**
	 * 获取部门信息
	 * @return
	 * @throws ServiceException
	 */
	List<WorkflowBaseInfoDTO> findOrg(TableTagBean ttb)throws ServiceException;
	/**
	 * 新增模板信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	String insertTemplet(WorkflowConfigurationDTO workflowConfigurationDto)throws ServiceException;
	/**
	 * 修改模板信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	String updateTemplet(WorkflowConfigurationDTO workflowConfigurationDto)throws ServiceException;
	/**
	 * 删除模板记录
	 * @param templetId
	 * @throws ServiceException
	 */
	void deleteTemplet(String templetId)throws ServiceException;
	/**
	 * 修改流程信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	void updateFlow(WorkflowConfigurationDTO workflowConfigurationDto)throws ServiceException;
	/**
	 * 删除流程记录
	 * @param baseInfoId
	 * @throws ServiceException
	 */
	void deleteFlow(Long baseInfoId)throws ServiceException;
	/**
	 * 保存流程信息
	 * @param df
	 * @throws ServiceException
	 */
	void saveRuleFlow(DrawingFlow df) throws ServiceException;


}
