package com.qyy.test.util;

import com.qyy.test.ServiceTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-04-15 11:44
 **/
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static <T extends ServiceTemplate> ServiceTemplate getBeanByName(String name){
        return (ServiceTemplate) applicationContext.getBean(name);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
