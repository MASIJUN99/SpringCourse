package com.Sample;

import com.Sample.c02.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest02 {
    @Test
    public void test01(){
        String config = "/c02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ac.getBean("someService");
        someService.doSome("lisi", 21);

    }
}
