package com.yh.hr.orghc.workgroup.queryhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.orghc.ub.bo.UbOrg;
import com.yh.hr.orghc.workgroup.dto.WorkGroupDTO;
import com.yh.hr.res.unit.bo.WorkGroup;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;


public class WorkGroupQueryHelper {

	public static List<WorkGroupDTO> listWorkGroup(TableTagBean ttb) throws ServiceException {
		
		Map<String, Object> params = new HashMap<String, Object>();

		StringBuilder hql = new StringBuilder();
		HashMap<String, Object> hqlParams = new HashMap<String, Object>();
		hql.append("from WorkGroup where 1=1 ");
				//单位id
		if (StringUtils.isNotEmpty(ttb.getCondition().get("orgOid"))) {
			hql.append(" and wpDepId = :wpDepId");
			hqlParams.put("wpDepId", ttb.getCondition().get("orgOid"));
		}
		//科室名称
		if (StringUtils.isNotEmpty(ttb.getCondition().get("wpName"))) {
			hql.append(" and wpName = :wpName");
			hqlParams.put("wpName", ttb.getCondition().get("wpName"));		
			}
		hql.append(" order by wpCreateDate desc");
		List<WorkGroupDTO> list = new ArrayList<WorkGroupDTO>();
		List<WorkGroup> boList = DaoUtil.listByCondition(hql.toString(),
				hqlParams, 0, 0);
		if (!CollectionUtils.isEmpty(boList)) {
			for (WorkGroup bo : boList) {
				WorkGroupDTO dto = new WorkGroupDTO();
				BeanHelper.copyProperties(bo, dto);
				UbOrg org=getOrgInfo(bo.getWpDepId());
				dto.setWpDepName(org.getOrgName());
				list.add(dto);
			}
		}
		return list;
	}
	/**
	 * 查询科室信息
	 * @param orgName
	 * @return
	 * @throws ServiceException
	 */
	public static UbOrg getOrgInfo(String orgOid) throws ServiceException{
		String hql = "from UbOrg ub where ub.orgOid ='"+orgOid+"'";
		return DaoUtil.uniqueResult(hql);
	}
}
