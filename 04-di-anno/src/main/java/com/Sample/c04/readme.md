## 注入引用类

使用@Autowired通过byName注入
1. 在属性上方加入@Autowired
2. 在属性上面加入@Qualifier(value="id") 表示创建对象的id
3. 这两个注解无所谓顺序
    

    
