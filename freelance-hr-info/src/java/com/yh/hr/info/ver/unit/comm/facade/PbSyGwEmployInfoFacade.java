﻿/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.info.ver.unit.comm.facade;

import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.dto.PbSyGwEmployInfoDTO;
import com.yh.hr.res.pb.service.PbSyGwEmployInfoService;
import com.yh.platform.core.exception.ServiceException;

public class PbSyGwEmployInfoFacade {

	private PbSyGwEmployInfoService pbSyGwEmployInfoService;

	public void setPbSyGwEmployInfoService(PbSyGwEmployInfoService pbSyGwEmployInfoService) {
		this.pbSyGwEmployInfoService = pbSyGwEmployInfoService;
	}

	/**
	 * 新增PbSyGwEmployInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void create(PbSyGwEmployInfoDTO pbSyGwEmployInfoDto) throws ServiceException {
		pbSyGwEmployInfoService.create(pbSyGwEmployInfoDto);
	}
	
	    /**
	 * 删除多PbSyGwEmployInfo信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void delete(java.lang.Long pbSyGwEmployInfoId) throws ServiceException {
		pbSyGwEmployInfoService.delete(pbSyGwEmployInfoId);
	}



	/**
	 * 查找PbSyGwEmployInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public PbSyGwEmployInfoDTO get(java.lang.Long pbSyGwEmployInfoId) throws ServiceException {
		return pbSyGwEmployInfoService.get(pbSyGwEmployInfoId);
	}
	
	/**
	 * 列出多条PbSyGwEmployInfo信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public List<PbSyGwEmployInfoDTO> find(TableTagBean ttb) throws ServiceException {
		return pbSyGwEmployInfoService.find(ttb);
	}
    
    /**
	 * 更新&修改PbSyGwEmployInfo详细信息
	 * 
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void update(PbSyGwEmployInfoDTO pbSyGwEmployInfoDto) throws ServiceException {
		pbSyGwEmployInfoService.update(pbSyGwEmployInfoDto);
	}
	/**
	 * 验证
	 * @param pbSyGwEmployInfoDto
	 * @return
	 * @throws ServiceException
	 */
	public String check(PbSyGwEmployInfoDTO pbSyGwEmployInfoDto) throws ServiceException {
		return pbSyGwEmployInfoService.check(pbSyGwEmployInfoDto);
	}
	
	/**
	 * 根据人员id查询该人员所有的事业岗位聘任信息
	 * @param personOid
	 * @return
	 * @throws ServiceException
	 */
	public List<PbSyGwEmployInfoDTO> listPbSyGwEmployInfoByPersonOid(Long personOid) throws ServiceException{
		return pbSyGwEmployInfoService.listPbSyGwEmployInfoByPersonOid(personOid);
	}
}