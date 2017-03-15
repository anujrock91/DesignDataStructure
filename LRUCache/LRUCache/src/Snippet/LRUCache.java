package Snippet;
import java.util.HashMap;
import java.util.LinkedHashSet;;

public class LRUCache {
	
	private LinkedHashSet<Integer> que = new LinkedHashSet<>();
	private int size;
	private HashMap<Integer, Integer> map = new HashMap<>();
	
	 public LRUCache(int capacity) {
		 size = capacity;
	 }
	    
	 public int get(int key) {
		 if(!map.containsKey(key)){ return -1;}
		 else{
			 if(que.contains(key)){ que.remove(key); }
			 que.add(key);
			 return map.get(key);
		 }
	 }
	    
	 public void put(int key, int value) {
		 if(map.containsKey(key)){
			 if(que.contains(key)){ que.remove(key); }
			 que.add(key);
			 map.put(key, value);
			 return;
		 }
		 if(map.size() >= size){
			 int toRemove = -1;
			 for(Integer i: que){
				 toRemove = i;
				 break;
			 }
			 que.remove(toRemove);
			 map.remove(toRemove);
			 if(que.contains(key)){ que.remove(key); }
			 que.add(key);
			 map.put(key, value);
		 }
		 else{
			 if(que.contains(key)){ que.remove(key); }
			 que.add(key);
			 map.put(key, value);
		 }
	 }
	 
	 
	 public static void main(String args[]){
		 LRUCache cache = new LRUCache(2);
		 cache.put(1, 1);
		 cache.put(2, 2);
		 System.out.println(cache.get(1));
		 cache.put(3, 3);
		 System.out.println(cache.get(2));
		 cache.put(4, 4);
		 System.out.println(cache.get(1));
		 System.out.println(cache.get(3));
		 System.out.println(cache.get(4));
	 }
	 
}
