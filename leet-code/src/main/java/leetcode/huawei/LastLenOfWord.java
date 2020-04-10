package leetcode.huawei;

import java.util.Scanner;

//字符串最后一个单词的长度
public class LastLenOfWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(input.length() - 1 - input.lastIndexOf(" "));
        }
        scanner.close();
    }
}
