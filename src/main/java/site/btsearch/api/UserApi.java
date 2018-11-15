package site.btsearch.api;

import java.util.List;
import java.util.Map;
/***
 *
 * 用户服务相关Api规范
 *
 */
public interface UserApi extends Api{

    public Map getUserInfo(String UID);

    public List<String> queryUID(String UID, String PWD);

    public String querySessionUID(String SESSIONID);

    public int SaveSession(String SessionId,String UID,String datetime);

    public String queryUser(String UID);

}
