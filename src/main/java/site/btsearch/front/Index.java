package site.btsearch.front;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.btsearch.Dao.JQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/")
public class Index {

    private final Logger logger = Logger.getLogger(Index.class);

    @Autowired
    private JQuery query;

    @RequestMapping("/")
    public String forward(HttpServletRequest request){
        Map map = query.queryForMap("User.queryUser","UID");
        logger.debug(map);
        return "login";
    }



}
