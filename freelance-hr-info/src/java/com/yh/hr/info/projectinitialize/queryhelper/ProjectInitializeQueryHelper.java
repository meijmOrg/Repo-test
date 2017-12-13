package com.yh.hr.info.projectinitialize.queryhelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.info.projectinitialize.dto.ProjectInitializeDTO;
import com.yh.hr.orghc.ub.bo.UbUnit;
import com.yh.hr.res.dictionary.DicConstants;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;

/**
 * @description 项目初始化查询工具类
 * @author meijm
 * @created 2017-9-19
 * @version 1.0
 */
public class ProjectInitializeQueryHelper {

	
	/**
     * 获取客户信息
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public static List<ProjectInitializeDTO> listCustomerInfo(TableTagBean ttb) throws ServiceException {
		
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder sql = new StringBuilder();
		sql.append(" from ProjectInitialize pi where 1=1 ");
		
		if (StringUtils.isNotEmpty(ttb.getCondition().get("customerName"))) {
			sql.append(" and pi.customerName like '%")
			.append(ttb.getCondition().get("customerName")).append("%' ");
		}
		if (StringUtils.isNotEmpty(ttb.getCondition().get("startStatus"))) {
			sql.append(" and pi.startStatus = '")
			.append(ttb.getCondition().get("startStatus")).append("' ");
		}
		
		if (ttb.getPageSize() != 0) {
			ttb.setTotal(DaoUtil.countByCondition(
					new StringBuilder().append("select count(*) ").append(sql)
							.toString(), params));
		}
		
		return BeanHelper.copyProperties(DaoUtil.listByCondition(
				new StringBuilder().append(sql)
						.append(" order by pi.startStatus desc").toString(), params,
				ttb.getPage(), ttb.getPageSize()), ProjectInitializeDTO.class);
	}
	
	/**
	 * 获取单位信息
	 * @param unitName
	 * @return UbUnit
	 * @throws ServiceException
	 */
	public static UbUnit getUbUnit(String unitName)  throws ServiceException{
		return DaoUtil.uniqueResult(" from UbUnit uu where uu.unitName='"+unitName+"'"
		    + " and uu.unitStatus in('"+DicConstants.YHRS0101_2+"')");
	}
	
	/**
	 * 获取单位信息
	 * @param 
	 * @return UbUnit
	 * @throws ServiceException
	 */
	public static UbUnit getUbUnit()
			throws ServiceException {
		List<UbUnit> list = DaoUtil
				.find("from UbUnit uu where 1=1 and uu.unitStatus ='2' ");
		if (CollectionUtils.isEmpty(list)) {
			return null;
		} else {
			UbUnit bd = list.get(0);
			return bd;
		}
	}
}
