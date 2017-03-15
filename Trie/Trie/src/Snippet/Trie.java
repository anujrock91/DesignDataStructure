package Snippet;
import java.util.HashSet;

class TrieNode{
	char c;
	TrieNode[] arr = new TrieNode[26];
	boolean isLeaf = true;
	boolean isWord = false;
}

public class Trie {
	
	private TrieNode head;
	
	public Trie(){
		head = new TrieNode();
	}
	
	public void insert(String word){
		insert(word, 0, head);
	}
	
	public void insert(String word, int count, TrieNode root){
		if(count >= word.length()){ 
			root.isWord = true;
			return; 
		}
		char c = word.charAt(count);
		int index = c-'a';
		if(root.isLeaf){ root.isLeaf = false; }
		if(root.arr[index] == null){
			TrieNode newNode = new TrieNode();
			newNode.c = c;
			root.arr[index] = newNode;
			insert(word, count+1, root.arr[index]);
		}
		else{
			insert(word, count+1, root.arr[index]);
		}
	}
	
	
	
	public boolean search(String word){
		return search(word, 0, head);
	}
	
	
	public boolean search(String word, int count, TrieNode root){
		if(count >= word.length()){
			return root.isWord;
		}
		if(root.isLeaf && count < word.length()){ return false; }
		char c = word.charAt(count);
		int index = c-'a';
		return root.arr[index]==null?false:search(word, count+1, root.arr[index]);
	}
	
	public boolean searchPattern(String word){
		return searchPattern(word, 0, head);
	}
	
	
	public boolean searchPattern(String word, int count, TrieNode root){
		if(count >= word.length()){
			return true;
		}
		if(root.isLeaf && count < word.length()){ return false; }
		char c = word.charAt(count);
		int index = c-'a';
		return root.arr[index]==null?false:searchPattern(word, count+1, root.arr[index]);
	}
	
	
	
	public static void main(String args[]){
		Trie obj = new Trie();
		obj.insert("rental");
		obj.insert("apple");
		obj.insert("app");
		obj.insert("jam");
		System.out.println(obj.search("rental"));
		System.out.println(obj.searchPattern("ja"));
	}
	
}
