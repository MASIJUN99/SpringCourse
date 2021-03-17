package com.Sample.dao.impl;

import com.Sample.dao.UserDao;
import com.Sample.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository("oracleDao")
public class OracleDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("插入用户user到Oracle数据库");
    }
}
