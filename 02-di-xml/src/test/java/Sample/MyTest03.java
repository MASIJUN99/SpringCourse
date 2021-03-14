package Sample;

import com.Sample.c03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void test01(){
        String config = "c03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // using name to init
        Student student = (Student) ac.getBean("myStudent");
        System.out.println(student);
        // using index to init
        Student student1 = (Student) ac.getBean("myStudent1");
        System.out.println(student1);
        // using no index to init
        Student student2 = (Student) ac.getBean("myStudent2");
        System.out.println(student2);

    }
}
