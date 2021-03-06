package com.yh.component.dynamicproperty.queryhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.yh.component.dictionary.utils.DicHelper;
import com.yh.component.dynamicproperty.dto.DynamicPropertyDTO;
import com.yh.component.dynamicproperty.dto.TablePropertyDTO;
import com.yh.component.dynamicproperty.util.DynamicPropertyUtil;
import com.yh.component.taglib.TableTagBean;
import com.yh.component.workflow.dto.WorkflowBaseInfoDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.DataAccessFailureException;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;
/**
 * @desc 动态字段QueryHelper
 * @author liul
 * @createDate 2017-10-31
 */
public class DynamicPropertyQueryHelper {

	public static DynamicPropertyDTO getDynamicPropertyDTO() throws DataAccessFailureException
	{
		StringBuffer sql = new StringBuffer("");
		List<Object[]> list= DaoUtil.findWithSQL(sql.toString());
		if (CollectionUtils.isNotEmpty(list)) 
		{
			for (Object[] objs : list) 
			{
				DynamicPropertyDTO dto = new DynamicPropertyDTO();
				return dto;
			}
		}
		return null;
	}
	/**
	 * 根据参数获取原表中的字段数据
	 * @param ttb
	 * @return
	 * @throws ServiceException 
	 */
	public static List<TablePropertyDTO> getTablePropertyList(TableTagBean ttb) throws ServiceException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		//查询原表字段sql
		String tSql = "select  infs.column_name,case when infs.CHARACTER_MAXIMUM_LENGTH is not null then cast(infs.DATA_TYPE as varchar(10))+'('+cast(infs.CHARACTER_MAXIMUM_LENGTH as varchar(10))+')' else infs.DATA_TYPE end as dataType from Information_schema.columns infs where infs.table_Name = '"+ttb.getCondition().get("dpCode")+"'";
		//查询管理库中字段sql
		String dSql = "SELECT ydp.DP_Name from yhf_dynamic_property ydp where ydp.dp_code = '"+ttb.getCondition().get("dpCode")+"'";
		sb.append(tSql);
		sb.append(" and infs.column_name not in ("+dSql+") ");
		if (ttb.getPageSize() != 0) {
			ttb.setTotal(DaoUtil.countWithSQLByCondition((new StringBuilder().append("select count(*) from (").append(sb.toString()).append(") as total").toString()), params));
		}
		List<Object[]> list = DaoUtil.listWithSQLByCondition(sb.toString(), params, 0, 0);
		List<TablePropertyDTO> tableList = new ArrayList<TablePropertyDTO>();
		for(Object[] obj:list){
			TablePropertyDTO dto = new TablePropertyDTO();
			dto.setColumnName(obj[0]==null?"":obj[0].toString());
			dto.setDataType(obj[1]==null?"":obj[1].toString());
			tableList.add(dto);
		}
		
		return tableList;
	}
	/**
	 * 根据参数获取管理库中的字段数据
	 * @param ttb
	 * @return
	 * @throws ServiceException 
	 */
	public static List<JSONObject> getDynamicPropertyList(TableTagBean ttb) throws ServiceException{
		Map<String,Object> params = new HashMap<String,Object>();
		//根据参数获取sql
		StringBuffer sql = new StringBuffer("SELECT ydp.DP_ID,ydp.DP_Name,ydp.DP_Type,ydp.DP_Description,ydp.DP_Category,ydp.DP_State,ydp.DP_Code,ydp.DP_Time from yhf_dynamic_property ydp where ydp.dp_code = '"+ttb.getCondition().get("dpCode")+"'");
		if(StringUtils.isNotEmpty(ttb.getCondition().get("config"))&&ttb.getCondition().get("config").equals("Y")){
			sql.append(" and ydp.DP_Category in ('"+DynamicPropertyUtil.YHRS3001_3+"','"+DynamicPropertyUtil.YHRS3001_4+"')");
		}
		if (ttb.getPageSize() != 0) {
			ttb.setTotal(DaoUtil.countWithSQLByCondition((new StringBuilder().append("select count(*) from (").append(sql).append(") as total").toString()), params));
		}
		List<Object[]> list = DaoUtil.listWithSQLByCondition(sql.toString(), params, ttb.getPage(), ttb.getPageSize());
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
			json.put("dpId", obj[0]==null?"":obj[0].toString());
			json.put("dpName", obj[1]==null?"":obj[1].toString());
			json.put("dpType", obj[2]==null?"":obj[2].toString());
			json.put("dpDescription", obj[3]==null?"":obj[3].toString());
			json.put("dpCategory", obj[4]==null?"":DicHelper.viewName(DynamicPropertyUtil.YHRS3001, obj[4].toString()));
			json.put("dpStateCode", obj[5]==null?"":obj[5].toString());
			json.put("dpState", obj[5]==null?"":DicHelper.viewName(DynamicPropertyUtil.YHRS3002, obj[5].toString()));
			json.put("dpCode", obj[6]==null?"":obj[6].toString());
			json.put("dpCodeName", obj[6]==null?"":DicHelper.viewName(DynamicPropertyUtil.YHRS3003, obj[6].toString()));
			json.put("dpTime", obj[7]==null?"":obj[7].toString());
			json.put("sc",DynamicPropertyUtil.DP_SC);
			jsonList.add(json);
		}
		
		return jsonList;
	}  
	/**
	 * 根据条件获取动态字段配置信息
	 * @param ttb
	 * @return
	 * @throws ServiceException 
	 */
	public static List<DynamicPropertyDTO> getDynamicPropertyListByHQL(TableTagBean ttb) throws ServiceException{
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer hql = new StringBuffer("from DynamicProperty ydp where ydp.dpCode = '"+ttb.getCondition().get("dpCode")+"'");
		hql.append(" and ydp.dpCategory in ('"+DynamicPropertyUtil.YHRS3001_3+"','"+DynamicPropertyUtil.YHRS3001_4+"')");
		List<DynamicPropertyDTO> list = BeanHelper.copyProperties(DaoUtil.listByCondition(hql.toString(), params, 0, 0),DynamicPropertyDTO.class);
		return list;
	}
}
