package com.yh.hr.biz.vacation.queryhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.res.dictionary.DicConstants;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.DataAccessFailureException;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.web.UserContext;


/**
 * @Description: 请休假业务queryHelper
 * @author: meijm
 * @date: 2018-6-10
 */
public class BizVacationQueryHelper {

	/** 
	* @Title: listVacationInfo 
	* @Description: 获取请休假业务列表 
	* @param ttb
	* @return List<JSONObject>
	*/ 
	public static List<JSONObject> listVacationInfo(TableTagBean ttb) throws ServiceException{
		String templateCode = ttb.getCondition().get("templateCode");
		Map<String,Object> params = new HashMap<String,Object>();
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
		strbuf.append(" and yf.file_Flow_Status = '"+DicConstants.YHRS4008_0+"'");//未启动
		if(StringUtils.isNotEmpty(templateCode)){
			strbuf.append(" and yf.template_Code = '"+templateCode+"'");
		}
		
		if (ttb.getPageSize() != 0) {
			ttb.setTotal(DaoUtil.countWithSQLByCondition((new StringBuilder().append("select count(*) from (").append(strbuf).append(") as total").toString()), params));
		}
		List<Object[]> list = DaoUtil.listWithSQLByCondition(strbuf.toString(), params, ttb.getPage(), ttb.getPageSize());
		return buildJSON(list);
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
			jsonList.add(json);
		}
		
		return jsonList;
	}
}
