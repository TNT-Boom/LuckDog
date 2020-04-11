package leetcode.dp;

/**
 * @author lmj
 * 要求连续出现的一种公共子序列
 */
public class Alcs {
    public static void main(String[] args) {
        System.out.println(getLcs("acbac", "acaccbabb"));
    }

    private static String getLcs(String s1, String s2) {
        String longestStr = "";
        int i = 0;
        int j = 0;
        // 第一个循环确定 S1的起点
        for (i = 0; i < s1.length(); i++) {
            // 第二个循环尝试寻找S2的起点
            for (j = 0; j < s2.length(); j++) {
                if (s2.charAt(j) != s1.charAt(i)) {
                    continue;
                }
                // 找到了公共开始的位置
                String temp = getLongest(s1, s2, i, j);
                if (temp.length() > longestStr.length()) {
                    longestStr = temp;
                }
            }
        }
        return longestStr;
    }

    private static String getLongest(String s1, String s2, int i, int j) {
        int start = i;
        // 最长子串的下一个索引
        int iend = i;
        while (i < s1.length() && j < s2.length() && s1.charAt(i++) == s2.charAt(j++)) {
            iend = i;
        }
        return s1.substring(start, iend);
    }
}
