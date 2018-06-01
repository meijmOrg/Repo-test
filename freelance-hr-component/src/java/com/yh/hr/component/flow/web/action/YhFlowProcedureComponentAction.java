package com.yh.hr.component.flow.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.facade.YhFlowProcedureComponentFacade;
import com.yh.hr.component.flow.web.form.YhFlowComponentForm;
import com.yh.hr.res.dictionary.DicConstants;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;

/**
 * @description 流程审批过程组件action
 * @author meijm
 * @created 2018-5-8
 * @version 1.0
 */
public class YhFlowProcedureComponentAction extends BaseAction {
	private YhFlowProcedureComponentFacade yhFlowProcedureComponentFacade = (YhFlowProcedureComponentFacade) SpringBeanUtil.getBean("yhFlowProcedureComponentFacade");

	/**
	 * 跳转到提交流程(用户弹框)页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goProUserListPartial(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			//String templateId = request.getParameter("templateId");
			String templateId = "68785b4b-e1cd-43dc-877a-79ef103d1c95";
			String actId = "1e4efb51-2284-4792-88ea-2266c670f331";
			String flag = request.getParameter("flag");
			String csUserList = request.getParameter("csUserList");
			YhFlowComponentDTO fdto = new YhFlowComponentDTO();
			fdto.setTemplateId(templateId);
			fdto.setTaskCurrentActId(actId);
			Map<String,List<WorkflowActivityDTO>> actInfo = yhFlowProcedureComponentFacade.goUserListPartial(fdto);
			if(!MapUtils.isEmpty(actInfo)){
	        	 for(Map.Entry<String, List<WorkflowActivityDTO>> me:actInfo.entrySet()){
	        		 request.setAttribute(me.getKey(), me.getValue());
	        	 }
			   }
			request.setAttribute("templateId", templateId);
			request.setAttribute("csUserList", csUserList);
			if(StringUtils.isNotEmpty(flag)){
				return mapping.findForward(flag);
			}
			return mapping.findForward(FORWARD_SUCCESS);
		} catch (Exception e) {
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
	public ActionForward submitFlowProcedure(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
//			dto.setFileFlowStatus(DicConstants.YHRS4008_1);//审批中
			yhFlowProcedureComponentFacade.submitFlowStart(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "提交成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "提交失败！")));
		}
		return null;
	}
	
	/**
	 * 退回
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward sendBack(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			yhFlowProcedureComponentFacade.recheckBack(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "退回成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "退回失败！")));
		}
		return null;
	}
	
	/**
	 * 加签(确定)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submitProSighUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			dto.setFileFlowStatus(DicConstants.YHRS4008_5);//加签中
			dto.setTaskSign("Y");//加签标识
			yhFlowProcedureComponentFacade.submitSighUsers(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "提交成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "提交失败！")));
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
	public ActionForward submitProCsUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			dto.setFileFlowStatus(DicConstants.YHRS4008_1);//审批中
			yhFlowProcedureComponentFacade.submitCsUsers(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "提交成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "提交失败！")));
		}
		return null;
	}
	
	/**
	 * 协同(确定)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submitCoordinationUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			dto.setFileFlowStatus(DicConstants.YHRS4008_4);//协同中
			dto.setTaskCoordination("Y");//协同标识
			yhFlowProcedureComponentFacade.submitSighUsers(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "提交成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "提交失败！")));
		}
		return null;
	}
	
}
