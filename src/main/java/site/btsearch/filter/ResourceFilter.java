package site.btsearch.filter;

import org.apache.log4j.Logger;
import site.btsearch.tools.Util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourceFilter implements Filter {

    private final Logger logger = Logger.getLogger(getClass());

    private ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if(response instanceof HttpServletResponse){
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            String rid = Util.getRID();
            httpServletResponse.addHeader("rid", rid);
            logger.debug("add rid header:"+rid);
        }
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
