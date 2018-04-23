package site.btsearch.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCConn {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

}
