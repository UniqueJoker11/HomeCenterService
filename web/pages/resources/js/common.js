/**
 * Created by joker on 14-12-23.
 */
$(function(){
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

});
