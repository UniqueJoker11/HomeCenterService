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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/resources/css/aticle.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/pages/resources/js/common.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="<%=request.getContextPath()%>/resources/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="<%=request.getContextPath()%>/resources/editor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="<%=request.getContextPath()%>/pages/resources/js/aticle.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8"
            src="<%=request.getContextPath()%>/resources/editor/lang/zh-cn/zh-cn.js"></script>
    <script>
        var ue = UE.getEditor('editor');
    </script>
    <title>文章首页</title>
</head>
<body>
<div class="uk-grid">
    <div class="uk-width-1-1">
        <div class="topHeader">
            <header>
                <a href="#" class="header-brand">Orange</a>
                <ul class="header-nav" id="headerNav">
                    <li><a href="index.html">首页</a></li>
                    <li class="link_active"><a href="aticle.html">文章</a></li>
                    <li><a href="picture.html">图片</a></li>
                    <li><a href="music.html">音乐</a></li>
                    <li><a href="video.html">视频</a></li>
                </ul>
            </header>
        </div>
    </div>
    <div class="uk-width-1-1">
        <div class="aticleMainContet">

            <ul class="uk-tab tab-nav colin-nav-banner" data-uk-switcher="{connect:'#switch-content'}">
                <li><a class="tabStyle" href="#">网站爬取</a></li>
                <li><a class="tabStyle" href="#">文章一览</a></li>
                <li><a class="tabStyle" href="#">发表文章</a></li>
                <li><a class="tabStyle" href="#">评论管理</a></li>
                <li><a class="tabStyle" href="#">草稿箱</a></li>
            </ul>

            <!-- 这是内容项的容器 -->
            <ul id="switch-content" class="uk-switcher uk-margin">
                <li>
                    <div class="uk-form-row">

                        <input type="text" name="spiderUrl" class="uk-width-5-6 uk-form-large"
                               id="spiderUrl" placeholder="请输入爬取文章URL">
                        <button id="spiderBtn" type="button" class="uk-button uk-button-primary colin-spider-btn">爬取</button>

                    </div>
                    <hr/>
                    <iframe id="urlContent" class="uk-width-1-1 colin-spider-iframe" src="http://www.baidu.com/"></iframe>
                    <div class="uk-width-1-1 uk-button-group" id="UrlLinkBtns">
                        <button class="uk-button uk-button-danger uk-button-large uk-width-1-3">收藏网页</button>
                        <button class="uk-button uk-button-success uk-button-large uk-width-1-3">网页编辑</button>

                    </div>
                </li>
                <li>
                    <div class="colin-tab-panel">
                        <div class="uk-grid" id="aticleContent">
                        </div>
                        <div class="uk-grid">
                            <div class="uk-width-1-1" id="aticlePagnation">
                            <ul id="aticlePagination" class="uk-pagination">

                            </ul>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="colin-tab-panel">
                        <form class="uk-form uk-form-horizontal" id="aticleContentForm">

                            <div class="uk-form-row">
                                <input type="text" name="aticleTitle" class="uk-width-1-1 uk-form-large"
                                       id="aticleTitle" placeholder="请输入文章标题">
                            </div>
                            <div class="uk-form-row">
                                <span class="error-tips"></span>
                            </div>
                            <div class="uk-form-row">
                                <input type="text" name="aticleDigest" class="uk-width-1-1 uk-form-large"
                                       id="aticleDigest" placeholder="请输入文章备注（可不填）">
                            </div>

                            <div class="uk-form-row">

                                <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
                            </div>

                            <div class="uk-form-row">

                                <div class="uk-form-controls uk-form-controls-text">

                                </div>
                            </div>
                            <div class="uk-form-row" style="text-align: center">
                                <button type="submit" id="aticleSubmitBtn" name="submitBtn"
                                        class="uk-width-1-5 uk-button uk-button-large uk-button-primary uk-button-expand">
                                    提交
                                </button>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="reset" id="aticleResetsBtn" name="resetBtn"
                                        class="uk-width-1-5 uk-button uk-button-large uk-button-danger">取消
                                </button>

                            </div>

                        </form>
                    </div>
                </li>
                <li>
                    <div class="colin-tab-panel">
                        <table class="uk-table">
                            <thead>
                            <tr>
                                <th>文章标题</th>
                                <th>文章摘要</th>
                                <th>文章阅读次数</th>
                                <th>评论次数</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </li>
                <li>
                    <div class="colin-tab-panel">
                        <p id="testContent">Contntifesafiejfei</p>
                        <ul class="uk-pagination">
                            <li><a href="">...</a></li>
                            <li class="uk-active"><span>...</span></li>
                            <li class="uk-disabled"><span>...</span></li>
                            <li><span>...</span></li>
                        </ul>
                        <div>
                            <p id="tese1">fewofjoiajiaw</p>

                            <p id="test2">knvseklfnisnlvnsifhgieowjfiowjriow</p>

                            <p id="test3">fnELIfjeliwnfkwenflwenfelwiflw</p>
                        </div>
                    </div>
                </li>
            </ul>

        </div>
    </div>
</div>
<div id="checkDetailDialog" class="uk-modal">
    <div class="uk-modal-dialog">
        <a class="uk-modal-close uk-close"></a>
        查看文章详情
    </div>
</div>
<div id="addTagDialog" class="uk-modal">
    <div class="uk-modal-dialog">
        <a class="uk-modal-close uk-close"></a>
        添加文章标记
    </div>
</div>
<div id="editAticleDialog" class="uk-modal">
    <div class="uk-modal-dialog">
        <a class="uk-modal-close uk-close"></a>
        编辑文章
    </div>
</div>
<div id="delateAticleDialog" class="uk-modal">
    <div class="uk-modal-dialog">
        <a class="uk-modal-close uk-close"></a>
        删除文章
    </div>
</div>
<!-- 查看文章详情弹出框-->
<div id="my-id" class="uk-modal">
    <div class="uk-modal-dialog">
        <a class="uk-modal-close uk-close"></a>
        <h3>文章标题</h3>
        <div>digest</div>
        <div>content</div>
    </div>
</div>
</body>
</html>
