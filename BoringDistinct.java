import java.util.HashSet;

public class BoringDistinct implements Distinct{
	private HashSet<String> set;
	BoringDistinct(){
		set = new HashSet<String>();
	}
	public void add(String s){
		set.add(s);
	}
	public double distinct(){
		return (double) set.size();
	}
}