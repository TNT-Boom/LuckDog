package leetcode.zuochengyun;
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
		List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> currValues = new LinkedList<>();
		// write code here
		if(root == null)
			return null;
		TreeNode last = root;
		TreeNode nLast = root;
		Queue<TreeNode> treeNodes = new LinkedList<>();
		treeNodes.add(root);
		while(treeNodes.isEmpty() == false)
		{
			TreeNode outline = treeNodes.poll();
			
			currValues.add(outline.val);
			
 			if(outline.left != null)
			{
				treeNodes.add(outline.left);
				nLast = outline.left;
			}
			if(outline.right != null)
			{
				treeNodes.add(outline.right);
				nLast = outline.right;
			}
			
			
			if(outline == last) // 换行
			{
				result.add(currValues);
				currValues = new LinkedList<Integer>();
				last = nLast;
			}
		}
		
		int[][] returnResult = new int[result.size()][];
		int lineIndex = 0;
		for (LinkedList<Integer> layer : result)
		{
			int[] eachLayer = new int[layer.size()];
			
			for(int i = 0; i < layer.size(); ++i)
			{
				eachLayer[i] = layer.get(i);
			}
			returnResult[lineIndex] = eachLayer;
			lineIndex++;
		}
		return returnResult;
	}
}