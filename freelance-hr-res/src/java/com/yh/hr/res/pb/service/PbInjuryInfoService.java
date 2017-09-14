﻿/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-13
 */
package com.yh.hr.res.pb.service;

import java.util.HashMap;
import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.dto.PbInjuryInfoDTO;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.StringMap;


public interface PbInjuryInfoService {
	/**
	 * 新增PbInjuryInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public void create(PbInjuryInfoDTO pbInjuryInfoDto) throws ServiceException;

	/**
	 * 获取PbInjuryInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public PbInjuryInfoDTO get(java.lang.Long pbInjuryInfoId) throws ServiceException;
    
	/**
	 * 修改PbInjuryInfo信息
	 * @param 
	 * @throws ServiceException
	 */    
	public void update(PbInjuryInfoDTO pbInjuryInfoDto) throws ServiceException;

	/**
	 * 删除PbInjuryInfo信息
	 * @param 
	 * @throws ServiceException
	 */    
	public void delete(java.lang.Long pbInjuryInfoId) throws ServiceException;
    
	/**
	 * 查询所有PbInjuryInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public List<PbInjuryInfoDTO> find(TableTagBean ttb) throws ServiceException; 

	/**
	 * HQL拼装
	 * @param 
	 * @throws ServiceException
	 */
    void buildHQL(StringMap params, StringBuilder hql, HashMap<String, Object> hqlParams) throws ServiceException;

	public List<PbInjuryInfoDTO> getInjuryInfoByPersonOid(Long personOid) throws ServiceException;
      
}
