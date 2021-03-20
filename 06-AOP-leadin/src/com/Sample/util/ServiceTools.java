package com.Sample.util;

import java.util.Date;

public class ServiceTools {
    public static void doLog(){
        System.out.println("非业务方法，显示时间");
    }

    public static void doTrans(){
        System.out.println("非业务方法，提交事务");
    }
}
