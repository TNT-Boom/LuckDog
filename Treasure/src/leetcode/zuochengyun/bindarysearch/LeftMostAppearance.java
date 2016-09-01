package leetcode.zuochengyun.bindarysearch;

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
		System.out.println(findPos(new int[] {36, 62, 146, 208, 210, 369, 616}, 7, 616));
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
		return res;
	}
}
