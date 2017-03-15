package Snippet;
import java.util.*;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}


class wrapper{
	int pointer;
	TreeNode node;
}

public class SerAndDeSer {
	
	private ArrayList<Integer> inorder = new ArrayList<Integer>();
	private ArrayList<Integer> preorder = new ArrayList<Integer>();
	
	public String serialize(TreeNode root) {
		traversal(root);
		String inorderString = inorder.toString();
		inorderString = inorderString.substring(0, inorderString.length()-1);
		inorderString = inorderString.substring(1);
		
		String preOrderString = preorder.toString();
		preOrderString = preOrderString.substring(0, preOrderString.length()-1);
		preOrderString = preOrderString.substring(1);
		
		return inorderString+"#"+preOrderString;
    }
	
	public void traversal(TreeNode root){
		if(root == null){
			return;
		}
		preorder.add(root.val);
		traversal(root.left);
		inorder.add(root.val);
		traversal(root.right);
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] splitHash = data.split("#");
        String [] inorderArr = splitHash[0].split(",");
        String [] preOrderArr = splitHash[1].split(",");
        int [] in = new int[inorderArr.length];
        int [] pre = new int[preOrderArr.length];
        for(int i=0;i<inorderArr.length;i++){
        	in[i] = Integer.parseInt(inorderArr[i].trim());
        	pre[i] = Integer.parseInt(preOrderArr[i].trim());
        }
        return constTree(in, pre, 0).node;
    }
    
    
    public void display(TreeNode root){
    	if(root==null){return; }
    	display(root.left);
    	System.out.print("->"+root.val);
    	display(root.right);
    }
    
    public wrapper constTree(int[] in, int[] pre, int pointer){
    	if(in.length == 0 || pre.length == 0){
    		wrapper obj = new wrapper();
    		obj.pointer = pointer;
    		return obj;
    	}
    	int val = pre[pointer];
    	TreeNode newNode = new TreeNode(val);
    	++pointer;
    	
    	int valIndex = 0;
    	for(int i=0;i<in.length;i++){
    		if(in[i] == val){
    			valIndex = i;
    			break;
    		}
    	}
    	++valIndex;
    	int inRight[] = new int[in.length-valIndex];
    	int inLeft[] = new int[valIndex-1];
    	
    	for(int i=0;i<inLeft.length;i++){
    		inLeft[i] = in[i];
    	}
    	
    	for(int i=0;i<inRight.length;i++){
    		inRight[i] = in[i+valIndex];
    	}
    	
    	wrapper leftObj = constTree(inLeft, pre, pointer);
    	wrapper rightObj = constTree(inRight, pre, leftObj.pointer);
    	newNode.left = leftObj.node;
    	newNode.right = rightObj.node;
    	wrapper obj = new wrapper();
    	obj.node = newNode;
    	obj.pointer = rightObj.pointer;
    	return obj;
    }
    
    
    
    public static void main(String args[]){
    	int [] in = new int[]{4,2,1,5,3,6};
    	int [] pre = new int[]{1,2,4,3,5,6};
    	TreeNode root = new SerAndDeSer().constTree(in, pre, 0).node;
    	new SerAndDeSer().display(root);
    }
    
}
