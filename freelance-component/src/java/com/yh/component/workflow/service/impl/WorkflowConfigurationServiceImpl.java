package com.yh.component.workflow.service.impl;



import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

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
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.JSONHelper;
import com.yh.platform.core.util.StringUtil;
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
		//根据流程Id获取流程信息yhf_flow_base_info
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
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#updateFlow(com.yh.component.workflow.dto.WorkflowConfigurationDTO)
	 */
	@SuppressWarnings("unchecked")
	public void updateFlow(WorkflowConfigurationDTO workflowConfigurationDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		TableTagBean ttb = new TableTagBean();
		String str = "{states:{rect1514343249391:{type:'state',ID:'',text:{text:'活动名称'}, attr:{ x:551, y:96, width:100, height:50}, props:{text:{value:'活动名称'},temp1:{value:'活动序号'},temp2:{value:'1'},temp3:{value:'1'},temp4:{value:'1'},temp5:{value:'活动名称'}}},rect1514343253157:{type:'state',ID:'',text:{text:'活动名称2'}, attr:{ x:824, y:119, width:100, height:50}, props:{text:{value:'活动名称2'},temp1:{value:'活动序号2'},temp2:{value:'2'},temp3:{value:'2'},temp4:{value:'2'},temp5:{value:'活动名称2'}}}},paths:{path1514343258269:{lineID:'',from:'rect1514343249391',to:'rect1514343253157', dots:[],text:{text:'线',textPos:{x:0,y:-10}}, props:{text:{value:'线'}}}}}";
		ttb.getCondition().put("json", str);
		//解析json  解析过程中验证所画流程是否符合要求？？？？？？
		/*1、为空验证
		 * 2、连接验证（除开始和结束外的活动需有前置规则和后置规则，规则线必须有前置活动与后置活动信息）
		*/
		JSONObject json = JSONHelper.fromObject(ttb.getCondition().get("json"));
		Iterator<String> flowIt = json.keys();  
        while(flowIt.hasNext()){  
        	//流程信息：活动和规则
            String flowKey = flowIt.next();
            if(StringUtils.isNotEmpty(flowKey)&&flowKey.equals("states")){
        		//1、解析活动信息
            	JSONObject actJson = JSONHelper.fromObject(json.getString(flowKey));
            	Iterator<String> actIt = actJson.keys();
            	while(actIt.hasNext()){
            		//活动属性
            		String actKey = actIt.next();
            		//基本属性 yhf_flow_activity
            		FlowActivity actBo = new FlowActivity();
            		//权限控制信息 yhf_flow_activity_permission  yhf_per_combination
            		FlowActivityPermission apBo = new FlowActivityPermission();
            		FlowActivityPerCombination pcBo = new FlowActivityPerCombination();
            		//任务通知信息 yhf_flow_activity_notice
            		FlowActivityNotice anBo = new FlowActivityNotice();
            	}
        	}else if(StringUtils.isNotEmpty(flowKey)&&flowKey.equals("paths")){
        		//1、解析规则信息
        		JSONObject ruleJson = JSONHelper.fromObject(json.getString(flowKey));
				Iterator<String> ruleIt = ruleJson.keys();
            	while(ruleIt.hasNext()){
            		//规则属性
            		String ruleKey = ruleIt.next();
            		//基本属性 yhf_flow_rule (yhf_flow_key_word???)
            		FlowRule ruleBo = new FlowRule();
            		FlowKeyWord kwBo = new FlowKeyWord();
            		//构置转移条件信息
            		
            	}
        	}
            //流程基本信息？？？yhf_flow
            Flow flowBo = new Flow();
        }  
        String templateId = ttb.getCondition().get("templateId");
        String flowId = ttb.getCondition().get("flowId");
        if(StringUtils.isNotEmpty(templateId)){
        	WorkflowBaseInfoDTO workflowBaseInfoDTO = new WorkflowBaseInfoDTO();
        	if(StringUtils.isNotEmpty(flowId)){
        		//1、验证（该流程已经开始使用---提示不可修改）
        		//2、删除流程 再新增流程
        		this.deleteFlow(Long.valueOf(flowId));
        		this.insertFlow(workflowBaseInfoDTO);
        	}else{
        		//1、新增流程
        		this.insertFlow(workflowBaseInfoDTO);
        	}
        }
        //新增
		/*Flow bo=new Flow();
		BeanUtils.copyProperties(workflowConfigurationDto, bo);
		bo.update();*/

	}
	public void insertFlow(WorkflowBaseInfoDTO workflowBaseInfoDTO)
	throws ServiceException {
		//1、流程信息
		Flow flowBo=new Flow();
		BeanUtils.copyProperties(workflowBaseInfoDTO, flowBo);
		flowBo.setFlowId(StringUtil.getUUID());
		flowBo.save();
		//2、模板-流程关联信息
		TemplateFlow tfBo = new TemplateFlow();
		tfBo.setTfId(StringUtil.getUUID());
		tfBo.setTemplateId(workflowBaseInfoDTO.getTemplateId());
		tfBo.setFlowId(flowBo.getFlowId());
		tfBo.save();
		//3、活动信息
		FlowActivity actBo = new FlowActivity();
		actBo.setActId(StringUtil.getUUID());
		actBo.setFlowId(flowBo.getFlowId());
			//其他信息
		//actBo.setActAuditContent(actAuditContent);
		actBo.save();
		//4、规则信息
		FlowRule ruleBo = new FlowRule();
		ruleBo.setRuleId(StringUtil.getUUID());
		ruleBo.setFlowId(flowBo.getFlowId());
			//其他信息
		//ruleBo.setActAuditContent(actAuditContent);
		ruleBo.save();
		//1、权限控制信息
		FlowActivityPermission apBo = new FlowActivityPermission();
		FlowActivityPerCombination pcBo = new FlowActivityPerCombination();
		//2、任务通知
		FlowActivityNotice anBo = new FlowActivityNotice();
		
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#deleteFlow(java.lang.Long)
	 */
	public void deleteFlow(Long flowId) throws ServiceException {
		// TODO Auto-generated method stub
		//根据flowId 删除规则信息、活动信息、流程信息
		StringBuffer sb = new StringBuffer();
		//活动信息-权限控制信息
		sb.append("delete from yhf_per_combination where ap_id in (select ap_id from yhf_flow_activity_permission where act_id in (select fa.act_id from yhf_flow_activity fa where fa.flow_id = '"+flowId+"'));");
		sb.append("delete from yhf_flow_activity_permission where act_id in (select fa.act_id from yhf_flow_activity fa where fa.flow_id = '"+flowId+"');");
		//活动信息-任务通知信息
		sb.append("delete from yhf_flow_activity_notice where act_id in (select fa.act_id from yhf_flow_activity fa where fa.flow_id = '"+flowId+"');");
		//规则信息
		sb.append("delete from yhf_flow_rule where flow_id = '"+flowId+"';");
		DaoUtil.executeSqlUpdate(sb.toString());
		//流程信息
		Flow bo=DaoUtil.get(Flow.class, flowId);
		if(bo!=null){
			bo.delete();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#insertRule(com.yh.component.workflow.dto.WorkflowRuleDTO)
	 
	public void insertRule(WorkflowRuleDTO workflowRuleDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FlowRule bo=new FlowRule();
		BeanUtils.copyProperties(workflowRuleDto, bo);
		bo.setRuleId(StringUtil.getUUID());
		bo.save();
	}
	
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#updateRule(com.yh.component.workflow.dto.WorkflowRuleDTO)
	 
	public void updateRule(WorkflowRuleDTO workflowRuleDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FlowRule bo=new FlowRule();
		BeanUtils.copyProperties(workflowRuleDto, bo);
		bo.update();
	}
	
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#deleteRule(java.lang.Long)
	 
	public void deleteRule(Long ruleId) throws ServiceException {
		// TODO Auto-generated method stub
		FlowRule bo=DaoUtil.get(FlowRule.class, ruleId);
		if(bo!=null){
			bo.delete();
		}
	}
	
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#getRuleInfo(java.lang.Long)
	 
	public WorkflowRuleDTO getRuleInfo(Long ruleId)
			throws ServiceException {
		// TODO Auto-generated method stub
		WorkflowRuleDTO dto = new WorkflowRuleDTO();
		//获取规则信息
		FlowRule bo =DaoUtil.get(FlowRule.class, ruleId);
		BeanUtils.copyProperties(bo, dto);
		//获取构置转移条件信息 
		//List<WorkflowBaseInfoDTO> list= WorkflowConfigurationQueryHelper.listFlowBaseInfo(templetId);
		//dto.setBaseInfoList(list);
		return dto;
	}
	
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#insertActivity(com.yh.component.workflow.dto.WorkflowActivityDTO)
	 
	public void insertActivity(WorkflowActivityDTO workflowActivityDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FlowActivity bo=new FlowActivity();
		BeanUtils.copyProperties(workflowActivityDto, bo);
		bo.setActId(StringUtil.getUUID());
		bo.save();
	}
	
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#updateActivity(com.yh.component.workflow.dto.WorkflowActivityDTO)
	 
	public void updateActivity(WorkflowActivityDTO workflowActivityDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		FlowActivity bo=new FlowActivity();
		BeanUtils.copyProperties(workflowActivityDto, bo);
		bo.update();
	}
	
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#deleteActivity(java.lang.Long)
	 
	public void deleteActivity(Long activityId) throws ServiceException {
		// TODO Auto-generated method stub
		FlowActivity bo=DaoUtil.get(FlowActivity.class, activityId);
		if(bo!=null){
			bo.delete();
		}
	}
	
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#getActivityInfo(java.lang.Long)
	 
	public WorkflowActivityDTO getActivityInfo(Long activityId)
			throws ServiceException {
		// TODO Auto-generated method stub
		WorkflowActivityDTO dto = new WorkflowActivityDTO();
		//获取活动信息
		FlowActivity bo =DaoUtil.get(FlowActivity.class, activityId);
		BeanUtils.copyProperties(bo, dto);
		//获取权限控制信息 
		//List<WorkflowBaseInfoDTO> list= WorkflowConfigurationQueryHelper.listFlowBaseInfo(templetId);
		//dto.setBaseInfoList(list);
		//获取任务通知信息
		return dto;
	}*/
}
