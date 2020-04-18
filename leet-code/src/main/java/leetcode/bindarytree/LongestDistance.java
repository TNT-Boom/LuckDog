package leetcode.bindarytree;

/**
 * 一棵二叉树有A B两个节点
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
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

    /**
     * 返回的是整棵树内，最大距离
     * 三种：
     * 仅左子树就有最大距离
     * 仅右子树就有最大距离
     * 经过根节点有最大距离即.h的左子树上离h.left最远的距离+1+h的右子树离h.rigth最远的距离
     * @param root
     * @param record
     * @return
     */
    private int getLongest(TreeNode root, int[] record) {
        if (root == null) {
            record[0] = 0;
            return 0;
        }
        // 左子树里最大的通路
        int lmax = getLongest(root.left, record);
        // 当前节点的左孩子到叶子节点的最大距离（其中一端必须是当前节点，这样后面才可以和右边的加起来，再和当前节点加1，构造一个经过当前节点的通路）
        int maxFromLeft = record[0];
        // 右子树里最大的通路
        int rmax = getLongest(root.right, record);
        // 当前节点的右孩子到叶子节点的最大距离（其中一端必须是当前节点，这样后面才可以和右边的加起来，再和当前节点加1，构造一个经过当前节点的通路）
        int maxFromRight = record[0];

        // 经过当前节点的通路
        int throughCurrNode = maxFromLeft + maxFromRight + 1;

        // 到当前节点的深度
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        // 左子树、右子树、经过当前节点的三个最大通路里选个最大的
        return Math.max(Math.max(lmax, rmax), throughCurrNode);
    }
}
