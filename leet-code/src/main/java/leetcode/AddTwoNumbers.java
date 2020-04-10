package leetcode;

import base.BaseAlgorithm;

public class AddTwoNumbers implements BaseAlgorithm {
    @Override
    public void runDemo() {
        ListNodes one = new ListNodes(9);
        ListNodes eight = new ListNodes(9);
        ListNodes zero = new ListNodes(1);
        one.next = eight;

        System.out.println(addTwoNumbers(zero, one).val);
    }

    private ListNodes addTwoNumbers(ListNodes l1, ListNodes l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNodes currl1 = l1;
        ListNodes currl2 = l2;
        int up = 0;
        ListNodes result = null, p = null, q = null;
        while (currl1 != null && currl2 != null) {
            int temp = (currl1.val + currl2.val + up);

            if (result == null) {
                result = new ListNodes(temp % 10);
                q = result;
            } else {
                p = new ListNodes(temp % 10);
                q.next = p;
                q = p;
                p = p.next;
            }
            up = temp / 10;

            currl1 = currl1.next;
            currl2 = currl2.next;
        }

        while (currl1 != null) {
            int temp = currl1.val + up;
            p = new ListNodes(temp % 10);
            q.next = p;
            q = p;
            p = p.next;
            up = temp / 10;
            currl1 = currl1.next;
        }

        while (currl2 != null) {
            int temp = currl2.val + up;
            p = new ListNodes(temp % 10);
            q.next = p;
            q = p;
            p = p.next;
            up = temp / 10;
            currl2 = currl2.next;
        }

        if (up != 0) {
            p = new ListNodes(up);
            q.next = p;
        }

        return result;
    }

    private class ListNodes {
        public int val;
        public ListNodes next;

        ListNodes(int x) {
            val = x;
        }
    }
}
