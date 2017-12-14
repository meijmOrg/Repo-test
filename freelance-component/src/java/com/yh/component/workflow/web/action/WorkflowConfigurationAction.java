/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2017-05-13
**/
package com.yh.component.workflow.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
import com.yh.component.workflow.facade.WorkflowConfigurationFacade;
import com.yh.component.workflow.web.form.WorkflowActivityForm;
import com.yh.component.workflow.web.form.WorkflowConfigurationForm;
import com.yh.component.workflow.web.form.WorkflowRuleForm;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.NumberUtils;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;
/**
 * @desc 流程-模板管理action
 * @author liul
 * @createDate 2017-11-15
 */
public class WorkflowConfigurationAction extends BaseAction {
	
	private WorkflowConfigurationFacade workflowConfigurationFacade = (WorkflowConfigurationFacade) SpringBeanUtil.getBean("workflowConfigurationFacade");

	/**
	 * 跳转至模板管理页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goWorkflowConfigurationUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return mapping.findForward("success");
	}
	/**
	 * 获取模板列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listWorkflowTemplet(ActionMapping mapping, 
	 		   ActionForm form,
	 		   HttpServletRequest request, 
	 		   HttpServletResponse response) throws Exception
		{
			try{
				TableTagBean ttb = TableTagBean.getFromRequest(request);
				List<JSONObject> list = workflowConfigurationFacade.listWorkflowTemplet(ttb);
				JSONObject obj = new JSONObject();
				obj.put("total", ttb.getTotal());
				obj.put("rows", list);
				response.getWriter().print(obj.toString());
				return null;
			}catch(Exception e)
			{
				handleException(request, e, "加载模板列表出错!");
				response.getWriter().print("{'fail':'fail','msg':'" + (GenericValidator.isBlankOrNull(e.getMessage())?"加载字段列表出错!":e.getMessage()) + "'}");
				return null;
			}
		}
	/**
	 * 查看模板信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goViewWorkflowTemplet(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			WorkflowConfigurationForm workflowConfigurationForm=(WorkflowConfigurationForm) form;
			String templetId=request.getParameter("templetId");
			if(StringUtils.isNotEmpty(templetId)){
				//获取模板信息和流程信息
				WorkflowConfigurationDTO workflowConfigurationDto=workflowConfigurationFacade.getTempletInfo(templetId);
				BeanHelper.copyProperties(workflowConfigurationDto, workflowConfigurationForm);
				return mapping.findForward("success");
			}else{
				return mapping.findForward("error");
			}
		} catch (Exception e) {
			handleException(request, e, "跳转到模板信息查看失败");
			return mapping.findForward("error");
		}
	}
	/**
	 * 跳转到新增模板信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goInsertTemplet(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 新增模板信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insertTemplet(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		WorkflowConfigurationForm workflowConfigurationForm = (WorkflowConfigurationForm) form;
		try
		{
			WorkflowConfigurationDTO workflowConfigurationDto = BeanHelper.copyProperties(workflowConfigurationForm, WorkflowConfigurationDTO.class);
			workflowConfigurationFacade.insertTemplet(workflowConfigurationDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "新增失败")).toString());
		}
		return null;
	}
	
	/**
	 * 跳转到修改模板信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goUpdateTemplet(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String templetId = request.getParameter("templetId");
		try
		{
			if(StringUtils.isEmpty(templetId))
			{
				throw new ServiceException(null, "templetId is null");
			}
			WorkflowConfigurationDTO workflowConfigurationDto = workflowConfigurationFacade.getTempletInfo(templetId);
			if(null != workflowConfigurationDto)
			{
				WorkflowConfigurationForm workflowConfigurationForm = BeanHelper.copyProperties(workflowConfigurationDto, WorkflowConfigurationForm.class);
				request.setAttribute("workflowConfigurationForm", workflowConfigurationForm);
			}
			else
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			return mapping.getInputForward();
		}
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 修改模板信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateTemplet(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String templetId = request.getParameter("templetId");
		WorkflowConfigurationForm workflowConfigurationForm = (WorkflowConfigurationForm) form;
		try
		{
			if(StringUtils.isEmpty(templetId))
			{
				throw new ServiceException(null, "templetId is null");
			}
			WorkflowConfigurationDTO workflowConfigurationDto = workflowConfigurationFacade.getTempletInfo(templetId);
			if(null == workflowConfigurationDto)
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
			BeanHelper.copyProperties(workflowConfigurationForm, workflowConfigurationDto);
			workflowConfigurationFacade.updateTemplet(workflowConfigurationDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "修改失败")).toString());
		}
		return null;
	}
	
	/**
	 * 删除模板记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteTemplet(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String templetId = request.getParameter("templetId");
		try
		{
			if(StringUtils.isEmpty(templetId))
			{
				throw new ServiceException(null, "templetId is null");
			}
			workflowConfigurationFacade.deleteTemplet(templetId);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "删除失败")).toString());
		}
		return null;
	}
	/**
	 * 跳转到新建流程-选择部门
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goCreateFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String templetId = request.getParameter("templetId");//模板Id
		String orgName = request.getParameter("orgName");//所属部门名称
		String orgOid = request.getParameter("orgOid");//部门ID
		//《增改 同一方法》
		String baseInfoId = request.getParameter("baseInfoId");//流程Id
		WorkflowConfigurationDTO workflowConfigurationDto = new WorkflowConfigurationDTO();
		
		if(StringUtils.isNotEmpty(baseInfoId)){
			//修改
			workflowConfigurationDto=workflowConfigurationFacade.getBaseFlowInfo(baseInfoId);
		}else{
			//新增
			//获取默认的活动（启动，结束？）与规则
			workflowConfigurationDto.setFlowOrgName(orgName);
			if(StringUtils.isNotEmpty(orgOid)){
				workflowConfigurationDto.setFlowOrgOid(Long.valueOf(orgOid));
			}
		}
		//流程示意图？？？？？？
		request.setAttribute("workflowConfigurationDto", workflowConfigurationDto);//流程基本信息
		request.setAttribute("templetId", templetId);
		return mapping.findForward("success");
	}
	/**
	 * 跳转到修改流程信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goUpdateFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String baseInfoId = request.getParameter("baseInfoId");
		try
		{
			if(StringUtils.isEmpty(baseInfoId))
			{
				throw new ServiceException(null, "baseInfoId is null");
			}
			WorkflowConfigurationDTO workflowConfigurationDto = workflowConfigurationFacade.getBaseFlowInfo(baseInfoId);
			if(null != workflowConfigurationDto)
			{
				//WorkflowConfigurationForm workflowConfigurationForm = BeanHelper.copyProperties(workflowConfigurationDto, WorkflowConfigurationForm.class);
				request.setAttribute("workflowConfigurationDto", workflowConfigurationDto);
			}
			else
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			return mapping.getInputForward();
		}
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 修改流程信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String baseInfoId = request.getParameter("baseInfoId");
		WorkflowConfigurationForm workflowConfigurationForm = (WorkflowConfigurationForm) form;
		try
		{
			if(StringUtils.isEmpty(baseInfoId))
			{
				throw new ServiceException(null, "baseInfoId is null");
			}
			WorkflowConfigurationDTO workflowConfigurationDto = workflowConfigurationFacade.getBaseFlowInfo(baseInfoId);
			if(null == workflowConfigurationDto)
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
			BeanHelper.copyProperties(workflowConfigurationForm, workflowConfigurationDto);
			workflowConfigurationFacade.updateFlow(workflowConfigurationDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "修改失败")).toString());
		}
		return null;
	}
	
	/**
	 * 删除流程记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String baseInfoId = request.getParameter("baseInfoId");
		try
		{
			if(StringUtils.isEmpty(baseInfoId))
			{
				throw new ServiceException(null, "baseInfoId is null");
			}
			workflowConfigurationFacade.deleteFlow(NumberUtils.longValue(baseInfoId));
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "删除失败")).toString());
		}
		return null;
	}
	/**
	 * 查询部门信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws java.lang.Exception
	 */
	public ActionForward goSelectOrgForCreateFlow(ActionMapping mapping, ActionForm form,javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response)throws java.lang.Exception {
		try {
			TableTagBean ttb = new TableTagBean(request);
			//如果不为空，说明是单位查询功能，则不分页
			if(StringUtils.isNotEmpty(ttb.getCondition().get("pageFlag")))
			{
				ttb.setPageSize(0);
			}
			//为空，则说明进行分页查询
			else
			{
				int pageNo=Integer.parseInt(ttb.getCondition().get("pageNo"));
				int pageSize=Integer.parseInt(ttb.getCondition().get("pageSize"));
				ttb.setPage((pageNo-1)*pageSize);
				ttb.setPageSize(pageSize);
			}
			//获取部门信息（一级科室）
			List<WorkflowBaseInfoDTO> list = workflowConfigurationFacade.findOrg(ttb);
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			json.put("total", ttb.getTotal());
			if(CollectionUtils.isNotEmpty(list)){
				JSONObject obj = null;
				for (WorkflowBaseInfoDTO dto : list) {
					obj = JSONHelper.fromObject(dto, DateUtil.DATE_PATTERN_DEFAULT);
					obj.put("orgName", dto.getFlowOrgName());
					obj.put("orgOid", dto.getFlowOrgOid());
					array.element(obj);
				}
			}
			json.put("rows", array);
			response.getWriter().print(json.toString());
			
		} catch (Exception ex) {
			handleException(request, ex, null);
			response.getWriter().write("查询供应商信息失败");
			return null;
		}
		return null;
	}
	/**
	 * 跳转到新增活动信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goInsertActivity(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		//获取流程ID
		String baseInfoId = request.getParameter("baseInfoId");
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 新增活动信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insertActivity(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		WorkflowActivityForm workflowActivityForm = (WorkflowActivityForm) form;
		try
		{
			WorkflowActivityDTO workflowActivityDto = BeanHelper.copyProperties(workflowActivityForm, WorkflowActivityDTO.class);
			workflowConfigurationFacade.insertActivity(workflowActivityDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "新增失败")).toString());
		}
		return null;
	}
	
	/**
	 * 跳转到修改活动信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goUpdateActivity(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String activityId = request.getParameter("activityId");
		try
		{
			if(StringUtils.isEmpty(activityId))
			{
				throw new ServiceException(null, "baseInfoId is null");
			}
			WorkflowActivityDTO workflowActivityDto = workflowConfigurationFacade.getActivityInfo(NumberUtils.longValue(activityId));
			if(null != workflowActivityDto)
			{
				WorkflowActivityForm workflowActivityForm = BeanHelper.copyProperties(workflowActivityDto, WorkflowActivityForm.class);
				request.setAttribute("workflowActivityForm", workflowActivityForm);
			}
			else
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			return mapping.getInputForward();
		}
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 修改活动信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateActivity(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String activityId = request.getParameter("activityId");
		WorkflowActivityForm workflowActivityForm = (WorkflowActivityForm) form;
		try
		{
			if(StringUtils.isEmpty(activityId))
			{
				throw new ServiceException(null, "activityId is null");
			}
			WorkflowActivityDTO workflowActivityDto = workflowConfigurationFacade.getActivityInfo(NumberUtils.longValue(activityId));
			if(null == workflowActivityDto)
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
			BeanHelper.copyProperties(workflowActivityForm, workflowActivityDto);
			workflowConfigurationFacade.updateActivity(workflowActivityDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "修改失败")).toString());
		}
		return null;
	}
	
	/**
	 * 删除活动记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteActivity(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String activityId = request.getParameter("activityId");
		try
		{
			if(StringUtils.isEmpty(activityId))
			{
				throw new ServiceException(null, "activityId is null");
			}
			workflowConfigurationFacade.deleteActivity(NumberUtils.longValue(activityId));
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "删除失败")).toString());
		}
		return null;
	}
	/**
	 * 跳转到新增规则信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goInsertRule(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String baseInfoId = request.getParameter("baseInfoId");
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 新增规则信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insertRule(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		WorkflowRuleForm workflowRuleForm = (WorkflowRuleForm) form;
		try
		{
			WorkflowRuleDTO workflowRuleDto = BeanHelper.copyProperties(workflowRuleForm, WorkflowRuleDTO.class);
			workflowConfigurationFacade.insertRule(workflowRuleDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "新增失败")).toString());
		}
		return null;
	}
	
	/**
	 * 跳转到修改规则信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goUpdateRule(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String ruleId = request.getParameter("ruleId");
		try
		{
			if(StringUtils.isEmpty(ruleId))
			{
				throw new ServiceException(null, "ruleId is null");
			}
			WorkflowRuleDTO workflowRuleDto = workflowConfigurationFacade.getRuleInfo(NumberUtils.longValue(ruleId));
			if(null != workflowRuleDto)
			{
				WorkflowRuleForm workflowRuleForm = BeanHelper.copyProperties(workflowRuleDto, WorkflowRuleForm.class);
				request.setAttribute("workflowRuleForm", workflowRuleForm);
			}
			else
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			return mapping.getInputForward();
		}
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 修改规则信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateRule(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String ruleId = request.getParameter("ruleId");
		WorkflowRuleForm workflowRuleForm = (WorkflowRuleForm) form;
		try
		{
			if(StringUtils.isEmpty(ruleId))
			{
				throw new ServiceException(null, "ruleId is null");
			}
			WorkflowRuleDTO workflowRuleDto = workflowConfigurationFacade.getRuleInfo(NumberUtils.longValue(ruleId));
			if(null == workflowRuleDto)
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
			BeanHelper.copyProperties(workflowRuleForm, workflowRuleDto);
			workflowConfigurationFacade.updateRule(workflowRuleDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "修改失败")).toString());
		}
		return null;
	}
	
	/**
	 * 删除规则记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteRule(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String ruleId = request.getParameter("ruleId");
		try
		{
			if(StringUtils.isEmpty(ruleId))
			{
				throw new ServiceException(null, "ruleId is null");
			}
			workflowConfigurationFacade.deleteRule(NumberUtils.longValue(ruleId));
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
