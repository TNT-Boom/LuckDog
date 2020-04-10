package leetcode.zuochengyun.linkedlist;

public class Remove {
    public boolean removeNode(ListNode pNode) {
        if (pNode.next == null) {
            return false;
        }
        ListNode next = pNode.next;
        pNode.val = next.val;
        pNode.next = next.next;
        return true;
    }
}
