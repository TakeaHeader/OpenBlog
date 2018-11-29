package site.btsearch.core.service;

import org.mybatis.spring.SqlSessionTemplate;
import site.btsearch.core.interfaces.DBQueryService;
import site.btsearch.core.tools.Constant;
import java.util.List;
import java.util.Map;

public class DefaultDBQueryService extends AbstractService implements DBQueryService<SqlSessionTemplate>{

    public Map queryMap(SqlSessionTemplate template, String Sql, Object object) throws Exception {
        throw new RuntimeException("unsupported opration!");
    }

    public List queryList(SqlSessionTemplate template, String Sql, Object object) throws Exception {
        throw new RuntimeException("unsupported opration!");
    }

    public Map queryMapByXml(SqlSessionTemplate template, String sqlid, Object paramter) throws Exception {
        return template.selectOne(sqlid,paramter);
    }

    public List queryListByXml(SqlSessionTemplate template, String sqlid, Object paramter) throws Exception {
        return template.selectList(sqlid,paramter);
    }

    public Map queryMapFromListByXml(SqlSessionTemplate template, String sqlid, Object paramter, String key) throws Exception {
        return template.selectMap(sqlid,paramter,key);
    }

    public String getServiceName() {
        return Constant.DBQuery;
    }




}
