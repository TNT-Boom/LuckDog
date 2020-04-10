package leetcode;

import base.BaseAlgorithm;

/**
 * Input: 123
 * Output: 321
 *
 * Input: -123
 * Output: -321
 *
 * Input: 120
 * Output: 21
 * @see https://leetcode.com/problems/reverse-integer/description/
 * @author lmj
 * @since 2018/5/30
 **/
public class ReverseInteger implements BaseAlgorithm {
	@Override
	public void runDemo() {
	}

	public static int reverse(int x) {
		if(x == Integer.MIN_VALUE){
			return 0;
		}
		int sign = 1;
		if(x < 0){
			sign = -1;
			x = Integer.MAX_VALUE +Integer.MAX_VALUE - x + 2;
		}
		// 判断时，加不加Increment并不影响值，是因为Intteger.MAX_VALUE的乘以10，
		// 最后可以加到0-7，但出现结果恰好溢出的时候，尾数只能是1 2
		int result = 0;
		while(x != 0){
			if(Integer.MAX_VALUE / 10 < result){
				return 0;
			}
			int increment = x % 10;
			result *= 10;
			result += increment;
			x = x / 10;
		}
		return result * sign;
	}

	public static void main(String[] args){
		System.out.println(Integer.MAX_VALUE);
		int src = -2147483647;
		System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE  - src + 2);
		System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE + 2 +  2);
		System.out.println(Integer.MAX_VALUE  + Integer.MAX_VALUE - 3 + 2);
		System.out.println(Integer.MAX_VALUE + 4);
		//System.out.println(reverse(-));
	}
}
