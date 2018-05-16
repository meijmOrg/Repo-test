package com.yh.component.workflow.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
import com.yh.component.workflow.service.WorkflowConfigurationService;
import com.yh.component.workflow.vo.DrawingFlow;
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
	public WorkflowConfigurationDTO getTempletInfo(String templetId) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.getTempletInfo(templetId);
	}
	/**
	 * 获取流程信息、活动信息和规则信息
	 * @param baseInfoId
	 * @return
	 * @throws ServiceException
	 */
	public WorkflowConfigurationDTO getBaseFlowInfo(String baseInfoId) throws ServiceException{
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
	public void deleteTemplet(String templetId) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.deleteTemplet(templetId);
		
	}
	/**
	 * 修改模板信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	public String updateTemplet(WorkflowConfigurationDTO workflowConfigurationDto) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.updateTemplet(workflowConfigurationDto);
	}
	/**
	 * 新增模板信息
	 * @param workflowConfigurationDto
	 * @throws ServiceException
	 */
	public String insertTemplet(WorkflowConfigurationDTO workflowConfigurationDto) throws ServiceException{
		// TODO Auto-generated method stub
		return workflowConfigurationService.insertTemplet(workflowConfigurationDto);
		
	}
	/**
	 * 删除流程记录
	 * @param baseInfoId
	 * @throws ServiceException
	 */
	public void deleteFlow(String baseInfoId) throws ServiceException{
		// TODO Auto-generated method stub
		workflowConfigurationService.deleteFlow(baseInfoId);
		
	}
	public void saveRuleFlow(DrawingFlow df)  throws ServiceException{
		workflowConfigurationService.saveRuleFlow(df);
	}
}
