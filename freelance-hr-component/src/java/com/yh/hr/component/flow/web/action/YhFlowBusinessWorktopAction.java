package com.yh.hr.component.flow.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.component.flow.facade.YhFlowBusinessWorktopFacade;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;

/**
 * @ClassName: YhFlowBusinessWorktopAction 
 * @Description: 业务工作台Action
 * @author: liul
 * @date: 2018-5-29 上午09:31:28
 */
public class YhFlowBusinessWorktopAction extends BaseAction {
	private YhFlowBusinessWorktopFacade yhFlowBusinessWorktopFacade = (YhFlowBusinessWorktopFacade) SpringBeanUtil.getBean("yhFlowBusinessWorktopFacade");
	/**
	 * 跳转到流程工作台页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goFlowWorktop(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
			String dataType = request.getParameter("dataType");
			if(StringUtils.isEmpty(dataType)){
				throw new ServiceException(null, "dataType is null");
			}
			return mapping.findForward(dataType);
	}
	/**
	 * 
	* @Title: listBusinessInfo 
	* @Description: 获取业务记录列表 
	* @param mapping
	* @param form
	* @param request
	* @param response
	* @return
	* @throws Exception ActionForward
	 */
	public ActionForward listBusinessInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			String dataType = request.getParameter("dataType");
			if(StringUtils.isEmpty(dataType)){
				throw new ServiceException(null, "dataType is null");
			}
			TableTagBean ttb = new TableTagBean();
			ttb.getCondition().put("dataType", dataType);
			//根据dataType获取相应的数据
			List<JSONObject> list = yhFlowBusinessWorktopFacade.listBusinessInfo(ttb);
			JSONObject obj = new JSONObject();
			obj.put("total", ttb.getTotal());
			obj.put("rows", list);
			response.getWriter().print(obj.toString());
			return null;
		} catch (Exception e) {
			handleException(request, e, "加载业务列表出错!");
			response.getWriter().print("{'fail':'fail','msg':'" + (GenericValidator.isBlankOrNull(e.getMessage())?"加载业务列表出错!":e.getMessage()) + "'}");
			return null;
		}
	}
	/**
	 * 
	* @Title: getBusinessTotal 
	* @Description: 获取业务记录条数 
	* @param mapping
	* @param form
	* @param request
	* @param response
	* @return
	* @throws Exception ActionForward
	 */
	public ActionForward getBusinessTotal(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			//根据dataType获取相应的数据
			JSONObject obj = yhFlowBusinessWorktopFacade.getBusinessTotal();
			response.getWriter().print(obj.toString());
			return null;
		} catch (Exception e) {
			handleException(request, e, "加载业务列表出错!");
			response.getWriter().print("{'fail':'fail','msg':'" + (GenericValidator.isBlankOrNull(e.getMessage())?"加载业务列表出错!":e.getMessage()) + "'}");
			return null;
		}
	}
}
