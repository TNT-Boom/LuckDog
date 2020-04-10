package leetcode.huawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String oriInput = scanner.nextLine().trim();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < oriInput.length(); ++i) {
                if ((oriInput.charAt(i) >= 'a' && oriInput.charAt(i) <= 'z') || (oriInput.charAt(i) >= 'A' && oriInput.charAt(i) <= 'Z')) {
                    builder.append(oriInput.charAt(i));
                } else {
                    builder.append(" ");
                }
            }
            Pattern p = Pattern.compile("\\s+");
            Matcher m = p.matcher(builder.toString());
            String[] input = m.replaceAll(" ").split(" ");
            System.out.println(reverseWords(input));
        }
        scanner.close();
    }

    private static String reverseWords(String[] source) {
        StringBuilder builder = new StringBuilder();
        for (int i = source.length - 1; i >= 0; --i) {
            builder.append(source[i]).append(" ");
        }
        return builder.toString().trim();
    }
}
