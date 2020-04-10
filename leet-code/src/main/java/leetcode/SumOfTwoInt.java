package leetcode;

import base.BaseAlgorithm;

public class SumOfTwoInt implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		System.out.println(add(100, 2000));
	}
	private int getSum(int a, int b)
	{
		while (a != 0)
		{
			int x = a ^ b;
			a = (a & b) << 1;
			b = x;
		}
		return b;
	}
	
	private int add(int a, int b)
	{
		if(b == 0)
			return a;
		int noCarray = a ^ b;
		int carray = (a & b) << 1;
		return add(noCarray, carray);
	}
}
