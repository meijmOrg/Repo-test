package com.yh.hr.info.projectinitialize.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.info.projectinitialize.bo.ProjectInitialize;
import com.yh.hr.info.projectinitialize.dto.ProjectInitializeDTO;
import com.yh.hr.info.projectinitialize.queryhelper.ProjectInitializeQueryHelper;
import com.yh.hr.info.projectinitialize.service.ProjectInitializeService;
import com.yh.hr.orghc.ub.bo.UbUnit;
import com.yh.hr.orghc.ub.dto.UbUnitDTO;
import com.yh.hr.orghc.ub.service.impl.UbUnitServiceImpl;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.DESUtils;
import com.yh.platform.core.util.SpringBeanUtil;

/**
 * @description 项目初始化ServiceImpl
 * @author meijm
 * @created 2017-9-19
 * @version 1.0
 */
public class ProjectInitializeServiceImpl implements ProjectInitializeService {
	
	private UbUnitServiceImpl ubUnitService	= (UbUnitServiceImpl) SpringBeanUtil.getBean("ubUnitService");

	/**
     * 获取客户信息
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public List<ProjectInitializeDTO> listCustomerInfo(TableTagBean ttb) throws ServiceException{
		return ProjectInitializeQueryHelper.listCustomerInfo(ttb);
	}
	
	/**
     * 根据customerOid获取客户信息
     * @param ttb
     * @return
     * @throws ServiceException
     */
	public ProjectInitializeDTO get(String customerOid) throws ServiceException{
		ProjectInitialize bo = DaoUtil.get(ProjectInitialize.class, Long.valueOf(customerOid));
		ProjectInitializeDTO dto = new ProjectInitializeDTO();
		BeanHelper.copyProperties(bo, dto);
		return dto;
	}
	
	/**
     * 新增客户信息
     * @param dto
     * @return
     * @throws ServiceException
     */
	public void create(ProjectInitializeDTO dto) throws ServiceException{
		ProjectInitialize bo = new ProjectInitialize();
		BeanHelper.copyProperties(dto, bo);
		bo.save();
		
		//如果是启动状态，则解密License码初始化单位信息
		if("1".equals(bo.getStartStatus())){
			try {
				//用默认的key解密
				String licenseStr = DESUtils.decrypt(bo.getLicenseCode());
				String unitName = "";
				if(StringUtils.isNotEmpty(licenseStr)&&licenseStr.length()>8){
					unitName = licenseStr.substring(0, licenseStr.length()-8);
				}
				UbUnitDTO ubUnitDTO = new UbUnitDTO();
				ubUnitDTO.setUnitName(unitName);
				ubUnitService.create(ubUnitDTO);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
     * 修改客户信息
     * @param dto
     * @return
     * @throws ServiceException
     */
	public void update(ProjectInitializeDTO dto) throws ServiceException {
		ProjectInitialize bo = DaoUtil.get(ProjectInitialize.class, dto.getCustomerOid());
		BeanHelper.copyProperties(dto,bo);
		bo.setLicenseCode(dto.getNewLicenseCode());
		bo.update();
		
		//如果是启动状态，则解密新License码初始化单位信息
		if("1".equals(bo.getStartStatus())){
			try {
				//用默认的key解密
				String licenseStr = DESUtils.decrypt(bo.getLicenseCode());
				String oldLicenseStr = DESUtils.decrypt(dto.getLicenseCode());
				String unitName = "";
				String oldUnitName = "";
				if(StringUtils.isNotEmpty(licenseStr)&&licenseStr.length()>8){
					unitName = licenseStr.substring(0, licenseStr.length()-8);
				}
				if(StringUtils.isNotEmpty(oldLicenseStr)&&oldLicenseStr.length()>8){
					oldUnitName = oldLicenseStr.substring(0, oldLicenseStr.length()-8);
				}
				//更新单位名称
				UbUnitDTO ubUnitDTO = new UbUnitDTO();
				//根据之前写进去的单位名称查找单位信息
				UbUnit ubUnit = ProjectInitializeQueryHelper.getUbUnit(oldUnitName);
				if(null == ubUnit){//如果查不到  说明人为的改了单位名称
					//如果根据单位名称查不到，直接查单位表取单位信息
					ubUnit = ProjectInitializeQueryHelper.getUbUnit(); 
				}
				if(null != ubUnit){
					BeanHelper.copyProperties(ubUnit,ubUnitDTO);
					ubUnitDTO.setUnitName(unitName);
					ubUnitService.update(ubUnitDTO);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
