package com.yh.hr.component.annex.service;


import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.platform.core.exception.ServiceException;


public interface UploadAnnexComponentService {
	/**
	 * 新增附件
	 * @param dto
	 * @return
	 * @throws ServiceException
	 */
	public String createAnnexFile(FileAnnexDTO dto) throws ServiceException;
	/**
	 * 根据条件获取附件列表
	 * @param ttb
	 * @return
	 * @throws ServiceException
	 */
	public List<FileAnnexDTO> listAnnexFile(TableTagBean ttb) throws ServiceException;
	/**
	 * 
	* @Title: checkFileName 
	* @Description: 判断是否存在同名文件 
	* @param path
	* @param fileNames
	* @param fileIds
	* @return
	* @throws ServiceException Boolean
	 */
	public List<String> checkFileName(String path,String[] fileNames,String[] fileIds) throws ServiceException;
}
