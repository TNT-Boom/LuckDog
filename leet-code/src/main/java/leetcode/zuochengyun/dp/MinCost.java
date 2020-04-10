package leetcode.zuochengyun.dp;

/*
 * ���������ַ���A��B��������Ҫ���в��롢ɾ�����޸Ĳ�����A����ΪB��������c0��c1��c2�ֱ�Ϊ���ֲ����Ĵ��ۣ������һ����Ч�㷨�������A����ΪB������Ҫ�����ٴ��ۡ�
���������ַ���A��B�������ǵĳ��Ⱥ����ֲ������ۣ��뷵�ؽ�A����ΪB������Ҫ����С���ۡ���֤�������Ⱦ�С�ڵ���300�������ִ���ֵ��С�ڵ���100��
����������
"abc",3,"adc",3,5,3,100
���أ�8
 */

public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int ic, int dc, int cc) {
        // write code here
        int[][] result = new int[n + 1][m + 1]; // s1[0...i-1] ת���� s2[0....j-1]�Ĵ���
        for (int i = 1; i <= n; i++) {
            result[i][0] = ic + result[i - 1][0];
        }

        for (int j = 1; j <= m; j++) {
            result[0][j] = ic + result[0][j - 1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                int one = result[i - 1][j] + dc;
                int two = result[i][j - 1] + ic;
                int three = result[i - 1][j - 1] + cc;
                int four = result[i - 1][j - 1];
                int min = one;
                min = min < two ? min : two;
                min = min < three ? min : three;
                min = min < four ? min : four;
                result[i][j] = min;
            }
        }

        return result[n][m];
    }

}
