<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0"/>
<title>字段列表</title>
<%-- <%@ include file="/include/js_css_admin_include.jsp"%> --%>
<script type="text/javascript">
function add(columnName,dataType){
	 var dpCode = $(this).attr('dpCode').value;
	 Widget.openContent("goCreateDynamicProperty.do?method=goCreateDynamicProperty&columnName="+columnName+"&dataType="+dataType+"&dpCode="+dpCode,
			function(){
		    goToTableProperty(dpCode);
		    goToDynamicProperty(dpCode);
	}); 
}
</script>
<style type="text/css">
th {border-style:solid;border-width:1px;border-bottom-style:none;cellpadding:0px;cellspacing:0px}
</style>
</head>
<body style="overflow-x: hidden;">
<div style="overflow-y:scroll;">
<table width="100%"  class="list">
	<tr style="heigth:10px;">
			<th width="25%"><div align="center"></div></th>
			<th width="5%"><div align="center">序号</div></th>
			<th width="50%"><div align="center">字段名称</div></th>
			<th width="20%"><div align="center">字段类型</div></th>
		</tr>
		</table>
</div>
<div style="height:calc(100% - 30px);width:100%;overflow:scroll">
	<!-- 列表内容展示-->
	 <table width="100%" border="1" cellpadding="0" cellspacing="0" class="list">
		<c:forEach items="${tableList}" var="dto" varStatus="status">
		    <tr style="heigth:10px">
		     	<td align="center" width="25%"><a href="javascript:void(0)" onclick="add('${dto.columnName }','${dto.dataType }')"  style="color:green">添加到字段管理</a></td>
		     	<td align="center" width="5%">${status.index+1 }</td>
		        <td align="center" width="50%">${dto.columnName }</td>
		        <td align="center" width="20%">${dto.dataType }</td>
		    </tr>
		</c:forEach>
    </table>
</div>
</body>
