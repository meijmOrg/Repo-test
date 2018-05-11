<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>附件</title>
<style type="text/css">
	
</style>
<script type="text/javascript">
  /* (function($, window, document){
		
	})(jQuery, window, document);  */
	</script>
</head>
<body>
	<div class="mho_row mho_row_no_margin" id="dndArea">
		<div class="mho_col mho_col_2"></div>
		<div class="mho_col mho_col_8">
			<div class="mho_form_group">
				<input id="file_name" type="text" readonly class="mho_form_field"
					style="width: 200px; flex-grow: 0;">
				<button id="pick_file" type="button"
					class="mho_btn mho_btn_primary mho_btn_file"
					style="margin-left: 20px;">浏览</button>
				<button id="upload_file" type="button" class="mho_btn mho_btn_primary"
					style="margin-left: 20px;">上传</button>
			</div>
		</div>
	</div>
	<div class="mho_row">
		<label class="mho_col mho_col_2 mho_text_right line_height_35">附件信息</label>
			<div class="mho_col <%=request.getParameter("widthFlag")%>">
			<section class="mho_accordion">
				<dl class="mho_accordion_item" style="border: 0;">
					<dt class="mho_accordion_title mho_pink mho_dep_pink_color">文件信息</dt>
					<dd class="mho_accordion_body" style="padding: 0;">
						<ul class="mho_list mho_list_strip" id="list_ul">
							<c:forEach items="${annexFileList}" var="dto" varStatus="status">
								<li id="${dto.faId }"><a href='javascript:void(0)'  onclick="downloadFile('${dto.faId}')">${dto.faName }</a><span class='state'>已上传</span>
								<a href='javascript:void(0)' class='mho_float_right mho_red_color' style='margin: 0 10px;' onclick="downloadFile('${dto.faId}')">下载</a>
								<a href='javascript:void(0)' class='mho_float_right mho_green_color' style='margin: 0 10px;' onclick="deleteFile('${dto.faId}')">删除</a>
								</li>
							</c:forEach>
						</ul>
					</dd>
				</dl>
			</section>
			</div>
	</div>
</body>
</html>