package com.yh.hr.info.projectinitialize.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.info.projectinitialize.dto.ProjectInitializeDTO;
import com.yh.hr.info.projectinitialize.facade.ProjectInitializeFacade;
import com.yh.hr.info.projectinitialize.web.form.ProjectInitializeForm;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.DESUtils;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;

/**
 * @description 项目初始化action
 * @author meijm
 * @created 2017-9-19
 * @version 1.0
 */
public class ProjectInitializeAction extends BaseAction {

	private ProjectInitializeFacade projectInitializeFacade	= (ProjectInitializeFacade) SpringBeanUtil.getBean("projectInitializeFacade");
	
	/**
	 * 跳转到项目初始化工作台
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goCustomerInfoList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		return mapping.findForward("success");
	}
	
	/**
	 * 列出客户信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listCustomerInfo(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
			try {
				TableTagBean ttb = new TableTagBean(request);
				List<ProjectInitializeDTO> list = projectInitializeFacade.listCustomerInfo(ttb);
				JSONObject json = new JSONObject();
				JSONArray array = new JSONArray();
				json.put("total", ttb.getTotal());
				if(CollectionUtils.isNotEmpty(list)){
					JSONObject obj = null;
					for (ProjectInitializeDTO dto : list) {
						if("0".equals(dto.getStartStatus())){
							dto.setStartStatus("未启动");
						}else if("1".equals(dto.getStartStatus())){
							dto.setStartStatus("已启动");
						}
						obj = JSONHelper.fromObject(dto, DateUtil.DATE_PATTERN_DEFAULT);
						array.element(obj);
					}
				}
				json.put("rows", array);
				response.getWriter().print(json.toString());
			} catch (Exception e) {
				handleException(request, e, "查询客户信息失败");
				response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "查询客户信息失败")));
			}
	return null;
	}
	
	/**
	 * 跳转到客户新增页面(启动配置)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goCustomerCreate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		return mapping.findForward("success");
	}
	
	/**
	 * 客户新增(启动配置)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createCustomerInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ProjectInitializeForm projectInitializeForm=(ProjectInitializeForm) form;
		 try {
			 ProjectInitializeDTO dto = new ProjectInitializeDTO();
			 BeanHelper.copyProperties(projectInitializeForm, dto);
			 projectInitializeFacade.create(dto);
			 response.getWriter().write(JSONHelper.fromObject(true, null).toString());
	        } catch (Exception e) {
	            handleException(request, e, e.getMessage());
	            response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "系统异常，增加客户信息失败")).toString());
	            return null;
	       }
		return null;
	}
	
	/**
	 * 跳转到客户修改页面(修改配置)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goCustomerUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ProjectInitializeForm projectInitializeForm = (ProjectInitializeForm)form;
		String customerOid = request.getParameter("customerOid");
		try{
			if(StringUtils.isNotEmpty(customerOid)){
				ProjectInitializeDTO dto = projectInitializeFacade.get(customerOid);
				BeanHelper.copyProperties(dto, projectInitializeForm);
			}
			request.setAttribute("projectInitializeForm", projectInitializeForm);
		} catch (Exception e) {
			handleException(request, e, e.getMessage());
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "系统异常，修改客户信息失败")).toString());
            return null;
		}
		return mapping.findForward("success");
	}
	
	/**
	 * 客户修改(修改配置)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateCustomerInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ProjectInitializeForm projectInitializeForm=(ProjectInitializeForm) form;
		 try {
			 String licenseCode = projectInitializeForm.getLicenseCode();//原license码
			 if(null == projectInitializeForm.getCustomerOid()){
				 throw new ServiceException("customerOid is null", "customerOid customerOid is null");
			 }
			 ProjectInitializeDTO odto = projectInitializeFacade.get(projectInitializeForm.getCustomerOid().toString());
			 if(null == odto){
				 throw new ServiceException("CustomerInfo not found", "CustomerInfo not found by customerOid");
			 }
			 if(licenseCode.equals(odto.getLicenseCode())){//原license码和数据库存的license码比较，相同就执行下一步更新操作
				 ProjectInitializeDTO dto = new ProjectInitializeDTO();
				 BeanHelper.copyProperties(projectInitializeForm, dto);
				 projectInitializeFacade.update(dto);
				 response.getWriter().write(JSONHelper.fromObject(true, null).toString());
			 }else{
				 throw new ServiceException("mismatching", "license mismatching"); 
			 }
	        } catch (Exception e) {
	            handleException(request, e, e.getMessage());
	            response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "系统异常，修改客户信息失败")).toString());
	            return null;
	       }
		return null;
	}
	
	/**
	 * 生成license码
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createLicense(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		 	HttpServletResponse response) throws Exception{
		 String mw = request.getParameter("mw");
		 try {
			 String licenseStr = DESUtils.encrypt(mw);
			 response.getWriter().write(JSONHelper.fromObject(true, licenseStr).toString());
	        } catch (Exception e) {
	            handleException(request, e, e.getMessage());
	            response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "系统异常，生成license码失败")).toString());
	            return null;
	       }
		return null;
	}
	
}
