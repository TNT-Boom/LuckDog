package com.limingjian.decorator.bean.coffee;
import com.limingjian.decorator.bean.Beverage;

/**
 * 浓缩咖啡
 * @author limingjian
 * @date 2020/5/21
 */
public class Expresso extends Beverage {
    public Expresso() {
        NAME = "Espresso";
        UNIT_PRICE = 9_99;
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