package com.yh.hr.component.annex.facade;


import java.io.File;
import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.component.annex.bo.FileAnnex;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.hr.component.annex.service.UploadAnnexComponentService;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;


/**
 * 上传文件facade
 * @author liul
 *
 */
public class UploadAnnexComponentFacade {

	private UploadAnnexComponentService uploadAnnexComponentService;
	
	public void setUploadAnnexComponentService(
			UploadAnnexComponentService uploadAnnexComponentService) {
		this.uploadAnnexComponentService = uploadAnnexComponentService;
	}
	/**
	 * 新增附件
	 * @param dto
	 * @return
	 * @throws ServiceException
	 */
	public String createAnnexFile(FileAnnexDTO dto) throws ServiceException{
		return uploadAnnexComponentService.createAnnexFile(dto);
	}
	/**
	 * 根据条件获取附件列表
	 * @param ttb
	 * @return
	 * @throws ServiceException
	 */
	public List<FileAnnexDTO> listAnnexFile(TableTagBean ttb)  throws ServiceException{
		return uploadAnnexComponentService.listAnnexFile(ttb);
	}
	/**
	 * 根据id获取附件信息
	 * @param faId
	 * @return
	 * @throws ServiceException
	 */
	public FileAnnexDTO get(String faId) throws ServiceException{
		return BeanHelper.copyProperties(DaoUtil.get(FileAnnex.class, faId), FileAnnexDTO.class);
	}
	/**
	 * 删除附件
	 * @param faId
	 * @throws ServiceException
	 */
	public void delete(String faId) throws ServiceException{
		FileAnnex fileAnnex = DaoUtil.get(FileAnnex.class, faId);
		
		if (fileAnnex != null) {
			fileAnnex.delete();
			new File(fileAnnex.getFaPath()).delete();
		}
	}
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
	public List<String> checkFileName(String path,String[] fileNames,String[] fileIds)  throws ServiceException{
		return uploadAnnexComponentService.checkFileName(path,fileNames,fileIds);
	}

}
