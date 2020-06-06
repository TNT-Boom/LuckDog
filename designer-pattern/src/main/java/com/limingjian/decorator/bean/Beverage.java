package com.limingjian.decorator.bean;

/**
 * 装饰者模式，所有的饮料均实现此接口，
 * 通过组合模式将不同的饮料组合到一起，从而实现不同口味
 * 防止类爆炸
 * @author limingjian
 * @date 2020/5/21
 *
 */
public abstract class Beverage {
    public String NAME = "Beverage";
    public int UNIT_PRICE = 0;

    /**
     * 获得产品的描述
     * @return
     */
    public abstract String getDesc();

    /**
     * 价格使用最小单位，例如分，仅在显示时转化成易于阅读的格式
     * @return
     */
    public abstract int cost();

    public double getViewCost() {
        double doubleCost = cost();
        return doubleCost / 100;
    }

    /**
     * 获得账单明细输出
     * @return
     */
    public abstract String getDetail();

    public double getOutputPrice() {
        double doublePrice = UNIT_PRICE;
        return doublePrice / 100;
    }
}