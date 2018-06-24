<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%@taglib uri="dictionary.tld" prefix="dictionary" %>
<%@taglib uri="c.tld" prefix="c"%>
<%@ page import="com.yh.component.workflow.utils.WorkFlowConfigurationUtil"%>
<%@ page import="com.yh.hr.res.dictionary.DicConstants"%>

<!DOCTYPE html>
<html>
<head lang="l">
	 <meta charset="UTF-8">
	</script>
	<link type="text/css" href="component/workflow/configuration/drawing/lib/jquery-ui-1.8.4.custom/css/smoothness/jquery-ui-1.8.4.custom.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="component/workflow/configuration/drawing/index.css">
	<script type="text/javascript" src="component/workflow/configuration/drawing/lib/raphael-min.js"></script>
	<script type="text/javascript" src="component/workflow/configuration/drawing/lib/jquery-ui-1.8.4.custom/js/jQuery-2.2.0.min.js"></script>
	<!--<script type="text/javascript" src="component/workflow/configuration/drawing/lib/jquery-ui-1.8.4.custom/js/jquery-ui.min.js"></script>-->
	<script src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="component/workflow/configuration/drawing/myflow.js"></script>
	<script type="text/javascript" src="component/workflow/configuration/drawing/myflow.jpdl4.js"></script>
	<script type="text/javascript" src="component/workflow/configuration/drawing/myflow.editors.js"></script>
	<script type="text/javascript" src="component/workflow/configuration/drawing/index.js"></script>
	<script type="text/javascript" src="component/workflow/configuration/js/selectOrgForCreateFlow.js"></script>
	<link rel="stylesheet" type="text/css" href="component/workflow/configuration/drawing/ruleFlowProps.css">
		<link rel="stylesheet" href="component/front_transform/mho.css">
		<script type="text/javascript">
	var templateId = '${templetId}';
	var flowdata='${workflowConfigurationDto.flowData}';
	 $.asset["ruleParams"]={}; // 节点属性参数
	 $.asset["ruleParamsPath"]={}; // 连线属性
	
	</script>
</head>
<body>
		<div style="overflow-x:hidden;padding-bottom: 20px;">
		<input type="hidden" id="templetId" name="templetId" value='${templetId}' /> 
		<input type="hidden" id="flowId" name="flowId" value='${workflowConfigurationDto.flowId}' /> 
				<dl class="data-unit-dl">
					<dt>流程名称：</dt>
					<dd>
						<label><input type="text" name="flowName" class="modal_iput" id="flowName" value='${workflowConfigurationDto.flowName}' maxlength="100"/></label>
					</dd>
				</dl>
				<dl class="data-unit-dl">
					<dt>流程类别：</dt>
					<dd>
					<label><dictionary:dicItemSelect id="flowType" name="flowType" styleClass="modal_select" emptyText="<%=WorkFlowConfigurationUtil.EMPTY_SELECT %>"  dicTypeCode="<%=WorkFlowConfigurationUtil.YHRS4004%>"  selected='${workflowConfigurationDto.flowType}'/> </label>
					</dd>
				</dl>
				<dl class='data-unit-dl'>
							<dt class="search-unit-dt">所属科室：</dt>
							<dd class="search-unit-dd">
									<input type="text" class="modal_iput" name="hireDeptName" id="hireDeptName" readonly="readonly" onclick="selectOrg()" value='${workflowConfigurationDto.flowOrgName}' /> 
									<input type="hidden" id="hireDeptOid" name="hireDeptOid" value='${workflowConfigurationDto.flowOrgOid}' /> 
									<!-- <a class="md-unit-clear" onclick="$(this).siblings('input').val('')"></a> -->
							</dd>
						</dl>
		</div>
<div class="substance"  id="tabs-1">
	<div id="myflow_tools" class="ui-widget-content">
		<div id="myflow_tools_handle" style="text-align: center;"
			class="ui-widget-header"> 工具集 
		</div>
		<div class="node" id="myflow_revoke"><img src="component/workflow/configuration/drawing/img/save.gif" />&nbsp;&nbsp;撤销</div>
		<!-- <div class="node" id="myflow_redraw"><img src="component/workflow/configuration/drawing/img/save.gif" />&nbsp;&nbsp;重绘</div> -->
		<div class="node" id="myflow_save"><img src="component/workflow/configuration/drawing/img/save.gif" />&nbsp;&nbsp;保存</div>
		<!-- <div class="node" id="myflow_publish"><img src="component/workflow/configuration/drawing/img/save.gif" />&nbsp;&nbsp;发布</div> -->
	<div>

	<hr />
	</div>
	<div class="node selectable selected" id="pointer"><img
		src="component/workflow/configuration/drawing/img/select16.gif" />&nbsp;&nbsp;选择</div>
	<div class="node selectable" id="path"><img
		src="component/workflow/configuration/drawing/img/16/flow_sequence.png" />&nbsp;&nbsp;转换</div>
	<div>
	<hr />
	</div>
	<div class="node state" id="start" type="start">
	<img src="component/workflow/configuration/drawing/img/16/start_event_empty.png" />&nbsp;&nbsp;开始</div>
	<div class="node state" id="activity" type="state"><img
		src="component/workflow/configuration/drawing/img/16/task_empty.png" />&nbsp;&nbsp;活动</div>
	<!-- <div class="node state" id="fork" type="fork">
	<img  src="component/workflow/configuration/drawing/img/16/gateway_parallel.png" />&nbsp;&nbsp;分支</div> -->
	<!-- <div class="node state" id="join" type="join"><img src="component/workflow/configuration/drawing/img/16/gateway_parallel.png" />&nbsp;&nbsp;合并</div> -->
	<div class="node state" id="end" type="end"><img src="component/workflow/configuration/drawing/img/16/end_event_terminate.png" />&nbsp;&nbsp;结束</div>
	<!-- <div class="node state" id="end-cancel" type="end-cancel"><img src="component/workflow/configuration/drawing/img/16/end_event_cancel.png" />&nbsp;&nbsp;取消</div>
	<div class="node state" id="end-error" type="end-error"><img src="component/workflow/configuration/drawing/img/16/end_event_error.png" />&nbsp;&nbsp;错误</div> -->
	</div>

	<div id="myflow"></div>
	
<div id="slideInfoDetail" class="rulePropDetailSlide">
    <div class="slideInfoContent">
        <div class="coloum-half column-left">
            <input type="hidden"  name="rectId">
            <div id="rectGroup" class="fgroupBack still ruleGroup" >
               <div class="panel-conds-cdh" style="margin-left: -10px;">
                  
                    <span class="rule-add ruleStratrgySave" style="
                       margin-bottom: 10px;" title="暂存">
                                                 <span>暂存</span>
                                                 </span>
                </div>
                <div class="ruleList" id="ruleList">

                </div>
            
            </div>
           
        </div>

    </div>
    <a href="javascript:void(0);" class="slideControler"></a>
</div>
	</div>
	 <div id="cdtnTemplates" class="hidden" style="display:none">
        <div id="ruleTemplates">
       		 <div class ="addRuleGroup">
                <section class="mho_accordion ruleStrategy">
					<dl class="mho_accordion_item">
					<dt class="mho_accordion_title mho_dep_yellow">基本属性</dt>
					<dd class="mho_accordion_body">
						<div class="mho_form_group">
							<label>活动名称</label>
							<input type="text" class="mho_form_field" name="activityName">
						</div>
						<div class="mho_form_group">
							<label>活动序号</label>
							<input type="text" class="mho_form_field" name="activityNo">
						</div>
						<div class="mho_form_group">
							<label>活动类型</label>
							<dictionary:dicItemSelect id="activityType" name="activityType"  emptyText="<%=WorkFlowConfigurationUtil.EMPTY_SELECT %>"  dicTypeCode="<%=WorkFlowConfigurationUtil.YHRS4005%>" />
						</div>
						<div class="mho_form_group">
							<label>退回方式</label>
							<dictionary:dicItemSelect id="backWay" name="backWay" emptyText="<%=WorkFlowConfigurationUtil.EMPTY_SELECT %>"  dicTypeCode="<%=WorkFlowConfigurationUtil.YHRS4006%>" />
						</div>
						<div class="mho_form_group">
							<label>默认审核内容</label>
							<textarea name="content" rows=2></textarea>
						</div>
					</dd>
				</dl>
				<dl class="mho_accordion_item qxControl">
					<dt class="mho_accordion_title mho_dep_yellow">权限控制</dt>
					<dd class="mho_accordion_body">
						<div class="mho_form_group">
							<label>允许协同</label>
							<dictionary:dicItemSelect id="allowSynergy" name="allowSynergy" 
															dicTypeCode="<%=DicConstants.YHRS0003%>" emptyText="--请选择--" />
						</div>
						<div class="mho_form_group">
							<label>允许结束</label>
							<dictionary:dicItemSelect id="allowEnd" name="allowEnd" 
															dicTypeCode="<%=DicConstants.YHRS0003%>" emptyText="--请选择--" />
						</div>
						<div class="mho_form_group">
							<label>允许加签</label>
							<dictionary:dicItemSelect id="allowCountersign" name="allowCountersign" 
															dicTypeCode="<%=DicConstants.YHRS0003%>" emptyText="--请选择--" />
						</div>
						<div class="mho_form_group">
							<label>允许抄送</label>
							<dictionary:dicItemSelect id="allowCopy" name="allowCopy" 
															dicTypeCode="<%=DicConstants.YHRS0003%>" emptyText="--请选择--" />
						</div>
						<div class="mho_form_group">
							<label>允许补签</label>
							<dictionary:dicItemSelect id="allowRetroactive" name="allowRetroactive" 
															dicTypeCode="<%=DicConstants.YHRS0003%>" emptyText="--请选择--" />
						</div>
						<div class="mho_form_group">
							<label>操作者集合</label>
							<select id="handlers" name="handlers">
							<option value>--请选择--</option>
							<option value="&amp;&amp;">与</option>
							<option value="||">或</option>
							</select>
						</div>
						<div class="mho_tabs">
							<ul class="mho_tabs_nav">
								<li class="mho_active"><a href="javascript:void(0)">部门</a></li>
								<li><a href="javascript:void(0)">小组</a></li>
								<li><a href="javascript:void(0)">角色</a></li>
							</ul>
							<div class="mho_tabs_body">
								<div class="mho_tab_panel  mho_orgInfo mho_active">
									
								</div>
								<div class="mho_tab_panel mho_groupInfo ">
								
								</div>
								<div class="mho_tab_panel mho_roleInfo ">
								
								</div>
							</div>
						</div>
					</dd>
				</dl>
				<dl class="mho_accordion_item">
					<dt class="mho_accordion_title mho_dep_yellow">任务通知</dt>
					<dt class="mho_accordion_title">任务创建人通知设置</dt>
					<dd class="mho_accordion_body">
						<div class="mho_form_group">
							<label>启用通知<input type="checkbox" id="isMessageNext" name="isMessage" ></label>
						</div>
						<div class="mho_form_group">
							<label>消息模板</label>
							<textarea rows=2 id="isMessageTemp" name="isMessageTemp"></textarea>
						</div>
						
					</dd>
					<dt class="mho_accordion_title">下一处理人通知设置</dt>
					<dd class="mho_accordion_body">
					<div class="mho_form_group">
							<label>启用通知<input type="checkbox" id="isMessageNext" name="isMessageNext" ></label>
						</div>
						<div class="mho_form_group">
							<label>消息模板</label>
							<textarea rows=2 id="isMessageTempNext" name="isMessageTempNext"></textarea>
						</div>
					</dd>
					<dt class="mho_accordion_title">历史处理人通知设置</dt>
					<dd class="mho_accordion_body">
						<div class="mho_form_group">
							<label>启用通知<input type="checkbox" id="isMessageHistory" name="isMessageHistory" ></label>
						</div>
						<div class="mho_form_group">
							<label>消息模板</label>
							<textarea rows=2 id="isMessageTempHistory" name="isMessageTempHistory"> </textarea>
						</div>
						
					</dd>
					<dt class="mho_accordion_title">通知方式</dt>
					<dd class="mho_accordion_body">
					<div class="mho_form_group">
					<label>手机短信<input type="checkbox" id="notification" name="notification" ></label>
					</div>
					</dd>
				</dl>
		</section>  
            </div>
         	 <div class ="addRuleGroupPath">
             <section class="mho_accordion ruleStrategyPath">
		<dl class="mho_accordion_item">
		<dt class="mho_accordion_title mho_dep_yellow">基本属性</dt>
		<dd class="mho_accordion_body">
			<div class="mho_form_group">
				<label>规则名称</label>
				<input type="text" class="mho_form_field" name="ruleName">
			</div>
			<div class="mho_form_group">
				<label>规则序号</label>
				<input type="text" class="mho_form_field" name="rueNo">
			</div>
			<div class="mho_form_group">
				<label>规则类型</label>
				<select id="handlers" name="ruleType" value="0">
				<option value>--请选择--</option>
				<option value="0">直线</option>
				<option value="1">折线</option>
				</select>
			</div>
		</dd>
	</dl>
	<dl class="mho_accordion_item">
		<dt class="mho_accordion_title mho_dep_yellow">购置转移条件</dt>
		<dd class="mho_accordion_body changeCond">
			   <div class="panel-conds-custoper rulesConds">
                   <label>执行条件：</label>
                   <select  style="width: 160px;" class="select2 select2-container rulesCondsOperator" name="rulesCondsOperator" data-name="rulesCondsOperator">
                    <option selected="selected" value="&amp;&amp;">满足以下所有条件</option>
                       <option selected="selected" value="||">满足以下任一条件</option>
                   </select>
               </div>
               <div class="panel-conds-cdsm">
                    <ul class="panel-conds-ul">

                    </ul>
                    <div class="panel-conds-cdh">
                    <span class="addCustomGroupOfAnd rule-add addSingleCond" title="添加与条件">
                     <span>添加与条件</span>
                     </span>
                        <span class="addCustomGroupOfOr rule-add" title="添加或条件">
                              <span>添加或条件</span>
                    </span>
                    </div>
                </div>
		</dd>
	</dl>
	</section>  
         </div>
               <!--添加与条件组模板-->
            <div class="conditionGroupOfAnd">
                <li class="conds-group-item-OfAnd conds-group-item-delete clearfix">
                    <div class="conds-group-logic">
                        <span>与：</span>
                        <input type="hidden" value="&amp;&amp;" name="customLogicOperator">
                    </div>
                    <ul class="conds-group-list">
                        <li>
                            <!-- 自定义模板的条件组（可考虑与baseCondition合并） -->
                            <div class="form-group cond-li-div">
                                <select style="width: 180px;display: inline-block;" class="select2 form-control select2-add-search" name="condProperty" >
                                </select>
                                <select style=" width: 120px; display: inline-block;" class="form-control select2 operator-select-" name="condOperator">
                                </select>
                                <div class="ui-myflow" style="display: inline-block;" >
                                    <span class="ui-myflow-input" style=""><input type="text" name="condValue" ></span>
                                </div>
                                <div class="deleteCustItem condCustSingleItem" data-toggle="tooltip" data-placement="top" data-original-title="删除条件">
                                    <img class="ss-strgy-operate-img" src="component/workflow/configuration/drawing/img/delete-rule.png">
                                </div>
                                <div class="addCustItemOfAnd condCustItem" data-toggle="tooltip" data-placement="top" data-original-title="添加条件">
                                    <img class="ss-strgy-operate-img" src="component/workflow/configuration/drawing/img/rule-add.png">
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
            </div>
            <!--添加或条件组模板-->
            <div class="conditionGroupOfOr">
                <li class="conds-group-item-OfOr conds-group-item-delete clearfix">
                    <div class="conds-group-logic">
                        <span>或：</span>
                        <input type="hidden" value="||" name="customLogicOperator">
                    </div>
                    <ul class="conds-group-list">
                        <li>
                            <!-- 自定义模板的条件组（可考虑与baseCondition合并） -->
                            <div class="form-group cond-li-div">
                                <select style="width: 180px;display: inline-block;" class="form-control select2 select2-add-search" name="condProperty" >
                                </select>
                                <select style=" width: 120px; display: inline-block;" class="form-control select2 select2 operator-select-" name="condOperator">
                                
                                </select>
                                <div class="ui-myflow" style="display: inline-block;" >
                                    <span class="ui-myflow-input" style=""><input type="text" name="condValue" ></span>
                                </div>
                                <div class="deleteCustItem condCustSingleItem" data-toggle="tooltip" data-placement="top" data-original-title="删除条件">
                                    <img class="ss-strgy-operate-img" src="component/workflow/configuration/drawing/img/delete-rule.png">
                                </div>
                                <div class="addCustItemOfOr condCustItem" data-toggle="tooltip" data-placement="top" data-original-title="添加条件">
                                    <img class="ss-strgy-operate-img" src="component/workflow/configuration/drawing/img/rule-add.png">
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
            </div>
        </div>
        </div>
<!-- 	<script type="text/javascript" src="component/front_transform/component/accordion/accordion.js"></script>
 -->	<script type="text/javascript" src="component/workflow/configuration/drawing/ruleFlowProps.js"></script>
</body>
</html>