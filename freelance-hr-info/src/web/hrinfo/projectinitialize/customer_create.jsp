<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>增加客户页面</title>
	<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="hrinfo/projectinitialize/js/customer_validate.js"></script>
	<script type="text/javascript" src="js/comm/customJs.js"></script>
   	<script>
   	
   	</script>
</head>
<body>
<div id="showmodal" class="modal-content">
   <form id="formCustomerCreate" class="form-inline" action="createCustomerInfo.do?method=createCustomerInfo" method="post" onsubmit="return false" >
    	<div class="modal-header">
            <button type="button" class="close close-popdown" data-dismiss="modal" aria-label="Close" button-click="widget-close">
            	<span aria-hidden="true" >&times;</span>
            </button>
            <h4 class="modal-title">客户信息&gt;新增</h4>
    	</div>		
     	<div class="modal-body">	
                <input style="display: none;" type="text"  id="customerOid" name="customerOid"  /> 
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
            	<div class="modal-row03">
            		<dl>
            			<dt><b class="Required">* </b>License码</dt>
            			<dd>
            				<label>
	                             <input type="text" id="licenseCode" name="licenseCode" class="modal_iput" maxlength="200" /> 
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>客户简称：</dt>
            			<dd>
            				<label>
	                             <input type="text" id="customerName" name="customerName" class="modal_iput" maxlength="100" /> 
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>单位地址：</dt>
            			<dd>
            				<label>
	                             <input type="text" id="address" name="address" class="modal_iput" maxlength="250" /> 
	                      	</label>
            			</dd>
            		</dl>
            	</div>
            	<div class="modal-row03">
            		<dl>
            			<dt>单位电话：</dt>
            			<dd>
            				<label>
	                             <input type="text" id="phone" name="phone" class="modal_iput" maxlength="100" /> 
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>单位负责人：</dt>
            			<dd>
            				<label>
	                             <input type="text" id="contacter" name="contacter" class="modal_iput" maxlength="100" /> 
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>联系电话：</dt>
            			<dd>
            				<label>
	                             <input type="text" id="contactType" name="contactType" class="modal_iput" maxlength="100" /> 
	                      	</label>
            			</dd>
            		</dl>
            	</div>
            	<div class="modal-row03">
            		<dl>
            			<dt><b class="Required">* </b>启动状态：</dt>
            			<dd>
            				<label>
	                             <select name="startStatus" class="modal_select">
									<option value="0">未启动</option>
									<option value="1">已启动</option>
								 </select>
	                      	</label>
            			</dd>
            		</dl>
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