package leetcode.linkedlist;

/**
 * @author lmj
 */
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {

        if (A == null || A.length == 0) {
            return null;
        }

        ListNode head = new ListNode(A[0]);
        ListNode p = head;
        for (int i = 1; i < A.length; i++) {
            p.next = new ListNode(A[i]);
            p = p.next;
        }

        p = head;
        ListNode q = head.next;

        while (q != null) {
            if (val >= p.val && val <= q.val) {
                break;
            }
            p = q;
            q = q.next;
        }

        ListNode insertNode = new ListNode(val);
        p.next = insertNode;
        insertNode.next = q;

        if (val < head.val) {
            return insertNode;
        } else {
            return head;
        }
    }
}
