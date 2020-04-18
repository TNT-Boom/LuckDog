package leetcode.bindarytree;

/**
 * @author limingjian
 * @date 2020/4/18
 *
 */
public class TreeUtil {
    /**
     *        8
     *     /    \
     *    7     10
     *   / \   /  \
     *  11 14 12 18
     * @return
     */
    public static TreeNode buildTreee() {
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode forteen = new TreeNode(14);
        TreeNode twelve = new TreeNode(12);
        TreeNode eighteen = new TreeNode(18);

        TreeNode root = eight;
        root.left = seven;
        root.right = ten;
        seven.left = eleven;
        seven.right = forteen;
        ten.left = twelve;
        ten.right = eighteen;
        return root;
    }
}