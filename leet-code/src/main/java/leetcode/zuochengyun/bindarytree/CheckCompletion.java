package leetcode.zuochengyun.bindarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ��һ�ö�����,�����һ���㷨�ж����Ƿ�����ȫ��������
�����������ĸ����root���뷵��һ��boolֵ�������Ƿ�Ϊ��ȫ�����������Ľ�����С�ڵ���500��
 */
public class CheckCompletion {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean chk(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.right != null && curr.left == null) // ��գ��Ҳ��գ�=
            {
                return false;
            }
            if (!(curr.right != null && curr.left != null)) // �������ҽڵ�ȫ�У�����һ���ڵ������Ҷ��
            {
                if (!queue.isEmpty()) // ��һ���ڵ������Ҷ�ӽڵ�
                {
                    TreeNode next = queue.peek();
                    if (next.left != null || next.right != null) {
                        return false;
                    }
                }
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return true;
    }
}
