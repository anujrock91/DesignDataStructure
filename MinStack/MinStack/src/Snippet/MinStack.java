package Snippet;
import java.util.Stack;

public class MinStack {
	
	Stack<Integer> original = new Stack<>();
	Stack<Integer> min = new Stack<>();
	
	public MinStack() {   }
    
    public void push(int x) {
        original.push(x);
        if(min.isEmpty() || x<=min.peek()){
        	min.push(x);
        }
    }
    
    public void pop() {
        int x = original.pop();
        if(x == min.peek()){
        	min.pop();
        }
    }
    
    public int top() {
        return original.peek();
    }
    
    public int getMin() {
        return min.peek();
    }	
}
