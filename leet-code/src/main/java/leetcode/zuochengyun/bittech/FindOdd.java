package leetcode.zuochengyun.bittech;

/*
 * ��һ����������A������ֻ��һ���������������Σ�����������������ż���Σ����ӡ�������Ҫ��ʱ�临�Ӷ�ΪO(N)������ռ临�Ӷ�ΪO(1)��
������������A�����Ĵ�Сn���뷵����Ŀ�������֡�
 */
public class FindOdd {
    public int findOdd(int[] A, int n) {
        int ori = 0;

        for (int i = 0; i < n; i++) {
            ori ^= A[i];
        }
        return ori;
    }
}
