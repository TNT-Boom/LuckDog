package leetcode;

import base.BaseAlgorithm;

public class CvteTest implements BaseAlgorithm
{

	public void runDemo()
	{
		System.out.println(isMatch("(0111)|(a11)"));
	}

	private boolean isMatch(String str)
	{
		if(str == null)
			return false;
		if (str.equals("0") || str.equals("1"))
			return true;
		if(!isCouple(str))
		{
			return false;
		}
		String left;
		String right;
		String tempStr;
		if (str.startsWith("("))
		{
			int index = str.indexOf(')');
			if (index == str.length() - 1)
			{
				tempStr = str.substring(1, str.length() - 1);
				if(tempStr.equals(""))
					return isMatch(tempStr);
			}
			else
			{
				left = str.substring(1, index);
				right = str.substring(index + 1);
				if (isMatch(left) && isMatch(right))
					return true;
			}
		}

		if (str.lastIndexOf('*') == str.length() - 1)
		{
			tempStr = str.substring(0, str.length() - 1);
			return isMatch(tempStr);
		}

		if (str.indexOf('|') != -1)
		{
			left = str.substring(0, str.indexOf('|'));
			right = str.substring(str.indexOf('|') + 1);

			if (isMatch(left) && isMatch(right))
				return true;
		}
		
		return isOnly01(str);
	}
	
	private boolean isOnly01(String str)
	{
		char[] array = str.toCharArray();
		for (char c : array)
		{
			if(c != '0' && c != '1')
				return false;
		}
		return true;
	}
	
	private boolean isCouple(String str)
	{
		int left = 0;
		int right = 0;
		char[] array = str.toCharArray();
		for (char c : array)
		{
			if(c == '(')
				++left;
			if(c == ')')
				++right;
		}
		
		return left == right;
	}
}
