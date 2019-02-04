package creditCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


public class Sagen_Matthew {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("src/priorityInversion/Sagen_Matthew.txt", "UTF-8"); //this is used to print to output file
		ArrayList<String> input = get_inputFileArray();
		
	}
	
	
	public static ArrayList<String> get_inputFileArray() throws FileNotFoundException, UnsupportedEncodingException{ //helper method creates jobs from input.txt
		Scanner scanner = null;
		ArrayList<String> input = new ArrayList<String>();	//holds data from input.txt in the form of Job# | Arrival_Time | Processing_Time
		//ArrayList<Job> jobs = new ArrayList<Job>();			//holds individual jobs from input.
		
        try{
            scanner = new Scanner(new File("src/creditCard/memorydump.dmp"));
        }
        //throws error if the file can't be located.
        catch(Exception e){
            System.out.println("File not found");
            System.exit(0);
        }
        //add data to input list.
        while(scanner.hasNextLine()){
            input.add(scanner.nextLine()); 
        }
        return input;
	}
}
