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

    private final String DATATYPE = "datatype";


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        this.DeteminedView(modelAndView);
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        Completion(httpServletRequest,httpServletResponse,o,e);
    }


    /**
     *you can add a datatype to set datatype ,default is Constant.RESOURCEVIEW
     * @param mav
     */
    protected void DeteminedView(ModelAndView mav){
        if(mav != null){
            Map<String,Object> model = mav.getModel();
            String ViewName = model.get(DATATYPE) == null ? null: model.get(DATATYPE).toString();
            if(ViewName != null){
                mav.setViewName(ViewName);
                logger.debug("Set ViewName >>> " + ViewName);
            }
        }
    }



    protected void Completion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e){};

}
