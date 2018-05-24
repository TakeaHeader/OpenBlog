$(document).ready(function () {


    $("#submit").on("click",function () {
        var pid = $("#id").val();
        var pwd = $("#pwd").val();
        var form = {};
        form["pid"] = pid;
        form["pwd"] = pwd;
        var json = {};
        json["url"] = "User/login";
        json["data"] = form;
        Util.ajax(json);
    });


});
