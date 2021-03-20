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

## Spring事务处理

### 先回答几个问题

1. Q1：什么是事务

   A1：

   <font color=white>事务指一组sql语句的集合，集合中有多条sql语句。

   我们希望集合中的sql语句都是执行的，或者都是不执行的。

   其实就是sql语句作为一个整体来执行。</font>

2. Q2：在什么时候用事务

   A2：

   <font color=white>当我的操作涉及到多个表或者是多个sql语句的操作时。

   需要保证这些语句都执行才能完成功能，或者都不执行，就可以用事务。

   在Java代码中写程序、控制事务，此时这个sql语句放在dao中，在Service使用这个事务。</font>

3. 使用jdbc访问数据库和mybatis访问数据库怎么处理事务

   A3：

   <font color=white>jdbc访问数据库，处理事务是

    Connection conn;

   conn.commit();

   conn.rollback();

   若用mybatis访问数据库，处理事务是

    SqlSession.commit();

    SqlSession.rollback();

   若用hibernate访问数据库，处理事务是

   Session.commit();

   Session.rollback();</font>

4. Q4：上述问题事务处理方式有什么不足

   A4：

   <font color=white>1. 不同的数据库，访问技术、处理方法不同，需要学会多个访问方法。</font>

   <font color=white>2. 需要掌握多种数据库处理事务的处理逻辑。</font>

   <font color=white>3. 需要张悟不同数据库处理事务的多种方法。</font>

   <font color=white>总结，不同数据库的访问技术不同，有着不同的个处理逻辑和技术。</font>

5. Q5：怎么解决不足

   A5：

   <font color=white>Spring提供一种处理事务的统一模型，能使用统一的步骤来完成多种不同的数据库的访问方法。</font>

6. 处理事务需要什么信息，怎么做，做什么

   A6：

   <font color=white>Spring处理事物的模型，使用步骤都是固定的。</font>

   <font color=white>1. 事务内部提交、回滚都是用的spring事务管理器，代替commit和rollback。</font>

   <font color=white>2. 你的业务方法是什么类型，需要声明你的事务类型，有五个隔离级别

    隔离级别以ISOLATION_开头，形如ISOLATION_xxx</font>

   <font color=white>i. DEFAULT：采用DB默认隔离级别，MySql使用READ，Oracle使用CoMMITTED。</font>

   <font color=white>ii. READ_UNCOMMITTED：读未提交。未解决任何并发问题。</font>

   <font color=white>iii. READ_COMMITTED：读已提交。解决脏读，存在不可重复读与幻读。</font>

   <font color=white>iv. REPEATABLE_READ：可重复读。解决脏读、不可重复读，存在幻读。</font>

   <font color=white>v. SERIALIZABLE：串行化，不存在并发问题。</font>

   <font color=white>3. 事务超时时间，超过时间就回滚事务。</font>

   <font color=white>4. 事务的传播行为，控制业务方法是不是有事务的，是什么样的事务

    传播行为一共有7个，表示业务调用时，事务在方法之间是如何使用的。</font>

   <font color=white>传播行为以PROPAGATION_开头，形如PROPAGATION_xxx</font>

   <font color=white>5. spring提交事务、回滚事务的时机</font>

   <font color=white>i. 当你的业务方法执行成功，没有异常抛出，自动执行事务管理器commit</font>

   <font color=white>ii. 当你的业务方法运行期间有运行时异常抛出或ERROR，自动执行事务管理器rollback</font>

   <font color=white>iii. 当你的业务方法抛出非运行时异常，主要是受查异常，提交事务</font>

总结：
1. 管办事务的是事务管理器
2. spring的事务是一个统一的模型

    1. 指定要使用的事务管理器的实现类，使用`<bean>`
    2. 指定哪些类和哪些方法需要加入事务功能
    3. 指定方法的隔离级别、传播行为和超时

### 买卖商品例子

详见项目09

#### AOP增加事务

1. [注解方案](#@Transactional)：适合中小项目使用。

    spring框架自己用AOP实现业务方法增加事务的功能，使用`@Transactional`注解增加事务。

    `@Transactional`是spring框架的注解，放在public方法之上；

    可以给注解的属性赋值，表示隔离级别、传播行为、异常信息等。

2. [aspectJ框架](#aspectJ框架)：适合大型项目

    大型项目很多类、方法，需要配置大量事务时，使用aspectJ框架的功能，在spring配置文件中，声明类、方法需要的事务。

    这种方式业务方和事务配置是完全分离的。


#### @Transactional

属性：
1. `propagation` 用于设置事务传播属性。该属性类型为Propagation枚举，默认值为Propagation.REQUIRED
2. `isolation` 用于设置事务的隔离级别。该属性类型为Isolation枚举，默认值为Isolation.DEFAULT
3. `readOnly` 用于设置该方法对数据库的操作是否是只读的。该属性类型为boolean，默认值为false
4. `timeout` 用于设置本操作与数据库连接的超时时限。单位为秒，该属性类型为int，默认值为-1，即没有时限
5. `rollbackFor` 用于指定需要回滚的异常类。该属性类型为Class[]，默认值为空数组。当然，若只有一个异常类时，可以不用数组类型
6. `rollbackForClassName` 用于指定需要回滚的异常类类名。该属性类型为String[]，默认值为空数组。当然，若只有一个异常类时，可以不用数组类型
7. `noRollbackFor` 用于指定不需要回滚的异常类。该属性类型为Class[]，默认值为空数组。当然，若只有一个异常类时，可以不用数组类型
8. `noRollbackForClassName` 用于指定不需要回滚的异常类。该属性类型为String[]，默认值为空数组。当然，若只有一个异常类时，可以不用数组类型

使用步骤：
1. 声明事务管理器对象
```xml
<bean id="xx" class="DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>
```
2. 开启事务注解驱动。

    spring会使用aop机制，去创建注解所在的类的代理对象，给方法加入事务功能。

    spring在业务方法执行之前，先开启事务，在业务方法之后提交或回滚事务，使用的是AOP环绕通知方法。

#### aspectJ框架

实现步骤（均是在xml文件中完成）：
1. 加入aspectJ依赖
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>5.3.4</version>
</dependency>
```
2. 声明事务管理器对象，即DataSourceTransactionManager
```xml
<bean id="xx" class="DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>
```
3. 声明方法需要的事务类型、事务属性（隔离级别、传播行为、超时...）

4. 配置aop，指定哪些哪类需要创建代理。

