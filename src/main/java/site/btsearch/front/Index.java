package site.btsearch.front;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.btsearch.Dao.JQuery;
import site.btsearch.tools.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/")
public class Index {

    private final Logger logger = Logger.getLogger(Index.class);

    @Autowired
    private JQuery query;

    @RequestMapping("/")
    public String forward(HttpServletRequest request){
        return "login";
    }


}
