package com.Sample.service.impl;

import com.Sample.dao.GoodsDao;
import com.Sample.dao.SalesDao;
import com.Sample.domain.Good;
import com.Sample.domain.Sale;
import com.Sample.exception.NotEnoughException;
import com.Sample.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SalesDao salesDao;
    private GoodsDao goodsDao;

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }


    /**
     * @Transactional:
     * 参数：1. propagation 默认为 Propagation.REQUIRED
     *      2. isolation 默认为 Isolation.DEFAULT
     *      3. readOnly 默认为 false
     *      4. rollbackFor 默认为 运行时异常，即 RuntimeException
     */
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            rollbackFor = {
//                    NullPointerException.class,
//                    NotEnoughException.class,
//            }
//    )
    @Transactional  // 与上面一样，省略。
    @Override
    public void buy(Integer goodId, Integer nums) {
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

        // 读取商品信息
        Good good = goodsDao.selectGoods(goodId);
        if (good == null){
            // 商品不存在
            throw new NullPointerException("编号为" + goodId + "的商品不存在");
        } else if (good.getAmount() < nums) {
            // 商品数量不足
            throw new NotEnoughException("编号为" + goodId + "的商品库存不足");
        }

        System.out.println("购买了" + nums + "个" + good.getName());
    }
}
