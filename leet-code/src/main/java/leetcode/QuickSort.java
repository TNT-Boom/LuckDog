package leetcode;

import base.BaseAlgorithm;

public class QuickSort implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		int[] source = new int[] {1, 4, 3, 2, 5, 6, 7, 5, 3, 2};
		quickSort(1, source.length - 1, source);

		System.out.println("quick sort");
		for (int i : source)
		{
			System.out.println(i);
		}
	}

	public void quickSort(int low, int heigh, int[] source)
	{
		if (source == null)
			return;
		if (low < heigh)
		{
			int patitionIndex = partition(low, heigh, source);
			quickSort(low, patitionIndex - 1, source);
			quickSort(patitionIndex + 1, heigh, source);
		}
	}

	private int partition(int low, int heigh, int[] source)
	{
		int temp = source[low];
		while(low < heigh)
		{
			while (low < heigh && source[heigh] >= temp)
			{
				heigh--;
			}
			if (low < heigh) // finded
			{
				source[low++] = source[heigh];
			}

			while (low < heigh && source[low] <= temp)
			{
				low++;
			}
			if (low < heigh)
			{
				source[heigh--] = source[low];
			}
		}
		source[low] = temp;
		return low;
	}
}
