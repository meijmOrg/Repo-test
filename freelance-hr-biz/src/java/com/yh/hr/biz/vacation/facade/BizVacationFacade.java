package com.yh.hr.biz.vacation.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.biz.vacation.dto.YhfVacationDTO;
import com.yh.hr.biz.vacation.service.BizVacationService;
import com.yh.hr.worktop.service.impl.YhfTaskManageServiceImpl;
import com.yh.platform.core.exception.ServiceException;
/**
 * @Description: 请休假业务Facade
 * @author: meijm
 * @date: 2018-6-10
 */
public class BizVacationFacade {
	
	private BizVacationService bizVacationService;

	public void setBizVacationService(BizVacationService bizVacationService) {
		this.bizVacationService = bizVacationService;
	}
	/** 
	* @Title: listVacationInfo 
	* @Description: 获取请休假业务列表 
	* @param ttb
	* @return List<JSONObject>
	*/ 
	public List<JSONObject> listVacationInfo(TableTagBean ttb) throws ServiceException{
		return bizVacationService.listVacationInfo(ttb);
	}
	
	/**
	 * 提交流程（确定）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitFlowStart(YhfVacationDTO dto) throws ServiceException{
		YhfTaskManageServiceImpl.createBizVacationInfo(dto);;
	}
	
	/**
	 * 加签（确定）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitSighUsers(YhfVacationDTO dto) throws ServiceException{
		YhfTaskManageServiceImpl.submitSighUsers(dto);;
	}
	
	/** 
	* @Description: 请休假表单暂存
	* @param YhfVacationDTO
	* @return 
	*/ 
	public void saveVacationInfo(YhfVacationDTO dto) throws ServiceException{
		YhfTaskManageServiceImpl.saveTemporaryStorage(dto);
	}
	
	/** 
	* @Description: 请休假保存历史数据
	* @param YhfVacationDTO
	* @return 
	*/ 
	public void saveHisVacationInfo(YhfVacationDTO dto) throws ServiceException{
		YhfTaskManageServiceImpl.saveHisVacationInfo(dto);
	}
	
	/** 
	* @Description: 根据ID请休假表单数据 
	* @param vacationId
	* @return 
	*/ 
	public YhfVacationDTO getVacationInfo(String vacationId) throws ServiceException{
		return bizVacationService.getVacationInfo(vacationId);
	}
}
