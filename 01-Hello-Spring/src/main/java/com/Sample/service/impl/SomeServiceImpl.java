package com.Sample.service.impl;

import com.Sample.service.SomeService;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl(){
        System.out.println("init");
    }

    @Override
    public void doSome() {
        System.out.println("Success called the doSome() function!");
    }

    public void doSome2(){
        System.out.println("Success called the doSome2() function!");
    }
}
