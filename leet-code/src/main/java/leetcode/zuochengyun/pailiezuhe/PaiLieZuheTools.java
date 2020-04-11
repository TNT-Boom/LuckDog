package leetcode.zuochengyun.pailiezuhe;

/**
 * @author lmj
 */
public class PaiLieZuheTools {
    public static void main(String[] args) {
        System.out.println(cnm(4, 2));
        System.out.println(anm(3, 2));
        System.out.println(ajiecheng(3));
    }

    public static int cnm(int n, int m) {
        int count = m;
        int fenzi = 1;
        int fenmu = 1;
        while (count > 0) {
            fenzi *= (n - count + 1);
            fenmu *= count--;
        }
        return fenzi / fenmu;
    }

    public static int anm(int n, int m) {
        int count = m;
        int total = 1;
        while (count > 0) {
            total *= (n - count-- + 1);
        }
        return total;
    }

    public static int ajiecheng(int n) {
        int total = 1;
        while (n > 0) {
            total *= (n--);
        }
        return total;
    }
}
