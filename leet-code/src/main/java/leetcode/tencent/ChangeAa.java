package leetcode.tencent;

import java.util.Scanner;

public class ChangeAa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            String s = scanner.nextLine();
            char[] sArray = s.toCharArray();
            int upperLowBound = sArray.length - 1;

            for (int i = sArray.length - 1; i >= 0; i--) {
                // 其后面的字符左移一位
                if (sArray[i] >= 'A' && sArray[i] <= 'Z') {
                    char temp = sArray[i];
                    for (int k = i + 1; k <= upperLowBound; k++) {
                        sArray[k - 1] = sArray[k];
                    }
                    sArray[upperLowBound] = temp;
                    upperLowBound--;
                }
            }
            System.out.println(new String(sArray));
        }
        scanner.close();
    }
}
