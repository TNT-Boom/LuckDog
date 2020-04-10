package leetcode.netease;

import java.util.Scanner;

// 查找 二进制1个数等于N的1的个数的值，这个值要大于N
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(getFast(n));
        }
    }

    public static int getResult(int n) {
        int standard = countOne(n);
        int currCountOne = -1;
        while (currCountOne != standard) {
            currCountOne = countOne(++n);
        }
        return n;
    }

    public static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    private static int getFast(int n) {
        if (n == 0) {
            return 0;
        }
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int i = chars.length - 1;
        for (; i >= 0; i--) {
            if (chars[i] == '1') {
                break;
            }
        }
        // 如果是最高位为1，则进位
        if (i == 0) {
            return Integer.parseInt(Integer.toBinaryString(n) + "0", 2);
        }
        int last = Integer.MAX_VALUE;
        if (i != chars.length - 1) {
            changeChar(chars, i, i + 1);
            last = Integer.parseInt(new String(chars), 2);
            if (last < n) {
                last = Integer.MAX_VALUE;
            }
            //	changeChar(chars, i, i+1);

        }
        if (chars[i - 1] == '0') {
            changeChar(chars, i, i - 1);
            String resultStr = new String(chars);
            return Integer.parseInt(resultStr, 2);
        }
        i = i - 1;
        while (i >= 0 && chars[i] == '1') {
            i--;
        }
        int preResult = 0;
        if (i == -1) {
            chars[0] = '0';
            String resultStr = "1" + new String(chars);
            preResult = Integer.parseInt(resultStr, 2);
        } else {
            changeChar(chars, i, i + 1);
            String resultStr = new String(chars);
            preResult = Integer.parseInt(resultStr, 2);
        }
        return preResult > last ? last : preResult;
    }

    private static void changeChar(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
