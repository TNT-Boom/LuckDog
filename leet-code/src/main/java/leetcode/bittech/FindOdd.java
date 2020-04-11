package leetcode.bittech;

/**
 * @author lmj
 * 有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
给定整形数组A及它的大小n，请返回题目所求数字。
 */
public class FindOdd {
    public int findOdd(int[] A, int n) {
        int ori = 0;

        for (int i = 0; i < n; i++) {
            ori ^= A[i];
        }
        return ori;
    }
}
