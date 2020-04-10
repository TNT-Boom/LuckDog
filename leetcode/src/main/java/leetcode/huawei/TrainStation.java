package leetcode.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 出栈顺序，后续比其小的数，必须是降序。
 */
public class TrainStation
{
	

	private static ArrayList<String> seque = new ArrayList<>(); 
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			Map<Integer, Integer> trains = new HashMap<>();
			StringBuilder arrayStr = new StringBuilder();
			int n = scanner.nextInt();
			int i = 0;
			while(i < n)
			{
				trains.put(i, scanner.nextInt());
				arrayStr.append(i);
				++i;
			}
			trainEnter(arrayStr.toString());
			
			ArrayList<String> result = new ArrayList<>();
			for (String string : seque)
			{
				StringBuilder builder = new StringBuilder();
				for(int j = 0; j < string.length(); j++)
				{
					
					builder.append(trains.get(string.charAt(j) - '0')).append(" ");
				}
				result.add(builder.toString().trim());
			}
			
			Collections.sort(result);
			for (String string : result)
			{
				System.out.println(string);
			}
		}
		scanner.close();
	}
	
	private static void trainEnter(String trainsStr)
	{
		genSeque(trainsStr, "", 0);
	}

	private static void genSeque(String source, String result, int index)
	{
		if(index == source.length())
		{
			if(isEffective(result))
				seque.add(result); // 表示一次排列完成
		}
		else
		{
			
			for(int i = 0; i < source.length(); i++)
			{
				if(result.indexOf(source.charAt(i)) < 0) // 考虑b开头的情况，仍然需要从a开始
					genSeque(source, result + source.charAt(i), index + 1);
			}
			index++;
		}
	}
	
	private static boolean isEffective(String result)
	{
		for(int i = 0; i < result.length() - 1; ++i)
		{
			int currJudge = result.charAt(i) - '0';
			int currSmall = Integer.MAX_VALUE;
			for(int j = i +1; j < result.length(); ++j)
			{
				int curr = result.charAt(j) - '0';
				if(curr <  currJudge && curr > currSmall)
				{
					return false;
				}
				if(curr <  currJudge && curr < currSmall)
				{
					currSmall = curr;
				}
			}
		}

		return true;
	}
}
