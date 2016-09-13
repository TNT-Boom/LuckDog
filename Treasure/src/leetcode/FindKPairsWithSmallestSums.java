package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import base.BaseAlgorithm;

public class FindKPairsWithSmallestSums implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		List<int[]> result = kSmallestPairs(new int[] {1, 1, 2}, new int[] {1, 2, 3}, 3);
		for (int[] is : result)
		{
			System.out.println(is[0]);
			System.out.println(is[1]);
			System.out.println("----");
		}
	}
	private List<int[]> myKSmallestPairs(int[] nums1, int[] nums2, int k)
	{
		List<int[]> ret = new ArrayList<int[]>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
		{
			return ret;
		}
		
		int[] index = new int[nums1.length];// 下标表示num1，值表示num2的下标
		while(k-- > 0)
		{
			int minVal = Integer.MAX_VALUE;
			int in = -1;
			for(int i = 0; i < nums1.length; ++i)
			{
				if(index[i] >= nums2.length)
					continue;
				if(nums1[i] + nums2[index[i]] < minVal)
				{
					minVal = nums1[i] + nums2[index[i]];
					in = i;
				}
			}
			if(in == -1)
				break;
			ret.add(new int[]{nums1[in], nums2[index[in]]});
			index[in]++; // 防止下次仍然匹配到该对
		}
		return ret;
	}
	
	private List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k)
	{
		List<int[]> ret = new ArrayList<int[]>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
		{
			return ret;
		}

		int[] index = new int[nums1.length];
		while (k-- > 0)
		{
			int min_val = Integer.MAX_VALUE;
			int in = -1;
			for (int i = 0; i < nums1.length; i++)
			{
				if (index[i] >= nums2.length)
				{
					continue;
				}
				if (nums1[i] + nums2[index[i]] < min_val)
				{
					min_val = nums1[i] + nums2[index[i]];
					in = i;
				}
			}
			if (in == -1)
			{
				break;
			}
			int[] temp = {nums1[in], nums2[index[in]]};
			ret.add(temp);
			index[in]++;
		}
		return ret;
	}

	// max cal : k*k，但运算次数还是多。当然可以利用TreeSet去计算，但是仍然是潜在的排序
	private List<int[]> better(int[] nums1, int[] nums2, int k)
	{
		List<int[]> ret = new ArrayList<int[]>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return ret;
		for (int i = 0; i < Math.min(nums1.length, k); ++i)
		{
			for (int j = 0; j < Math.min(nums2.length, k); ++j)
			{
				ret.add(new int[] {nums1[i], nums2[j]});
			}
		}
		Collections.sort(ret, new SumComparator());
		return ret.subList(0, k > ret.size() ? ret.size() : k);
	}
	
	// 穷举，几乎没法用	
	private List<int[]> lowest(int[] nums1, int[] nums2, int k)
	{
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < nums1.length; ++i)
		{
			for (int j = 0; j < nums2.length; ++j)
			{
				result.add(new int[] {nums1[i], nums2[j]});
			}
		}
		Collections.sort(result, new SumComparator());
		return result.subList(0, k > result.size() ? result.size() : k);
	}

	private class SumComparator implements Comparator<int[]>
	{
		@Override
		public int compare(int[] o1, int[] o2)
		{
			return o1[0] + o1[1] - o2[0] - o2[1];
		}
	}
}
