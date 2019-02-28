import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class CreateTestingData {

		public static void main(String args[]){
			
			PrintWriter outputStats = null;
			try{
	            outputStats = new PrintWriter(new FileOutputStream("testData3.txt"));
	            //use file I/O to write test dataset
				for(int i=0;i < 5; i++){
					for(int j = 0; j< 10000; j++){
						outputStats.println(StdRandom.uniform(10000));
						//use StdRandom.uniform() to generate random numbers
						//and write them into dataset
					}
				
				}

	            outputStats.close();
            }
	        catch (FileNotFoundException e){
	            System.out.println("Error opening the file players.dat");
	            System.exit(0);
	        }

		}	            
}
		
	

