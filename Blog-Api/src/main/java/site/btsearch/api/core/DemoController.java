package site.btsearch.api.core;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import site.btsearch.api.mapper.WebSocketInterface;
import site.btsearch.core.message.Publisher;
import site.btsearch.core.message.event.WebSocketEvent;
import site.btsearch.core.service.DefaultDBQuery;
import site.btsearch.core.websocket.MessageType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequestMapping("Demo")
public class DemoController {

    @Autowired
    private Publisher publisher;

    @Autowired
    private DefaultDBQuery queryService;

    @Autowired
    private WebSocketInterface webSocketInterface;

   @RequestMapping("/FilterHash")
    public Map FilterHash(String param) throws Exception{

        String Sql = "SELECT * from userlogins";
        List list =  queryService.queryList(Sql,null);
        Map map = new HashMap();
        map.put("Type", MessageType.MSG_ALL);
        JSONObject data = new JSONObject();
        data.put("name","张维");
        map.put("data",data);
        publisher.PulishEvent(new WebSocketEvent(map));
        map.put("key","Demo");
        return map;
    }

    @RequestMapping("/GenerateSocketId")
    public Map GenerateSocketId(){
        JSONObject object = new JSONObject();
        int i  = webSocketInterface.insertLog();
        String ID = "";
        int code = -1 ;
        if(i == 1){
            ID = webSocketInterface.queryID();
            code = 1;
        }
        object.put("ID",ID);
        object.put("code",code);
        return object;
    }

}
