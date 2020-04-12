package leetcode.bittech;

public class Compare {
    public int getMax(int a, int b) {
        int c = a - b;
        int as = sign(a);
        int bs = sign(b);
        int cs = sign(c);
        // 不同为1，相同为0
        int difabs = as ^ bs;
        int sameabs = flip(difabs);

        int returnA = difabs * as + sameabs * cs;
        int returnB = flip(returnA);
        // returnA returnB一个0，一个1
        return a * returnA + b * returnB;
    }

    /**
     *  正1 负0 ，正包括0
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
