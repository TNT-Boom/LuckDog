package leetcode;

import base.BaseAlgorithm;

public class BubbleSort implements BaseAlgorithm
{
	public void runDemo()
	{
		int[] source = new int[]{1,3,4,2,5,2,1};
		bubbleSort(source);
		for (int i : source)
		{
			System.out.println(i);
		}
	}
	public void bubbleSort(int[] source)
	{
		for(int i = 0; i < source.length - 1; i++)
		{
			for(int j = i + 1; j < source.length; j++)
			{
				if(source[i] < source[j])
				{
					int temp = source[i];
					source[i] = source[j];
					source[j] = temp;
				}
			}
		}
	}
}
