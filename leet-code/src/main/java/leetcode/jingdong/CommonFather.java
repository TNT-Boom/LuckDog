package leetcode.jingdong;

// 求两个节点的公共子树
public class CommonFather {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode father;
    }

    public static void main() {

    }

    TreeNode LowestCommonAncestor(TreeNode first, TreeNode second) {
        int firstHeight = getHeight(first);
        int secondHeight = getHeight(second);
        int diffHeight = firstHeight - secondHeight;
        if (diffHeight > 0) {
            while (diffHeight-- != 0) {
                first = first.father;
            }
        } else if (diffHeight > 0) {
            while (diffHeight++ != 0) {
                second = second.father;
            }

        }
        while (first != second) {
            first = first.father;
            second = second.father;
        }
        return first;
    }

    public static int getHeight(TreeNode node) {
        if (node.father == null) {
            return 1;
        }
        return getHeight(node.father) + 1;
    }
}
