package leetcode.baidu;

import java.util.Scanner;
// http://cache.baiducontent.com/c?m=9d78d513d9d437ab4f9b96697b14c017694381132ba6d2020fd08438e5732840506793ac57530775d7d20c1716dc3e4beb802104331456b58cc9f85dadbc8559299f2644676d805663d60eaebb5155c637e158feae69f0caf125e2abc5a2ac4325c844040a9780804d7710dd1f80034294b19838022e61ad9a30728e5f6059eb3707f619f6ba74284596f7ae4151866f957611e0fe69e0604fe052b31f6c7519ff51e6540a7561e34f3abd593a0398ef5ced2b6e4054ec0eece7&p=85769a47c0934eac58e8de62564e8d&newp=9e72da0d9e934eac58e8822d021495231610db2151ddd501298ffe0cc4241a1a1a3aecbf26221504d2c77c6607ae4a5beff33c76300634f1f689df08d2ecce7e39&user=baidu&fm=sc&query=%D6%D0%D0%CB%C0%B6%BD%A3%BC%C6%BB%AE%D6%D0%B5%C4%C4%C7%B5%C0%B3%C7%CA%D0%B9%E6%BB%AE%CC%E2%C4%BF&qid=905117c700003c35&p1=1
//目回忆：为了规划城市，需要统计房屋数目信息。
//方法如下，一张航拍照片会被分隔为M*N个小格子，
//用数字0或1分别表示某格子看到的是空地还是屋顶，相邻的屋顶属于同一栋房子，
//位于对角线上的屋顶不属于同一栋房子（这也符合实际），现在先输入航拍照片的大小（M行N列），
//再输入矩形俯视图的布局，要求我们输出这块矩形空地中有多少栋房子
public class Home
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext())
		{
			int row = scan.nextInt();
			int col = scan.nextInt();
			int[][] matrix = new int[row][col];
			for (int i = 0; i < row; i++)
			{
				for (int j = 0; j < col; j++)
				{
					matrix[i][j] = scan.nextInt();
				}
			}
			System.out.println(CountHourse.doCountHourse(matrix));

		}
		scan.close();
	}

}

class CountHourse
{
	public static int doCountHourse(int[][] matrix)
	{
		int count = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (matrix[i][j] == 1)
				{
					count++;
					route(i, j, matrix);
				}
			}
		}
		return count;
	}

	public static void route(int i, int j, int[][] matrix)
	{
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
		{
			if (matrix[i][j] == 1)
			{
				matrix[i][j] = 0;
				route(i - 1, j, matrix);
				route(i + 1, j, matrix);
				route(i, j - 1, matrix);
				route(i, j + 1, matrix);
			}
		}

	}
}