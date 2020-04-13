package leetcode.zuochengyun.pailiezuhe;

import java.util.Arrays;

/**
 * @author limingjian
 * @date 2020/4/13
 *
 */
public class AllPailie {
    /**
     * 算法思路：
     * (1)n个元素的全排列 = （n - 1个元素的全排列） + （另一个元素作为前缀）；
     * (2)出口：如果只有一个元素的全排列，则说明已经排完，则输出数组；
     * (3)不断将每个元素放作第一个元素，然后将这个元素作为前缀，并将其余元素继续全排列，等到出口，出口出去后还需要还原数组；
     * @param chs
     * @param start
     */
    public void Permutation(char chs[], int start) {
        if (start == chs.length - 1) {
            System.out.println(Arrays.toString(chs));
            //如果已经到了数组的最后一个元素，前面的元素已经排好，输出。
        }
        for (int i = start; i <= chs.length - 1; i++) {
            if (needSwap(chs, start, i)) {
                // 不断将每个元素放到第一个元素
                Swap(chs, i, start);
                Permutation(chs, start + 1);
                Swap(chs, i, start);
                //子数组排序返回后要将第一个元素交换回来。
                //如果不交换回来会出错，比如说第一次1、2交换，第一个位置为2，子数组排序返回后如果不将1、2
                //交换回来第二次交换的时候就会将2、3交换，因此必须将1、2交换使1还是在第一个位置
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
        // 自己和自己交换，必须进行递归打印
        if (i == j) {
            return true;
        }

        return chs[i] != chs[j];
    }
}