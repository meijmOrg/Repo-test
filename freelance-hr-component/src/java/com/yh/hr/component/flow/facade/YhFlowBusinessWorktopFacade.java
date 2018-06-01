package com.yh.hr.component.flow.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.component.flow.service.YhFlowBusinessWorktopService;
import com.yh.platform.core.exception.ServiceException;
/**
 * 
 * @ClassName: YhFlowBusinessWorktopFacade 
 * @Description: 业务工作台Facade
 * @author: liul
 * @date: 2018-5-29 上午09:36:05
 */
public class YhFlowBusinessWorktopFacade {
	
	private YhFlowBusinessWorktopService yhFlowBusinessWorktopService;

	public void setYhFlowBusinessWorktopService(
			YhFlowBusinessWorktopService yhFlowBusinessWorktopService) {
		this.yhFlowBusinessWorktopService = yhFlowBusinessWorktopService;
	}
	/**
	 * 
	* @Title: listBusinessInfo 
	* @Description: 获取业务记录列表 
	* @param ttb
	* @return
	* @throws ServiceException List<JSONObject>
	 */
	public List<JSONObject> listBusinessInfo(TableTagBean ttb) throws ServiceException{
		return yhFlowBusinessWorktopService.listBusinessInfo(ttb);
	}
	/** 
	* @Title: getBusinessTotal 
	* @Description: 获取业务记录条数 
	* @return JSONObject
	*/ 
	public JSONObject getBusinessTotal() throws ServiceException{
		return yhFlowBusinessWorktopService.getBusinessTotal();
	}
}
