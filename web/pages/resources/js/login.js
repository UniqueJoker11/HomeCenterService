$(function () {
    //初始化页面的大小
    function initBgHeight() {
        $(".header_model").css("height", ($(document).height() - 200));
    }

    initBgHeight();
    $(window).bind("resize", function () {
        initBgHeight();
    });
    $("#linkTab").children("a").bind("click", function (e) {
        var idVal = $(this).attr("href");
        $(this).addClass("formTabActive");
        var siblingObj = $(this).siblings("a");
        siblingObj.removeClass("formTabActive");
        var siblingVal = siblingObj.attr("href");
        $(siblingVal).hide();
        $(idVal).slideDown();
    }).eq(0).trigger("click");
    /*------------注册模块校验开始----------*/
    //绑定用户名申请
    $("#register_username").bind("focusout", function (e) {
        //校验注册用户名是否为空!
        if (validateInputIsEmpty("register_username", "注册用户名不能为空！")) {
            //校验注册用户名是否注册
            validateIsRegisterUsernameExists($.trim($("#register_username").val()))
        }
    });
    //绑定密码验证
    $("#register_truePassword").bind("focusout", function () {
        //验证密码是否为空
        validateInputIsEmpty("register_truePassword", "密码不能为空！");
    });
    //再次输入密码
    $("#register_confirmPassword").bind("focusout", function () {
        if (validateInputIsEmpty("register_truePassword", "确认密码不能为空！")) {
            //验证确认密码是否一致
            if (!$.trim($("#register_confirmPassword").val()) == $.trim($("#register_truePassword").val())) {
                $.UIkit.notify({
                    message: '两次输入密码不一致，请重新填写!',
                    status: 'info',
                    timeout: 2000,
                    pos: 'top-center'
                });
                $("#register_truePassword").val("");
                $("#register_confirmPassword").val("");
            }
        }
    });
    //绑定表单提交吗？
    $("#register_submitBtn").bind("click", function (e) {
        //校验注册用户名是否为空!
        if (validateInputIsEmpty("register_username", "注册用户名不能为空！")) {
            //校验注册用户名是否注册
            if (validateIsRegisterUsernameExists($.trim($("#register_username").val()))) {
                //验证密码是否为空
                if (validateInputIsEmpty("register_truePassword", "密码不能为空！")) {
                    if (validateInputIsEmpty("register_confirmPassword", "确认密码不能为空！")) {
                        //验证确认密码是否一致
                        if ($.trim($("#register_confirmPassword").val()) == $.trim($("#register_truePassword").val())) {
                            var params = new Object();
                            params.username = $.trim($("#register_username").val());
                            params.userpw = $.trim($("#register_truePassword").val());
                            $.ajax({
                                url: 'registerUserInfo.action',
                                data: params,
                                async: true,
                                type: 'post',
                                dataType: 'json',
                                success: function (data) {
                                    if (data.isSuccess) {
                                        $.UIkit.notify({
                                            message: "恭喜你注册成功，请选择登录！",
                                            status: 'success',
                                            timeout: 2000,
                                            pos: 'top-center'
                                        });
                                        $("#linkTab").children("a").eq("1").trigger("click");
                                    } else {
                                        $.UIkit.notify({
                                            message: data.retsultMsg,
                                            status: 'warning',
                                            timeout: 4000,
                                            pos: 'top-center'
                                        });
                                    }
                                }
                            });
                        } else {
                            $.UIkit.notify({
                                message: '两次输入密码不一致，请重新填写!',
                                status: 'warning',
                                timeout: 2000,
                                pos: 'top-center'
                            });
                            $("#register_truePassword").val("");
                            $("#register_confirmPassword").val("");
                        }
                    }
                }
            }
        }
        e.preventDefault();
        return false;
    });
    //重置注册内容
    $("#register_resetBtn").bind("click", function () {
        $("#registerFormModel").find("input").val("");
    });
    //验证用户名是否存在
    function validateIsRegisterUsernameExists(username) {
        var result = true;
        var params = new Object();
        params.username = username;
        $.ajax({
            async: false,
            url: 'isUsernameExists.action',
            data: params,
            type: "post",
            dataType: 'json',
            success: function (data) {
                if (data.isSuccess) {
                    result = false;
                    $.UIkit.notify({
                        message: '用户名已存在，请重新填写!',
                        status: 'danger',
                        timeout: 2000,
                        pos: 'top-center'
                    });
                }
            }
        });
        return result;
    }

    /*------------注册模块校验结束----------*/

    /*------------登录模块校验开始----------*/

    //登录模块的邮箱校验的绑定
    $("#userLoginName").bind("focusout", function (e) {
        if (validateInputIsEmpty("userLoginName", "用户名不能为空!")) {
            //开始校验用户名是否存在
            validateIsUsernameExists($.trim($(this).val()));
        }
    });

    //登录模块的密码验证
    $("#userLoginPassword").bind("focusout", function (e) {
        validateInputIsEmpty("userLoginPassword", "密码不能为空!")
    });

    //登录模块的提交表单绑定
    $("#loginSubmitBtn").bind("click", function (e) {
        //验证用户名是否为空！
        if (validateInputIsEmpty("userLoginName", "用户名不能为空!")) {
            //验证用户名是否存在
            if (validateIsUsernameExists($.trim($("#userLoginName").val()))) {
                //验证密码是否为空
                if (validateInputIsEmpty("userLoginPassword", "密码不能为空!")) {
                    //验证用户名和密码的正确性
                    if (!validateIsUsernameAndPwRight($.trim($("#userLoginName").val()), $.trim($("#userLoginPassword").val()))) {
                        e.preventDefault();
                        return false;
                    } else {
                        return true;
                    }
                }
            }

        }
        e.preventDefault();
    });

    //验证用户名是否存在
    function validateIsUsernameExists(username) {
        var result = true;
        var params = new Object();
        params.username = username;
        $.ajax({
            async: false,
            url: 'isUsernameExists.action',
            data: params,
            type: "post",
            dataType: 'json',
            success: function (data) {
                if (!data.isSuccess) {
                    result = false;
                    $.UIkit.notify({
                        message: '用户名不存在，请重新填写!',
                        status: 'warning',
                        timeout: 2000,
                        pos: 'top-center'
                    });
                }
            }
        });
        return result;
    }

    //验证用户名和密码是否正确
    function validateIsUsernameAndPwRight(username, password) {
        var result = true;
        var params = new Object();
        params.username = username;
        params.password = password;
        // send the reqeust
        $.ajax({
            url: "validateUserLogin.action",
            data: params,
            dataType: 'json',
            async: false,
            type: 'post',
            success: function (data) {
                if (!data.isSuccess) {
                    result = false;
                    $.UIkit.notify({
                        message: '用户名对应的密码不正确!',
                        status: 'warning',
                        timeout: 3000,
                        pos: 'top-center'
                    });
                }
            }
        });
        return result;
    }

    /*------------登录模块校验结束----------*/
    //验证表单输入是否为空
    function validateInputIsEmpty(obj, message) {
        var inputVal = $.trim($("#" + obj).val());
        if (inputVal == "" || inputVal == null) {
            $.UIkit.notify({
                message: message,
                status: 'warning',
                timeout: 3000,
                pos: 'top-center'
            });
            return false;
        } else {
            return true;
        }
    }
});