<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程启动</title>
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="component/front_transform/webuploader-0.1.5/webuploader.js"></script>
<script src="hrcomponent/flow/js/yhflow_start.js"></script>
</head>
<body>
	<div
		style="background: #fff; position: absolute; top: 0; bottom: 0; left: 0; right: 0; overflow: auto; padding: 20px 50px 0 0;">
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">上级</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<select class="mho_form_field">
						<option>深圳市宝安区规划建设局</option>
					</select>
				</div>
			</div>
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">类型</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<select class="mho_form_field" style="width: 100%;">
						<option>机关单位</option>
					</select>
				</div>
			</div>
		</div>
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">名称</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input class="mho_form_field">
				</div>
			</div>
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">编号</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input class="mho_form_field" style="width: 100%;">
				</div>
			</div>
		</div>
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">负责人</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input class="mho_form_field">
				</div>
			</div>
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">手机</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input class="mho_form_field">
				</div>
			</div>
		</div>
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">邮箱</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input class="mho_form_field">
				</div>
			</div>
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">传真</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input class="mho_form_field">
				</div>
			</div>
		</div>
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">地址</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input class="mho_form_field">
				</div>
			</div>
		</div>
		<jsp:include page="yhflow_button.jsp"></jsp:include>
		<jsp:include page="yhflow_attachment.jsp"></jsp:include>
	</div>
</body>
</html>