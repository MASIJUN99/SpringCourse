package com.Sample.c08;


// 目标类
public class SomeServiceImpl {
    public void doSome(String name, Integer age) {
        // 在doSome()执行前 插入执行时间
        System.out.println("目标方法doSome()执行");
    }

    public String doOther(String name, Integer age) {
        System.out.println("目标方法都Other()执行");
        return "abc";
    }

    public String doFirst(String name, Integer age) {
        System.out.println("目标方法doFirst()");
        return "doFirst";
    }

}
