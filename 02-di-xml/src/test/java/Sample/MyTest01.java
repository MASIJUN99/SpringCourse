package Sample;


import com.Sample.c01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest01 {
    @Test
    public void test_c01(){
        String config = "c01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取Student对象
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("Student对象" + myStudent);
        myStudent.setAge(30);
        System.out.println("Student对象" + myStudent);

        Date myDate = (Date) ac.getBean("myDate");
        System.out.println(myDate);
    }

    @Test
    public void test_c01_2(){
        System.out.println();
    }
}
