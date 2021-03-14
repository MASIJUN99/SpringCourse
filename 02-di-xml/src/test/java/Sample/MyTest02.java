package Sample;

import com.Sample.c02.School;
import com.Sample.c02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test_c01(){
        // normal set
        Student student = new Student();
        student.setAge(20);
        student.setName("李四lisi");

        School school = new School();
        school.setAddress("广东省深圳市龙岗区");
        school.setName("平安里中学");

        student.setSchool(school);

        System.out.println(student);
    }

    @Test
    public void test_c02_2(){
        // using spring config.xml
        String config = "/c02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("myStudent");
        System.out.println(student);
    }
}
