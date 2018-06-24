package com.yh.component.workflow.queryhelper;

import java.util.List;

import com.yh.component.workflow.dto.WorkFlowKeyWordDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;

/**
 * 查询关键字工具类
 * @author halfsummer
 * 2018年04月22日21:27:11
 */
public class WorkFlowKeyWordQueryHelper {
	
	/**
	 * 查询所有关键字
	 * @return
	 * @throws ServiceException
	 */
	public static List<WorkFlowKeyWordDTO> queryAllKeyWord() throws ServiceException {
		StringBuilder hql = new StringBuilder();
		hql.append("from FlowKeyWord f where 1=1");
		return BeanHelper.copyProperties(DaoUtil.find(hql.toString()), WorkFlowKeyWordDTO.class);
	}

}
