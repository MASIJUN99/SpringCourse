package com.Sample.service.impl;

import com.Sample.dao.GoodsDao;
import com.Sample.dao.SalesDao;
import com.Sample.domain.Good;
import com.Sample.domain.Sale;
import com.Sample.exception.NotEnoughException;
import com.Sample.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SalesDao salesDao;
    private GoodsDao goodsDao;

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }


    @Override
    public void buy(Integer goodId, Integer nums) {
        // 若将异常抛出放在最后，会发现表sale的id不是连续的，因为当中出现了回滚。
        // 读取商品信息
        Good good = goodsDao.selectGoods(goodId);
        if (good == null){
            // 商品不存在
            throw new NullPointerException("编号为" + goodId + "商品不存在");
        } else if (good.getAmount() < nums) {
            // 商品数量不足
            throw new NotEnoughException("编号为" + goodId + "库存不足");
        }

        // 更新销售信息
        Sale sale = new Sale();
        sale.setGid(goodId);
        sale.setNums(nums);
        salesDao.insertSales(sale);

        // 更新商品信息
        Good buyGood = new Good();
        buyGood.setAmount(nums);
        buyGood.setId(goodId);
        goodsDao.updateGoods(buyGood);

        System.out.println("购买了" + nums + "个" + good.getName());
    }
}
