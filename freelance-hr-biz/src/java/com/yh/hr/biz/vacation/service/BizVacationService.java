package com.yh.hr.biz.vacation.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.biz.vacation.dto.YhfVacationDTO;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.platform.core.exception.ServiceException;

/**
 * @Description: 请休假业务Service
 * @author: meijm
 * @date: 2018-6-10
 */
public interface BizVacationService {

	/** 
	* @Title: listVacationInfo 
	* @Description: 获取请休假业务列表 
	* @param ttb
	* @return List<JSONObject>
	*/ 
	List<JSONObject> listVacationInfo(TableTagBean ttb) throws ServiceException;
	
	/** 
	* @Description: 请休假表单暂存或历史数据保存 
	* @param YhfVacationDTO
	* @return 
	*/ 
	public void saveVacationInfo(YhfVacationDTO dto) throws ServiceException;
	
	/** 
	* @Description: 请休假表单暂存或历史数据保存 
	* @param YhFlowComponentDTO
	* @return 
	*/ 
	public void createSubTaskInfo(YhFlowComponentDTO dto) throws ServiceException;
	
	/** 
	* @Description: 根据ID请休假表单数据 
	* @param vacationId
	* @return 
	*/ 
	public YhfVacationDTO getVacationInfo(String vacationId) throws ServiceException;

}
