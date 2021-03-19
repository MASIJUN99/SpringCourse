## 07-AOP-aspectJ

### 使用aspectJ实现AOP的基本步骤

1. 新建maven项目
   
2. 加入依赖
   
    1. spring依赖
    2. aspectJ依赖
    3. junit单元测试
    
3. 创建目标类：接口、实现类

    给类中的方法增加功能。

4. 创建切面类：普通类

    1. 在类的上面加入@Aspect
    2. 在类中定义方法，方法就是切面要执行的功能代码 
       
        在类的方法上面加入aspect的通知注解，例如@Before
        
        有需要指定切入点表达式execution
    
5. 创建spring的配置文件，声明对象，把对象交给容器统一管理

    可使用xml或者<bean>
    1. 声明目标对象
    2. 声明切面类对象
    3. 声明aspectJ框架中的自动代理生成器标签
        
        自动代理生成器：用来完成的代理对象的自动创建。
    
6. 创建测试类，从spring容器中获取目标对象（实际上就是代理对象）

    通过代理执行方法，实现AOP。

### 六个注解

1. @Before
2. @AfterReturning
3. @Around
4. @AfterThrowing
5. @After
6. @Pointer

#### c01

Before前置通知，方法有JoinPoint参数

若@Before中的目标对象错误，即代理失败、找不到目标，但程序编译运行均可以通过。

详见项目

#### c02

Before前置通知，使用JoinPoint参数

#### c03

AfterReturning后置通知

虽然AfterReturning增强处理可以访问到方法的返回值，但它不可以改变目标方法的返回值。

#### c04

Around环绕通知，多用于事务

#### c05

AfterThrowing异常通知，出现异常时执行。

#### c06

After最终通知，总是会执行，代表程序运行完毕，常用来清理内存，类似析构。

#### c07

Pointer定义和管理切入点

#### c08

展示了没有接口类的动态代理，使用的是CGLIB动态代理，spring会自动使用CGLIB

#### c09

展示了有接口的情况下使用CGLIB代理方式

效率会稍高一点的