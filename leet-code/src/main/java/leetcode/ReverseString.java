package leetcode;

import base.BaseAlgorithm;

public class ReverseString implements BaseAlgorithm {
    @Override
    public void runDemo() {
        System.out.println(reverseString("limingjian"));
    }

    public String reverseString(String s) {
        char[] tempChars = s.toCharArray();
        int i = 0;
        while (i < s.length() / 2) {
            char temp = tempChars[i];
            tempChars[i] = tempChars[tempChars.length - i - 1];

            tempChars[tempChars.length - i - 1] = temp;

            ++i;
        }
        // tempChars.toString(); // �ǲ��еģ���Ϊ����õ���Object��toString������
        return new String(tempChars);
    }
}
