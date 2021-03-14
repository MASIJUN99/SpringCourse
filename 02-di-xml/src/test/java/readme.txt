
junit: 单元测试，一个工具类，做很多测试方法用的

单元：指的是方法，一个类中有很多方法，一个方法被称为单元

使用单元测试：

1.加入junit依赖
    在pom.xml文件<dependencies>标签内添加
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13</version>
        <scope>test</scope>
    </dependency>

2.创建测试作用类：叫做测试类
    必须在以下目录中：
    src/test/java

3.创建测试方法
    1）public方法
    2）没有返回值，void类型
    3）方法名称自定义，一般用test作为前缀
    4）方法没有输入参数
    5）方法上面要加上@Test标识符，这样的方法是可以单独执行而不需要main方法



