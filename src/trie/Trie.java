	package trie;

public class Trie {
	
	private TrieNode root;
	
	public Trie()
	{
		root = new TrieNode();
	}
	
	//inserts a word into the trie
	public void insert(String word)
	{
		TrieNode node = root;
		for(int i=0;i<word.length();i++)
		{
			char currentChar = word.charAt(i);
			if(!node.containsKey(currentChar))
				node.put(currentChar, new TrieNode());
			node = node.get(currentChar);
		}
		node.setEnd();
	}
	//search a prefix or whole key in trie
	//returns the node where search ends
	private TrieNode searchPrefix(String word)
	{
		TrieNode node = root;
		for(int i=0;i<word.length();i++)
		{
			char curLetter = word.charAt(i);
			if(node.containsKey(curLetter))
				node = node.get(curLetter);
			else
				return null;
		}
		return node;
	}
	//returns if there is any word in the trie
	//that starts with given prefix
	public boolean startsWith(String prefix)
	{
		TrieNode node = searchPrefix(prefix);
		return node !=null;
	}

}
