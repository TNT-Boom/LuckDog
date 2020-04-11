package leetcode.linkedlist;

/**
 * @author limingjian
 * @date 2020/4/11
 * ��ת����
 * ��Ҫ�������ڵ㣬��ת��ǰ������ʱ��Ҫ��ס���������Ӷ�ƽ������Ųָ���ʱ���ܹ�������ȥ
 */
public class ReverseLinklist {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = pre.next;
        pre.next = null;
        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            // ����Ų�ڵ�
            pre = curr;
            curr = tmp;
        }

        return pre;
    }
}