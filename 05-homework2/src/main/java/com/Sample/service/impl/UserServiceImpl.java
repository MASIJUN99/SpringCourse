package com.Sample.service.impl;

import com.Sample.dao.UserDao;
import com.Sample.domain.SysUser;
import com.Sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "mysqlDao")
    private UserDao dao = null;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        dao.insertUser(user);
    }
}
