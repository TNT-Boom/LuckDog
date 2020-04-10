package leetcode.jingdong;

/*
 * 着第二头熊重复这一过程，即先均分n份，扔掉一个然后拿走一份，以此类推直到最后一头熊都是这样(最后一头熊扔掉后可以拿走0个，也算是n份均分)。问最初这堆苹果最少有多少个。
给定一个整数n,表示熊的个数，返回最初的苹果数。保证有解。
测试样例：
2
返回：3
 */
public class Apples {
    public int getInitial(int n) {
        if (n < 0) {
            return 0;
        }
        int total = 0; // 遍历找到总数
        while (true) {
            if (total >= Integer.MAX_VALUE) {
                return 0;
            }
            total++;
            int bearCount = n;
            while (bearCount > 0) {
                if ((total - 1) % n == 0) {
                    total = total - total / n - 1;
                    bearCount--;
                } else {
                    break;
                }
            }
            if (bearCount == 0) {
                return total;
            }

        }
    }
}
