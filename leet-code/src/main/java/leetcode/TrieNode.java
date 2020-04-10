package leetcode;

import java.util.ArrayList;

class TrieNode {
    private char value;
    private ArrayList<TrieNode> sons = new ArrayList<>();

    // Initialize your data structure here.
    public TrieNode() {
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void insert(String word, int index) {
        if (!word.isEmpty() && index < word.length()) {
            char currChar = word.charAt(index);
            boolean hasEqual = false;
            for (TrieNode subNode : sons) {
                if (subNode.value == currChar) {
                    hasEqual = true;
                    subNode.insert(word, ++index);
                    break;
                }

            }

            if (!hasEqual) {
                TrieNode subNode = new TrieNode();
                subNode.setValue(currChar);
                sons.add(subNode);
                subNode.insert(word, ++index);
            }
        }
    }

    public boolean search(String word, int index) {
        if (index == word.length()) // 无此串，而是以该串开头
        {
            return true;
        }
        char currChar = word.charAt(index);

        for (TrieNode trieNode : sons) {
            if (trieNode.getValue() == currChar) {
                if (index == word.length() - 1 && trieNode.sons.size() == 0) // 最后一个，并且节点是叶子节点
                {
                    return true;
                } else {
                    return trieNode.search(word, ++index);
                }
            }
        }

        return false;

    }

    public boolean startWith(String word, int index) {
        if (index == word.length()) {
            return true;
        }
        char currChar = word.charAt(index);

        for (TrieNode trieNode : sons) {
            if (trieNode.getValue() == currChar) {
                return trieNode.startWith(word, ++index);
            }
        }

        return false;
    }
}