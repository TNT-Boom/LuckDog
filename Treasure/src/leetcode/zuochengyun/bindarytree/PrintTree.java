package leetcode.zuochengyun.bindarytree;
import java.util.*;

public class PrintTree
{
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
	
	public static void main(String[] args)
	{
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
		
 		int[][] result = printTree(one);
		System.out.println(result);
	}
	private  static int[][] printTree(TreeNode root)
	{
		List<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> currValues = new LinkedList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root == null)
			return null;
		queue.add(root);
		TreeNode last = root;
		TreeNode nlast = root;
		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			currValues.add(node.val);
			if(node.left != null)
			{
				queue.add(node.left);
				nlast = node.left;
			}
			if(node.right != null)
			{	
				queue.add(node.right);
				nlast = node.right;
			}
			
			if(last == node) // 弹出的节点等于last，则换行
			{
				last = nlast; // last指向下一行的最后一个节点。
				results.add(currValues);
				currValues = new LinkedList<>();
			}
		}
		int[][] resultArr = new int[results.size()][];
		for(int i = 0; i< results.size(); i++)
		{
			LinkedList<Integer> layer = results.get(i);
			int[] eachLayer = new int[layer.size()];
			for(int j = 0; j < layer.size(); j++)
			{
				eachLayer[j] = layer.get(j);
			}
			resultArr[i] = eachLayer;
		}
		return resultArr;
	}
}