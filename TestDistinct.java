/* 
A sample testing function for distinct elements counter
*/

import java.io.*;

public class TestDistinct{
	
	public static void main(String args[]){
		if (args.length != 1){
		    System.err.println("Should be only one argument, the filename.");
		    System.exit(1);
		}
		TestDistinct testDist = new TestDistinct();
		String fileName = args[0]; // argument is filename.
	    double distincts = testDist.exactDistinctValue(fileName);
	    
	    System.out.println("There are "+distincts+" distinct values in this file");
		
	    double estimate = 0.0;
		double estimates[] = new double [100];
		int counter = 0;  // counter is used to count the number of testing times
		long timeUsed = 0;	// timeUsed is the variable used to store running time
		double currentVal = 0.0; 
		//currentVal is the variable to store estimation of current tesing case
	    BufferedReader br = null;
	    String line;
		while(counter<100) {
			Distinct d = new AMS();
			//Generate a new AMS object at each testing time
			try  {
				br = new BufferedReader(new FileReader(fileName));
			    long startTime = System.nanoTime();
			    while ((line = br.readLine()) != null) {
			    	d.add(line);


			    }
			    long endTime = System.nanoTime();
				timeUsed += (endTime - startTime);
			    System.out.println(d.distinct());
			    currentVal = d.distinct();
			    estimate += currentVal;
			    estimates[counter]=currentVal;
			    br.close();
		}
		
		catch(IOException e){
		    System.err.println("File " + fileName + " not ok.\n");
		    System.exit(1);
			}
			counter++;
		}
		
		estimate /= 100;
		double avgTime = (1.0*timeUsed/1000000)/100;
		double var = 0.0;
		for(int i = 0; i<100; i++) {
			var += (estimates[i]-estimate)*(estimates[i]-estimate);
		}
		
		var /= 100;
		
		//output the result for testing cases
		System.out.println("This is the result of AMS");
		System.out.println("Time used is "+avgTime+"MS");
		System.out.println("Average estimate is "+estimate);
		System.out.println("Relative error is "+Math.abs(estimate/distincts-1)); 		
		System.out.println("Variance is "+Math.sqrt(var));
	}
	
	private double exactDistinctValue(String filename) {
		//this method is used to calculate the real number of distinct values in file
		String line;
		Distinct exactResult = new BoringDistinct();
		BufferedReader reader = null;
		try  {
			reader = new BufferedReader(new FileReader(filename));
		    while ((line = reader.readLine()) != null) {
		    		exactResult.add(line);
		    }
		    reader.close();
		}
		catch(IOException e){
		    System.err.println("File " + filename + " not ok.\n");
		    System.exit(1);
			}
		return exactResult.distinct();
	}
}
