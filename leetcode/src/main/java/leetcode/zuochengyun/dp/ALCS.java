package leetcode.zuochengyun.dp;

/*
 * Ҫ���������ֵ�һ�ֹ���������
 */
public class ALCS
{
	public static void main(String[] args)
	{
		System.out.println(getLCS("acbac", "acaccbabb"));
	}
	private static String getLCS(String s1, String s2)
	{
		String longestStr = "";
		int i = 0;
		int j = 0;
		for(i = 0; i < s1.length(); i++) // ��һ��ѭ��ȷ�� S1�����
		{
			for(j = 0; j < s2.length(); j++) // �ڶ���ѭ������Ѱ��S2�����
			{
				if(s2.charAt(j) != s1.charAt(i))
					continue;
				// �ҵ��˹�����ʼ��λ��
				String temp = getLongest(s1, s2, i, j);
				if(temp.length() > longestStr.length())
					longestStr = temp;
			}
		}
		return longestStr;
	}
	private static String getLongest(String s1, String s2, int i, int j)
	{
		int start = i;
		int iend = i; // ��Ӵ�����һ������
		while( i < s1.length() && j < s2.length() && s1.charAt(i++) == s2.charAt(j++))
		{
			iend = i;
		}
		return s1.substring(start, iend);
	}
}
