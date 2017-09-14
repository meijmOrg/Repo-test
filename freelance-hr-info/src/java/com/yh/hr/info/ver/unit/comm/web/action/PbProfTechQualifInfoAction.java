﻿/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.info.ver.unit.comm.web.action;

import jade.workflow.utils.ObjectUtil;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.dictionary.utils.DicHelper;
import com.yh.component.taglib.TableTagBean;
import com.yh.hr.info.ver.unit.comm.facade.PbProfTechQualifInfoFacade;
import com.yh.hr.info.ver.unit.comm.web.form.PbProfTechQualifInfoForm;
import com.yh.hr.res.dictionary.DicConstants;
import com.yh.hr.res.pb.dto.PbProfTechQualifInfoDTO;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.NumberUtils;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.util.StringUtil;
import com.yh.platform.core.web.UserContext;
import com.yh.platform.core.web.action.BaseAction;

public class PbProfTechQualifInfoAction extends BaseAction {
	private PbProfTechQualifInfoFacade pbProfTechQualifInfoFacade = (PbProfTechQualifInfoFacade) SpringBeanUtil.getBean("pbProfTechQualifInfoFacade");

	/**
	 * 列出所有 PbProfTechQualifInfo信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listPbProfTechQualifInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TableTagBean ttb = TableTagBean.getFromRequest(request);
		if (request.getMethod().equals("POST")) {
	        @SuppressWarnings("rawtypes")
			Map map = BeanUtils.describe(form);
	        ttb.getCondition().copyFrom(map, true);
	    } else {
	        BeanUtils.populate(form, ttb.getCondition());
	        request.setAttribute("pbProfTechQualifInfoForm", form);
	    }
        try {
	        
	        List<PbProfTechQualifInfoDTO> list = pbProfTechQualifInfoFacade.find(ttb);

            for(PbProfTechQualifInfoDTO dto: list){
            	if(StringUtils.isNotEmpty(dto.getProfTechCode()))
    			{
            		dto.setProfTechCode(DicHelper.viewName(DicConstants.YHRS0117, dto.getProfTechCode()));
    			}
            	if(StringUtils.isNotEmpty(dto.getProfTechLevel()))
    			{
            		dto.setProfTechLevel(DicHelper.viewName(DicConstants.YHRS0047, dto.getProfTechLevel()));
    			}
            	if(dto.getProcureDate()!=null)
    			{
            		dto.setProcureDateStr(DateUtil.format(dto.getProcureDate(), "yyyy-MM-dd"));
    			}
            	if(dto.getValidityDate()!=null)
    			{
            		dto.setValidityDateStr(DateUtil.format(dto.getValidityDate(), "yyyy-MM-dd"));
    			}
            }

			request.setAttribute("list", list);
	        request.setAttribute("ttb", ttb);
        } catch (Exception se) {
			this.handleException(request, se, null);
			return mapping.findForward("fail");
		}
        return mapping.findForward("success");
	}
	
	/**
	 * 查找单个PbProfTechQualifInfo信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String profTechQualifOid = request.getParameter("profTechQualifOid");
        if (StringUtil.isBlank(profTechQualifOid)) {
            profTechQualifOid = ObjectUtil.getValue(request.getAttribute("profTechQualifOid"), String.class);
        }
		try {
            if (StringUtils.isEmpty(profTechQualifOid)) {
				throw new ServiceException("error.pk.invalid", "pbProfTechQualifInfo profTechQualifOid is null");
			}
            PbProfTechQualifInfoDTO pbProfTechQualifInfoDto = pbProfTechQualifInfoFacade.get(ObjectUtil.getValue(profTechQualifOid, java.lang.Long.class));
			if (null == pbProfTechQualifInfoDto) {
				throw new ServiceException(null, "查询不到相关信息");
			}
			PbProfTechQualifInfoForm pbProfTechQualifInfoForm = BeanHelper.copyProperties(pbProfTechQualifInfoDto, PbProfTechQualifInfoForm.class);
			pbProfTechQualifInfoForm.setProcureDateStr(DateUtil.format(pbProfTechQualifInfoForm.getProcureDate(), "yyyy-MM-dd"));
			pbProfTechQualifInfoForm.setValidityDateStr(DateUtil.format(pbProfTechQualifInfoForm.getValidityDate(), "yyyy-MM-dd"));
			
			request.setAttribute("pbProfTechQualifInfoForm", pbProfTechQualifInfoForm);
            request.setAttribute("profTechQualifOid", profTechQualifOid);
		} catch (Exception se) {
			this.handleException(request, se, "profTechQualifOid=" + profTechQualifOid);
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	/**
	 * 跳转到 PbProfTechQualifInfo信息添加页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goCreate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String urlId = request.getParameter("urlId");
		String personOid = request.getParameter("personOid");
		if(StringUtils.isEmpty(urlId))
		{
			throw new ServiceException("urlId is null");
		}
		if(StringUtils.isEmpty(personOid))
		{
			throw new ServiceException("personOid is null");
		}

		request.setAttribute("urlId", urlId);
		request.setAttribute("personOid", personOid);
		
		return mapping.findForward(FORWARD_SUCCESS);
	}

	/**
	 * 添加 PbProfTechQualifInfo信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("cancel");
		}
		PbProfTechQualifInfoForm pbProfTechQualifInfoForm = (PbProfTechQualifInfoForm) form;
		try {
//			if(StringUtils.isEmpty(${fkOid}))
//			{
//				throw new ServiceException("${fkOid} is null");
//			}
			PbProfTechQualifInfoDTO pbProfTechQualifInfoDto = BeanHelper.copyProperties(pbProfTechQualifInfoForm, PbProfTechQualifInfoDTO.class);
//			pbProfTechQualifInfoDto.setPersonOid(NumberUtils.longValue(personOid));
			pbProfTechQualifInfoDto.setCreateBy(UserContext.getLoginUserID());
			pbProfTechQualifInfoDto.setCreateName(UserContext.getLoginUserName());
			pbProfTechQualifInfoDto.setCreateDate(DateUtil.now());
			pbProfTechQualifInfoFacade.create(pbProfTechQualifInfoDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		} catch (Exception se) {
			this.handleException(request, se, null);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "新增失败")).toString());
		}

		return null;
	}


	/**
	 * 跳转到 PbProfTechQualifInfo信息修改（编辑）页面前的查询回显
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward goUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(this.isCancelled(request)) {
			return mapping.findForward("cancel");
		}
		
		String urlId = request.getParameter("urlId");
        String profTechQualifOid = request.getParameter("profTechQualifOid");

		try {
			if(StringUtils.isEmpty(urlId))
			{
				throw new ServiceException(null, "urlId is null");
			}
            if (StringUtils.isBlank(profTechQualifOid)) {
				throw new ServiceException("error.pk.invalid", "pbProfTechQualifInfo profTechQualifOid is null");
			}
            
            PbProfTechQualifInfoDTO pbProfTechQualifInfoDto = pbProfTechQualifInfoFacade.get(ObjectUtil.getValue(profTechQualifOid, java.lang.Long.class));
			if (null == pbProfTechQualifInfoDto) {
				throw new ServiceException("error.object.notfound", "pbProfTechQualifInfo not found by profTechQualifOid");
			}
			
			PbProfTechQualifInfoForm pbProfTechQualifInfoForm = BeanHelper.copyProperties(pbProfTechQualifInfoDto, PbProfTechQualifInfoForm.class);
			pbProfTechQualifInfoForm.setProcureDateStr(DateUtil.format(pbProfTechQualifInfoForm.getProcureDate(), "yyyy-MM-dd"));
			pbProfTechQualifInfoForm.setValidityDateStr(DateUtil.format(pbProfTechQualifInfoForm.getValidityDate(), "yyyy-MM-dd"));
			
			request.setAttribute("urlId", urlId);
			request.setAttribute("pbProfTechQualifInfoForm", pbProfTechQualifInfoForm);
            request.setAttribute("profTechQualifOid", profTechQualifOid);
		} catch (Exception se) {
			this.handleException(request, se, "profTechQualifOid=" + profTechQualifOid);
			return mapping.getInputForward();
		}
		return goUpdateView(mapping, form, request, response);
	}

	/**
	 * 跳转到 PbProfTechQualifInfo信息修改（编辑）页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    public ActionForward goUpdateView(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //add jsp init values
        @SuppressWarnings("unused")
		PbProfTechQualifInfoForm pbProfTechQualifInfoForm = (PbProfTechQualifInfoForm) form;
        return mapping.findForward("success");
    }

	/**
	 * 更新 PbProfTechQualifInfo信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(this.isCancelled(request)) {
			return mapping.findForward("cancel");
		}
        String profTechQualifOid = request.getParameter("profTechQualifOid");
		PbProfTechQualifInfoForm pbProfTechQualifInfoForm = (PbProfTechQualifInfoForm) form;
		try {
            if (StringUtils.isBlank(profTechQualifOid)) {
				throw new ServiceException("error.pk.invalid", "pbProfTechQualifInfo profTechQualifOid is null");
			}
            
            PbProfTechQualifInfoDTO pbProfTechQualifInfoDto = pbProfTechQualifInfoFacade.get(NumberUtils.longValue(profTechQualifOid));
			if(null == pbProfTechQualifInfoDto)
			{
				throw new ServiceException(null, "查询不到相关信息");
			}
			
			BeanHelper.copyProperties(pbProfTechQualifInfoForm, pbProfTechQualifInfoDto);
//			pbProfTechQualifInfoDto.setProfTechName(DicHelper.viewName(DicConstants.YHRS0117, pbProfTechQualifInfoForm.getProfTechCode()));
//			pbProfTechQualifInfoDto.setProfTechLevelName(DicHelper.viewName(DicConstants.YHRS0047, pbProfTechQualifInfoForm.getProfTechLevelName()));
			pbProfTechQualifInfoDto.setUpdateBy(UserContext.getLoginUserID());
			pbProfTechQualifInfoDto.setUpdateName(UserContext.getLoginUserName());
			pbProfTechQualifInfoDto.setUpdateDate(DateUtil.now());
			pbProfTechQualifInfoFacade.update(pbProfTechQualifInfoDto);
			response.getWriter().write(JSONHelper.fromObject(true, null).toString());
		} catch (Exception se) {
			this.handleException(request, se, pbProfTechQualifInfoForm);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "修改失败")).toString());
		}

		return null;
	}



	/**
	 * 删除 PbProfTechQualifInfo信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
           String profTechQualifOid = request.getParameter("profTechQualifOid");
        try {
            if(StringUtils.isEmpty(profTechQualifOid))
			{
				throw new ServiceException(null, "profTechQualifOid is null");
			}
            pbProfTechQualifInfoFacade.delete(ObjectUtil.getValue(profTechQualifOid, java.lang.Long.class));
            response.getWriter().write(JSONHelper.fromObject(true, null).toString());
        } catch (Exception se) {
            this.handleException(request, se, "profTechQualifOid=" + profTechQualifOid);
			response.getWriter().write(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(se.getMessage(), "删除失败")).toString());
        }
        return null;
    }
    
    /**
     * 唯一验证
     * @param pbEducationLevelDegreeForm
     * @throws ServiceException
     * @throws Exception 
     */
	public ActionForward uniqueCheck(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//获取人员id,学历证书号,学位证书号
		String certificateNo = request.getParameter("certificateNo");
		if(!StringUtil.isBlank(certificateNo)){
			certificateNo = certificateNo.trim();
		}
		String isHighestLevel = request.getParameter("isHighestLevel");
		if(!StringUtil.isBlank(isHighestLevel)){
			isHighestLevel = isHighestLevel.trim();
		}
		String personOid = request.getParameter("personOid");
		String profTechQualifOid = request.getParameter("profTechQualifOid");
		
		String flag = "true";
		
		//根据人员id,获取该人员所有的学历学位信息
		List<PbProfTechQualifInfoDTO> list = pbProfTechQualifInfoFacade.listProfTechQualifInfoByPersonOid(NumberUtils.longValue(personOid));

		for(PbProfTechQualifInfoDTO dto: list){
			if(!dto.getProfTechQualifOid().toString().equals(profTechQualifOid)){//修改时,跳过当前专业技术资格信息
				//判断资格证书编号是否重复
				if(!StringUtil.isBlank(certificateNo))
				{
					//如果资格证书编号号不为空
					if(certificateNo.equals(dto.getCertificateNo())){
						flag = "false";
					}
				}
				
				//判断是否是主要专业技术资格
				if(!StringUtil.isBlank(isHighestLevel))
				{
					if(!isHighestLevel.equals(DicConstants.YHRS0003_0)){//如果为0否,就跳过
						//如果不是是主要专业技术资格
						if(isHighestLevel.equals(dto.getIsHighestLevel())){
							flag = "false";
						}
					}
				}
			}
		}
		response.getWriter().write(flag);
		return null;
    }
}