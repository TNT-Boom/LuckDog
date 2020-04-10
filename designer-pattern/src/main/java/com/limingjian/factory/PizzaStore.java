package com.limingjian.factory;

public abstract class PizzaStore
{
	
	public Pizza orderPizza(String type)
	{
		Pizza pizza = null;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	// 工厂方法
	public abstract Pizza createPizza(String type);
}
