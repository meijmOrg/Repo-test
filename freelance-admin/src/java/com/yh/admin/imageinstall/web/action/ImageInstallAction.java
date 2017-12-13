package com.yh.admin.imageinstall.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.admin.imageinstall.dto.ImageInstallDTO;
import com.yh.admin.imageinstall.facade.ImageInstallFacade;
import com.yh.admin.imageinstall.web.form.ImageInstallForm;
import com.yh.admin.sao.unit.dto.SaoAdminUnitDTO;
import com.yh.admin.users.facade.UsersFacade;
import com.yh.component.taglib.TableTagBean;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.web.UserContext;
import com.yh.platform.core.web.action.BaseAction;

/**
 * @description 系统外观设置action
 * @author meijm
 * @created 2017-9-16
 * @version 1.0
 */
public class ImageInstallAction extends BaseAction {

	private ImageInstallFacade imageInstallFacade	= (ImageInstallFacade) SpringBeanUtil.getBean("imageInstallFacade");
	private UsersFacade usersFacade = (UsersFacade) SpringBeanUtil.getBean("usersFacade");
	
	/**
	 * 跳转到系统外观设置页面(logo、banner)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goImageInstall(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			TableTagBean ttb = new TableTagBean();
			ttb.setPageSize(0);
			//获取主管单位信息
			List<SaoAdminUnitDTO> adminUnits=usersFacade.findUsersUnitList(ttb);
			if(CollectionUtils.isNotEmpty(adminUnits)){
				request.setAttribute("adminUnit", adminUnits.get(0));
			}
		} catch (Exception e) {
			handleException(request, e, null);
		}
		return mapping.findForward("success");
	}
	
	/**
	 * 修改系统登录界面外观
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateImageInstall(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ImageInstallForm imageInstallForm = (ImageInstallForm) form;
		String flag = request.getParameter("flag");
		try {
			String systemCode = "";
			HttpSession session = request.getSession();//拿到当前session
			if(session.getAttribute(UserContext.WEB_KEY_SYSTEMID)!=null||session.getAttribute(UserContext.WEB_KEY_SYSTEMID)!=""){
				systemCode = session.getAttribute(UserContext.WEB_KEY_SYSTEMID).toString();//拿到session中存的系统id
			}
			ImageInstallDTO imageInstallDTO = new ImageInstallDTO();
			BeanHelper.copyProperties(imageInstallForm, imageInstallDTO);
			imageInstallDTO.setSubSystemCode(systemCode);
			imageInstallDTO.setFlag(flag);
			imageInstallFacade.update(imageInstallDTO);
			response.getWriter().write(JSONHelper.fromObject(true, "上传成功！").toString());
		} catch (Exception se) {
			this.handleException(request, se, imageInstallForm);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "修改失败")).toString());
		}
		return null;
	}
	
}
