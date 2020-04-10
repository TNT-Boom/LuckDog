package leetcode.zuochengyun.linkedlist;

import java.util.ArrayList;

/*
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 */
public class Common
{
	 public int[] findCommonParts(ListNode headA, ListNode headB) {
		 if(headA == null || headB == null)
	            return null;
	        ArrayList<Integer> result = new ArrayList<>();
	        while(headA != null && headB != null)
	        {
	            if(headA.val == headB.val)
	            {
	               	result.add(headA.val);
	               	headA = headA.next;
	               	headB = headB.next;
	            }
	        	else if(headA.val < headB.val && headA != null)
	                headA = headA.next;
	            else if(headB.val < headA.val && headB != null)
	                headB = headB.next;
	            else{}
	        }
	        int[] resultArray = new int[result.size()];
	        for(int i=0; i < result.size(); i++)
	            resultArray[i] = result.get(i);
	        return resultArray;
	 }
}
