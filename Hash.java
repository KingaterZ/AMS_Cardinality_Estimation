/* 
This is a class for hashing
*/

public class Hash{
	private int p = 1073741789; //smaller than 2^30
	private int a,b;		// only use for hash tables < 24593 in size
	
	public Hash(){
		a=StdRandom.uniform(p-1)+1;	// choose random parameters
		b=StdRandom.uniform(p+1);
	}
	public int h2u(int x,int n){

		int y = (a*x+b) % p;
		return y % n;
	}
	
	public static int h_basic(Object key){	    // if you only want the
	    return (key.hashCode() & 0xffffffff);   // lower 32 bits
	}
	
}