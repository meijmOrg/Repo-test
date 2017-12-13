<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/js_css_base_include.jsp"%>  
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="admin/imageinstall/js/photo_operation.js"></script>
<title>系统外观设置</title>
<script type="text/javascript">

</script>
</head>
<body style="overflow-x: hidden;">
<div>
	<div class="sitemap" style="padding-bottom: 10px;">
		<ul>
			<li>当前位置：</li>
			<li>系统管理<span class="spanColor"> > </span></li>
			<li>外观设置<span class="spanColor"></span></li>
		</ul>
		<div style="clear: both"></div>
	</div>
	<div class="search search-horizontal-small">
		<form id="uploadForm" action="updateImageInstall.do?method=updateImageInstall" method="post" enctype="multipart/form-data">
		<!-- <div id="transaction_modal_box" class="transaction_modal_box"> -->
			<!-- <div class="modal-dialog-container">
			<div class="md-main-content">
			<div class="md-units md-three-column clearfix"> -->
		<!-- <div class="md-units md-three-column md-unit-hasimg clearfix"> -->
		<dl class="updown-dl">
			<dt>客户名称：</dt>
	        <dd><label>${adminUnit.unitName}人事信息管理系统</label></dd>
		</dl>
		<dl class="updown-dl updown-img">
			<dt>
				客户Logo
			</dt>
			<dd>
				<div class="md-unit-img">
					<img name="offerImg" id="previewImg" src="<%=request.getContextPath() %>/admin/imageinstall/image_view.jsp?systemCode=1000&flag=logo&_<%=new java.util.Random().nextInt(1000) %>" alt="照片" />
				</div>
				<a class="img-upload"> <input type="file" id="file_upload" name="logoPhotoPath" accept="image/*">选择照片 </a>
				<p class="md-unit-p" title="图片请小于100K（jpg、png、bmp、gif、tif等）">图片请小于500K（jpg、png、bmp、gif、tif等）</p>
			</dd>
		</dl>
		<div class="md-btn">
					<input type="button" value="上传Logo" onClick="uploadLogoPhoto()"/>
			</div>
		<dl class="updown-dl updown-img">
			<dt>
				客户Banner
			</dt>
			<dd>
				<div class="md-unit-img">
					<img name="offerImg2" id="previewImg2" src="<%=request.getContextPath() %>/admin/imageinstall/image_view.jsp?systemCode=1000&flag=banner&_<%=new java.util.Random().nextInt(1000) %>" alt="照片" />
				</div>
				<a class="img-upload"> <input type="file" id="file_upload2" name="bannerPhotoPath" accept="image/*">选择照片 </a>
				<p class="md-unit-p" title="图片请小于100K（jpg、png、bmp、gif、tif等）">图片请小于500K（jpg、png、bmp、gif、tif等）</p>
			</dd>
		</dl>
	<!-- </div>
	</div> -->
	<!-- </div> -->
          <div class="md-btn">
					<input type="button" value="上传Banner" onClick="uploadBannerPhoto()"/>
			</div>
			 <div class="md-btn">
					<input type="button" value="一键上传" onClick="uploadPhoto()"/>
			</div>
			<!-- </div> -->
	<!-- </div> -->
		</form>
	</div>
	
</div>
</body>
</html>