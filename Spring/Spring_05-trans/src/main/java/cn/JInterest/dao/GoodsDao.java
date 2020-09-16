package cn.JInterest.dao;

import cn.JInterest.domain.Goods;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/29  13:58
 */

public interface GoodsDao {
    //更新库存
    //goods表示本次用户购买的商品信息， id， 购买数量
    int updateGoods(Goods goods);

    //查询商品的信息
    Goods selectGoods(Integer goodsId);
}
