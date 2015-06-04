/**
 * Created by joker on 14-10-23.
 */
$(function () {
    //tab导航页切换的事件绑定
    $("[data-uk-tab]").on("change.uk.tab", function(event,item){
        var tabTitle=$(item).find("a").text();
        if(tabTitle=="文章一览"){
            initAticleContent();
        }
    });
    //隐藏缩略图显示
    $("#uploadSnapshot").hide();
    //定义分页的全局变量
    var pageSize = 10;// 页面显示个数
    var initCurrentPage = 1;//初始化当前的页面
    var uploadImgAddress = "";//图片上传后的具体访问地址、异步的。

    //初始化提交文章按钮不可用，直到博客封面图片上传成功
    $("#aticleSubmitBtn").attr("disabled", true);
    //绑定文章的标题校验
    $("#aticleTitle").bind("blur", function (e) {
        var obj = $(this);
        initEmptyErrorInfoShow(obj, "文章标题不能为空！", "");
    });
    $("#aticleDigest").bind("blur", function (e) {
        var obj = $(this);
        initEmptyErrorInfoShow(obj, "文章摘要不能为空！", "");
    });

    var pagination = new Object();
    //初始化文章的内容
    initAticleContent();
    function initAticleContent() {
        var params = new Object();
        params.pageSize = pageSize;
        params.currentPage = initCurrentPage;
        params.currentIndex = 1;
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
                        showContent += " <tr id=\'aticleId" + i + "\' class=\"uk-table-middle\"><td data-aticleId=\"" + currentAticle.aticleId + "\"><a href=\"#\" onclick=\"readAticle("+prevAticleId+","+nextAticleId+","+currentAticle.aticleId+")\">" + currentAticle.aticleTitle + "</td><td>" + currentAticle.aticleAuthor + "</a></td><td>" + currentAticle.aticleCommentNum + "</td><td>" + currentAticle.aticleBrowserNum + "</td><td>" + currentAticle.aticleCreateDate + "</td><td class=\"uk-text-center\">"
                        + "<div class=\"uk-button-group\">"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-primary\" onClick=\"browserAticle(" + currentAticle.aticleId + ")\">浏览</button>"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-primary\" onClick=\"updateAticle(" + currentAticle.aticleId + ",\'aticleId" + i + "\')\">更新</button>"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-danger\"  onClick=\"deleteAticle(" + currentAticle.aticleId + ",\'aticleId" + i + "\')\">删除</button>"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-success\" onClick=\"setTopAticle(" + currentAticle.aticleId + ")\">置顶</button>"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-primary\" onClick=\"commentAticle(" + currentAticle.aticleId + ",\'aticleId" + i + "\')\">评论</button>"
                        + "</div>"
                        + "</td>";
                    }
                    pagination = $.UIkit.pagination("#aticlePagination", {
                        items: data.pageContent.totalRecord,
                        itemsOnPage: data.pageContent.pageSize,
                        displayedPages: 3,
                        currentPage: data.pageContent.currentPage,
                        lblPrev: "上一页",
                        lblNext: "下一页",
                        onSelectPage: function (pageIndex, pages) {
                            initAticlePageContent(pageIndex + 1, data.pageContent.resultList.length);
                        }
                    });
                }

                $("#aticleContentContainer").html(showContent);
            }

        });
    }

    //初始化分页文章的内容
    function initAticlePageContent(currentPage, currentIndex) {
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
                        showContent += " <tr id=\'aticleId" + i + "\' class=\"uk-table-middle\"><td data-aticleId=\"" + currentAticle.aticleId + "\"><a href=\"#\" onclick=\"readAticle("+prevAticleId+","+nextAticleId+","+currentAticle.aticleId+")\">" + currentAticle.aticleTitle + "</td><td>" + currentAticle.aticleAuthor + "</a></td><td>" + currentAticle.aticleCommentNum + "</td><td>" + currentAticle.aticleBrowserNum + "</td><td>" + currentAticle.aticleCreateDate + "</td><td class=\"uk-text-center\">"
                        + "<div class=\"uk-button-group\">"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-primary\" onClick=\"browserAticle(" + currentAticle.aticleId + ")\">浏览</button>"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-primary\" onClick=\"updateAticle(" + currentAticle.aticleId + ",\'aticleId" + i + "\')\">更新</button>"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-danger\"  onClick=\"deleteAticle(" + currentAticle.aticleId + ",\'aticleId" + i + "\')\">删除</button>"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-success\" onClick=\"setTopAticle(" + currentAticle.aticleId + ")\">置顶</button>"
                        + "<button data-aticleId=\"" + currentAticle.aticleId + "\" class=\"uk-button uk-button-primary\" onClick=\"commentAticle(" + currentAticle.aticleId + ",\'aticleId" + i + "\')\">评论</button>"
                        + "</div>"
                        + "</td>";
                    }
                }
                $("#aticleContentContainer").html(showContent);
            }
        });

    }

    //处理封面图片的上传
    var progressbar = $("#progressbar"),
        bar = progressbar.find('.uk-progress-bar'),
        settings = {

            action: 'uploadAticleCoverImg.action', // 上传路径 url
            param: 'aticleCoverImg',
            allow: '*.(jpg|jpeg|gif|png)', // 只允许上传图片

            loadstart: function () {
                bar.css("width", "0%").text("0%");
                progressbar.removeClass("uk-hidden");
            },

            progress: function (percent) {
                percent = Math.ceil(percent);
                bar.css("width", percent + "%").text(percent + "%");
            },

            allcomplete: function (response) {
                var result = $.parseJSON(response);
                bar.css("width", "100%").text("100%");
                if (result.isSuccess) {
                    showUploadFile(result.retsultMsg);
                }
                setTimeout(function () {
                    progressbar.addClass("uk-hidden");
                }, 1200);
            }
        };
//检测上传文件是否已经完成，否则继续检测。
    function showUploadFile(src) {
        $.ajax({
            url: src,
            method: 'get',
            statusCode: {
                404: function () {
                    setTimeout(showUploadFile(src), 2500);
                },
                200: function () {
                    $("#uploadSnapshot").attr("src", src).show();
                    $("#aticleSubmitBtn").attr("disabled", false);
                }
            }
        });
    }

    var select = UIkit.uploadSelect($("#upload-select"), settings),
        drop = UIkit.uploadDrop($("#upload-drop"), settings);
    //处理文章提交事件
    $("#aticleSubmitBtn").bind("click", function (e) {
        var submitSuccess = true;
        submitSuccess = initEmptyErrorInfoShow($("#aticleTitle"), "文章标题不能为空！", "");
        if (submitSuccess) {
            var aticleContent = ue.getContent();
            if ($.trim(aticleContent) != "") {
                var params = new Object();
                params.aticleCategory = $("#aticleCategory option:selected").val();
                params.aticleTitle = $("#aticleTitle").val();
                params.aticleDigest = $("#aticleDigest").val();
                params.aticleCoverImg = $("#uploadSnapshot").attr("src");
                params.aticleContent = aticleContent;
                params.keyWords = $("#aticleKeywords").val();
                params.aticleAuthor = $("#aticleAuthor").val();
                $.post("saveAticleContet.action", params, function (data) {
                    if (data.isSuccess) {
                        $.UIkit.notify({
                            message: '保存文章成功!',
                            status: 'success',
                            timeout: 3000,
                            pos: 'top-center'
                        });
                        //清空内容
                        clearAticleContent();
                    } else {
                        $.UIkit.notify({
                            message: '保存文章失败!',
                            status: 'warning',
                            timeout: 3000,
                            pos: 'top-center'
                        });
                    }
                });
            } else {
                $.UIkit.notify("<i class='uk-icon-warning'></i> 文章内容不能为空！", {timeout: 3000});
            }
        }
        e.preventDefault();
    });
    $("#aticleSubmitBtn").ajaxStart(function () {
        //定义模态对话框
        $("#linkLoadDialog").trigger("click");
    }).ajaxComplete(function () {
        var loadDialog = UIkit.modal("#loadingDailog");
        loadDialog.hide();
    });
    /**
     * 清空文章内容
     * */
    function clearAticleContent() {
        $("#aticleTitle").val("");
        $("#aticleDigest").val("");
        ue.setContent("");
        $("#aticleKeywords").val("");
        $("#aticleAuthor").val("");
        $("#uploadSnapshot").attr("src", "").hide();
        $("#aticleSubmitBtn").attr("disabled", true);
    }

    //union all of the  error info show
    function initEmptyErrorInfoShow(obj, message, regex) {
        if (regex != "") {
            var objVal = obj.val();
            if (!regex.test(objVal)) {
                $.UIkit.notify("<i class='uk-icon-warning'></i> " + message, {timeout: 3000});
                return false;
            } else {
                return true;
            }
        } else {
            if ($.trim(obj.val()) == "") {
                $.UIkit.notify("<i class='uk-icon-warning'></i> " + message, {timeout: 3000});
                return false;
            } else {
                return true;
            }
        }

    }

    //绑定URL链接地址的功能
    $("#spiderBtn").bind("click", function (e) {
        if ($.trim($("#spiderUrl").val()) == "") {
            $.UIkit.notify("<i class='uk-icon-warning'></i> " + "URL地址不能为空", {timeout: 2000});
        } else {
            //需要判断正是否是正确的URL格式
            if (IsURL($.trim($("#spiderUrl").val()))) {
                $("#urlContent").attr("src", $("#spiderUrl").val());
            } else {
                $.UIkit("<i class='uk-icon-warning'></i> " + "URL地址格式不正确", {timeout: 2000});
            }

        }

    });
    function IsURL(str_url) {
        var strRegex = '^((https|http|ftp|rtsp|mms)?://)'
            + '?(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' //ftp的user@
            + '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184
            + '|' // 允许IP和DOMAIN（域名）
            + '([0-9a-z_!~*\'()-]+.)*' // 域名- www.
            + '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名
            + '[a-z]{2,6})' // first level domain- .com or .museum
            + '(:[0-9]{1,4})?' // 端口- :80
            + '((/?)|' // a slash isn't required if there is no file name
            + '(/[0-9a-z_!~*\'().;?:@&=+$,%#-]+)+/?)$';
        var re = new RegExp(strRegex);
        if (re.test(str_url)) {
            return (true);
        } else {
            return (false);
        }
    }

    //提交悄悄话的内容
    $("#publishStaticWords").bind("click", function (e) {
        var publishContent = $.trim($("#publishStaticContent").val());
        if (publishContent == "") {
            $.UIkit.notify({
                message: '悄悄话内容不能为空！',
                status: "danger",
                timeout: 2000
            });
        } else {
            var params = new Object();
            params.whisperContent = publishContent;
            $.post("addWhisperInfo.action", params, function (data) {
                if (data.isSuccess) {
                    $.UIkit.notify({
                        message: '更新悄悄话成功！',
                        status: "info",
                        timeout: 2000
                    });
                    $("#publishStaticContent").val("");
                }
            });
        }

        e.preventDefault();
    });
});

function showAticleContent() {
    var params = new Object();
    params.pageSize = 3;
    params.currentPage = 1;
    $.ajax(
        {
            url: 'fetchAticlePageInfo.action',
            data: params,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
}
//浏览文章详情
function browserAticle(idVal) {
    window.open("getAticleDeatil.html?prevId=" + prevAticleId + "&id=" + idVal + "&nextId=" + nextAticleId);
}
//编辑文章内容
function updateAticle(idVal, currentObj) {
//弹出对话框
}
//文章置顶
function setTopAticle(idVal) {

}
//评论文章
function commentAticle(idVal, currentObj) {


}
//删除文章
function deleteAticle(idVal, currentObj) {
    //弹出删除确认框
    var result = window.confirm("确认要删除该数据吗？");
    if (result) {
        var params = new Object();
        params.aticleId = idVal;
        $.ajax({
            url: 'deleteAticleInfo.action',
            data: params,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.isSuccess) {
                    alert("删除文章成功！");
                    $("#" + currentObj).empty();
                } else {
                    alert("删除文章失败！");
                }
            }

        });
    }
}
function readAticle(prevAticleId, nextAticleId, idVal) {
    window.open("getAticleDeatil.html?prevId=" + prevAticleId + "&id=" + idVal + "&nextId=" + nextAticleId);
}
