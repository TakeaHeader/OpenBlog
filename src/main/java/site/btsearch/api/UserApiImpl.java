package site.btsearch.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import site.btsearch.mapper.UserMapper;

import java.util.List;
import java.util.Map;

@Service
public class UserApiImpl implements UserApi {

    @Autowired
    private UserMapper UserService;

    public Map getUserInfo(String UID) {
       return UserService.queryUserInfo(UID);
    }

    public List<String> queryUID(String UID, String PWD) {
        return UserService.queryUID(UID,PWD);
    }

    public String querySessionUID(String SESSIONID){
        return UserService.querySessionUID(SESSIONID);
    }

    public int SaveSession(String SessionId,String UID,String datetime){
        return UserService.insertSession(SessionId,UID,datetime);
    }


    public String queryUser(String UID){
        return UserService.queryUser(UID);
    }


}
