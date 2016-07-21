package leetcode;

import java.util.HashMap;
import java.util.Map;

import base.BaseAlgorithm;

public class TwoSum implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		int[] nums = new int[] {0,4,3,0};
		int target = 0;
		System.out.println(listTwoSum(nums, target)[0]);
	}

	/*
	 * 最基本的遍历
	 */
	private int[] listTwoSum(int[] nums, int target)
	{
		int[] result = new int[2];
		Map<Integer, Integer> numsCatche = new HashMap<>();
		for(int i = 0; i < nums.length; ++i)
		{
			if(!numsCatche.containsKey(nums[i]))
			{
				numsCatche.put(nums[i], i);
			}
			if(numsCatche.containsKey(target - nums[i]) && numsCatche.get(target - nums[i]) < i)
			{
				result[0] = i; // 由于第二次重复的数字不会放进去，所以只能直接去当前的i的值比较靠谱
				result[1] = numsCatche.get(target - nums[i]);
				return result;
			}
		}
		return result;
	}

	/*
	 * 最基本的遍历
	 */
	private int[] baseTwoSum(int[] nums, int target)
	{
		int[] result = new int[2];
		for (int i = 0; i < nums.length; ++i)
		{
			for (int j = i + 1; j < nums.length; ++j)
			{
				if (nums[i] + nums[j] == target)
				{
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
}
