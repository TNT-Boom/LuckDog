package leetcode.zuochengyun.bittech;

import java.util.*;

public class Compare
{
	public int getMax(int a, int b) {
        int c = a - b;
        int as = sign(a);
        int bs = sign(b);
        int cs = sign(c);
        int difabs = as ^ bs; // ��ͬΪ1����ͬΪ0
        int sameabs = flip(difabs);
        
        int returnA = difabs * as + sameabs * cs;
        int returnB = flip(returnA);
        return a * returnA + b*returnB; // returnA returnBһ��0��һ��1
    }

	public int sign(int n) // ��1 ��0 ��������0
	{
		return flip((n >> 31) & 1);
	}

	public int flip(int n)
	{
		return n ^ 1; // 1--> 0; 0-->1;
	}
}
