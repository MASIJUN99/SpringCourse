package com.Sample.c02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
     * 前置通知，定义方法，方法是实现切面功能的
     * 方法的定义要求：1.公共方法
     *              2.没有返回值
     *              3.方法名称自定义
     *              4.方法可以有参数也可以无参数
     *              若有参数，参数不是自定义的。
     *
     */

    /**
     * @Before: 前置通知注解
     *          属性：value，是切入点表达式，表示切面功能执行的位置
     *          位置：在方法的上面
     *          特点：1.在目标方法之前先执行
     *               2.不会改变目标方法的执行结果
     *               3.不会影响目标方法的执行
     *
     * Before表示在value参数中的方法前执行这个切面。
     */

    /**
     * 指定通知方法中的参数：JoinPoint
     * JoinPoint：业务方法，要加入切面功能的业务方法
     *            作用是：可以在通知方法中获取方法执行时的信息，例如方法名称、实参
     *                   如果你的切面功能中需要用到方法的信息，就加入JoinPoint
     *                   使用JoinPoint参数的值是框架赋予的，必须是第一个位置的参数。
     *
     */
    @Before(value="execution(public void com.Sample.c02.impl.SomeServiceImpl.doSome(String, Integer))")
    public void myBefore(JoinPoint jp){
        // 获取方法的完整定义
        System.out.println("方法的签名（定义）：" + jp.getSignature());
        System.out.println("方法的名称：" + jp.getSignature().getName());
        Object[] args = jp.getArgs();
        for(Object arg : args) {
            System.out.println("参数为：" + arg);
        }
        // 切面代码
        System.out.println("1：前置通知切面，执行时间为：" + new Date());
    }



    // 写法1
//    @Before(value="execution(public void com.Sample.c01.impl.SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore(){
//        // 切面代码
//        System.out.println("1：前置通知切面，执行时间为：" + new Date());
//    }
    // 写法2
//    @Before(value="execution(void com.Sample.c01.impl.SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore(){
//        // 切面代码
//        System.out.println("2：前置通知切面，执行时间为：" + new Date());
//    }
    // 写法3
//    @Before(value="execution(void *..SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore(){
//        // 切面代码
//        System.out.println("3：前置通知切面，执行时间为：" + new Date());
//    }
    // 写法4
//    @Before(value="execution(* *..SomeServiceImpl.doSome(..))")
//    public void myBefore(){
//        // 切面代码
//        System.out.println("4：前置通知切面，执行时间为：" + new Date());
//    }
    // 写法5
//    @Before(value="execution(* *..SomeServiceImpl.do*(..))")
//    public void myBefore2(){
//        // 切面代码
//        System.out.println("5：前置通知切面，执行时间为：" + new Date());
//    }



}
