package com.yh.component.workflow.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
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
	WorkflowConfigurationDTO getTempletInfo(Long templetId) throws ServiceException;
	/**
	 * 根据流程ID获取流程信息
	 * @param baseInfoId
	 * @return
	 * @throws ServiceException
	 */
	WorkflowConfigurationDTO getBaseFlowInfo(Long baseInfoId) throws ServiceException;
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
	void insertTemplet(WorkflowConfigurationDTO workflowConfigurationDto)throws ServiceException;
	/**
	 * 修改模板信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	void updateTemplet(WorkflowConfigurationDTO workflowConfigurationDto)throws ServiceException;
	/**
	 * 删除模板记录
	 * @param templetId
	 * @throws ServiceException
	 */
	void deleteTemplet(Long templetId)throws ServiceException;
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
	 * 新增规则信息
	 * @param workflowRuleDto
	 * @throws ServiceException
	 */
	void insertRule(WorkflowRuleDTO workflowRuleDto)throws ServiceException;
	/**
	 * 修改规则信息
	 * @param workflowRuleDto
	 * @throws ServiceException
	 */
	void updateRule(WorkflowRuleDTO workflowRuleDto)throws ServiceException;
	/**
	 * 删除规则信息
	 * @param ruleId
	 * @throws ServiceException
	 */
	void deleteRule(Long ruleId)throws ServiceException;
	/**
	 * 获取规则信息、 构置转移条件信息
	 * @param ruleId
	 * @return
	 * @throws ServiceException
	 */
	WorkflowRuleDTO getRuleInfo(Long ruleId)throws ServiceException;
	/**
	 * 新增活动信息
	 * @param workflowActivityDto
	 * @throws ServiceException
	 */
	void insertActivity(WorkflowActivityDTO workflowActivityDto)throws ServiceException;
	
	/**
	 * 修改活动信息
	 * @param workflowActivityDto
	 * @throws ServiceException
	 */
	void updateActivity(WorkflowActivityDTO workflowActivityDto)throws ServiceException;
	/**
	 * 删除活动信息
	 * @param activityId
	 * @throws ServiceException
	 */
	void deleteActivity(Long activityId)throws ServiceException;
	/**
	 * 获取活动信息、权限控制信息、任务通知信息
	 * @param activityId
	 * @return
	 * @throws ServiceException
	 */
	WorkflowActivityDTO getActivityInfo(Long activityId)throws ServiceException;


}
