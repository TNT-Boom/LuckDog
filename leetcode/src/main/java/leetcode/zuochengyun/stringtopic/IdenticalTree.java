package leetcode.zuochengyun.stringtopic;

public class IdenticalTree
{
	public static void main(String[] args)
	{
		buildTree();
	}

	public static void buildTree()
	{
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);

		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		TreeNode b2 = new TreeNode(2);
		TreeNode b4 = new TreeNode(4);
		TreeNode b5 = new TreeNode(5);
		b2.left = b4;
		b2.right = b5;
		System.out.println(chkIdentical(a, b2));
	}

	public static boolean chkIdentical(TreeNode A, TreeNode B)
	{
		String a = serialTree(new StringBuilder(), A);
		String b = serialTree(new StringBuilder(), B);
		if (a.contains(b))
			return true;
		else
			return false;
	}

	// 关键在于序列化，而不是简单的一次遍历
	private static String serialTree(StringBuilder builder, TreeNode root)
	{
		if (root == null)
			return builder.append("#!").toString();
		builder.append(root.val).append("!");

		serialTree(builder, root.left);

		serialTree(builder, root.right);
		return builder.toString();

	}

	public static class TreeNode
	{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val)
		{
			this.val = val;
		}
	}
}
