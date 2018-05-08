<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>
	<table class="mho_table mho_table_center mho_table_border">
		<thead>
			<tr>
				<td></td>
				<td>单位名称</td>
				<td>部门名称</td>
				<td>职务名称</td>
				<td>姓名</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ttb.list}" var="dto" varStatus="s">
			<tr>
				<td>
				<span class="mho_checkbox" style="margin: 0 5px -4px 5px;">
				<input type="checkbox" name="checkbox" value="${dto.userId}"><i class="fa fa-check"></i>
				</span>
				</td>
				<td>${dto.unitName}</td>
				<td>${dto.deptName}</td>
				<td>${dto.dutyName}</td>
				<td>${dto.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>