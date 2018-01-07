package com.yh.component.dynamicproperty.service.impl;



import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.yh.component.dynamicproperty.bo.DynamicProperty;
import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.queryhelper.DynamicPropertyQueryHelper;
import com.yh.component.dynamicproperty.service.DynamicPropertyConfigService;
import com.yh.component.dynamicproperty.util.DynamicPropertyUtil;
import com.yh.component.taglib.TableTagBean;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
/**
 * @desc 功能字段配置ServiceImpl
 * @author liul
 * @createDate 2017-11-09
 */
public class DynamicPropertyConfigServiceImpl implements DynamicPropertyConfigService{

	/*
	 * (non-Javadoc)
	 * @see com.yh.component.dynamicproperty.service.DynamicPropertyConfigService#doDynamicPropertyAvailiable(java.lang.String, java.lang.String)
	 */
	public void doDynamicPropertyAvailable(String dpId,String status) throws ServiceException {
		DynamicProperty dp = DaoUtil.get(DynamicProperty.class, Long.valueOf(dpId));
		if(dp!=null){
			//如果是启用状态则置为停用 否则置为启用  
			if(StringUtils.isNotEmpty(status)&&status.equals(DynamicPropertyUtil.YHRS3002_1)){
				//停用
				dp.setDpState(DynamicPropertyUtil.YHRS3002_2);
			}else{
				//启用
				dp.setDpState(DynamicPropertyUtil.YHRS3002_1);
			}
			dp.update();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.dynamicproperty.service.DynamicPropertyConfigService#updateDpDescription(com.yh.component.dynamicproperty.dto.DynamicPropertyDTO)
	 */
	public void updateDpDescription(DynamicPropertyDTO dynamicPropertyDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		DynamicProperty dp = DaoUtil.get(DynamicProperty.class, dynamicPropertyDto.getDpId());
		dp.setDpDescription(dynamicPropertyDto.getDpDescription());
		dp.update();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.dynamicproperty.service.DynamicPropertyConfigService#getDynamicPropertyConfig(java.lang.String)
	 */
	public List<DynamicPropertyDTO> getDynamicPropertyConfig(String tableName)
			throws ServiceException {
		// 获取控制页面展示的信息
		TableTagBean ttb = new TableTagBean();
		ttb.getCondition().put("dpCode", tableName);
		return DynamicPropertyQueryHelper.getDynamicPropertyListByHQL(ttb);
	}

	
}
