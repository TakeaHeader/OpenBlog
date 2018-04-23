package site.btsearch.front;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class User {


    @RequestMapping("/login")
    public Map login(String data){
        System.out.println("Login");
        return new HashMap();
    }




}
