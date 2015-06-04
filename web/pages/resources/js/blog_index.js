$(function () {
    //添加访问记录
    //addNetAccessRecord();
    function addNetAccessRecord() {
        $.post("addNewAccessTime.action", null, function (data) {
            var result = data.isSuccess;
            if (!result) {
                addNetAccessRecord();
            }
        });
    };
    //定义分页的全局变量
    var pageSize = 10;// 页面显示个数
    var initCurrentPage = 1;//初始化当前的页面
    var pagination = new Object();//分页的变量
    //初始化主页博主信息
    initBlogMaterInfo();
    function initBlogMaterInfo() {
        $.ajax({
            url: 'getMasterInfo.action',
            async: false,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                console.log(data)
                if (data.isSuccess) {
                    var masterInfo = data.retsultData[0];
                    $("#masterHeader").attr("src", masterInfo.master_header);
                    $("#masterName").html("博主：" + masterInfo.master_name);
                    $("#masterCarrer").html("职业：" + masterInfo.master_carrer);
                    $("#masterIntroduce").html("个人介绍：" + masterInfo.master_introduce);
                    $("#masterWords").html("座右铭：" + masterInfo.master_words);
                    $("#masterHeader").attr("src","/HomeCenterService/upload/header/header.jpg");
                }
            }
        });
    }

//初始化主页banner图
    function initBlogNavPics() {

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
        })
    }

   //初始化用户关注
    function initBlogUserFocus() {

    }

    //初始化博主推荐的文章列表
    initBlogAticleList();
    function initBlogAticleList() {
        var params = new Object();
        params.pageSize = pageSize;
        params.currentPage = initCurrentPage;
        params.currentIndex = 1;
        $.ajax({
            url: 'fetchAticlePageInfo.action',
            type: 'post',
            data: params,
            async: 'true',
            success: function (data) {
                var showContent = "";
                if (data.pageContent.resultList.length == 0) {
                    showContent = "还没新文章发布，请稍候再试~~~~";
                } else {
                    for (var i = 0; i < data.pageContent.resultList.length; i++) {
                        var prevAticleId = 0;
                        var nextAticleId = 0;
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
                        + "<p class=\"dateview\"><span>" + currentAticle.aticleCreateDate.substring(0, 10) + "</span><span>作者：" + currentAticle.aticleAuthor + "</span><span><span>阅读：" + currentAticle.aticleBrowserNum + "</span><span>分类：[<a href=\"#\">" + currentAticle.aticleCategory + "</a>]</span></p>"
                        + "<figure><img src=\"" + currentAticle.aticleCoverImg + "\"></figure>"
                        + "<ul>"
                        + "<p>" + currentAticle.aticleDigest + "</p>"
                        + "<a title=\"阅读全文\" href=\"#\" onclick=\"readAticle(" + prevAticleId + "," + nextAticleId + "," + currentAticle.aticleId + ")\" target=\"_blank\" class=\"readmore\">阅读全文>></a>"
                        + "</ul>"
                        + "<div class=\"clear\"></div>"
                        + "</div>";
                    }
                    pagination = $.UIkit.pagination("#aticlePagination", {
                        items: data.pageContent.totalRecord,
                        itemsOnPage: data.pageContent.pageSize,
                        displayedPages: 3,
                        currentPage: data.pageContent.currentPage,
                        lblPrev: "上一页",
                        lblNext: "下一页",
                        onSelectPage: function (pageIndex, pages) {
                            pageAticleContent(pageIndex + 1, data.pageContent.resultList.length);
                        }
                    });
                }
                $("#bloglist").html(showContent);
            }
        });
    }

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
                        var prevAticleId = 0;
                        var nextAticleId = 0;
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