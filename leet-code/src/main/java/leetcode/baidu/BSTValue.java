package leetcode.baidu;

// 二叉查找树的最小路径值。
public class BSTValue
{
	public static void main(String[] args)
	{

		/*
		 * root： tNodeRoot one layer: tNode21 tNode22 two layer：tNode11 tNode12 tNode13 tNode14
		 */

		// 构造一个BST树
		TreeNode tNode11 = new TreeNode(10, null, null);
		TreeNode tNode12 = new TreeNode(50, null, null);
		TreeNode tNode13 = new TreeNode(5, null, null);
		TreeNode tNode14 = new TreeNode(30, null, null);

		TreeNode tNode21 = new TreeNode(30, tNode11, tNode12);
		TreeNode tNode22 = new TreeNode(30, tNode13, tNode14);

		TreeNode tNodeRoot = new TreeNode(100, tNode21, tNode22);

		System.out.println(minlength(tNodeRoot));

	}

	/**
	 * 获取BST树的最短路径
	 * 
	 * @param tNode
	 * @return minLength：BST最短路径
	 */
	private static int minlength(TreeNode tNode)
	{
		// TODO Auto-generated method stub
		if (tNode != null)
		{
			return getMinPath(tNode, 0);
		}
		return -1;
	}

	/**
	 * 递归获取非空根节点到叶子节点的最短路径
	 * 
	 * @param node
	 * @param currVal
	 * @return minLeft>minRight? minRight:minLeft
	 */
	private static int getMinPath(TreeNode node, int currVal)
	{
		int leftPath = -1;
		int rightPath = -1;

		// 右子树
		if (node.rightNode != null)
		{
			rightPath = getMinPath(node.rightNode, currVal + node.value);
		}

		// 左子树
		if (node.leftNode != null)
		{
			leftPath = getMinPath(node.leftNode, currVal + node.value);
		}

		// 叶子节点
		if (node.leftNode == null && node.rightNode == null)
		{
			return currVal + node.value;
		}

		// 如果右子树为空
		if (node.rightNode == null)
		{
			return leftPath;
		}

		// 如果左子树为空
		if (node.leftNode == null)
		{
			return rightPath;
		}

		// 如果右子树和左子树都不为空
		return leftPath > rightPath ? rightPath : leftPath;
	}
}

/**
 * 定义BST树结构类型
 * 
 * @author ZhuXY
 *
 */
class TreeNode
{
	int value;
	TreeNode leftNode;
	TreeNode rightNode;

	TreeNode(int value, TreeNode lefeNode, TreeNode rightNode)
	{
		this.value = value;
		this.leftNode = lefeNode;
		this.rightNode = rightNode;
	}
}
