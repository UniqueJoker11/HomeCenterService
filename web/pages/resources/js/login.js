$(function () {
    function initBgHeight() {
        $(".header_model").css("height", ($(document).height() - 200));
    }

    initBgHeight();
    $(window).bind("resize", function () {
        initBgHeight();
    });
    $("#linkTab").children("a").bind("click", function (e) {
        var idVal = $(this).attr("href");
        var siblingVal = $(this).siblings("a").attr("href");
        $(siblingVal).hide();
        $(idVal).slideDown();
    }).eq(0).trigger("click");
    //绑定邮箱校验
    $("#")
    //绑定表单提交吗？
    $("#registerFormModel").bind("submit", function (e) {
        var params = $("#registerFormModel").serialize();
        $.post("registerUserInfo.action", params, function (data) {
        });
        e.preventDefault();
        return false;
    });
    $("#resetBtn").bind("click", function () {
        var params = new Object();
        params.hasParams = "0";
        $.post("queryUserInfo.action", params, function (data) {
            console.log(data);
        })
    });
    //登录模块的邮箱校验的绑定
    $("#userLoginName").bind("focusout", function () {
        if ($.trim($(this).val()) == "") {
            $.UIkit.notify({
                message: '用户名不能为空!',
                status: 'info',
                timeout: 2000,
                pos: 'top-center'
            });
        } else {
            var params = new Object();
            params.username = $(this).val();
            //开始校验
            $.ajax({
                async: false,
                url: 'isUsernameExists.action',
                data: params,
                type: "post",
                dataType:'json',
                success: function (data) {
                    if (!data.isSuccess) {
                        $.UIkit.notify({
                            message: '用户名不存在，请重新填写!',
                            status: 'info',
                            timeout: 2000,
                            pos: 'top-center'
                        });
                    }
                }
            });
        }
    });
    //登录模块的密码验证
    $("#userLoginPassword").bind("focusout",function(e){
        if($.trim($(this).val())==""){
            $.UIkit.notify({
                message: '密码不能为空!',
                status: 'info',
                timeout: 5000,
                pos: 'top-center'
            });
        }
    });
    //登录模块的提交表单绑定
    $("#loginFormModel").bind("submit", function (e) {
        var result = true;
        var userLoginName = $(this).find("input[name='userLoginName']");
        var userLoginPassword = $(this).find("input[name='userLoginPassword']");
        if ($.trim(userLoginName.val()) == "") {
            result = false;
            $.UIkit.notify({
                message: '用户名不能为空!',
                status: 'info',
                timeout: 2000,
                pos: 'top-center'
            });
            userLoginName.attr({"data-uk-tooltip": "{pos:'top-center'}", "title": "用户名不能为空！"});
            result = false;
        }
        if ($.trim(userLoginPassword.val()) == "") {
            result = false;
            $.UIkit.notify({
                message: '密码不能为空!',
                status: 'info',
                timeout: 2000,
                pos: 'top-center'
            });
            userLoginPassword.attr({"data-uk-tooltip": "{pos:'top-center'}", "title": "密码不能为空！"});
            result = false;
        }
        // send the reqeust
        var params = new Object();
        params.username = userLoginName.val();
        params.password = userLoginPassword.val();
        console.log($.parseJSON(params));
        $.ajax({
            url: "validateUserLogin.action",
            data: params,
            dataType: 'json',
            async: false,
            type: 'post',
            success: function (data) {
                if (!data.isSuccess) {
                    $.UIkit.notify({
                        message: '用户名或密码不正确!',
                        status: 'info',
                        timeout: 3000,
                        pos: 'top-center'
                    });
                    result = false;
                } else {
                    result = true;
                }

            }
        });
        if (result) {
            return true;
        } else {
            e.preventDefault();
            return false;
        }
    });

});