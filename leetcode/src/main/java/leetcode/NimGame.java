package leetcode;

import base.BaseAlgorithm;

public class NimGame implements BaseAlgorithm
{
	
	@Override
	public void runDemo()
	{
		System.out.println(canWinNim(100));
	}
	/*A 先， B 后
	 * 首先考虑先手必输
	 * 若有m + 1 个球，则无论A摸几个，机智的B总能取光剩下的。
	 * 考虑(m + 1 )k，无论A第一次摸几个，机智的B总能造成 (m + 1)(k -1)的情况，然后轮到A
	 * 如此往复，则总能到m + 1的情况让A摸，则最终，A必输
	 *
	 * 下面考虑必赢
	 * 若有(m + 1)k + s 个球，其中 0 < s <= m
	 * A先摸1个，然后造成 (m + 1)(k - 1) + m + s的情况给B
	 * 轮到B，无论B摸几个，A总能造成(m + 1)(k - 2) + m + s的情况给B
	 * 如此往复，最后成了 m + s 给B摸，无论B摸什么，A总能 赢。
	 */
	public boolean canWinNim(int n)
	{
		return n % (3 + 1) != 0;
	}
}
