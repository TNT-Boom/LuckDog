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
			}
		};

		try
		{
			int algrithmIndex = 6;
			Class algrithm = Class.forName(algrithmMap.get(algrithmIndex));
			BaseAlgorithm baseAlgorithm = (BaseAlgorithm)algrithm.newInstance();
			baseAlgorithm.runDemo();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}