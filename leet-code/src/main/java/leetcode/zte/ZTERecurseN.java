package leetcode.zte;

/*
 * 递归计算N阶乘
 */
public class ZTERecurseN {
    public static void main(String[] args) {
        System.out.println(nRecurse(1));
    }

    private static long nRecurse(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * nRecurse(n - 1);
    }
}
