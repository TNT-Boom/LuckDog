package leetcode.linkedlist;

/**
 * @author limingjian
 * @date 2020/4/11
 * 从尾部分组逆序链表
 * 给定一个单链表的头节点 head,实现一个调整单链表的函数，使得每K个节点之间为一组进行逆序。
 * （不能使用队列或者栈作为辅助）
 */
public class ReverseLinklistGroup {
    public ListNode groupReverseFromTail(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastRevLast = new ListNode(-1);
        lastRevLast.next = head;
        ListNode nextGroupFirst = head;
        int i = 0;



        while (nextGroupFirst != null) {

            ListNode pre = nextGroupFirst;
            ListNode curr = pre.next;

            int stepCount = k;
            // 开始寻找本组最后一个节点，找k步
            while (nextGroupFirst != null && stepCount > 0) {
                stepCount--;
                nextGroupFirst = nextGroupFirst.next;
            }
            // 当前组不够 k 个
            if (stepCount > 0) {
                break;
            }

            while (curr != nextGroupFirst) {
                // TODO 翻转
                ListNode tmp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = tmp;
            }
            ListNode tmp = lastRevLast.next;
            lastRevLast.next = pre;
            lastRevLast = tmp;
            // 重要，用来保存翻转下一组时的 翻转前第一个节点，即翻转后的最后一个节点
            lastRevLast.next = nextGroupFirst;
            if (i == 0) {
                head = pre;
            }
            i++;
        }

        return head;
    }
}