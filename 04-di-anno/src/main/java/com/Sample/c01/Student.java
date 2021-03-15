package com.Sample.c01;


import org.springframework.stereotype.Component;


/**
 * @Component: 创建对象的，等同于<bean>的功能，会使用无参构造的方法构造对象
 *         属性：value就是对象的名称，也是bean的id值
 *             value的值是唯一的，创建的对象在整个spring容器中有且仅有一个
 *         位置：在类的上面
 *
 * 和@Comonent使用方法一样的还有：
 *     1.@Repository（持久层）：放在Dao的实现类上面，表示创建Dao对象，可以访问数据库
 *     2.@Service（业务层）：放在Service的实现类上面，创建Service对象，做业务处理
 *     3.@Controller（控制器）：放在控制器的实现类上面，创建控制器对象，接收用户提交的参数，显示请求处理结果
 * 以上三个注解的适用语法一样。
 * 基本功能及语法都是一样的，但可以用来给项目对象分层，承担不同的角色。
 *
 * 即
 * @Component(value = "myStudent")
 * 等同于
 * <bean id="myStudent" class="com.Sample.c01.Student"/>
 */

// 使用value属性指定对象名称
@Component(value = "myStudent")
// @Component("myStudent")  // 可省略value属性
// @Component()  // 直接省略名称，spring提供默认名称，即为student（首字母小写）

public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("执行无参数构造方法");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
