package site.btsearch.api.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface WebSocketInterface {


    public int insertLog();

    public String queryID();

}
