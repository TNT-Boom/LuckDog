package leetcode.huawei;

import java.util.Scanner;

import base.BaseAlgorithm;

public class TailMoney implements BaseAlgorithm
{
	public void runDemo()
	{
		
	}

	public static void main(String[] args)
	{
//		Scanner scanner = new Scanner(System.in);
//		while(scanner.hasNext())
//		{
//			
//		}
//		scanner.close();
		int[] input = new int[] {5,10,25,1};
		System.out.println(countWays(input, 4, 15));
	}
	public static int countWays(int[] changes, int n, int x)
	{
		return myCount(changes, n, x);
	}

	static int myCount(int S[], int m, int n)
	{
		int include, exclusive;
		int table[][] = new int[n +1 ][m]; // table[i][j] i元钱，前j种货币，组合数
		for(int k = 0; k < m; k++)
			table[0][k] = 1; // 0原的情况，每种货币只能有一种方法，即0枚
		for(int i = 1; i < n + 1; ++i)
		{
			for(int j = 0; j < m; ++j)
			{
				include = i - S[j] >= 0 ? table[i-S[j]][j] : 0;
				exclusive = j >= 1 ? table[i][j - 1] : 0;
				
				table[i][j] = include + exclusive;
			}
		}
		return table[n][m-1];
	}
}
