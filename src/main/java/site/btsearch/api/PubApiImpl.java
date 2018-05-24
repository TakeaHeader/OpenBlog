package site.btsearch.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.btsearch.mapper.PubMapper;

import java.util.List;

@Service
public class PubApiImpl implements PubApi {

    @Autowired
    private PubMapper pubMapper;

    public boolean IsNotAllowIP(String IP) {
        List<String> IPS = pubMapper.queryIP(IP);
        if(IPS.size() != 0){
            return  true;
        }
        return false;
    }

}
