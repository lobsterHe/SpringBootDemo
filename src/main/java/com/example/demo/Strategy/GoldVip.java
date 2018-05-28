package com.example.demo.strategy;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/5/28
 * Time：12:23
 * Des：金牌会员
 * ========================
 */
@PriceRegion(min=30000)
public class GoldVip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.7;
    }
}
