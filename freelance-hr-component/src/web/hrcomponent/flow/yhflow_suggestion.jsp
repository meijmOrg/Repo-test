<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程操作</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
</head>
<body>
	<!-- <div class="mho_row mho_row_no_margin">
		<div class="mho_col mho_col_2">
			<div class="mho_form_group">
				<label style="width: 100%;">地址</label>
			</div>
		</div>
		<div class="mho_col mho_col_8">
			<div class="mho_form_group mho_form_group_block">
				<textarea rows=5></textarea>
			</div>
		</div>
	</div> -->
	<div class="mho_row">
			<label class="mho_col mho_col_2 mho_text_right line_height_35">处理意见</label>
			<div class="mho_col <%=request.getParameter("widthFlag")%>">
				<div class="mho_form_group">
					<textarea class="mho_form_field" rows="5" style="width:100%;height:100px;"></textarea>
				</div>
			</div>
		</div>
</body>
</html>