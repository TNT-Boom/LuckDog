package com.limingjian.decorator.bean.coffee;

import com.limingjian.decorator.bean.Beverage;

/**
 * 美式咖啡
 * @author limingjian
 * @date 2020/5/21
 */
public class Americano extends Beverage {

    public Americano() {
        NAME = "Americano";
        UNIT_PRICE = 10_00;
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