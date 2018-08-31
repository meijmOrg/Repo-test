package com.yh.hr.biz.vacation.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.biz.vacation.bo.YhfVacation;
import com.yh.hr.biz.vacation.dto.YhfVacationDTO;
import com.yh.hr.biz.vacation.queryhelper.BizVacationQueryHelper;
import com.yh.hr.biz.vacation.service.BizVacationService;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.service.impl.YhFlowComponentAbstractServiceImpl;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.web.UserContext;
/**
 * @Description: 请休假业务ServiceImpl
 * @author: meijm
 * @date: 2018-6-10
 */
public class BizVacationServiceImpl extends YhFlowComponentAbstractServiceImpl implements  BizVacationService
{

	/* (non-Javadoc)
	 * @see com.yh.hr.biz.vacation.service.BizVacationService#listVacationInfo(com.yh.component.taglib.TableTagBean)
	 */
	@Override
	public List<JSONObject> listVacationInfo(TableTagBean ttb)
			throws ServiceException {
		return BizVacationQueryHelper.listVacationInfo(ttb);
	}
	
	/* (non-Javadoc)
	 * @see com.yh.hr.biz.vacation.service.BizVacationService#saveVacationInfo(com.yh.hr.biz.vacation.dto.YhfVacationDTO)
	 */
	public void saveVacationInfo(YhfVacationDTO dto) throws ServiceException{
		YhfVacation bo = new YhfVacation();
		BeanHelper.copyProperties(dto, bo);
		bo.setVacationId(dto.getFileId());
		bo.setUserId(UserContext.getLoginUserID());
		bo.setUserName(UserContext.getLoginUserName());
		bo.setBeginTime(dto.getBeginTime());
		bo.setEndTime(dto.getEndTime());
		bo.setReason(dto.getReason());
		bo.save();
	}
	
	/* (non-Javadoc)
	 * @see com.yh.hr.biz.vacation.service.BizVacationService#createSubTaskInfo(com.yh.hr.biz.vacation.dto.YhfVacationDTO)
	 */
	@Override
	public void createSubTaskInfo(YhFlowComponentDTO dto) throws ServiceException{
		YhfVacationDTO yhfVacationDTO = (YhfVacationDTO)dto;
		this.saveVacationInfo(yhfVacationDTO);
	}
	
	/* (non-Javadoc)
	 * @see com.yh.hr.biz.vacation.service.BizVacationService#getVacationInfo(Long)
	 */
	public YhfVacationDTO getVacationInfo(String vacationId) throws ServiceException{
		return BeanHelper.copyProperties(DaoUtil.get(YhfVacation.class, vacationId), YhfVacationDTO.class);
	}

}
