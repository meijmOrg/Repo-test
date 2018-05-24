<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>抄送信息</title>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="mho_row">
			<label class="mho_col mho_col_2 mho_text_right line_height_35">抄送信息</label>
			<div class="mho_col mho_col_10">
				<table class="mho_table mho_table_center mho_table_border">
					<thead>
						<tr>
							<td>序号</td>
							<td>抄送人</td>
							<td>接收人</td>
							<td>查看时间</td>
							<td>查看意见</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ccList}" var="dto" varStatus="status">
							<tr>
								<td>${status.index }</td>
								<td>${dto.ccCreateUser }</td>
								<td>${dto.ccUser }</td>
								<td>${dto.ccReadTime }</td>
								<td>${dto.ccExplain }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>