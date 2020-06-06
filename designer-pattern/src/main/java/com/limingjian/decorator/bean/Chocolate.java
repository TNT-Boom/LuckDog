package com.limingjian.decorator.bean;

/**
 * @author limingjian
 * @date 2020/5/21
 *
 */
public class Chocolate extends Condiment {

    private Beverage beverage;
    private int count;

    public Chocolate(Beverage beverage, int count) {
        super();

        NAME = "Chocolate";
        UNIT_PRICE = 3_00;

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