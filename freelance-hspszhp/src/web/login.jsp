<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>医院人事管理系统</title>
    <link rel="stylesheet" href="component/front_transform/mho.css">
    <link rel="stylesheet" href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
    <script type="application/x-javascript"> 
    	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    	if (parent.opener != null)  {
            parent.opener.location ="logout.do?method=logout";
            parent.close();
        }
    	if(parent != self) {
    		top.location.href=self.location.href;
    	}
	document.onkeyup = function (e) {  
    if (window.event)//如果window.event对象存在，就以此事件对象为准  
        e = window.event;  
    var code = e.charCode || e.keyCode;  
    if (code == 13) {  
        //此处编写用户敲回车后的代码  
	document.getElementById('yhlogin').submit();
    }  
}  

    </script>
</head>
<body>
	<div class="mho_login_bg">
		<div class="mho_login mho_row">
			<div class="mho_col mho_col_6 mho_login_img">
			</div>
			<div class="mho_col mho_col_6">
				<form class="mho_login_form" id="yhlogin" action="login.do?method=login" method="post" >
					<h2>医院人事信息管理系统</h2>
					<div class="mho_form_group yh_input">
						<input type="text" name="userCode" placeholder="请输入用户名" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
					</div>
				  
					<div class="mho_form_group yh_input">
						<input type="password" name="password" placeholder="请输入密码" >
					</div>
					<div class="mho_form_group">
                  		 <input type="button" onclick="document.getElementById('yhlogin').submit();" value="登 录">
                  	</div>
                  	<div class="mho_form_group">
                  	 <div class="lg-error">
		                    <logic:messagesPresent>
								<ul>
									<html:messages id="error">
									<li><bean:write name="error" /></li>
									</html:messages>
								</ul>
							</logic:messagesPresent>
	                </div>
	                </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>