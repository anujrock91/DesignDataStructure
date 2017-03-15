package Snippet;
import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
	
	private Iterator<Integer> iterator;
    private Integer peek;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    peek = null;
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peek == null && iterator.hasNext()){
            peek = iterator.next();
            return peek;
        }
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peek!=null){
	        Integer temp = peek;
	        peek = null;
	        return temp;
	    }
	    if(iterator.hasNext()){
	        return iterator.next();    
	    }
	    return null;
	}

	@Override
	public boolean hasNext() {
	    if(peek!=null){ return true; }
	    else{
	        return iterator.hasNext();
	    }
	}
}
