package leetcode.zuochengyun;

public class RotateWords
{
	public boolean chkRotation(String A, int lena, String B, int lenb)
	{
		if(lena != lenb)
			return false;
		if((A + A).contains(B) || (B + B).contains(A))
			return true;
		return false;
	}
}
