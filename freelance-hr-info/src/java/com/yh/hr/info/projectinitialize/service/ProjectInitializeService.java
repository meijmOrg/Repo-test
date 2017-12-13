package com.yh.hr.info.projectinitialize.service;

import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.info.projectinitialize.dto.ProjectInitializeDTO;
import com.yh.platform.core.exception.ServiceException;

/**
 * @description 项目初始化Service
 * @author meijm
 * @created 2017-9-19
 * @version 1.0
 */
public interface ProjectInitializeService {

	/**
     * 获取客户信息
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public List<ProjectInitializeDTO> listCustomerInfo(TableTagBean ttb) throws ServiceException;
	
	/**
     * 新增客户信息
     * @param dto
     * @return
     * @throws ServiceException
     */
	public void create(ProjectInitializeDTO dto) throws ServiceException;
	
	/**
     * 根据customerOid获取客户信息
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public ProjectInitializeDTO get(String customerOid) throws ServiceException;
	
	/**
     * 修改客户信息
     * @param dto
     * @return
     * @throws ServiceException
     */
	public void update(ProjectInitializeDTO dto) throws ServiceException;

}
