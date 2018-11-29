package site.btsearch.api.core;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Service
@RequestMapping("Demo")
public class DemoController {



    @RequestMapping("/FilterHash")
    public Map FilterHash(String param){
        Map map = new HashMap();
        map.put("key","Demo");
        return map;
    }

}
