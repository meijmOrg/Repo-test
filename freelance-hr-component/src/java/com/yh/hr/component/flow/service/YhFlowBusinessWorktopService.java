package com.yh.hr.component.flow.service;

import java.util.List;

import net.sf.json.JSONObject;


import com.yh.component.taglib.TableTagBean;
import com.yh.platform.core.exception.ServiceException;

/**
 * 
 * @ClassName: YhFlowBusinessWorktopService 
 * @Description: 业务工作台Service
 * @author: liul
 * @date: 2018-5-29 上午09:36:15
 */
public interface YhFlowBusinessWorktopService {

	/** 
	* @Title: listBusinessInfo 
	* @Description: 根据条件获取业务列表 
	* @param ttb
	* @return List<JSONObject>
	*/ 
	List<JSONObject> listBusinessInfo(TableTagBean ttb) throws ServiceException;

	/** 
	* @Title: getBusinessTotal 
	* @Description: 获取业务记录条数 
	* @return JSONObject
	*/ 
	JSONObject getBusinessTotal() throws ServiceException;
}
