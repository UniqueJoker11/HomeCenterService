<%--
  Created by IntelliJ IDEA.
  User: joker
  Date: 14-9-18
  Time: 下午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="./common/header.jsp"></jsp:include>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/resources/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/resources/css/index.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/pages/resources/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/pages/resources/js/index.js"></script>

    <title>Blog首页</title>
</head>
<body>
<div class="uk-grid">
    <div class="uk-width-1-1">
        <header class="colin-top-nav">
            <a href="#" class="header-brand">Orange</a>
        </header>

    </div>
</div>
<div class="uk-grid">
    <div class="uk-width-1-1">
        <div class="topHeader">
            <header>
                <a href="#" class="header-brand">Orange</a>
                <ul class="header-nav" id="headerNav">
                    <li class="link_active"><a href="index.html">首页</a></li>
                    <li><a href="aticle.html">文章</a></li>
                    <li><a href="picture.html">图片</a></li>
                    <li><a href="music.html">音乐</a></li>
                    <li><a href="video.html">视频</a></li>
                </ul>
            </header>
        </div>
    </div>
</div>
<div class="uk-container uk-container-center">
    <div class="uk-grid">
        <div class="uk-width-medium-1-1">

            <div class="uk-grid">
                <div class="uk-width-5-6">
                    <fieldset class="colin-aticles">
                        <legend>最新文章</legend>
                        <ul>
                            <li>
                                <div class="uk-panel uk-panel-box">
                                    <div class="uk-panel-badge uk-badge uk-badge-danger">New</div>
                                    <h3 class="uk-panel-title">文章标题</h3>
                                    比起忙碌的工作日，一个人的周末更让人不知所措
                                    起床、吃饭、摊在床上盯着天花板发呆。窗外光影变换，到日落黄昏之时，寻一部电影，戴上耳机，某个镜头让人心底一暖。恰到好处的旋律不经意间流淌出来，无法言语的情绪慢慢发酵...
                                    一个人看电影
                                    一个人听电影里的歌 一个人也可以这般美好
                                    <div class="uk-panel-foot">
                                        <ul>
                                            <li><a href="#" data-uk-tooltip title="添加书签"
                                                   class="uk-icon-button uk-icon-bookmark-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="标注记号"
                                                   class="uk-icon-button uk-icon-circle-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="添加星级"
                                                   class="uk-icon-button uk-icon-star-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="发表评论"
                                                   class="uk-icon-button uk-icon-comment-o"></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="uk-panel uk-panel-box">
                                    <div class="uk-panel-badge uk-badge uk-badge-danger">New</div>
                                    <h3 class="uk-panel-title">文章标题</h3>
                                    比起忙碌的工作日，一个人的周末更让人不知所措
                                    起床、吃饭、摊在床上盯着天花板发呆。窗外光影变换，到日落黄昏之时，寻一部电影，戴上耳机，某个镜头让人心底一暖。恰到好处的旋律不经意间流淌出来，无法言语的情绪慢慢发酵...
                                    一个人看电影
                                    一个人听电影里的歌 一个人也可以这般美好
                                    <div class="uk-panel-foot">
                                        <ul>
                                            <li><a href="#" data-uk-tooltip title="添加书签"
                                                   class="uk-icon-button uk-icon-bookmark-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="标注记号"
                                                   class="uk-icon-button uk-icon-circle-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="添加星级"
                                                   class="uk-icon-button uk-icon-star-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="发表评论"
                                                   class="uk-icon-button uk-icon-comment-o"></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="uk-panel uk-panel-box">
                                    <div class="uk-panel-badge uk-badge uk-badge-danger">New</div>
                                    <h3 class="uk-panel-title">文章标题</h3>
                                    比起忙碌的工作日，一个人的周末更让人不知所措
                                    起床、吃饭、摊在床上盯着天花板发呆。窗外光影变换，到日落黄昏之时，寻一部电影，戴上耳机，某个镜头让人心底一暖。恰到好处的旋律不经意间流淌出来，无法言语的情绪慢慢发酵...
                                    一个人看电影
                                    一个人听电影里的歌 一个人也可以这般美好
                                    <div class="uk-panel-foot">
                                        <ul>
                                            <li><a href="#" data-uk-tooltip title="添加书签"
                                                   class="uk-icon-button uk-icon-bookmark-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="标注记号"
                                                   class="uk-icon-button uk-icon-circle-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="添加星级"
                                                   class="uk-icon-button uk-icon-star-o"></a></li>
                                            <li><a href="#" data-uk-tooltip title="发表评论"
                                                   class="uk-icon-button uk-icon-comment-o"></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </fieldset>
                </div>
                <div class="uk-width-1-6">
                    <fieldset>
                        <legend>最新文章</legend>
                    </fieldset>
                    <fieldset>
                        <legend>阅读排行</legend>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
