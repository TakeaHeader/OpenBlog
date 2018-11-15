package site.btsearch.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCConn {

//    mybatis 数据源
    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;


//    spring 数据源
    @Autowired
    protected JdbcTemplate jdbcTemplate;



}
