package com.Sample.dao.impl;

import com.Sample.dao.UserDao;
import com.Sample.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository("mysqlDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("插入用户user到mysql数据库");
    }
}
