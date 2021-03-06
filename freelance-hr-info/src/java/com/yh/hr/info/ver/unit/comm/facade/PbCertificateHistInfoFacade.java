﻿/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.info.ver.unit.comm.facade;

import java.util.List;

import com.yh.platform.core.exception.ServiceException;
import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.dto.PbCertificateHistInfoDTO;
import com.yh.hr.res.pb.service.PbCertificateHistInfoService;

public class PbCertificateHistInfoFacade {

	private PbCertificateHistInfoService pbCertificateHistInfoService;

	public void setPbCertificateHistInfoService(PbCertificateHistInfoService pbCertificateHistInfoService) {
		this.pbCertificateHistInfoService = pbCertificateHistInfoService;
	}

	/**
	 * 新增PbCertificateHistInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void create(PbCertificateHistInfoDTO pbCertificateHistInfoDto) throws ServiceException {
		pbCertificateHistInfoService.create(pbCertificateHistInfoDto);
	}
	
	    /**
	 * 删除多PbCertificateHistInfo信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void delete(java.lang.Long pbCertificateHistInfoId) throws ServiceException {
		pbCertificateHistInfoService.delete(pbCertificateHistInfoId);
	}



	/**
	 * 查找PbCertificateHistInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public PbCertificateHistInfoDTO get(java.lang.Long pbCertificateHistInfoId) throws ServiceException {
		return pbCertificateHistInfoService.get(pbCertificateHistInfoId);
	}
	
	/**
	 * 列出多条PbCertificateHistInfo信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public List<PbCertificateHistInfoDTO> find(TableTagBean ttb) throws ServiceException {
		return pbCertificateHistInfoService.find(ttb);
	}
    
    /**
	 * 更新&修改PbCertificateHistInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void update(PbCertificateHistInfoDTO pbCertificateHistInfoDto) throws ServiceException {
		pbCertificateHistInfoService.update(pbCertificateHistInfoDto);
	}

	/**
	 * 根据id获取PbCertificateHistInfo详细信息
	 * @param personOid
	 * @return
	 * @throws ServiceException
	 */
	public List<PbCertificateHistInfoDTO> getPbCertificateHistInfoById(Long personOid) throws ServiceException {
		return pbCertificateHistInfoService.getPbCertificateHistInfoById(personOid);
	}
}