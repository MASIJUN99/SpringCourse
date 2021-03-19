package com.Sample.c01.impl;

import com.Sample.c01.SomeService;


// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 在doSome()执行前 插入执行时间
        System.out.println("目标方法doSome()执行");
    }
}
