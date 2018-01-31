package com.yh.hr.component.flow.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yh.component.workflow.bo.FlowActivity;
import com.yh.component.workflow.bo.FlowRule;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.hr.component.flow.queryhelper.YhFlowComponentQueryHelper;
import com.yh.hr.component.flow.service.YhFlowComponentService;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
/**
 * @description 流程组件ServiceImpl
 * @author meijm
 * @created 2018-1-18
 * @version 1.0
 */
public class YhFlowComponentServiceImpl implements  YhFlowComponentService
{
	/*
	 * (non-Javadoc)
	 * @see YhFlowProcessingOpinionService#goUserListPartial(String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, List<WorkflowActivityDTO>> goUserListPartial(String templateId) throws ServiceException
	{
		//获取流程信息
		WorkflowBaseInfoDTO wdto = YhFlowComponentQueryHelper.getYhFlowByTemplateId(templateId);
		if(null == wdto){
			return null;
		}
		//获取活动单元信息(权限控制、任务通知)
		List<WorkflowActivityDTO> allActivityDTOList = YhFlowComponentQueryHelper.getFlowActivityByFlowId(wdto.getFlowId());
		if(null == allActivityDTOList){
			return null;
		}
		//新建任务默认当前活动单元为第一步如：经办人 
		WorkflowActivityDTO currentActivityDTO = allActivityDTOList.get(0);
		String[] actEndRuleIds = currentActivityDTO.getActEndRuleId().split(",");//后置规则id数组
		List<WorkflowActivityDTO> nexActivityDTOList = new ArrayList<WorkflowActivityDTO>();//下一步活动单元集合
		if(actEndRuleIds.length > 0){
			for(String actEndRuleId : actEndRuleIds){
				FlowRule bo = DaoUtil.get(FlowRule.class, actEndRuleId);
				Boolean result = this.checkRuleCondition(bo);
				if(!result){
					continue;
				}
				WorkflowActivityDTO dto = new WorkflowActivityDTO();
				FlowActivity fabo = DaoUtil.get(FlowActivity.class, bo.getRuleEndActId());
				BeanHelper.copyProperties(fabo, dto);
				dto.setApList(YhFlowComponentQueryHelper.getActivityPermissionByActId(bo.getRuleEndActId()));
				dto.setAnList(YhFlowComponentQueryHelper.getActivityNoticeByActId(bo.getRuleEndActId()));
				nexActivityDTOList.add(dto);
			}
		}
		Map map = new HashMap<String, List<WorkflowActivityDTO>>();
		map.put("allActivityDTOList", allActivityDTOList);
		map.put("nexActivityDTOList", nexActivityDTOList);
		return map;
	}
	
	/**
	 * 检查流程规则的构造转移条件
	 * @param FlowRule
	 * @return true:符合 false:不符合
	 * @throws ServiceException
	 */
	private Boolean checkRuleCondition(FlowRule bo) throws ServiceException{
		return false;
	}
}
