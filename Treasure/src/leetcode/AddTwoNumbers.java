package leetcode;

import base.BaseAlgorithm;

public class AddTwoNumbers implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		ListNode one = new ListNode(9);
		ListNode eight = new ListNode(9);
		ListNode zero = new ListNode(1);
		one.next = eight;

		System.out.println(addTwoNumbers(zero, one).val);
	}

	private ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode currl1 = l1;
		ListNode currl2 = l2;
		int up = 0;
		ListNode result = null, p = null, q = null;
		while (currl1 != null && currl2 != null)
		{
			int temp = (currl1.val + currl2.val + up);
			
			if(result == null)
			{
				result = new ListNode(temp % 10);
				q = result;
			}
			else
			{
				p = new ListNode(temp % 10);
				q.next = p;
				q = p;
				p = p.next;
			}
			up = temp / 10;
			
			currl1 = currl1.next;
			currl2 = currl2.next;
		}
		
		while(currl1 != null)
		{
			int temp = currl1.val + up;
			p = new ListNode(temp % 10);
			q.next = p;
			q = p;
			p = p.next;
			up = temp / 10;
			currl1 = currl1.next;
		}
		
		while(currl2 != null)
		{
			int temp = currl2.val + up;
			p = new ListNode(temp % 10);
			q.next = p;
			q = p;
			p = p.next;
			up = temp / 10;
			currl2 = currl2.next;
		}
		
		if(up != 0)
		{
			p = new ListNode(up);
			q.next = p;
		}
		
		return result;
	}

	private class ListNode
	{
		public int val;
		public ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}
}
