package leetcode.zuochengyun.bindarysearch;



/*
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
给定树的根结点root，请返回树的大小。
 */
// 未调试

public class CountNodes {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int total = 0;
        int maxLevel = getMaxLevel(root);
        int rightLeftLevel = getRLeft(root.right);

        if (maxLevel == rightLeftLevel) {
            total = pow(2, maxLevel - 1) + 1 + count(root.right);
        } else {
            total = pow(2, rightLeftLevel - 1) + 1 + count(root.left);
        }
        return total;
    }

    public static int pow(int base, int index) {
        int result = 1;
        for (int i = 0; i < index; i++) {
            result *= base;
        }
        return result;
    }

    public static int getRLeft(TreeNode rootRight) {
        return getMaxLevel(rootRight) + 1;
    }

    public static int getMaxLevel(TreeNode root) {
        int level = 0;
        if (root == null) {
            return 0;
        }
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
