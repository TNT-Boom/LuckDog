package leetcode.jingdong;

import java.util.Scanner;

public class BallsFreeDown
{
	public static void main(String[] args)
	{
		System.out.println(calcDistance(2,2,2,4));
	}
	public static int calcDistance(int A, int B, int C, int D)
	{

		return getResult(A) + getResult(B) + getResult(C) + getResult(D);

	}

	private static int getResult(int n)
	{
		if(n == 1)
			return 1;
		return n + n / 2+ getResult(n / 2);
	}

}
