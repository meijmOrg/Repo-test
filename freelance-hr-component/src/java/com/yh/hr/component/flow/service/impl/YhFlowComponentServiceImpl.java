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
import com.yh.component.workflow.bo.CarbonCopy;
import com.yh.component.workflow.bo.File;
import com.yh.component.workflow.bo.FileTemplate;
import com.yh.component.workflow.bo.FlowActivity;
import com.yh.component.workflow.bo.FlowRule;
import com.yh.component.workflow.bo.SelUser;
import com.yh.component.workflow.bo.Task;
import com.yh.component.workflow.bo.TaskProcess;
import com.yh.component.workflow.dto.CarbonCopyDTO;
import com.yh.component.workflow.dto.FlowActivityPermissionDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.TaskProcessDTO;
import com.yh.component.workflow.dto.WorkFlowKeyWordDTO;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.queryhelper.WorkFlowCarbonCopyQueryHelper;
import com.yh.component.workflow.queryhelper.WorkFlowKeyWordQueryHelper;
import com.yh.component.workflow.queryhelper.WorkFlowTaskProcessQueryHelper;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.queryhelper.YhFlowComponentQueryHelper;
import com.yh.hr.component.flow.service.YhFlowComponentService;
import com.yh.hr.component.orgtree.queryhelper.JhcOrgTreeQueryHelper;
import com.yh.hr.res.unit.dto.UtOrgDTO;
import com.yh.hr.res.unit.dto.WorkGroupDTO;
import com.yh.hr.res.unit.queryhelper.WorkGroupQueryHelper;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.UuidUtils;
import com.yh.platform.core.web.UserContext;
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
	 * 提交流程（确定）
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
			String fileId = saveFileInfo(dto);
		
			nextUsers = dto.getNextUserList().split(",");//注意每个用户id前面带了36位的所属actId
			for(int i = 0;i<nextUsers.length;i++){
				nextActId = nextUsers[i].toString().substring(0, 36);
				//获取当前（下一步审批）活动单元信息
				FlowActivity currentbo = DaoUtil.get(FlowActivity.class, nextActId);
				//2.保存任务表信息 YHTask
				saveTaskInfo(dto, probo, currentbo, fileId);
			}
		
			//3.保存任务进程表信息 YHTaskProcess
			saveTaskProcessInfo(dto);
			//4.保存设置的下一步用户办理人信息
			saveSelUserInfo(dto, fileId, nextUsers);
			//5.保存抄送记录信息(如果有选择抄送人才保存)
			if(StringUtils.isNotEmpty(dto.getCsUserList())){
				CarbonCopy cbc = new CarbonCopy();
				cbc.setCcId(UuidUtils.getUUID36());
				cbc.setCcActId(dto.getTaskCurrentActId());
				cbc.setCcUser(dto.getCsUserList());
				cbc.setCcFlowId(dto.getFlowId());
				cbc.setCcTime(DateUtil.now());
				cbc.setCcCreateUser(UserContext.getLoginUserID());
				cbc.setCcFileID(fileId);
				cbc.save();
			}
			
			//6.保存其他业务信息
		}
	}
	
	public String saveFileInfo(YhFlowComponentDTO dto) throws ServiceException{
		//获取模板信息
		FileTemplate tbo =DaoUtil.get(FileTemplate.class, dto.getTemplateId());
		File f = new File();
		f.setFileId(UuidUtils.getUUID36());
		f.setTemplateId(tbo.getTemplateId());
		f.setTemplateCode(tbo.getTemplateCode());
		f.setFileCode(dto.getFileCode());
		f.setFileTitle(dto.getFileTitle());
		f.setFileKeyWord(dto.getFileKeyWord());
		f.setFileFlowStatus(dto.getFileFlowStatus());
		f.setCreateDate(DateUtil.now());
		f.setCreateUserID(UserContext.getLoginUserID());
		f.setCreateUserName(UserContext.getLoginUserName());
		f.setCreateDepartID(UserContext.getLoginUserDeptOid());
		f.setFileEmergencyLevel(dto.getFileEmergencyLevel());
		f.setFileSecurityRate(dto.getFileSecurityRate());
		f.save();
		return f.getFileId();
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
	
	public void saveTaskProcessInfo(YhFlowComponentDTO dto) throws ServiceException{
		TaskProcess tp = new TaskProcess();
		tp.setTaskProcessId(UuidUtils.getUUID36());
		tp.setTaskId("");
		tp.setFlowId(dto.getFlowId());
		tp.setActId("");
		tp.setActName("");
		tp.setFileId(dto.getFileId());
		tp.setRuleId("");
		tp.setTaskProcessDoTime(DateUtil.now());
		tp.setTaskProcessUser(UserContext.getLoginUserID());
		tp.setTaskProcessResult(dto.getTaskProcessResult());
		tp.setTaskProcessExplain(dto.getTaskProcessExplain());
		tp.setDeptId(UserContext.getLoginUserDeptOid());
		tp.setTaskProcessName("");
		tp.setTaskProcessType("");
		tp.setIsSkip(null);
		tp.setSkipUser("");
		tp.setTaskStartTime(null);
		tp.setTaskEndTime(DateUtil.now());
		tp.setTaskFromUser(UserContext.getLoginUserID());
		tp.setTaskSendNextUser("");
		tp.save();
	}
	
	public void saveSelUserInfo(YhFlowComponentDTO dto, String fileId, String[] nextUsers) throws ServiceException{
		//下一步选择的办理人及活动单元Id
		String nextActId = "";
		String nextUserId = "";
		for(int i = 0;i<nextUsers.length;i++){
			nextActId = nextUsers[i].toString().substring(0, 36);
			nextUserId = nextUsers[i].toString().substring(36, nextUsers[i].toString().length());
			SelUser su = new SelUser();
			su.setSelUserId(UuidUtils.getUUID36());
			su.setFileId(fileId);
			su.setActId(nextActId);
			su.setUserId(nextUserId);
			su.setSelType("0");//提交流程所选择的用户
			su.save();
		}
		//如果其他步骤也有设置则保存
		if(StringUtils.isNotEmpty(dto.getOtherUserList())){
			String otherActId = "";
			String otherUserId = "";
			//其他步骤选择的办理人及活动单元Id
			String[] otherUsers = dto.getOtherUserList().split(",");//注意每个用户id前面带了36位的所属actId
//			boolean b = false;
//			String val = "";
//			String val2 = "";
//			List<String> otherUsersList = new ArrayList<String>();
//			for(int j = 0;j<otherUsers.length;j++){
//				val = otherUsers[j];
//				if(otherUsersList.size() == 0){
//					otherUsersList.add(val);
//				}else{
//					for(int k = 0;k<otherUsersList.size();k++){
//						val2 = otherUsersList.get(k);
//						if(val2.substring(0, 36).equals(val.substring(0, 36))){
//							val2 = val2+","+val.substring(36, val.length());
//							otherUsersList.set(k, val2);
//							b=true;
//							break;
//						}
//					}
//					if(!b){
//						otherUsersList.add(val);
//					}
//				}
//			}
			for(int y = 0;y<otherUsers.length;y++){
				otherActId = otherUsers[y].toString().substring(0, 36);
				otherUserId = otherUsers[y].toString().substring(36, otherUsers[y].toString().length());
				SelUser bo = new SelUser();
				bo.setSelUserId(UuidUtils.getUUID36());
				bo.setFileId(fileId);
				bo.setActId(otherActId);
				bo.setUserId(otherUserId);
				bo.setSelType("0");//提交流程所选择的用户
				bo.save();
			}
		}
	}
	
	
	/**
	 * 表单数据暂存
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unused")
	public void saveTemporaryStorage(YhFlowComponentDTO dto) throws ServiceException{
		//保存文档信息 YHFile(文件基础表状态0-未启动)
		String fileId = saveFileInfo(dto);
	}
	
	/**
	 * 历史数据
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unused")
	public void saveHistoryData(YhFlowComponentDTO dto) throws ServiceException{
		//保存文档信息 YHFile(文件基础表状态6-历史数据)
		String fileId = saveFileInfo(dto);
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
	
	/**
	 * 加签(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitSighUsers(YhFlowComponentDTO dto) throws ServiceException{
		//加签选择的办理人(只能选一个人)
		String nextUsersId = dto.getNextUserList();
		String nextActId = dto.getTaskCurrentActId();
		//获取上一步活动单元信息
		FlowActivity probo = DaoUtil.get(FlowActivity.class, dto.getTaskPreActId());
		//获取当前（下一步审批）活动单元信息
		FlowActivity currentbo = DaoUtil.get(FlowActivity.class, nextActId);
		
		
		//1.保存文档信息 YHFile(文件基础表状态5-加签中)
		String fileId = saveFileInfo(dto);
		
		//2.保存任务表信息 YHTask
		saveTaskInfo(dto, probo, currentbo, fileId);
		
		//3.保存任务进程表信息 YHTaskProcess(发起不保存)
		
		//4.保存加签办理人信息
		SelUser su = new SelUser();
		su.setSelUserId(UuidUtils.getUUID36());
		su.setFileId(fileId);
		su.setActId(nextActId);
		su.setUserId(nextUsersId);
		su.setSelType("1");//加签所选择的用户
		su.save();
		//5.保存其他业务信息
	}
	
	/**
	 * 抄送用户(确定,相当于暂存抄送用户,没有提交流程操作)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitCsUsers(YhFlowComponentDTO dto) throws ServiceException{
		//抄送选择的用户（可能多个，以“,”分隔）
		String nextUsersId = dto.getNextUserList();
		
		//保存抄送记录信息(当前只保存这几个字段，其他信息在提交流程操作时候保存)
		CarbonCopy cbc = new CarbonCopy();
		cbc.setCcId(UuidUtils.getUUID36());
		cbc.setCcCreateUser(UserContext.getLoginUserID());
		cbc.setCcUser(nextUsersId);
		cbc.save();
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
		List<TaskProcessDTO> tpList = WorkFlowTaskProcessQueryHelper.listTaskProcess(ttb);
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
