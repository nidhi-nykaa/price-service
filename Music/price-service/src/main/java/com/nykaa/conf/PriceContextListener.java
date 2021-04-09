package com.nykaa.conf;

import com.nykaa.service.StartUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@ManagedBean
public class PriceContextListener implements ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(PriceContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("context initialized event called.........");
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        StartUpService startupService = context.getBean(StartUpService.class);
        try {
            startupService.load();
        } catch (Exception e) {
            throw new RuntimeException("Application startup failed. Exception is : ", e);
        }
    }
}
