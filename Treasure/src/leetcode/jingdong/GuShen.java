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
					int j = upDays; // ����ÿһ���ǵ�
					while (j > 0 && i <= n)
					{
						total++;
						j--;
						i++;
					}
					upDays++; // �´��ǵ�������һ
					if (i <= n)
						total--; // ��һ��
				}

			}
			System.out.println(total);
		}
		in.close();
	}
}
