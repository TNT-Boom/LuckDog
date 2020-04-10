package leetcode;

import base.BaseAlgorithm;

import java.util.Scanner;

// 牛客网 密码验证程序
public class EncryptTestify implements BaseAlgorithm {

    public boolean testify(String str) {
        if (str == null || str.length() <= 8) {
            return false;
        }

        int bigChar = 0;
        int smallChar = 0;
        int num = 0;
        int otherSymbol = 0;

        char pre2Char = str.charAt(0);
        char pre1Char = str.charAt(1);
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (i >= 2) {
                if (pre1Char == c && pre2Char == c) {
                    return false;
                }
            }

            if (c >= 'a' && c <= 'z') {
                smallChar = 1;
            } else if (c >= 'A' && c <= 'Z') {
                bigChar = 1;
            } else if (c >= '0' && c <= '9') {
                num = 1;
            } else {
                otherSymbol = 1;
            }
            pre2Char = pre1Char;
            pre1Char = c;
        }
        if (bigChar + smallChar + num + otherSymbol < 3) {
            return false;
        }
        return true;

    }

    @Override
    public void runDemo() {
        Scanner in = new Scanner(System.in);

        String lineStr;
        while ((lineStr = in.nextLine()) != null) {
            System.out.println(testify(lineStr) ? "OK" : "NG");
        }
    }
}
