## 10-Spring-trans

### 实现步骤

1. 新建maven项目
2. 加入spring依赖
3. 创建实体类
    
    1. Goods
    2. Sale
    
4. 创建dao接口和mapper文件
    
    1. SaleDao 和 GoodsDao
    2. SaleDao.xml 和 GoodsDao.xml
    
5. 创建mybatis.xml主配置文件
6. 创建Service接口和实现类，属性是SaleDao和GoodsDao
7. 创建spring配置文件

### 控制事务

当在进行一部分sql语句后发生了异常，后面的sql进行不了，那么前期的sql操作就需要回滚。

通过增加事务来实现回归。

AOP + 功能 + 事务的模式来解决，通过AOP方法增加事务。

### 注解

1. 声明事务管理器对象
```xml
<bean id="xx" class="DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>
```
2. 开启事务注解驱动。

   spring会使用aop机制，去创建注解所在的类的代理对象，给方法加入事务功能。

   spring在业务方法执行之前，先开启事务，在业务方法之后提交或回滚事务，使用的是AOP环绕通知方法。




