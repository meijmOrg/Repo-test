﻿/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
 */
package com.yh.hr.res.pb.service;

import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.dto.PbEducationLevelDegreeDTO;
import com.yh.platform.core.exception.ServiceException;


public interface PbEducationLevelDegreeService {
	/**
	 * 新增PbEducationLevelDegree信息
	 * @param 
	 * @throws ServiceException
	 */
	public void create(PbEducationLevelDegreeDTO pbEducationLevelDegreeDto) throws ServiceException;

	/**
	 * 获取PbEducationLevelDegree信息
	 * @param 
	 * @throws ServiceException
	 */
	public PbEducationLevelDegreeDTO get(java.lang.Long pbEducationLevelDegreeId) throws ServiceException;
    
	/**
	 * 修改PbEducationLevelDegree信息
	 * @param 
	 * @throws ServiceException
	 */    
	public void update(PbEducationLevelDegreeDTO pbEducationLevelDegreeDto) throws ServiceException;

	/**
	 * 删除PbEducationLevelDegree信息
	 * @param 
	 * @throws ServiceException
	 */    
	public void delete(java.lang.Long pbEducationLevelDegreeId) throws ServiceException;
    
	/**
	 * 查询所有PbEducationLevelDegree信息
	 * @param 
	 * @throws ServiceException
	 */
	public List<PbEducationLevelDegreeDTO> find(TableTagBean ttb) throws ServiceException; 
    
    /**
     * 根据人员id查询该人员所有的学历学位记录
     * @param personOid
     * @return
     */
	public List<PbEducationLevelDegreeDTO> listPbEducationLevelDegreeByPersonOid(Long personOid) throws ServiceException;

	/**
	 * 删除该人员的所有学历学位记录
	 * @param personOid
	 */
	public void deleteByPersonOid(Long personOid) throws ServiceException;
      
}
