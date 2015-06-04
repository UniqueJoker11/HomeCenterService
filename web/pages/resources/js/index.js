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
    /*图片上传功能*/
    var progressbar = $("#progressbar"),
        bar         = progressbar.find('.uk-progress-bar'),
        settings    = {

            action: '/', // 上传路径 url

            allow : '*.(jpg|jpeg|gif|png)', // 只允许上传图片

            loadstart: function() {
                bar.css("width", "0%").text("0%");
                progressbar.removeClass("uk-hidden");
            },

            progress: function(percent) {
                percent = Math.ceil(percent);
                bar.css("width", percent+"%").text(percent+"%");
            },

            allcomplete: function(response) {

                bar.css("width", "100%").text("100%");

                setTimeout(function(){
                    progressbar.addClass("uk-hidden");
                }, 250);

                alert("Upload Completed")
            }
        };

    var select = UIkit.uploadSelect($("#upload-select"), settings),
        drop   = UIkit.uploadDrop($("#upload-drop"), settings);

});
