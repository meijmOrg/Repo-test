/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-13
**/
package com.yh.hr.res.pb.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.yh.hr.res.pb.bo.PbReviewInfo;
import com.yh.hr.res.pb.dto.PbReviewInfoDTO;
import com.yh.hr.res.pb.queryhelper.PbReviewInfoQueryHelper;
import com.yh.hr.res.pb.service.PbReviewInfoService;
import org.springframework.util.CollectionUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.exception.ServiceException;

public class PbReviewInfoServiceImpl implements PbReviewInfoService {
	public void create(PbReviewInfoDTO pbReviewInfoDto) throws ServiceException {
		PbReviewInfo pbReviewInfo = new PbReviewInfo();
		BeanHelper.copyProperties(pbReviewInfoDto, pbReviewInfo);
        pbReviewInfo.save();
	}

	public PbReviewInfoDTO get(java.lang.Long pbReviewInfoId) throws ServiceException {
        return BeanHelper.copyProperties(DaoUtil.get(PbReviewInfo.class, pbReviewInfoId),PbReviewInfoDTO.class);
	}
    
	public void update(PbReviewInfoDTO pbReviewInfoDto) throws ServiceException {

		PbReviewInfo pbReviewInfo = new PbReviewInfo();
		BeanHelper.copyProperties(pbReviewInfoDto, pbReviewInfo);
		pbReviewInfo.update();
	}
    
	public void delete(java.lang.Long pbReviewInfoId) throws ServiceException {
      DaoUtil.get(PbReviewInfo.class, pbReviewInfoId).delete();
	}
    
	public List<PbReviewInfoDTO	> find(TableTagBean ttb) throws ServiceException {
        StringBuilder hql = new StringBuilder();
        HashMap<String, Object> hqlParams = new HashMap<String, Object>();
        PbReviewInfoQueryHelper.buildHQL(ttb.getCondition(), hql, hqlParams);
        String order = ttb.getOrderBy();
        if (order != null) {
            if (ttb.getAsc()) {
                hql.append(" order by " + order + " asc");
            } else {
                hql.append(" order by " + order + " desc");
            }
        }
        List<PbReviewInfoDTO> list = new ArrayList<PbReviewInfoDTO>();
        List<PbReviewInfo> boList = DaoUtil.listByCondition(hql.toString(), hqlParams, ttb.getPage() * ttb.getPageSize(), ttb.getPageSize());
		if(!CollectionUtils.isEmpty(boList))
		{
			for(PbReviewInfo bo : boList)
			{
				PbReviewInfoDTO dto = new PbReviewInfoDTO();
				BeanHelper.copyProperties(bo, dto);
				list.add(dto);
			}
		}
        ttb.setList(list);
        ttb.setTotal(DaoUtil.countByCondition("select count(*) "+hql, hqlParams));
        return list;
	}

	/*
	 * (non-Javadoc)
	 * @see PbReviewInfoService#findByReviewYear(TableTagBean)
	 */
	public List<PbReviewInfoDTO> findByReviewYear(TableTagBean ttb) throws ServiceException {
		return PbReviewInfoQueryHelper.findByReviewYear(ttb);
	}
	
	/*
	 * (non-Javadoc)
	 * @see PbReviewInfoService#findReviewInfoByPersonOidAndReviewYear(java.lang.Long, java.util.Date)
	 */
	public List<PbReviewInfoDTO> findReviewInfoByPersonOidAndReviewYear(
			Long personOid,Date date) throws ServiceException {
		
        return PbReviewInfoQueryHelper.findReviewInfoByPersonOidAndReviewYear(personOid, date);
	}

	/* (non-Javadoc)
	 * @see PbReviewInfoService#getPbReviewInfoById(java.lang.Long)
	 */
	public List<PbReviewInfoDTO> getPbReviewInfoById(Long persosnOid)
			throws ServiceException {
		return PbReviewInfoQueryHelper.getPbReviewInfoById(persosnOid);
	}


}