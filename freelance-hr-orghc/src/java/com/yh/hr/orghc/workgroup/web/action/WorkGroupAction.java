package com.yh.hr.orghc.workgroup.web.action;


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
import com.yh.hr.orghc.ub.dto.UbOrgDTO;
import com.yh.hr.orghc.unit.unitmanger.dto.OrgDTO;
import com.yh.hr.orghc.unit.unitmanger.facade.UnitMangerFacade;
import com.yh.hr.orghc.unit.unitmanger.web.form.OrgForm;
import com.yh.hr.orghc.workgroup.dto.WorkGroupDTO;
import com.yh.hr.orghc.workgroup.facade.WorkGroupFacade;
import com.yh.hr.orghc.workgroup.web.form.WorkGroupForm;
import com.yh.hr.res.dictionary.DicConstants;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.NumberUtils;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;

public class WorkGroupAction extends BaseAction {

	private WorkGroupFacade workGroupFacade = (WorkGroupFacade) SpringBeanUtil.getBean("workGroupFacade");
	
	/**
	 * 跳转到单位管理工作台
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goBizWorkGroupTop(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		return mapping.findForward("success");
	}
	/**
	 * 跳转到单位新增页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goToWorkGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setAttribute("orgOid", request.getParameter("orgOid"));
		request.setAttribute("unitOid", request.getParameter("unitOid"));
		
		return mapping.findForward("success");
	}
	/**
	 * 根据unitOid查询科室列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listWorkGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			TableTagBean ttb = new TableTagBean(request);
			List<WorkGroupDTO> list = workGroupFacade.listWorkGroup(ttb);
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			json.put("total", list.size());
			if(CollectionUtils.isNotEmpty(list)){
				for (WorkGroupDTO obj : list) {
					
					array.element(obj);
				}
			}
			json.put("rows", array);
			response.getWriter().print(json.toString());

		} catch (Exception e) {
			handleException(request, e, "查询科室列表失败");
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "查询科室列表失败")));
		}

		return null;
	}
	/**
	 * 跳转新增科室
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goCreateWorkGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("orgOid", request.getParameter("orgOid"));
		request.setAttribute("unitOid", request.getParameter("unitOid"));
		return mapping.findForward("success");
	}
	/**
	 * 新增科室
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createWorkGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WorkGroupForm workGroupForm = (WorkGroupForm) form;
		try {
			WorkGroupDTO dto = BeanHelper.copyProperties(workGroupForm, WorkGroupDTO.class);
			workGroupFacade.create(dto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		} catch (Exception e) {
			handleException(request, e, e.getMessage());
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "保存小组信息失败")).toString());

			return null;
		}
		return null;
	}
	/**
	 * 跳转新增科室
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goUpdateWorkGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String wpId=request.getParameter("wpId");
		WorkGroupForm workGroupForm = (WorkGroupForm) form;
		WorkGroupDTO dto = workGroupFacade.getWorkGroup(wpId);
		BeanHelper.copyProperties(dto, workGroupForm);
		request.setAttribute("wpId", request.getParameter("wpId"));
		request.setAttribute("unitOid", request.getParameter("unitOid"));
		return mapping.findForward("success");
	}
	
	/**
	 * 跳转新增科室
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateWorkGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WorkGroupForm workGroupForm = (WorkGroupForm) form;
		try {
			WorkGroupDTO dto = BeanHelper.copyProperties(workGroupForm, WorkGroupDTO.class);
			workGroupFacade.update(dto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		} catch (Exception e) {
			handleException(request, e, e.getMessage());
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "更新小组信息失败")).toString());

			return null;
		}
		return null;
	}
	
	/**
	 * 删除小组记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteWorkGroup(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String wpId = request.getParameter("wpId");
		try
		{
			if(StringUtils.isEmpty(wpId))
			{
				throw new ServiceException(null, "wpId is null");
			}
			workGroupFacade.delete(wpId);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "删除失败")).toString());
		}
		return null;
	}
}
