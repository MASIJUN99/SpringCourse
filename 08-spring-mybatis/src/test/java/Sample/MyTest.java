package Sample;

import com.Sample.dao.StudentDao;
import com.Sample.domain.Student;
import com.Sample.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void testSpring() {
        // 检验是否成功创建对象
        String config = "/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        String names[] = ac.getBeanDefinitionNames();
        for(String name : names){
            System.out.println("容器中对象名称：" + name + " | " + ac.getBean(name));
        }
    }


    @Test
    public void testDao() {
        String config = "/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");

        // first insert by spring!!!
        Student student = new Student();
        student.setId(1015);
        student.setName("msj");
        student.setEmail("785493116@QQ.com");
        student.setAge(24);
        int nums = studentDao.insertStudent(student);
        System.out.println("num: " + nums);
    }

    @Test
    public void testServiceAdd() {
        String config = "/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        StudentService studentService = (StudentService) ac.getBean("studentService");

        Student student = new Student();
        student.setId(1016);
        student.setName("xjy");
        student.setEmail("");
        student.setAge(23);
        int nums = studentService.addStudent(student);
        // spring和mybatis整合时，事务是自动提交的，无需执行SqlSession.commit()
        System.out.println("num: " + nums);
    }

    @Test
    public void testServiceSelect() {
        String config = "/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        StudentService studentService = (StudentService) ac.getBean("studentService");

        List<Student> students = studentService.queryStudent();
        // spring和mybatis整合时，事务是自动提交的，无需执行SqlSession.commit()
        for(Student student: students){
            System.out.println("学生：" + student);
        }
    }
}
