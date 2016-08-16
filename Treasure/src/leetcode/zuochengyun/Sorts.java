package leetcode.zuochengyun;

public class Sorts
{
	public int[] bubbleSort(int[] A, int n)
	{
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				if (A[i] < A[j])
				{
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
		return A;
	}

	public int[] selectionSort(int[] A, int n)
	{
		for (int i = 0; i < n; i++)
		{
			int minIndex = i;
			for (int j = i + 1; j < n; j++)
			{
				if (A[j] < A[minIndex])
				{
					minIndex = j;
				}
			}
			int temp = A[minIndex];
			A[minIndex] = A[i];
			A[i] = temp;

		}
		return A;
	}

	public int[] insertionSort(int[] A, int n)
	{
		for (int i = 1; i < n; i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (A[j] < A[j - 1])
				{
					int temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;

				}
			}
		}
		return A;
	}

	public int[] mergeSort(int[] A, int n)
	{
		int[] tmpArray = new int[n];
		mergeSort(A, tmpArray, 0, n - 1);
		return A;
	}

	private void mergeSort(int[] array, int[] tmpArray, int left, int right)
	{
		if (left < right)
		{
			int midle = (right + left) / 2;
			mergeSort(array, tmpArray, left, midle);
			mergeSort(array, tmpArray, midle + 1, right);
			merger(array, tmpArray, left, midle + 1, right);
		}
	}

	private void merger(int[] array, int[] tmpArray, int leftPos, int rightPos, int rightEnd) // 对Arrat进行归并
	{
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd)
		{
			if (array[leftPos] < array[rightPos])
				tmpArray[tmpPos++] = array[leftPos++];
			else
				tmpArray[tmpPos++] = array[rightPos++];
		}
		while (leftPos <= leftEnd)
			tmpArray[tmpPos++] = array[leftPos++];
		while (rightPos <= rightEnd)
			tmpArray[tmpPos++] = array[rightPos++];

		// copy to a
		for (int i = 0; i < numElements; i++, rightEnd--)
			array[rightEnd] = tmpArray[rightEnd];
	}

	public int[] quickSort(int[] A, int n)
	{
		quickSort(A, 0, n - 1);
		return A;
	}

	private void quickSort(int[] array, int low, int high)
	{
		if (low < high)
		{
			int partIndex = partion(array, low, high);
			quickSort(array, low, partIndex);
			quickSort(array, partIndex + 1, high);
		}
	}

	private int partion(int[] array, int low, int high)
	{
		int temp = array[low];
		while (low < high)
		{
			while (low < high && array[high] >= temp)
				high--;
			if (low < high)
				array[low++] = array[high];
			while (low < high && array[low] <= temp)
				low++;
			if (low < high)
				array[high--] = array[low];
		}
		array[low] = temp;
		return low;

	}

	public int[] heapSort(int[] A, int n)
	{
		int[] heapArray = new int[n + 1];
		for (int i = 0; i < n; i++)
			inset(heapArray, A[i], i);
		for (int i = 1; i <= n; ++i)
		{
			A[i - 1] = deleteMin(heapArray, n + 1 - i);
		}
		return A;
	}

	// 下滤
	private void inset(int[] heapArray, int x, int currentSize) // 数组下标从1开始算
	{
		int hole = ++currentSize;
		for (; hole > 1 && x < heapArray[hole / 2]; hole = hole / 2) // hole向上滤
			heapArray[hole] = heapArray[hole / 2];
		heapArray[hole] = x;
	}

	private int deleteMin(int[] heapArray, int currentSize)
	{
		int temp = heapArray[1];
		percolateDown(heapArray, 1, currentSize--);
		return temp;
	}

	private void percolateDown(int[] heapArray, int hole, int currentSize)
	{
		int child = 0;
		int temp = heapArray[currentSize];
		for (; hole * 2 <= currentSize; hole = child)
		{
			child = hole * 2;
			if (child != currentSize && heapArray[child + 1] < heapArray[child]) // 选择较小的一个child
				child++;
			if (heapArray[child] < temp)
				heapArray[hole] = heapArray[child];
			else
				break;
		}
		heapArray[hole] = temp;
	}

	public int[] shellSort(int[] A, int n)
	{
		for (int gap = n / 2; gap > 0; gap /= 2) // 对于每一个Gap
		{
			for (int i = gap; i < n; ++i) // 对于每一组
			{
				int tmp = A[i];
				int j = i;
				for (; j >= gap && A[j - gap] >= tmp; j -= gap) // 比起大的，则向后移动
				{
					A[j] = A[j - gap];
				}
				A[j] = tmp;
			}
		}
		return A;
	}

	public int[] countingSort(int[] A, int n)
	{
		if (A == null)
			return A;
		int min = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++)
		{
			if (A[i] > max)
				max = A[i];
			if (A[i] < min)
				min = A[i];
		}

		int[] bucket = new int[max - min + 1];
		for (int i = 0; i < n; i++)
			bucket[A[i] - min]++;
		int index = 0;
		for (int i = 0; i < bucket.length; i++)
		{
			while (bucket[i]-- > 0)
				A[index++] = i + min;
		}
		return A;
	}

	public int[] sortElement(int[] A, int n, int k)
	{
		int[] heapArray = new int[k];
		int index = 0;
		for (int i = 0; i < n; i++)
		{
			if (i < k)
				inset(heapArray, A[i], i);
			else
			{
				A[index++] = deleteMin(heapArray, k);
				inset(heapArray, A[i], k - 1);
			}
		}
		while(index < n)
		{
			A[index++] = deleteMin(heapArray, k--);
		}
		return A;
	}
}
