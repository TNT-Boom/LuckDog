package leetcode.zuochengyun.pailiezuhe;

import java.util.Arrays;

/**
 * @author limingjian
 * @date 2020/4/13
 *
 */
public class AllPailie {
    /**
     * �㷨˼·��
     * (1)n��Ԫ�ص�ȫ���� = ��n - 1��Ԫ�ص�ȫ���У� + ����һ��Ԫ����Ϊǰ׺����
     * (2)���ڣ����ֻ��һ��Ԫ�ص�ȫ���У���˵���Ѿ����꣬��������飻
     * (3)���Ͻ�ÿ��Ԫ�ط�����һ��Ԫ�أ�Ȼ�����Ԫ����Ϊǰ׺����������Ԫ�ؼ���ȫ���У��ȵ����ڣ����ڳ�ȥ����Ҫ��ԭ���飻
     * @param chs
     * @param start
     */
    public void Permutation(char chs[], int start) {
        if (start == chs.length - 1) {
            System.out.println(Arrays.toString(chs));
            //����Ѿ�������������һ��Ԫ�أ�ǰ���Ԫ���Ѿ��źã������
        }
        for (int i = start; i <= chs.length - 1; i++) {
            if (needSwap(chs, start, i)) {
                // ���Ͻ�ÿ��Ԫ�طŵ���һ��Ԫ��
                Swap(chs, i, start);
                Permutation(chs, start + 1);
                Swap(chs, i, start);
                //���������򷵻غ�Ҫ����һ��Ԫ�ؽ���������
                //����������������������˵��һ��1��2��������һ��λ��Ϊ2�����������򷵻غ��������1��2
                //���������ڶ��ν�����ʱ��ͻὫ2��3��������˱��뽫1��2����ʹ1�����ڵ�һ��λ��
            }
        }
    }

    public void Swap(char chs[], int i, int j) {
        char temp;
        temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    private Boolean needSwap(char chs[], int i, int j) {
        // �Լ����Լ�������������еݹ��ӡ
        if (i == j) {
            return true;
        }

        return chs[i] != chs[j];
    }
}