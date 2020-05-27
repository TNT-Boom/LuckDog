package leetcode.bittech;

/**
 * @author limingjian
 * @date 2020/4/12
 * 计算一个数中二进制1的个数
 * x & (x - 1)，本质就是将最右一个1变为0
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