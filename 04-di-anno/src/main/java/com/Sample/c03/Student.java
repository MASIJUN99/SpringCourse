package com.Sample.c03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {

    /**
     * @Value: 简单类型的属性赋值
     * 属性： value 是String类型，表示简单类型的属性值
     * 位置： 1. 在属性定义的上面，不需要set方法，推荐
     *       2. 在set方法上面
     */

    @Value(value = "张飞")  // 可省略value属性，直接 @Value("张飞")
    private String name;
    @Value(value = "29")
    private int age;
    /**
     * 引用类型
     * @Autowired： spring框架提供的注解，实现引用类型的注解
     * spring中通过注解给引用类型赋值，使用的是自动注入原理，支持byName， byType
     * @Autewired： 默认是byType自动注入
     * 位置：1. 在属性定义的上面，无需set方法，推荐
     *      2. 在set方法上面
     */
    @Autowired
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
