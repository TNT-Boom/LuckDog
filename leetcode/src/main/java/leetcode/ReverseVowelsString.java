package leetcode;

import base.BaseAlgorithm;

public class ReverseVowelsString implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		System.out.println(reverseVowels("hellohello"));
	}
	
	private String reverseVowels(String s)
	{
		char[] source = s.toCharArray();
		int leftIndex = 0;
		int rightIndex = source.length - 1;
		while(leftIndex < rightIndex)
		{
			while(!isVowels(source[leftIndex]) && leftIndex < rightIndex)
			{
				++leftIndex;
			}
			while(!isVowels(source[rightIndex]) && rightIndex > leftIndex)
			{
				--rightIndex;
			}
			
			char temp = source[leftIndex];
			source[leftIndex] = source[rightIndex];
			source[rightIndex] = temp;
			
			++leftIndex;
			--rightIndex;
		}
		return String.valueOf(source);
	}
	
	private boolean isVowels(char c)
	{
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
			c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
		{
			return true;
		}
		return false;
	}
}
