<%--
  Created by IntelliJ IDEA.
  User: joker
  Date: 14-12-25
  Time: 下午9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/uikit.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/switchPic/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/resources/css/blog.css">
    <!--引入Js文件-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/modernizr.custom.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/uikit.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/switchPic/js/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/switchPic/js/transit.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/switchPic/js/touchSwipe.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/switchPic/js/simpleSlider.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/switchPic/js/backstretch.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/switchPic/js/custom.js"></script>
    <title>博客首页</title>
</head>
<body>

<div class='pagewrap'>

    <div class='pageblock' id='fullscreen'>
        <div class='slider'>
            <div class='slide' id="first">
                <div class='slidecontent'>
                    <span class="headersur">It's powerful and at the same time a</span>
                    <h1>SIMPLE SLIDER</h1>
                    <div class="button" onclick="mainslider.nextSlide();">Let me show you how simple</div>
                </div>
            </div>
            <div class='slide' id="sec">
                <div class='slidecontent'>
                    <span class="headersur">Grab your shit together and</span>
                    <h1>INCLUDE</h1>
                    <div class="text">
                        <p>Go to the  Github page and download the simpleslider.js file. Don't forget to download the touchswipe.js and transit.js if you're going for a complete (and still simple) slider.<br>Now you have the files you can include them in your header.</p>

                        <xmp><script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
                            <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

                            <script type="text/javascript" src="transit.js"></script>
                            <script type="text/javascript" src="touchSwipe.js"></script>
                            <script type="text/javascript" src="simpleSlider.js"></script></xmp>

                        <div class="button" onclick="mainslider.nextSlide();">Done? Let's move on!</div>
                    </div>
                </div>
            </div>
            <div class='slide' id="thirth">
                <div class='slidecontent'>
                    <span class="headersur">Time to start this party</span>
                    <h1>BIND IT</h1>
                    <div class="text">
                        <p>Now it's time to bind the simpleslider on your HTML element. Check the  Github README for an example HTML.</p>
                        <xmp>$(document).ready(function(){
                            $(".slider").simpleSlider();
                            });</xmp>
                        <div class="button" onclick="mainslider.nextSlide();">Done? Let's move on again!</div>
                    </div>
                </div>
            </div>
            <div class='slide' id="fourth">
                <div class='slidecontent'>
                    <span class="headersur">And you're done! Grab a beer and</span>
                    <h1>WATCH</h1>
                    <div class="text">
                        <p>SimpleSlider will now do the rest. Are you looking for more options? Check the Github readme!</p>
                        <p>SimpleSlider standard comes with a few methods, triggers and a tracker. These are all easy to configure. More information about them can be found on the Github page<br/>Btw, this site has been made using simpleslider! </p>

                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<div class="blog-header">
    <a href="#" class="blog-brand">我的个人博客</a>

    <div class="blob-nav">
        <ul>
            <li><a href="">首页</a></li>
            <li><a href="">生活点滴</a></li>
            <li><a href="">闲言碎语</a></li>
            <li><a href="">美文欣赏</a></li>
            <li><a href="">精美图片</a></li>
        </ul>
    </div>
</div>
<div class="uk-container uk-container-center">
    <div class="uk-grid uk-margin-top">
        <div class="uk-width-5-6">
            <fieldset>
                <legend>
                    文章<em>推荐</em>
                </legend>
                <div class="aticle-panel">
                    <h3>关于响应事的设计</h3>

                    <div>fejopwfjewrinfkafnkwe发博能违反金额为快乐伏努科沃吗，嗯哦</div>
                </div>
            </fieldset>
        </div>
        <div class="uk-width-1-6">
            <fieldset>
                <legend>最新文章</legend>
            </fieldset>
        </div>
    </div>
</div>
</body>
</html>
