import java.util.Arrays;


// AMS.java
// AMS distinct elements counter
// awirth for COMP90056
// Aug 2017,8

public class AMS implements Distinct{
	private byte arrayOfZs[]; 
	private int range = 536870912-3;//2^29-3
	private Hash hs[];
	private int c=50; //number of AMS estimators
		
	public AMS(){
		arrayOfZs = new byte[c];
		hs = new Hash[c];
		for(int i=0;i<c;i++){
			// create k new hash functions
			hs[i] = new Hash();
		}
		
	}
	
	public void add(String s){
		int val;
		for(int i=0;i<c;i++){
			val = hs[i].h_basic(s);
			val = hs[i].h2u(val, range);
			if(val != 0) {
				//to prevent the situation that zeros method consider value 0 as 32 zeros
				byte nz = Distinct.zeros(val);
				// for each hash function, store the maximum number of
				// zeros seen
				if(nz > arrayOfZs[i]){
					arrayOfZs[i] = nz;
					}
			}
		
		}
	}
	
	public static double getMedian(byte[] data) {
	    byte[] copy = Arrays.copyOf(data, data.length);
	    Arrays.sort(copy);
	    double result = 0.0;
	    int length = copy.length;
	    for( int i = length/2 - length/10; i<(length/2+length/10) ; i++ ) {
	    	result += copy[i];
	    }
	    result /= (2.0*length/10);
	    // if the length is odd, return the middle item, else return the average of the two middle items
	    return result;
	}
	    		
	public double distinct(){
		double m = getMedian(arrayOfZs); // because it's monotonic
		return Math.pow(2, m+0.5);
	}
	
}

	

