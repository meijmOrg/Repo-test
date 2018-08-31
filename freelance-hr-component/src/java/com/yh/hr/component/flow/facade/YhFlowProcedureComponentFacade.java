package com.yh.hr.component.flow.facade;

import java.util.List;
import java.util.Map;

import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.service.YhFlowProcedureComponentService;
import com.yh.platform.core.exception.ServiceException;

public class YhFlowProcedureComponentFacade {
	
	private YhFlowProcedureComponentService yhFlowProcedureComponentService;

	public void setYhFlowProcedureComponentService(
			YhFlowProcedureComponentService yhFlowProcedureComponentService) {
		this.yhFlowProcedureComponentService = yhFlowProcedureComponentService;
	}


	/**
	 * 获取下一步活动单元和用户集合
	 * @param YhFlowComponentDTO
	 * @return
	 * @throws ServiceException
	 */
	public Map<String, List<WorkflowActivityDTO>> goUserListPartial(YhFlowComponentDTO fdto) throws ServiceException{
		return yhFlowProcedureComponentService.goUserListPartial(fdto);
	}
	
	/**
	 * 提交流程（确定）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitFlowStart(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowProcedureComponentService.submitFlowStart(dto);
	}
	
	/**
	 * 退回
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void recheckBack(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowProcedureComponentService.recheckBack(dto);
	}
	
	/**
	 * 加签(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitSighUsers(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowProcedureComponentService.submitSighUsers(dto);
	}
	
	/**
	 * 抄送用户(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitCsUsers(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowProcedureComponentService.submitCsUsers(dto);
	}
	
	/**
	 * 协同(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitCoordinationUsers(YhFlowComponentDTO dto) throws ServiceException{
		yhFlowProcedureComponentService.submitCoordinationUsers(dto);
	}
	
}
