package leetcode.netease;

import java.util.Scanner;

public class Main1
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();

			System.out.println(getResult(a, b, c));
		}
	}

	private static int getResult(int a, int b, int c)
	{
		if(a <= c && b >= c)
			return c;
		int min = Integer.MAX_VALUE;
		int index = Integer.MIN_VALUE;
		int standard = getSum(c);
		
		for (int i = a; i < b; i++)
		{
			int curr =abs( getSum(i) - standard);
			if (curr < min)
			{
				min = curr;
				index = i;
			}
		}
		return index;
	}

	private static int abs(int n)
	{
		return n > 0 ? n : -n;
	}
	private static int getSum(int n)
	{
		int sum = 0;
		char[] chars = (n + "").toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			sum += chars[i] - '0';
		}
		return sum;
	}
}
