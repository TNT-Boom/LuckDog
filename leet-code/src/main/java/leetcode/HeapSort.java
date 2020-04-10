package leetcode;

public class HeapSort {
    public static void main(String[] args) {
        int[] source = new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        int[] heapArray = new int[14];
        for (int i = 0; i < source.length; i++) {
            inset(heapArray, source[i], i);
        }
        for (int i = 1; i <= 13; i++) {
            source[i - 1] = deleteMin(heapArray, 14 - i);
        }
        for (int i = 0; i < source.length; i++) {
            System.out.println(source[i]);
        }

    }

    // 涓嬫护
    private static void inset(int[] heapArray, int x, int currentSize) // 鏁扮粍涓嬫爣浠�1寮�濮嬬畻
    {
        int hole = ++currentSize;
        for (; hole > 1 && x < heapArray[hole / 2]; hole = hole / 2) // hole鍚戜笂婊�
        {
            heapArray[hole] = heapArray[hole / 2];
        }
        heapArray[hole] = x;
    }

    private static int deleteMin(int[] heapArray, int currentSize) {
        int temp = heapArray[1];
        percolateDown(heapArray, 1, currentSize--);
        return temp;
    }

    private static void percolateDown(int[] heapArray, int hole, int currentSize) {
        int child = 0;
        int temp = heapArray[currentSize];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && heapArray[child + 1] < heapArray[child]) //閫夋嫨杈冨皬鐨勪竴涓猚hild
            {
                child++;
            }
            if (heapArray[child] < temp) {
                heapArray[hole] = heapArray[child];
            } else {
                break;
            }
        }
        heapArray[hole] = temp;
    }
}
