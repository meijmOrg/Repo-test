package com.yh.component.workflow.queryhelper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.CarbonCopyDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.TaskProcessDTO;
import com.yh.component.workflow.dto.WorkFlowKeyWordDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;

/**
 * 
 * @ClassName: WorkFlowTaskProcessQueryHelper 
 * @Description: 流程处理QueryHelper
 * @author: liul
 * @date: 2018-5-28 上午09:19:55
 */
public class WorkFlowTaskProcessQueryHelper {
	
	public static List<TaskProcessDTO> listTaskProcess(TableTagBean ttb) throws ServiceException {
		String fileId = ttb.getCondition().get("fileId");
		fileId = "1";
		StringBuilder hql = new StringBuilder();
		hql.append("select (select actOrder from FlowActivity where actId = tp.actId) as actOrder,tp.taskProcessName ,tp.taskProcessResult,tp.taskProcessExplain");
		hql.append(" from TaskProcess tp where 1=1");
		if(StringUtils.isNotEmpty(fileId)){
			hql.append(" and tp.fileId = '"+fileId+"'");
		}else{
			hql.append(" and 1=2");
		}
		hql.append(" order by tp.taskProcessDoTime");
		List<Object[]> objList = DaoUtil.find(hql.toString());
		List<TaskProcessDTO> tpList = new ArrayList<TaskProcessDTO>();
		if(CollectionUtils.isNotEmpty(objList)){
			for(Object[] obj : objList){
				TaskProcessDTO dto = new TaskProcessDTO();
				dto.setActOrder(obj[0]==null?"":obj[0].toString());
				dto.setTaskProcessName(obj[1]==null?"":obj[1].toString());
				dto.setTaskProcessResult(obj[2]==null?"":obj[2].toString());
				dto.setTaskProcessExplain(obj[3]==null?"":obj[3].toString());
				tpList.add(dto);
			}
		}
		return tpList;
	}

}
