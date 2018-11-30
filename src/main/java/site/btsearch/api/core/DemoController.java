package site.btsearch.api.core;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import site.btsearch.core.message.Publisher;
import site.btsearch.core.message.event.WebSocketEvent;
import site.btsearch.core.websocket.MessageType;

import java.util.HashMap;
import java.util.Map;

@Service
@RequestMapping("Demo")
public class DemoController {

    @Autowired
    private Publisher publisher;



    @RequestMapping("/FilterHash")
    public Map FilterHash(String param){

        Map map = new HashMap();
        map.put("Type", MessageType.MSG_ALL);
        JSONObject data = new JSONObject();
        data.put("name","张维");
        map.put("data",data);
        publisher.PulishEvent(new WebSocketEvent(map));
        map.put("key","Demo");
        return map;
    }

}
