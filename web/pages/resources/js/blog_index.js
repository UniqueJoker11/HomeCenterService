$(function () {
    //定义分页的全局变量
    var pageSize = 3;// 页面显示个数
    var initCurrentPage = 1;//初始化当前的页面
    //添加访问记录
    addNetAccessRecord();
    function addNetAccessRecord() {
        $.post("addNewAccessTime.action", null, function (data) {
            var result = data.isSuccess;
            if (!result) {
                addNetAccessRecord();
            }
        });
    };
    //监听分页函数
    $("#aticlePagination").on("select.uk.pagination",function(e, pageIndex){
        var params=new Object();
        params.currentPage=parseInt(pageIndex)+1;
        params.pageSize=pageSize;
        $.get("getAticlePageInfo.html",params,function(data){
           $("#colin-aticle-page-info").html(data);
        });
    });

    //初始化主页博主信息


    //初始化主页banner图
    function initBlogNavPics() {

    }




   //初始化用户关注
    function initBlogUserFocus() {

    }

    //初始化博主推荐的文章列表


//初始化分页文章的内容
    function pageAticleContent(currentPage, currentIndex) {
        var params = new Object();
        params.pageSize = pageSize;
        params.currentPage = currentPage;
        if (currentPage - 1 == 0) {
            params.currentIndex = 1;
        } else {
            params.currentIndex = (currentPage - 1) * pageSize;
        }
        $.ajax({
            url: "fetchAticlePageInfo.action",
            type: 'post',
            data: params,
            async: false,
            dataType: 'json',
            success: function (data) {
                var showContent = "";
                if (data.pageContent.resultList.length == 0) {
                    showContent = "还没新文章发布，请稍候再试~~~~";
                } else {
                    for (var i = 0; i < data.pageContent.resultList.length; i++) {
                        var prevAticleId = "0";
                        var nextAticleId = "0";
                        if (i == 0) {
                            if (data.pageContent.resultList.length > 1) {
                                nextAticleId = data.pageContent.resultList[i + 1].aticleId;
                            }
                        } else if (i > 0 && i < data.pageContent.resultList.length - 1) {
                            prevAticleId = data.pageContent.resultList[i - 1].aticleId;
                            nextAticleId = data.pageContent.resultList[i + 1].aticleId;
                        } else if (i = (data.pageContent.resultList.length - 1)) {
                            if (data.pageContent.resultList.length > 1) {
                                prevAticleId = data.pageContent.resultList[i - 1].aticleId;
                            }
                        }
                        var currentAticle = data.pageContent.resultList[i];
                        showContent += "<div class=\"wz\"> <h3 data-aticleId=\"" + currentAticle.aticleId + "\">" + currentAticle.aticleTitle + "</h3>"
                        + "<p class=\"dateview\"><span>" + currentAticle.aticleCreateDate.substring(0, 10) + "</span><span>作者：" + currentAticle.aticleAuthor + "</span><span>分类：[<a href=\"#\">" + currentAticle.aticleCategory + "</a>]</span></p>"
                        + "<figure><img src=\"" + currentAticle.aticleCoverImg + "\"></figure>"
                        + "<ul>"
                        + "<p>" + currentAticle.aticleDigest + "</p>"
                        + "<a title=\"阅读全文\" href=\"#\" onclick=\"readAticle(\"" + prevAticleId + "\",\"" + nextAticleId + "\",\"" + currentAticle.aticleId + "\")\" target=\"_blank\" class=\"readmore\">阅读全文>></a>"
                        + "</ul>"
                        + "<div class=\"clear\"></div>"
                        + "</div>";
                    }
                }
                $("#aticleContentContainer").html(showContent);
            }
        });

    };
});
//阅读全文
function readAticle(prevAticleId, nextAticleId, idVal) {
    //更新当前的文章内容
    var params=new Object();
    params.aticleId=idVal;
    params.aticleReadNum=1;
    //跳转到文章的详情
    window.open("getAticleDeatil.html?prevId=" + prevAticleId + "&id=" + idVal + "&nextId=" + nextAticleId);
}