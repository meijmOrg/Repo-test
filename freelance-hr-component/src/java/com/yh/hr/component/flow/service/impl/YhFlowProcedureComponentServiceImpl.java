package com.yh.hr.component.flow.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.yh.component.workflow.bo.CarbonCopy;
import com.yh.component.workflow.bo.FlowActivity;
import com.yh.component.workflow.bo.FlowRule;
import com.yh.component.workflow.bo.SelUser;
import com.yh.component.workflow.bo.Task;
import com.yh.component.workflow.bo.TaskProcess;
import com.yh.component.workflow.dto.FlowActivityPermissionDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.queryhelper.YhFlowComponentQueryHelper;
import com.yh.hr.component.flow.service.YhFlowProcedureComponentService;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.UuidUtils;
import com.yh.platform.core.web.UserContext;
/**
 * @description 流程审批过程组件ServiceImpl
 * @author meijm
 * @created 2018-5-8
 * @version 1.0
 */
public class YhFlowProcedureComponentServiceImpl implements  YhFlowProcedureComponentService
{
	/*
	 * (non-Javadoc)
	 * @see YhFlowProcedureComponentService#goUserListPartial(String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, List<WorkflowActivityDTO>> goUserListPartial(YhFlowComponentDTO fdto) throws ServiceException
	{
		//获取当前活动单元信息 
		FlowActivity currentActivity = DaoUtil.get(FlowActivity.class, fdto.getTaskCurrentActId());
		String[] actEndRuleIds = currentActivity.getActEndRuleId().split(",");//后置规则id数组
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
		map.put("nextActivityDTOList", nextActivityDTOList);
		map.put("actOrder", nextActivityDTOList.get(0).getActOrder());
		map.put("nextActId", nextActivityDTOList.get(0).getActId());
		map.put("preActId", fdto.getTaskCurrentActId());
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
	 * 审批过程提交流程（确定）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitFlowStart(YhFlowComponentDTO dto) throws ServiceException{
		//下一步选择的办理人及活动单元Id
		String[] nextUsers = null;
		String nextActId = "";
		//获取上一步活动单元信息
		FlowActivity probo = DaoUtil.get(FlowActivity.class, dto.getTaskPreActId());
		
		if(StringUtils.isNotEmpty(dto.getNextUserList())){
			//1.保存文档信息 YHFile(文件基础表状态1-审批中)
			//String fileId = saveFileInfo(dto);
		
			nextUsers = dto.getNextUserList().split(",");//注意每个用户id前面带了36位的所属actId
			for(int i = 0;i<nextUsers.length;i++){
				nextActId = nextUsers[i].toString().substring(0, 36);
				//获取当前（下一步审批）活动单元信息
				FlowActivity currentbo = DaoUtil.get(FlowActivity.class, nextActId);
				//2.保存任务表信息 YHTask
				saveTaskInfo(dto, probo, currentbo, dto.getFileId());
			}
		
			//3.保存任务进程表信息 YHTaskProcess
			saveTaskProcessInfo(dto, probo);
			
			//4.保存设置的下一步用户办理人信息
			saveSelUserInfo(dto, dto.getFileId(), nextUsers);
			//5.保存抄送记录信息(如果有选择抄送人才保存)
			if(StringUtils.isNotEmpty(dto.getCsUserList())){
				CarbonCopy cbc = new CarbonCopy();
				cbc.setCcId(UuidUtils.getUUID36());
				cbc.setCcActId(dto.getTaskCurrentActId());
				cbc.setCcUser(dto.getCsUserList());
				cbc.setCcFlowId(dto.getFlowId());
				cbc.setCcTime(DateUtil.now());
				cbc.setCcCreateUser(UserContext.getLoginUserID());
				cbc.setCcFileID(dto.getFileId());
				cbc.save();
			}
			//6.保存其他业务信息
		}
	}
	
	public void saveTaskInfo(YhFlowComponentDTO dto, FlowActivity probo, FlowActivity currentbo, String fileId) throws ServiceException{
		Task t = new Task();
		t.setTaskId(UuidUtils.getUUID36());
		t.setFlowId(probo.getFlowId());
		t.setRuleId(probo.getActEndRuleId());
		t.setFileId(fileId);
		t.setDeptId(UserContext.getLoginUserDeptOid());
		t.setTaskCurrentActId(currentbo.getActId());
		t.setTaskPreActId(dto.getTaskPreActId());
		t.setTaskUser(UserContext.getLoginUserID());
		t.setTaskName(dto.getTaskName());
		t.setTaskSendTime(DateUtil.now());
		t.setTaskSendUser(UserContext.getLoginUserID());
		t.setTaskSign(dto.getTaskSign());
		t.setTaskCoordination(dto.getTaskCoordination());
		t.setTaskConunterSign(dto.getTaskConunterSign());
		t.save();
	}
	
	public void saveTaskProcessInfo(YhFlowComponentDTO dto, FlowActivity probo) throws ServiceException{
		Task task = YhFlowComponentQueryHelper.getTaskInfoByTaskPreActId(dto.getTaskPreActId());
		TaskProcess tp = new TaskProcess();
		tp.setTaskProcessId(UuidUtils.getUUID36());
		tp.setTaskId(task.getTaskId());
		tp.setFlowId(probo.getFlowId());
		tp.setActId(probo.getActId());
		tp.setActName(probo.getActName());
		tp.setFileId(dto.getFlowId());
		tp.setRuleId(probo.getActBeginRuleId());
		tp.setTaskProcessDoTime(DateUtil.now());
		tp.setTaskProcessUser(UserContext.getLoginUserID());
		tp.setTaskProcessResult(dto.getTaskProcessResult());
		tp.setTaskProcessExplain(dto.getTaskProcessExplain());
		tp.setDeptId(UserContext.getLoginUserDeptOid());
		tp.setTaskProcessName(task.getTaskName());
		tp.setTaskProcessType("");
		tp.setIsSkip(null);
		tp.setSkipUser("");
		tp.setTaskStartTime(task.getTaskSendTime());
		tp.setTaskEndTime(DateUtil.now());
		tp.setTaskFromUser(task.getTaskSendUser());
		tp.setTaskSendNextUser("");
		tp.save();
	}
	
	public void saveSelUserInfo(YhFlowComponentDTO dto, String fileId, String[] nextUsers) throws ServiceException{
		//下一步选择的办理人及活动单元Id
		String nextActId = nextUsers[0].toString().substring(0, 36);
		String nextUserId = "";
		for(int i = 0;i<nextUsers.length;i++){
			nextUserId += nextUsers[i].toString().substring(36, nextUsers[i].toString().length())+",";
		}
		nextUserId = nextUserId.substring(0, nextUserId.length()-1);//去掉最后一个逗号
		SelUser su = new SelUser();
		su.setSelUserId(UuidUtils.getUUID36());
		su.setFileId(fileId);
		su.setActId(nextActId);
		su.setUserId(nextUserId);
		su.setSelType("0");//提交流程所选择的用户
		su.save();
	}
	
	/**
	 * 退回
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void recheckBack(YhFlowComponentDTO dto) throws ServiceException{
		
	}
	
	/**
	 * 加签(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitSighUsers(YhFlowComponentDTO dto) throws ServiceException{
		//加签选择的办理人
		String nextUsersId = dto.getNextUserList();
		String nextActId = dto.getTaskCurrentActId();
		//获取上一步活动单元信息
		FlowActivity probo = DaoUtil.get(FlowActivity.class, dto.getTaskPreActId());
		//获取当前（下一步审批）活动单元信息
		FlowActivity currentbo = DaoUtil.get(FlowActivity.class, nextActId);
		
		
		//1.保存文档信息 YHFile(文件基础表状态5-加签中)
//		String fileId = saveFileInfo(dto);
		
		//2.保存任务表信息 YHTask
		saveTaskInfo(dto, probo, currentbo, dto.getFileId());
		
		//3.保存任务进程表信息 YHTaskProcess(发起不保存)
		
		//4.保存加签办理人信息
		SelUser su = new SelUser();
		su.setSelUserId(UuidUtils.getUUID36());
		su.setFileId(dto.getFileId());
		su.setActId(nextActId);
		su.setUserId(nextUsersId);
		su.setSelType("1");//加签所选择的用户
		su.save();
		//5.保存其他业务信息
	}
	
	/**
	 * 抄送用户(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitCsUsers(YhFlowComponentDTO dto) throws ServiceException{
		//抄送选择的用户
		String nextUsersId = dto.getNextUserList();
		String nextActId = dto.getTaskCurrentActId();
		//获取上一步活动单元信息
		FlowActivity probo = DaoUtil.get(FlowActivity.class, dto.getTaskPreActId());
		//获取当前（下一步审批）活动单元信息
		FlowActivity currentbo = DaoUtil.get(FlowActivity.class, nextActId);
		
		
		//1.保存文档信息 YHFile(文件基础表状态1-审批中)
//		String fileId = saveFileInfo(dto);
		
		//2.保存任务表信息 YHTask
		saveTaskInfo(dto, probo, currentbo, dto.getFileId());
		
		//3.保存任务进程表信息 YHTaskProcess(发起不保存)
		
		//4.保存抄送办理人信息
		SelUser su = new SelUser();
		su.setSelUserId(UuidUtils.getUUID36());
		su.setFileId(dto.getFileId());
		su.setActId(nextActId);
		su.setUserId(nextUsersId);
		su.setSelType("2");//抄送所选择的用户
		su.save();
		//5.保存其他业务信息
	}
	
	/**
	 * 协同（确认）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitCoordinationUsers(YhFlowComponentDTO dto) throws ServiceException{
		
	}

}
