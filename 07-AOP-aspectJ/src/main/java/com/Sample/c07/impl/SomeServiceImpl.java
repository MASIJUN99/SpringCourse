package com.Sample.c07.impl;


import com.Sample.c07.SomeService;

// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 在doSome()执行前 插入执行时间
        System.out.println("目标方法doSome()执行");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("目标方法都Other()执行");
        return "abc";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("目标方法doFirst()");
        return "doFirst";
    }

}
