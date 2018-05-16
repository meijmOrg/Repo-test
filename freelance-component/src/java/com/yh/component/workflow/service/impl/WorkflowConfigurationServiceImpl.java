package com.yh.component.workflow.service.impl;



import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
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
import com.yh.component.workflow.vo.DrawingBaseInfo;
import com.yh.component.workflow.vo.DrawingBaseInfoRuleProps;
import com.yh.component.workflow.vo.DrawingBaseInfoText;
import com.yh.component.workflow.vo.DrawingFlow;
import com.yh.component.workflow.vo.DrawingFlowRule;
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
/*	public void updateFlow(WorkflowConfigurationDTO workflowConfigurationDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		TableTagBean ttb = new TableTagBean();
		String str = "{states:{rect1514343249391:{type:'state',ID:'',text:{text:'活动名称'}, attr:{ x:551, y:96, width:100, height:50}, props:{text:{value:'活动名称'},temp1:{value:'活动序号'},temp2:{value:'1'},temp3:{value:'1'},temp4:{value:'1'},temp5:{value:'活动名称'}}},rect1514343253157:{type:'state',ID:'',text:{text:'活动名称2'}, attr:{ x:824, y:119, width:100, height:50}, props:{text:{value:'活动名称2'},temp1:{value:'活动序号2'},temp2:{value:'2'},temp3:{value:'2'},temp4:{value:'2'},temp5:{value:'活动名称2'}}}},paths:{path1514343258269:{lineID:'',from:'rect1514343249391',to:'rect1514343253157', dots:[],text:{text:'线',textPos:{x:0,y:-10}}, props:{text:{value:'线'}}}}}";
		ttb.getCondition().put("json", str);
		//解析json  解析过程中验证所画流程是否符合要求？？？？？？
		1、为空验证
		 * 2、连接验证（除开始和结束外的活动需有前置规则和后置规则，规则线必须有前置活动与后置活动信息）
		
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
		Flow bo=new Flow();
		BeanUtils.copyProperties(workflowConfigurationDto, bo);
		bo.update();

	}*/
	private static void insertFlow(DrawingFlow df,Flow originalFlow) throws ServiceException {
		
		//1、流程信息
		Flow flowBo = new Flow();
		toBO(df,flowBo,originalFlow);
		flowBo.save();
		//2、模板-流程关联信息
		TemplateFlow tfBo = new TemplateFlow();
		toBO(df,tfBo,flowBo.getFlowId());
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
	/**
	 * 对象————对象
	 * @param <T>
	 * @param t
	 * @return
	 * @throws ServiceException
	 */
	private static <T> void toBO(DrawingFlow df,T t,T params) throws ServiceException {
		if(t != null){
			//活动信息
			List<DrawingBaseInfo> dbiList = df.getDbiList();
			if(CollectionUtils.isNotEmpty(dbiList)){
				for(DrawingBaseInfo dbi:dbiList){
					dbi.getAttr();
					DrawingBaseInfoText dbit = dbi.getText();
					DrawingBaseInfoRuleProps dbirp = dbi.getRuleProps();
					//创建主活动
					FlowActivity fa = new FlowActivity();
					fa.setActId(StringUtil.getUUID());
					fa.setFlowId(dbi.getId());
					fa.setActName(dbit.getText());
					fa.setActType(dbi.getType());
					if(dbirp != null){
						fa.setActOrder(Integer.parseInt(dbirp.getActivityNo())); //活动序号
						//fa.setActResult(actResult); // 活动序号
						//fa.setActBeginRuleId(actBeginRuleId); // 前置规则
						//fa.setActEndRuleId(actEndRuleId); // 后置规则
						fa.setActBackType(dbirp.getBackWay()); //退回方式
						//fa.setActFinishType(actFinishType); // 结束方式
						fa.setActAuditContent(dbirp.getContent());
					}
				}
			}
			//规则信息
			List<DrawingFlowRule> dfrList = df.getDfrList();
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
				//return flowBo;
			}else if(t instanceof TemplateFlow){//2、模板-流程关联信息
				TemplateFlow tfBo=(TemplateFlow)t;
				tfBo.setTfId(StringUtil.getUUID());
				tfBo.setTemplateId(df.getTemplateId());
				tfBo.setFlowId((String)params);
			}else if(t instanceof FlowActivity){//3、活动信息
				FlowActivity actBo = new FlowActivity();
				actBo.setActId(StringUtil.getUUID());
				actBo.setFlowId((String)params);
				//其他信息
				//actBo.setActAuditContent(actAuditContent);
			}else if(t instanceof FlowRule){//4、规则信息
				FlowRule ruleBo = new FlowRule();
				ruleBo.setRuleId(StringUtil.getUUID());
				ruleBo.setFlowId((String)params);
					//其他信息
				//ruleBo.setActAuditContent(actAuditContent);
				ruleBo.save();
			}else if(t instanceof FlowActivityPermission){//1、权限控制信息
				
			}else if(t instanceof FlowActivityPerCombination){
				
			}else if(t instanceof FlowActivityNotice){//2、任务通知
				
			}
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.yh.component.workflow.service.WorkflowConfigurationService#deleteFlow(java.lang.Long)
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
		String flag = "insert"; //update
		if(df != null){
			if(StringUtils.isNotEmpty(flag)&&flag.equals("update")&&StringUtils.isEmpty(df.getFlowId())){
					throw new ServiceException(null,"flowId is null");
			}else if(StringUtils.isNotEmpty(flag)&&flag.equals("update")&&StringUtils.isNotEmpty(df.getFlowId())){//修改
				//获取创建人信息
				Flow originalFlow = DaoUtil.get(Flow.class, df.getFlowId());
				this.deleteFlow(df.getFlowId());
				this.insertFlow(df,originalFlow);
			}else{//新增
				this.insertFlow(df,null);
			}
		}
	}
}
