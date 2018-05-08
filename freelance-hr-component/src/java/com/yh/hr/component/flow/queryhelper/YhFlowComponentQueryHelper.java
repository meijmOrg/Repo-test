package com.yh.hr.component.flow.queryhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.FlowActivityNotice;
import com.yh.component.workflow.bo.FlowActivityPerCombination;
import com.yh.component.workflow.bo.FlowActivityPermission;
import com.yh.component.workflow.bo.Task;
import com.yh.component.workflow.dto.FlowActivityNoticeDTO;
import com.yh.component.workflow.dto.FlowActivityPermissionDTO;
import com.yh.component.workflow.dto.PermissionUsersDTO;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.utils.WorkFlowConfigurationUtil;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.DataAccessFailureException;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
import com.yh.platform.core.web.UserContext;

/**
 * @description 流程组件查询类
 * @author meijm
 * @created 2018-1-18
 * @version 1.0
 */
public class YhFlowComponentQueryHelper {
	/**
     * 根据模板ID获取流程信息（有专属流程返回专属，没有就返回通用）
     * @param templateId
     * @param 
     * @return WorkflowBaseInfoDTO
     * @throws ServiceException
     */
	public static WorkflowBaseInfoDTO getYhFlowByTemplateId(String templateId) throws ServiceException {

		Map<String, Object> params1 = new HashMap<String, Object>();
		Map<String, Object> params2 = new HashMap<String, Object>();
//		Object[] objUser = getUserInfoByUserCode(UserContext.getLoginUserID());
//		Long deptOid = objUser[5] == null ? null:Long.valueOf(objUser[5].toString());//用户所在部门id
		Long deptOid = UserContext.getLoginUserDeptOid();//用户所在部门id
		params1.put("templateId", templateId);
		params2.put("templateId", templateId);
		params2.put("deptOid", deptOid);
		params1.put("flowType1", WorkFlowConfigurationUtil.YHRS4004_0);
		params2.put("flowType2", WorkFlowConfigurationUtil.YHRS4004_1);
		StringBuilder sql = new StringBuilder();
		StringBuilder sql1 = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		sql.append("select yf.flow_id,");
		sql.append("       yf.flow_name,");
		sql.append("       yf.flow_type,");
		sql.append("       yf.flow_org_oid,");
		sql.append("       yf.flow_org_name,");
		sql.append("       yft.template_Id,");
		sql.append("       ytf.tf_forbidden");
		sql.append("       from yhf_file_template yft,yhf_flow yf,yhf_template_flow ytf");
		sql.append("       where yft.template_Id=ytf.template_Id");
		sql.append("       and yf.flow_id=ytf.flow_id");
		sql.append("       and yft.template_Id = :templateId");
		sql1.append(" and yf.flow_type = :flowType1");
		sql2.append(" and yf.flow_type = :flowType2");
		sql2.append(" and yf.flow_org_oid = :deptOid");
		List<Object[]> list = null;
		List<Object[]> tylist = DaoUtil.findWithSQL(sql.append(sql1).toString(),params1);//通用流程
		//减去sql1内容
		sql.delete(sql.length()-sql1.length(), sql.length());
		List<Object[]> zslist = DaoUtil.findWithSQL(sql.append(sql2).toString(),params2);//专属流程
		if(CollectionUtils.isEmpty(zslist)&&CollectionUtils.isEmpty(tylist)){
			return null;
		}
		if(CollectionUtils.isNotEmpty(zslist)){
			list = zslist;
		}
		if(CollectionUtils.isEmpty(zslist)&&CollectionUtils.isNotEmpty(tylist)){
			list = tylist;
		}
		Object[] task = list.get(0);
			
		WorkflowBaseInfoDTO dto = new WorkflowBaseInfoDTO();
		dto.setFlowId(task[0] == null ? null:task[0].toString());
		dto.setFlowName(task[1] == null ? null:task[1].toString());
		dto.setFlowType(task[2] == null ? null:task[2].toString());
		dto.setFlowOrgOid(task[3] == null ? null:Long.valueOf(task[3].toString()));
		dto.setFlowOrgName(task[4] == null ? null:task[4].toString());
		dto.setTemplateId(task[5] == null ? null:task[5].toString());
		dto.setTfForbidden(task[6] == null ? null:Long.valueOf(task[6].toString()));
		return dto;
	}
	
	/**
     * 根据流程ID获取所有活动单元信息 并按序号排序
     * @param flowId
     * @return List<WorkflowActivityDTO>
     * @throws ServiceException
     */
	public static List<WorkflowActivityDTO> getFlowActivityByFlowId(String flowId) throws ServiceException {
		StringBuilder sql = new StringBuilder();
		sql.append("select yfa.act_id,");
		sql.append("       yfa.flow_id,");
		sql.append("       yfa.act_name,");
		sql.append("       yfa.act_order,");
		sql.append("       yfa.act_result,");
		sql.append("       yfa.act_begin_rule_id,");
		sql.append("       yfa.act_end_rule_id,");
		sql.append("       yfa.act_type,");
		sql.append("       yfa.act_back_type,");
		sql.append("       yfa.act_finish_type,");
		sql.append("       yfa.act_audit_content");
		sql.append("       from yhf_flow_activity yfa");
		sql.append("       where 1=1");
		sql.append("       and yfa.flow_id='"+flowId+"'");
		sql.append("       order by yfa.act_order");
		List<Object[]> list = DaoUtil.findWithSQL(sql.toString());
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		List<WorkflowActivityDTO> dtos = new ArrayList<WorkflowActivityDTO>();
		for (int i = 0; i < list.size(); i++) {
			Object[] task = list.get(i);
			
			WorkflowActivityDTO dto = new WorkflowActivityDTO();
			dto.setActId(task[0] == null ? null:task[0].toString());
			dto.setFlowId(task[1] == null ? null:task[1].toString());
			dto.setActName(task[2] == null ? null:task[2].toString());
			dto.setActOrder(task[3] == null ? null:Integer.valueOf(task[3].toString()));
			dto.setActOrderStr(task[3] == null ? null:task[3].toString()+".");
			dto.setActResult(task[4] == null ? null:task[4].toString());
			dto.setActBeginRuleId(task[5] == null ? null:task[5].toString());
			dto.setActEndRuleId(task[6] == null ? null:task[6].toString());
			dto.setActType(task[7] == null ? null:task[7].toString());
			dto.setActBackType(task[8] == null ? null:task[8].toString());
			dto.setActFinishType(task[9] == null ? null:task[9].toString());
			dto.setActAuditContent(task[10] == null ? null:task[10].toString());
			dto.setApList(getActivityPermissionByActId(task[0] == null ? null:task[0].toString()));
			dto.setAnList(getActivityNoticeByActId(task[0] == null ? null:task[0].toString()));
			dtos.add(dto);
		}
		return dtos;
	}
	
	/**
     * 根据活动单元ID获取权限控制信息
     * @param actId
     * @return List<FlowActivityPermissionDTO>
     * @throws ServiceException
     */
	public static List<FlowActivityPermissionDTO> getActivityPermissionByActId(String actId) throws ServiceException {
		List<FlowActivityPermission> list=DaoUtil.find(" from FlowActivityPermission fap where fap.actId=?",actId);
		return BeanHelper.copyProperties(list, FlowActivityPermissionDTO.class);
	}
	
	/**
     * 根据权限控制ID获取权限组合信息
     * @param apId
     * @return List<FlowActivityPerCombination>
     * @throws ServiceException
     */
	public static List<FlowActivityPerCombination> getFlowActivityPerCombinationByApId(String apId) throws ServiceException {
		return DaoUtil.find(" from FlowActivityPerCombination fapc where fapc.apId=?",apId);
	}
	
	/**
     * 根据活动单元ID获取任务通知信息
     * @param actId
     * @return List<FlowActivityNoticeDTO>
     * @throws ServiceException
     */
	public static List<FlowActivityNoticeDTO> getActivityNoticeByActId(String actId) throws ServiceException {
		List<FlowActivityNotice> list=DaoUtil.find(" from FlowActivityNotice fan where fan.actId=?",actId);
		return BeanHelper.copyProperties(list, FlowActivityNoticeDTO.class);
	}
	
	/**
     * 根据用户ID获取用户信息
     * @param userCode
     * @return List<Object[]>
     * @throws ServiceException
     */
//	public static Object[] getUserInfoByUserCode(String userCode) throws ServiceException {
//		StringBuilder sql = new StringBuilder();
//		sql.append("select yu.USER_OID,");
//		sql.append("       yu.USER_ID,");
//		sql.append("       yu.PASSWORD,");
//		sql.append("       yu.USER_NAME,");
//		sql.append("       yu.UNIT_ID,");
//		sql.append("       yu.DEPT_ID");
//		sql.append("       from yhb_users yu");
//		sql.append("       where 1=1");
//		sql.append("       and yu.user_id='"+userCode+"'");
//		List<Object[]> list = DaoUtil.findWithSQL(sql.toString());
//		if(CollectionUtils.isEmpty(list)){
//			return null;
//		}
//		return list.get(0);
//	}
	
	/**
     * 根据权限控制ID获取权限组合信息(查询视图)
     * @param apId
     * @return List<Object[]>
     * @throws ServiceException
     */
	public static List<Object[]> getFlowActivityPerCombinationByApIdView(String apId) throws ServiceException {
		StringBuilder sql = new StringBuilder();
		sql.append("select ycv.ap_id,");
		sql.append("       ycv.pc_type,");
		sql.append("       CONVERT(varchar(1000), isnull(ycv.NS, '')),");
		sql.append("       CONVERT(varchar(1000), isnull(ycv.NSValue, ''))");
		sql.append("       from YHF_Combination_View ycv");
		sql.append("       where 1=1");
		sql.append("       and ycv.ap_id='"+apId+"'");
		List<Object[]> list = DaoUtil.findWithSQL(sql.toString());
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return list;
	}
	
	/**
     * 活动单元权限的用户
     * @param sql
     * @return List<PermissionUsersDTO>
     * @throws ServiceException
     */
	public static List<PermissionUsersDTO> getPermissionUsersDTO(String sql) throws ServiceException {
		List<Object[]> list = DaoUtil.findWithSQL(sql);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		List<PermissionUsersDTO> permissionUsersDTOList = new ArrayList<PermissionUsersDTO>();
		for(int i = 0; i < list.size(); i++){
			Object[] o = list.get(i);
			PermissionUsersDTO dto = new PermissionUsersDTO();
			dto.setUserId(o[0] == null? "":o[0].toString());
			dto.setUserName(o[1] == null? "":o[1].toString());
			dto.setPassword(o[2] == null? "":o[2].toString());
			dto.setPersonOid(o[3] == null? null:Long.valueOf(o[3].toString()));
			dto.setDeptId(o[6] == null? null:Long.valueOf(o[6].toString()));
			permissionUsersDTOList.add(dto);
		}
		return permissionUsersDTOList;
	}
	
	/**
     * 根据上一步活动单元id查询上一步任务信息
     * @param taskPreActId
     * @return List<Task>
     * @throws ServiceException
     */
	public static Task getTaskInfoByTaskPreActId(String taskPreActId) throws ServiceException {
		List<Task> taskList = DaoUtil.find(" from Task t where t.taskCurrentActId=?",taskPreActId);
		if(CollectionUtils.isEmpty(taskList)){
			return null;
		}
		return taskList.get(0);
	}
	
	/**
	 * 获取人员信息列表
	 * @param ttb
	 * @return
	 * @throws ServiceException 
	 */
	public static List<PermissionUsersDTO> listPersonInfo(TableTagBean ttb) throws ServiceException{
		String unitName = ttb.getCondition().get("unitName");
		String deptName = ttb.getCondition().get("deptName");
		String name = ttb.getCondition().get("name");
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("select t.PERSON_OID,t.name,t.UNIT_OID,t.DEPT_OID,t.unitName,t.deptName,t.DUTY_NAME,t.USER_ID ");
		sql.append("from (");
		sql.append("select p.PERSON_OID,");
		sql.append("p.name,");
		sql.append("p.UNIT_OID,");
		sql.append("p.DEPT_OID,");
		sql.append("(select yuu.unit_name from yhc_ut_unit yuu where yuu.UNIT_OID=p.UNIT_OID) as unitName,");
		sql.append("(select yuo.org_name from yhc_ut_org yuo where yuo.ORG_OID=p.DEPT_OID) as deptName,");
		sql.append("pa.DUTY_NAME,");
		sql.append("yu.USER_ID ");
		sql.append(" from yhc_pb_person_info p,yhc_pb_person_attach pa,yhb_users yu ");
		sql.append(" where p.PERSON_OID=pa.PERSON_OID and p.PERSON_OID=yu.Person_OID) t where 1=1 ");
		if(StringUtils.isNotEmpty(unitName)){
			sql.append(" and t.unitName like '%"+unitName+"%'");
		}
		if(StringUtils.isNotEmpty(deptName)){
			sql.append(" and t.deptName like '%"+deptName+"%'");
		}
		if(StringUtils.isNotEmpty(name)){
			sql.append(" and t.name like '%"+name+"%'");
		}
		if (ttb.getPageSize() != 0) {
			ttb.setTotal(DaoUtil.countWithSQLByCondition((new StringBuilder().append("select count(*) from (").append(sql).append(") as total").toString()), params));
		}
		List<Object[]> list = DaoUtil.listWithSQLByCondition(sql.toString(), params, ttb.getPage(), ttb.getPageSize());
		return buildJSON(list);
	}  
	/**
	 * object to PermissionUsersDTO
	 * @param list
	 * @return
	 * @throws DataAccessFailureException
	 * @throws ServiceException
	 */
	private static List<PermissionUsersDTO> buildJSON(List<Object[]> list) throws DataAccessFailureException,ServiceException
	{
		List<PermissionUsersDTO> dtoList = new ArrayList<PermissionUsersDTO>();
		for(Object[] obj:list){
			PermissionUsersDTO dto = new PermissionUsersDTO();
			dto.setPersonOid(obj[0]==null?null:Long.valueOf(obj[0].toString()));
			dto.setName(obj[1]==null?"":obj[1].toString());	//姓名
			dto.setUnitId(obj[2]==null?null:Long.valueOf(obj[2].toString()));
			dto.setDeptId(obj[3]==null?null:Long.valueOf(obj[3].toString()));
			dto.setUnitName(obj[4]==null?"":obj[4].toString());//单位名称
			dto.setDeptName(obj[5]==null?"":obj[5].toString());//部门名称
			dto.setDutyName(obj[6]==null?"":obj[6].toString());//现任职务
			dto.setUserId(obj[7]==null?"":obj[7].toString());//用户ID
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}
	
}
