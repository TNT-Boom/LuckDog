package leetcode.zuochengyun.bindarysearch;

/*
 * ��һ����������arr�����в������ظ�Ԫ�أ����ҵ�����arr[i]==i�����������λ�á��������λ���ϵ���������������������-1��
������������arr�����Ĵ�Сn���뷵������ֵ��
����������
[-1,0,2,3],4
���أ�2
 */
public class Find
{
	public int findPos(int[] arr, int n)
	{
		if (arr == null)
			return -1;
		int left = 0;
		int right = n - 1;
		int res = -1;
		while (left < right)
		{
			int mid = left + (right - left) / 2;
			if (arr[mid] == mid)
			{
				res = mid;
				right = mid - 1;
			}
			else if (arr[mid] > mid)
				right = mid - 1;
			else
				left = mid + 1;
		}
		if (arr[left] == left)
			res = left;
		return res;
	}
}
