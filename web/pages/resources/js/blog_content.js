/**
 * Created by ASUS on 2015/4/24.
 */
$(function(){
    //初始化最新发布
    initBlogPublishRank();
    function initBlogPublishRank(){
        $.post("getAticlePublishRank.action", function (data) {
            if (data.isSuccess && data.retsultData.length > 0) {
                var showContent = "";
                var aticleData = data.retsultData;
                for (var i = 0; i < aticleData.length; i++) {
                    if (i == 0) {
                        showContent += "<li><a href=\"#\" onclick=\"readAticle(0," + aticleData[i + 1].aticleId + "," + aticleData[i].aticleId + ")\" title=\"" + aticleData[i].aticleName + "\" target=\"_blank\">" + aticleData[i].aticleName + "</a></li>";
                    } else if (i == aticleData.length - 1) {
                        showContent += "<li><a href=\"#\" onclick=\"readAticle(" + aticleData[i - 1].aticleId + ",0," + aticleData[i].aticleId + ")\" title=\"" + aticleData[i].aticleName + "\" target=\"_blank\">" + aticleData[i].aticleName + "</a></li>";
                    } else {
                        showContent += "<li><a href=\"#\" onclick=\"readAticle(" + aticleData[i - 1].aticleId + "," + aticleData[i + 1].aticleId + "," + aticleData[i].aticleId + ")\" title=\"" + aticleData[i].aticleName + "\" target=\"_blank\">" + aticleData[i].aticleName + "</a></li>";
                    }
                }
                $("#publishList").html(showContent);
            } else {
                $.UIkit.notify("还没有发布文章！", "danger");
            }
        });
    }
    //初始化点击排行
    initBlogClickRank();
    function initBlogClickRank() {
        $.post("getAticleClickRank.action", function (data) {
            if (data.isSuccess && data.retsultData.length > 0) {
                var showContent = "";
                var aticleData = data.retsultData;
                for (var i = 0; i < aticleData.length; i++) {
                    if (i == 0) {
                        showContent += "<li><a href=\"#\" onclick=\"readAticle(0," + aticleData[i + 1].aticleId + "," + aticleData[i].aticleId + ")\" title=\"" + aticleData[i].aticleName + "\" target=\"_blank\">" + aticleData[i].aticleName + "</a></li>";
                    } else if (i == aticleData.length - 1) {
                        showContent += "<li><a href=\"#\" onclick=\"readAticle(" + aticleData[i - 1].aticleId + ",0," + aticleData[i].aticleId + ")\" title=\"" + aticleData[i].aticleName + "\" target=\"_blank\">" + aticleData[i].aticleName + "</a></li>";
                    } else {
                        showContent += "<li><a href=\"#\" onclick=\"readAticle(" + aticleData[i - 1].aticleId + "," + aticleData[i + 1].aticleId + "," + aticleData[i].aticleId + ")\" title=\"" + aticleData[i].aticleName + "\" target=\"_blank\">" + aticleData[i].aticleName + "</a></li>";
                    }
                }
                $("#rankList").html(showContent);
            } else {
                $.UIkit.notify("还没有发布文章！", "danger");
            }
        });
    }
});