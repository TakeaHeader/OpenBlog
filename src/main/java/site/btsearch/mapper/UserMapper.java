package site.btsearch.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {


    public List<String> queryUID(@Param("UID") String UID, @Param("PWD") String PWD);

    public Map<String,Object> queryUserInfo(String UID);

    public String querySessionUID(String SESSIONID);

    public int insertSession(@Param("SESSIONID") String SessionId,@Param("UID")String UID,@Param("CREATEDATE")String datetime);

}
