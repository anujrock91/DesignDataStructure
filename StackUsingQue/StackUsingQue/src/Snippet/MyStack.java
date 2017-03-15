package Snippet;
import java.util.LinkedList;

public class MyStack {
	
	LinkedList<Integer> que = new LinkedList<>();
	
	public MyStack() {}
    
    /** Push element x onto stack. */
    public void push(int x) {
    	que.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return que.removeLast();
    }
    
    /** Get the top element. */
    public int top() {
        return que.getLast();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.size()==0?true:false;
    }
}
