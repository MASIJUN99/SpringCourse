package com.Sample.c02.impl;

import com.Sample.c02.SomeService;


// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 在doSome()执行前 插入执行时间
        System.out.println("目标方法doSome()执行");
    }
}
