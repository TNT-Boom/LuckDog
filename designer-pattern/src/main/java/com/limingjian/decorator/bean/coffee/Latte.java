package com.limingjian.decorator.bean.coffee;
import com.limingjian.decorator.bean.Beverage;

/**
 * 拿铁咖啡
 * @author limingjian
 * @date 2020/5/21
 *
 */
public class Latte extends Beverage {
    public Latte() {
        NAME = "Latte";
        UNIT_PRICE = 5_21;
    }

    @Override
    public String getDesc() {
        return NAME;
    }

    @Override
    public int cost() {
        return UNIT_PRICE;
    }

    @Override
    public String getDetail() {
        return NAME + "    " + getOutputPrice() + "\r\n";
    }
}