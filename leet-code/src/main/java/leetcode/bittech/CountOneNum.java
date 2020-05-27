package leetcode.bittech;

/**
 * @author limingjian
 * @date 2020/4/12
 * ����һ�����ж�����1�ĸ���
 * x & (x - 1)�����ʾ��ǽ�����һ��1��Ϊ0
 */
public class CountOneNum {

    public int count(int x) {
        int count = 0;
        while (x != 0) {
            x = x & (x - 1);
            count++;
        }

        return count;
    }
}