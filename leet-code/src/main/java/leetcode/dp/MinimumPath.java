package leetcode.dp;

/*
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 */
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        int[][] result = new int[n][m];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += map[i][0];
            result[i][0] = sum;
        }
        sum = 0;
        for (int j = 0; j < m; j++) {
            sum += map[0][j];
            result[0][j] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 来自上面
                int one = map[i][j] + result[i - 1][j];
                // 来自左边
                int two = map[i][j] + result[i][j - 1];
                result[i][j] = one > two ? two : one;
            }
        }
        return result[n - 1][m - 1];
    }
}
