/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-13
**/
package com.yh.hr.res.pb.service.impl;

import jade.workflow.utils.ObjectUtil;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.bo.PbRetrieInfo;
import com.yh.hr.res.pb.dto.PbRetrieInfoDTO;
import com.yh.hr.res.pb.queryhelper.PbRetrieInfoQueryHelper;
import com.yh.hr.res.pb.service.PbRetrieInfoService;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.StringMap;
import com.yh.platform.core.web.UserContext;

public class PbRetrieInfoServiceImpl implements PbRetrieInfoService{
	public void create(PbRetrieInfoDTO pbRetrieInfoDto) throws ServiceException {
		PbRetrieInfo pbRetrieInfo = new PbRetrieInfo();
		BeanHelper.copyProperties(pbRetrieInfoDto, pbRetrieInfo);
		pbRetrieInfo.setCreateBy(UserContext.getLoginUserID());
		pbRetrieInfo.setCreateName(UserContext.getLoginUserName());
		pbRetrieInfo.setCreateDate(DateUtil.now());
        pbRetrieInfo.save();
        PersonAttachInfoServiceUtil.sysPbRetireInfo(pbRetrieInfoDto.getPersonOid());
	}

	public PbRetrieInfoDTO get(java.lang.Long pbRetrieInfoId) throws ServiceException {
        return BeanHelper.copyProperties(DaoUtil.get(PbRetrieInfo.class, pbRetrieInfoId),PbRetrieInfoDTO.class);
	}
    
	public void update(PbRetrieInfoDTO pbRetrieInfoDto) throws ServiceException {
		PbRetrieInfo pbRetrieInfo = DaoUtil.get(PbRetrieInfo.class, pbRetrieInfoDto.getPersonOid());
		BeanHelper.copyProperties(pbRetrieInfoDto, pbRetrieInfo, BeanHelper.getNullPropertyNames(pbRetrieInfoDto));
		pbRetrieInfo.setUpdateBy(UserContext.getLoginUserID());
		pbRetrieInfo.setUpdateName(UserContext.getLoginUserName());
		pbRetrieInfo.setUpdateDate(DateUtil.now());
		pbRetrieInfo.update();
		PersonAttachInfoServiceUtil.sysPbRetireInfo(pbRetrieInfoDto.getPersonOid());
	}
    
	public void delete(java.lang.Long pbRetrieInfoId) throws ServiceException {
      PbRetrieInfo bo = DaoUtil.get(PbRetrieInfo.class, pbRetrieInfoId);
	  if(null != bo)
	  {
		  bo.delete();
	      PersonAttachInfoServiceUtil.sysPbRetireInfo(bo.getPersonOid());
	  }
	}
    
	public List<PbRetrieInfoDTO> find(TableTagBean ttb) throws ServiceException {
        StringBuilder hql = new StringBuilder();
        HashMap<String, Object> hqlParams = new HashMap<String, Object>();
        buildHQL(ttb.getCondition(), hql, hqlParams);
        String order = ttb.getOrderBy();
        if (order != null) {
            if (ttb.getAsc()) {
                hql.append(" order by " + order + " asc");
            } else {
                hql.append(" order by " + order + " desc");
            }
        }
        List<PbRetrieInfoDTO> list = BeanHelper.copyProperties(DaoUtil.listByCondition(hql.toString(), hqlParams, ttb.getPage() * ttb.getPageSize(), ttb.getPageSize()),PbRetrieInfoDTO.class);
        ttb.setList(list);
        ttb.setTotal(DaoUtil.countByCondition("select count(*) "+hql, hqlParams));
        return list;
	}

    public void buildHQL(StringMap params, StringBuilder hql, HashMap<String, Object> hqlParams) throws ServiceException {
        hql.append("from PbRetrieInfo where 1=1");
        String personOid = params.getAsStringEmptyNull("personOid");
        if (personOid != null){
           	hql.append(" and personOid = :personOid");
           	try{
           		hqlParams.put("personOid", ObjectUtil.getValue(personOid, java.lang.Long.class));
        	} catch (jade.workflow.exception.ServiceException e) {
			e.printStackTrace();
			}
        }
        String retrieTypeCode = params.getAsStringEmptyNull("retrieTypeCode");
        if (retrieTypeCode != null){
           hql.append(" and retrieTypeCode like :retrieTypeCode");
           hqlParams.put("retrieTypeCode", "%"+retrieTypeCode.trim()+"%");
        }
        String retrieDate = params.getAsStringEmptyNull("retrieDateStr");
        if (retrieDate != null){
            hql.append(" and retrieDate = :retrieDate");
            hqlParams.put("retrieDate", DateUtil.parseDate(retrieDate));
        }
        String retrieReason = params.getAsStringEmptyNull("retrieReason");
        if (retrieReason != null){
           hql.append(" and retrieReason like :retrieReason");
           hqlParams.put("retrieReason", "%"+retrieReason.trim()+"%");
        }
        String retireTreatmentLevelCode = params.getAsStringEmptyNull("retireTreatmentLevelCode");
        if (retireTreatmentLevelCode != null){
           hql.append(" and retireTreatmentLevelCode like :retireTreatmentLevelCode");
           hqlParams.put("retireTreatmentLevelCode", "%"+retireTreatmentLevelCode.trim()+"%");
        }
   }
    
    /*
     * (non-Javadoc)
     * @see PbRetrieInfoService#findByPersonOid(java.lang.Long)
     */
	public PbRetrieInfoDTO findByPersonOid(Long personOid)
			throws ServiceException 
	{
		List<PbRetrieInfoDTO> dtoList = PbRetrieInfoQueryHelper.findByPersonOid(personOid);
		if(CollectionUtils.isNotEmpty(dtoList))
		{
			return dtoList.get(0);
		}
		return null;
	}

	public void deleteByPersonOid(Long personOid) throws ServiceException {
		DaoUtil.executeUpdate("delete from PbRetrieInfo where personOid='"+personOid+"'");
	}
}