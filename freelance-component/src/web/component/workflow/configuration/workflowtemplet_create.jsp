<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
 * @function    模板管理新增页面
 * @page name   workflowtemplet_create.jsp
 * @author      liul
 * @created     2017/11/28
 * @version     1.0
-->
<!DOCTYPE html>
<html>
<head lang="l">
    <meta charset="UTF-8">
     <title>模板管理新增页面</title>
	<script type="text/javascript" src="js/comm/customJs.js"></script>
   	<script>
   	</script>
</head>
<body>
<div id="showmodal" class="modal-content">
<form id="workflowConfigurationForm" class="form-inline" action="insertWorkflowTemplet.do?method=insertTemplet" method="post" onsubmit="return false">
		<div class="modal-header">
            <button type="button" class="close close-popdown" data-dismiss="modal" aria-label="Close" button-click="widget-close">
            	<span aria-hidden="true" >&times;</span>
            </button>
            <h4 class="modal-title">模板信息&gt;新增</h4>
    	</div>		
     	<div class="modal-body">	
            <div class="modal-wrong" style="display: none">
                	<ol class="titwrong"><embed src="img/index/jg.svg" width="20" height="20" top="0" type="image/svg+xml" class="ico"/> 以下信息有误，请重新输入！</ol>
               		<ol class="wroglist">
                    	<logic:messagesPresent>
                        	<html:messages id="error">
                           		<li><bean:write name="error" /></li>
                        	</html:messages>
                    	</logic:messagesPresent>
                	</ol>
            </div>
	       	<jsp:include page="/component/workflow/configuration/workflowtemplet_body.jsp"></jsp:include> 	
        </div>
        
         <div class="modal-footer">
               <input  type="submit" class="btn btn-primary" value="保　存">
               <button type="button" class="btn btn-default close-login" data-dismiss="modal" button-click="widget-close">
               <a href="#" class="close-popdown">取　消</a></button>
          </div>
</form>
</div>
</body>
</html>