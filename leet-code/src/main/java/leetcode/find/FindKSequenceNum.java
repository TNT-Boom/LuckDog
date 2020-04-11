package leetcode.find;

/**
 * @author limingjian
 * @date 2020/4/11
 *  寻找第k大的数, k从1 开始
 */
public class FindKSequenceNum {

    public Integer findKSeqNum(int[] array, int left, int right , int k) {
        if (array == null || array.length < k) {
            return null;
        }

        int partIndex = partition(array, left, right);
        if (partIndex - left == k - 1) {
            return array[partIndex];
        }

        int leftLen = partIndex - left;
        int rightLen = array.length - partIndex - 1;

        if (leftLen >= k) {
            return findKSeqNum(array, left, partIndex - 1, k);
        } else {
            return findKSeqNum(array, partIndex + 1, right, k - leftLen - 1);
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