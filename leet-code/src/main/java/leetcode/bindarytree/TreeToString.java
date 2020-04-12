package leetcode.bindarytree;

public class TreeToString {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String toString(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Serialize(root, builder);
        return builder.toString();
    }

    private void Serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#!");
        } else {
            builder.append(root.val).append("!");
            Serialize(root.left, builder);
            Serialize(root.right, builder);
        }
    }
}
