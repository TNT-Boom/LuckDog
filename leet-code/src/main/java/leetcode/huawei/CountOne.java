package leetcode.huawei;

import java.util.Scanner;

/*
 * ��int���������ڴ��д洢ʱ1�ĸ���
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
