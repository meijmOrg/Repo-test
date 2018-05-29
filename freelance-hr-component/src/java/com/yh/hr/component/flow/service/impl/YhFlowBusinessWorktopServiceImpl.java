package com.yh.hr.component.flow.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.component.flow.queryhelper.YhFlowBusinessWorktopQueryHelper;
import com.yh.hr.component.flow.service.YhFlowBusinessWorktopService;
import com.yh.platform.core.exception.ServiceException;
/**
 * @ClassName: YhFlowBusinessWorktopServiceImpl 
 * @Description: 业务工作台ServiceImpl
 * @author: liul
 * @date: 2018-5-29 上午09:35:23
 */
public class YhFlowBusinessWorktopServiceImpl implements  YhFlowBusinessWorktopService
{

	/* (non-Javadoc)
	 * @see com.yh.hr.component.flow.service.YhFlowComponentWorktopService#listBusinessInfo(com.yh.component.taglib.TableTagBean)
	 */
	@Override
	public List<JSONObject> listBusinessInfo(TableTagBean ttb)
			throws ServiceException {
		return YhFlowBusinessWorktopQueryHelper.listBusinessInfo(ttb);
	}

	/* (non-Javadoc)
	 * @see com.yh.hr.component.flow.service.YhFlowBusinessWorktopService#getBusinessTotal()
	 */
	@Override
	public JSONObject getBusinessTotal() throws ServiceException {
		return YhFlowBusinessWorktopQueryHelper.getBusinessTotal();
	}

}
