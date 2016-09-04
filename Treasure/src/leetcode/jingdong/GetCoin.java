package leetcode.jingdong;

public class GetCoin
{
	public int MaxValue(int v[], int n)
	{
		// dp[i][j] i---j 之间可拿的最大值
		int[][] dp = new int[n][n];

		// record[i][j] i---j情况下，取的位置
		int[][] record = new int[n][n];
		for (int i = 0; i < n; i++) // 针对只有一个硬币的情况
		{
			dp[i][i] = v[i];
			record[i][i] = i;
		}

		// 对每个长度进行遍历
		for (int i = 2; i <= n; i++)
		{
			for (int s = 0; (s + i) <= n; s++) // s表示起始位置
			{
				int end = i + s - 1; // 当前循环中，结束的位置
				int num1 = v[s];
				int num2 = v[end];

				if (i >= 3)
				{
					// 如果上一次我拿了第一个 s a a a a end，剩下的是 s-1  ----- end
					if (record[s + 1][end] == s + 1) // 由于采取的最优策略，所以上一步也是对方的计策，对方拿第一个
						num1 += dp[s + 2][end];
					else // 对方拿第二个
						num1 += dp[s + 1][end - 1];

					// 假设我拿了最后一个走了，剩下的是s ----end -1
					if (record[s][end - 1] == s)
						num2 += dp[s + 1][end - 1]; // 对方拿第一个
					else
						num2 += dp[s][end - 2]; // 对方拿最后一个
				}
				// 长度为2直接取较大的一个就行。
				record[s][end] = (num1 > num2) ? s : end;
				dp[s][end] = num1 > num2 ? num1 : num2;
			}
		}
		return dp[0][n - 1];
	}
}
