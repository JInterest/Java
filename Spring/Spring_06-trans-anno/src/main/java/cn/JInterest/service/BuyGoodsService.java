package cn.JInterest.service;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/29  14:09
 */
public interface BuyGoodsService {
    //购买商品的方法， goodsId：购买商品的编号， nums：购买的数量
    public void buy(Integer goodsId,Integer nums);
}
