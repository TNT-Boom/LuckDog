package leetcode.netease;

/*
 * 平方串的个数
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    static Set<String> results = new HashSet<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        Set<String> result = new HashSet();
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (Is(input.substring(i, j + 1))) {
                    result.add(input.substring(i, j + 1));
                }
            }
        }
        System.out.println(result.size());
    }

    public static boolean Is(String s) {
        if (results.contains(s)) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        int mid = s.length() / 2;
        if (s.substring(0, mid).equals(s.substring(mid))) {
            results.add(s);
            return true;
        }
        return false;
    }
}
