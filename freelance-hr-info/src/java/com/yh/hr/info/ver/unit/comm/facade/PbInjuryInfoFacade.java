﻿/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-13
**/
package com.yh.hr.info.ver.unit.comm.facade;

import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.dto.PbInjuryInfoDTO;
import com.yh.hr.res.pb.service.PbInjuryInfoService;
import com.yh.platform.core.exception.ServiceException;

public class PbInjuryInfoFacade {

	private PbInjuryInfoService pbInjuryInfoService;

	public void setPbInjuryInfoService(PbInjuryInfoService pbInjuryInfoService) {
		this.pbInjuryInfoService = pbInjuryInfoService;
	}

	/**
	 * 新增PbInjuryInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void create(PbInjuryInfoDTO pbInjuryInfoDto) throws ServiceException {
		pbInjuryInfoService.create(pbInjuryInfoDto);
	}
	
	    /**
	 * 删除多PbInjuryInfo信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void delete(java.lang.Long pbInjuryInfoId) throws ServiceException {
		pbInjuryInfoService.delete(pbInjuryInfoId);
	}



	/**
	 * 查找PbInjuryInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public PbInjuryInfoDTO get(java.lang.Long pbInjuryInfoId) throws ServiceException {
		return pbInjuryInfoService.get(pbInjuryInfoId);
	}
	
	/**
	 * 列出多条PbInjuryInfo信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public List<PbInjuryInfoDTO> find(TableTagBean ttb) throws ServiceException {
		return pbInjuryInfoService.find(ttb);
	}
    
    /**
	 * 更新&修改PbInjuryInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void update(PbInjuryInfoDTO pbInjuryInfoDto) throws ServiceException {
		pbInjuryInfoService.update(pbInjuryInfoDto);
	}
	/**
	 * 查找PbInjuryInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public List<PbInjuryInfoDTO> getInjuryInfoByPersonOid(java.lang.Long personOid) throws ServiceException {
		return pbInjuryInfoService.getInjuryInfoByPersonOid(personOid);
	}
}