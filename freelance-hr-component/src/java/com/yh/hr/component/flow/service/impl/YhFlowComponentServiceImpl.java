package com.yh.hr.component.flow.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;

import com.yh.admin.dto.RolesDTO;
import com.yh.admin.roles.queryhelper.RolesQueryHelper;
import com.yh.admin.util.AuthConstants;
import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.File;
import com.yh.component.workflow.bo.FlowActivity;
import com.yh.component.workflow.bo.FlowRule;
import com.yh.component.workflow.bo.Task;
import com.yh.component.workflow.bo.TaskProcess;
import com.yh.component.workflow.dto.FlowActivityPermissionDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.queryhelper.YhFlowComponentQueryHelper;
import com.yh.hr.component.flow.service.YhFlowComponentService;
import com.yh.hr.component.orgtree.queryhelper.JhcOrgTreeQueryHelper;
import com.yh.hr.res.unit.dto.UtOrgDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.UuidUtils;
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
				dto.setApList(YhFlowComponentQueryHelper.getActivityPermissionByActId(bo.getRuleEndActId()));
				dto.setAnList(YhFlowComponentQueryHelper.getActivityNoticeByActId(bo.getRuleEndActId()));
				dto.setPuList(this.listPermissionUsers(bo.getRuleEndActId()));
				nextActivityDTOList.add(dto);
			}
		}
		Map map = new HashMap<String, List<WorkflowActivityDTO>>();
		map.put("allActivityDTOList", allActivityDTOList);
		map.put("nextActivityDTOList", nextActivityDTOList);
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
	 * 提交流程（确定）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitFlowStart(YhFlowComponentDTO dto) throws ServiceException{
		//1.保存文档信息 YHFile(文件基础表状态1-审批中)
		File f = new File();
		f.setFileId(UuidUtils.getUUID36());
		f.save();
		
		//2.保存任务表信息 YHTask
		Task t = new Task();
		t.setTaskId(UuidUtils.getUUID36());
		t.save();
		
		//3.保存任务进程表信息 YHTaskProcess
		TaskProcess tp = new TaskProcess();
		tp.setTaskProcessId(UuidUtils.getUUID36());
		tp.save();
	}
	
	/**
	 * 表单数据暂存
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void saveTemporaryStorage(YhFlowComponentDTO dto) throws ServiceException{
		
	}
	
	/**
	 * 历史数据
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void saveHistoryData(YhFlowComponentDTO dto) throws ServiceException{
		
	}
	
	/**
	 * 列出人员信息
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public List<JSONObject> listPersonInfo(TableTagBean ttb) throws ServiceException{
		return null;
	}
	
	/**
	 * 抄送用户(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitCcUsers(YhFlowComponentDTO dto) throws ServiceException{
		
	}

	@Override
	public JSONObject queryDepGroRole() throws ServiceException {
		// 部门信息
		List<UtOrgDTO> orgList = JhcOrgTreeQueryHelper.findAllOrgList();
		//小组信息
				
		//角色信息
		List<RolesDTO> roleList = RolesQueryHelper.findAllRoles(AuthConstants.ROLE_TYPE_FUNCTION);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("orgInfo", CollectionUtils.isEmpty(orgList) ? JSONHelper.fromObject("{}") : JSONHelper.fromObject(orgList));
		jsonObject.put("groupInfo", CollectionUtils.isEmpty(orgList) ? JSONHelper.fromObject("{}") : JSONHelper.fromObject(orgList));
		jsonObject.put("roleInfo", CollectionUtils.isEmpty(orgList) ? JSONHelper.fromObject("{}") : JSONHelper.fromObject(roleList));
		return jsonObject;
	}
}
