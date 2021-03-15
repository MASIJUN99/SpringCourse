package com.Sample.c08;

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

    @Value("${myname}")  // 可省略value属性，直接 @Value("张飞")
    private String name;
    @Value("${myage}")
    private int age;

    public Student() {
        System.out.println("执行无参数构造方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
