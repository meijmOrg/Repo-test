package com.yh.hr.component.flow.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.yh.admin.dto.RolesDTO;
import com.yh.admin.roles.queryhelper.RolesQueryHelper;
import com.yh.admin.util.AuthConstants;
import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.FlowActivity;
import com.yh.component.workflow.bo.FlowRule;
import com.yh.component.workflow.dto.CarbonCopyDTO;
import com.yh.component.workflow.dto.FlowActivityPermissionDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.TaskProcessDTO;
import com.yh.component.workflow.dto.WorkFlowKeyWordDTO;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.queryhelper.WorkFlowCarbonCopyQueryHelper;
import com.yh.component.workflow.queryhelper.WorkFlowKeyWordQueryHelper;
import com.yh.hr.component.flow.queryhelper.YhFlowComponentQueryHelper;
import com.yh.hr.component.flow.queryhelper.YhFlowTaskProcessQueryHelper;
import com.yh.hr.component.flow.service.YhFlowComponentService;
import com.yh.hr.component.orgtree.queryhelper.JhcOrgTreeQueryHelper;
import com.yh.hr.res.unit.dto.UtOrgDTO;
import com.yh.hr.res.unit.dto.WorkGroupDTO;
import com.yh.hr.res.unit.queryhelper.WorkGroupQueryHelper;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
/**
 * @description 流程启动组件ServiceImpl
 * @author meijm
 * @created 2018-1-18
 * @version 1.0
 */
public class YhFlowComponentServiceImpl implements  YhFlowComponentService
{
	/*
	 * (non-Javadoc)
	 * @see YhFlowComponentService#goUserListPartial(String)
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
		List<WorkflowActivityDTO> allActivityDTOListTemp = YhFlowComponentQueryHelper.getFlowActivityByFlowId(wdto.getFlowId());
		if(null == allActivityDTOListTemp){
			return null;
		}
		List<WorkflowActivityDTO> allActivityDTOList = new ArrayList<WorkflowActivityDTO>();//所有活动单元集合
		for(WorkflowActivityDTO alldto : allActivityDTOListTemp){
			alldto.setPuList(this.listPermissionUsers(alldto.getActId()));
			allActivityDTOList.add(alldto);
		}
		//新建任务默认当前活动单元为第一步如：经办人 
		WorkflowActivityDTO currentActivityDTO = allActivityDTOListTemp.get(0);
		String[] actEndRuleIds = currentActivityDTO.getActEndRuleId().split(",");//后置规则id数组
		List<WorkflowActivityDTO> nextActivityDTOList = new ArrayList<WorkflowActivityDTO>();//下一步活动单元集合
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
				dto.setActOrderStr(fabo.getActOrder()+".");
				dto.setApList(YhFlowComponentQueryHelper.getActivityPermissionByActId(bo.getRuleEndActId()));
				dto.setAnList(YhFlowComponentQueryHelper.getActivityNoticeByActId(bo.getRuleEndActId()));
				dto.setPuList(this.listPermissionUsers(bo.getRuleEndActId()));
				nextActivityDTOList.add(dto);
			}
		}
		Map map = new HashMap<String, List<WorkflowActivityDTO>>();
		map.put("allActivityDTOList", allActivityDTOList);
		map.put("nextActivityDTOList", nextActivityDTOList);
		map.put("actOrder", nextActivityDTOList.get(0).getActOrder());
		map.put("nextActId", nextActivityDTOList.get(0).getActId());
		map.put("preActId", allActivityDTOList.get(0).getActId());
		return map;
	}
	
	/**
	 * 检查流程规则的构造转移条件
	 * @param FlowRule
	 * @return true:符合 false:不符合
	 * @throws ServiceException
	 */
	private Boolean checkRuleCondition(FlowRule bo) throws ServiceException{
		return true;
	}
	
	/**
	 * 根据活动单元ID查询有活动单元权限的用户
	 * @param actId
	 * @return List<PermissionUsersDTO>
	 * @throws ServiceException
	 */
	private List<PermissionUsersDTO> listPermissionUsers(String actId) throws ServiceException{
		String apUserType = "AND";//默认
		//拼动态查询sql语句
		StringBuilder sql = new StringBuilder();
		//1.根据活动单元id查询权限控制信息
		List<FlowActivityPermissionDTO> apList = YhFlowComponentQueryHelper.getActivityPermissionByActId(actId);
		//2.根据权限控制id查询权限组合信息(活动单元和权限控制信息为1对1关系)
		List<Object[]> apcList = null;
		if(CollectionUtils.isNotEmpty(apList)){
			apUserType = apList.get(0).getApUserType()==null? apUserType:apList.get(0).getApUserType();
			apcList = YhFlowComponentQueryHelper.getFlowActivityPerCombinationByApIdView(apList.get(0).getApId());
		}
		if(null == apcList){
			return null;
		}
		sql.append(" select * from YHF_Combination_Person_View cpv where 1=1 ");
		for(int i=0;i<apcList.size();i++){
			sql.append(apUserType+" cpv."+apcList.get(i)[1]+" in ("+apcList.get(i)[2]+") ");
		}
		
		return YhFlowComponentQueryHelper.getPermissionUsersDTO(sql.toString());
	}
	
	/**
	 * 列出人员信息
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public List<PermissionUsersDTO> listPersonInfo(TableTagBean ttb) throws ServiceException{
		return YhFlowComponentQueryHelper.listPersonInfo(ttb);
	}
	
	@Override
	public JSONObject queryDepGroRole() throws ServiceException {
		// 部门信息
		List<UtOrgDTO> orgList = JhcOrgTreeQueryHelper.findAllOrgList();
		//小组信息
		List<WorkGroupDTO> wgList = WorkGroupQueryHelper.queryWorkGroupList();	
		//角色信息
		List<RolesDTO> roleList = RolesQueryHelper.findAllRoles(AuthConstants.ROLE_TYPE_FUNCTION);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("orgInfo", CollectionUtils.isEmpty(orgList) ? JSON.toJSON("{}") : JSON.toJSON(orgList));
		jsonObject.put("groupInfo", CollectionUtils.isEmpty(wgList) ? JSON.toJSON("{}") : JSON.toJSON(wgList));
		jsonObject.put("roleInfo", CollectionUtils.isEmpty(roleList) ? JSON.toJSON("{}") : JSON.toJSON(roleList));
		return jsonObject;
	}
	
	/**
	 * 查询关键字
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public JSONObject queryKeyWords() throws ServiceException {
		List<WorkFlowKeyWordDTO> keyWordList = WorkFlowKeyWordQueryHelper.queryAllKeyWord();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("keyWord", CollectionUtils.isEmpty(keyWordList) ? JSON.toJSON("{}") : JSON.toJSON(keyWordList).toString());
		return jsonObject;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.hr.component.flow.service.YhFlowComponentService#listCarbonCopy(com.yh.component.taglib.TableTagBean)
	 */
	public List<CarbonCopyDTO> listCarbonCopy(TableTagBean ttb) throws ServiceException {
		List<CarbonCopyDTO> ccList = WorkFlowCarbonCopyQueryHelper.listCarbonCopy(ttb);
		return ccList;
	}

	/* (non-Javadoc)
	 * @see com.yh.hr.component.flow.service.YhFlowComponentService#listTaskProcess(com.yh.component.taglib.TableTagBean)
	 */
	@Override
	public Map<String, List<TaskProcessDTO>> listTaskProcess(TableTagBean ttb)
			throws ServiceException {
		List<TaskProcessDTO> tpList = YhFlowTaskProcessQueryHelper.listTaskProcess(ttb);
		Map<String, List<TaskProcessDTO>> map = new TreeMap<String, List<TaskProcessDTO>>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }
                });
		int index = 0;
		if(CollectionUtils.isNotEmpty(tpList)){
			String order = tpList.get(0).getActOrder();
			if(StringUtils.isNotEmpty(order)){
				List<TaskProcessDTO> newList = new ArrayList<TaskProcessDTO>();
				for(TaskProcessDTO tp:tpList){
					//判断比较项（order与actOrder）是否一致 如果一致则应该是下一轮 index++，
					//newList保存在map中 key为上一个index 如果newList为空则不保存，
					//新建一个新的newLIst 
					//如果不一致 则直接保存到newList中
					if(order.equals(tp.getActOrder())){
						index++;
						if(CollectionUtils.isNotEmpty(newList)){
							map.put(String.valueOf(index-1), newList);
							newList.clear();
						}
						newList.add(tp);
					}else{
						newList.add(tp);
					}
				}
				if(CollectionUtils.isNotEmpty(newList)){
					map.put(String.valueOf(index), newList);
				}
			}
		}
		return map;
	}

}
