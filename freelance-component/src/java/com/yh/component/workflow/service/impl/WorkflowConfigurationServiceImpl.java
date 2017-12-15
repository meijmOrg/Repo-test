package com.yh.component.workflow.service.impl;



import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.BeanUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.FileTemplate;
import com.yh.component.workflow.bo.Flow;
import com.yh.component.workflow.bo.FlowActivity;
import com.yh.component.workflow.bo.FlowRule;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
import com.yh.component.workflow.queryhelper.WorkflowConfigurationQueryHelper;
import com.yh.component.workflow.service.WorkflowConfigurationService;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.StringUtil;
/**
 * @desc 流程-模板管理ServiceImpl
 * @author liul
 * @createDate 2017-11-15
 */
public class WorkflowConfigurationServiceImpl implements WorkflowConfigurationService{
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#listWorkflowConfiguration(com.yh.component.taglib.TableTagBean)
	 */
	public List<JSONObject> listWorkflowTemplet(TableTagBean ttb)
			throws ServiceException {
		// TODO Auto-generated method stub
		return WorkflowConfigurationQueryHelper.listWorkflowTemplet(ttb);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#get(java.lang.Long)
	 */
	public WorkflowConfigurationDTO getTempletInfo(String templetId) throws ServiceException {
		// TODO Auto-generated method stub
		WorkflowConfigurationDTO dto = new WorkflowConfigurationDTO();
		//获取模板信息
		FileTemplate bo =DaoUtil.get(FileTemplate.class, templetId);
		BeanUtils.copyProperties(bo, dto);
		//获取流程信息 （并获取流程是否能删除标识？？？？？）
		List<WorkflowBaseInfoDTO> list= WorkflowConfigurationQueryHelper.listFlowBaseInfo(templetId);
		dto.setBaseInfoList(list);
		return dto;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#getBaseFlowInfo(java.lang.Long)
	 */
	public WorkflowConfigurationDTO getBaseFlowInfo(String baseInfoId) throws ServiceException {
		// TODO Auto-generated method stub
		WorkflowConfigurationDTO dto = new WorkflowConfigurationDTO();
		//根据流程Id获取流程信息yhf_flow_base_info
		Flow bo= DaoUtil.get(Flow.class, baseInfoId);
		BeanUtils.copyProperties(bo, dto);
		//根据流程Id获取活动列表yhf_flow_activity
		List<WorkflowActivityDTO> activityList= WorkflowConfigurationQueryHelper.listFlowActivity(baseInfoId);
		//根据流程ID获取规则列表yhf_flow_rule
		List<WorkflowRuleDTO> ruleList= WorkflowConfigurationQueryHelper.listFlowRule(baseInfoId);
		dto.setActivityList(activityList);
		dto.setRuleList(ruleList);
		return dto;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#findOrg()
	 */
	public List<WorkflowBaseInfoDTO> findOrg(TableTagBean ttb) throws ServiceException {
		// TODO Auto-generated method stub
		return WorkflowConfigurationQueryHelper.findOrg(ttb);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#insert(com.yh.component.workflow.dto.WorkflowConfigurationDTO)
	 */
	public String insertTemplet(WorkflowConfigurationDTO workflowConfigurationDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FileTemplate bo=new FileTemplate();
		BeanUtils.copyProperties(workflowConfigurationDto, bo);
		bo.setTemplateId(StringUtil.getUUID());
		bo.save();
		return bo.getTemplateId();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#update(com.yh.component.workflow.dto.WorkflowConfigurationDTO)
	 */
	public String updateTemplet(WorkflowConfigurationDTO workflowConfigurationDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FileTemplate bo=new FileTemplate();
		BeanUtils.copyProperties(workflowConfigurationDto, bo);
		bo.update();
		return bo.getTemplateId();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#delete(java.lang.Long)
	 */
	public void deleteTemplet(String templetId) throws ServiceException {
		// TODO Auto-generated method stub
		FileTemplate bo=DaoUtil.get(FileTemplate.class, templetId);
		if(bo!=null){
			bo.delete();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#updateFlow(com.yh.component.workflow.dto.WorkflowConfigurationDTO)
	 */
	public void updateFlow(WorkflowConfigurationDTO workflowConfigurationDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		Flow bo=new Flow();
		BeanUtils.copyProperties(workflowConfigurationDto, bo);
		bo.update();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#deleteFlow(java.lang.Long)
	 */
	public void deleteFlow(Long baseInfoId) throws ServiceException {
		// TODO Auto-generated method stub
		Flow bo=DaoUtil.get(Flow.class, baseInfoId);
		if(bo!=null){
			bo.delete();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#insertRule(com.yh.component.workflow.dto.WorkflowRuleDTO)
	 */
	public void insertRule(WorkflowRuleDTO workflowRuleDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FlowRule bo=new FlowRule();
		BeanUtils.copyProperties(workflowRuleDto, bo);
		bo.setRuleId(StringUtil.getUUID());
		bo.save();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#updateRule(com.yh.component.workflow.dto.WorkflowRuleDTO)
	 */
	public void updateRule(WorkflowRuleDTO workflowRuleDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FlowRule bo=new FlowRule();
		BeanUtils.copyProperties(workflowRuleDto, bo);
		bo.update();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#deleteRule(java.lang.Long)
	 */
	public void deleteRule(Long ruleId) throws ServiceException {
		// TODO Auto-generated method stub
		FlowRule bo=DaoUtil.get(FlowRule.class, ruleId);
		if(bo!=null){
			bo.delete();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#getRuleInfo(java.lang.Long)
	 */
	public WorkflowRuleDTO getRuleInfo(Long ruleId)
			throws ServiceException {
		// TODO Auto-generated method stub
		WorkflowRuleDTO dto = new WorkflowRuleDTO();
		//获取规则信息
		FlowRule bo =DaoUtil.get(FlowRule.class, ruleId);
		BeanUtils.copyProperties(bo, dto);
		//获取构置转移条件信息 
		//List<WorkflowBaseInfoDTO> list= WorkflowConfigurationQueryHelper.listFlowBaseInfo(templetId);
		//dto.setBaseInfoList(list);
		return dto;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#insertActivity(com.yh.component.workflow.dto.WorkflowActivityDTO)
	 */
	public void insertActivity(WorkflowActivityDTO workflowActivityDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FlowActivity bo=new FlowActivity();
		BeanUtils.copyProperties(workflowActivityDto, bo);
		bo.setActId(StringUtil.getUUID());
		bo.save();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#updateActivity(com.yh.component.workflow.dto.WorkflowActivityDTO)
	 */
	public void updateActivity(WorkflowActivityDTO workflowActivityDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FlowActivity bo=new FlowActivity();
		BeanUtils.copyProperties(workflowActivityDto, bo);
		bo.update();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#deleteActivity(java.lang.Long)
	 */
	public void deleteActivity(Long activityId) throws ServiceException {
		// TODO Auto-generated method stub
		FlowActivity bo=DaoUtil.get(FlowActivity.class, activityId);
		if(bo!=null){
			bo.delete();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#getActivityInfo(java.lang.Long)
	 */
	public WorkflowActivityDTO getActivityInfo(Long activityId)
			throws ServiceException {
		// TODO Auto-generated method stub
		WorkflowActivityDTO dto = new WorkflowActivityDTO();
		//获取活动信息
		FlowActivity bo =DaoUtil.get(FlowActivity.class, activityId);
		BeanUtils.copyProperties(bo, dto);
		//获取权限控制信息 
		//List<WorkflowBaseInfoDTO> list= WorkflowConfigurationQueryHelper.listFlowBaseInfo(templetId);
		//dto.setBaseInfoList(list);
		//获取任务通知信息
		return dto;
	}
}
