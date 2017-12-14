package com.yh.component.dynamicproperty.service.impl;



import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import net.sf.json.JSONObject;


import com.yh.component.dynamicproperty.bo.DynamicProperty;
import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.dto.TablePropertyDTO;
import com.yh.component.dynamicproperty.queryhelper.DynamicPropertyQueryHelper;
import com.yh.component.dynamicproperty.service.DynamicPropertyService;
import com.yh.component.taglib.TableTagBean;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
/**
 * @desc 动态字段控制serviceImpl
 * @author liul
 * @createDate 2017-10-31
 */
public class DynamicPropertyServiceImpl implements DynamicPropertyService{

	/*
	 * (non-Javadoc)
	 * @see com.yh.component.dynamicproperty.service.DynamicPropertyService#getTablePropertyList(com.yh.component.taglib.TableTagBean)
	 */
	public List<TablePropertyDTO> getTablePropertyList(TableTagBean ttb)
			throws ServiceException {
		return DynamicPropertyQueryHelper.getTablePropertyList(ttb);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.dynamicproperty.service.DynamicPropertyService#getDynamicPropertyList(com.yh.component.taglib.TableTagBean)
	 */
	public List<JSONObject> getDynamicPropertyList(TableTagBean ttb)
		throws ServiceException {
		return DynamicPropertyQueryHelper.getDynamicPropertyList(ttb);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.dynamicproperty.service.DynamicPropertyService#create(com.yh.component.dynamicproperty.dto.DynamicPropertyDTO)
	 */
	public void create(DynamicPropertyDTO dynamicPropertyDto)
			throws ServiceException {
		DynamicProperty dp = new DynamicProperty();
		BeanUtils.copyProperties(dynamicPropertyDto, dp);
		dp.setDpTime(new Date());
		dp.save();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.dynamicproperty.service.DynamicPropertyService#deleteDynamicProperty(java.lang.String)
	 */
	public void deleteDynamicProperty(String dpId) throws ServiceException {
		DynamicProperty dp = DaoUtil.get(DynamicProperty.class, Long.valueOf(dpId));
		if(dp!=null){
			dp.delete();
		}
	}

	
}
