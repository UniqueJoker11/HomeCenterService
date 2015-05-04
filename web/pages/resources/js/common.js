/**
 * Created by joker on 14-12-23.
 */
$(function(){
    //每个选项页面的绑定
    $.each($("#functionNav").find("td"),function(i,e){
        $(this).bind("click",function(event){
            redirectHtmlPage(i);
        });

    });
    function redirectHtmlPage(i){
        switch (i) {
            case 0:
                window.open("blog_index.html");
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                window.location.href="blog_manage_masterInfo.html";
                break;
            case 4:
                break;
            case 5:
                break;}
    }
    //头部共同的导航头
 $("#headerNav").children("li").each(function(i){
    $(this).hover(function(e){
        console.log($(this).find("a").html());
        $(this).find("a").addClass("hoverNav");
    },function(e){
        $(this).find("a").removeClass("hoverNav");
    });
    $(this).click(function(e){
        var currentObj=$(this);
        currentObj.siblings("li").removeClass("link_active");
        currentObj.addClass("link_active").find("a").addClass("hoverNav");
    });
 });
    //初始化页面的高度
    initPageEffect();
    function initPageEffect(){
        var windwoHeight=$(document).height();
        var headerHeight=$(".topHeader").height();
        $(".colin-main-frame").css({"height":windwoHeight-headerHeight});
        //初始化左侧的导航高度布局
        var functionNavWidh=$("#functionNav").width();
        $("#functionNav").find("td").css({"height":functionNavWidh/2});
    }
    $(window).bind("resize",function(e){
        initPageEffect();
    });
});
function logOffSystem(){
    window.location.href="/userLogOff.html";
}
