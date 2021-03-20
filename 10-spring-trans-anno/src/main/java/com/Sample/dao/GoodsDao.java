package com.Sample.dao;

import com.Sample.domain.Good;

import java.util.List;

public interface GoodsDao {
    int insertGoods(Good good);
    int updateGoods(Good good);
    List<Good> allGoods();
    Good selectGoods(Integer gid);
}
