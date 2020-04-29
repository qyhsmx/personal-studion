package qyy.test.rxjava;

import com.qyy.test.config.BeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-02 10:31
 **/
public class TestSpring {

    private AnnotationConfigApplicationContext context;

    @Before
    public void getApplicationContext(){
        context = new AnnotationConfigApplicationContext(BeanConfig.class);
    }

    @Test
    public void showAllBeanName(){
        String[] names = context.getBeanDefinitionNames();
        Arrays.asList(names).forEach(System.out::println);
        //context.close();
    }
}
