package SpringMVC.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { //create ContextLouderListener
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//create WebAppContext and loud Beans
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() { //Servlet
        return new String[]{"/"};
    }
}
