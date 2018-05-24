package site.btsearch.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubMapper {

    public List<String> queryIP(String IP);


}
