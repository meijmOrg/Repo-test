package com.yh.admin.imageinstall.queryhelper;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.yh.admin.dto.SubSystemDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;

/**
 * @description 系统外观设置查询工具类
 * @author meijm
 * @created 2017-9-18
 * @version 1.0
 */
public class ImageInstallQueryHelper {

	
	/**
     * 获取系统id
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public static String getSystemCode() throws ServiceException {
		StringBuilder hql = new StringBuilder();
		String systemCode = "";
		hql.append(" from SubSystem ss ");
        HashMap<String, Object> hqlParams = new HashMap<String, Object>();
        List<SubSystemDTO> list = BeanHelper.copyProperties(DaoUtil.listByCondition("select ss "+hql.toString(), hqlParams, 0, 0),SubSystemDTO.class);
        if(CollectionUtils.isNotEmpty(list)){
        	systemCode = list.get(0).getSubSystemCode();
        }
        return systemCode;
	}
}
