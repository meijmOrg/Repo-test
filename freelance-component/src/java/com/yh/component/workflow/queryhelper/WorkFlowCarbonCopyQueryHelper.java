package com.yh.component.workflow.queryhelper;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.CarbonCopyDTO;
import com.yh.component.workflow.dto.WorkFlowKeyWordDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;

/**
 * 
 * @ClassName: WorkFlowCarbonCopyQueryHelper 
 * @Description: 抄送信息QueryHelper
 * @author: liul
 * @date: 2018-5-24 上午11:15:45
 */
public class WorkFlowCarbonCopyQueryHelper {
	
	/**
	 * 
	* @Title: listCarbonCopy 
	* @Description: TODO 
	* @param ttb
	* @return
	* @throws ServiceException List<CarbonCopyDTO>
	* @author liul
	* @date 2018-5-24上午11:18:54
	 */
	public static List<CarbonCopyDTO> listCarbonCopy(TableTagBean ttb) throws ServiceException {
		StringBuilder hql = new StringBuilder();
		hql.append("from CarbonCopy cc where 1=1");
		if(StringUtils.isNotEmpty(ttb.getCondition().get("fileId"))){
			hql.append(" and cc.ccFileID = '"+ttb.getCondition().get("fileId")+"'");
		}else{
			hql.append(" and 1=2");
		}
		
		return BeanHelper.copyProperties(DaoUtil.find(hql.toString()), CarbonCopyDTO.class);
	}

}
