package leetcode.linkedlist;

/**
 * @author limingjian
 * @date 2020/4/11
 * 翻转链表
 * 主要是两个节点，翻转当前两个的时候，要记住第三个，从而平滑往后挪指针的时候，能够进行下去
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
            // 往后挪节点
            pre = curr;
            curr = tmp;
        }

        return pre;
    }
}