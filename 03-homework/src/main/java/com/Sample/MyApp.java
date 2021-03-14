package com.Sample;

import com.Sample.domain.SysUser;
import com.Sample.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        String config = "/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        UserService userService = (UserService) ac.getBean("userService");

        SysUser user = new SysUser();
        user.setAge(20);
        user.setHabits("骑车");
        user.setName("lisi");
        userService.addUser(user);
    }
}
