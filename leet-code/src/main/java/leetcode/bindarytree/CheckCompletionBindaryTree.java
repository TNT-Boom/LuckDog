package leetcode.bindarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 */
public class CheckCompletionBindaryTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean chk(TreeNode root) {
        // 用队列存储每个需要检查的节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            // 左空，右不空，=
            if (curr.right != null && curr.left == null) {
                return false;
            }
            // 不是左右节点全有，则下一个节点必须是叶子
            if (!(curr.right != null && curr.left != null)) {
                // 下一个节点必须是叶子节点，所以检查下下一个节点
                if (!queue.isEmpty()) {
                    TreeNode next = queue.peek();
                    // 如果这个节点的父节点本身就不是左右全有，结果这个节点又有孩子节点，那么不是叶子节点了
                    if (next.left != null || next.right != null) {
                        return false;
                    }
                }
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return true;
    }
}
