package leetcode.zuochengyun.bindarysearch;

/*
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，
 * 有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
 * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
给定数组arr及它的大小n，请返回最小值。
测试样例：
[4,1,2,3,3],5
返回：1
 */
public class MinValue {
    public static void main(String[] args) {
        System.out.println(getMin(new int[]{5, 6, 7, 1, 2, 3, 4}, 7));
    }

    public static int getMin(int[] arr, int n) {
        if (arr == null) {
            return Integer.MIN_VALUE;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (left == right - 1) {
                break;
            }
            int mid = left + (right - left) / 2;
            if (arr[left] < arr[right]) // 表示处于非循环段
            {
                return arr[left];
            } else // 其中必有部分或全部的循环段，例如   5 6 7 1 2 3 4
            {
                // 分几种情况
                if (arr[left] > arr[mid]) // 表示 mid处于循环部分，那么m右侧肯定比m大
                {
                    right = mid;
                } else if (arr[mid] > arr[right]) // 由于其中肯定有循环部分，arr[m] > arr[right]， 所以小的在 m-r之间
                {
                    left = mid;
                } else // aL >= aR, aL <= aM <= aR ==> aL = aM = aR。只能遍历了
                {
                    int min = Integer.MAX_VALUE;
                    for (int i = left; i <= right; i++) {
                        if (arr[i] < min) {
                            min = arr[i];
                        }
                    }
                    return min;
                }
            }
        }
        return arr[left] > arr[right] ? arr[right] : arr[left]; // 重要

    }

}
