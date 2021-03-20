package com.Sample.handler;

import com.Sample.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    // 目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("执行：" + method.getName() + "()");

        // 通过代理对象执行方法时，会调用此invoke()
        Object res = null;

        // 添加日志
        ServiceTools.doLog();

        // 执行目标类的方法，通过method类实现。
        res = method.invoke(target ,args);  // SomeServiceImpl.doSome()或者doOther()

        // 执行业务方法
        ServiceTools.doTrans();

        // 目标方法执行结果
        return res;
    }
}
