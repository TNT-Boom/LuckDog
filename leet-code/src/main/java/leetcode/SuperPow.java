package leetcode;

import base.BaseAlgorithm;

public class SuperPow implements BaseAlgorithm {
    @Override
    public void runDemo() {
        superPow(10, new int[]{1, 2, 3, 4, 5});
    }

    private final static int q = 5;

    //(a * b) % c = ((a % c) * b) % c
    public int intPow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int res = 1;
        while (b-- > 0) {
            res = (res * a) % 1337;
        }
        return res;
    }

    // (a ^ b) % c = ((a % c) ^ b) % c

    public int superPow(int a, int[] b) {
        a = a % 1337; // �˴���������Ĺ�ʽ��Сa����������� ����ݹ�Ҳ���õ�����Ĺ�ʽ
        int index = 0;
        int res = 1;
        while (index < b.length) {
            int currPow = intPow(a, b[index]);
            res = intPow(res, 10); //  (a ^ 5) ^ 10 % 3 = (((a ^ 5) % 3 ) ^ 10 ) % 3
            res = (res * currPow) % 1337; // ��һ���Ľ��10�������࣬ �ٳ��Ա��ν����������. �˴��ǳ˷�չ��������intPow
            ++index;
        }
        return res;
    }
}
