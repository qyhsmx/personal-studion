package com.qyy.test.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-02 10:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class Person implements InitializingBean, DisposableBean {

    private String name;
    private Integer age;
    private String describe;

    @PostConstruct
    public void postConstruct(){
        System.out.println("person qyy -> postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("person qyy -> preDestroy");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("person qyy -> destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("person qyy -> afterPropertiesSet");
    }

    public void initMethod(){
        System.out.println("person qyy -> initMethod");
    }
    public void destroyMethod(){
        System.out.println("person qyy -> destroyMethod");
    }
}
