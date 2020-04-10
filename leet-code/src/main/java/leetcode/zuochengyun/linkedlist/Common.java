package leetcode.zuochengyun.linkedlist;

import java.util.ArrayList;

/*
 * �����������������������о����ظ�Ԫ�ء������һ����Ч���㷨����ӡ��������Ĺ���ֵ���֡�
�������������ͷָ��headA��headB���뷵��һ��vector��Ԫ��Ϊ��������Ĺ������֡��뱣֤����������������������Ԫ�ظ�����С�ڵ���500����֤һ���й���ֵ
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
