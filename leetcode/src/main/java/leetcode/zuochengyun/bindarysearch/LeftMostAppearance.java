package leetcode.zuochengyun.bindarysearch;

import java.util.Scanner;

/*
 * ����һ����������arr���ٸ���һ������num������arr���ҵ�num��������ֵ�����ߵ�λ�á�
����һ������arr�����Ĵ�Сn��ͬʱ����num���뷵������λ�á�����Ԫ����������δ���֣��뷵��-1��
����������
[1,2,3,3,4],5,3
���أ�2

 */
public class LeftMostAppearance
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			int num = scanner.nextInt();
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
			{
				arr[i] = scanner.nextInt();
			}
			System.out.println(findPos(arr, n, num));
		}
	}

	public static int findPos(int[] arr, int n, int num)
	{
		int res = -1;
		int left = 0;
		int right = n - 1;
		if (arr == null)
			return -1;
		if (arr[0] == num)
			return 0;
		while (left < right)
		{
			int mid = left + (right - left) / 2;
			if (arr[mid] == num)
			{
				res = mid;
				right = mid - 1;
			}
			else if (arr[mid] > num)
				right = mid - 1;
			else
				left = mid + 1;
		}
		if (arr[left] == num)
			res = left;
		else if(res == -1)
		{
			int i = n - 1;
			while(i >= 0)
			{
				if(arr[i] < num)
					break;
				--i;
			}
			if(i == -1)
				res= -1;
			else {
				res = -1 - i - 1;
			}
		}
		return res;
	}
}
