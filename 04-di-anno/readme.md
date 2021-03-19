# di注入（注解）
目前项目以注解为主，配置文件为辅

一个大原则就是：常改动的用配置文件，不常改动的用注解。

## 基于注解的di
使用注解的步骤
1. 加入maven的依赖spring-context，在加入此依赖的同时，也就加入了
   spring-aop的依赖。
2. 在类中添加spring注解（多个不同功能的注释）
3. 在spring的配置文件中，加入组件扫描器标签，说明注解在你的项目中的
   位置
   
> 需要学习的注解：
> 1. `@component` - c01
> 2. `@Respotory` - c01
> 3. `@Service` - c01
> 4. `@Controller` - c01
> 5. `@Value` - c02
> 6. `@Autowired` - c03 c04 c05
> 7. `@Resource` - c06 c07

## 项目04-di-anno
注解实现步骤：
1. 加入依赖
   
2. 创建类，在类中加入注解
   
3. 创建spring配置文件，
   声明组件扫描器的标签，指明注解在你的项目中的位置
   
4. 使用注解创建对象，创建容器ApplicationContext

### *@Component*

1. 在pom.xml文件中加入spring-context依赖。

2. 在对象类上添加注解，添加方法有三种：
   
   1. `@Component(value = "class_name")`
      
      创建名为class_name的实例
   
   2. `@Component("class_name")`
      
      创建名为class_name的实例
   
   3. `@Component()`
   
      创建默认名的实例，默认名为类的首字母小写。
   
3. 添加spring的配置文件applicationContext.xml
   
   添加`<context:component-scan base-package="packaged"/>`

   会自动在包内寻找注解创建对象。

4. 有另外三个和@Component用法一样
   
   1. `@Repository`（创建在持久层上）：放在Dao的实现类上面，表示创建Dao对象，可以访问数据库
   
   2. `@Service`（创建在业务层上）：放在Service的实现类上面，创建Service对象，做业务处理
   
   3. `@Controller`（创建在控制器上）：放在控制器的实现类上面，创建控制器对象，接收用户提交的参数，显示请求处理结果
   
5. 注意，以上四种注解注入的方式基本功能与用法一模一样，作用就是可以用不同的标签区分程序不同的子块

### *@Value*

直接在属性上使用，或者在set方法上使用

直接赋值。

### *@Autowired*引用类型注入

`@Autowired`: spring框架提供的注解，实现引用类型的注解

spring中通过注解给引用类型赋值，使用的是自动注入原理，支持byName， byType

默认是byType自动注入

**位置**：
1. 在属性定义的上面，无需set方法，推荐
2. 在set方法上面

**参数**：
1. required 是一个boolean类型参数，默认是true 
   
   当期参数为False时，引用类型如果赋值失败，程序正常执行，引用类型为Null
   
2. 一般required为true

#### *byName*

1. 在属性上加入@Autowired注解
2. 在属性上加入@Qualifier(value = "id")注解

其中id可以用注解在类上进行定义，也可以使用bean进行定义

### *@Resource*引用类型注入

默认为byName，若byName失败，就自动使用byType

若使用byName添加name属性

### 准备文件

即${}语法。

详见c08。
