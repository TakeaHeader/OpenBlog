package site.btsearch.tools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/index")
public class PropertiesReader {


    @RequestMapping("/service.do")
    public Map queryXW(){
        return  null;
    }


}
