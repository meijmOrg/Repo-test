/**
 * @desctiption   This file is generated by  code generation tool version 0.2 ^_^
 * @Created   2017-02-10
**/
package com.yh.hr.res.pb.service.impl;

import java.util.List;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.pb.bo.PbEducationLevelDegree;
import com.yh.hr.res.pb.dto.PbEducationLevelDegreeDTO;
import com.yh.hr.res.pb.queryhelper.PbEducationLevelDegreeQueryHelper;
import com.yh.hr.res.pb.service.PbEducationLevelDegreeService;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;

public class PbEducationLevelDegreeServiceImpl implements PbEducationLevelDegreeService{
	public void create(PbEducationLevelDegreeDTO pbEducationLevelDegreeDto) throws ServiceException {
		PbEducationLevelDegree pbEducationLevelDegree = new PbEducationLevelDegree();
		BeanHelper.copyProperties(pbEducationLevelDegreeDto, pbEducationLevelDegree);
        pbEducationLevelDegree.save();
     // TODO 成功新增学历学位信息后,同步学历学位信息到人员附属表
        PersonAttachInfoServiceUtil.sysPbEducationLevelDegreeInfo(pbEducationLevelDegree.getPersonOid());
	}

	public PbEducationLevelDegreeDTO get(java.lang.Long pbEducationLevelDegreeId) throws ServiceException {
        return BeanHelper.copyProperties(DaoUtil.get(PbEducationLevelDegree.class, pbEducationLevelDegreeId),PbEducationLevelDegreeDTO.class);
	}
    
	public void update(PbEducationLevelDegreeDTO pbEducationLevelDegreeDto) throws ServiceException {

		PbEducationLevelDegree pbEducationLevelDegree = new PbEducationLevelDegree();
		BeanHelper.copyProperties(pbEducationLevelDegreeDto, pbEducationLevelDegree);
		pbEducationLevelDegree.update();
		// TODO 成功修改学历学位信息后,同步学历学位信息到人员附属表
        PersonAttachInfoServiceUtil.sysPbEducationLevelDegreeInfo(pbEducationLevelDegree.getPersonOid());

	}
    
	public void delete(java.lang.Long pbEducationLevelDegreeId) throws ServiceException {
		PbEducationLevelDegree bo = DaoUtil.get(PbEducationLevelDegree.class, pbEducationLevelDegreeId);
		Long personOid = bo.getPersonOid();
		bo.delete();
		// TODO 删除学历学位信息后,同步学历学位信息到人员附属表
        PersonAttachInfoServiceUtil.sysPbEducationLevelDegreeInfo(personOid);

	}
    
	public List<PbEducationLevelDegreeDTO> find(TableTagBean ttb) throws ServiceException {
        return PbEducationLevelDegreeQueryHelper.find(ttb);
	}

	public List<PbEducationLevelDegreeDTO> listPbEducationLevelDegreeByPersonOid(Long personOid) throws ServiceException {
		return PbEducationLevelDegreeQueryHelper.listPbEducationLevelDegreeByPersonOid(personOid);
	}

	public void deleteByPersonOid(Long personOid) throws ServiceException {
		PbEducationLevelDegreeQueryHelper.deleteByPersonOid(personOid);
	}

}