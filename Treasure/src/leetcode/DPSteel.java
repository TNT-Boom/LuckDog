package leetcode;

import base.BaseAlgorithm;

//切割钢条
public class DPSteel implements BaseAlgorithm
{
	public void runDemo()
	{
		int[] values = new int[]{1,5,8,9,10,17,17,20,24,30};
		
		System.out.println(getMaxValue(values, 1));
		System.out.println(getMaxValue(values, 2));
		System.out.println(getMaxValue(values, 3));
		System.out.println(getMaxValue(values, 4));
		System.out.println(getMaxValue(values, 5));
		System.out.println(getMaxValue(values, 6));
		System.out.println(getMaxValue(values, 7));
		System.out.println(getMaxValue(values, 8));
		System.out.println(getMaxValue(values, 9));
		System.out.println(getMaxValue(values, 10));
	}
	
	
	// 传统的自上而下递归，遍历了所有情况，另外额外计算了大量重复值
	//rn = max(pi + r(n-i))   1<=i <=n
	private int getMaxValue(int[] values, int totalLen)
	{
		int[] tempResult = new int[totalLen];
		return mem_getMaxValue(values, totalLen, tempResult);
	}
	
	private int mem_getMaxValue(int[] values, int totalLen, int[] tempResult)
	{
		if(totalLen == 0)
			return 0;
		
		if(tempResult[totalLen - 1] > 0)
			return tempResult[totalLen - 1];
		
		int q = Integer.MIN_VALUE;
		for(int i = 1; i <= totalLen; ++i)
		{
			// 当前收益，裁剪i之后的收益
			q = max(q, values[i - 1] + mem_getMaxValue(values, totalLen - i, tempResult));
		}
		tempResult[totalLen - 1] = q;
		return q;
	}
	private int max(int a, int b)
	{
		return a > b ? a : b;
	}
}
