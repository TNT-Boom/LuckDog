package leetcode.zuochengyun.dp;

/*
 * 跳台阶问题：主要防止溢出
 * 一次走一步或者两步
 */
public class GoUpstairs {
    public int countWays(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }
        return result[n];
    }
}
