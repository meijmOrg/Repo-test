package com.yh.component.workflow.service.impl;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONArray;
import com.yh.component.dictionary.utils.DicHelper;
import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.bo.FileTemplate;
import com.yh.component.workflow.bo.Flow;
import com.yh.component.workflow.bo.FlowActivity;
import com.yh.component.workflow.bo.FlowActivityNotice;
import com.yh.component.workflow.bo.FlowActivityPerCombination;
import com.yh.component.workflow.bo.FlowActivityPermission;
import com.yh.component.workflow.bo.FlowKeyWord;
import com.yh.component.workflow.bo.FlowRule;
import com.yh.component.workflow.bo.TemplateFlow;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
import com.yh.component.workflow.queryhelper.WorkflowConfigurationQueryHelper;
import com.yh.component.workflow.service.WorkflowConfigurationService;
import com.yh.component.workflow.utils.WorkFlowConfigurationUtil;
import com.yh.component.workflow.vo.DrawingBaseInfo;
import com.yh.component.workflow.vo.DrawingBaseInfoRuleProps;
import com.yh.component.workflow.vo.DrawingBaseInfoText;
import com.yh.component.workflow.vo.DrawingFlow;
import com.yh.component.workflow.vo.DrawingFlowRule;
import com.yh.component.workflow.vo.DrawingFlowRuleText;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.StringUtil;
import com.yh.platform.core.web.UserContext;
/**
 * @desc 流程-模板管理ServiceImpl
 * @author liul
 * @createDate 2017-11-15
 */
public class WorkflowConfigurationServiceImpl implements WorkflowConfigurationService{
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#listWorkflowConfiguration(com.yh.component.taglib.TableTagBean)
	 */
	public List<JSONObject> listWorkflowTemplet(TableTagBean ttb)
			throws ServiceException {
		// TODO Auto-generated method stub
		return WorkflowConfigurationQueryHelper.listWorkflowTemplet(ttb);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#get(java.lang.Long)
	 */
	public WorkflowConfigurationDTO getTempletInfo(String templetId) throws ServiceException {
		// TODO Auto-generated method stub
		WorkflowConfigurationDTO dto = new WorkflowConfigurationDTO();
		//获取模板信息
		FileTemplate bo =DaoUtil.get(FileTemplate.class, templetId);
		bo.setTemplateType(bo.getTemplateType()==null?"":DicHelper.viewName(WorkFlowConfigurationUtil.YHRS4003, bo.getTemplateType()));
		BeanUtils.copyProperties(bo, dto);
		//获取流程信息 （并获取流程是否能删除标识？？？？？）
		List<WorkflowBaseInfoDTO> list= WorkflowConfigurationQueryHelper.listFlowBaseInfo(templetId);
		dto.setBaseInfoList(list);
		return dto;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#getBaseFlowInfo(java.lang.Long)
	 */
	public WorkflowConfigurationDTO getBaseFlowInfo(String baseInfoId) throws ServiceException {
		// TODO Auto-generated method stub
		WorkflowConfigurationDTO dto = new WorkflowConfigurationDTO();
		//根据流程Id获取流程信息yhf_flow
		Flow bo= DaoUtil.get(Flow.class, baseInfoId);
		BeanUtils.copyProperties(bo, dto);
		//根据流程Id获取活动列表yhf_flow_activity
		List<WorkflowActivityDTO> activityList= WorkflowConfigurationQueryHelper.listFlowActivity(baseInfoId);
		//根据流程ID获取规则列表yhf_flow_rule
		List<WorkflowRuleDTO> ruleList= WorkflowConfigurationQueryHelper.listFlowRule(baseInfoId);
		dto.setActivityList(activityList);
		dto.setRuleList(ruleList);
		return dto;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#findOrg()
	 */
	public List<WorkflowBaseInfoDTO> findOrg(TableTagBean ttb) throws ServiceException {
		// TODO Auto-generated method stub
		return WorkflowConfigurationQueryHelper.findOrg(ttb);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#insert(com.yh.component.workflow.dto.WorkflowConfigurationDTO)
	 */
	public String insertTemplet(WorkflowConfigurationDTO workflowConfigurationDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FileTemplate bo=new FileTemplate();
		BeanUtils.copyProperties(workflowConfigurationDto, bo);
		bo.setTemplateId(StringUtil.getUUID());
		bo.save();
		return bo.getTemplateId();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#update(com.yh.component.workflow.dto.WorkflowConfigurationDTO)
	 */
	public String updateTemplet(WorkflowConfigurationDTO workflowConfigurationDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FileTemplate bo=new FileTemplate();
		BeanUtils.copyProperties(workflowConfigurationDto, bo);
		bo.update();
		return bo.getTemplateId();
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#delete(java.lang.Long)
	 */
	public void deleteTemplet(String templetId) throws ServiceException {
		// TODO Auto-generated method stub
		FileTemplate bo=DaoUtil.get(FileTemplate.class, templetId);
		if(bo!=null){
			bo.delete();
		}
	}
	/**
	 * 新增流程信息
	 * @param df
	 * @param originalFlow
	 * @throws ServiceException
	 */
	private void insertFlow(DrawingFlow df,Flow originalFlow) throws ServiceException {
		
		//1、流程信息
		Flow flowBo = new Flow();
		toBO(df,flowBo,originalFlow);
		flowBo.save();
		//2、模板-流程关联信息
		TemplateFlow tfBo = new TemplateFlow();
		toBO(df,tfBo,flowBo.getFlowId());
		tfBo.save();
		//3、活动信息
		List<DrawingBaseInfo> dbiList = df.getDbiList();
		if(CollectionUtils.isNotEmpty(dbiList)){
			for(DrawingBaseInfo dbi:dbiList){
				DrawingBaseInfoText dbit = dbi.getText();
				DrawingBaseInfoRuleProps dbirp = dbi.getRuleProps();
				//创建主活动
				FlowActivity fa = new FlowActivity();
				fa.setActId(dbi.getId());
				fa.setFlowId(flowBo.getFlowId());
				fa.setActName(dbit.getText());
				fa.setActType(dbi.getType());
				if(dbirp != null){
					fa.setActOrder(Integer.parseInt(dbirp.getActivityNo())); //活动序号
					//fa.setActResult(actResult); // 活动结果
					//fa.setActBeginRuleId(actBeginRuleId); // 前置规则
					//fa.setActEndRuleId(actEndRuleId); // 后置规则
					fa.setActBackType(dbirp.getBackWay()); //退回方式
					//fa.setActFinishType(actFinishType); // 结束方式
					fa.setActAuditContent(dbirp.getContent());
				}
				fa.save();
				//活动附属表
				if(dbirp != null){
					//权限控制
					FlowActivityPermission apBo = new FlowActivityPermission();
					apBo.setActId(dbi.getId());
					apBo.setApCanCarbanCopy(dbirp.getAllowCopy());
					apBo.setApCanCoordination(dbirp.getAllowSynergy());
					apBo.setApCanFinish(dbirp.getAllowEnd());
					apBo.setApCanRetroactive(dbirp.getAllowRetroactive());
					apBo.setApCanSkip(dbirp.getAllowCountersign());
					apBo.setApId(StringUtil.getUUID());
					apBo.setApUserType(dbirp.getHandlers());
					apBo.save();
					//权限控制-权限组合
					JSONArray orgInfo = dbirp.getOrgInfo(); // 部门
					JSONArray groupInfo = dbirp.getGroupInfo(); // 小组
					JSONArray roleInfo = dbirp.getRoleInfo(); // 角色
					if(orgInfo.size() != 0){
						for(int i=0; i<orgInfo.size();i++){
							FlowActivityPerCombination pcBo = new FlowActivityPerCombination();
							pcBo.setApId(apBo.getApId());
							pcBo.setPcFieldId(orgInfo.getString(i)); // 组合值ID
							pcBo.setPcFieldValue(orgInfo.toString()); // 组合字段值
							pcBo.setPcId(StringUtil.getUUID());
							pcBo.setPcType(WorkFlowConfigurationUtil.PC_TYPE_ORG); // 组合类别-部门、小组、角色、岗位、职务、职务等级
						}
						
					}
					if(groupInfo.size() != 0){
						for(int i=0; i<orgInfo.size();i++){
							FlowActivityPerCombination pcBo = new FlowActivityPerCombination();
							pcBo.setApId(apBo.getApId());
							pcBo.setPcFieldId(orgInfo.getString(i)); // 组合值ID
							pcBo.setPcFieldValue(groupInfo.toString()); // 组合字段值
							pcBo.setPcId(StringUtil.getUUID());
							pcBo.setPcType(WorkFlowConfigurationUtil.PC_TYPE_GROUP); // 组合类别-部门、小组、角色、岗位、职务、职务等级
						}
					}
					if(roleInfo.size() != 0){
						for(int i=0; i<roleInfo.size();i++){
						FlowActivityPerCombination pcBo = new FlowActivityPerCombination();
						pcBo.setApId(apBo.getApId());
						pcBo.setPcFieldId(orgInfo.getString(i)); // 组合值ID
						pcBo.setPcFieldValue(roleInfo.toString()); // 组合字段值
						pcBo.setPcId(StringUtil.getUUID());
						pcBo.setPcType(WorkFlowConfigurationUtil.PC_TYPE_ROLE); // 组合类别-部门、小组、角色、岗位、职务、职务等级
						}
					}
					//任务通知
					if(dbirp.getIsMessage()){//任务创建人通知
						FlowActivityNotice anBo = new FlowActivityNotice();
						anBo.setActId(dbi.getId());
						anBo.setAnContent(dbirp.getIsMessageTemp());
						anBo.setAnId(StringUtil.getUUID());
						anBo.setAnMode(dbirp.getNotification()?"Tel":null); //如果为true 则是开启短信通知
						anBo.setAnState(dbirp.getIsMessage()?1d:0d); 
						anBo.setAnType(WorkFlowConfigurationUtil.IsMessage);
						anBo.save();
					}
					if(dbirp.getIsMessageNext()){//下一处理人通知
						FlowActivityNotice anBo = new FlowActivityNotice();
						anBo.setActId(dbi.getId());
						anBo.setAnContent(dbirp.getIsMessageTempNext());
						anBo.setAnId(StringUtil.getUUID());
						anBo.setAnMode(dbirp.getNotification()?"Tel":null); //如果为true 则是开启短信通知
						anBo.setAnState(dbirp.getIsMessageNext()?1d:0d);
						anBo.setAnType(WorkFlowConfigurationUtil.IsMessageNext);
						anBo.save();
					}
					if(dbirp.getIsMessageHistory()){//历史处理人通知
						FlowActivityNotice anBo = new FlowActivityNotice();
						anBo.setActId(dbi.getId());
						anBo.setAnContent(dbirp.getIsMessageTempHistory());
						anBo.setAnId(StringUtil.getUUID());
						anBo.setAnMode(dbirp.getNotification()?"Tel":null); //如果为true 则是开启短信通知
						anBo.setAnState(dbirp.getIsMessageHistory()?1d:0d);
						anBo.setAnType(WorkFlowConfigurationUtil.IsMessageHistory);
						anBo.save();
					}
				}
				
			}
		}
		//规则信息
		List<DrawingFlowRule> dfrList = df.getDfrList();
		if(CollectionUtils.isNotEmpty(dfrList)){
			for(DrawingFlowRule dfr:dfrList){
				DrawingFlowRuleText dfrt = dfr.getText();
				//规则主信息
				FlowRule ruleBo = new FlowRule();
				ruleBo.setFlowId(flowBo.getFlowId());
				ruleBo.setRuleBeginActId(dfr.getFrom());
				//ruleBo.setRuleCondition(); // 规则构造流转条件
				ruleBo.setRuleEndActId(dfr.getTo());
				ruleBo.setRuleId(dfr.getId());
				ruleBo.setRuleName(dfrt.getText());
				//ruleBo.setRuleOrder(); // 规则序号
				//ruleBo.setRuleSysType(); // 规则系统类型
				//ruleBo.setRuleType(); // 规则类型
				ruleBo.save();
			}
		}
	}
	/**
	 * 对象————对象
	 * @param <T>
	 * @param t
	 * @return
	 * @throws ServiceException
	 */
	private static <T> void toBO(DrawingFlow df,T t,T params) throws ServiceException {
		if(t != null){
			if(t instanceof Flow){//1、流程信息
				Flow flowBo=(Flow)t;
				Flow originalFlow=(Flow)params;
				flowBo.setFlowId(StringUtils.isEmpty(df.getFlowId())?StringUtil.getUUID():df.getFlowId());
				if(originalFlow != null){
					flowBo.setFlowCreateDate(originalFlow.getFlowCreateDate());
					flowBo.setFlowCreateUserID(originalFlow.getFlowCreateUserID());
					flowBo.setFlowCreateUserName(originalFlow.getFlowCreateUserName());
					flowBo.setFlowModifyDate(DateUtil.now());
					flowBo.setFlowModifyUserID(UserContext.getLoginUserID());
					flowBo.setFlowModifyUserName(UserContext.getLoginUserName());
				}else{
					flowBo.setFlowCreateDate(DateUtil.now());
					flowBo.setFlowCreateUserID(UserContext.getLoginUserID());
					flowBo.setFlowCreateUserName(UserContext.getLoginUserName());
				}
				flowBo.setFlowName(df.getFlowName());
				flowBo.setFlowType(df.getFlowType());
				flowBo.setFlowOrgOid(df.getFlowOrgOid());
				flowBo.setFlowOrgName(df.getFlowOrgName());
				flowBo.setFlowData(df.getFlowData());
				//return flowBo;
			}else if(t instanceof TemplateFlow){//2、模板-流程关联信息
				TemplateFlow tfBo=(TemplateFlow)t;
				tfBo.setTfId(StringUtil.getUUID());
				tfBo.setTemplateId(df.getTemplateId());
				tfBo.setFlowId((String)params);
			}else if(t instanceof FlowActivityPermission){//1、权限控制信息
				
			}else if(t instanceof FlowActivityPerCombination){
				
			}else if(t instanceof FlowActivityNotice){//2、任务通知
				
			}
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#deleteFlow(java.lang.String)
	 */
	public void deleteFlow(String flowId) throws ServiceException {
		// TODO Auto-generated method stub
		//根据flowId 删除规则信息、活动信息、流程信息
		StringBuffer sb = new StringBuffer();
		//活动信息-权限控制信息表
		sb.append("delete from yhf_per_combination where ap_id in (select ap_id from yhf_flow_activity_permission where act_id in (select fa.act_id from yhf_flow_activity fa where fa.flow_id = '"+flowId+"'));");
		sb.append("delete from yhf_flow_activity_permission where act_id in (select fa.act_id from yhf_flow_activity fa where fa.flow_id = '"+flowId+"');");
		//活动信息-任务通知信息表
		sb.append("delete from yhf_flow_activity_notice where act_id in (select fa.act_id from yhf_flow_activity fa where fa.flow_id = '"+flowId+"');");
		
		//规则信息表
		sb.append("delete from yhf_flow_activity where flow_id = '"+flowId+"';");
		//规则信息表
		sb.append("delete from yhf_flow_rule where flow_id = '"+flowId+"';");
		//模板-流程关联信息表
		sb.append("delete from yhf_template_flow where flow_id = '"+flowId+"';");
		DaoUtil.executeSqlUpdate(sb.toString());
		//流程信息
		Flow bo=DaoUtil.get(Flow.class, flowId);
		if(bo!=null){
			bo.delete();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#saveRuleFlow(com.yh.component.workflow.vo.DrawingFlow)
	 */
	public void saveRuleFlow(DrawingFlow df) throws ServiceException {
		if(df != null){
			if(StringUtils.isEmpty(df.getFlowId())){
				this.insertFlow(df,null);
			}else{//修改
				//获取创建人信息
				Flow originalFlow = DaoUtil.get(Flow.class, df.getFlowId());
				this.deleteFlow(df.getFlowId());
				this.insertFlow(df,originalFlow);
			}
			
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#getFlow(java.lang.String)
	 */
	public WorkflowBaseInfoDTO getFlow(String flowId) throws ServiceException {
		WorkflowBaseInfoDTO dto = new WorkflowBaseInfoDTO();
		//根据流程Id获取流程信息yhf_flow
		Flow bo= DaoUtil.get(Flow.class, flowId);
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
}
