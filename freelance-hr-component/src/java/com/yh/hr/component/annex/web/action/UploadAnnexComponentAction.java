package com.yh.hr.component.annex.web.action;




import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.hr.component.annex.facade.UploadAnnexComponentFacade;
import com.yh.hr.component.annex.utils.UploadAnnexComponentUtil;
import com.yh.platform.core.util.ConfigUtil;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.IOUtil;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.SpringBeanUtil;
import com.yh.platform.core.util.StringUtil;
import com.yh.platform.core.web.action.BaseAction;


/**
 * 
 *@description       上传文件管理器
 *@author            liul
 *@created           2018-05-8
 *@version           1.0
 *
 */
public class UploadAnnexComponentAction extends BaseAction
{
	UploadAnnexComponentFacade uploadAnnexComponentFacade = (UploadAnnexComponentFacade) SpringBeanUtil.getBean("uploadAnnexComponentFacade");
	private static String UPLOAD_URL = "file.path.annex";
	/**
     * 得到文件路径
     *
     * @param bizType
     * @param uploadCreateDate
     * @return
     */
    static String getFilePath( Date uploadCreateDate) {
        String dateStr = DateUtil.format(uploadCreateDate, DateUtil.DATA_PATTERN_YYYYMMDD);
        String year = dateStr.substring(0, 4);
        String month = dateStr.substring(4, 6);
        StringBuffer path = new StringBuffer(ConfigUtil.getProperty(UPLOAD_URL)); //文件上传默认路径
        // 文件上传默认路径/业务类别名/文件上传年/文件上传月/文件
        path.append("/").append(year).append("/").append(month);
        return path.toString();
    }
    /*public ActionForward listAnnexFile(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			TableTagBean ttb = new TableTagBean(request);
			
//			String refRoleCode = request.getParameter("refRoleCode");//当前角色
			String viewRefCodes = StringUtil.joinWrap(StringUtils.split(request.getParameter("viewRefCodes"),","));//查看的来源，如果为空，表示查看所有来源
			
			ttb.getCondition().put("viewRefCodes", viewRefCodes);
			
			List<JSONObject> list = uploadAnnexComponentFacade.listAnnexFile(ttb);
			
			JSONObject json = new JSONObject();
			json.put("total", ttb.getTotal());
			json.put("rows", null!=list?list:new ArrayList<Object>());
			response.getWriter().print(json.toString());
		} catch (Exception e) {
			handleException(request, e, "查询文件列表失败");
			response.getWriter().print(JSONHelper.fromObject(false, StringUtils.defaultIfEmpty(e.getMessage(), "查询文件列表失败")));
		}
		
		return null;
	}*/
    /**
	 * 下载上传文件
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward downAnnexFile(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String faId = request.getParameter("faId");
			FileAnnexDTO dto = uploadAnnexComponentFacade.get(faId);
			File file = null;
			if (dto != null && (file = new File(dto.getFaPath())).exists()) {
				IOUtil.writeResponse(response, file, "application/octet-stream", dto.getFaName());
				return null;
			}
			
			response.getWriter().print("<center style='margin-top:50px;'>您打开的文件不存在!</center>");
			
		} catch (Exception e) {
			handleException(request, e, "文件下载失败");
			
			response.getWriter().print("<center style='margin-top:50px;'文件下载失败!</center>");
		}
		
		return null;
	}
	
	public ActionForward deleteAnnexFile(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			String faId = request.getParameter("faId");
			
			uploadAnnexComponentFacade.delete(faId);
			
			response.getWriter().print(JSONHelper.fromObject(true, "删除成功！"));
		} catch (Exception e) {
			handleException(request, e, "跳转文件上传页面失败");
			response.getWriter().print(JSONHelper.fromObject(false, "删除失败！"));
		}
		return null;
	}
	public ActionForward checkAnnexFileName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			String fileName = request.getParameter("fileName");
			String path = UploadAnnexComponentUtil.getFilePath(DateUtil.now());
			
			Boolean isExist = uploadAnnexComponentFacade.checkFileName(path+"/"+fileName);
			if(isExist){
				response.getWriter().print(JSONHelper.fromObject(true, "已存在名为 "+fileName+" 的文件,请重新选择！"));
			}else{
				response.getWriter().print(JSONHelper.fromObject(false, "不存在！"));
			}
		} catch (Exception e) { 
			handleException(request, e, "跳转文件上传页面失败");
			response.getWriter().print(JSONHelper.fromObject(true, "检查文件失败,请刷新重试！"));
		}
		return null;
	}
}
