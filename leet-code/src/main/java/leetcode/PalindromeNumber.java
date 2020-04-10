package leetcode;

import base.BaseAlgorithm;

/**
 * Palindrome Number
 * @see https://leetcode.com/problems/palindrome-number/description/
 * @author lmj
 * @since 2018/5/31
 **/
public class PalindromeNumber implements BaseAlgorithm {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }
        long temp = x;
        long y = 0;
        while (temp != 0) {
            y = y * 10 + temp % 10;
            temp /= 10;
        }
        if (y > Integer.MAX_VALUE) {
            return false;
        }
        if (y == x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //System.out.println(isPalindrome(10));
        //System.out.println(isPalindrome(12321));
        //System.out.println(isPalindrome(-123));
        //System.out.println(isPalindrome(0));
        testFinally();
    }

    public void runDemo() {

    }

    public static void testFinally() {
        System.out.println("before try");
        return;
        try {
            //throw new Exception("try throws exception");
        } catch (Exception e) {
            System.out.println("catch excption");
        } finally {
            System.out.println("finally");
        }
    }
}
