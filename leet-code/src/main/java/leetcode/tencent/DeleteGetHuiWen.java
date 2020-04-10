package leetcode.tencent;

import java.util.Scanner;

/*
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 *
 * 翻转字符串，然后用LCS，再做差
 */
public class DeleteGetHuiWen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String source = scanner.nextLine();
            int longest = LCS(source, source.length());
            System.out.println(source.length() - longest);
        }
        scanner.close();
    }


    private static String reverse(String source, int n) {
        StringBuilder builder = new StringBuilder(n);
        for (int i = n - 1; i >= 0; i--) {
            builder.append(source.charAt(i));
        }
        return builder.toString();
    }

    private static int LCS(String source, int n) {
        String s1 = source;
        String s2 = reverse(source, n);

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (s1.charAt(0) == s2.charAt(i)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = i == 0 ? 0 : dp[0][i - 1];
            }

            if (s2.charAt(0) == s1.charAt(i)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = i == 0 ? 0 : dp[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int preNum = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = preNum;
                }
            }
        }
        return dp[n - 1][n - 1];

    }

}
