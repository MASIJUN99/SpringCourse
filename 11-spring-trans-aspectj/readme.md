## 11-Spring-trans-aspectj

### 实现步骤

1. 新建maven项目
2. 加入spring依赖（包含aspectJ）
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

### 事务属性

语法如下
```xml
 <tx:advice id="myAdvice" transaction-manager="transactionManager">
     <tx:attributes>
         <tx:method
                 name="buy"
                 propagation="REQUIRED"
                 isolation="DEFAULT"
                 rollback-for="java.lang.NullPointerException,
                               com.Sample.exception.NotEnoughException"
         />
     </tx:attributes>
 </tx:advice>
```

可在name中使用通配符，通配符配置优先级低。

### 配置AOP

配置AOP的目的是告诉事务管理器添加事务时是给哪些类。即，哪些类要应用事务。