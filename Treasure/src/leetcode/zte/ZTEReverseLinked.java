package leetcode.zte;

import leetcode.zuochengyun.linkedlist.ListNode;

public class ZTEReverseLinked
{
	public static void main(String[] args)
	{
		ListNode head = buildList();
		ListNode reverseNode = reverseNode(head);
		
		while(reverseNode != null)
		{
			System.out.println(reverseNode.val);
			reverseNode = reverseNode.next;
		}
	}
	

	public static ListNode buildList()
	{
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);

		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		return head;
	}

	public static ListNode reverseNode(ListNode head)
	{
		if(head == null)
			return null;
		
		ListNode p = head;
		ListNode q = head.next;
		
		head.next = null; // 重要，作为尾巴，需要清空
		while(q != null)
		{
			ListNode temp = q.next;
			q.next = p;
			p = q;
			q = temp;
		}
		return p;	
	}
}
