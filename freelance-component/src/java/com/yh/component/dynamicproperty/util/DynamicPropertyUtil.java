/**
 * 
 */
package com.yh.component.dynamicproperty.util;

import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;


/**
 * 动态字段util
 * 
 * @author liul
 * @version 1.0, 2017/11/08
 */

public class DynamicPropertyUtil {

	public static final String	YHRS3001	= "YHRS3001";	// 字段类别
	public static final String	YHRS3002	= "YHRS3002";	// 字段状态
	public static final String	YHRS3003	= "YHRS3003";	// 字段编码
	/**
	 * 字段状态
	 */
	public static final String	YHRS3002_1	= "1";	// 启用
	public static final String	YHRS3002_2	= "2";	// 停用
	/**
	 * 字段编码
	 */
	public static final String	YHRS3003_1	= "1";	// 项目字段编码
	public static final String	YHRS3003_2	= "2";	// 招标计划
	public static final String	YHRS3003_3	= "3";	// 标段字段编码
	public static final String	YHRS3003_4	= "4";	// 合同字段编码
	public static final String	YHRS3003_5	= "5";	// 单位字段编码
	/**
	 * 根据参数获取sql
	 * @param ttb
	 * @createDate 2017-11-8
	 */
	public String getSqlByDpCode(TableTagBean ttb){
		StringBuffer sb  = new StringBuffer("select  tab.column_name,tab.data_type from Information_schema.columns tab");
		String dpCode = ttb.getCondition().get("dpCode");
		if(StringUtils.isNotEmpty(dpCode)&&dpCode.equals(YHRS3003_1)){
			sb.append(" where tab.table_Name = ''");
		}else if(StringUtils.isNotEmpty(dpCode)&&dpCode.equals(YHRS3003_2)){
			sb.append(" where tab.table_Name = ''");
		}
		else if(StringUtils.isNotEmpty(dpCode)&&dpCode.equals(YHRS3003_3)){
			sb.append(" where tab.table_Name = ''");
		}
		else if(StringUtils.isNotEmpty(dpCode)&&dpCode.equals(YHRS3003_4)){
			sb.append(" where tab.table_Name = ''");
		}
		else if(StringUtils.isNotEmpty(dpCode)&&dpCode.equals(YHRS3003_5)){
			sb.append(" where tab.table_Name = ''");
		}else{
			sb.append(" where 1=2");
		}
		
		
		return sb.toString();
		
	} 
	/**
	 * 删除
	 */
	public static final String	DP_SC	= "删除";
}
