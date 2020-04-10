package leetcode.zuochengyun.bittech;

import java.util.*;

public class Compare
{
	public int getMax(int a, int b) {
        int c = a - b;
        int as = sign(a);
        int bs = sign(b);
        int cs = sign(c);
        int difabs = as ^ bs; // 不同为1，相同为0
        int sameabs = flip(difabs);
        
        int returnA = difabs * as + sameabs * cs;
        int returnB = flip(returnA);
        return a * returnA + b*returnB; // returnA returnB一个0，一个1
    }

	public int sign(int n) // 正1 负0 ，正包括0
	{
		return flip((n >> 31) & 1);
	}

	public int flip(int n)
	{
		return n ^ 1; // 1--> 0; 0-->1;
	}
}
