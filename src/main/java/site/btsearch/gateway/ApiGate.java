package site.btsearch.gateway;

import site.btsearch.api.Api;
import site.btsearch.rmi.Client;

public interface ApiGate {

    public Api getServiceApi(String protocol) throws RuntimeException;


}
