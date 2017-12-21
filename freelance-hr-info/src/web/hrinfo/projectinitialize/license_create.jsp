<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>license生成页面</title>
	<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/comm/customJs.js"></script>
   	<script>
   	$(function() {
   	    $("#button").click(function() {
   	    	var mw = $("#mw").val();
   	    	if(mw == ''||mw == null){
   	    		alert("请输入明文！");
   	    		return;
   	    	}
   	    	$.get("createLicense.do?method=createLicense&mw="+$("#mw").val(),function(data,status){
   	    	    //alert("数据: " + data + "\n状态: " + status);
   	    	  $("#license").val(eval("("+data+")").message);
   	    	  });
   	    });
   	});
   	</script>
</head>
<body>
<div id="showmodal" class="modal-content">
    	<div class="modal-header">
            <button type="button" class="close close-popdown" data-dismiss="modal" aria-label="Close" button-click="widget-close">
            	<span aria-hidden="true" >&times;</span>
            </button>
            <h4 class="modal-title">license&gt;生成</h4>
    	</div>		
     	<div class="modal-body">	
            	<div class="modal-row03">
            		<dl>
            			<dt title="明文（单位名称加八位密钥）："><b class="Required">* </b>明文（单位名称加八位密钥）：</dt>
            			<dd>
            				<label>
	                             <input type="text" id="mw" class="modal_iput" maxlength="200" /> 
	                      	</label>
            			</dd>
            		</dl>
            	</div>
            	<div class="modal-row03">
            		<dl>
            			<dt>License码：</dt>
            			<dd>
            				<label>
	                             <input type="text" id="license" class="modal_iput" readOnly="readOnly" /> 
	                      	</label>
            			</dd>
            		</dl>
            	</div>
           </div>	
      	  <div class="modal-footer">
               <input  type="button" id="button" class="btn btn-primary" value="生　成">
               <button type="button" class="btn btn-default close-login" data-dismiss="modal" button-click="widget-close">
               <a href="#" class="close-popdown">取　消</a></button>
          </div>
    </div>
</body>

</html>