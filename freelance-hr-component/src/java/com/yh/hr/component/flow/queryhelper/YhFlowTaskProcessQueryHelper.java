package com.yh.hr.component.flow.queryhelper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.TaskProcessDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;

/**
 * 
 * @ClassName: YhFlowTaskProcessQueryHelper 
 * @Description: 流程处理QueryHelper
 * @author: liul
 * @date: 2018-5-28 上午09:19:55
 */
public class YhFlowTaskProcessQueryHelper {
	
	public static List<TaskProcessDTO> listTaskProcess(TableTagBean ttb) throws ServiceException {
		String fileId = ttb.getCondition().get("fileId");
		fileId = "1";
		StringBuilder hql = new StringBuilder();
		hql.append("select (select actOrder from FlowActivity where actId = tp.actId) as actOrder,tp.taskProcessName ,tp.taskProcessResult,tp.taskProcessExplain");
		hql.append(",tp.fileId,tp.taskProcessUser");
		hql.append(",(select COUNT(*) from FileAnnex fa where fa.fileId = tp.fileId and fa.faUserName = tp.taskProcessUser) as haveAnnex,"); //是否存在附件
		hql.append("(select COUNT(*) from CoordinationProcess cp where cp.cpEntityId = tp.fileId and cp.cpSendUser = tp.taskProcessUser) as haveCoordination"); //是否存在协同记录
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
				dto.setFileId(obj[4]==null?"":obj[4].toString());
				dto.setTaskProcessUser(obj[5]==null?"":obj[5].toString());
				dto.setHaveAnnex(Integer.valueOf(obj[6].toString())==0?"":obj[6].toString());
				dto.setHaveCoordination(Integer.valueOf(obj[7].toString())==0?"":obj[7].toString());
				
				tpList.add(dto);
			}
		}
		return tpList;
	}

}
