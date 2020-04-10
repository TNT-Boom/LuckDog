package leetcode.netease;

import java.util.Scanner;

public class Main5 {
    int $abc;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            t(n);
        }
    }

    public static void ty(int n) {
        int oneCount = one(n);
        int last = -1;
        while (last != oneCount) {
            last = one(++n);
        }
        System.out.println(n);
    }

    public static void t(int n) {
        String bit = Integer.toBinaryString(n);
        int len = bit.length();
        int oneCount = one(n);

        String[] bitArr = bit.split("");
        bitArr[0] = "0";
        for (int i = len; i > 0; i--) {
            String s = bitArr[i];
            String ps = bitArr[i - 1];
            if ("1".equals(s)) {
                String temp;
                if ("0".equals(ps)) {
                    temp = bitArr[i];
                    bitArr[i] = bitArr[i - 1];
                    bitArr[i - 1] = temp;
                    break;
                } else {
                    temp = bitArr[i - 1];
                    for (int j = i; j <= len; j++) {
                        bitArr[j - 1] = bitArr[j];
                    }
                    bitArr[len] = temp;
                }
            }
        }

        String res = "";
        for (int i = 0; i < bitArr.length; i++) {
            res += bitArr[i];
        }

        System.out.println(Integer.valueOf(res, 2));
    }

    // 1 count
    public static int one(int n) {
        int res = 0;
        while (n > 0) {
            res += n & 0X01;
            n >>= 1;
        }
        return res;
    }

}
