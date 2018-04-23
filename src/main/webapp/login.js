$(document).ready(function () {


    $("#submit").on("click",function () {
        var pid = $("#id").val();
        var pwd = $("#pwd").val();
        var i = 0;
        var t = null;
        var timer = function () {
            var text = "";
            if(i == 3){
                i = 0;
            }
            if(i == 0){
                text = "登陆中.";
            }else if(i == 1){
                text = "登陆中..";
            }else if(i == 2){
                text = "登陆中...";
            }
            $("#submit").val(text);
            i++;
            t = setTimeout(timer,800);
        }
        timer();
        var Data = {};
        Data["pid"] = pid;
        Data["pwd"] = pwd;
        var json = {};
        json["url"] = "User/login";
        json["data"] = Data;
        F.ajax(json);
    });

});
