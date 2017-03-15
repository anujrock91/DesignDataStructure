package Snippet;
import java.util.*;

public class UniqueWordAbbrevation {
	
	private HashSet<String> abbrevations;
	private HashMap<String, Boolean> map; 
	
	public UniqueWordAbbrevation(String [] words){
		abbrevations = new HashSet<>();
		map = new HashMap<>();
		constDict(words);
	}
	
	private void constDict(String [] words){
		for(String word: words){
			if(map.containsKey(word)){ continue; }
			String abbr = ""+word.charAt(0)+(word.length()-2)+word.charAt(word.length()-1);
			//if the word abbrevation is already present then we need not add that word
			boolean dec = (abbrevations.contains(abbr))?false:map.put(word, true)==null; 
			abbrevations.add(abbr);
		}
	}
	
	 public boolean isUnique(String word){
		 if(map.containsKey(word)){
			 return map.get(word);
		 }
		 else{
			 String abbr = ""+word.charAt(0)+(word.length()-2)+word.charAt(word.length()-1);
			 if(abbrevations.contains(abbr)){ return false; }
			 else{
				 abbrevations.add(abbr);
				 map.put(word, true);
				 return true;
			 }
		 }
	 }
	 
	 
	 public static void main(String args[]){
		 UniqueWordAbbrevation obj = new UniqueWordAbbrevation(new String[]{"deer", "door", "cake", "card"});
		 System.out.println(obj.isUnique("deer"));
		 System.out.println(obj.isUnique("sex"));
		 System.out.println(obj.isUnique("sax"));
		 System.out.println(obj.isUnique("sex"));
		 System.out.println(obj.isUnique("door"));
	 }
}
