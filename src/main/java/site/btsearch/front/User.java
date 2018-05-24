package site.btsearch.front;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import site.btsearch.adapter.Service;
import site.btsearch.api.UserApi;
import site.btsearch.tools.Constant;
import site.btsearch.tools.DATE;
import site.btsearch.tools.JSON;
import site.btsearch.tools.Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class User extends Service{


    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public Map login(String data, HttpServletResponse response, HttpServletRequest request) throws RuntimeException{
        JSONObject Param = JSON.toJSONObject(data);
        if(!Param.containsKey("pid") || !Param.containsKey("pwd")){
            throw new RuntimeException("请输入用户名或密码!");
        }
        String uid = Param.getString("pid");
        String pwd = Param.getString("pwd");
        if(uid.length() == 0 || pwd.length() == 0){
            throw new RuntimeException("请输入用户名或密码!");
        }
        pwd = Util.getMD5(pwd);
        List<String> user = userService.queryUID(uid,pwd);
        Map result  = new HashMap();
        if(user.size() == 1){
            result.put("code",1);
            String UID = user.get(0);
            String id = request.getSession().getId();
            userService.SaveSession(id,UID, DATE.getFull());
            Cookie cookie = new Cookie("sessionid",id);
            cookie.setPath(servletContext.getContextPath());
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            Cookie uidcookie = new Cookie("uid",UID);
            uidcookie.setPath(servletContext.getContextPath());
            cookie.setMaxAge(-1);
            response.addCookie(uidcookie);
            result.put("url","admin/index.html");
            return result;
        }else{
            throw new RuntimeException("用户不存在,请检查用户名或密码!");
        }
    }




}
