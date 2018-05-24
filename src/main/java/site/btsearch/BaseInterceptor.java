package site.btsearch;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;
import site.btsearch.adapter.Service;
import site.btsearch.tools.Constant;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class BaseInterceptor extends Service implements HandlerInterceptor,ApplicationContextAware {

    protected final Logger logger = Logger.getLogger(getClass());

    private final String DATATYPE = "datatype";

    protected ApplicationContext context;

    protected final UrlPathHelper pathHelper = new UrlPathHelper();

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {
        if(!checkUri(Request,Response)){
            Response.sendRedirect(Request.getContextPath()+"/login.html");
            return false;
        }
        if(checkIP(Request)){
            Response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if(o instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)o;
            Method method = handlerMethod.getMethod();
            Class type = method.getReturnType();
            if(type.isAssignableFrom(Map.class) || type.isAssignableFrom(List.class) || type.isAssignableFrom(Collection.class)){
                modelAndView.setViewName(Constant.JSONVIEW);
            }
        }
        this.DeteminedView(modelAndView);
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        if(e != null){
            Error(httpServletRequest,httpServletResponse,o,e);
        }

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
                model.remove(DATATYPE);
                logger.debug("Set ViewName >>> " + ViewName);
            }
        }
    }


    protected void Error(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e){};


    public boolean checkUri(HttpServletRequest Request, HttpServletResponse response){
        String path = pathHelper.getRequestUri(Request);
        if(path.indexOf("/admin") != -1){
            Cookie [] cookies = Request.getCookies();
            if(cookies == null){
                return false;
            }
            if(cookies.length == 0){
                return false;
            }
            for (int i = 0; i < cookies.length; i ++){
                if("uid".equals(cookies[i].getName())){
                    if(cookies[i].getValue().length() == 0){
                        return false;
                    }else {
                        return true;
                    }
                }
            }
            return true;
        }
        return true;
    }


    public boolean checkIP(HttpServletRequest Request){
        String IP = Request.getRemoteAddr();
        return pubService.IsNotAllowIP(IP);
    }

}
