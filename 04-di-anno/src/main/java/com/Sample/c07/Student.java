package com.Sample.c07;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myStudent")
public class Student {

    @Value(value = "张飞")  // 可省略value属性，直接 @Value("张飞")
    private String name;
    @Value(value = "29")
    private int age;
    /**
     * 引用类型
     * @Resource: 来自jdk中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
     *            使用的也是自动注入原理，支持byName byType，默认是byName
     *
     * 位置： 1. 在属性定义的上面，无需set方法，推荐
     *       2. 在set方法的上面
     *
     * 属性： 1. 使用byName方式，添加属性name属性
     *       2. 使用byType方式，默认方式
     */
    @Resource(name = "mySchool")
    private School school;


    public Student() {
        System.out.println("执行无参数构造方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
