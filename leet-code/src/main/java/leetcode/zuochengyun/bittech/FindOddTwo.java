package leetcode.zuochengyun.bittech;

/*
 * 给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
 */
public class FindOddTwo {
    public int[] findOdd(int[] A, int n) {
        int ori = 0;

        for (int i = 0; i < n; i++) {
            ori ^= A[i];
        }
        int k = 0;
        for (k = 1; k < 32; k++) {
            if (isOne(ori, k)) {
                break;
            }
        }

        // 下次与 K位为1的异或，这样就挑出其中一个数了。
        int ori2 = 0;
        for (int i = 0; i < n; i++) {
            if (isOne(A[i], k)) {
                ori2 ^= A[i];
            }
        }
        ori = ori ^ ori2;

        int[] result = new int[2];
        result[0] = ori > ori2 ? ori2 : ori;
        result[1] = ori > ori2 ? ori : ori2;
        return result;
    }

    // 31 30 ....1 位 ， 第k位是否为1
    private boolean isOne(int n, int k) {
        int result = (n >>> k) & 1;
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}
