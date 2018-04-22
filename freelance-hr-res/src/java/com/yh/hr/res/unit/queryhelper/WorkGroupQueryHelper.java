package com.yh.hr.res.unit.queryhelper;

import java.util.List;

import com.yh.hr.res.unit.dto.WorkGroupDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.DataAccessFailureException;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;

/**
 * 小组查询工具类
 * @author halfsummer
 * 2018年04月22日19:15:01
 */
public class WorkGroupQueryHelper {
	
	/**
     * 查询小组信息
     * @return
     * @throws ServiceException 
     * @throws DataAccessFailureException 
     */
	public static List<WorkGroupDTO> queryWorkGroupList() throws DataAccessFailureException, ServiceException {
        StringBuilder hql = new StringBuilder();
		hql.append("from WorkGroup w where 1=1 and wpStatus = '1'");
		return BeanHelper.copyProperties(DaoUtil.find(hql.toString()), WorkGroupDTO.class);
	}	

}
