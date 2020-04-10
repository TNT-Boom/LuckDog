package leetcode.zte;

import java.util.HashMap;
import java.util.Map;

public class ZTECommonCount {
    public static void main(String[] args) {
        diffNums(new int[]{4, 3, 5, 6}, new int[]{3, 2, 1, 6, 3, 9, 8, 13});
    }

    private static void diffNums(int[] a, int[] b) {
        if (a == null && b == null) {
            System.out.println(0);
        }
        if (a == null && b != null) {
            System.out.println(b.length);
        }
        if (a != null && b == null) {
            System.out.println(a.length);
        }

        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (numCount.containsKey(a[i])) {
                numCount.put(a[i], numCount.get(a[i]) + 1);
            } else {
                numCount.put(a[i], 1);
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (numCount.containsKey(b[i])) {
                numCount.put(b[i], numCount.get(b[i]) + 1);
            } else {
                numCount.put(b[i], 1);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() == 1) {
                ++count;
            }
        }
        System.out.println(count);
    }
}
