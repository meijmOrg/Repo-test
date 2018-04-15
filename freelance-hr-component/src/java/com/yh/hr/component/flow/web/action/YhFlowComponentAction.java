package com.yh.hr.component.flow.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.facade.YhFlowComponentFacade;
import com.yh.hr.component.flow.web.form.YhFlowComponentForm;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;

/**
 * @description 流程启动组件action
 * @author meijm
 * @created 2018-1-18
 * @version 1.0
 */
public class YhFlowComponentAction extends BaseAction {
	private YhFlowComponentFacade yhFlowComponentFacade = (YhFlowComponentFacade) SpringBeanUtil.getBean("yhFlowComponentFacade");

	/**
	 * 跳转到提交流程(用户弹框)页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goUserListPartial(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			//String templateId = request.getParameter("templateId");
			String templateId = "68785b4b-e1cd-43dc-877a-79ef103d1c95";
			Map<String,List<WorkflowActivityDTO>> ActInfo = yhFlowComponentFacade.goUserListPartial(templateId);
			if(!MapUtils.isEmpty(ActInfo)){
	        	 for(Map.Entry<String, List<WorkflowActivityDTO>> me:ActInfo.entrySet()){
	        		 request.setAttribute(me.getKey(), me.getValue());
	        	 }
			   }
			return mapping.findForward(FORWARD_SUCCESS);
		} catch (ServiceException e) {
			this.handleException(request, e, null);
			return mapping.findForward(FORWARD_FAIL);
		}
	}
	
	/**
	 * 提交流程(确定)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submitFlowStart(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			yhFlowComponentFacade.submitFlowStart(dto);
			return mapping.findForward(FORWARD_SUCCESS);
		} catch (ServiceException e) {
			this.handleException(request, e, null);
			return mapping.findForward(FORWARD_FAIL);
		}
	}
	
	/**
	 * 表单数据暂存
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveTemporaryStorage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			yhFlowComponentFacade.saveTemporaryStorage(dto);
			return mapping.findForward(FORWARD_SUCCESS);
		} catch (ServiceException e) {
			this.handleException(request, e, null);
			return mapping.findForward(FORWARD_FAIL);
		}
	}
	
	/**
	 * 保存历史数据
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveHistoryData(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			yhFlowComponentFacade.saveHistoryData(dto);
			return mapping.findForward(FORWARD_SUCCESS);
		} catch (ServiceException e) {
			this.handleException(request, e, null);
			return mapping.findForward(FORWARD_FAIL);
		}
	}
	
	/**
	 * 跳转到加签、抄送、协同选择人员页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goSelectPersons(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 列出人员信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listPersonInfo(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		TableTagBean ttb = new TableTagBean(request);
		try {
			List<JSONObject> list = yhFlowComponentFacade.listPersonInfo(ttb);
			JSONObject obj = new JSONObject();
			obj.put("total", ttb.getTotal());
			obj.put("rows", null != list ? list : new ArrayList<Object>());
			response.getWriter().print(obj.toString());
		} catch (Exception e) {
			this.handleException(request, e, "查询人员选择列表失败!");
			response.getWriter().print(
					JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(
							e.getMessage(), "查询人员信息失败")));
		}
		return null;
	}
	
	/**
	 * 抄送用户(确定)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submitCcUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			yhFlowComponentFacade.submitCcUsers(dto);
			return mapping.findForward(FORWARD_SUCCESS);
		} catch (ServiceException e) {
			this.handleException(request, e, null);
			return mapping.findForward(FORWARD_FAIL);
		}
	}
	
	/**
	 * 查询部门、小组、角色
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryDepGroRole(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			JSONObject jsonObject = yhFlowComponentFacade.queryDepGroRole();
			response.getWriter().print(jsonObject.toString());
		} catch (Exception e) {
			this.handleException(request, e, "查询所在部门、小组、角色信息失败!");
		}
		return null;
	}
	
}
