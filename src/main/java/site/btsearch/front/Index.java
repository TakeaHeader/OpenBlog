package site.btsearch.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class Index {


    @RequestMapping("/")
    public String forward(){
        return "user";
    }



}
