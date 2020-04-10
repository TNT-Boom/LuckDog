package leetcode.zuochengyun.bindarytree;

import java.util.ArrayList;
import java.util.List;


public class FindErrorNode {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> results = new ArrayList<Integer>();

    public int[] findError(TreeNode root) {
        midSearch(root);
        int first = -1;
        int second = -1;
        int last = Integer.MIN_VALUE;
        boolean isFirst = true;
        // 第一逆序的较大值，最后一次逆序的较小值
        for (Integer i : results) {
            if (i < last) {
                if (isFirst) {
                    first = last;
                    isFirst = false;
                }
                second = i;
            }
            last = i;
        }

        int[] ret = new int[2];
        ret[0] = first < second ? first : second;
        ret[1] = first < second ? second : first;
        return ret;
    }

    private void midSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        midSearch(root.left);
        results.add(root.val);
        midSearch(root.right);
    }
}
