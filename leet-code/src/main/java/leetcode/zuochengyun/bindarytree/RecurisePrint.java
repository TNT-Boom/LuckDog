package leetcode.zuochengyun.bindarytree;

import java.util.LinkedList;
import java.util.Queue;

public class RecurisePrint {
    Queue<Integer> firstResult = new LinkedList<Integer>();
    Queue<Integer> midResult = new LinkedList<Integer>();
    Queue<Integer> lastResult = new LinkedList<Integer>();

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int[][] convert(TreeNode root) {
        first(root);
        midle(root);
        last(root);
        int[][] result = new int[3][firstResult.size()];
        for (int i = 0; i < firstResult.size(); i++) {
            result[0][i] = firstResult.poll();
            result[1][i] = midResult.poll();
            result[2][i] = lastResult.poll();
        }
        return result;
    }

    private void first(TreeNode root) {
        if (root == null) {
            return;
        }
        firstResult.add(root.val);
        first(root.left);
        first(root.right);
    }

    private void midle(TreeNode root) {
        if (root == null) {
            return;
        }
        first(root.left);
        midResult.add(root.val);
        first(root.right);
    }

    private void last(TreeNode root) {
        if (root == null) {
            return;
        }
        first(root.left);
        first(root.right);
        lastResult.add(root.val);
    }
}
