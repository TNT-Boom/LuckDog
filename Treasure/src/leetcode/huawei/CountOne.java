package leetcode.huawei;

import java.util.Scanner;

/*
 * 求int型数据在内存中存储时1的个数
 */
public class CountOne
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			int x = scanner.nextInt();
			System.out.println(countOne(x));
		}
	}
	
	private static int countOne(int input)
	{
		int count = 0;
		while(input != 0)
		{
			input = input & (input - 1);
			count++;
		}
		return count;
	}
}
