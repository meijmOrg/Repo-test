package com.yh.hr.orghc.workgroup.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.orghc.workgroup.dto.WorkGroupDTO;
import com.yh.hr.orghc.workgroup.service.WorkGroupService;
import com.yh.hr.res.unit.service.UtUnitService;
import com.yh.platform.core.exception.ServiceException;


public class WorkGroupFacade {
	private WorkGroupService workGroupService;
	
    public WorkGroupService getWorkGroupService() {
		return workGroupService;
	}

	public void setWorkGroupService(WorkGroupService workGroupService) {
		this.workGroupService = workGroupService;
	}

	/**
     * 查询工作组列表
     * @param ttb
     * @return
     */
	public List<WorkGroupDTO> listWorkGroup(TableTagBean ttb) throws ServiceException {
		
		return workGroupService.listWorkGroup(ttb);
	}

	public void create(WorkGroupDTO dto) throws ServiceException{
		
		 workGroupService.create(dto);
	}
   /**
    * 获取小组信息
    * @param wpId
    * @return
    * @throws ServiceException
    */
	public WorkGroupDTO getWorkGroup(String wpId) throws ServiceException{
		
		return workGroupService.getWorkGroup(wpId);
	}

public void update(WorkGroupDTO dto) throws ServiceException{

	workGroupService.updateWorkGroup(dto);
}

public void delete(String wpId)throws ServiceException {
	workGroupService.deleteWorkGroup(wpId);
	
}
	
}
