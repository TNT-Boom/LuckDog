package com.limingjian.factory;

public class PizzaTestDrive implements BaseEnter
{
	public void runDemo()
	{
		PizzaStore nyPizzaStore = new NYStylePizzaStore();
		
		Pizza pizza = nyPizzaStore.orderPizza("cheese");
	}
}
