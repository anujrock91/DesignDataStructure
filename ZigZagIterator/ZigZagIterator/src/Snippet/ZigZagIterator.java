package Snippet;
import java.util.*;

public class ZigZagIterator {
	
	private int count1 = 0;
	private int count2 = 0;
	private int switch1 = 1;
	private int switch2 = 0;
	private List<Integer> vector1;
	private List<Integer> vector2;
	
	public ZigZagIterator(List<Integer> v1, List<Integer> v2){
		vector1 = v1;
		vector2 = v2;
	}
	
	public Integer next(){
		if(hasNext()){ 
			if(count1 >= vector1.size()){
				int temp = vector2.get(count2);
				++count2;
				return temp;
			}
			else if(count2 >= vector2.size()){
				int temp = vector1.get(count1);
				++count1;
				return temp;
			}
			else if(switch1 == 1){
				int temp = vector1.get(count1);
				++count1;
				switch1 = 0;
				switch2 = 1;
				return temp;
			}
			else if(switch2 == 1){
				int temp = vector2.get(count2);
				++count2;
				switch2 = 0;
				switch1 = 1;
				return temp;
			}
		}
		return null; 
	}

	public boolean hasNext(){
		return (count1 >= vector1.size() && count2 >= vector2.size())?false:true;
	}
	
	
	
	public static void main(String args[]){
		List<Integer> v1 = new ArrayList<>(); 
		v1.add(1);v1.add(2);
		List<Integer> v2 = new ArrayList<>();
		v2.add(3);v2.add(4);v2.add(5);v2.add(6);
		
		ZigZagIterator obj = new ZigZagIterator(v1, v2);
		while(obj.hasNext()){
			System.out.print(obj.next()+" | ");
		}
		System.out.println();
	}
}
