package leetcode.zuochengyun.stackqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class TwoStack
{
	public int[] twoStack(int[] ope, int n)
	{
		if(ope == null)
			return null;
		int count = 0;
		for(int i = 0; i < n; ++i)
			if(ope[i] == 0)
				count++;
		int[] result = new int[count];
		StackQueue stackQueue = new StackQueue();
		for(int i = 0,resultIndex = 0; i < n; i++)
		{
			int curr = ope[i];
			if(curr > 0)
				stackQueue.push(curr);
			if(curr == 0)
				result[resultIndex++] = stackQueue.pop();
		}
		return result;
	}

	private class StackQueue
	{
		Stack<Integer> pushStack;
		Stack<Integer> popStack;

		public StackQueue()
		{
			pushStack = new Stack<>();
			popStack = new Stack<>();
		}

		public void push(Integer node)
		{
			pushStack.push(node);
		}

		public Integer pop()
		{
			if (popStack.isEmpty())
			{
				transfer();
			}
			return popStack.pop();
		}

		private void transfer()
		{
			while (!pushStack.isEmpty())
			{
				popStack.push(pushStack.pop());
			}
		}
	}
}
