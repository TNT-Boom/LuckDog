package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import base.BaseAlgorithm;

// 145
public class PostordertTraversal implements BaseAlgorithm
{
	TreeNode root = null;

	@Override
	public void runDemo()
	{
		Solution solution = new Solution();
		solution.init();
		System.out.println("recursionPostorder: " + solution.secursionPostorder(root));
		System.out.println("noSecursionPostorder: " + solution.noSecursionPostorder(root));
		System.out.println("noSecursionPostorderSimple: " + solution.noSecursionPostorderSimple(root));
	}

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	public class Solution
	{
		public List<Integer> secursionPostorder(TreeNode root)
		{
			List<Integer> result = new ArrayList<>();
			postorderTraversal(root, result);
			return result;
		}

		private void postorderTraversal(TreeNode root, List<Integer> result)
		{
			if (root == null)
				return;
			postorderTraversal(root.left, result);
			postorderTraversal(root.right, result);
			result.add(root.val);
		}


		public List<Integer> noSecursionPostorder(TreeNode root)
		{
			List<Integer> result = new ArrayList<>();

			if (root == null)
				return result;
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);

			TreeNode pre = null;
			while (!stack.isEmpty())
			{
				TreeNode curr = stack.peek(); // 不能remove
				if (pre == null || pre.left == curr || pre.right == curr) // 一颗树下去的
				{
					if (curr.left != null)
						stack.push(curr.left);
					else if (curr.right != null)
						stack.push(curr.right);
					else // 叶子节点
					{
						stack.pop();
						result.add(curr.val);

					}
				}

				else if (curr.left == pre) // 回到李上个节点的父亲节点
				{
					if (curr.right != null)
						stack.push(curr.right);  // 忘了，所以重复添加李当前结点
					else // 遍历完左子树，又没有右子树
					{
						stack.pop();
						result.add(curr.val);
					}
				}
				else if(curr.right == pre) // 由右子树回溯到父节点
				{
					stack.pop();
					result.add(curr.val);
				}
				pre = curr;
			}
			
			return result;
		}

		/*
		 * 感觉是上一个方法里记录了树的各种关系，而对此题仅需要知道节点上下节点关系，所以肯定存在压缩的空间
		 */
		public List<Integer> noSecursionPostorderSimple(TreeNode root)
		{
			List<Integer> result = new ArrayList<>();
			if(root == null)
				return result;
			TreeNode curr = root;
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			while(!stack.isEmpty())
			{
				curr = stack.peek();
				if(curr.left == null && curr.right == null)
				{
					TreeNode leaf = stack.pop();
					result.add(leaf.val);
				}
				else
				{
					if(curr.right != null)
					{
						stack.push(curr.right);
						curr.right = null;
					}
					if(curr.left != null)
					{
						stack.push(curr.left);
						curr.left = null;
					}
				}
			}
			
			return result;
		}
		
		public void init()
		{
			root = new TreeNode(1);
			TreeNode rootRight = new TreeNode(2);
			TreeNode leave = new TreeNode(3);
			insert(root, rootRight, 0);
			insert(root, leave, 1);
		}

		private void insert(TreeNode father, TreeNode node, int leftOrRight)
		{
			switch (leftOrRight)
			{
				case 0:
					father.left = node;
					break;
				case 1:
					father.right = node;
					break;
				default:
					break;
			}
		}
	}
}
