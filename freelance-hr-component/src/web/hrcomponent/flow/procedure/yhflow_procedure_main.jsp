<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程过程</title>
<link rel="stylesheet" href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="component/front_transform/webuploader-0.1.5/webuploader.js"></script>
<script src="component/front_transform/component/accordion/accordion.js"></script>
</head>
<body>
	<div style="background:#fff;padding:20px 60px 20px 0;">
		<jsp:include page="../yhflow_attachment_view.jsp">
			<jsp:param value="mho_col_10" name="widthFlag"/>
		</jsp:include>
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
						<tr>
							<td>1</td>
							<td>王明</td>
							<td>李健</td>
							<td>2018-01-03</td>
							<td><a>关于医疗处理的意见.doc</a></td>
						</tr>
						<tr>
							<td>1</td>
							<td>李晓</td>
							<td>张三三</td>
							<td>2018-01-15</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="mho_row">
			<label class="mho_col mho_col_2 mho_text_right line_height_35">流程处理记录</label>
			<div class="mho_col mho_col_10">
				<section class="mho_accordion">
					<dl class="mho_accordion_item" style="border:0;">
						<dt class="mho_accordion_title mho_pink mho_dep_pink_color">第一轮报批<span class="mho_float_right mho_accordion_item_toggle"><i class="fa fa-angle-down fa-2x" style="line-height:40px;"></i></span></dt>
						<dd class="mho_accordion_body" style="padding:0;">
							<table class="mho_table mho_table_center mho_table_border">
								<thead>
									<tr style="background:#f3f5ff;">
										<td>流程</td>
										<td>审批结果</td>
										<td>审批意见</td>
										<td>附件信息</td>
										<td>协同记录</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>经办人：吴忠义</td>
										<td>通过</td>
										<td>关于本流程的意见</td>
										<td><a>查看附件</a></td>
										<td><a>查看协同记录</a></td>
									</tr>
									<tr>
										<td>项目经理：王勤贵</td>
										<td>未通过</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</dd>
					</dl>
					<dl class="mho_accordion_item" style="margin-top:5px;border:0;">
						<dt class="mho_accordion_title mho_pink mho_dep_pink_color">第二轮报批<span class="mho_float_right mho_accordion_item_toggle"><i class="fa fa-angle-down fa-2x" style="line-height:40px;"></i></span></dt>
						<dd class="mho_accordion_body" style="padding:0;">
							<table class="mho_table mho_table_center mho_table_border">
								<thead>
									<tr style="background:#f3f5ff;">
										<td>流程</td>
										<td>审批结果</td>
										<td>审批意见</td>
										<td>附件信息</td>
										<td>协同记录</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>经办人：吴忠义</td>
										<td>通过</td>
										<td>关于本流程的意见</td>
										<td><a>查看附件</a></td>
										<td><a>查看协同记录</a></td>
									</tr>
									<tr>
										<td>项目经理：王勤贵</td>
										<td>未通过</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</dd>
					</dl>
				</section>
			</div>
		</div>
		<jsp:include page="../yhflow_suggestion.jsp">
			<jsp:param value="mho_col_10" name="widthFlag"/>
		</jsp:include>
		<jsp:include page="../yhflow_attachment.jsp">
			<jsp:param value="mho_col_10" name="widthFlag"/>
		</jsp:include>
		<jsp:include page="../yhflow_button.jsp"></jsp:include>
	</div>
	<script src="component/front_transform/index/flow/flow.js"></script>
</body>
</html>