package leetcode.linkedlist;

/**
 * O(1)ʱ��ɾ��һ���ڵ�
 */
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
