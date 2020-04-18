package leetcode.bindarytree;

/**
 * @author limingjian
 * @date 2020/4/18
 * 判断node2是否是node1的子树
 */
public class IsSubTree {
    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        boolean result = false;
        // 我觉得吧，如果node2 == null, 那肯定匹配到了node1的叶子节点，符合要求
        if (node2 == null) {
            return true;
        }

        if (node1 == null) {
            return false;
        }

        if (node1.val == node2.val) {
            result = hasSubTreeInThisNode(node1, node2);
        }
        if (node1.left.val == node2.val) {
            result = isSubTree(node1.left, node2);
        }
        if (node1.right.val == node2.val) {
            result = isSubTree(node1.right, node2);
        }

        return result;
    }
    // 以node1为根节点的树，是否包含node2（必须以node1为根节点）
    private boolean hasSubTreeInThisNode(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }

        if (node1 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return hasSubTreeInThisNode(node1.left, node2.left) && hasSubTreeInThisNode(node1.right, node2.right);
    }
}