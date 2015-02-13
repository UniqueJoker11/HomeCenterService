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
    <title>图片管理</title>
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
                    <li class="link_active"><a href="picture.html">图片</a></li>
                    <li><a href="music.html">音乐</a></li>
                    <li><a href="video.html">视频</a></li>
                </ul>
            </header>
        </div>
    </div>
    <div class="uk-width-1-1">
        <ul class="uk-tab uk-active tab-nav colin-nav-banner" data-uk-tab="{connect:'#switch-content'}">
            <li><a class="tabStyle" href="#">网站爬取</a></li>
            <li><a class="tabStyle" href="#">发表文章</a></li>
            <li><a class="tabStyle" href="#">评论管理</a></li>
            <li><a class="tabStyle" href="#">草稿箱</a></li>
        </ul>

        <!-- 这是内容项的容器 -->
        <ul id="switch-content" class="uk-switcher uk-margin">
            <li>efbjkbkjbkhbjkbllnkln
                </br> illkml;w</li>
            <li>efwvWESFc</li>
            <li>efwvew</li>
            <li>efwvew</li>
        </ul>
    </div>
    </div>
</body>
</html>
