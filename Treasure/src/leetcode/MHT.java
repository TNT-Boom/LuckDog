package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import base.BaseAlgorithm;

/*
 * 先构造好，然后逐层删除叶子，直到所有的都是叶子，此时剩1-2个
 */
public class MHT implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		System.out.println(findMinHeightTrees(6,new int[][]{{0,3},{1,3},{2,3},{4,3},{5,4}}));
	}
	private class Node
	{
		public int val;
		public Set<Integer> neighbors = new HashSet<>();
		public boolean isLeaves()
		{
			return neighbors.size() == 1;
		}
	}
	// n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
    	List<Integer> result = new ArrayList<>();
    	List<Node> nodes = new ArrayList<Node>(n);
    	if(n == 1)
    	{
    		result.add(0);
    		return result;
    	}
    	if(n == 2)
    	{
    		result.add(0);
    		result.add(1);
    	}
    	for(int i = 0; i < n; ++i)
    	{
    		nodes.add(i, new Node());
    	}
    	
    	for(int i = 0; i < edges.length; i++)
    	{
    		nodes.get(edges[i][0]).neighbors.add(edges[i][1]);
    		nodes.get(edges[i][1]).neighbors.add(edges[i][0]);
    	}
    	
    	List<Integer> leaves1 = new ArrayList<>();
    	List<Integer> leaves2 = new ArrayList<>();
    	
    	for (Node node : nodes)
		{
			if(node.isLeaves())
				leaves1.add(nodes.indexOf(node));
		}
    	
    	while(true) // 逐层删除，用两个List互换，保证一层一层
    	{
    		
    		for (Integer nodeVal : leaves1)
			{
				for(Integer neighbor : nodes.get(nodeVal).neighbors) // 叶子节点由于要被删除，所以其邻居解除与叶子节点的关联
				{
					nodes.get(neighbor).neighbors.remove(nodeVal);
					if(nodes.get(neighbor).isLeaves())
						leaves2.add(neighbor);
				}
			}
    		if(leaves2.isEmpty())
    		{
    			return leaves1;
    		}
    		leaves1.clear();
    		leaves1.addAll(leaves2);
    		leaves2.clear();
    	}
    }
}
