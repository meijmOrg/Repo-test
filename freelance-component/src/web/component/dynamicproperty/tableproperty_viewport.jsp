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
/* var worktop_table = null;
$(document).ready(function(){
	worktop_table = new Worktop([
		{
			xtype:'Xtable',
			xname:'grid',
			url: 'getPropertyList.do?method=getTablePropertyList&dpCode=${dpCode}',
			rowNumber: true,
			start : '1',
			iPageLength:'30',
			columns: [
				{header:'',field:'',renderer:function(){
					return "<a onclick='' >添加到管理库</a>";
					},width:120},
				{header:'字段名称', field:'columnName', width:80},
				{header:'字段类型', field:'dataType', width:80}
			]
		},
		{
			xtype: 'QueryForm',//属性对应的构造函数
			xname: 'tableForm'//属性名
			 el:'#fr_wsid' 
		}
	]);
	
     $(window).resize(function(){
    	 worktop_table.grid.wrap.find('.ct').height(
				$('#messageTab').height()-$('.page_foot').height()-48
			);//48(分页48)
	}).resize().unbind();
     worktop_table.tableForm.goQuery();
}); */
function add(columnName,dataType){
	var dpCode = $(this).attr('dpCode').value;
		 Widget.openContent("goCreateDynamicProperty.do?method=goCreateDynamicProperty&columnName="+columnName+"&dataType="+dataType+"&dpCode="+dpCode,
				function(){
			    goToTableProperty(dpCode);
			    goToDynamicProperty(dpCode);
			    }); 
}
</script>
</head>
<body style="overflow-x: hidden;">
<div>
	<!-- 列表内容展示-->
	 <table width="100%" border="1" cellpadding="0" cellspacing="0" class="list">
		<tr style="heigth:10px">
			<th><div align="center"></div></th>
			<th><div align="center">序号</div></th>
			<th><div align="center">字段名称</div></th>
			<th><div align="center">字段类型</div></th>
		</tr>
		<c:forEach items="${tableList}" var="dto" varStatus="status">
		    <tr style="heigth:10px">
		     	<td align="center"><a href="#" onclick="add('${dto.columnName }','${dto.dataType }')"  style="color:green">添加到字段管理</a></td>
		     	<td align="center">${status.index+1 }</td>
		        <td align="center">${dto.columnName }</td>
		        <td align="center">${dto.dataType }</td>
		    </tr>
		</c:forEach>
    </table>
</div>
</body>
