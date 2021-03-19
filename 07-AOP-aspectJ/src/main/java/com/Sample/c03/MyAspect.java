package com.Sample.c03;

import org.aspectj.lang.annotation.AfterReturning;
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
     * 后置通知，定义方法，方法是实现切面功能的
     * 方法的定义要求：1.公共方法
     *              2.没有返回值
     *              3.方法名称自定义
     *              4.方法是有参数的，参数推荐使用Object，参数名自定义
     *
     */

    /**
     * @AfterReturning: 后置通知
     *          属性：1.value，切入点表达式
     *               2.returning，自定义的变量，表示目标方法的返回值
     *               自定义变量名称必须和通知方法的形参名一样。
     *          位置：在方法定义的上面
     *          特点：1.在目标方法之后先执行
     *               2.能够获取到目标方法的返回值，根据这个返回值可以做不同的功能
     *                 Object res = doOther()
     *               3.可以修改返回值
     *
     * 后置通知的执行
     *      Object res = doOther();
     *      myAfterReturning(res);
     *      System.out.println(res); -->还是abc
     *
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))", returning = "res")
    public void myAfterReturning(Object res) {
        // Object res:是目标方法执行后的返回值，根据返回值做你的切面的功能处理
        System.out.println("后置通知：在目标方法之后执行，获取的返回值是：" + res);


        if (res.equals("abc")) {
            // do some
        } else {
            // do some
        }

        if (res != null) {
            res = "Hello AfterReturning";
        }

    }

    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther2(..))", returning = "res")
    public void myAfterReturning2(Object res) {
        // Object res:是目标方法执行后的返回值，根据返回值做你的切面的功能处理
        System.out.println("后置通知：在目标方法之后执行，获取的返回值是：" + res);

        // 修改res内容、属性值，会不会影响调用结果。
        Student student = new Student();
        student.setName("xiaoma");
        student.setAge(18);
        res = student;
    }


}
