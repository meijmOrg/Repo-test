package com.yh.hr.orghc.workgroup.service.impl;


import java.util.Date;
import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.orghc.ub.bo.UbOrg;
import com.yh.hr.orghc.workgroup.dto.WorkGroupDTO;
import com.yh.hr.orghc.workgroup.queryhelper.WorkGroupQueryHelper;
import com.yh.hr.orghc.workgroup.service.WorkGroupService;
import com.yh.hr.res.unit.bo.WorkGroup;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.StringUtil;
import com.yh.platform.core.web.UserContext;

public class WorkGroupServiceImpl implements WorkGroupService {

	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.orghc.workgroup.service.WorkGroupService#listWorkGroup(com.yh.component.taglib.TableTagBean)
	 */
	public List<WorkGroupDTO> listWorkGroup(TableTagBean ttb) throws ServiceException {
		
		return WorkGroupQueryHelper.listWorkGroup(ttb);
	}

	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.orghc.workgroup.service.WorkGroupService#create(com.yh.hr.orghc.workgroup.dto.WorkGroupDTO)
	 */
	public void create(WorkGroupDTO dto) throws ServiceException {
		
		WorkGroup workGroup = new WorkGroup();
		BeanHelper.copyProperties(dto, workGroup);
		workGroup.setWpCreateDate(new Date());
		workGroup.setWpCreateUser(UserContext.getLoginUserName());
		workGroup.setWpId(StringUtil.getUUID());
		workGroup.save();
	}

	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.orghc.workgroup.service.WorkGroupService#getWorkGroup(java.lang.String)
	 */
	public WorkGroupDTO getWorkGroup(String wpId) throws ServiceException {
		WorkGroup bo=DaoUtil.get(WorkGroup.class, wpId);
		if(bo!=null){
			WorkGroupDTO dto=new WorkGroupDTO();
			BeanHelper.copyProperties(bo, dto);
			UbOrg org =WorkGroupQueryHelper.getOrgInfo(bo.getWpDepId());
			if(org!=null){
				dto.setWpDepName(org.getOrgName());	
			}
			
			return dto;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.orghc.workgroup.service.WorkGroupService#updateWorkGroup(com.yh.hr.orghc.workgroup.dto.WorkGroupDTO)
	 */
	public void updateWorkGroup(WorkGroupDTO dto)
			throws ServiceException {
		WorkGroup bo=DaoUtil.get(WorkGroup.class, dto.getWpId());
		if(bo!=null){
			bo.setWpDescription(dto.getWpDescription());
			bo.setWpName(dto.getWpName());
			bo.setWpDepId(dto.getWpDepId());
			bo.update();
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.orghc.workgroup.service.WorkGroupService#deleteWorkGroup(java.lang.String)
	 */
	public void deleteWorkGroup(String wpId) throws ServiceException {
		
		WorkGroup bo=DaoUtil.get(WorkGroup.class, wpId);
		if(bo!=null){
			bo.delete();
		}
	}
	

}
