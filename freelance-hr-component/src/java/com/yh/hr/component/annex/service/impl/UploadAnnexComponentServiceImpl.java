package com.yh.hr.component.annex.service.impl;


import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.FileAnnex;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.hr.component.annex.queryhelper.UploadAnnexComponentQueryHelper;
import com.yh.hr.component.annex.service.UploadAnnexComponentService;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.UuidUtils;


public class UploadAnnexComponentServiceImpl implements UploadAnnexComponentService
{

	@Override
	public String createAnnexFile(FileAnnexDTO dto) throws ServiceException {
		// TODO Auto-generated method stub
		FileAnnex bo = new FileAnnex();
		BeanUtils.copyProperties(dto, bo);
		bo.setFaId(UuidUtils.getUUID36());
		bo.setFileId(UuidUtils.getUUID36());
		bo.save();
		return bo.getFaId();
	}

	@Override
	public List<FileAnnexDTO> listAnnexFile(TableTagBean ttb)
			throws ServiceException {
		// TODO Auto-generated method stub
		return UploadAnnexComponentQueryHelper.listAnnexFile(ttb);
	}

	@Override
	public Boolean checkFileName(String path)
			throws ServiceException {
		return UploadAnnexComponentQueryHelper.checkFileName(path);
	}


}