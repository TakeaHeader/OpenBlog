package site.btsearch.api;

public interface PubApi extends Api {


    public boolean IsNotAllowIP(String IP);


    public int insertLog(String Message,String datetime);



}
