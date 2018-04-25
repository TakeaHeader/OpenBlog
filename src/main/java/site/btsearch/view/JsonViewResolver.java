package site.btsearch.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;
import java.util.Locale;

public class JsonViewResolver extends AbstractCachingViewResolver implements Ordered {

    private final String viewName = "JsonView";

    private View view = null;

    private int order = Integer.MAX_VALUE ;

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order){
        this.order = order;
    }

    public void setView(View view){
        this.view = view;
    }

    protected View loadView(String viewName, Locale locale) throws Exception {
        if(this.view != null){
            return this.view;
        }
        return (View) getApplicationContext().getBean(viewName);
    }
}
