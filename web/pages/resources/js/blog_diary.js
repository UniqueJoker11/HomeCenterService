$(function(){
    var pageSize = 10;// 页面显示个数
    var initCurrentPage = 1;//初始化当前的页面
    var pagination = new Object();//分页的变量
   //初始化个人日记列表
    initBlogAticleList();
    function initBlogAticleList(){
        var params=new Object();
        params.pageSize = pageSize;
        params.currentPage = initCurrentPage;
        params.currentIndex = 1;
        $.ajax({
            url:'fetchAticlePageInfo.action',
            type:'post',
            data:params,
            async:'true',
            success:function(data){
                var showContent = "";
                for (var i = 0; i < data.pageContent.resultList.length; i++) {
                    var prevAticleId=0;
                    var nextAticleId=0;
                    if(i==0){
                        nextAticleId=data.pageContent.resultList[i+1].aticleId;
                    }else if(i>0&&i<data.pageContent.resultList.length-1){
                        prevAticleId=data.pageContent.resultList[i-1].aticleId;
                        nextAticleId=data.pageContent.resultList[i+1].aticleId;
                    }else if(i=(data.pageContent.resultList.length-1)){
                        prevAticleId=data.pageContent.resultList[i-1].aticleId;
                    }
                    var currentAticle = data.pageContent.resultList[i];
                    showContent += "<div class=\"wz\"> <h3 data-aticleId=\"" + currentAticle.aticleId + "\">" + currentAticle.aticleTitle + "</h3>"
                    +"<p class=\"dateview\"><span>"+currentAticle.aticleCreateDate.substring(0,10)+"</span><span>作者：" + currentAticle.aticleAuthor + "</span><span>分类：[<a href=\"#\">"+currentAticle.aticleCategory+"</a>]</span></p>"
                    +"<figure><img src=\""+currentAticle.aticleCoverImg+"\"></figure>"
                    +"<ul>"
                    +"<p>"+currentAticle.aticleDigest+"</p>"
                    +"<a title=\"阅读全文\" href=\"#\" onclick=\"readAticle("+prevAticleId+","+nextAticleId+"," + currentAticle.aticleId +")\" target=\"_blank\" class=\"readmore\">阅读全文>></a>"
                    +"</ul>"
                    +"<div class=\"clear\"></div>"
                    +"</div>";


                }
                $("#bloglist").html(showContent);
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
                for (var i = 0; i < data.pageContent.resultList.length; i++) {
                    var prevAticleId=0;
                    var nextAticleId=0;
                    if(i==0){
                        nextAticleId=data.pageContent.resultList[i+1].aticleId;
                    }else if(i>0&&i<data.pageContent.resultList.length-1){
                        prevAticleId=data.pageContent.resultList[i-1].aticleId;
                        nextAticleId=data.pageContent.resultList[i+1].aticleId;
                    }else if(i=(data.pageContent.resultList.length-1)){
                        prevAticleId=data.pageContent.resultList[i-1].aticleId;
                    }
                    var currentAticle = data.pageContent.resultList[i];
                    showContent += "<div class=\"wz\"> <h3 data-aticleId=\"" + currentAticle.aticleId + "\">" + currentAticle.aticleTitle + "</h3>"
                    +"<p class=\"dateview\"><span>"+currentAticle.aticleCreateDate.substring(0,10)+"</span><span>作者：" + currentAticle.aticleAuthor + "</span><span>分类：[<a href=\"#\">"+currentAticle.aticleCategory+"</a>]</span></p>"
                    +"<figure><img src=\""+currentAticle.aticleCoverImg+"\"></figure>"
                    +"<ul>"
                    +"<p>"+currentAticle.aticleDigest+"</p>"
                    +"<a title=\"阅读全文\" href=\"#\" onclick=\"readAticle(\""+prevAticleId+"\",\""+nextAticleId+"\",\"" + currentAticle.aticleId + "\")\" target=\"_blank\" class=\"readmore\">阅读全文>></a>"
                    +"</ul>"
                    +"<div class=\"clear\"></div>"
                    +"</div>";


                }
                $("#aticleContentContainer").html(showContent);
            }
        });
    }

});
function readAticle(prevAticleId,nextAticleId,idVal){
    window.open("getAticleDeatil.html?prevId="+prevAticleId+"&id="+idVal+"&nextId="+nextAticleId);
}