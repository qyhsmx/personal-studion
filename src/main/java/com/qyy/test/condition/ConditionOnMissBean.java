package com.qyy.test.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-02 10:43
 **/
@Slf4j
public class ConditionOnMissBean implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //hypothesis there is no another person whose name is baby

        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        boolean flag = registry.containsBeanDefinition("testEntity");
        log.info("是否包含 testEntity "+ flag);
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        log.info("所有的bean "+ Arrays.asList(beanDefinitionNames));
        return !flag;
    }
}
