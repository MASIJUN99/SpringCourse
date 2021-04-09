## 08-Spring-mybatis

spring和mybatis集成开发

### 步骤

1. 新建maven项目
2. 加入spring依赖
   
    1. spring依赖
    2. mybatis依赖
    3. mysql驱动
    4. spring事务依赖
    5. mybatis和spring集成依赖：mybatis官方提供的依赖
        
        用来在spring项目中创建mybatis的SqlSessionFactory，dao对象
    
3. 加入mybatis代码，创建实体类。
4. 创建dao接口和mapper文件
5. 创建mybatis主配置文件
6. 创建Service接口，属性是dao
7. 创建spring配置文件：声明mybatis对象交给spring创建

    1. 数据源（DataSource）
    2. SqlSessionFactory对象
    3. dao对象
    4. 声明自定义Service
    
8. 创建测试类获取Service对象，通过Service调用dao完成访问。

### 文件结构
```txt
└─src
   ├─main
   │  ├─java
   │  │  └─com
   │  │      └─Sample
   │  │          ├─dao
   │  │          ├─domain
   │  │          └─service
   │  │              └─impl
   │  └─resources
   └─test
       └─java
           └─Sample
```

