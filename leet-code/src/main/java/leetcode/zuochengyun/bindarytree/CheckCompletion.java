package leetcode.zuochengyun.bindarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 */
public class CheckCompletion {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean chk(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.right != null && curr.left == null) // 左空，右不空，=
            {
                return false;
            }
            if (!(curr.right != null && curr.left != null)) // 不是左右节点全有，则下一个节点必须是叶子
            {
                if (!queue.isEmpty()) // 下一个节点必须是叶子节点
                {
                    TreeNode next = queue.peek();
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
