package com.Sample;

import com.Sample.c09.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest09 {
    @Test
    public void test01() {
        String config = "/c09/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ac.getBean("someService");
        System.out.println(someService.getClass().getName());

        String res = someService.doFirst("lihua", 21);
        System.out.println(res);

    }
}
