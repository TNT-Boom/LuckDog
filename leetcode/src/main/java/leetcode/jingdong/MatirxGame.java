package leetcode.jingdong;
/*
 * С�����ڹ�˾Ҫ�����ս�����С��ǡ�û������߸�������Ҫ�ڹ�˾����ϲ���һ���齱��Ϸ����Ϸ��һ��6*6�������Ͻ��У��������36����ֵ���ȵ����ÿ��С���������������һ���������Ҫ�����Ͻǿ�ʼ��Ϸ��ÿ��ֻ�����»��������ƶ�һ�����������½�ֹͣ��һ·�ϵĸ����������С�������õ��������һ���㷨ʹС���õ���ֵ��ߵ����
����һ��6*6�ľ���board������ÿ��Ԫ��Ϊ��Ӧ���ӵ������ֵ,���Ͻ�Ϊ[0,0],�뷵���ܻ�õ�����ֵ����֤ÿ�������ֵ����100С��1000��
 */
public class MatirxGame
{
	public static void main(String[] args)
	{
	   
		
	}
	
	 public int getMost(int[][] board) 
	 {
		 if(board == null)
			 return 0;
		 int n = board.length;
	    	int[][] dp = new int[n][n];
	    	for(int i = 0; i < n; i++)
	    	{
	    		dp[i][0] = i == 0 ? (board[i][0]) : (dp[i - 1][0] + board[i][0]);
	    		
	    	}
	    	for(int j = 0; j < n; j++)
	    	{
	    		dp[0][j] = j == 0 ? (board[0][j]) : (dp[0][j - 1] + board[0][j]);
	    	}
	    	for(int i = 1; i < n; i++)
	    	{
	    		for(int j = 1; j < n; j++)
	    		{
	    			dp[i][j] = Math.max(dp[i - 1][j], dp[i][j- 1]) + board[i][j];
	    		}
	    	}
	    	return dp[n -1][n - 1];
	 }
}
