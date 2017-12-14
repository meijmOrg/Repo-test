package com.yh.component.dynamicproperty.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.dto.TablePropertyDTO;
import com.yh.component.dynamicproperty.service.DynamicPropertyService;
import com.yh.component.taglib.TableTagBean;
import com.yh.platform.core.exception.ServiceException;
/**
 * @desc 动态字段控制Facade
 * @author liul
 * @createDate 2017-10-31
 */
public class DynamicPropertyFacade {
	private DynamicPropertyService dynamicPropertyService;
	public void setDynamicPropertyService(
			DynamicPropertyService dynamicPropertyService) {
		this.dynamicPropertyService = dynamicPropertyService;
	}
	/**
	 * 根据参数获取原表中的字段数据
	 * @param ttb
	 * @return
	 * @throws ServiceException
	 */
	public List<TablePropertyDTO> getTablePropertyList(TableTagBean ttb) throws ServiceException{
		return dynamicPropertyService.getTablePropertyList(ttb);
	}
	/**
	 * 根据参数获取管理库中的字段数据
	 * @param ttb
	 * @return
	 * @throws ServiceException
	 */
	public List<JSONObject> getDynamicPropertyList(TableTagBean ttb) throws ServiceException{
		return dynamicPropertyService.getDynamicPropertyList(ttb);
	}
	/**
	 * 新增动态字段
	 * @param dynamicPropertyDto
	 * @throws ServiceException
	 */
	public void create(DynamicPropertyDTO dynamicPropertyDto) throws ServiceException{
		// TODO Auto-generated method stub
		dynamicPropertyService.create(dynamicPropertyDto);
	}
	public void deleteDynamicProperty(String dpId) throws ServiceException {
		// TODO Auto-generated method stub
		dynamicPropertyService.deleteDynamicProperty(dpId);
	}

}
