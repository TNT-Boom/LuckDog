package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import base.BaseAlgorithm;

public class StatisticFood implements BaseAlgorithm
{
	public void runDemo()
	{
		demo();
	}

	public void demo()
	{
		Set<String> count = new HashSet<>();

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		try
		{
			String lineStr;
			while ((lineStr = input.readLine()) != null)
			{
				if (lineStr.equals(" "))
					break;
				String[] line = lineStr.split(" ");
				for (int i = 0; i < line.length; i++)
				{
					count.add(line[i]);
				}
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count.size());
	}
}
