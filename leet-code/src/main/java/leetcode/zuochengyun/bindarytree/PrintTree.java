package leetcode.zuochengyun.bindarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = six;
        six.left = seven;
        boolean[] res = new boolean[1];
        res[0] = true;
        System.out.println(getHeight(one, res) + "" + res[0]);
        int[][] result = printTree(one);
        System.out.println(result);
    }

    private static int getHeight(TreeNode root, boolean[] res) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = getHeight(root.left, res);
        }
        if (root.right != null) {
            right = getHeight(root.right, res);
        }
        if (Math.abs(left - right) > 1) {
            res[0] = false;
        }
        return Math.max(left, right) + 1;
    }

    private static int[][] printTree(TreeNode root) {
        List<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
        LinkedList<Integer> currValues = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) {
            return null;
        }
        queue.add(root);
        TreeNode last = root;
        TreeNode nlast = root;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currValues.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nlast = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                nlast = node.right;
            }

            if (last == node) // 弹出的节点等于last，则换行
            {
                last = nlast; // last指向下一行的最后一个节点。
                results.add(currValues);
                currValues = new LinkedList<>();
            }
        }
        int[][] resultArr = new int[results.size()][];
        for (int i = 0; i < results.size(); i++) {
            LinkedList<Integer> layer = results.get(i);
            int[] eachLayer = new int[layer.size()];
            for (int j = 0; j < layer.size(); j++) {
                eachLayer[j] = layer.get(j);
            }
            resultArr[i] = eachLayer;
        }
        return resultArr;
    }
}