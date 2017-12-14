/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2017-05-13
**/
package com.yh.component.dynamicproperty.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.dto.TablePropertyDTO;
import com.yh.component.dynamicproperty.facade.DynamicPropertyFacade;
import com.yh.component.dynamicproperty.web.form.DynamicPropertyForm;
import com.yh.component.taglib.TableTagBean;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;
/**
 * @desc 动态字段控制action
 * @author liul
 * @createDate 2017-10-31
 */
public class DynamicPropertyAction extends BaseAction {
	
	private DynamicPropertyFacade dynamicPropertyFacade = (DynamicPropertyFacade) SpringBeanUtil.getBean("dynamicPropertyFacade");

	/**
	 * 跳转至动态字段控制页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goDynamicPropertyUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return mapping.findForward("success");
	}
	/**
	 * 跳转到新增动态字段页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goCreateDynamicProperty(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		DynamicPropertyForm dynamicPropertyForm=(DynamicPropertyForm) form;
		String columnName = request.getParameter("columnName");
		String dataType = request.getParameter("dataType");
		String dpCode = request.getParameter("dpCode");
		dynamicPropertyForm.setDpName(columnName);
		dynamicPropertyForm.setDpType(dataType);
		dynamicPropertyForm.setDpCode(dpCode);
		request.setAttribute("dynamicPropertyForm", dynamicPropertyForm);
		return mapping.findForward("success");
	}
	/**
	 * 跳转至字段控制页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goToPropertyList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String dpCode = request.getParameter("dpCode");
		String flag = request.getParameter("flag");
		request.setAttribute("dpCode", dpCode);
		if(StringUtils.isNotEmpty(flag)){
			TableTagBean ttb = TableTagBean.getFromRequest(request);
			List<TablePropertyDTO> list = dynamicPropertyFacade.getTablePropertyList(ttb);
			request.setAttribute("tableList", list);
			return mapping.findForward("TABLE");//原表字段
		}
		return mapping.findForward("DYNAMIC");//管理库字段
	}
	
	/**
	 * 查询原表字段数据列表(1、根据编码查询数据库表 并展示字段名称 字段类型等信息   ----添加到管理库 (修改字段含义 字段类别 字段状态等信息（字段编码（表名？？）） 新增至动态字段表中  同一页面关联展示  可删除动态字段)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	/*public ActionForward getTablePropertyList(ActionMapping mapping, 
    		   ActionForm form,
    		   HttpServletRequest request, 
    		   HttpServletResponse response) throws Exception
	{
		try{
			TableTagBean ttb = TableTagBean.getFromRequest(request);
			List<TablePropertyDTO> list = dynamicPropertyFacade.getTablePropertyList(ttb);
			JSONObject obj = new JSONObject();
			obj.put("total", ttb.getTotal());
			obj.put("rows", list);
			response.getWriter().print(obj.toString());
			return null;
		}catch(Exception e)
		{
			handleException(request, e, "加载字段列表出错!");
			response.getWriter().print("{'fail':'fail','msg':'" + (GenericValidator.isBlankOrNull(e.getMessage())?"加载字段列表出错!":e.getMessage()) + "'}");
			return null;
		}
	}*/
	/**
	 * 查询管理库字段数据列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getDynamicPropertyList(ActionMapping mapping, 
 		   ActionForm form,
 		   HttpServletRequest request, 
 		   HttpServletResponse response) throws Exception
	{
		try{
			TableTagBean ttb = TableTagBean.getFromRequest(request);
			List<JSONObject> list = dynamicPropertyFacade.getDynamicPropertyList(ttb);
			JSONObject obj = new JSONObject();
			obj.put("total", ttb.getTotal());
			obj.put("rows", list);
			response.getWriter().print(obj.toString());
			return null;
		}catch(Exception e)
		{
			handleException(request, e, "加载字段列表出错!");
			response.getWriter().print("{'fail':'fail','msg':'" + (GenericValidator.isBlankOrNull(e.getMessage())?"加载字段列表出错!":e.getMessage()) + "'}");
			return null;
		}
	}

	/**
	 * 新增动态字段
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createDynamicProperty(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
			DynamicPropertyForm dynamicPropertyForm=(DynamicPropertyForm) form;
		 try {
			DynamicPropertyDTO dynamicPropertyDto = BeanHelper.exportProperties(dynamicPropertyForm, DynamicPropertyDTO.class);
			dynamicPropertyFacade.create(dynamicPropertyDto);
			response.getWriter().write(JSONHelper.fromObject(true, "保存成功！").toString());
	        } catch (Exception e) {
	            handleException(request, e, e.getMessage());
	            response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "系统异常，添加到管理库失败")).toString());
	            return null;
	       }
		return null;
	}
	/**
	 * 删除
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteDynamicProperty(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String dpId =request.getParameter("dpId");
		if(StringUtils.isNotEmpty(dpId)){
			dynamicPropertyFacade.deleteDynamicProperty(dpId);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}else{
			response.getWriter().write(JSONHelper.fromObject(true, "刪除字段失败！").toString());
		}
	
	return null;
}
}