package Sample;

import com.Sample.dao.StudentDao;
import com.Sample.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {

        // 检验是否成功创建对象
        String config = "/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        String names[] = ac.getBeanDefinitionNames();
        for(String name : names){
            System.out.println("容器中对象名称：" + name + " | " + ac.getBean(name));
        }

    }
    @Test
    public void test02() {
        String config = "/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");

        // first insert by spring!!!
        Student student = new Student();
        student.setId(1014);
        student.setName("傻子2");
        student.setEmail("shazi2@QQ.com");
        student.setAge(19);
        int nums = studentDao.insertStudent(student);
        System.out.println("num: " + nums);

    }
}
