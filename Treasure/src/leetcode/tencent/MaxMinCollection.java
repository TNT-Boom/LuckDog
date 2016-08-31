package leetcode.tencent;

import java.util.*;

/*
 * ����ÿ�����ݣ��������������һ������ʾ����С�Ķ������ڶ�������ʾ�����Ķ�����
 */
public class MaxMinCollection
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			int num = scanner.nextInt();
			int[] source = new int[num];
			for (int i = 0; i < num; i++)
				source[i] = scanner.nextInt();
			printResult(source, num);
			getResult(source, num); //��ʾ��ʱ
		}
		scanner.close();
	}

	private static void getResult(int[] source, int n)
	{
		Arrays.sort(source); // ��������Сֵһ�����������ڵ�������֮�䡣
		
		
		if(source[0] == source[n - 1]) // �����С��ͬ
		{
			int result = n * (n - 1) / 2;
			System.out.println(result + " " + result);
			return;
		}
		int min = Integer.MAX_VALUE;
		
		for(int i =1; i < n; i++)
		{
			if(min > source[i] - source[i-1])
			{
				min = source[i] - source[i - 1];
			}
		}
		
		int minCount = 0;
		if(min == 0) // �ҳ�������ͬ�ĸ�����Ȼ������������
		{
			int sameCount = 1;
			int preNum = source[0];
			for(int i = 1; i < n; i++)
			{
				if(source[i] == preNum)
					sameCount++;
				else
				{
					if(sameCount >= 2)
					{
						int temp = 1;
						temp = sameCount * (sameCount - 1) / 2;
						minCount += temp;
					}
					sameCount = 1;
				}
				preNum = source[i];
			}
			if(sameCount >= 2)
			{
				int temp = 1;
				temp = sameCount * (sameCount - 1) / 2;
				minCount += temp;
			}
		}
		else
		{
			for(int i = 1; i < n; i++)
			{
				if(source[i] - source[i -1] == min)
					minCount++;
			}
		}
		
		// getMax   ���ֵ ��Сֵ���������
		int minNumCount = 1;
		int maxNumCount = 1;
		int i = 1;
		while(i < n && source[i] == source[i -1])
		{
			++minNumCount;
			++i;
		}
		i = n - 2;
		while(i >=0 && source[i] == source[i + 1])
		{
			++maxNumCount;
			--i;
		}
		int maxCount = minNumCount * maxNumCount;
		
		System.out.println(minCount + " " + maxCount);
		
	}
	// ʱ�临�Ӷȹ��󡣡����������� O(nlgn)
	private static void printResult(int[] source, int n)
	{
		if(source == null)
			return;
		if(n <= 1)
			System.out.println("0 0");
		
		int[] dpMin = new int[n];
		int[] dpMax = new int[n];
		dpMin[0] = 0;
		dpMin[1] = 1;
		
		dpMax[0] = 0;
		dpMax[1] = 1;
		
		int totalMin = abs(source[1] - source[0]);
		int totalMax = abs(source[1] - source[0]);
		for (int i = 2; i < n; i++)
		{
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int minCount = 0;
			int maxCount = 0;
			for (int k = i - 1; k >= 0; k--)
			{
				int gap = abs(source[i] - source[k]);
				if (gap < min)
				{
					minCount = 1;
					min = gap;
				}
				if(gap == min)
					minCount++;
				
				
				if(gap> max)
				{
					maxCount = 1;
					max = gap;
				}
				
				if(gap == max)
					maxCount++;
			}
			if(min < totalMin)
			{
				dpMin[i] = minCount;
				totalMin = min;
			}
			else if(min == totalMin)
			{
				dpMin[i] = dpMin[i-1] +minCount;
			}
			else
			{
				dpMin[i] = dpMin[i - 1];
			}
			
			if(max > totalMax)
			{
				dpMax[i] = maxCount;
				totalMax = max;
			}
			else if(max == totalMax)
			{
				dpMax[i] = dpMax[i - 1] + maxCount;
			}
			else
			{
				dpMax[i] = dpMax[i - 1];
			}
		}
		System.out.println(dpMin[n -1] + " " + dpMax[n -1]);
	}

	private static int abs(int a)
	{
		return a > 0 ? a : -a;
	}
}
