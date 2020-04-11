package leetcode.linkedlist;

import org.junit.Test;

/**
 * @author limingjian
 * @date 2020/4/11
 *
 */
public class LinkedListTest {

    @Test
    public void testReverseLinklistGroup(){

        ListNode head = buildLinklist();
        ReverseLinklistGroup reverseLinklistGroup = new ReverseLinklistGroup();
        ListNode reverse = reverseLinklistGroup.groupReverseFromTail(head, 3);
        System.out.println(reverse);

    }

    private ListNode buildLinklist() {
        ListNode head = new ListNode(0);
        ListNode node = new ListNode(1);
        head.next = node;
        for (int i = 2; i < 10; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head;
    }
}