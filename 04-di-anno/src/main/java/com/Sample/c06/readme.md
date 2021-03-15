## *@Resoucrce*

要使用Resource方式注入引用类型，需要先用maven添加javax的依赖项：
```xml
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.1</version>
</dependency>
```

@Resource: 来自jdk中的注解，spring框架提供了对这个注解的功能支持，
可以使用它给引用类型赋值，使用的也是自动注入原理，支持byName byType，
默认是byName

位置： 
1. 在属性定义的上面，无需set方法，推荐
2. 在set方法的上面

当Resource默认byName失败，就会自动进行byType注入