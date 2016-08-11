package leetcode.huawei;

import java.util.Scanner;

// 求最小公倍数
public class LCM
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(lcm(a, b));
		}
		scanner.close();
	}

	private static int lcm(int a, int b)
	{
		return a * b / gcd(a, b);
	}

	public static int gcd(int m, int n)
	{
		while (true)
		{
			if ((m = m % n) == 0)
				return n;
			if ((n = n % m) == 0)
				return m;
		}
	}
}
