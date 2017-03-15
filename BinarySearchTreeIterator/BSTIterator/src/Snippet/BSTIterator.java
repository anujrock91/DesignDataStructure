package Snippet;
import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


public class BSTIterator {
	
	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		fillAllLeft(root, stack);
	}
	
	private void fillAllLeft(TreeNode root, Stack<TreeNode> stack){
		if(root==null){ return; }
		stack.push(root);
		fillAllLeft(root.left, stack);
	}
	
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		if(node.right == null){
			return node.val;
		}
		else{
			fillAllLeft(node.right, stack);
		}
		return node.val;
	}
}