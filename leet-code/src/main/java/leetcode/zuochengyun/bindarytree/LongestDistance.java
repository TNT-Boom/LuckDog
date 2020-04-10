package leetcode.zuochengyun.bindarytree;

/*
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.s

 */
public class LongestDistance {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int findLongest(TreeNode root) {
        int[] record = new int[1];
        return getLongest(root, record);
    }

    private int getLongest(TreeNode root, int[] record) // 返回的是最大距离
    {
        if (root == null) {
            record[0] = 0;
            return 0;
        }
        int lmax = getLongest(root.left, record);
        int maxFromLeft = record[0]; // 左子树到root左海子的最大距离
        int rmax = getLongest(root.right, record);
        int maxFromRight = record[0]; // 右子树到root右孩子的最大距离
        int curr = maxFromLeft + maxFromRight + 1;

        record[0] = Math.max(maxFromLeft, maxFromRight) + 1; // 到root的深度
        return Math.max(Math.max(lmax, rmax), curr);
    }
}
