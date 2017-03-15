package Snippet;

public class ShortestWordDistance2 {
	
	String [] wordsArr;
	
	public ShortestWordDistance2(String [] words){
		wordsArr = words;
	}
	
	public int shortestWordDist(String word1, String word2){
		Integer index1 = null;
		Integer index2 = null;
		Integer min = Integer.MAX_VALUE;
		for(int i=0;i<wordsArr.length;i++){
			String word = wordsArr[i];
			if(word.equals(word1)){
				index1 = i;
				if(index2 != null){	
					min = Math.min(min, Math.abs(index1-index2));
				}
			}
			else if(word.equals(word2)){
				index2 = i;
				if(index1 != null){	
					min = Math.min(min, Math.abs(index1-index2));
				}
			}
		}
		
		return min;
	}
	
	
	public static void main(String args[]){
		ShortestWordDistance2 obj = new ShortestWordDistance2(new String[]{"practice", "makes", "perfect", "coding", "makes"});
		System.out.println(obj.shortestWordDist("makes", "coding"));
	}
	
	
}
