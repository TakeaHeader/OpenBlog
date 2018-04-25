package site.btsearch.front;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class User {

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login(String data){
        System.out.println("Login");
        return "admin/index";
    }




}
