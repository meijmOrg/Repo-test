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
		String sql = "select yft.templet_id,yft.templet_name,yft.templet_code,yft.templet_Type,yft.flow_process_page,yft.synergy_process_page,yft.document_edit_page,yft.document_detail_page,yft.document_print_page from yhf_flow_templet yft";
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
			json.put("templetId", obj[0]==null?"":obj[0].toString());
			json.put("templetName", obj[1]==null?"":obj[1].toString());
			json.put("templetCode", obj[2]==null?"":obj[2].toString());
			json.put("templetType", obj[3]==null?"":obj[3].toString());
			json.put("flowProcessPage", obj[4]==null?"":obj[4].toString());//流程处理页面
			json.put("synergyProcessPage", obj[5]==null?"":obj[5].toString());//协同处理页面
			json.put("documentEditPage", obj[6]==null?"":obj[6].toString());//文档编辑页面
			json.put("documentDetailPage", obj[7]==null?"":obj[7].toString());//文档详细页面
			json.put("documentPrintPage", obj[8]==null?"":obj[8].toString());//文档打印页面
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
	public static List<WorkflowBaseInfoDTO> listFlowBaseInfo(Long templetId) throws DataAccessFailureException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hql = new StringBuffer("from WorkflowBaseInfo yfbi where yfbi.templetId = '"+templetId+"'");
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
	public static List<WorkflowActivityDTO> listFlowActivity(Long baseInfoId) throws DataAccessFailureException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hql = new StringBuffer("from WorkflowActivity yfa where yfa.baseInfoId = '"+baseInfoId+"'");
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
	public static List<WorkflowRuleDTO> listFlowRule(Long baseInfoId) throws DataAccessFailureException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hql =new StringBuffer("from WorkflowRule yfu where yfu.baseInfoId = '"+baseInfoId+"'");
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
