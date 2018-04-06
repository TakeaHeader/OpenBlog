package site.btsearch.Dao;

import java.util.List;
import java.util.Map;

public interface JQuery extends JOperation {


    public Map queryForMap();

    public List QueryForList();

    public Map queryForMap(String statmentid,String mapkey);






}