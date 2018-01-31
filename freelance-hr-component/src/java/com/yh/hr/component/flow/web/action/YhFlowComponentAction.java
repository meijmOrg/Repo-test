package com.yh.hr.component.flow.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.hr.component.flow.facade.YhFlowComponentFacade;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.action.BaseAction;

/**
 * @description 处理意见组件action
 * @author meijm
 * @created 2018-1-18
 * @version 1.0
 */
public class YhFlowComponentAction extends BaseAction {
	YhFlowComponentFacade yhFlowComponentFacade = (YhFlowComponentFacade) SpringBeanUtil.getBean("yhFlowComponentFacade");

	/**
	 * 提交流程(用户弹框)
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
			String templateId = request.getParameter("templateId");
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
	
}
