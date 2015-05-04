/**
 * Created by joker on 14-9-19.
 */
$(function(){
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

    /*绑定左侧导航的按钮功能*/

});
