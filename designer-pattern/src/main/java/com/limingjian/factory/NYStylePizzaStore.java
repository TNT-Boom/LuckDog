package com.limingjian.factory;

public class NYStylePizzaStore extends PizzaStore
{
	@Override
	public Pizza createPizza(String type)
	{
		Pizza pizza = null;
		switch (type)
		{
			case "cheese":
				pizza = new CheesePizza();
				break;
			case "pepperoni":
				pizza = new PepperoniPizza();
				break;
			default:
				break;
		}
		return pizza;
	}
}
