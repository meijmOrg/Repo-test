<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提交流程</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div style="padding: 20px;">
		<table class="mho_table mho_table_center mho_table_border">
			<thead>
				<tr>
					<td colspan="3">下一步骤</td>
				</tr>
			</thead>
			<tbody>
				<tr style="background: #f3f5ff;">
					<td style="width: 25%;">流程步骤</td>
					<td>用户选择</td>
					<td style="width: 25%;">短息提醒</td>
				</tr>
				<tr style="text-align: left;">
					<td>项目组长审核</td>
					<td><span class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="checkbox" name="myCheckbox"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">张晓凡</label> <span
						class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="checkbox" name="myCheckbox"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">李毅成</label> <span
						class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="checkbox" name="myCheckbox"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">河西</label></td>
					<td><span class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="radio" name="myRadio"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">是</label> <span
						class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="radio" name="myRadio"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">否</label></td>
				</tr>
				<tr style="text-align: left;">
					<td>自定义提醒内容（短信）</td>
					<td colspan="2"><textarea rows="5" style="width: 100%;"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<p style="margin: 10px 0 20px 0; color: #e96238;">注：不填写自定义提醒内容时，系统会按默认提醒内容发送</p>
		<table class="mho_table mho_table_center mho_table_border">
			<thead>
				<tr>
					<td colspan="2">设置其他审批步骤办理人</td>
				</tr>
			</thead>
			<tbody>
				<tr style="background: #f3f5ff;">
					<td style="width: 30%;">流程步骤</td>
					<td>用户选择</td>
				</tr>
				<tr style="text-align: left;">
					<td>1.经办人</td>
					<td><span class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="checkbox" name="myCheckbox"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">张晓凡</label></td>
				</tr>
				<tr style="text-align: left;">
					<td>2.项目组长审核</td>
					<td><span class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="checkbox" name="myCheckbox" checked><i
							class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">张晓凡</label> <span
						class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="checkbox" name="myCheckbox"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">李毅成</label></td>
				</tr>
				<tr style="text-align: left;">
					<td>3.部门经理审核</td>
					<td><span class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="checkbox" name="myCheckbox"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">张晓凡</label></td>
				</tr>
				<tr style="text-align: left;">
					<td>4.风管领导审核</td>
					<td><span class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
							type="checkbox" name="myCheckbox"><i class="fa fa-check"></i>
					</span> <label style="margin-right: 10px;">张晓凡</label></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>