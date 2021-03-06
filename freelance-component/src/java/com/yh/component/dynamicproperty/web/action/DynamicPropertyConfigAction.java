/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2017-05-13
**/
package com.yh.component.dynamicproperty.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.facade.DynamicPropertyConfigFacade;
import com.yh.component.dynamicproperty.util.DynamicPropertyUtil;
import com.yh.component.dynamicproperty.web.form.DynamicPropertyForm;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;
/**
 * @desc 功能字段配置action
 * @author liul
 * @createDate 2017-11-09
 */
public class DynamicPropertyConfigAction extends BaseAction {
	
	private DynamicPropertyConfigFacade dynamicPropertyConfigFacade = (DynamicPropertyConfigFacade) SpringBeanUtil.getBean("dynamicPropertyConfigFacade");

	/**
	 * 跳转至功能字段配置页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goDynamicPropertyConfigUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return mapping.findForward("success");
	}
	/**
	 * 启用/停用 功能字段
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */                  
	public ActionForward doDynamicPropertyAvailable(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String dpId =request.getParameter("dpId");
		String status = request.getParameter("status");
		if(StringUtils.isNotEmpty(dpId)){
			dynamicPropertyConfigFacade.doDynamicPropertyAvailable(dpId,status);
			response.getWriter().write(JSONHelper.fromObject(true, status).toString());
		}else{
			//判断是启用还是停用 分别赋值
			if(StringUtils.isNotEmpty(status)&&status.equals(DynamicPropertyUtil.YHRS3002_1)){
				response.getWriter().write(JSONHelper.fromObject(true, "启用字段失败！").toString());
			}else{
				response.getWriter().write(JSONHelper.fromObject(true, "停用字段失败！").toString());
			}
		}
	
	return null;
	}
	/**
	 * 跳转到修改字段含义页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goUpdateDpDescription(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		DynamicPropertyForm dynamicPropertyForm=(DynamicPropertyForm) form;
		String dpId = request.getParameter("dpId");
		String dpDescription = request.getParameter("dpDescription");
		if(StringUtils.isNotEmpty(dpId)){
			dynamicPropertyForm.setDpId(Long.valueOf(dpId));
			dynamicPropertyForm.setDpDescription(dpDescription);
			request.setAttribute("dynamicPropertyForm", dynamicPropertyForm);
			return mapping.findForward("success");
		}else{
			return mapping.findForward("fail");
		}
		
		
	}
	/**
	 * 修改字段含义
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateDpDescription(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DynamicPropertyForm dynamicPropertyForm=(DynamicPropertyForm) form;
	 try {
		DynamicPropertyDTO dynamicPropertyDto = BeanHelper.exportProperties(dynamicPropertyForm, DynamicPropertyDTO.class);
		if(dynamicPropertyDto.getDpId()!=null){
			dynamicPropertyConfigFacade.updateDpDescription(dynamicPropertyDto);
			response.getWriter().write(JSONHelper.fromObject(true, "保存成功！").toString());
		}else{
			response.getWriter().write(JSONHelper.fromObject(false, "保存失败，未获取到参数！").toString());
		}
        } catch (Exception e) {
            handleException(request, e, e.getMessage());
            response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "系统异常，修改字段含义失败")).toString());
            return null;
       }
	return null;
}
}
