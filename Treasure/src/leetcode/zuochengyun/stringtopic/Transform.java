package leetcode.zuochengyun.stringtopic;

import java.util.HashMap;
import java.util.Map;

public class Transform
{
	public static void main(String[] args)
	{
		System.out.println(chkTransform("GE", 2, "GE", 2));
	}
	public static boolean chkTransform(String A, int lena, String B, int lenb)
	{
		if(lena != lenb)
			return false;
		if(A == null && B != null)
			return false;
		if(A != null && B == null)
			return false;
		if(A==null && B == null)
			return true;
		
		Map<Character, Integer> aMap = new HashMap<>();
		Map<Character, Integer> bMap = new HashMap<>();
		for(int i = 0; i < lena; ++i)
		{
			int count = 0;
			if(aMap.containsKey(A.charAt(i)))
				count = aMap.get(A.charAt(i)) + 1;
			aMap.put(A.charAt(i), count);
		}
		
		for(int i = 0; i < lenb; ++i)
		{
			int count = 0;
			if(bMap.containsKey(B.charAt(i)))
				count = bMap.get(B.charAt(i)) + 1;
			bMap.put(B.charAt(i), count);
		}
		
		if(aMap.size() != bMap.size())
			return false;

		for (Map.Entry<Character, Integer> aEntry : aMap.entrySet())
		{
			if(!bMap.containsKey(aEntry.getKey()))
				return false;
			if(bMap.get(aEntry.getKey()) != aEntry.getValue())
				return false;
		}
		return true;
	}
}
