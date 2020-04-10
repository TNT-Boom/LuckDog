package leetcode.zuochengyun.stringtopic;

public class Parenthesis
{
	public boolean chkParenthesis(String A, int n)
	{
		int num = 0;
		for(int i = 0; i < n; ++i)
		{
			if(A.charAt(i) == '(')
				++num;
			if(A.charAt(i) == ')')
				--num;
			if(num < 0)
				return false;
		}
		if(num != 0)
			return false;
		return true;
	}
}
