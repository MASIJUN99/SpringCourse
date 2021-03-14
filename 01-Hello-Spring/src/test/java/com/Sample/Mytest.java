package com.Sample;

import com.Sample.service.SomeService;
import com.Sample.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.Provider;
import java.util.Date;

public class Mytest {
    @Test
    public void test01(){
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void test02(){
        // 使用spring创建的对象
        // 1. 指定spring配置文件的名称
        String config = "beans.xml";
        // 2. 创建spring容器对象，ApplicationContext
        // ApplicationContext就表示spring容器，通过容器对象能够获取里面的对象。
        // ClassPathXmlApplicationContext 表示从类路径中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 3. 从容器中获取某个对象，调用对象的方法
        // getBean(配置文件中bean的id值)
        SomeService service = (SomeService) ac.getBean("someService");
        // 使用spring创建好的对象
        service.doSome2();
    }

    /**
     * 获取spring容器中java对象的信息
     */
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // spring容器中对象的数量
        int nums = ac.getBeanDefinitionCount();
        System.out.println(nums);
        // spring容器中对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for(String name: names){
            System.out.println(name);
        }
    }

    /**
     * 获取非自定义类对象
     */
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // spring容器中对象的数量
        Date mydata = (Date) ac.getBean("mydate");
        System.out.println("Data" + mydata);

    }
}
