<%--
  Created by IntelliJ IDEA.
  User: joker
  Date: 14-9-23
  Time: 下午11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <jsp:include page="./common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/resources/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/resources/css/picture.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/pages/resources/js/common.js"></script>
    <title>音乐管理界面</title>
</head>
<body>
<div class="uk-grid">
    <div class="uk-width-1-1">
        <div class="topHeader">
            <header>
                <a href="#" class="header-brand">Orange</a>
                <ul class="header-nav"  id="headerNav">
                    <li><a href="index.html">首页</a></li>
                    <li><a href="aticle.html">文章</a></li>
                    <li><a href="picture.html">图片</a></li>
                    <li class="link_active"><a href="music.html">音乐</a></li>
                    <li><a href="video.html">视频</a></li>
                </ul>
            </header>
        </div>
    </div>
    </div>
</body>
</html>
