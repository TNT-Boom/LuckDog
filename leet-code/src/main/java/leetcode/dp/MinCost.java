package leetcode.dp;

/**
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
测试样例：
"abc",3,"adc",3,5,3,100
返回：8
 */

public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int ic, int dc, int cc) {
        // write code here
        // s1[0...i-1] 转换成 s2[0....j-1]的代价
        int[][] result = new int[n + 1][m + 1];
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
