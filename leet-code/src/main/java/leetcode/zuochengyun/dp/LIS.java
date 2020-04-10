package leetcode.zuochengyun.dp;

/*
 * 求最长上升子序列
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
        int[] result = new int[n]; // result[i] 0...i的最大上升子序列。表示必须包含A[i]的子序列。我之前打算少了一层“包含当前字符”的含义
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
