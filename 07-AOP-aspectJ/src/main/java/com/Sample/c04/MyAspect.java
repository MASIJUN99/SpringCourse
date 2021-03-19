package com.Sample.c04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;


/**
 * @Aspect: 是aspectJ框架中的注解
 *          作用：表示当前类是切面类
 *          目的：给目标方法增加额外功能，有切面代码
 *          位置：在类定义的上面，声明这个类是切面类
 */
@Aspect
public class MyAspect {
    /**
     * 环绕方法定义的格式
     * 1. public
     * 2. 必须返回值，推荐使用Object
     * 3. 方法名称自定义
     * 4. 方法有参数，固定参数ProceedingJoinPoint
     *
     */

    /**
     * @Around: 环绕通知
     *      属性：value 切入点表达式
     *      位置：方法定义的上方
     *      特点：1. 他是功能最强的通知
     *           2. 他在目标方法前后都能增强功能
     *           3. 他能控制目标方法是否被调用执行
     *           4. 它还能够修改原来目标方法执行结果，影响调用结果
     *
     * 环绕通知，等同于JDK的动态代理
     *
     *           1. ProceedingJoinPoint 等同于 Method
     *           2. 作用是执行目标方法
     *           3. 返回目标方法的返回值，可以被修改
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAroung(ProceedingJoinPoint pjp) throws Throwable {
        // 实现环绕通知

        // 实现分支控制
        // 获取第一个参数
        String arg_name = "";
        Object[] args = pjp.getArgs();
        if (args != null && args.length >= 1) {
            Object arg = args[0];
            arg_name = (String) arg;
        }

        Object res = null;
        if (arg_name == "zhangsan") {
            // 在目标方法之前增强功能，输出时间
            System.out.println("在目标方法之前增强功能，输出时间: " + new Date());

            // 目标方法调用
            res = pjp.proceed(); // 等同于invoke 即 Object res = doFirst();

            // 在目标方法之后增强功能，提交事务
            System.out.println("在目标方法之后增强功能，提交事务");

            // 返回结果
            return res;
        } else {
            // 在目标方法之前增强功能，输出时间
            System.out.println("在目标方法之前增强功能，输出时间: " + new Date());

            // 在目标方法之后增强功能，提交事务
            System.out.println("在目标方法之后增强功能，提交事务");

            // 修改结果，影响方法的调用结果
            res = "Name is not equal zhangsan!";

            // 返回结果
            return res;
        }


    }
}
