package leetcode.zuochengyun.bindarytree;

/*
 * ��һ�ö������������һ���㷨�ж���ö������Ƿ�Ϊƽ���������
�����������ĸ����root���뷵��һ��boolֵ������������Ƿ�Ϊƽ���������
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
