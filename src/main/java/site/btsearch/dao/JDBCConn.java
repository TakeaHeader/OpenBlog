package site.btsearch.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class JDBCConn {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

}
