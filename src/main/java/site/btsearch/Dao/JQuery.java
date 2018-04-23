package site.btsearch.Dao;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public interface JQuery extends JOperation {


    public Map queryForMap(SqlSessionTemplate template,String sid, String key);

    public Map queryForMap(SqlSessionTemplate template,String sid, Object parameter, String key);

    public List QueryForList(SqlSessionTemplate template,String sid,Object parameter);

    public List QueryForList(SqlSessionTemplate template,String sid);


}