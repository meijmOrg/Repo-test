package com.yh.component.dynamicproperty.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.dto.TablePropertyDTO;
import com.yh.component.taglib.TableTagBean;
import com.yh.platform.core.exception.ServiceException;
/**
 * @desc 动态字段控制Service
 * @author liul
 * @createDate 2017-10-31
 */
public interface DynamicPropertyService {

	/**
	 * 根据参数获取原表中的字段数据
	 * @param ttb
	 * @return
	 * @throws ServiceException
	 */
	public List<TablePropertyDTO> getTablePropertyList(TableTagBean ttb)throws ServiceException;
	/**
	 * 根据参数获取管理库中的字段数据
	 * @param ttb
	 * @return
	 * @throws ServiceException
	 */
	public List<JSONObject> getDynamicPropertyList(TableTagBean ttb)throws ServiceException;
	/**
	 * 新增动态字段
	 * @param dynamicPropertyDto
	 * @throws ServiceException
	 */
	public void create(DynamicPropertyDTO dynamicPropertyDto)throws ServiceException;
	/**
	 * 删除
	 * @param dpId
	 * @throws ServiceException
	 */
	public void deleteDynamicProperty(String dpId)throws ServiceException;


}
