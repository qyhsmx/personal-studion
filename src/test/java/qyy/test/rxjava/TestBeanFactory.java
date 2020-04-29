package qyy.test.rxjava;

import com.qyy.test.config.BeanConfig;
import com.qyy.test.domian.*;
import com.qyy.test.processor.TestLoadTimeWeaverAware;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import java.util.Arrays;

/**
 * @description: 这是代码里唯一的注释
 * @author: QinYong
 * @create: 2020-01-09 09:29
 **/
public class TestBeanFactory {
    
    @Test
    public void test12(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int l = 0,r = matrix[0].length-1,t = 0,b = matrix.length-1,x = 0;
        int[] res = new int[(r+1)*(b+1)];
        while (true){
            // l -> r
            for (int i=l;i<=r;i++)res[x++]=matrix[t][i];
            if(++t>b)break;
            // t -> b
            for (int j=t;j<=b;j++)res[x++]=matrix[j][r];
            if(--r<l)break;
            // r -> l
            for (int m=r;m>=l;m--)res[x++]=matrix[b][m];
            if(--b<t)break;
            // b -> t
            for (int n=b;n>=t;n--)res[x++]=matrix[n][l];
            if(++l>r)break;

        }
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test01(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        ConstructorArgumentValues values = new ConstructorArgumentValues();
        values.addIndexedArgumentValue(0,new Apple());
        values.addIndexedArgumentValue(1,new Color());
        Person person = new Person();
        person.setName("qyy");
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("person", person);

        factory.registerBeanDefinition("testBean",new RootBeanDefinition(TestBean.class,values,propertyValues));
        Object testBean = factory.getBean("testBean");
        System.out.println(testBean);
    }
    @Test
    public void test02(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory(new AnnotationConfigApplicationContext(BeanConfig.class));

        String[] type = factory.getBeanNamesForType(TestLoadTimeWeaverAware.class);

        System.out.println("TestLoadTimeWeaverAware all is ->"+Arrays.toString(type));

        factory.destroySingletons();
    }
    @Test
    public void test03(){
        FileSystemXmlApplicationContext context =
                new FileSystemXmlApplicationContext("D:\\sto gitlab\\personal-studio\\src\\main\\resources\\application.xml");
        String[] names = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));
    }

    @Test
    public void test04(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Yellow yellow = context.getBean(Yellow.class);
        String[] allProfiles = yellow.getAllProfiles();
        System.out.println("当前激活的环境是——————"+Arrays.toString(allProfiles));
    }
    @Test
    public void test014(){
        System.out.println(3|9);// 3 = 11 9 = 101
        // 101
        // 011
        // 111
    }


}
