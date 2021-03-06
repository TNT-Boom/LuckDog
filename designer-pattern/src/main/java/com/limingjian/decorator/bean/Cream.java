package com.limingjian.decorator.bean;

/**
 * 奶油
 * @author limingjian
 * @date 2020/5/21
 *
 */
public class Cream extends Condiment {

    private Beverage beverage;
    private int count;

    public Cream(Beverage beverage, int count) {
        super();

        NAME = "Cream";
        UNIT_PRICE = 1_50;

        this.beverage = beverage;
        this.count = count;
    }

    @Override
    public String getDesc() {
        return NAME;
    }

    @Override
    public int cost() {
        return UNIT_PRICE * count + beverage.cost();
    }

    @Override
    public String getDetail() {
        return String.format("%s    %s    %s * %d\r\n", beverage.getDetail(), NAME, getOutputPrice(), count);
    }
}