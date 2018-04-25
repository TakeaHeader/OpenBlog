package site.btsearch;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import site.btsearch.tools.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public abstract class BaseInterceptor implements HandlerInterceptor {

    protected final Logger logger = Logger.getLogger(getClass());


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        this.DeteminedView(modelAndView);
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {


        Completion(httpServletRequest,httpServletResponse,o,e);
    }

    protected void DeteminedView(ModelAndView mav){
        Map<String,Object> model = mav.getModel();
        String ViewName = model.get("datatype") == null ? Constant.RESOURCEVIEW: model.get("datatype").toString();
        mav.setViewName(ViewName);
        logger.debug("Set ViewName >>> " + ViewName);
    }

    protected void Completion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e){};

}
