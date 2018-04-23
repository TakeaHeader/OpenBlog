package site.btsearch.view;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JsonView extends AbstractView {


    protected final String ContentType = "application/json;charset=utf-8";

    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(ContentType);
        ServletOutputStream out = response.getOutputStream();




    }



}
