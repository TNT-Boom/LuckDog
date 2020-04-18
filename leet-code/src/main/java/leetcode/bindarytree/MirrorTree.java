package leetcode.bindarytree;

/**
 * @author limingjian
 * @date 2020/4/18
 * ·­×ª¶þ²æÊ÷
 */
public class MirrorTree {
    public void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }
}