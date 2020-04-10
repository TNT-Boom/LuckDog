package leetcode.zuochengyun.bindarysearch;

/*
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，
 * 如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，
 * 那么arr[i]是局部最小。 给定无序数组arr
 * ，已知arr中任意两个相邻的数都不相等，
 * 写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class PartSmall {
    public static void main(String[] args) {
        System.out.println(getLessIndex(new int[]{5, 4, 5, 8, 0, 10, 8, 6, 7, 10}));
    }

    public static int getLessIndex(int[] arr) {
        int n = arr.length;
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        }
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid - 1]) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid + 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;

    }
}
