// Distinct.java
// Interface for distinct elements counter
// awirth for COMP90056
// Aug 2017,8

public interface Distinct{
	public static byte zeros(int v){
		return (byte)Integer.numberOfTrailingZeros(v); // builtin function
	}
	
	void add(String s); // add a new element to the collection
	double distinct(); // return a double representing the number of
			    // distinct elements
}