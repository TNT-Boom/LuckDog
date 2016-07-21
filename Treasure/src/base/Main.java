package base;

import java.util.HashMap;
import java.util.Map;

public class Main
{

	public static void main(String args[])
	{	
		Map<Integer, String> algrithmMap = new HashMap<Integer, String>()
		{
			/**
			 * serialVersionUID
			 */
			private static final long serialVersionUID = 1L;

			{
				put(1, "leetcode.DoubleMatrix");
				put(2, "leetcode.Trie");
				put(3, "leetcode.SuperPow");
				put(4, "leetcode.GuessNum");
				put(5, "leetcode.ReverseVowelsString");
				put(6, "leetcode.PostordertTraversal");
				put(7, "leetcode.FindKPairsWithSmallestSums");
				put(8, "leetcode.SubOfTwoInt");
				put(9, "leetcode.AddDigits");
				put(10, "leetcode.NimGame");
				put(11, "leetcode.TwoSum");
				put(12, "leetcode.AddTwoNumbers");
			}
		};

		try
		{
			int algrithmIndex = 12;
			Class<?> algrithm = Class.forName(algrithmMap.get(algrithmIndex));
			BaseAlgorithm baseAlgorithm = (BaseAlgorithm)algrithm.newInstance();
			baseAlgorithm.runDemo();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}

	}
}