package com.qyy.test;

import com.qyy.test.config.BeanConfig;
import com.qyy.test.domian.Yellow;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-13 13:52
 **/
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Yellow yellow = context.getBean(Yellow.class);
        String[] allProfiles = yellow.getAllProfiles();
        System.out.println("当前激活的环境是——————"+ Arrays.toString(allProfiles));
    }
}
