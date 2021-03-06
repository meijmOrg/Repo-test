﻿/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
 */
package com.yh.hr.res.pb.service;

import java.util.HashMap;
import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.dto.PbCertificateInfoDTO;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.StringMap;


public interface PbCertificateInfoService {
	/**
	 * 新增PbCertificateInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public void create(PbCertificateInfoDTO pbCertificateInfoDto) throws ServiceException;

	/**
	 * 获取PbCertificateInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public PbCertificateInfoDTO get(java.lang.Long pbCertificateInfoId) throws ServiceException;
    
	/**
	 * 修改PbCertificateInfo信息
	 * @param 
	 * @throws ServiceException
	 */    
	public void update(PbCertificateInfoDTO pbCertificateInfoDto) throws ServiceException;

	/**
	 * 删除PbCertificateInfo信息
	 * @param 
	 * @throws ServiceException
	 */    
	public void delete(java.lang.Long pbCertificateInfoId) throws ServiceException;
    
	/**
	 * 查询所有PbCertificateInfo信息
	 * @param 
	 * @throws ServiceException
	 */
	public List<PbCertificateInfoDTO> find(TableTagBean ttb) throws ServiceException; 

	/**
	 * HQL拼装
	 * @param 
	 * @throws ServiceException
	 */
    void buildHQL(StringMap params, StringBuilder hql, HashMap<String, Object> hqlParams) throws ServiceException;
    /**
     * 根据人员id和职业证编号查询该人员职业注册信息记录
     * @param personOid
     * @param certificateInfoNo
     * @return
     * @throws ServiceException
     */
    public PbCertificateInfoDTO getCertificateInfoByCertificateNo(Long personOid,String certificateNo) throws ServiceException;

	/**
	 * 根据id获取PbCertificateInfo详细信息
	 * @param personOid
	 * @return
	 */
	public List<PbCertificateInfoDTO> getCertificateInfoById(Long personOid) throws ServiceException;

	/**
	 * 删除该人员的所有执业注册信息
	 * @param personOid
	 */
	public void deleteByPersonOid(Long personOid) throws ServiceException;
      
}
