package com.yh.component.workflow.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
import com.yh.component.workflow.service.WorkflowConfigurationService;
import com.yh.platform.core.exception.ServiceException;
/**
 * @desc 流程-模板管理Facade
 * @author liul
 * @createDate 2017-11-15
 */
public class WorkflowConfigurationFacade {
	private WorkflowConfigurationService workflowConfigurationService;
	public void setWorkflowConfigurationService(
			WorkflowConfigurationService workflowConfigurationService) {
		this.workflowConfigurationService = workflowConfigurationService;
	}
	/**
	 * 获取模板列表
	 * @param ttb
	 * @return
	 * @throws ServiceException
	 */
	public List<JSONObject> listWorkflowTemplet(TableTagBean ttb) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.listWorkflowTemplet(ttb);
	}
	/**
	 * 获取模板信息和流程信息
	 * @param templetId
	 * @return
	 * @throws ServiceException
	 */
	public WorkflowConfigurationDTO getTempletInfo(Long templetId) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.getTempletInfo(templetId);
	}
	/**
	 * 获取流程信息、活动信息和规则信息
	 * @param baseInfoId
	 * @return
	 * @throws ServiceException
	 */
	public WorkflowConfigurationDTO getBaseFlowInfo(Long baseInfoId) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.getBaseFlowInfo(baseInfoId);
	}
	/**
	 * 获取部门信息
	 * @return
	 * @throws ServiceException
	 */
	public List<WorkflowBaseInfoDTO> findOrg(TableTagBean ttb) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.findOrg(ttb);
	}
	/**
	 * 删除模板记录
	 * @param templetId
	 * @throws ServiceException
	 */
	public void deleteTemplet(Long templetId) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.deleteTemplet(templetId);
		
	}
	/**
	 * 修改模板信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	public void updateTemplet(WorkflowConfigurationDTO workflowConfigurationDto) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.updateTemplet(workflowConfigurationDto);
	}
	/**
	 * 新增模板信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	public void insertTemplet(WorkflowConfigurationDTO workflowConfigurationDto) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.insertTemplet(workflowConfigurationDto);
		
	}
	/**
	 * 删除流程记录
	 * @param baseInfoId
	 * @throws ServiceException
	 */
	public void deleteFlow(Long baseInfoId) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.deleteFlow(baseInfoId);
		
	}
	/**
	 * 修改流程信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	public void updateFlow(WorkflowConfigurationDTO workflowConfigurationDto) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.updateFlow(workflowConfigurationDto);
	}
	/**
	 * 获取活动信息、权限控制信息、任务通知信息
	 * @param activityId
	 * @return
	 * @throws ServiceException
	 */
	public WorkflowActivityDTO getActivityInfo(Long activityId) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.getActivityInfo(activityId);
	}
	/**
	 * 删除活动记录
	 * @param activityId
	 * @throws ServiceException
	 */
	public void deleteActivity(Long activityId) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.deleteActivity(activityId);
		
	}
	/**
	 * 修改活动信息
	 * @param workflowActivityDto
	 * @throws ServiceException
	 */
	public void updateActivity(WorkflowActivityDTO workflowActivityDto) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.updateActivity(workflowActivityDto);
	}
	/**
	 * 新增活动信息
	 * @param workflowActivityDto
	 * @throws ServiceException
	 */
	public void insertActivity(WorkflowActivityDTO workflowActivityDto) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.insertActivity(workflowActivityDto);
	}
	/**
	 * 获取规则信息、构置转移条件信息
	 * @param ruleId
	 * @return
	 * @throws ServiceException
	 */
	public WorkflowRuleDTO getRuleInfo(Long ruleId) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.getRuleInfo(ruleId);
	}
	/**
	 * 删除规则记录
	 * @param ruleId
	 * @throws ServiceException
	 */
	public void deleteRule(Long ruleId) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.deleteRule(ruleId);
		
	}
	/**
	 * 修改规则信息
	 * @param workflowRuleDto
	 * @throws ServiceException
	 */
	public void updateRule(WorkflowRuleDTO workflowRuleDto) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.updateRule(workflowRuleDto);
	}
	/**
	 * 新增规则信息
	 * @param workflowRuleDto
	 * @throws ServiceException
	 */
	public void insertRule(WorkflowRuleDTO workflowRuleDto) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.insertRule(workflowRuleDto);
	}
}
