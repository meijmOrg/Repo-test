<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%@taglib uri="dictionary.tld" prefix="dictionary" %>
<%@taglib uri="c.tld" prefix="c"%>
<!--
 * @function    模板管理修改页面
 * @page name   workflowtemplet_update.jsp
 * @author      liul
 * @created     2017/11/28
 * @version     1.0
-->
<!DOCTYPE html>
<html>
<head lang="l">
    <meta charset="UTF-8">  
    <title>模板管理修改页面</title>
    <script type="text/javascript" src="component/workflow/configuration/js/CheckWorkflowTemplet.js"></script>
	<script type="text/javascript" src="js/comm/customJs.js"></script>
	<script type="text/javascript">
	var templateId = '${workflowConfigurationForm.templateId }';
	</script>
</head>

<body>
<div id="showmodal" class="modal-content">
<form id="workflowConfigurationForm" class="form-inline" action="updateWorkflowTemplet.do?method=updateTemplet" method="post" onsubmit="return false">
		<div class="modal-header">
            <button type="button" class="close close-popdown" data-dismiss="modal" aria-label="Close" button-click="widget-close">
            	<span aria-hidden="true" >&times;</span>
            </button>
            <h4 class="modal-title">模板信息&gt;修改</h4>
    	</div>		
     	<div class="modal-body">	
            <input style="display: none;" type="text"  id="dpCode" name="dpCode"  value=""/>
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
            <div class="md-main-content">
            	<input type="hidden" name="flagStatus" value="UPDATE"/>
	       		<jsp:include page="/component/workflow/configuration/workflowtemplet_body_dp.jsp"></jsp:include>    	
        	</div>
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