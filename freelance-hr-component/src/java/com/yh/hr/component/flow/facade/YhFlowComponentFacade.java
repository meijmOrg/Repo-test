package com.yh.hr.component.flow.facade;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
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
	public List<JSONObject> listPersonInfo(TableTagBean ttb) throws ServiceException{
		return yhFlowComponentService.listPersonInfo(ttb);
	}
	
	/**
	 * 抄送用户(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitCcUsers(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowComponentService.submitCcUsers(dto);
	}
}
