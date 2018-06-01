<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>附件查看</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function downloadFile(faId) {
	MessageBox.openWindow('downAnnexFile.do?method=downAnnexFile&faId='+faId);
};
</script>
</head>
<body>
	<div style="padding: 20px;">
			<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_10">
				<ul class="mho_list mho_list_strip">
					<c:forEach items="${annexFileList}" var="dto" varStatus="status">
								<li id="${dto.faId }"><a href='javascript:void(0)' onclick="downloadFile('${dto.faId}')">${dto.faName }</a>
								</li>
							</c:forEach>
				</ul>
			</div>
		</div>
		</div>
</body>
</html>