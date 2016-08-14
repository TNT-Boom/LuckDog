package leetcode.huawei;

import java.util.Scanner;

public class ReverseString
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			String source = scanner.nextLine();
			System.out.println(reverse(source));
		}
		scanner.close();
	}
	private static String reverse(String source)
	{
		char[] resultArray = new char[source.length()];
		for(int i = 0; i <= source.length() >> 1 ; ++i)
		{
			resultArray[i] = source.charAt(source.length() -1 - i);
			resultArray[source.length() - 1 - i] = source.charAt(i);
		}
		return  new String(resultArray);
	}
	
}
