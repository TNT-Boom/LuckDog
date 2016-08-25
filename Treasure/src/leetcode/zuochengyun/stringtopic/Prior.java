package leetcode.zuochengyun.stringtopic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Prior
{
	public String findSmallest(String[] strs, int n)
	{
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
		{
			result.add(strs[i]);
		}
		Collections.sort(result, new  Comparator<String>()
		{
			@Override
			public int compare(String o1, String o2)
			{
				return ((o1 + o2).compareTo(o2 + o1));
			}
		});
		
		StringBuilder builder = new StringBuilder();
		for (String string : result)
		{
			builder.append(string);
		}
		return builder.toString();
	}
}
