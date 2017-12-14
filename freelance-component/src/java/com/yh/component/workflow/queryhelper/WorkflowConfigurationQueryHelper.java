package com.yh.component.workflow.queryhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.WorkflowActivityDTO;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.component.workflow.dto.WorkflowConfigurationDTO;
import com.yh.component.workflow.dto.WorkflowRuleDTO;
import com.yh.component.workflow.utils.WorkFlowConfigurationUtil;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.DataAccessFailureException;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
/**
 * @desc 动态字段QueryHelper
 * @author liul
 * @createDate 2017-11-16
 */
public class WorkflowConfigurationQueryHelper {

	/**
	 * 获取模板列表
	 * @param ttb
	 * @return
	 * @throws ServiceException 
	 */
	public static List<JSONObject> listWorkflowTemplet(TableTagBean ttb) throws ServiceException{
		Map<String,Object> params = new HashMap<String,Object>();
		String sql = "select yft.template_Id,yft.template_Name,yft.template_Code,yft.template_Is_Universal,yft.template_Type,yft.template_Create_Page,yft.template_Edit_Page,yft.template_Info_Page,yft.template_Flow_Page,yft.template_Report_Page,yft.template_Create_Date,yft.template_Create_User_Name,yft.template_Modify_Date,yft.template_Modify_User_Name,yft.template_Description from yhf_file_template yft";
		if (ttb.getPageSize() != 0) {
			ttb.setTotal(DaoUtil.countWithSQLByCondition((new StringBuilder().append("select count(*) from (").append(sql).append(") as total").toString()), params));
		}
		List<Object[]> list = DaoUtil.listWithSQLByCondition(sql, params, ttb.getPage(), ttb.getPageSize());
		return buildJSON(list);
	}  
	/**
	 * object to JSONObject
	 * @param list
	 * @return
	 * @throws DataAccessFailureException
	 * @throws ServiceException
	 */
	private static List<JSONObject> buildJSON(List<Object[]> list) throws DataAccessFailureException,ServiceException
	{
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		for(Object[] obj:list){
			JSONObject json = new JSONObject();
			json.put("templateId", obj[0]==null?"":obj[0].toString());
			json.put("templateName", obj[1]==null?"":obj[1].toString());	//模板名称	
			json.put("templateCode", obj[2]==null?"":obj[2].toString());//编码
			json.put("templateIsUniversal", obj[3]==null?"":obj[3].toString());//是否通用模板
			json.put("templateType", obj[4]==null?"":obj[4].toString());//模板类别
			json.put("templateCreatePage", obj[5]==null?"":obj[5].toString());//创建页面
			json.put("templateEditPage", obj[6]==null?"":obj[6].toString());//编辑页面
			json.put("templateInfoPage", obj[7]==null?"":obj[7].toString());//详细页面
			json.put("templateFlowPage", obj[8]==null?"":obj[8].toString());//流程页面
			json.put("templateReportPage", obj[9]==null?"":obj[9].toString());//报表页面
			json.put("templateCreateDate", obj[10]==null?"":obj[10].toString());//创建时间
			json.put("templateCreateUserName", obj[11]==null?"":obj[11].toString());//创建人
			json.put("templateModifyDate", obj[12]==null?"":obj[12].toString());//修改时间
			json.put("templateModifyUserName", obj[13]==null?"":obj[13].toString());//修改人
			json.put("templateDescription", obj[14]==null?"":obj[14].toString());//模板描述
			jsonList.add(json);
		}
		
		return jsonList;
	}
	/**
	 * 根据模板id获取流程信息list
	 * @param templetId
	 * @return
	 * @throws DataAccessFailureException
	 */
	public static List<WorkflowBaseInfoDTO> listFlowBaseInfo(String templetId) throws DataAccessFailureException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hql = new StringBuffer("from com.yh.component.workflow.bo.Flow f,TemplateFlow tf where tf.flowId = f.flowId and tf.templateId = '"+templetId+"'");
		//流程排序
		//hql.append(" order by	");
		List<WorkflowBaseInfoDTO> list = DaoUtil.listByCondition(hql.toString(), params, 0, 0);
		return list;
	}
	/**
	 * 根据流程Id获取活动列表yhf_flow_activity
	 * @param baseInfoId
	 * @return
	 * @throws DataAccessFailureException
	 */
	public static List<WorkflowActivityDTO> listFlowActivity(String baseInfoId) throws DataAccessFailureException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hql = new StringBuffer("from FlowActivity fa where fa.flowId = '"+baseInfoId+"'");
		//活动排序
		//hql.append(" order by	");
		List<WorkflowActivityDTO> list = DaoUtil.listByCondition(hql.toString(), params, 0, 0);
		return list;
	}
	/**
	 * 根据流程ID获取规则列表yhf_flow_rule
	 * @param baseInfoId
	 * @return
	 * @throws DataAccessFailureException
	 */
	public static List<WorkflowRuleDTO> listFlowRule(String baseInfoId) throws DataAccessFailureException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hql =new StringBuffer("from FlowRule fu where fu.flowId = '"+baseInfoId+"'");
		//规则排序
		//hql.append(" order by	");
		List<WorkflowRuleDTO> list = DaoUtil.listByCondition(hql.toString(), params, 0, 0);
		return list;
	}
	/**
	 * 获取部门信息
	 * @return
	 * @throws ServiceException 
	 */
	public static List<WorkflowBaseInfoDTO> findOrg(TableTagBean ttb)  throws ServiceException{
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from UbOrg ub where ub.parentOrgOid is not null ");
		hql.append(" and ub.unitOid in(select unitOid from UbUnit where unitStatus = '"+WorkFlowConfigurationUtil.YHRS0101_2+"')");
		hql.append(" and ub.parentOrgOid in (select orgOid from UbOrg where orgType in(select orgType from UbOrg where parentOrgOid is null))");
		if(StringUtils.isNotEmpty(ttb.getCondition().get("orgName").trim())){
			hql.append(" and ub.orgName like '%"+ttb.getCondition().get("orgName").trim()+"%'");
			
		}
		hql.append(" order by ub.orgOid");
		if(ttb.getPageSize() != 0) {
			ttb.setTotal(DaoUtil.countByCondition(new StringBuilder("select count(*) ").append(hql).toString(), params));
		}
		
		return BeanHelper.copyProperties(DaoUtil.listByCondition(
				new StringBuilder().append(hql).toString(), params, ttb.getPage(), ttb.getPageSize()), WorkflowBaseInfoDTO.class);
	}  
}
