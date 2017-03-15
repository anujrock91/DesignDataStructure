package Snippet;
import java.util.*;

public class MyQueue {
	
	Stack<Integer> insert = new Stack<>();
	Stack<Integer> remove = new Stack<>();
	
	public MyQueue(){}
	
	public void push(int x){
		insert.push(x);
	}
	
	public int pop(){
		if(remove.isEmpty()){
			while(!insert.isEmpty()){
				remove.push(insert.pop());
			}
			return remove.pop();
		}
		else{
			return remove.pop();
		}
	}
	
	public int peek(){
		if(remove.isEmpty()){
			while(!insert.isEmpty()){
				remove.push(insert.pop());
			}
			return remove.peek();
		}
		else{
			return remove.peek();
		}
	}
	
	
	public boolean isEmpty(){
		return remove.isEmpty()&&insert.isEmpty()?true:false;
	}
	
}
