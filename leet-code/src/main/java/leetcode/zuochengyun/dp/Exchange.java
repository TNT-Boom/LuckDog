package leetcode.zuochengyun.dp;

/*
 * 找零钱问题
 */
public class Exchange {
    static int[] source = new int[]{5, 10, 25, 1};
    static int[][] memResult;
    static int[][] origDpResult;

    public static void main(String[] args) {
        int a = 100;
        System.out.println(a);
        System.out.println(a++);
        System.out.println(++a);
        System.out.println(--a);
        System.out.println(a--);
        System.out.println(a + 1);
        System.out.println(a += 1);
        System.out.println(a);
        countWays(source, 4, 15);
    }

    public static int countWays(int[] penny, int n, int aim) {
        // 暴力搜索
        System.out.println(baoliExchange(source, 0, aim));

        // 记忆搜索
        // 定义中间结果
        memResult = new int[n][aim + 1]; // [当前起始Index][当前需要构成的钱数]，这个概念与动态规划的含义不同。类似自顶向下。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < aim + 1; j++) {
                memResult[i][j] = -1;
            }
        }
        System.out.println(memSearch(penny, 0, aim));

        // 基本动态规划
        origDpResult = new int[n][aim + 1]; // 表示的是[0 。。。index种钱][需要组成的钱数]，与记忆搜索不同，这个类似自下而上，规定了计算顺序
        System.out.println(dpCount(penny, 0, aim));

        // 改进后的动态规划
        origDpResult = new int[n][aim + 1]; // 表示的是[0 。。。index种钱][需要组成的钱数]，与记忆搜索不同，这个类似自下而上，规定了计算顺序
        System.out.println(advDpCount(penny, 0, aim));
        return 0;
    }

    // 暴力搜索
    // 数组，开始计算的下标，构成的零钱数
    public static int baoliExchange(int[] penny, int index, int aim) {
        int total = 0;
        if (index == penny.length) {
            return aim == 0 ? 1 : 0;
        }
        int maxCount = aim / penny[index]; // 计算可容纳多少当前的零钱
        while (maxCount >= 0) // 分别使用 maxCount....0张当前零钱，去计算剩余的。
        {
            total += baoliExchange(penny, index + 1, aim - penny[index] * maxCount--);
        }
        return total;
    }

    // 记忆搜索，不过是用一个二维数组或者Hash表记录计算过的值，不存在顺序问题。
    public static int memSearch(int[] penny, int index, int aim) {
        int total = 0;
        if (index == penny.length) {
            return aim == 0 ? 1 : 0;
        }
        if (memResult[index][aim] != -1) {
            return memResult[index][aim];
        }
        int maxCount = aim / penny[index];
        while (maxCount >= 0) {
            total += memSearch(penny, index + 1, aim - penny[index] * maxCount--);
        }
        return total;

    }

    // 动态规划，无任何额外优化的
    public static int dpCount(int[] penny, int index, int aim) {
        // 先初始化数组
        // 0行 j列，只有j 为 penny[0]的整数倍的时候才可以有方案。
        for (int j = 0; j < aim + 1; j++) {
            if (j % penny[0] == 0) {
                origDpResult[0][j] = 1;
            }
        }

        // 初始化列，由于是0元，所以所有的方案都是只有一种，即0张。
        for (int i = 0; i < penny.length; i++) {
            origDpResult[i][0] = 1;
        }

        // 下面开始计算，采用朴素的自底向上的思维。
        // dp[i][j] 表示 penny[0，1，2，3，。。。，i] 的零钱组成j的方案数。
        // 对于dp[i][j] = d[i-1][j] + d[i-1][j - penny[i]] + d[i - 1][j - penny[i] * 2] + ...
        // 接下来，构造二维数组
        for (int i = 1; i < penny.length; i++) // 从1开始，因为0行已经初始化
        {
            for (int j = 1; j < aim + 1; j++) {
                int total = 0;
                int count = j / penny[i]; // 如果全用j
                while (count >= 0) // 分别用count张i
                {
                    total += origDpResult[i - 1][j - penny[i] * count--];
                }
                origDpResult[i][j] = total;
            }
        }
        return origDpResult[penny.length - 1][aim];
    }

    // 总结规律后的动态规划
    // 不再遍历上一行
    public static int advDpCount(int[] penny, int index, int aim) {
        // 先初始化数组
        // 0行 j列，只有j 为 penny[0]的整数倍的时候才可以有方案。
        for (int j = 0; j < aim + 1; j++) {
            if (j % penny[0] == 0) {
                origDpResult[0][j] = 1;
            }
        }

        // 初始化列，由于是0元，所以所有的方案都是只有一种，即0张。
        for (int i = 0; i < penny.length; i++) {
            origDpResult[i][0] = 1;
        }

        // 下面开始计算，采用朴素的自底向上的思维。
        // dp[i][j] 表示 penny[0，1，2，3，。。。，i] 的零钱组成j的方案数。
        // 对于dp[i][j] = d[i-1][j] + d[i-1][j - penny[i]] + d[i - 1][j - penny[i] * 2] + ...
        // 接下来，构造二维数组
        for (int i = 1; i < penny.length; i++) // 从1开始，因为0行已经初始化
        {
            for (int j = 1; j < aim + 1; j++) {
                // 由于 d[i][j] = d[i-1][j] + d[i-1][j - penny[i]] + d[i - 1][j - penny[i] * 2] + ...
                // 那么 d[i][j - penny[i]] =   d[i-1][j - penny[i]] + d[i - 1][j - penny[i] * 2] + ...
                // 所以直接优化
                if (j - penny[i] >= 0) {
                    origDpResult[i][j] = origDpResult[i][j - penny[i]] + origDpResult[i - 1][j];
                } else {
                    origDpResult[i][j] = origDpResult[i - 1][j];
                }
            }
        }
        return origDpResult[penny.length - 1][aim];
    }
}
