# di注入




## 基于注解的di
使用注解的步骤
1. 加入maven的依赖spring-context，在加入此依赖的同时，也就加入了
   spring-aop的依赖。
2. 在类中添加spring注解（多个不同功能的注释）
3. 在spring的配置文件中，加入组件扫描器标签，说明注解在你的项目中的
   位置
   
> 需要学习的注解：
> 1. @component
> 2. @Respotory
> 3. @Service
> 4. @Controller
> 5. @Value
> 6. @Autowired
> 7. @Resource