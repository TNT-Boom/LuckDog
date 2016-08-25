package leetcode.zuochengyun.stringtopic;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubstring
{
	public static void main(String[] args)
	{
		System.out.println(longestSubstring("limingjian",10));
	}
	public static int longestSubstring(String A, int n)
	{
		 if (A == null || n == 0) {
	            return 0;
	        }
	        char[] chas = A.toCharArray();
	        int[] map = new int[256];
	        for (int i = 0; i < 256; i++) {
	            map[i] = -1;
	        }
	        int len = 0;
	        int pre = -1;
	        int cur = 0;
	        for (int i = 0; i < n; i++) {
	            pre = Math.max(pre, map[chas[i]]);
	            cur = i - pre;
	            len = Math.max(len, cur);
	            map[chas[i]] = i;
	        }
	        return len;
	}
}
