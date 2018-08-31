package com.yh.hr.orghc.workgroup.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.orghc.workgroup.dto.WorkGroupDTO;
import com.yh.platform.core.exception.ServiceException;


public interface WorkGroupService {
    /**
     * 查询工作组信息
     * @param ttb
     * @return
     */
	List<WorkGroupDTO> listWorkGroup(TableTagBean ttb)throws ServiceException;
    /**
     * 创建小组信息
     * @param dto
     */
	void create(WorkGroupDTO dto)throws ServiceException;
	/**
	 * 查询小组信息
	 * @param wpId
	 * @return
	 * @throws ServiceException
	 */
	WorkGroupDTO getWorkGroup(String wpId)throws ServiceException;

	/**
	 * 更新小组信息
	 * @param wpId
	 * @return
	 * @throws ServiceException
	 */
	void updateWorkGroup(WorkGroupDTO dto)throws ServiceException;
	
	/**
	 * 删除小组信息
	 * @param wpId
	 * @return
	 * @throws ServiceException
	 */
	void deleteWorkGroup(String wpId)throws ServiceException;
}
