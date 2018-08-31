package com.yh.hr.biz.vacation.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.alibaba.fastjson.JSON;
import com.yh.component.taglib.TableTagBean;
import com.yh.hr.biz.vacation.dto.YhfVacationDTO;
import com.yh.hr.biz.vacation.facade.BizVacationFacade;
import com.yh.hr.biz.vacation.web.form.YhfVacationForm;
import com.yh.hr.component.flow.web.form.YhFlowComponentForm;
import com.yh.hr.res.dictionary.DicConstants;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;

/**
 * @description 请休假业务action
 * @author meijm
 * @created 2018-6-9
 * @version 1.0
 */
public class BizVacationAction extends BaseAction {
	private BizVacationFacade bizVacationFacade = (BizVacationFacade) SpringBeanUtil.getBean("bizVacationFacade");
	/**
	 * 跳转到请休假业务工作台	
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goBizVacationWorkTop(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 
	* @Description: 获取请休假发起业务记录列表 
	* @param mapping
	* @param form
	* @param request
	* @param response
	* @return
	* @throws Exception ActionForward
	 */
	public ActionForward listVacationInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		try {
			TableTagBean ttb = new TableTagBean();
			List<JSONObject> list = bizVacationFacade.listVacationInfo(ttb);
			JSONObject obj = new JSONObject();
			obj.put("total", ttb.getTotal());
			obj.put("rows", list);
			response.getWriter().print(obj.toString());
			return null;
		} catch (Exception e) {
			handleException(request, e, "加载请休假业务列表出错!");
			response.getWriter().print("{'fail':'fail','msg':'" + (GenericValidator.isBlankOrNull(e.getMessage())?"加载请休假业务列表出错!":e.getMessage()) + "'}");
			return null;
		}
	}
	
	/**
	 * 跳转到请休假流程发起页面	
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goVacationFlowStartPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	/**
	 * 创建请休假业务	
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createVacationInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
		String postDataStr = request.getParameter("postData");//业务表单数据
		try {
			YhfVacationForm yhfVacationForm = null;
			if(StringUtils.isNotEmpty(postDataStr)){
				//把拿到的json字符串转成 json对象
				JSONObject jsonObject=JSONObject.fromObject(postDataStr);
				yhfVacationForm=(YhfVacationForm)JSONObject.toBean(jsonObject, YhfVacationForm.class);
			}
			YhfVacationDTO dto = new YhfVacationDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			if(null != yhfVacationForm){
				//具体业务信息拷贝
				dto.setBeginTime(yhfVacationForm.getBeginTime());
				dto.setBeginTimeStr(yhfVacationForm.getBeginTimeStr());
				dto.setEndTime(yhfVacationForm.getEndTime());
				dto.setEndTimeStr(yhfVacationForm.getEndTimeStr());
				dto.setReason(yhfVacationForm.getReason());
				dto.setTaskProcessExplain(yhfVacationForm.getTaskProcessExplain());
			}
			dto.setTemplateId("68785b4b-e1cd-43dc-877a-79ef103d1c95");
			//和创建bean有关  每个类型的业务标识不同
			dto.setTaskFlag(yhFlowComponentForm.getTemplateCode());
			dto.setFileFlowStatus(DicConstants.YHRS4008_1);//审批中
			bizVacationFacade.submitFlowStart(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "提交成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "提交失败！")));
		}
		return null;
	}
	
	/**
	 * 请休假业务加签	
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createVacationInfoSigh(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		YhFlowComponentForm yhFlowComponentForm = (YhFlowComponentForm) form;
		String postDataStr = request.getParameter("postData");//业务表单数据
		try {
			YhfVacationForm yhfVacationForm = null;
			if(StringUtils.isNotEmpty(postDataStr)){
				//把拿到的json字符串转成 json对象
				JSONObject jsonObject=JSONObject.fromObject(postDataStr);
				yhfVacationForm=(YhfVacationForm)JSONObject.toBean(jsonObject, YhfVacationForm.class);
			}
			YhfVacationDTO dto = new YhfVacationDTO();
			BeanHelper.copyProperties(yhFlowComponentForm, dto);
			if(null != yhfVacationForm){
				//具体业务信息拷贝
				dto.setBeginTime(yhfVacationForm.getBeginTime());
				dto.setBeginTimeStr(yhfVacationForm.getBeginTimeStr());
				dto.setEndTime(yhfVacationForm.getEndTime());
				dto.setEndTimeStr(yhfVacationForm.getEndTimeStr());
				dto.setReason(yhfVacationForm.getReason());
				dto.setTaskProcessExplain(yhfVacationForm.getTaskProcessExplain());
			}
			dto.setTemplateId("68785b4b-e1cd-43dc-877a-79ef103d1c95");
			//和创建bean有关  每个类型的业务标识不同
			dto.setTaskFlag(yhFlowComponentForm.getTemplateCode());
			dto.setFileFlowStatus(DicConstants.YHRS4008_5);//加签中
			bizVacationFacade.submitSighUsers(dto);
			response.getWriter().print(JSONHelper.fromObject(true, "提交成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "提交失败！")));
		}
		return null;
	}
	
	/**
	 * 请休假表单暂存或历史数据保存	
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveVacationInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String flag = request.getParameter("flag");
		try {
			YhfVacationForm yhfVacationForm = (YhfVacationForm) form;
			YhfVacationDTO dto = new YhfVacationDTO();
			BeanHelper.copyProperties(yhfVacationForm, dto);
			dto.setTemplateId("68785b4b-e1cd-43dc-877a-79ef103d1c95");
			//和创建bean有关  每个类型的业务标识不同
			dto.setTaskFlag(yhfVacationForm.getTemplateCode());
			if("zc".equals(flag)){
				dto.setFileFlowStatus(DicConstants.YHRS4008_0);//未启动
				bizVacationFacade.saveVacationInfo(dto);
			}else if("ls".equals(flag)){
				dto.setFileFlowStatus(DicConstants.YHRS4008_6);//历史数据
				bizVacationFacade.saveHisVacationInfo(dto);
			}else{
				throw new Exception("flag is null");
			}
			response.getWriter().print(JSONHelper.fromObject(true, "保存成功！"));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "保存失败！")));
		}
		return null;
	}
	
	/**
	 * 获取请休假表单数据	
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getVacationInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String vacationId = request.getParameter("fileId");
		try {
			if(StringUtils.isEmpty(vacationId)){
				throw new Exception("vacationId is null");
			}
			YhfVacationDTO dto = bizVacationFacade.getVacationInfo(vacationId);
			JSONObject obj = JSONHelper.fromObject(dto, DateUtil.DATE_PATTERN_DEFAULT);
			response.getWriter().print(JSONHelper.fromObject(true, obj.toString()));
		} catch (Exception e) {
			this.handleException(request, e, null);
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "保存失败！")));
		}
		return null;
	}
	
}