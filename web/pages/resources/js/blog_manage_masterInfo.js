/**
 * Created by ASUS on 2015/4/21.
 */
$(function () {
    //处理上传图片
    handerUploadPic("progressbar_edit", "select_edit", "blog_masterpic_edit");
    handerUploadPic("progressbar_add", "upload-select_add", "blog_masterpic_add");
    function handerUploadPic(progressObj, uploadObj, dropObj) {
        var progressbar = $("#" + progressObj),
            bar = progressbar.find('.uk-progress-bar'),
            settings = {

                action: 'masterpicupload.action', // upload url

                allow: '*.(jpg|jpeg|gif|png)', // allow only images
                param: 'masterheaderpic',
                filelimit: 1,
                type: 'json',
                loadstart: function () {
                    bar.css("width", "0%").text("0%");
                    progressbar.removeClass("uk-hidden");
                },

                progress: function (percent) {
                    percent = Math.ceil(percent);
                    bar.css("width", percent + "%").text(percent + "%");
                },

                allcomplete: function (response) {

                    bar.css("width", "100%").text("100%");

                    setTimeout(function () {
                        progressbar.addClass("uk-hidden");
                    }, 1200);
                    if (response.isSuccess) {
                        if (progressObj == "progressbar_add") {
                            $("#blogMasterSubmitBtnAdd").removeAttr("disabled");
                            //展示预览图片
                            var headerPic = response.retsultMsg;
                            $("#previewpic_add >img").attr("src", headerPic);
                            $("#previewpic_add").show();
                        }
                    } else {
                        $.UIkit.notify({
                            message: '上传头像失败，请稍候再试....',
                            timeout: 2000
                        });
                    }

                }
            };
        var select = UIkit.uploadSelect($("#" + uploadObj), settings),
            drop = UIkit.uploadDrop($("#" + dropObj), settings);
    }

    //获取用户的信息
    initBlogMasterInfo();
    function initBlogMasterInfo() {
        $.ajax({
            url: 'getMasterInfo.action',
            async: false,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.isSuccess) {
                    $("#hasNotBlogMasterInfo").remove();
                    $("#hasBlogMasterInfo").show();
                    $("#editMasterInfoForm").hide();
                    showMasterInfo(data.retsultData[0]);
                } else {
                    $("#hasNotBlogMasterInfo").show();
                    $("#hasBlogMasterInfo").remove();
                }
            }
        });
    }

    //展示博主信息内容
    function showMasterInfo(obj) {
        $("#showMasterName").html(obj.master_name);
        $("#showMasterCarrer").html(obj.master_carrer);
        $("#showMasterHeader >img").attr("src", obj.master_header);
        $("#showMasterIntroduce").html(obj.master_introduce);
        $("#showMasterWords").html(obj.master_words);
    }

//提交编辑按钮的内容
    $("#editMasterInfoBtn").bind("click", function (e) {
        $("#editMasterInfoForm").show();
    });
    $("#blogMasterSubmitBtnEdit").bind("click", function (e) {
        var params=new Object();
        if(isInputEmpty("blog_mastername_edit")){
               params.masterName=getInputVal("blog_mastername_edit");
        }
        if(isInputEmpty("blog_mastercarrer_edit")){
            params.masterCarrer=getInputVal("blog_mastercarrer_edit");
        }
        if(isInputEmpty("blog_masterintroduce_edit")){
            params.masterIntroduce=getInputVal("blog_masterintroduce_edit");
        }
        if(isInputEmpty("blog_masterwords_edit")){
            params.masterWords=getInputVal("blog_masterwords_edit");
        }
        if($("#previewpic_edit >img").attr("src")!=""){
            params.masterHeader=$("#previewpic_edit >img").attr("src");
        }
        $.post("updateMasterInfo.action",params,function(data){
            console.log(data);
            initBlogMasterInfo()
        });
    });
    //提交博主的提交信息
    $("#blogMasterSubmitBtnAdd").bind("click", function (e) {
        //验证一些列表单
        $.trim($("#blog_mastername_add").val());
        if (isInputEmpty("blog_mastername_add", "博主姓名不能为空！")) {
            var params = new Object();
            params.masterName = getInputVal("blog_mastername_add");
            if (isInputEmpty("blog_mastercarrer_add", "博主职业不能为空！")) {
                params.masterCarrer = getInputVal("blog_mastercarrer_add");
                if (isInputEmpty("blog_masterintroduce_add", "个人简介不能为空！")) {
                    params.masterIntroduce = getInputVal("blog_masterintroduce_add");
                    if (isInputEmpty("blog_masterwords_add")) {
                        params.masterWords = getInputVal("blog_masterwords_add");
                        params.masterHeader = $("#previewpic_add > img").attr("src");
                        $.post("addMasterInfo.action", params, function (data) {
                            if (data.isSuccess) {
                                $.UIkit.notify("添加博主信息成功！", "success");
                                $("#hasNotBlogMasterInfo").remove();
                                initBlogMasterInfo();
                            } else {
                                $.UIkit.notify("添加博主信息失败！", "danger");
                            }
                        });
                    }
                }

            }
        }
        e.preventDefault();
    });
    function isInputEmpty(inputObj, messsage) {
        if ($.trim($("#" + inputObj).val()) == "") {
            $.UIkit.notify({
                message: messsage,
                status: 'danger',
                timeout: 2000,
                pos: 'top-center'
            });
            return false;
        } else {
            return true;
        }
    }

    function getInputVal(inputObj) {
        return $.trim($("#" + inputObj).val());
    }
    function isInputEmpty(inputObj){
        if ($.trim($("#" + inputObj).val()) == "") {
            return false;
        }else{
            return true;
        }
    }
});