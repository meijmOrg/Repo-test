/**
 * 
 */
package com.yh.component.workflow.utils;



/**
 * 流程组件util
 * 
 * @author liul
 * @version 1.0, 2017/11/17
 */

public class WorkFlowConfigurationUtil {

	/** 机构状态 */
	public static final String	YHRS0101	= "YHRS0101";
	/** 机构状态-新建*/
	public static final String	YHRS0101_1	= "1";
	/** 机构状态-正常*/
	public static final String	YHRS0101_2	= "2";
	/** 机构状态-撤销*/
	public static final String	YHRS0101_3	= "3"; 
	
	//下拉列表项
	public static final String EMPTY_ALL = "全部";
	public static final String EMPTY_SELECT = "--请选择--";
	
	/**
	 * 模板分类（备用）
	 */
	public static final String YHRS4003 = "YHRS4003"; 
	/**人事信息*/
	public static final String YHRS4003_1 = "1";
	/**人事业务*/
	public static final String YHRS4003_2 = "2";
	/**综合管理*/
	public static final String YHRS4003_3 = "3";
	/**其它*/
	public static final String YHRS4003_4 = "4";
	
	/**
	 * 流程类别
	 */
	public static final String YHRS4004 = "YHRS4004"; 
	/**通用流程*/
	public static final String YHRS4004_0 = "0";
	/**专属流程*/
	public static final String YHRS4004_1 = "1";
	
	/**
	 * 活动单元类型
	 */
	public static final String YHRS4005 = "YHRS4005"; 
	
	/**
	 * 退回方式
	 */
	public static final String YHRS4006 = "YHRS4006";
	
	/**
	 * 组合类别
	 */
	public static final String PC_TYPE_ORG = "yhe_ub_org"; // 部门
	public static final String PC_TYPE_GROUP = "yhb_roles"; // 小组
	public static final String PC_TYPE_ROLE = "yhb_users"; // 角色
	
	/**
	 * 任务通知类别
	 */
	public static final String IsMessage = "1"; // 任务创建人通知
	public static final String IsMessageNext = "2"; // 下一处理人通知
	public static final String IsMessageHistory = "3"; // 历史处理人通知
}
