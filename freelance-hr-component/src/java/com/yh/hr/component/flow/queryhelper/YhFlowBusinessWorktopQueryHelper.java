package com.yh.hr.component.flow.queryhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.yh.component.dictionary.utils.DicHelper;
import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.utils.WorkFlowConfigurationUtil;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.DataAccessFailureException;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.web.UserContext;


/**
 * 
 * @ClassName: YhFlowBusinessWorktopQueryHelper 
 * @Description: 业务工作台queryHelper
 * @author: liul
 * @date: 2018-5-29 上午10:23:08
 */
public class YhFlowBusinessWorktopQueryHelper {

	/** 
	* @Title: listBusinessInfo 
	* @Description: TODO 
	* @param ttb
	* @return List<JSONObject>
	*/ 
	public static List<JSONObject> listBusinessInfo(TableTagBean ttb) throws ServiceException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer strbuf = new StringBuffer();
		
		String dataType = ttb.getCondition().get("dataType");
		if(dataType.equals("daiban")){
			//待办
			strbuf.append(getDBSqlByFile("'0'"));
			strbuf.append(" union all ");
			strbuf.append(getDBSqlByFileAndTask("'0','1','4','5','6'")); 
		}else if(dataType.equals("yiban")){
			//已办 
			strbuf.append(getYBSqlByFileAndTask("'2','3'"));
		}else if(dataType.equals("jiaqian")){
			//加签 
			strbuf.append(getDBSqlByFileAndTask("'5'")); 
		}else if(dataType.equals("chaosong")){
			//抄送 
			
		}else if(dataType.equals("xietong")){
			//协同 
			strbuf.append(getDBSqlByFileAndTask("'4'")); 
		}
		
		if (ttb.getPageSize() != 0) {
			ttb.setTotal(DaoUtil.countWithSQLByCondition((new StringBuilder().append("select count(*) from (").append(strbuf).append(") as total").toString()), params));
		}
		List<Object[]> list = DaoUtil.listWithSQLByCondition(strbuf.toString(), params, ttb.getPage(), ttb.getPageSize());
		return buildJSON(list);
	}
	/**
	 * 
	* @Title: getSqlByFile 
	* @Description: 获取未启动的待办sql 0未启动
	* @param dataType
	* @return String
	 */
	private static String getDBSqlByFile(String dataType){
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("select yf.file_Create_Date,");
		strbuf.append(" yf.file_Create_User_Id,");
		strbuf.append(" yf.file_Create_User_Name,");
		strbuf.append(" yf.file_Flow_Status,");
	   
		strbuf.append(" yf.file_ID,");
		strbuf.append(" yf.file_KeyWord,");
		strbuf.append(" yf.file_create_org_oid,");
		strbuf.append(" yf.file_emergency_level,");
		strbuf.append(" yf.file_code,");
		strbuf.append(" yf.file_security_rate,");
		strbuf.append(" yf.file_title,");
		strbuf.append(" yf.template_Code,");
		strbuf.append(" yf.template_Id");
		strbuf.append(" from yhf_file yf");
		strbuf.append(" where yf.file_Create_User_Id = '"+UserContext.getLoginUserID()+"'");
		strbuf.append(" and yf.file_Flow_Status in ("+dataType+")");//未启动
		return strbuf.toString();
	}
	/**
	 * 
	* @Title: getSqlByFileAndTask 
	* @Description: 获取已启动的待办 加签 抄送 协同sql  0未启动，1审批中，4协同中，5加签中，6历史数据
	* @param dataType
	* @return String
	 */
	private static String getDBSqlByFileAndTask(String dataType){
		StringBuffer strbuf = new StringBuffer();
		strbuf.append(" select ");
		strbuf.append(" yf.file_Create_Date,");
		strbuf.append(" yf.file_Create_User_Id,");
		strbuf.append(" yf.file_Create_User_Name,");
		strbuf.append(" yf.file_Flow_Status,");
		strbuf.append(" yf.file_ID,");
		strbuf.append(" yf.file_KeyWord,");
		strbuf.append(" yf.file_create_org_oid,");
		strbuf.append(" yf.file_emergency_level,");
		strbuf.append(" yf.file_code,");
		strbuf.append(" yf.file_security_rate,");
		strbuf.append(" yf.file_title,");
		strbuf.append(" yf.template_Code,");
		strbuf.append(" yf.template_Id");
		strbuf.append(" from yhf_file yf,YHF_Task yt");
		strbuf.append(" where yf.file_ID = yt.task_entityid ");
		strbuf.append(" and yt.task_senduser = '"+UserContext.getLoginUserID()+"'");
		strbuf.append(" and yf.file_Flow_Status in ("+dataType+")");
		return strbuf.toString();
		
	}
	/**
	 * 
	* @Title: getYBSqlByFileAndTask 
	* @Description: 获取已办sql  2已终止 3已结束 
	* @param dataType
	* @return String
	 */
	private static String getYBSqlByFileAndTask(String dataType){
		StringBuffer strbuf = new StringBuffer();
		strbuf.append(" select ");
		strbuf.append(" yf.file_Create_Date,");
		strbuf.append(" yf.file_Create_User_Id,");
		strbuf.append(" yf.file_Create_User_Name,");
		strbuf.append(" yf.file_Flow_Status,");
		strbuf.append(" yf.file_ID,");
		strbuf.append(" yf.file_KeyWord,");
		strbuf.append(" yf.file_create_org_oid,");
		strbuf.append(" yf.file_emergency_level,");
		strbuf.append(" yf.file_code,");
		strbuf.append(" yf.file_security_rate,");
		strbuf.append(" yf.file_title,");
		strbuf.append(" yf.template_Code,");
		strbuf.append(" yf.template_Id");
		strbuf.append(" from yhf_file yf,YHF_Task_Process ytp");
		strbuf.append(" where yf.file_ID = ytp.tp_entityid ");
		strbuf.append(" and ytp.tp_douser = '"+UserContext.getLoginUserID()+"'");
		strbuf.append(" and yf.file_Flow_Status in ("+dataType+")");
		return strbuf.toString();
	}
	/**
	 * 
	* @Title: buildJSON 
	* @Description: object to JSONObject 
	* @param list
	* @return
	* @throws DataAccessFailureException
	* @throws ServiceException List<JSONObject>
	 */
	private static List<JSONObject> buildJSON(List<Object[]> list) throws DataAccessFailureException,ServiceException
	{
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		for(Object[] obj:list){
			JSONObject json = new JSONObject();
			json.put("file_Create_Date", obj[0]==null?"":obj[0].toString()); // 文档创建时间
			json.put("file_Create_User_Id", obj[1]==null?"":obj[1].toString()); // 文档创建人ID
			json.put("file_Create_User_Name", obj[2]==null?"":obj[2].toString()); // 文档创建人姓名
			json.put("file_Flow_Status", obj[3]==null?"":obj[3].toString()); // 流程处理状态
			//json.put("file_Flow_Status_name", obj[3]==null?"":DicHelper.viewName(WorkFlowConfigurationUtil.YHRS4008, obj[3].toString()));//流程处理状态名称
			json.put("file_ID", obj[4]==null?"":obj[4].toString()); // 
			json.put("file_KeyWord", obj[5]==null?"":obj[5].toString()); // 文档描述
			json.put("file_create_org_oid", obj[6]==null?"":obj[6].toString()); // 文档创建部门
			json.put("file_emergency_level", obj[7]==null?"":obj[7].toString()); // 紧急程度
			json.put("file_code", obj[8]==null?"":obj[8].toString()); // 文档Code
			json.put("file_security_rate", obj[9]==null?"":obj[9].toString()); // 文档密级
			json.put("file_title", obj[10]==null?"":obj[10].toString()); // 文件标题
			json.put("template_Code", obj[11]==null?"":obj[11].toString()); // 模板编码
			json.put("template_Id", obj[12]==null?"":obj[12].toString()); // 
			//是否退回
			jsonList.add(json);
		}
		
		return jsonList;
	}
	/** 
	* @Title: getBusinessTotal 
	* @Description: 获取业务记录条数 
	* @return JSONObject
	 * @throws DataAccessFailureException,ServiceException 
	*/ 
	public static JSONObject getBusinessTotal() throws DataAccessFailureException,ServiceException {
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("select ");
		strbuf.append(" (select count(*) from (");
		strbuf.append(getDBSqlByFile("'0'"));
		strbuf.append(" union all ");
		strbuf.append(getDBSqlByFileAndTask("'0','1','4','5','6'")); 
		strbuf.append(") t1) as dbTotal,"); // 待办
		
		strbuf.append(" (select count(*) from (");
		strbuf.append(getYBSqlByFileAndTask("'2','3'"));
		strbuf.append(") t2) as ybTotal,"); // 已办
		
		strbuf.append(" (select count(*) from (");
		strbuf.append(getDBSqlByFileAndTask("'5'")); 
		strbuf.append(") t3) as jqTotal,"); // 加签
		
		strbuf.append(" (select count(*) from (");
		strbuf.append(getDBSqlByFileAndTask("'8'")); 
		strbuf.append(") t4) as csTotal,"); // 抄送？？
		
		strbuf.append(" (select count(*) from (");
		strbuf.append(getDBSqlByFileAndTask("'4'")); 
		strbuf.append(") t5) as xtTotal"); // 协同
		List<Object[]> list =DaoUtil.listWithSQLByCondition(strbuf.toString(), params,0,0);
		if(CollectionUtils.isNotEmpty(list)){
			return buildTotalJSON(list.get(0));
		}else{
			return null;
		}
	}
	/**
	 * 
	* @Title: buildTotalJSON 
	* @Description: obj -->json 
	* @param obj
	* @return
	* @throws DataAccessFailureException
	* @throws ServiceException JSONObject
	 */
	private static JSONObject buildTotalJSON(Object[] obj) throws DataAccessFailureException,ServiceException
	{
		if(obj.length != 0){
			JSONObject json = new JSONObject();
			json.put("daiban", obj[0]==null?"":obj[0].toString());
			json.put("yiban", obj[1]==null?"":obj[1].toString());
			json.put("jiaqian", obj[2]==null?"":obj[2].toString());
			json.put("chaosong", obj[3]==null?"":obj[3].toString());
			json.put("xietong", obj[4]==null?"":obj[4].toString());
			
			return json;
		}
		return null;
	}
}
