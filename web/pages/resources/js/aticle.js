/**
 * Created by joker on 14-10-23.
 */
$(function () {
    //定义分页的全局变量
    var pageSize=10;// 页面显示个数
    var initCurrentPage=1;//初始化当前的页面
    $("#aticleTitle").bind("blur", function (e) {
        var obj = $(this);
        initEmptyErrorInfoShow(obj, "文章标题不能为空！");
    });
    $("#aticleDigest").bind("blur", function (e) {
        var obj = $(this);
        initEmptyErrorInfoShow(obj, "文章摘要不能为空！");
    });
    var pagination=new Object();
    //初始化文章的内容
    initAticleContent();
    function initAticleContent() {
        var params = new Object();
        params.pageSize = pageSize;
        params.currentPage = initCurrentPage;
        $.ajax({
            url: "fetchAticlePageInfo.action",
            type: 'post',
            data: params,
            async: false,
            dataType: 'json',
            success: function (data) {
                var showContent = "";
                for (var i = 0; i < data.pageContent.resultList.length; i++) {
                    var currentAticle = data.pageContent.resultList[i];
                    showContent += "<div class='uk-width-medium-1-2'><div class='uk-panel uk-panel-box colin-aticle-body'><h3 class='uk-panel-title'><a href=''/titlefisefef.html'>" + currentAticle.aticleName + "</a></h3><pre class='uk-scrollable-text' style='min-height100px;max-height: 200px'>" + currentAticle.aticleContent + "</pre><div class='uk-panel-foot'>"
                        + "<ul>"
                        + "<li><a href='#checkDetailDialog' data-uk-tooltip title='查看详情' data-uk-modal class='uk-icon-button uk-icon-eye'></a></li>"
                        + "<li><a href='#addTagDialog' data-uk-tooltip title='标注记号' data-uk-modal class='uk-icon-button uk-icon-circle-o'></a></li>"
                        + "<li><a href='#editAticleDialog' data-uk-tooltip title='编辑文章' data-uk-modal class='uk-icon-button uk-icon-edit'></a></li>"
                        + "<li><a href='#delateAticleDialog' data-uk-tooltip title='删除文章' data-uk-modal class='uk-icon-button uk-icon-times-circle-o'></a></li>"
                        + "</ul>"
                        + "</div>"
                        + "</div>"
                        + "</div>";

                }
                $("#aticleContent").html(showContent);
                pagination = $.UIkit.pagination("#aticlePagination", {items:data.pageContent.totalRecord,itemsOnPage:data.pageContent.pageSize,displayedPages:3,currentPage:data.pageContent.currentPage,lblPrev:"上一页",lblNext:"下一页",onSelectPage:function(pageIndex,pages){
                    initAticlePageContent(pageIndex+1);
                }});

               // $("#aticlePagnation").html(aticlePagination(data.pageContent.currentPage, data.pageContent.totalPage));
            }

        });
    }
function initAticlePageContent(currentPage){
    var params = new Object();
    params.pageSize = pageSize;
    params.currentPage = currentPage;
    $.ajax({
        url: "fetchAticlePageInfo.action",
        type: 'post',
        data: params,
        async: false,
        dataType: 'json',
        success: function (data) {
            var showContent = "";
            for (var i = 0; i < data.pageContent.resultList.length; i++) {
                var currentAticle = data.pageContent.resultList[i];
                showContent += "<div class='uk-width-medium-1-2'><div class='uk-panel uk-panel-box colin-aticle-body'><h3 class='uk-panel-title'><a href=''/titlefisefef.html'>" + currentAticle.aticleName + "</a></h3><pre class='uk-scrollable-text' style='min-height100px;max-height: 200px'>" + currentAticle.aticleContent + "</pre><div class='uk-panel-foot'>"
                    + "<ul>"
                    + "<li><a href='#checkDetailDialog' data-uk-tooltip title='查看详情' data-uk-modal class='uk-icon-button uk-icon-eye'></a></li>"
                    + "<li><a href='#addTagDialog' data-uk-tooltip title='标注记号' data-uk-modal class='uk-icon-button uk-icon-circle-o'></a></li>"
                    + "<li><a href='#editAticleDialog' data-uk-tooltip title='编辑文章' data-uk-modal class='uk-icon-button uk-icon-edit'></a></li>"
                    + "<li><a href='#delateAticleDialog' data-uk-tooltip title='删除文章' data-uk-modal class='uk-icon-button uk-icon-times-circle-o'></a></li>"
                    + "</ul>"
                    + "</div>"
                    + "</div>"
                    + "</div>";

            }
            $("#aticleContent").html(showContent);
        }});

    }
    $("#aticleSubmitBtn").bind("click", function (e) {
        var submitSuccess = true;
        submitSuccess = initEmptyErrorInfoShow($("#aticleTitle"), "文章标题不能为空！");
        if (submitSuccess) {
            submitSuccess = initEmptyErrorInfoShow($("#aticleDigest"), "文章标题不能为空！");
            if (submitSuccess) {
                var aticleContent = ue.getContent();
                if ($.trim(aticleContent) != "") {
                    var params = new Object();
                    params.aticleTitle = $("#aticleTitle").val();
                    params.aticleDigest = $("#aticleDigest").val();
                    params.aticleContent = aticleContent;
                    alert(aticleContent);
                    $.post("saveAticleContet.action", params, function (data) {
                        if (data.isSuccess) {
                            $.UIkit.notify({
                                message: '保存文章成功!',
                                status: 'success',
                                timeout: 3000,
                                pos: 'top-center'
                            });
                        }else{
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
        }
        e.preventDefault();
    });
    //union all of the  error info show
    function initEmptyErrorInfoShow(obj, message, regex) {
        if (regex) {
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
    $("#spiderBtn").bind("click",function(e){
        if($.trim($("#spiderUrl").val())==""){
            $.UIkit.notify("<i class='uk-icon-warning'></i> "+"URL地址不能为空",{timeout:2000});
        }else{
            //需要判断正是否是正确的URL格式
            if(IsURL($.trim($("#spiderUrl").val()))){
                $("#urlContent").attr("src",$("#spiderUrl").val());
            }else{
                $.UIkit("<i class='uk-icon-warning'></i> "+"URL地址格式不正确",{timeout:2000});
            }

        }

    });
    function IsURL (str_url) {
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
        var re=new RegExp(strRegex);
        if (re.test(str_url)) {
            return (true);
        } else {
            return (false);
        }
    }
});
function showAticleContent() {
    var params = new Object();
    params.pageSize = 3;
    params.currentPage = 1;
    $.ajax(
        {url: 'fetchAticlePageInfo.action',
            data: params,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
}
