package site.btsearch.core.base;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.util.UrlPathHelper;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultStaticResourceHandler implements HttpRequestHandler,ServletContextAware{

    @Value(value="${CONFIG.QXML}")
    private String QXML;

    @Value(value="${CONFIG.KZFW}")
    private boolean KZFW;

    private final String defaultServletName = "default";

    private final Logger logger = Logger.getLogger(DefaultStaticResourceHandler.class);

    private final UrlPathHelper pathHelper = new UrlPathHelper();

    private ServletContext servletContext;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = pathHelper.getLookupPathForRequest(request);
        String real = servletContext.getRealPath("/");
        if(url.indexOf(QXML) != -1){
            if(!checkResource()){
                response.sendError(HttpServletResponse.SC_FORBIDDEN,"禁止访问");
                return;
            }
        }else{
            if(KZFW){
                RequestDispatcher rd = this.servletContext.getNamedDispatcher(this.defaultServletName);
                rd.forward(request,response);
            }else{
                response.sendError(HttpServletResponse.SC_FORBIDDEN,"禁止访问");
            }
        }
    }

    public boolean checkResource(){

        return  false;
    }


}
