package site.btsearch.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;
import site.btsearch.api.PubApi;
import site.btsearch.api.UserApi;
import site.btsearch.dao.JQuery;
import site.btsearch.tools.Assert;
import site.btsearch.tools.SpringApplicationContextHoler;

import javax.servlet.ServletContext;

public class Service implements ServletContextAware{

        @Autowired
        protected JQuery QueryService;

        @Autowired
        protected UserApi userService;

        @Autowired
        protected PubApi pubService;

        protected ServletContext servletContext;

        public void setServletContext(ServletContext servletContext) {
                this.servletContext = servletContext;
        }

        public Object getObject(String beanName){
                Assert.isNull(beanName);
                return SpringApplicationContextHoler.getBean(beanName);
        }
}
