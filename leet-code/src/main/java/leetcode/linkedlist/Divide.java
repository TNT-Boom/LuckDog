package leetcode.linkedlist;

public class Divide {

    public ListNode listDivide(ListNode head, int pivot) {
        // small head
        ListNode sH = null;
        // small tail
        ListNode sT = null;
        // big head
        ListNode bH = null;
        // big tail
        ListNode bT = null;
        // save next node
        ListNode next;
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val <= pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = bH;
        }
        return sH != null ? sH : bH;
    }
}
