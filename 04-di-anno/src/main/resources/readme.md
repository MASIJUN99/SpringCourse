## spring配置文件中文件扫描器的三种添加方式

这个内容有些超出Java课程范围，这个应该是标签语言的特性

1. 正常添加

    `<context:component-scan base-package="parent.package"/>`
   
2. 多个包间 `,` 或者 `;`隔开
   
    `<context:component-scan base-package="package1,package2"/>`
   
3. 直接导入父包（不推荐）

   `<context:component-scan base-package="parents"/>`

## 准备文件 - c08

后缀为`.properties`的文件

在spring配置文件applicationContext.xml中添加标签，语法如下

