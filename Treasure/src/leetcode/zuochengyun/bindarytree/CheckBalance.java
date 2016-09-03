package leetcode.zuochengyun.bindarytree;

/*
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 */
public class CheckBalance
{
	public class TreeNode
	{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val)
		{
			this.val = val;
		}
	}

	public boolean check(TreeNode root)
	{
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(root, res);
		return res[0];
	}
	private int getHeight(TreeNode root, boolean[] res)
	{
		if(root == null)
			return 0;
		int left = 0;
		int right = 0;
		if(root.left != null)
			left = getHeight(root.left, res);
		if(root.right != null)
			right = getHeight(root.right, res);
		if(Math.abs(left - right) > 1)
			res[0] = false;
		return Math.max(left, right) + 1;
	}
	
}
