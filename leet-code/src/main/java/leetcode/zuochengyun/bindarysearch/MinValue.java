package leetcode.zuochengyun.bindarysearch;

/*
 * ����һ������ѭ������arr������arr�е���Сֵ������ѭ��������ָ��
 * ��������������ⳤ�ȵĲ��ַŵ��ұ�ȥ���ұߵĲ����õ��������
 * ��������[1,2,3,3,4]��������ѭ�����飬[4,1,2,3,3]Ҳ�ǡ�
��������arr�����Ĵ�Сn���뷵����Сֵ��
����������
[4,1,2,3,3],5
���أ�1
 */
public class MinValue {
    public static void main(String[] args) {
        System.out.println(getMin(new int[]{5, 6, 7, 1, 2, 3, 4}, 7));
    }

    public static int getMin(int[] arr, int n) {
        if (arr == null) {
            return Integer.MIN_VALUE;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (left == right - 1) {
                break;
            }
            int mid = left + (right - left) / 2;
            if (arr[left] < arr[right]) // ��ʾ���ڷ�ѭ����
            {
                return arr[left];
            } else // ���б��в��ֻ�ȫ����ѭ���Σ�����   5 6 7 1 2 3 4
            {
                // �ּ������
                if (arr[left] > arr[mid]) // ��ʾ mid����ѭ�����֣���ôm�Ҳ�϶���m��
                {
                    right = mid;
                } else if (arr[mid] > arr[right]) // �������п϶���ѭ�����֣�arr[m] > arr[right]�� ����С���� m-r֮��
                {
                    left = mid;
                } else // aL >= aR, aL <= aM <= aR ==> aL = aM = aR��ֻ�ܱ�����
                {
                    int min = Integer.MAX_VALUE;
                    for (int i = left; i <= right; i++) {
                        if (arr[i] < min) {
                            min = arr[i];
                        }
                    }
                    return min;
                }
            }
        }
        return arr[left] > arr[right] ? arr[right] : arr[left]; // ��Ҫ

    }

}
