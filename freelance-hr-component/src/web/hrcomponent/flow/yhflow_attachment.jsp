<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程启动</title>
</head>
<body>
	<div class="mho_row mho_row_no_margin">
		<div class="mho_col mho_col_2"></div>
		<div class="mho_col mho_col_8">
			<div class="mho_form_group">
				<input id="file_name" type="text" readonly class="mho_form_field"
					style="width: 200px; flex-grow: 0;">
				<button id="pick_file" type="button"
					class="mho_btn mho_btn_primary mho_btn_file"
					style="margin-left: 20px;">浏览</button>
				<button type="button" class="mho_btn mho_btn_primary"
					style="margin-left: 20px;">上传</button>
			</div>
		</div>
	</div>
	<div class="mho_row">
		<label class="mho_col mho_col_2 mho_text_right line_height_35">附件信息</label>
		<div class="mho_col mho_col_8">
			<section class="mho_accordion">
				<dl class="mho_accordion_item" style="border: 0;">
					<dt class="mho_accordion_title mho_pink mho_dep_pink_color">文件信息</dt>
					<dd class="mho_accordion_body" style="padding: 0;">
						<ul class="mho_list mho_list_strip">
							<li><a href="javascript:void(0)">后勤保障处举办“五小”创新成果评选活动.jpg</a>
								<a href="javascript:void(0)"
								class="mho_float_right mho_red_color" style="margin: 0 10px;">删除</a>
								<a href="javascript:void(0)"
								class="mho_float_right mho_green_color" style="margin: 0 10px;">下载</a>
							</li>
						</ul>
					</dd>
				</dl>
			</section>
		</div>
	</div>
</body>
</html>