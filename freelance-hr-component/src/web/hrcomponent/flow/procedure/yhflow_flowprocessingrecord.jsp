<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程处理记录</title>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="mho_row">
			<label class="mho_col mho_col_2 mho_text_right line_height_35">流程处理记录</label>
			<div class="mho_col mho_col_10">
				<section class="mho_accordion">
					<!-- 遍历map key为轮次（key应等于varStatus+1） -->
					<c:if test="${empty tpMap}">
						<dl>
							<dt></dt>
							<dd>无</dd>
						</dl>
					</c:if>
					<c:forEach items="${tpMap}" var="map" varStatus="mapStatus">
						<dl class="mho_accordion_item" style="margin-top:${mapStatus.index*5}px;border:0;">
							<dt class="mho_accordion_title mho_pink mho_dep_pink_color" style="text-transform:uppercase;">第${map.key }轮报批<span class="mho_float_right mho_accordion_item_toggle"><i class="fa fa-angle-down fa-2x" style="line-height:40px;"></i></span></dt>
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
										<c:forEach items="${map.value}" var="list" varStatus="listStatus">
											<tr>
												<td>${list.taskProcessName }</td>
												<td>${list.taskProcessResult }</td>
												<td>${list.taskProcessExplain }</td>
												<td><a >查看附件</a></td>
												<td><a >查看协同记录</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</dd>
						</dl>
					</c:forEach>
				</section>
			</div>
		</div>
</body>
</html>