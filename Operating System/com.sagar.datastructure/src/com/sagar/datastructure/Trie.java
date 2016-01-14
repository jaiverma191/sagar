package com.sagar.datastructure;

import java.util.HashMap;

public class Trie {
	private class TrieNode {
		boolean isEnd;
		HashMap<Character, TrieNode> children;

		public TrieNode(Character ch) {
			this.isEnd = false;
			this.children = new HashMap<>();
		}
	}

	public Trie() {
		this.root = new TrieNode((char) 0);
	}

	private TrieNode root;

	public void insert(String s) {
		TrieNode temp = root;
		for (int i = 0; i < s.length(); i++) {
			if (temp.children.containsKey(s.charAt(i))) {
				temp = temp.children.get(s.charAt(i));
			} else {
				TrieNode n = new TrieNode(s.charAt(i));
				temp.children.put(s.charAt(i), n);
				temp = n;
			}
		}
		temp.isEnd = true;
	}

	public String getMatchingPrefix(String input) {
		String result = "";
		TrieNode temp = root;
		int i, prev = 0;
		for (i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			if (temp.children.get(c) != null) {
				result += c;
				temp = temp.children.get(c);
				if (temp.isEnd)
					prev = i + 1;

			} else
				break;
		}
		if (!temp.isEnd)
			return result.substring(0, prev);
		return result;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("India");
		trie.insert("In");
		trie.insert("javaforinterview");
		trie.insert("java");
		System.out.println(trie.getMatchingPrefix("java1"));

	}
}
