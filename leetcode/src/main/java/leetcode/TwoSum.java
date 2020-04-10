package leetcode;

import base.BaseAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 在数组中找给定的两个数，使得和为target的值
 * @author lmj
 */
public class TwoSum implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		int[] nums = new int[] {0,4,3,0};
		int target = 0;
		System.out.println(twoSum(nums, target)[0]);
	}


	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
		for(int i = 0; i < nums.length; i++){
			int num2 = target - nums[i];
			if(numsMap.containsKey(num2)){
				result[0] = i;
				result[1] = numsMap.get(num2);
				return result;
			}
			numsMap.put(nums[i], i);
		}
		return result;
	}

	/*
	 * ������ı���
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
