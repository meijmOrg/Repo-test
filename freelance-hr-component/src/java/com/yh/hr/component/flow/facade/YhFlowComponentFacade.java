package com.yh.hr.component.flow.facade;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.CarbonCopyDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.TaskProcessDTO;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.service.YhFlowComponentService;
import com.yh.platform.core.exception.ServiceException;

public class YhFlowComponentFacade {
	
	private YhFlowComponentService yhFlowComponentService;

	public void setYhFlowComponentService(
			YhFlowComponentService yhFlowComponentService) {
		this.yhFlowComponentService = yhFlowComponentService;
	}


	/**
	 * 根据模板Id获取活动单元和用户集合
	 * @param templateId
	 * @return
	 * @throws ServiceException
	 */
	public Map<String, List<WorkflowActivityDTO>> goUserListPartial(String templateId) throws ServiceException{
		return yhFlowComponentService.goUserListPartial(templateId);
	}
	
	/**
	 * 提交流程（确定）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitFlowStart(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowComponentService.submitFlowStart(dto);
	}
	
	/**
	 * 表单数据暂存
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void saveTemporaryStorage(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowComponentService.saveTemporaryStorage(dto);
	}
	
	/**
	 * 历史数据
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void saveHistoryData(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowComponentService.saveHistoryData(dto);
	}
	
	/**
	 * 列出人员信息
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public List<PermissionUsersDTO> listPersonInfo(TableTagBean ttb) throws ServiceException{
		return yhFlowComponentService.listPersonInfo(ttb);
	}
	
	/**
	 * 加签(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitSighUsers(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowComponentService.submitSighUsers(dto);
	}
	
	/**
	 * 抄送用户(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitCsUsers(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowComponentService.submitCsUsers(dto);
	}
	
	/**
	 * 查询部门、小组、角色
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public JSONObject queryDepGroRole() throws ServiceException {
		return yhFlowComponentService.queryDepGroRole();
		
	}
	
	/**
	 * 查询关键字信息
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public JSONObject queryKeyWord() throws ServiceException {
		return yhFlowComponentService.queryKeyWords();
	}
	/**
	 * 根据条件获取抄送记录
	 * @param ttb
	 * @return
	 */
	public List<CarbonCopyDTO> listCarbonCopy(TableTagBean ttb) throws ServiceException{
		return yhFlowComponentService.listCarbonCopy(ttb);
	}

	/** 
	* @Title: listTaskProcess 
	* @Description: 获取流程处理记录 
	* @param ttb
	* @return List<TaskProcessDTO>
	*/ 
	public Map<String, List<TaskProcessDTO>> listTaskProcess(TableTagBean ttb) throws ServiceException{
		return yhFlowComponentService.listTaskProcess(ttb);
	}
}
