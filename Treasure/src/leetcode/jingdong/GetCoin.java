package leetcode.jingdong;

public class GetCoin
{
	public int MaxValue(int v[], int n)
	{
		// dp[i][j] i---j ֮����õ����ֵ
		int[][] dp = new int[n][n];

		// record[i][j] i---j����£�ȡ��λ��
		int[][] record = new int[n][n];
		for (int i = 0; i < n; i++) // ���ֻ��һ��Ӳ�ҵ����
		{
			dp[i][i] = v[i];
			record[i][i] = i;
		}

		// ��ÿ�����Ƚ��б���
		for (int i = 2; i <= n; i++)
		{
			for (int s = 0; (s + i) <= n; s++) // s��ʾ��ʼλ��
			{
				int end = i + s - 1; // ��ǰѭ���У�������λ��
				int num1 = v[s];
				int num2 = v[end];

				if (i >= 3)
				{
					// �����һ�������˵�һ�� s a a a a end��ʣ�µ��� s-1  ----- end
					if (record[s + 1][end] == s + 1) // ���ڲ�ȡ�����Ų��ԣ�������һ��Ҳ�ǶԷ��ļƲߣ��Է��õ�һ��
						num1 += dp[s + 2][end];
					else // �Է��õڶ���
						num1 += dp[s + 1][end - 1];

					// �������������һ�����ˣ�ʣ�µ���s ----end -1
					if (record[s][end - 1] == s)
						num2 += dp[s + 1][end - 1]; // �Է��õ�һ��
					else
						num2 += dp[s][end - 2]; // �Է������һ��
				}
				// ����Ϊ2ֱ��ȡ�ϴ��һ�����С�
				record[s][end] = (num1 > num2) ? s : end;
				dp[s][end] = num1 > num2 ? num1 : num2;
			}
		}
		return dp[0][n - 1];
	}
}
