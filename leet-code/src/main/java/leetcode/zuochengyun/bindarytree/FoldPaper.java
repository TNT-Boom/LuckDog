package leetcode.zuochengyun.bindarytree;

/*
 * 折纸，打印折痕方向
 */

import java.util.ArrayList;
import java.util.List;

public class FoldPaper {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(foldPaper(4));
    }

    public static String foldPaper(int n) {
        fold(1, true, n);
        return result.toString();
    }

    // 第二个参数表示当前的值
    private static void fold(int i, boolean down, int n) {
        if (i > n) {
            return;
        }
        fold(i + 1, true, n);
        result.add(down ? "down" : "up");
        fold(i + 1, false, n);

    }

    /*用数组存储结果*/
    public static String ArrayfoldPaper(int n) {
        int nodeCount = (int) (Math.pow(2, n) - 1 + 1); // 0位置置空
        int[] result = new int[nodeCount];

        result[1] = 0; // 0代表下， 1代表上
        for (int i = 1; i < nodeCount + 1; i++) {
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;
            if (leftIndex > nodeCount || rightIndex > nodeCount) {
                break;
            }
            result[leftIndex] = 0;
            result[rightIndex] = 1;
        }
        return "";
    }

}
