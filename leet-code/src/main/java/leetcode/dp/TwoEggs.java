package leetcode.dp;

/**
 * N个鸡蛋，M层楼，确定鸡蛋哪一层落下来会碎
 * 要求最坏的情况下的探测次数最少
 * 动态规划
 * dp[i][j] 表示i个鸡蛋，在总共j 层楼，最坏的情况下扔鸡蛋的次数
 * 只有1个鸡蛋的情况下，显然只能一层一层的测试，故
 * dp[1][j] = j
 * 假设有i个鸡蛋，j层楼，那就想办法将情况拆分成1个鸡蛋的情况。
 * 1、从第 k 层扔下，鸡蛋破了，则肯定 目标层数x 肯定 < k , 就变成了 dp[i - 1][k - 1]
 * 2、从第 k 层扔下，鸡蛋没破，上面还有 j - k 层， 就变成了 dp[i][j - k] (本次扔球1次 + 子问题)
 * 考虑到最坏的情况： max(dp[i - 1][k - 1], dp[i][j - k]) + 1，最后这个 + 1  是本次的次数
 * 对于dp[i][j],要找到一个最好的一个值，需要遍历k，range[1, j] 取最小
 * for (int k = 1; k <= j; k++) {
 *     dp[i][j] = min(dp[i][j],max(dp[i-1][k-1], dp[i][j-k]) + 1)
 * }
 * @author limingjian
 * @date 2020/4/24
 *
 */
public class TwoEggs {
    public void slove(int eggCount, int flooorCount) {
        // 为了下表和数量、层数能对上，统一从1开始
        int[][] dp = new int[eggCount + 1][flooorCount + 1];
        // 只有一个鸡蛋的情况
        for (int j = 1; j <= flooorCount; j++) {
            dp[1][j] = j;
        }
        // 只有一层楼的情况
        for (int i = 1; i <= eggCount; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= eggCount; i++) {
            for (int j = 2; j <= flooorCount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1);
                }
                System.out.printf("eggCount = %s, floorCount = %s, badCase = %d\n", i, j, dp[i][j]);
            }
        }
    }
}