package leetcode.zuochengyun.bindarysearch;

public class QuickPower
{
	public static void main(String[] args)
	{
		System.out.println(getPower(2, 14876069));
	}
	
	// 数太大会溢出
	public static  int getPower(int k, int N)
	{
	       int total = 1;
			int temp = k;
			for(int i = 0; N != 0; i ++)
			{
	            N = N >> 1;
				if( (N & 1)  != 0)
				{
					total  = (total * temp) % 1000000007;
				}
				temp = (temp * temp) % 1000000007;
			}
			return total;
	}
}
