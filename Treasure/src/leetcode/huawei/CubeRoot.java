package leetcode.huawei;

import java.util.Scanner;

/*
 * 求解立方根,用牛顿迭代法
 * x(n+1) = xn - f(xn) / f'(xn)
 * 考点：浮点数相等之比较
 * f(x) = x^3 - input
 */
public class CubeRoot
{
	private static double EPS = 0.000001;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			double input = scanner.nextDouble();
			String str = String.format("%.1f", getCubeRoot(input));
			System.out.println(str.trim());
		}
		scanner.close();
	}

	public static double getCubeRoot(double input)
	{
		double x = input;
		double nextX;
		double cubeX = x * x * x;
		while (abs(cubeX - input) > EPS)
		{
			nextX = (2.0 * x + input / (x * x)) / 3;
			x = nextX;
			cubeX = x * x * x;
		}
		return x;
	}

	private static double abs(double input)
	{
		return input > 0 ? input : -input;
	}
}
