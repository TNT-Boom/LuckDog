package leetcode.bittech;

public class Compare {
    public int getMax(int a, int b) {
        int c = a - b;
        int as = sign(a);
        int bs = sign(b);
        int cs = sign(c);
        // ��ͬΪ1����ͬΪ0
        int difabs = as ^ bs;
        int sameabs = flip(difabs);

        int returnA = difabs * as + sameabs * cs;
        int returnB = flip(returnA);
        // returnA returnBһ��0��һ��1
        return a * returnA + b * returnB;
    }

    /**
     *  ��1 ��0 ��������0
     * @param n
     * @return
     */
    public int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public int flip(int n) {
        // 1--> 0; 0-->1;
        return n ^ 1;
    }
}
