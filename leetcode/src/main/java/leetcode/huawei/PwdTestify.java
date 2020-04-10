package leetcode.huawei;

import java.util.Scanner;

/*
 * 码验证合格程序
 */
public class PwdTestify
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			String pwd = scanner.nextLine();
			System.out.println(testify(pwd)? "OK" : "NG");
		}
		scanner.close();
	}
	
	private static boolean testify(String pwd)
	{
		int lowerLetter = 0;
		int upperLetter = 0;
		int num = 0;
		int others = 0;
		if(pwd == null || pwd.length() <= 8)
		{
			return false;
		}
		
		for(int i = 0; i < pwd.length(); ++i)
		{
			if(i < pwd.length() - 2)
			{
				String subStr = pwd.substring(i, i + 3); // 长度为3以上的重复， 则长度为3的必然重复
				if(pwd.substring(i +1 ).contains(subStr)) //其后的字串是否包含
					return false;
			}
			char currChar = pwd.charAt(i);
			if(currChar >= 'a' && currChar <= 'z')
			{
				lowerLetter = 1;
			}
			else if(currChar >= 'A' && currChar <= 'Z')
			{
				upperLetter = 1;
			}
			else if(currChar >= '0' && currChar <= '9')
			{
				num = 1;
			}
			else
			{
				others = 1;
			}
		}
		if(lowerLetter + upperLetter + num + others < 3)
			return false;
		return true;
	}
}
