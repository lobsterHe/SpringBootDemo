package com.example.demo.strategy;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/5/28
 * Time：12:21
 * Des：超级Vip
 * ========================
 */
@PriceRegion(min=20000,max=30000)
public class SuperVip implements CalPrice{
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.8;
    }
}
