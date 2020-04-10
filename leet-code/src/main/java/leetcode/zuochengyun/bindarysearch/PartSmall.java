package leetcode.zuochengyun.bindarysearch;

/*
 * ����ֲ���С�ĸ��arr����Ϊ1ʱ��arr[0]�Ǿֲ���С��arr�ĳ���ΪN(N>1)ʱ��
 * ���arr[0]<arr[1]����ôarr[0]�Ǿֲ���С��
 * ���arr[N-1]<arr[N-2]����ôarr[N-1]�Ǿֲ���С��
 * ���0<i<N-1������arr[i]<arr[i-1]����arr[i]<arr[i+1]��
 * ��ôarr[i]�Ǿֲ���С�� ������������arr
 * ����֪arr�������������ڵ���������ȣ�
 * дһ��������ֻ�践��arr������һ���ֲ���С���ֵ�λ�ü��ɡ�
 */
public class PartSmall {
    public static void main(String[] args) {
        System.out.println(getLessIndex(new int[]{5, 4, 5, 8, 0, 10, 8, 6, 7, 10}));
    }

    public static int getLessIndex(int[] arr) {
        int n = arr.length;
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        }
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid - 1]) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid + 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;

    }
}
