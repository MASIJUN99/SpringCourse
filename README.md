# SpringCourse

## IOC控制反转

## AOP面向切面编程

### 动态代理

动态代理指的是，程序在整个运行过程中根本就不存在目标类的代理类，目标对象的戴笠对象只是有代理生成工具（不是真实定义的类）在程序运行时由JVM根据反射等动态机制生成的。代理对象与目标对象的代理管旭在程序运行时才确立。

实际上就是在原本程序不改动的情况下，通过动态代理，给原先的类增加额外的功能。

#### JDK动态代理

动态代理的实现方式常用的有两种：使用JDK的Proxy，与通过CGLIB生成代理。JDK的动态要求目标对象必须实现接口，这是Java设计上的要求。

从JDK1.3依赖，Java通过java.lang.reflect包提供三个类支持代理模式Proxy、Method、InvocationHandler。

#### CGLIB动态代理

CGLIB（Code Generation Library）是一个第三方开源工具库。是一个强大的，高性能的，高质量的Code生成类库，它可以在运行期间扩展Java类与实现Java接口。倍广泛的用于很多AOP框架。

根本原理是继承，通过创建子类，在子类中重写父类方法，来实现类的增强。

#### 动态代理的作用

1. 在不改变源代码的基础上，增加功能。
2. 减少重复代码
3. 能更专注业务逻辑代码
4. 解耦合

### AOP (Aspect Orient Programming)

AOP就是面向切面编程，基于动态代理，可以使用jdk和cglib两种方式。

由于动态代理难以掌握，所以有了AOP。

AOP就是动态代理的规范化，把动态代理的实现步骤、方式都定义好了，让开发人员用一种统一的方式进行动态代理，更易于维护。

#### Aspect

切面，实际上就是目标类额外增加的功能就是切面。

一般为非业务功能，独立使用的。

#### Orient

面向

#### Programming

编程

#### 怎样理解

以增加*切面*的方式去完善项目，以切面为核心完成编程。
1. 在分析项目功能时，找出切面
2. 合理安排切面执行时间
3. 合理安排切面执行位置，在哪个方法执行切面

#### 几个术语

1. Aspect：切面，给业务方法**增强的功能**，一般是非业务功能

    常见的切面共能有：日志、事务、统计信息、参数检查、权限验证...

2. JoinPoint：连接点，连接业务方法和切面的位置。

    其实就是某个类中的业务方法，即被添加切面的方法。

3. Pointcut：切入点，指多个连接点方法的集合。多个方法，都要加入切面功能。

4. 目标对象：给哪个类的方法增加功能，这个类就是目标对象。

5. Advice：通知，表示切面功能执行时间。

#### 切面的三个关键要素

1. 切面的功能代码 - Aspect
2. 切面的执行位置 - Pointcut
3. 切面的执行时间 - Advice

#### AOP实现流程

AOP是一个规范，是动态的一个规范化、标准化的代理

技术框架
1. spring：在内部实现了AOP规范，能做AOP工作

    spring主要在事务处理时使用AOP。

    在项目开发中很少使用spring的AOP，因为spring的AOP比较繁琐。

2. aspectJ：开源的专门做AOP的框架。

    业内来说最权威的框架。

    spring中继承了aspectJ框架，通过spring就能使用aspectJ的功能。

    使用方法
    1. 使用xml配置文件，配置全局事务。
    2. 使用注解（一般都使用这个，有五个注解）

#### aspectJ的使用

1. 切面的执行时间，这个执行时间在规范中叫做Advice（通知、增强）

    在aspectJ中通过注解表示或`.xml`文件的标签

    1. @Before
    2. @AfterReturning
    3. @Around
    4. @AfterThrowing
    5. @After

2. 表示切面执行的位置，也叫做切入点表达式

    ```
    excution(modifiers-pattern? ret-type-pattern
            declaring-type-pattern? name-pattern(param-pattern)
            throws-pattern?)
    ```

    * modifiers-pattern: 访问权限类型，public private等

    * ret-type-pattern：返回值类型，void int等

    * declaring-type-pattern: 包名类名

    * name-pattern: 方法名

    * throws-pattern: 返回抛出异常类型

    即execution(访问权限 <font color=red>方法返回值</font> <font color=red>方法声明(参数)</font> 异常类型)

    切入点表达式要匹配的对象就是目标方法的方法名，所以execution表达式中明显就是方法的签名，可以用通配符：

   |  符号   | 含义  |
   |  :----:  | ----  |
   | *  | 0至多个任意字符。 |
   | .. | 用在方法参数中，表示任意多个参数；<br>用在包名后，表示当前包及其子包。|
   | +  | 用在类名后，表示的当前类及其子类；<br>用在接口后，表示当前接口及其实现类。 |

    举例：

    > `execution(public * *(..))`
    >
    > 指定切入点为：任意公共方法

    > `execution(set* *(..))`
    >
    > 指定切入点为：任意set开头的方法
    >

    > `execution(* com.Sample.service.*.*(..))`
    >
    > 指定切入点为：任意在com.Sample.service内类的方法（子包不包含）

    > `execution(* com.Sample.service..*.*(..))`
    >
    > 指定切入点为：任意在com.Sample.service内类的方法（子包包含）

    > `execution(* *..service.*.*(..))`
    >
    > 指定切入点为：所有包内service内类的方法（子包不包含）


3. AOP使用时机

    1. 当你要给一个系统中存在的类修改、增加额外功能
    2. 你要给项目中多个类增加同一个功能
    3. 给业务方法增加事务功能

### mybatis

用的技术是ioc

为什么ioc能把mybatis和spring集成在一起呢，象一个框架呢？

是因为ioc能创建对象，可以把mybatis框架中的对象交给spring统一创建，开发人员从spring中获取对象。

开发人员就可以不用同时面对两个或者多个框架了，就只面对spring。

#### mybatis使用步骤

1. 定义Dao接口，StudentDao
2. 定义mapper文件，StudentDao.xml
3. 定义mybatis的主配置文件，mybatis.xml
4. 创建Dao代理对象，StudentDao studentDao = SqlSession.getMapper(StudentDao.class)
5. 获取，List<Student> students = studentDao.selectStudents();

要是用这个dao对象，要使用getMapper()方法。

要使用getMapper()方法，需要以下条件：
1. 获取SqlSession对象，需要使用SqlSessionFactory的openSession()方法。
2. 创建SqlSessionFactory对象。通过读取mybatis主配置文件，就能SqlSessionFactory对象。

需要SqlSessionFactory对象，就能使用Factory获取SqlSession，就可以有dao对象了。

Factory创建需要读取主配置文件

#### 主配置文件

去除掉一些不相关的，这些是必须的。

在spring中会使用独立的连接池来代替mybatis默认自带的，我们把连接池也交给spring来创建，

1. 数据库信息
```xml
<enviroment id = "mydev">
   <transactionManager type="JDBC"/>
   <dataSource type="POOLED">
      <!-- 数据库的驱动类名 -->
      <property name="driver" value="com.mysql.jdbc.Driver"/>
      <!-- 连接数据的url字符串 -->
      <property name="url" value="jdbc:mysql://localhost:3306/springdb"/>
      <!-- 访问数据库的用户名 -->
      <property name="username" value="root"/>
      <!-- 密码 -->
      <property name="password" value="123456"/>
   </dataSource>
</enviroment>
```
2. mapper文件的位置
```xml
<mappers>
    <mapper resource="com/Sample/dao/StudentDao.xml"/>
</mappers>
```

#### spring框架结合mybatis

需要spring创建以下对象
1. 独立的连接池（使用阿里的druid连接池）
2. SqlSessionFactory对象
3. dao对象

需要学习的就是上面三个对象的创建语法。使用xml的`<bean>`标签。
