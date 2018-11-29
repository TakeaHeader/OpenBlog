package site.btsearch.core.interfaces;

import org.mybatis.spring.SqlSessionTemplate;
import java.util.List;
import java.util.Map;

/*
* 目前适用多数据源
* 适配于Mybaties
* 查询标准接口
* */
public interface DBQueryService<T> extends Service{

//    多数据源
    public Map queryMap(T template,String Sql,Object object) throws Exception;

    public List queryList(T template,String Sql,Object object) throws Exception;

    public Map queryMapByXml(T template, String sqlid, Object paramter) throws Exception;

    public Map queryMapFromListByXml(T template, String sqlid, Object paramter,String key) throws Exception;

    public List queryListByXml(T template,String sqlid, Object paramter) throws Exception;




}
