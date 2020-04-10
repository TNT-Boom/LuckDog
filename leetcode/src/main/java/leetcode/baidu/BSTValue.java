package leetcode.baidu;

// �������������С·��ֵ��
public class BSTValue
{
	public static void main(String[] args)
	{

		/*
		 * root�� tNodeRoot one layer: tNode21 tNode22 two layer��tNode11 tNode12 tNode13 tNode14
		 */

		// ����һ��BST��
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
	 * ��ȡBST�������·��
	 * 
	 * @param tNode
	 * @return minLength��BST���·��
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
	 * �ݹ��ȡ�ǿո��ڵ㵽Ҷ�ӽڵ�����·��
	 * 
	 * @param node
	 * @param currVal
	 * @return minLeft>minRight? minRight:minLeft
	 */
	private static int getMinPath(TreeNode node, int currVal)
	{
		int leftPath = -1;
		int rightPath = -1;

		// ������
		if (node.rightNode != null)
		{
			rightPath = getMinPath(node.rightNode, currVal + node.value);
		}

		// ������
		if (node.leftNode != null)
		{
			leftPath = getMinPath(node.leftNode, currVal + node.value);
		}

		// Ҷ�ӽڵ�
		if (node.leftNode == null && node.rightNode == null)
		{
			return currVal + node.value;
		}

		// ���������Ϊ��
		if (node.rightNode == null)
		{
			return leftPath;
		}

		// ���������Ϊ��
		if (node.leftNode == null)
		{
			return rightPath;
		}

		// ���������������������Ϊ��
		return leftPath > rightPath ? rightPath : leftPath;
	}
}

/**
 * ����BST���ṹ����
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
