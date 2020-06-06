package com.limingjian.decorator;

import com.limingjian.decorator.bean.Beverage;
import com.limingjian.decorator.bean.Cream;
import com.limingjian.decorator.bean.Milk;
import com.limingjian.decorator.bean.coffee.Expresso;


/**
 * @author limingjian
 * @date 2020/5/21
 *
 */
public class Main {
    public static void main(String[] args) {
        // 创建一杯带牛奶，奶油的浓缩咖啡
        Beverage expresso = new Expresso();
        Beverage milkCoffe = new Milk(expresso, 5);
        Beverage creamCoffe = new Cream(milkCoffe, 5);
        System.out.println(" orderDeatil \r\n" + creamCoffe.getDetail() + " \r\n Total: " + creamCoffe.getViewCost());
    }
}