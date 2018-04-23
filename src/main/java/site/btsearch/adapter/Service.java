package site.btsearch.adapter;

import java.util.Map;

public interface Service {

    public Boolean PreService() throws Exception;

    public Map Service() throws Exception;

    public Map AfterService() throws Exception;


}
