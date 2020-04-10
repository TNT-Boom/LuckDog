package leetcode.zuochengyun.dp;

/*
 * �������������
 */
public class LIS {
    public static void main(String[] args) {
        int[] hehe = new int[]{1, 5, 9, 7, 6, 3, 4};
        System.out.println(getLIS(hehe, hehe.length));
    }

    public static int getLIS(int[] A, int n) {
        if (A == null) {
            return 0;
        }
        int[] result = new int[n]; // result[i] 0...i��������������С���ʾ�������A[i]�������С���֮ǰ��������һ�㡰������ǰ�ַ����ĺ���
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j] && result[j] > temp) {
                    temp = result[j];
                }
                result[i] = temp + 1;
            }
        }

        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] > temp) {
                temp = result[i];
            }
        }
        return temp;
    }
}
