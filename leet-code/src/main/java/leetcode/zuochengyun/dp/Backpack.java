package leetcode.zuochengyun.dp;

/*
 * ��������
 * 
 * һ��������һ���ĳ���cap����N����Ʒ��ÿ�������Լ��ļ�ֵ����¼������v�У�Ҳ�����Լ�����������¼������w�У�ÿ����Ʒֻ��ѡ��Ҫװ�뱳�����ǲ�װ�뱳����Ҫ���ڲ������������ص�ǰ���£�ѡ����Ʒ���ܼ�ֵ���
������Ʒ������w��ֵv����Ʒ��n�ͳ���cap���뷵������ܼ�ֵ��
����������
[1,2,3],[1,2,3],3,6
���أ�6
 */
public class Backpack {
    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{1, 2, 3};
        System.out.println(maxValue(w, v, 3, 6));
    }

    public static int maxValue(int[] w, int[] v, int n, int cap) {
        int[][] result = new int[n + 1][cap + 1]; // ��ʾ ǰi����Ʒ����������Y������ֵ
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (i == 1 && v[i - 1] <= j) {
                    result[i][j] = v[i - 1];
                    continue;
                }
                int excludeI = result[i - 1][j];

                int includeI = j - w[i - 1] >= 0 ? result[i - 1][j - w[i - 1]] + v[i - 1] : 0;
                result[i][j] = excludeI > includeI ? excludeI : includeI;

            }
        }
        return result[n][cap];
    }
}
