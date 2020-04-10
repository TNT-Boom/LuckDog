package leetcode.zuochengyun.bittech;

/*
 * ����һ����������arr�������������������������Σ�����������������ż���Σ��ҵ�����������Ҫ��ʱ�临�Ӷ�ΪO(N)������ռ临�Ӷ�ΪO(1)��
����һ����������arr�����Ĵ�Сn���뷵��һ�����飬��������Ԫ��Ϊ���������������ε�Ԫ��,�뽫���ǰ���С�������С�
 */
public class FindOddTwo {
    public int[] findOdd(int[] A, int n) {
        int ori = 0;

        for (int i = 0; i < n; i++) {
            ori ^= A[i];
        }
        int k = 0;
        for (k = 1; k < 32; k++) {
            if (isOne(ori, k)) {
                break;
            }
        }

        // �´��� KλΪ1�������������������һ�����ˡ�
        int ori2 = 0;
        for (int i = 0; i < n; i++) {
            if (isOne(A[i], k)) {
                ori2 ^= A[i];
            }
        }
        ori = ori ^ ori2;

        int[] result = new int[2];
        result[0] = ori > ori2 ? ori2 : ori;
        result[1] = ori > ori2 ? ori : ori2;
        return result;
    }

    // 31 30 ....1 λ �� ��kλ�Ƿ�Ϊ1
    private boolean isOne(int n, int k) {
        int result = (n >>> k) & 1;
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}
