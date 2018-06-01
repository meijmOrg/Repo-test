<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>附件查看</title>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="mho_row">
			<label class="mho_col mho_col_2 mho_text_right line_height_35">附件信息</label>
			<div class="mho_col <%=request.getParameter("widthFlag")%>">
				<ul class="mho_list mho_list_strip">
					<c:forEach items="${annexFileList}" var="dto" varStatus="status">
								<li id="${dto.faId }"><a href='javascript:void(0)' onclick="downloadFile('${dto.faId}')">${dto.faName }</a>
								</li>
							</c:forEach>
				</ul>
			</div>
		</div>
</body>
</html>