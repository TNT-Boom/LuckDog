package leetcode.zuochengyun.sort;

/**
 * @author limingjian
 * @date 2020/4/11
 * https://blog.csdn.net/MoreWindows/article/details/6684558
 * 快速排序
 * 一定要从右侧开始遍历，如果在左侧，i停下来的地方一定大于base，结果把一个大于base的挪到了最左侧，违背了排序原则
 */
public class QuickSort implements ISort {

    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 1) {
            return array;
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partIndex = partition(array, left, right);
            quickSort(array, left, partIndex - 1);
            quickSort(array, partIndex + 1, right);
        }
    }

    public int partition(int[] array, int left, int right) {
        int base = array[left];
        while (left < right) {
            while (left < right && array[right] >= base) {
                right--;
            }

            if (left < right) {
                array[left] = array[right];
                left++;
            }

            while (left < right && array[left] <= base) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }

        array[left] = base;
        return left;
    }
}
