package leetcode.zuochengyun.dp;

/*
 * ��һ������map����ÿ��������һ��Ȩֵ�������Ͻǵĸ��ӿ�ʼÿ��ֻ�����һ��������ߣ���󵽴����½ǵ�λ�ã�·�������е������ۼ���������·���ͣ��������е�·������С��·���͡�
����һ������map����������n������m���뷵����С·���͡���֤��������С�ڵ���100.
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
                int one = map[i][j] + result[i - 1][j]; // ��������
                int two = map[i][j] + result[i][j - 1]; // �������
                result[i][j] = one > two ? two : one;
            }
        }
        return result[n - 1][m - 1];
    }
}
