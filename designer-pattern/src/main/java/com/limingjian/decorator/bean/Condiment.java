package com.limingjian.decorator.bean;

/**
 * @author limingjian
 * @date 2020/5/21
 *
 */
public class Condiment extends Beverage {
    @Override
    public String getDesc(){
        return "default condiment description";
    }

    @Override
    public int cost() {
        return UNIT_PRICE;
    }

    @Override
    public String getDetail() {
        return "default condiment description";
    }


}