package leetcode.zuochengyun.dp;

/*
 * 最长公共串
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
测试样例：
"1A2C3D4B56",10,"B1D23CA45B6A",12
返回：6
 */
public class LCS
{
	public static void main(String[] arsgs)
	{
		System.out.println(findLCS("1A2C3D4B56", 10, "B1D23CA45B6A", 12));
	}

	public static int findLCS(String A, int n, String B, int m)
	{
		int[][] result = new int[n][m]; // [左串下标][右串下标]的公共子串长度
		for (int j = 0; j < m; j++)
		{
			if (A.charAt(0) == B.charAt(j))
				result[0][j] = 1;
			else
				result[0][j] = j == 0 ? 0 : result[0][j - 1];
		}
		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < m; j++) // 对于每一行
			{
				
				if (B.charAt(j) == A.charAt(i)) // 如果相等，则考虑加一
					result[i][j] = j == 0? 1: result[i-1][j-1] + 1;
				else
					result[i][j] = j == 0 ? 0 : Math.max(result[i - 1][j], result[i][j - 1]);
				
			}
		}
		return result[n - 1][m - 1];
	}
}
