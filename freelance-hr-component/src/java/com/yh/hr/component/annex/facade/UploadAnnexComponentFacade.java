package com.yh.hr.component.annex.facade;


import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.FileAnnex;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.hr.component.annex.service.UploadAnnexComponentService;
import com.yh.hr.component.flow.service.YhFlowComponentService;
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

	public String createAnnexFile(FileAnnexDTO dto) throws ServiceException{
		return uploadAnnexComponentService.createAnnexFile(dto);
	}

	public List<FileAnnexDTO> listAnnexFile(TableTagBean ttb)  throws ServiceException{
		return uploadAnnexComponentService.listAnnexFile(ttb);
	}

	public FileAnnexDTO get(String faId) throws ServiceException{
		return BeanHelper.copyProperties(DaoUtil.get(FileAnnex.class, faId), FileAnnexDTO.class);
	}

	public void delete(String faId) throws ServiceException{
		FileAnnex fileAnnex = DaoUtil.get(FileAnnex.class, faId);
		
		if (fileAnnex != null) {
			fileAnnex.delete();
			new File(fileAnnex.getFaPath()).delete();
		}
	}
	/**
	 * 判断是否存在同名文件
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public Boolean checkFileName(String path)  throws ServiceException{
		return uploadAnnexComponentService.checkFileName(path);
	}

}
