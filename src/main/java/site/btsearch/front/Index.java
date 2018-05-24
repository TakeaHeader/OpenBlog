package site.btsearch.front;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import site.btsearch.adapter.Service;
import site.btsearch.api.UserApi;
import site.btsearch.dao.JQuery;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class Index  extends Service {

    private final Logger logger = Logger.getLogger(Index.class);


    @RequestMapping("/")
    public String forward(HttpServletRequest request, HttpServletResponse response, @CookieValue(name = "sessionid",required=false) String sessionid,@CookieValue(name = "uid",required=false) String uid){
        if(sessionid != null && uid == null){
           String dbuid =  userService.querySessionUID(sessionid);
           logger.debug("get uid:"+dbuid);
           Cookie cookie = new Cookie("uid",dbuid);
           cookie.setPath(servletContext.getContextPath());
           cookie.setMaxAge(-1);
           response.addCookie(cookie);
           return "admin/index";
        }else if(sessionid != null && uid != null){
            return "admin/index";
        }
        return "login";
    }


}
