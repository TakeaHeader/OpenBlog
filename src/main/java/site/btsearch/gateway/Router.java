package site.btsearch.gateway;

import site.btsearch.api.Api;
import site.btsearch.tools.Assert;

import java.util.HashMap;
import java.util.Map;

public class Router {

    private static Map <String,Api>RouteTable = new HashMap();

    static {
    }

    public static void registerApi(String protocol, Api api){
        if(!RouteTable.containsKey(protocol)){
            RouteTable.put(protocol,api);
        }
    }

    public static Api findTargetApi(String protocol){
        Assert.isNull(protocol);
        Api api = RouteTable.get(protocol);
        return api;
    }


}
