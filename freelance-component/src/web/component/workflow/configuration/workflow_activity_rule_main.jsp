<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%@taglib uri="dictionary.tld" prefix="dictionary" %>
<%@taglib uri="c.tld" prefix="c"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head lang="l">
    <meta charset="UTF-8">
    <title>流程设置</title>
	<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/comm/customJs.js"></script>
    <%-- <%@ include file="/include/js_css_admin_include.jsp"%> --%>
    <%@ include file="/include/js_css_base_include.jsp"%>
    
    <style>
    	.floatDiv{float:left;}
    </style>
   	<script>
   	function createActivity(baseInfoId){
   		Widget.openContent("goInsertWorkflowActivity.do?method=goInsertActivity&baseInfoId="+baseInfoId,function(){
			worktop.grid.store.load({
				params: {start:0, limit: worktop.grid.page.limit}
			});
		});
	}
   	function updateActivity(activityId){
		Widget.openContent("goUpdateWorkflowActivity.do?method=goUpdateActivity&activityId="+activityId,function(){
			worktop.grid.store.load({
				params: {start:0, limit: worktop.grid.page.limit}
			});
		});
	}
	function deleteActivity(ActivityId){
		$.get("deleteWorkflowActivity.do?method=deleteActivity&activityId="+activityId,function(data){
			if (data.message) {
				MessageBox.alert('提示', data.message, function(){
					worktop.grid.store.load({
						params: {start:0, limit: worktop.grid.page.limit}
					});
				})
			}
		},'json')
	
	}
   	function createRule(baseInfoId){
		Widget.openContent("goInsertWorkflowRule.do?method=goInsertRule&baseInfoId="+baseInfoId,function(){
			worktop.grid.store.load({
				params: {start:0, limit: worktop.grid.page.limit}
			});
		});
	}
   	function updateRule(ruleId){
		Widget.openContent("goUpdateWorkflowRule.do?method=goUpdateRule&ruleId="+ruleId,function(){
			worktop.grid.store.load({
				params: {start:0, limit: worktop.grid.page.limit}
			});
		});
	}
	function deleteRule(RuleId){
		$.get("deleteWorkflowRule.do?method=deleteRule&ruleId="+ruleId,function(data){
			if (data.message) {
				MessageBox.alert('提示', data.message, function(){
					worktop.grid.store.load({
						params: {start:0, limit: worktop.grid.page.limit}
					});
				})
			}
		},'json')
	
	}
   	</script>
   	<script type="text/javascript">
function changeTab(index)
		{
			var oTab=document.getElementById("cen_right_top");
			var aH3=oTab.getElementsByTagName("h3");
			var aDiv=oTab.getElementsByTagName("div");
			aH3[index].index=index;
			for(var i=0;i<aH3.length;i++)
			{
				aH3[i].className="";
				aDiv[i].style.display="none";
			}
			aH3[index].className="active";
			aDiv[aH3[index].index].style.display="block";
		}
function goback(){
	HistoryRegister.go("goWorkflowConfigurationUpdate");
}
</script>
</head>
<body>
<div class="sitemap">
    <ul style="float: left">
        <li>当前位置：</li>
        <li><a href="#">基础信息管理&gt;</a></li>
        <li><a href="#">信息管理 &gt;</a></li>
        <li><a href="#">模板管理&gt;</a></li>
        <li><a href="#">新建流程</a></li>
    </ul>
    <div class="go_back"><a href="javascript:void(0);" onclick="goback();"><span style="font-family: sans-serif;"><< </span>返回</a></div>
    <div style="clear: both"></div>
</div>
<div id="showmodal" class="modal-content" width="100%">
    	  <div class="modal-row03">
            		<dl>
            			<dt>名称</dt>
            			<dd>
								<input type="text" name="flowName"  id="flowName" value="${workflowConfigurationDto.flowName}" /> 
            			</dd>
            		</dl>
            		<dl>
            			<dt>所属部门</dt>
            			<dd>
            				<label title="${workflowConfigurationDto.orgName}"> 
            				${workflowConfigurationDto.orgName}
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>类别</dt>
            			<dd>
            				<label title="${workflowConfigurationDto.flowType}"> 
            				${workflowConfigurationDto.flowType}
	                      	</label>
            			</dd>
            		</dl>
    </div>
        <div class="floatDiv" style="width:48%">
	    	<table width="100%" border="1" cellpadding="0" cellspacing="0" class="list">
				<tr style="heigth:10px">
					<th><div align="center">活动序号</div></th>
					<th><div align="center">活动名称</div></th>
					<th><div align="center">前置规则</div></th>
					<th><div align="center">后置规则</div></th>
					<th colspan="2"><div align="center"><a href="#" onclick="createActivity('${baseInfoId}');" style="color:green">新建活动</a></div></th>
				</tr>
				<c:forEach items="${workflowConfigurationDto.activityList}" var="dto" varStatus="status">
				    <tr style="heigth:10px">
				     	<td align="center">${status.index+1 }</td>
				        <td align="center">${dto.activityName }</td>
				        <td align="center">${dto.preRegulation }</td>
				        <td align="center">${dto.succeedRegulation }</td>
				        <td align="center"><a href="#" onclick="updateActivity('${dto.activityId}')" style="color:green">修改</a></td>
		        		<td align="center"><a href="#" onclick="deleteActivity('${dto.activityId}')" style="color:green">删除</a></td>
				    </tr>
				</c:forEach>
	    	</table>
    	</div>
    	<div class="floatDiv" style="width:48%">
	    	<table width="100%" border="1" cellpadding="0" cellspacing="0" class="list">
				<tr style="heigth:10px">
					<th><div align="center">规则序号</div></th>
					<th><div align="center">规则名称</div></th>
					<th><div align="center">规则类型</div></th>
					<th><div align="center">前置活动</div></th>
					<th><div align="center">后置活动</div></th>
					<th colspan="2"><div align="center"><a href="#" onclick="createRule('${baseInfoId}')" style="color:green">新建规则</a></div></th>
				</tr>
				<c:forEach items="${workflowConfigurationDto.ruleList}" var="dto" varStatus="status">
				    <tr style="heigth:10px">
				     	<td align="center">${status.index+1 }</td>
				        <td align="center">${dto.ruleName }</td>
				        <td align="center">${dto.ruleType }</td>
				        <td align="center">${dto.preActivity }</td>
				        <td align="center">${dto.succeedActivity }</td>
				        <td align="center"><a href="#" onclick="updateRule('${dto.ruleId}')" style="color:green">修改</a></td>
		        		<td align="center"><a href="#" onclick="deleteRule('${dto.ruleId}')" style="color:green">删除</a></td>
				    </tr>
				</c:forEach>
	    	</table>
    	</div>
</body>

</html>