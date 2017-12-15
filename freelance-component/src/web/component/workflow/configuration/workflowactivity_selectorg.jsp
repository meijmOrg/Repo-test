<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%@taglib uri="dictionary.tld" prefix="dictionary" %>
<%@taglib uri="c.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="l">
    <meta charset="UTF-8">
    <title>新建流程-选择部门</title>
	<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/comm/customJs.js"></script>
   	<script>
   	function createFlow(){
		Widget.openContent("goUpdateWorkflowBaseInfo.do?method=goUpdateFlow",function(){
			worktop.grid.store.load({
				params: {start:0, limit: worktop.grid.page.limit}
			});
		});
}
   	</script>
</head>
<body>
<div id="showmodal" class="modal-content">
    	<div class="modal-header">
            <button type="button" class="close close-popdown" data-dismiss="modal" aria-label="Close" button-click="widget-close">
            	<span aria-hidden="true" >&times;</span>
            </button>
            <h4 class="modal-title">新建流程&gt;&gt;</h4>
    	</div>	
        <div>
    	<table width="100%" border="1" cellpadding="0" cellspacing="0" class="list">
		<tr style="heigth:10px">
			<th><div align="center">序号</div></th>
			<th><div align="center"><input type="text"/></div></th>
			<th><div align="center">查询</div></th>
		</tr>
		<c:forEach items="${orgList}" var="dto" varStatus="status">
		    <tr style="heigth:10px">
		     	<td align="center">${status.index+1 }</td>
		        <td align="center">${dto.flowOrgName }</td>
		        <td align="center"><a href="#" onclick="createFlow()" style="color:green">新建流程</a></td>
		    </tr>
		</c:forEach>
    </table>
    </div>
</body>

</html>