package com.yh.component.config.queryhelper;

import jade.workflow.utils.DaoUtil;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.yh.platform.core.exception.ServiceException;


public class YhSysprmQueryHelper {

	/**
	 *根据属性名称获取属性值
	 * @param sysConfName
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public static String getSysConfValue(String sysConfName) throws ServiceException{
		StringBuffer hql = new StringBuffer();

		hql.append("select sysConfValue from Sysprm p where p.sysConfName = '").append(sysConfName).append("'");

		List<String> ls = DaoUtil.createQuery(hql.toString());

		if (CollectionUtils.isNotEmpty(ls)) {
			return (String) ls.get(0);
		}
		return null;
	}
}
