package leetcode.bindarytree;

/**
 * @author limingjian
 * @date 2020/4/18
 *
 */
public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
    public void setLeft(TreeNode treeNode) {
        this.left = treeNode;
    }

    public void setRight(TreeNode treeNode) {
        this.right = treeNode;
    }
}