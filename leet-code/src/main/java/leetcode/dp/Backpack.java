package leetcode.dp;

/**
 * @author lmj
 *  背包问题
 *  一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * 测试样例：
 * [1,2,3],[1,2,3],3,6
 * 返回：6
 * 动态规划
 * 新建一个二维数组 result[前i件物品][不超过的重量] = 最大价值
 * 1、对于 1件物品，那如果物品的重量没有超过 j,那么就直接将这个物品放进去
 * 2、对于其他的，要么还是现在这么多件，即i放不进去，取result[i-1][j]
 * 要么看是否可以将i放进去。 j - w[i - 1] >= 0 ? 如果大等于0  则是result[i - 1][j - w[i-1]] + v[i-1], 否则当作0
 */
public class Backpack {
    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{1, 2, 3};
        System.out.println(maxValue(w, v, 3, 6));
    }

    public static int maxValue(int[] w, int[] v, int n, int cap) {
        // 表示 前i件物品不超过重量Y的最大价值
        int[][] result = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (i == 1 && v[i - 1] <= j) {
                    result[i][j] = v[i - 1];
                    continue;
                }
                int excludeI = result[i - 1][j];

                int includeI = j - w[i - 1] >= 0 ? result[i - 1][j - w[i - 1]] + v[i - 1] : 0;
                result[i][j] = excludeI > includeI ? excludeI : includeI;

            }
        }
        return result[n][cap];
    }
}
