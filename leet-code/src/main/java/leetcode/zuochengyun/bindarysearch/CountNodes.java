package leetcode.zuochengyun.bindarysearch;



/*
 * ����һ����ȫ�������ĸ��ڵ�root������������Ľڵ�����������ȫ�������Ľڵ���ΪN����ʵ��ʱ�临�Ӷȵ���O(N)�Ľⷨ��
�������ĸ����root���뷵�����Ĵ�С��
 */
// δ����

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
