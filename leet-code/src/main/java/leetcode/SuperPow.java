package leetcode;

import base.BaseAlgorithm;

public class SuperPow implements BaseAlgorithm {
    @Override
    public void runDemo() {
        superPow(10, new int[]{1, 2, 3, 4, 5});
    }

    private final static int Q = 5;

    /**
     * (a * b) % c = ((a % c) * b) % c
     * @param a
     * @param b
     * @return
     */
    public int intPow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int res = 1;
        while (b-- > 0) {
            res = (res * a) % 1337;
        }
        return res;
    }

    // (a ^ b) % c = ((a % c) ^ b) % c

    public int superPow(int a, int[] b) {
        // 此处先用上面的公式减小a，避免溢出。 下面递归也是用的上面的公式
        a = a % 1337;
        int index = 0;
        int res = 1;
        while (index < b.length) {
            int currPow = intPow(a, b[index]);
            //  (a ^ 5) ^ 10 % 3 = (((a ^ 5) % 3 ) ^ 10 ) % 3
            res = intPow(res, 10);
            // 上一步的结果10次幂求余， 再乘以本次结果，再求余. 此处是乘法展开，类似intPow
            res = (res * currPow) % 1337;
            ++index;
        }
        return res;
    }
}
