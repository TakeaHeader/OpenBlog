package site.btsearch.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SimpleQuery extends JDBCConn implements JQuery {

    public Map queryForMap(SqlSessionTemplate template,String sid, String key) {
        return template.selectMap(sid,key);
    }

    public Map queryForMap(SqlSessionTemplate template,String sid, Object parameter,String key){
        return template.selectMap(sid,parameter,key);
    }

    public List QueryForList(SqlSessionTemplate template,String sid, Object parameter) {
        return template.selectList(sid,parameter);
    }

    public List QueryForList(SqlSessionTemplate template,String sid){
        return template.selectList(sid);
    }

}
