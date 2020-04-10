package leetcode.tencent;

import java.util.ArrayList;

public class GrayCode
{
	public static void main(String[] args)
	{
		String[] hehe =getGray(2);
	}
	public static String[] getGray(int n) {
      return genCode(n);
    }
	private static String[] genCode(int n)
	{
		if(n <= 0)
			return null;
		if(n == 1)
			return new String[] {"0", "1"};
		String[] preCodes = genCode(n - 1);
		ArrayList<String> results = new ArrayList<>();
		for(int i = 0; i < preCodes.length; i++)
		{
			String result = "0" + preCodes[i];
			results.add(result);
		}
		
		for(int i = preCodes.length - 1; i >= 0 ; i--)
		{
			String result = "1" + preCodes[i];
			results.add(result);
		}
		String[] returnResult = new String[results.size()];
		results.toArray(returnResult);
		return returnResult;
	}
}
