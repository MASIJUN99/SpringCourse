package com.Sample.dao;

import com.Sample.domain.Sale;

import java.util.List;

public interface SalesDao {
    int insertSales(Sale sale);
    List<Sale> selectSales();
}
