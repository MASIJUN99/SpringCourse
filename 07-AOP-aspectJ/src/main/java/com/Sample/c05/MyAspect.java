package com.Sample.c05;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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
     * 异常方法定义的格式
     * 1. public
     * 2. 没有返回值
     * 3. 方法名称自定义
     * 4. 方法有Exception、JoinPoint
     *
     */

    /**
     * @AfterThrowing: 异常通知
     *      属性：1. value 切入点表达式
     *           2. throwing 自定义的变量，目标方法抛出的异常对象
     *              变量名必须和方法的参数名一样
     *      位置：方法定义的上方
     *      特点：1. 在目标方法抛出异常时执行
     *           2. 做异常的监控程序，监控目标方法是否有异常
     *              如果有异常，可以做其他行为去解决（发邮箱、短信等）
     *           3.
     *           4.
     *
     *      实际上就是：
     *      try {
     *          SomeServiceImpl.doSecond(..);
     *      } catch {
     *          myAfterThrowing(e);
     *      }
     */
    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))" , throwing = "ex")
    public void myAfterThrowing(Exception ex) {
        System.out.println("异常通知，发生异常时执行：" + ex.getMessage());





    }
}
