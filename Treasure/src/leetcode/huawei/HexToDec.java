package leetcode.huawei;

import java.util.Scanner;

/*
 * 进制转换
 */
public class HexToDec
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			String hexStr = scanner.nextLine();
			hexStr = hexStr.substring(2);
			System.out.println(Integer.parseInt(hexStr, 16));
		}
		scanner.close();
	}
}
