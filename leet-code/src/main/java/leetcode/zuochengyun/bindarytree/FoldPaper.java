package leetcode.zuochengyun.bindarytree;

/*
 * ��ֽ����ӡ�ۺ۷���
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

    // �ڶ���������ʾ��ǰ��ֵ
    private static void fold(int i, boolean down, int n) {
        if (i > n) {
            return;
        }
        fold(i + 1, true, n);
        result.add(down ? "down" : "up");
        fold(i + 1, false, n);

    }

    /*������洢���*/
    public static String ArrayfoldPaper(int n) {
        int nodeCount = (int) (Math.pow(2, n) - 1 + 1); // 0λ���ÿ�
        int[] result = new int[nodeCount];

        result[1] = 0; // 0�����£� 1������
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
