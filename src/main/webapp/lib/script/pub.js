var F = {};

F.ajax = function (json) {
    debugger;
    var ajaxJson = {};
    ajaxJson["contentType"]= F.isNull(json.contentType) ? "application/x-www-form-urlencoded; charset=UTF-8" : json.contentType;
    ajaxJson["async"]= F.isNull(json.async) ? false : json.async;
    ajaxJson["type"]= F.isNull(json.type) ? "POST" : "GET";
    ajaxJson["url"]= F.isNull(json.url) ? "" : json.url;
    var data = F.isNull(json.data) ? {} : json.data;
    data['sign'] = Math.random();
    ajaxJson["data"]= {data:JSON.stringify(data)};
    ajaxJson["headers"]= F.isNull(json.headers) ? {} : json.headers;
    ajaxJson["beforeSend"] = function (xhr) {
        xhr.onprogress = function (event) {
            if(F.isFun(json.progress)){
                json.progress(event);
            }
        }
    };
    ajaxJson["error"]=function(XMLHttpRequest,B,C,D) {
        debugger;
    };
    ajaxJson["success"]=function(data,B,C,D) {
        debugger;
        result = data;
    };
    var result = null;
    $.ajax(ajaxJson);
    return result;
}

F.isNull = function(obj){
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

F.isFun = function (obj) {
    if(typeof obj === "function"){
        return true;
    }
    return false;
}
