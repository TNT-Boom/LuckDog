package leetcode;

import base.BaseAlgorithm;

public class SubOfTwoInt implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		System.out.println(getSum(100, 2000));
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
}
