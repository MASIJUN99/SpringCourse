package com.Sample;

import com.Sample.c03.SomeService;
import com.Sample.c03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
   @Test
    public void test01(){
        String config = "/c03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ac.getBean("someService");

        String ans = someService.doOther("zhangsan", 28);
        System.out.println(ans);
    }

    @Test
    public void test02(){
        String config = "/c03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ac.getBean("someService");

        Student ans = someService.doOther2("lisi", 25);
        System.out.println(ans);
    }
}
