package leetcode;

import base.BaseAlgorithm;

public class Trie implements BaseAlgorithm
{
	@Override
	public void runDemo()
	{
		Trie trie = new Trie();
		trie.insert("limingjian");
		System.out.println("Search liming: " + trie.search("liming"));
		System.out.println("Search limingjian: " + trie.search("limingjian"));
		System.out.println("StartWith liming: " + trie.startsWith("liming"));
	}
	
	private TrieNode root;

	public Trie()
	{
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word)
	{
		if(!word.isEmpty())
		{
			root.insert(word + "$", 0);
		}
		
	}

	// Returns if the word is in the trie.
	public boolean search(String word)
	{
		return root.search(word + "$", 0);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix)
	{
		return root.startWith(prefix, 0);
	}
}