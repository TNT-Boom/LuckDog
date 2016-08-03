package com.limingjian.factory;

import java.util.ArrayList;

public abstract class Pizza
{
	String name;
	String dough;
	String sauce;
	ArrayList<Object> toppings = new ArrayList<>();

	public void prepare()
	{
		System.out.println("Prepare.." + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings...");
		for (Object object : toppings)
		{
			System.out.println("  " + object);
		}
	}

	public void bake()
	{
		System.out.println("Bake for 25 mins...");
	}

	public void cut()
	{
		System.out.println("cutting the pizza into diagonal slices");
	}

	public void box()
	{
		System.out.println("Place pizza in official PizzaStore box");
	}
	
	public String getName()
	{
		return name;
	}
}
