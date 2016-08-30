package leetcode.zuochengyun.dp;

/*
 * �������
 * ���������ַ���A��B�����������ַ���������������еĳ��ȡ����磬A="1A2C3D4B56����B="B1D23CA45B6A������123456"����"12C4B6"��������������С�
���������ַ���A��B��ͬʱ�����������ĳ���n��m���뷵������������еĳ��ȡ���֤�������Ⱦ�С�ڵ���300��
����������
"1A2C3D4B56",10,"B1D23CA45B6A",12
���أ�6
 */
public class LCS
{
	public static void main(String[] arsgs)
	{
		System.out.println(findLCS("1A2C3D4B56", 10, "B1D23CA45B6A", 12));
	}

	public static int findLCS(String A, int n, String B, int m)
	{
		int[][] result = new int[n][m]; // [���±�][�Ҵ��±�]�Ĺ����Ӵ�����
		for (int j = 0; j < m; j++)
		{
			if (A.charAt(0) == B.charAt(j))
				result[0][j] = 1;
			else
				result[0][j] = j == 0 ? 0 : result[0][j - 1];
		}
		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < m; j++) // ����ÿһ��
			{
				
				if (B.charAt(j) == A.charAt(i)) // �����ȣ����Ǽ�һ
					result[i][j] = j == 0? 1: result[i-1][j-1] + 1;
				else
					result[i][j] = j == 0 ? 0 : Math.max(result[i - 1][j], result[i][j - 1]);
				
			}
		}
		return result[n - 1][m - 1];
	}
}
