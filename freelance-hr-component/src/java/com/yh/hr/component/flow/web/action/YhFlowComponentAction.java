package com.yh.hr.component.flow.web.action;

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

import com.yh.component.config.queryhelper.YhSysprmQueryHelper;
import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.CarbonCopyDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.TaskProcessDTO;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.hr.component.annex.facade.UploadAnnexComponentFacade;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.facade.YhFlowComponentFacade;
import com.yh.hr.component.flow.web.form.YhFlowComponentForm;
import com.yh.hr.res.dictionary.DicConstants;
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
	private UploadAnnexComponentFacade uploadAnnexComponentFacade = (UploadAnnexComponentFacade) SpringBeanUtil.getBean("uploadAnnexComponentFacade");
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
			String flag = request.getParameter("flag");
			Map<String,List<WorkflowActivityDTO>> ActInfo = yhFlowComponentFacade.goUserListPartial(templateId);
			if(!MapUtils.isEmpty(ActInfo)){
	        	 for(Map.Entry<String, List<WorkflowActivityDTO>> me:ActInfo.entrySet()){
	        		 request.setAttribute(me.getKey(), me.getValue());
	        	 }
			   }
			request.setAttribute("templateId", templateId);
			if("jq".equals(flag)){
				return mapping.findForward("jq");
			}
			if("cc".equals(flag)){
				return mapping.findForward("cc");
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
	public ActionForward submitFlowStart(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			dto.setFileFlowStatus(DicConstants.YHRS4008_1);//审批中
			yhFlowComponentFacade.submitFlowStart(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "提交成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "提交失败！")));
		}
		return null;
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
			dto.setFileFlowStatus(DicConstants.YHRS4008_0);//未启动
			yhFlowComponentFacade.saveTemporaryStorage(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "保存成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "保存失败！")));
		}
		return null;
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
			dto.setFileFlowStatus(DicConstants.YHRS4008_6);//历史数据
			yhFlowComponentFacade.saveHistoryData(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "保存成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "保存失败！")));
		}
		return null;
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
			List<PermissionUsersDTO> list = yhFlowComponentFacade.listPersonInfo(ttb);
//			JSONObject obj = new JSONObject();
//			obj.put("total", ttb.getTotal());
//			obj.put("rows", null != list ? list : new ArrayList<Object>());
//			response.getWriter().print(obj.toString());
			ttb.setList(list);
			request.setAttribute("ttb", ttb);
		} catch (Exception e) {
			this.handleException(request, e, "查询人员选择列表失败!");
			response.getWriter().print(
					JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(
							e.getMessage(), "查询人员信息失败")));
		}
		//return null;
		return mapping.findForward(FORWARD_SUCCESS);
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
	public ActionForward submitSighUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			dto.setFileFlowStatus(DicConstants.YHRS4008_5);//加签中
			dto.setTaskSign("Y");//加签标识
			yhFlowComponentFacade.submitSighUsers(dto);
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
	public ActionForward submitCsUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
			YhFlowComponentDTO dto = new YhFlowComponentDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			dto.setFileFlowStatus(DicConstants.YHRS4008_1);//审批中
			yhFlowComponentFacade.submitCsUsers(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "提交成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "提交失败！")));
		}
		return null;
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
			this.handleException(request, e, "查询部门、小组、角色信息失败!");
		}
		return null;
	}
	
	/**
	 * 查询关键字信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryKeyWord(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			JSONObject jsonObject = yhFlowComponentFacade.queryKeyWord();
			response.getWriter().print(jsonObject.toString());
		} catch (Exception e) {
			this.handleException(request, e, "查询关键字信息");
		}
		return null;
	}
	/**
	 * 跳转到流程过程主页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goFlowProcedureMainPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String maxFileSize = YhSysprmQueryHelper.getSysConfValue("annex.max.file.size");
		String maxFileCounts = YhSysprmQueryHelper.getSysConfValue("annex.max.file.counts");
		String acceptFileTypes = YhSysprmQueryHelper.getSysConfValue("annex.accept.file.types");
		request.setAttribute("maxFileSize", maxFileSize);
		request.setAttribute("maxFileCounts", maxFileCounts);
		request.setAttribute("acceptFileTypes", acceptFileTypes);
		//获取附件列表
		String fileId = request.getParameter("fileId");
		String faUserName = request.getParameter("faUserName");
		request.setAttribute("fileId", fileId);
		request.setAttribute("faUserName", faUserName);
		TableTagBean ttb = new TableTagBean();
		ttb.getCondition().put("fileId", fileId);
		ttb.getCondition().put("faUserName", faUserName);
		List<FileAnnexDTO> annexFileList = uploadAnnexComponentFacade.listAnnexFile(ttb);
		request.setAttribute("annexFileList", annexFileList);
		//获取抄送信息
		List<CarbonCopyDTO> ccList = yhFlowComponentFacade.listCarbonCopy(ttb);
		request.setAttribute("ccList", ccList);
		//获取流程处理记录 处理意见
		Map<String, List<TaskProcessDTO>> tpMap = yhFlowComponentFacade.listTaskProcess(ttb);
		request.setAttribute("tpMap", tpMap);
		return mapping.findForward(FORWARD_SUCCESS);
	}
}
