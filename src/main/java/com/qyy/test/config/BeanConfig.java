package com.qyy.test.config;

import com.qyy.test.condition.ConditionOnMissBean;
import com.qyy.test.domian.Person;
import com.qyy.test.selector.ColorSelector;
import com.qyy.test.selector.FruitImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.*;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-02 10:29
 **/
@Configuration
@Import({ColorSelector.class, FruitImportBeanDefinitionRegistrar.class})
@ComponentScan(basePackages = "com.qyy")
public class BeanConfig {

    @Bean(name = "qyy",initMethod = "initMethod",destroyMethod = "destroyMethod")
    @Conditional({ConditionOnMissBean.class})
    public Person person(){
        return new Person("qyy",21,"java engineer");
    }

    @Bean
    public Person baby(){
        return new Person("baby",21,"java engineer");
    }

    @Bean

    public Person gorge(){
        return new Person("gorge",34,"c# engineer");
    }
}
