<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<%@page import="com.yh.component.dynamicproperty.util.DynamicPropertyUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0" />
<title>医院人事管理系统</title>
<%@ include file="/include/js_css_base_include.jsp"%>
<script src="hspszhphtml/js/plugin/jadeforturepull_top_bottom.js"></script>
<script type="text/javascript">
var MESSAGE_LIMIT = 10;
$(function() {
    // 页面加载后各区域的高度设置
    function eachAreaHeight() {
        var windowHeight = $(window).height();

        //主内容区高度
        $('.main-container').height(windowHeight - $('.head-nav').outerHeight(true) -$('.current-position').outerHeight(true) - 2);
    }
    eachAreaHeight();

    $(window).resize(
        function () {
            eachAreaHeight();
        }
    );
    $.drag_top_bottom("index-main-id","index-top-id","index-bottom-id","index-line-id");
    var dpCode = $(this).attr('dpCode');
    goToTableProperty(dpCode);
    goToDynamicProperty(dpCode);
});
function goToTableProperty(dpCode){
	$("#messageContent").load("goToPropertyList.do?method=goToPropertyList&dpCode="+dpCode+"&flag='Y'");
}

function goToDynamicProperty(dpCode){
	$("#warningRight").load("goToPropertyList.do?method=goToPropertyList&dpCode="+dpCode);
}
function changeDpCode(obj){
	goToTableProperty(obj.value);
    goToDynamicProperty(obj.value);
}
</script>
</head>
<body class="main-body">
<div id="head-nav"></div>
<div class="current-position">
当前位置 : 
	<span>基础信息管理 > </span>
    <span>信息管理 > </span>
	<span>自定义字段</span></div>
<div style="clear: both"></div>
<div class="main-container">
  <div class="right-content" id="index-main-id">
    <div class="imain-list il-warning" id="index-top-id">
        <div class="img-text">
            <dt class="search-unit-dt">动态管理编码：</dt>
						<dd class="search-unit-dd">
							<label> <dictionary:dicItemSelect dicTypeCode="<%=DynamicPropertyUtil.YHRS3003 %>"  id="dpCode" name="dpCode" onchange="changeDpCode(this)" /> </label>
						</dd>
        </div>
        <div class="index-tabs clearfix" id="messageTab">
                <div class="tabs-line" id="messageDragLine"></div>
	      <div id="messageContent" class="i-tab-content">
	      </div>
      </div>
</div>
    
    <div class="index-line" id="index-line-id"><img src="./hspszhphtml/images/index/drag-up-down.png"/></div>
    
    <div class="imain-list il-warning" id="index-bottom-id">
	    <div class="img-text" id="img-warning-id">
	      <span>动态字段管理库信息</span>
	    </div>
	    <div class="index-tabs clearfix" id="messageTabWarning">
			  <div class="tabs-line" id="warningDragLine"></div>
	      <div id="warningRight">
	      </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>