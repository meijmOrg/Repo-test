<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<%@page import="com.yh.admin.imageinstall.dto.ImageInstallDTO"%>
<%@page import="com.yh.admin.imageinstall.facade.ImageInstallFacade"%>
<%@page import="com.yh.platform.core.util.SpringBeanUtil"%>
<%@page import="com.yh.platform.core.util.ConfigUtil"%>
<%@page import="java.io.*"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.yh.platform.core.util.NumberUtils" %>
<%
	response.reset();
	try
	{
		ImageInstallFacade imageInstallFacade = (ImageInstallFacade) SpringBeanUtil.getBean("imageInstallFacade");
		String systemCode=request.getParameter("systemCode");
		String flag=request.getParameter("flag");

		byte[] bs= null;
		byte[] lgbs= null;
		byte[] banbs= null;
		ImageInstallDTO imageInstallDTO = null;
		if(systemCode!=null&&systemCode.length()>0)
		{
			imageInstallDTO = imageInstallFacade.get(systemCode);
			if(imageInstallDTO!=null)
			{
				lgbs=imageInstallDTO.getLogoPhotoPathB();
				banbs=imageInstallDTO.getBannerPhotoPathB();
				if("logo".equals(flag)){
					bs = lgbs;
				}else if("banner".equals(flag)){
					bs = banbs;
				}
			}
		}
		
		if(imageInstallDTO==null || imageInstallDTO.getLogoPhotoPathB().length < 100||imageInstallDTO.getBannerPhotoPathB().length < 100)
		{			
			File file = new File(ConfigUtil.getProperty("file.path.affiche")+"photo.jpg");
			//File file = new File(getServletContext().getRealPath("/")+"photo.jpg");
			InputStream ip = new FileInputStream(file);
			
			bs = new byte[(int)file.length()];
			ip.read(bs,0,bs.length);					
	
		}
		
		if(bs!=null && bs.length>0)
		{
			if(imageInstallDTO == null)
				response.setContentType("image/jpg"); 
			else
				if(imageInstallDTO.getLogoPhotoPathB().length < 100||imageInstallDTO.getBannerPhotoPathB().length < 100) {
					response.setContentType("image/jpg"); 
				} 
				else {	
					if("logo".equals(flag)){
						response.setContentType("image/"+imageInstallDTO.getLogoPhotoType());
					}else if("banner".equals(flag)){
						response.setContentType("image/"+imageInstallDTO.getBannerPhotoType());
					}else{
						response.setContentType("image/jpg");
					}
				}
				
			ServletOutputStream outs = response.getOutputStream();
			outs.write(bs);
			outs.flush();
			outs.close();
			
			out.clear();   
			out = pageContext.pushBody(); 
		
		}
	}
	catch(RuntimeException  e)
	{
		//e.printStackTrace();
		Logger log = Logger.getLogger("web");
		log.error("Image show error!",e);
	}
%>
