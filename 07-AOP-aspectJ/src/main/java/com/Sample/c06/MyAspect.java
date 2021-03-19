package com.Sample.c06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


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
     * 4. 方法没有参数除了JoinPoint
     *
     */

    /**
     * @After: 最终通知
     *      属性：value 切入点表达式
     *      位置：方法定义的上方
     *      特点：1. 总是会执行
     *           2. 在目标方法之后执行
     *
     *      try {
     *
     *      } catch {
     *
     *      } finally {
     *          myAfter();
     *      }
     */
    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myAfter() {
        System.out.println("最终通知，总是会执行，程序执行完毕");
        // 一般做资源清除工作，类似析构函数

    }
}
