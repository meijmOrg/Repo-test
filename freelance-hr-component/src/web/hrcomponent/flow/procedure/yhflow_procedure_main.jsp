<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程过程</title>
<link rel="stylesheet" href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">

<!-- <link rel="stylesheet" type="text/css" href="component/front_transform/webuploader-0.1.5/webuploader.css"> -->
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<!-- <script src="js/jquery.form.min.js"></script> -->
<script src="component/front_transform/webuploader-0.1.5/webuploader.js"></script>
<script src="component/front_transform/component/accordion/accordion.js"></script>
<script type="text/javascript">
var serverUrl = '${pageContext.request.contextPath}';
var maxFileSize = parseInt('${maxFileSize}')*1024*1024;
var acceptFileTypes = '${acceptFileTypes}'.toLowerCase();
var fileId = '343sdfdf';
var faUserName = '自定义的';
//acceptFileTypes = acceptFileTypes ? acceptFileTypes.split(',') : [];
//var maxFileCounts = parseInt('${maxFileCounts}');
</script>
</head>
<body>
	<div style="background:#fff;padding:20px 60px 20px 0;">
		<jsp:include page="../yhflow_attachment_view.jsp">
			<jsp:param value="mho_col_10" name="widthFlag"/>
		</jsp:include>
		<jsp:include page="yhflow_carboncopy.jsp">
		</jsp:include>
		<jsp:include page="yhflow_flowprocessingrecord.jsp">
		</jsp:include>
		<jsp:include page="../yhflow_suggestion.jsp">
			<jsp:param value="mho_col_10" name="widthFlag"/>
		</jsp:include>
		<jsp:include page="../yhflow_attachment.jsp">
			<jsp:param value="mho_col_10" name="widthFlag"/>
		</jsp:include>
		<jsp:include page="../yhflow_button.jsp"></jsp:include>
	</div>
	<!-- <script src="component/front_transform/index/flow/flow.js"></script> -->
	<script src="hrcomponent/flow/js/YhflowAttachment.js"></script>
</body>
</html>