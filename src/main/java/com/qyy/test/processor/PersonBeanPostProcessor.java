package com.qyy.test.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-02 10:49
 **/
@Component
public class PersonBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanConfig")) {
            System.out.println("当前的bean是->"+bean);
            Method[] methods = bean.getClass().getMethods();
//            Arrays.stream(methods)
//                    .map(AccessibleObject::getAnnotations)
//                    .forEach(annotations ->
//                            System.out.println("beanconfig 所有的方法的注解分别是"+Arrays.asList(annotations)));
            System.out.println(Arrays.asList(bean.getClass().getAnnotations()));
        }
        if(beanName.equals("yellow"))
            System.out.println("yellow bean is "+bean);
            System.out.println("加的注解是 "+ Arrays.toString(bean.getClass().getAnnotations()));
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
