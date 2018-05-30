package com.yh.hr.component.annex.service.impl;


import java.util.List;

import org.springframework.beans.BeanUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.FileAnnex;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.hr.component.annex.queryhelper.UploadAnnexComponentQueryHelper;
import com.yh.hr.component.annex.service.UploadAnnexComponentService;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.UuidUtils;


public class UploadAnnexComponentServiceImpl implements UploadAnnexComponentService
{
	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.component.annex.service.UploadAnnexComponentService#createAnnexFile(com.yh.hr.component.annex.dto.FileAnnexDTO)
	 */
	public String createAnnexFile(FileAnnexDTO dto) throws ServiceException {
		FileAnnex bo = new FileAnnex();
		BeanUtils.copyProperties(dto, bo);
		bo.setFaId(UuidUtils.getUUID36());
		bo.setFileId(UuidUtils.getUUID36());
		bo.save();
		return bo.getFaId();
	}

	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.component.annex.service.UploadAnnexComponentService#listAnnexFile(com.yh.component.taglib.TableTagBean)
	 */
	public List<FileAnnexDTO> listAnnexFile(TableTagBean ttb)
			throws ServiceException {
		return UploadAnnexComponentQueryHelper.listAnnexFile(ttb);
	}

	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.component.annex.service.UploadAnnexComponentService#checkFileName(java.lang.String)
	 */
	public List<String> checkFileName(String path,String[] fileNames,String[] fileIds)
			throws ServiceException {
		return UploadAnnexComponentQueryHelper.checkFileName(path,fileNames,fileIds);
	}


}