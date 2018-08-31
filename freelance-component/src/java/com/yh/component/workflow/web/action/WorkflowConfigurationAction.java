/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2017-05-13
**/
package com.yh.component.workflow.web.action;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.alibaba.fastjson.JSON;
import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.facade.DynamicPropertyConfigFacade;
import com.yh.component.dynamicproperty.util.DynamicPropertyUtil;
import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.Flow;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
import com.yh.component.workflow.facade.WorkflowConfigurationFacade;
import com.yh.component.workflow.vo.DrawingBaseInfo;
import com.yh.component.workflow.vo.DrawingFlow;
import com.yh.component.workflow.vo.DrawingFlowRule;
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
	private DynamicPropertyConfigFacade dynamicPropertyConfigFacade = (DynamicPropertyConfigFacade) SpringBeanUtil.getBean("dynamicPropertyConfigFacade");
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
				String templateId = request.getParameter("templateId");
				TableTagBean ttb = TableTagBean.getFromRequest(request);
				List<JSONObject> list = workflowConfigurationFacade.listWorkflowTemplet(ttb);
				JSONObject obj = new JSONObject();
				obj.put("total", ttb.getTotal());
				obj.put("rows", list);
				obj.put("templateId", templateId);
				request.setAttribute("templateId", templateId);
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
		/**
		 * 调用动态字段方法 获取动态字段配置信息
		 */
		List<DynamicPropertyDTO> dpList = dynamicPropertyConfigFacade.getDynamicPropertyConfig(DynamicPropertyUtil.yhf_file_template);
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		if(CollectionUtils.isNotEmpty(dpList)){
			for(DynamicPropertyDTO dto:dpList){
				JSONObject json = JSONHelper.fromObject(dto);
				jsonList.add(json);
			}
		}
		WorkflowConfigurationForm workflowConfigurationForm = new WorkflowConfigurationForm();
		workflowConfigurationForm.setDpList(jsonList);
		request.setAttribute("workflowConfigurationForm", workflowConfigurationForm);
		String templateId = request.getParameter("templateId");
		request.setAttribute("templateId", templateId);
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
				/**
				 * 调用动态字段方法 获取动态字段配置信息
				 */
				List<DynamicPropertyDTO> dpList = dynamicPropertyConfigFacade.getDynamicPropertyConfig(DynamicPropertyUtil.yhf_file_template);
				List<JSONObject> jsonList = new ArrayList<JSONObject>();
				if(CollectionUtils.isNotEmpty(dpList)){
					for(DynamicPropertyDTO dto:dpList){
						JSONObject json = JSONHelper.fromObject(dto);
						jsonList.add(json);
					}
				}
				workflowConfigurationForm.setDpList(jsonList);
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
 		String templetId = request.getParameter("templateId");
 		String flagStatus = request.getParameter("flagStatus");
 		String templateId = "";
		WorkflowConfigurationForm workflowConfigurationForm = (WorkflowConfigurationForm) form;
		try
		{
			if(StringUtils.isNotEmpty(flagStatus)&&flagStatus.equals("INSERT")){
				WorkflowConfigurationDTO workflowConfigurationDto = BeanHelper.copyProperties(workflowConfigurationForm, WorkflowConfigurationDTO.class);
				templateId = workflowConfigurationFacade.insertTemplet(workflowConfigurationDto);
			}else if(StringUtils.isNotEmpty(flagStatus)&&flagStatus.equals("UPDATE")){
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
				templateId = workflowConfigurationFacade.updateTemplet(workflowConfigurationDto);
			}else{
				throw new ServiceException(null, "null");
			}
			response.getWriter().write(JSONHelper.fromObject(true, templateId).toString());
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
	public ActionForward goUpdateFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String templetId = request.getParameter("templetId");//模板Id
		String orgName = request.getParameter("orgName");//所属部门名称
		String orgOid = request.getParameter("orgOid");//部门ID
		//《增改 同一方法》
		String flowId = request.getParameter("flowId");//流程Id
		WorkflowConfigurationDTO workflowConfigurationDto = new WorkflowConfigurationDTO();
		
		if(StringUtils.isNotEmpty(flowId)){
			//修改
			workflowConfigurationDto=workflowConfigurationFacade.getBaseFlowInfo(flowId);
		}else{
			//新增
			//获取默认的活动（启动，结束？）与规则
			workflowConfigurationDto.setFlowOrgName(orgName);
			if(StringUtils.isNotEmpty(orgOid)){
				workflowConfigurationDto.setFlowOrgOid(Long.valueOf(orgOid));
			}
		}
		request.setAttribute("workflowConfigurationDto", workflowConfigurationDto);//流程基本信息
		request.setAttribute("templetId", templetId);
		return mapping.findForward("success");
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
			workflowConfigurationFacade.deleteFlow(baseInfoId);
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
			response.getWriter().write("查询部门信息失败");
			return null;
		}
		return null;
	}
	/**
	 * 跳转至流程画图界面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goViewWorkFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//获取操作类型 view insert update
		String operateFlag = request.getParameter("operateFlag");
		if(StringUtils.isEmpty(operateFlag)){
			throw new ServiceException(null,"operateFlag is null");
		}else if(operateFlag.equals("view")||operateFlag.equals("update")){
			//查询flowData
			String flowId = request.getParameter("flowId");
			if(StringUtils.isEmpty(flowId)){
				throw new ServiceException(null,"flowId is null");
			}
			WorkflowBaseInfoDTO flowInfo = workflowConfigurationFacade.getFlow(flowId);
			
		}else{
			
		}
		request.setAttribute("operateFlag", operateFlag);
		return mapping.findForward("success");
	}
	/**
	 * 保存流程信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveRuleFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String ruleFlowContent = request.getParameter("ruleFlowContent");
		/*String id = request.getParameter("id"); //ruleId
		String ruleFlowId = request.getParameter("ruleFlowId");*/
		String templateId = request.getParameter("templateId");//模板id
		String flowId = request.getParameter("flowId"); //流程ID
		String flowName = request.getParameter("flowName"); //ruleId
		String flowType = request.getParameter("flowType");
		String flowOrgOid = request.getParameter("flowOrgOid"); //ruleId
		String flowOrgName = request.getParameter("flowOrgName");
		try
		{
			if(StringUtils.isEmpty(templateId))
			{
				throw new ServiceException(null, "templateId is null");
			}
			//json to 对象
			if(StringUtils.isNotEmpty(ruleFlowContent)){
				DrawingFlow df = new DrawingFlow();
				df.setTemplateId(templateId);
				df.setFlowId(flowId);
				
				df.setFlowName(flowName);
				df.setFlowType(flowType);
				if(StringUtils.isNotBlank(flowOrgOid))
				{
					df.setFlowOrgOid(Long.valueOf(flowOrgOid));
					df.setFlowOrgName(flowOrgName);
				}
				List<DrawingBaseInfo> dbiList = new ArrayList<DrawingBaseInfo>();
				List<DrawingFlowRule> dfrList = new ArrayList<DrawingFlowRule>();
				/*ruleFlowContent =URLEncoder.encode(ruleFlowContent);
				ruleFlowContent=URLDecoder.decode(URLDecoder.decode(ruleFlowContent, "utf-8"), "utf-8");*/
				df.setFlowData(ruleFlowContent);
				JSONObject ja = JSONObject.fromObject(ruleFlowContent);
				JSONObject states = ja.getJSONObject("states");
				Map<String,Object> statesMaps = JSON.parseObject(states.toString()); 
				for(Map.Entry<String, Object> map:statesMaps.entrySet()){
					DrawingBaseInfo dbi= JSON.parseObject(map.getValue().toString(), DrawingBaseInfo.class);
					dbiList.add(dbi);
				}
				JSONObject paths = ja.getJSONObject("paths");
				Map<String,Object> pathsMaps = JSON.parseObject(paths.toString()); 
				for(Map.Entry<String, Object> map:pathsMaps.entrySet()){
					DrawingFlowRule dfr= JSON.parseObject(map.getValue().toString(), DrawingFlowRule.class);
					dfrList.add(dfr);
				}
				df.setDbiList(dbiList);
				df.setDfrList(dfrList);
				workflowConfigurationFacade.saveRuleFlow(df);
			}
			//states paths
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		}
		catch(Exception se)
		{
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "保存流程信息失败")).toString());
		}
		return null;
	}
}
