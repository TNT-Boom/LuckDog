package leetcode.jingdong;

import java.util.Scanner;

public class GuShen
{
	public static void main(String[] args)
	{

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt())
		{
			int total = 1;
			int upDays = 1;
			int n = in.nextInt();
			for (int i = 1; i <= n; i++)
			{
				if (i != 1)
				{
					int j = upDays; // 对于每一天涨的
					while (j > 0 && i <= n)
					{
						total++;
						j--;
						i++;
					}
					upDays++; // 下次涨的天数加一
					if (i <= n)
						total--; // 跌一天
				}

			}
			System.out.println(total);
		}
		in.close();
	}
}
