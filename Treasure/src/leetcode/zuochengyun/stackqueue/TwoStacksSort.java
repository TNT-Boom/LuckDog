package leetcode.zuochengyun.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

public class TwoStacksSort
{
	public ArrayList<Integer> twoStacksSort(int[] numbers)
	{
		if(numbers == null)
			return null;
		Stack<Integer> sortStack = new Stack<>();
		Stack<Integer> source = new Stack<>();
		for(int i = 0; i < numbers.length; i++)
		{
			source.push(numbers[i]);
		}
		
		while(!source.isEmpty())
		{
			int sourceTop = source.pop();
			
			while(!sortStack.isEmpty() && sourceTop < sortStack.peek())
			{
				source.push(sortStack.pop());
			}
			sortStack.push(sourceTop);
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		while(!sortStack.isEmpty())
		{
			result.add(sortStack.pop());
		}
		return result;
	}
	
	
}
