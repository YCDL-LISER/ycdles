package com.liser.common.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocator implements ApplicationContextAware {
    private static ApplicationContext appContext;

    public ServiceLocator() {
    }

    public void setApplicationContext(ApplicationContext ac) {
        appContext = ac;
    }

    public static Object getService(String key) {
        return appContext.getBean(key);
    }

    public static boolean containsBean(String key) {
        return appContext.containsBean(key);
    }

    public static ApplicationContext getAppContext() {
        return appContext;
    }

    public static <T> T getService(Class<T> clazz) {
        return appContext.getBean(clazz);
    }
}
