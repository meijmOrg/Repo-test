<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>医院人事管理系统</title>
    <!-- <link rel="stylesheet" href="hspszhphtml/css/login.css">
    <link rel="stylesheet" href="hspszhphtml/css/common/reset.css">
    <link rel="stylesheet" href="hspszhphtml/css/common/base.css"> -->
    <link rel="stylesheet" href="yhhtml/font-awesome-4.7.0/css/font-awesome.css">
     <link rel="stylesheet" href="yhhtml/mho.css">
    <script type="application/x-javascript"> 
    	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    	if (parent.opener != null)  {
            parent.opener.location ="logout.do?method=logout";
            parent.close();
        }
    	if(parent != self) {
    		top.location.href=self.location.href;
    	}
    </script>
</head>
<%-- <body class="main-body">
    <div class="lg-title">
        <!-- <img src="hspszhphtml/images/copyright/logo_login.png"/> -->
        <img src="<%=request.getContextPath() %>/admin/imageinstall/image_view.jsp?systemCode=<%=com.yh.admin.imageinstall.queryhelper.ImageInstallQueryHelper.getSystemCode()%>&flag=logo&_<%=new java.util.Random().nextInt(1000) %>" alt="图片" width="100px;"/>&nbsp;
    </div>

    <div class="lg-banner">
        <div class="lg-container">
        <img style="width:500px;" src="<%=request.getContextPath() %>/admin/imageinstall/image_view.jsp?systemCode=<%=com.yh.admin.imageinstall.queryhelper.ImageInstallQueryHelper.getSystemCode()%>&flag=banner&_<%=new java.util.Random().nextInt(1000) %>" alt="图片" width="100px;"/>&nbsp;
            <div class="lg-ad-img"></div>
            <div class="lg-form-cont">
              <h2 class="lg-form-title">中国领先的医疗行业人事管理软件服务供应商</h2>
	            <form class="lg-form" action="login.do?method=login" method="post">
	                <h3 class="lg-form-title">用户登录</h3>
	                <div class="lg-form-item">
	                    <input class="lg-account lg-error-border" type="text" name="userCode" placeholder="请输入用户名" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
	                    <span class="lg-ac-icon lg-icon"></span>
	                    <span class="lg-error-icon"></span>
	                </div>
	                <div class="lg-error">
		                    <logic:messagesPresent>
								<ul>
									<html:messages id="error">
									<li><bean:write name="error" /></li>
									</html:messages>
								</ul>
							</logic:messagesPresent>
	                </div>
	                <div class="lg-form-item">
	                    <input class="lg-account" type="password" name="password" placeholder="请输入密码">
	                    <span class="lg-pw-icon lg-icon"></span>
	                </div>
	                <a class="lg-forget-pw"></a><!-- 忘记密码 -->
	                <button class="lg-submit" type="submit">登 录</button>
	            </form>
	          </div>
            <!-- <div class="cl"></div> -->
        </div>
    </div>

    <div class="lg-footer">深圳市嘉德永丰开发科技股份有限公司 版权所有</div>
</body> --%>
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