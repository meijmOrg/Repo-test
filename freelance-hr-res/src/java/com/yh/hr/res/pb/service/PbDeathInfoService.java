﻿/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-13
 */
package com.yh.hr.res.pb.service;

import java.util.HashMap;
import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.dto.PbDeathInfoDTO;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.StringMap;


public interface PbDeathInfoService {
	/**
	 * 新增PbDeathInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public void create(PbDeathInfoDTO pbDeathInfoDto) throws ServiceException;

	/**
	 * 获取PbDeathInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public PbDeathInfoDTO get(java.lang.Long pbDeathInfoId) throws ServiceException;
    
	/**
	 * 修改PbDeathInfo信息
	 * @param 
	 * @throws ServiceException
	 */    
	public void update(PbDeathInfoDTO pbDeathInfoDto) throws ServiceException;

	/**
	 * 删除PbDeathInfo信息
	 * @param 
	 * @throws ServiceException
	 */    
	public void delete(java.lang.Long pbDeathInfoId) throws ServiceException;
    
	/**
	 * 查询所有PbDeathInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public List<PbDeathInfoDTO> find(TableTagBean ttb) throws ServiceException; 

	/**
	 * HQL拼装
	 * @param 
	 * @throws ServiceException
	 */
    void buildHQL(StringMap params, StringBuilder hql, HashMap<String, Object> hqlParams) throws ServiceException;

    /**
     * 根据人员ID查询人员死亡信息
     * @param personOid
     * @return
     * @throws ServiceException
     */
	public PbDeathInfoDTO findByPersonOid(Long personOid)throws ServiceException;
    
	/**
	 * 根据人员id查询该人员所有的自然减员记录
	 * @param personOid
	 * @return
	 * @throws ServiceException
	 */
	public List<PbDeathInfoDTO> listPbDeathInfoByPersonOid(Long personOid) throws ServiceException;

	/**
	 * 删除该人员的自然减员信息
	 * @param personOid
	 */
	public void deleteByPersonOid(Long personOid) throws ServiceException;
}