package leetcode.baidu;
/*
 * 递增值矩阵与其转置矩阵乘积。
 * 1 2 3   1 4 7 
 * 4 5 6   2 5 8 
 * 7 8 9   3 6 9
 */
public class JuZhen
{
	public static void main(String[] args)
	{
		int n = 1;
		int row = 2;
		int col =3;
		int[][] m = getMatrix(n, row, col);
		int[][] result = new int[row][row];
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j< row; j++)
			{
				result[i][j] = getNum(i, j, m);
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
	}
	private static int getNum(int i, int j, int[][] arr)
	{
		int result = 0;
		for(int k = 0; k < arr[0].length; k++)
		{
			result+= (arr[i][k] * arr[j][k]);
		}
		return result;
	}
	private static int[][] getMatrix(int n, int row, int col)
	{
		int[][] result = new int[row][col];
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
			{
				result[i][j] = n++;
			}
		return result;
	}


	private static void iniCache(int[] cache, int n, int[] input)
	{
		cache = new int[n]; // i 表示 i i-1之间素数的个数
		for (int i = 1; i < n; i++)
		{
			cache[i] = getCount(input[i - 1], input[i - 2]);
		}
	}

	private static int getCount(int left, int right)
	{
		int total = 0;
		for (int i = left + 1; i < right; i++)
		{
			if (isSushu(i))
				++total;
		}
		return total;
	}

	private static boolean isSushu(int n)
	{
		boolean right = true;
		if (n <= 1)
		{
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			if (n % i == 0)
			{
				right = false;
				break;
			}
		}
		return right;
	}
}
