package leetcode.huawei;

import java.util.Scanner;

/*
 * ¼ÆËã×Ö·û¸öÊý
 */
public class CountChar
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			String source= scanner.nextLine().toLowerCase();
			String finded = scanner.nextLine().toLowerCase();
			findChar(source, finded);
		}
	}
	private static void findChar(String source, String finded)
	{
		int count = 0;
		for(int i = 0; i < source.length(); i++)
		{
			
			if(source.charAt(i) == finded.charAt(0))
				count++;
		}
		System.out.println(count);
	}
}
