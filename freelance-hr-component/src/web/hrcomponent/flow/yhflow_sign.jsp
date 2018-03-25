<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>加签</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div style="padding: 20px;">
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">单位名称</label>
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
					<label style="width: 100%;">部门名称</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<select class="mho_form_field" style="width: 100%;">
						<option>销售部</option>
					</select>
				</div>
			</div>
		</div>
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">姓名</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input class="mho_form_field">
				</div>
			</div>
		</div>
		<div class="mho_row mho_row_no_margin">
			<button class="mho_btn mho_btn_primary mho_btn_circle"
				style="margin: 10px auto; width: 100px;">查询</button>
		</div>
		<table class="mho_table mho_table_center mho_table_border">
			<thead>
				<tr>
					<td>单位名称</td>
					<td>部门名称</td>
					<td>职务</td>
					<td>人员</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>