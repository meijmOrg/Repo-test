package com.yh.hr.component.flow.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.CarbonCopyDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.TaskProcessDTO;
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
	
	/**
	 * 列出人员信息
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public List<PermissionUsersDTO> listPersonInfo(TableTagBean ttb) throws ServiceException;
	
	/**
	 * 查询部门、小组、角色
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public JSONObject queryDepGroRole() throws ServiceException;
	
	/**
	 * 查询关键字
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public JSONObject queryKeyWords() throws ServiceException;
	/**
	 * 根据条件获取抄送记录
	 * @param ttb
	 * @return
	 */
	public List<CarbonCopyDTO> listCarbonCopy(TableTagBean ttb)throws ServiceException;

	/** 
	* @Title: listTaskProcess 
	* @Description: 获取流程处理记录 
	* @param ttb
	* @return List<TaskProcessDTO>
	*/ 
	public Map<String, List<TaskProcessDTO>> listTaskProcess(TableTagBean ttb) throws ServiceException;
	
}
