package leetcode.sort;

/**
 * @author limingjian
 * @date 2020/4/11
 * 冒泡排序
 */
public class BubbleSort implements ISort {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}