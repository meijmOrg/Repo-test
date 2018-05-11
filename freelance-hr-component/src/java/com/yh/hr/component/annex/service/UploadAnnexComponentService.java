package com.yh.hr.component.annex.service;


import java.util.List;
import java.util.Map;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.FileAnnex;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.platform.core.exception.ServiceException;

import net.sf.json.JSONObject;


public interface UploadAnnexComponentService {

	public String createAnnexFile(FileAnnexDTO dto) throws ServiceException;

	public List<FileAnnexDTO> listAnnexFile(TableTagBean ttb) throws ServiceException;
	/**
	 * 判断是否存在同名文件
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public Boolean checkFileName(String path) throws ServiceException;
}
