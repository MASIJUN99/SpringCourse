package com.Sample;

import com.Sample.c08.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest08 {
    @Test
    public void test01() {
        String config = "/c08/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeServiceImpl someService = (SomeServiceImpl) ac.getBean("someService");

        System.out.println(someService.getClass().getName());

        String res = someService.doFirst("lihua", 21);
        System.out.println(res);

    }
}
