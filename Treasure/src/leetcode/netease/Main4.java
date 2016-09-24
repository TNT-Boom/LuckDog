package leetcode.netease;

import java.util.Scanner;

public class Main4
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		while (in.hasNext())
		{
			int n = in.nextInt();
			System.out.println(getResult(n));
		}
	}

	public static int getResult(int n)
	{
		int standard = countOne(n);
		int currCountOne = -1;
		while (currCountOne != standard)
		{
			currCountOne = countOne(++n);
		}
		return n;
	}

	public static int countOne(int n)
	{
		int count = 0;
		while (n > 0)
		{
			count++;
			n = n & (n-1);
		}
		return count;
	}
}

