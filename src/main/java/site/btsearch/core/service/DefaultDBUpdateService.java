package site.btsearch.core.service;

import org.mybatis.spring.SqlSessionTemplate;
import site.btsearch.core.interfaces.DBUpdateService;
import site.btsearch.core.tools.Constant;

public class DefaultDBUpdateService<SqlSessionTemplate> extends AbstractService implements DBUpdateService<SqlSessionTemplate> {

    public int insert(SqlSessionTemplate template, String sql, Object param) throws Exception {
        return 0;
    }

    public int update(SqlSessionTemplate template, String sql, Object param) throws Exception {
        return 0;
    }

    public int insertByXml(SqlSessionTemplate template, String sqlid, Object param) throws Exception {
        return 0;
    }

    public int updateByXml(SqlSessionTemplate template, String sqlid, Object param) throws Exception {
        return 0;
    }

    public int delete() throws Exception {
        return 0;
    }



    public String getServiceName() {
        return Constant.DBUpdate;
    }
}
