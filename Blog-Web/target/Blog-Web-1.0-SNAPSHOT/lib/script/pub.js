var HttpUtil= {};

HttpUtil.ajax = function (json) {
    var ajaxJson = {};
    ajaxJson["contentType"]= Util.isNull(json.contentType) ? "application/x-www-form-urlencoded; charset=UTF-8" : json.contentType;
    ajaxJson["async"]= Util.isNull(json.async) ? false : json.async;
    ajaxJson["type"]= Util.isNull(json.type) ? "GET" : "POST";
    ajaxJson["url"]= Util.isNull(json.url) ? "" : json.url;
    var data = Util.isNull(json.data) ? {} : json.data;
    data['sign'] = Math.random();
    $.extend(data,$.cookie("pid"));
    ajaxJson["data"]= {data:JSON.stringify(data)};
    ajaxJson["headers"]= Util.isNull(json.headers) ? {} : json.headers;
    ajaxJson["beforeSend"] = function (xhr) {
        xhr.onprogress = function (event) {
            if(Util.isFun(json.progress)){
                json.progress(event);
            }
        }
    };
    ajaxJson["error"]=function(XMLHttpRequest,B,C) {
        if(Util.isFun(json.error)){
            json.error(C);
        }
    };
    ajaxJson["success"]=function(data,B,C) {
        var type = C.getResponseHeader("content-type");
        if(type.indexOf("text/html") != -1){
            console.error("content-type text/html is not supported!");
        }else if(type.indexOf("application/json") != -1){
            var code = typeof data.code === "undefined" ? 0 : data.code;
            if(code == 1){
                if(Util.isFun(json.success)){
                    json.success(data.data);
                }
                if(data.url != undefined){
                    window.location.href = data.url;
                }
            }else if (code == 0){
                if(Util.isFun(json.error)){
                    json.error(data);
                }
            }
        }
    };
    $.ajax(ajaxJson);
}

HttpUtil.isNull = function(obj){
    if(typeof obj == "undefined"){
        return true;
    }else if(obj == null){
        return true;
    }else if(typeof obj == "string" && (obj === "" || obj === "undefined" || obj === "null")){
        return true;
    }else if(typeof obj == "object" && $.isArray(obj) && obj.length == 0){
        return true;
    }else if(typeof obj == "object" && $.isEmptyObject(obj)){
        return true;
    }else{
        return false;
    }
}

HttpUtil.isFun = function (obj) {
    if(typeof obj === "function"){
        return true;
    }
    return false;
}
