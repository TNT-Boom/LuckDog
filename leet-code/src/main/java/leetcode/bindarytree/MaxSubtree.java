package leetcode.bindarytree;

public class MaxSubtree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode getMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] info = new int[3];
        return getMax(root, info);
    }

    // Info  最小值，最大值，叶子节点数
    private TreeNode getMax(TreeNode root, int[] info) {
        if (root == null) {
            info[0] = Integer.MAX_VALUE;
            info[1] = Integer.MIN_VALUE;
            info[2] = 0;
            return null;
        }
        //这种递归数组复用挺厉害
        TreeNode lNode = getMax(root.left, info);
        int lmin = info[0];
        int lmax = info[1];
        int lnodeNum = info[2];

        TreeNode rNode = getMax(root.right, info);
        int rmin = info[0];
        int rmax = info[1];
        int rnodeNum = info[2];

        info[0] = Math.min(root.val, lmin);
        info[1] = Math.max(root.val, rmax);
        // root就是一颗搜索树
        if (lmax < root.val && rmin > root.val && lNode == root.left && rNode == root.right) {
            info[2] = lnodeNum + rnodeNum + 1;
            return root;
        }

        info[2] = Math.max(rnodeNum, lnodeNum);
        if (rnodeNum >= lnodeNum) {
            return rNode;
        } else {
            return lNode;
        }

    }

}
