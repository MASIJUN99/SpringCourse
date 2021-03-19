package com.Sample.c07;

import org.aspectj.lang.annotation.*;

import java.sql.SQLOutput;


/**
 * @Aspect: 是aspectJ框架中的注解
 *          作用：表示当前类是切面类
 *          目的：给目标方法增加额外功能，有切面代码
 *          位置：在类定义的上面，声明这个类是切面类
 */
@Aspect
public class MyAspect {

    @After(value = "mypt()")
    public void myAfter() {
        System.out.println("最终通知，总是会执行，程序执行完毕");
        // 一般做资源清除工作，类似析构函数
    }

    @Before(value = "mypt()")
    public void myBefore() {
        System.out.println("前置通知，在目标之前执行");
        // 一般做资源清除工作，类似析构函数
    }

    @AfterReturning(value = "mypt()")
    public void myAfterReturning() {
        System.out.println("后置通知，在目标之后执行");
    }

    /**
     * @Pointercut: 定义和管理切入点，如果你的项目中有多个切入点表达式且重复，是可以复用的
     *              可以使用@Pointercut，可以是 public 和 private，一般为 private
     *    属性：value切入点表达式
     *    位置：在自定义的方法上面
     *    特点：当使用了@Pointcut定义在一个方法上面，此时这个方法的名称就是*切入点表达式的别名*。
     *         此时在其他的通知中，value就可以使用这个方法的名称来代替切入点表达式
     */

    @Pointcut(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    private void mypt(){

    }

}
