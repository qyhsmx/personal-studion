package com.qyy.test.processor;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-09 13:22
 **/
@Component
public class TestBeanNameAware implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("the implement of beanNameAware is "+ s);
    }
}
