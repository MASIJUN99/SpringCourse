package com.Sample.service.impl;

import com.Sample.dao.UserDao;
import com.Sample.domain.SysUser;
import com.Sample.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = null;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        dao.insertUser(user);
    }
}
