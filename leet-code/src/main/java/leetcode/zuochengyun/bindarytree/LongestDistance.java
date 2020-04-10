package leetcode.zuochengyun.bindarytree;

/*
 * �Ӷ������Ľڵ�A�������������ϻ��������ߣ�����;�Ľڵ�ֻ�ܾ���һ�Σ�������ڵ�Bʱ��·���ϵĽڵ�������A��B�ľ��롣���ڸ�����һ�ö����������������Ͻڵ��������롣
����һ����������ͷ���root���뷵�������롣��֤�������ڵ���2С�ڵ���500.s

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

    private int getLongest(TreeNode root, int[] record) // ���ص���������
    {
        if (root == null) {
            record[0] = 0;
            return 0;
        }
        int lmax = getLongest(root.left, record);
        int maxFromLeft = record[0]; // ��������root���ӵ�������
        int rmax = getLongest(root.right, record);
        int maxFromRight = record[0]; // ��������root�Һ��ӵ�������
        int curr = maxFromLeft + maxFromRight + 1;

        record[0] = Math.max(maxFromLeft, maxFromRight) + 1; // ��root�����
        return Math.max(Math.max(lmax, rmax), curr);
    }
}
