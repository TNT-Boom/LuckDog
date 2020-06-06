package com.limingjian.decorator.bean;

/**
 * 鲜奶
 * @author limingjian
 * @date 2020/5/21
 *
 */
public class Milk extends Condiment {

    private Beverage beverage;
    private int count;

    public Milk(Beverage beverage, int count) {
        super();

        NAME = "Milk";
        UNIT_PRICE = 1_00;

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