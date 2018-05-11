package com.liser.websocket.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebSocketClientListener implements ServletContextListener {

    @Autowired
   // SocketServer nettyService;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("监听器状态为contextInitialized");
        WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    nettyService.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听器状态为contextDestroyed");
    }
}
