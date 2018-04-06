package site.btsearch.Dao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SimpleQuery extends JDBCConn implements JQuery {


    public Map queryForMap() {
        return null;
    }

    public List QueryForList() {
        return null;
    }

    public Map queryForMap(String statmentid,String mapkey){
        return sqlSessionTemplate.selectMap(statmentid,mapkey);
    }
}
