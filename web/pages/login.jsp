<%--
  Created by IntelliJ IDEA.
  User: joker
  Date: 14-9-11
  Time: 下午11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <jsp:include page="common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/resources/css/login.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/pages/resources/js/login.js"></script>
    <title>首页登录</title>
</head>
<body>
<div class="uk-grid">
    <div class="uk-width-1-1">
        <header class="header_model">
            <div class="logo">
                <h1>Orange</h1>
                <h2>cute<span class="f3">、</span>funny<span class="f3">、</span>geek<span class="f3">、</span>lovely</h2>
            </div>
            <div id="linkTab" class="form_model">
                <a href="#registerForm" class="tabPanel tabTitle" onclick="return false;">注册&nbsp;&nbsp;|&nbsp;&nbsp;Regiter</a>
                <a href="#loginForm" class="tabPanel tabTitle" onclick="return false;">登录&nbsp;&nbsp;|&nbsp;&nbsp;Login</a>
            </div>
            <div class="panelModel">
                <div id="registerForm">
                    <form class="uk-form uk-form-horizontal registerForm" id="registerFormModel" >
                        <div class="uk-form-row">
                            <label class="uk-form-label">邮箱|Email</label>
                            <div class="uk-form-controls">
                                <input type="text" name="username" class="uk-form-width-large" placeholder="请输入注册邮箱"/>
                            </div>
                            <label class="uk-form-controls" style="display: none">*用户名错误</label>
                        </div>
                        <div class="uk-form-row">
                            <label class="uk-form-label">密码|Password</label>
                            <div class="uk-form-controls">
                                <input type="password" name="password" class="uk-form-width-large" placeholder="请设置密码"/>
                            </div>
                            <label class="uk-form-controls" style="display: none">*密码错误</label>
                        </div>
                        <div class="uk-form-row">
                            <div class="uk-form-controls">
                               <button class="uk-button uk-button-primary uk-button-large uk-width-1-3" type="submit">注册｜Register</button>
                                <button class="uk-button uk-button-primary uk-button-large uk-width-1-3" type="reset" id="resetBtn">重置｜Reset</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div id="loginForm" style="display: none">
                    <form class="uk-form uk-form-horizontal registerForm" method="post" action="userLogin.html" id="loginFormModel">
                        <div class="uk-form-row">
                            <label class="uk-form-label" for="">邮箱|Email</label>
                            <div class="uk-form-controls">
                                <input type="text" class="uk-form-width-large" id="userLoginName" name="userLoginName" placeholder="请输入登录用户名"/>
                            </div>
                        </div>
                        <div class="uk-form-row">
                            <label class="uk-form-label" for="">密码|Password</label>
                            <div class="uk-form-controls">
                                <input type="password" class="uk-form-width-large" id="userLoginPassword" name="userLoginPassword" placeholder="请输入密码"/>
                            </div>
                        </div>
                        <div class="uk-form-row">
                            <div class="uk-form-controls">
                                <input class="uk-button uk-button-primary uk-button-large uk-width-1-3" type="submit" value="登录｜Login"/>

                                <input class="uk-button uk-button-primary uk-button-large uk-width-1-3" type="reset" value="重置｜Reset"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </header>

    </div>
    <div class="uk-width-1-1">
        <div class="footer-style">
            <h1>随性的记录方式</h1>
        </div>
    </div>
</div>

</body>
</html>
