package site.btsearch;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import site.btsearch.tools.JSON;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Interceptor extends BaseInterceptor{


    @Override
    protected void Error(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
            logger.debug(e);
            Map result = new HashMap();
            result.put("code",0);
            result.put("msg",e.getMessage());
            ServletOutputStream out = null;
            try{
                httpServletResponse.setContentType("application/json;charset=utf-8");
                out = httpServletResponse.getOutputStream();
                byte [] data = JSON.toByteArray(result);
                out.write(data,0,data.length);
                out.flush();
                out.close();
            }catch (Exception ex){
                logger.error(ex);
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }finally {
                if(out != null){
                    try{
                        out.close();
                    }catch (IOException e1){
                        logger.error(e1);
                    }
                }
            }
    }
}
