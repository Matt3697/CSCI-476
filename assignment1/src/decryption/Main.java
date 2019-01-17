package decryption;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		getInput(input);
		
	}
	
	public static void getInput(ArrayList<String> input) {
		Scanner scanner = null;
		 try{
			 scanner = new Scanner(new File("src/decryption/input.txt"));
	     }
		 //throws error if the file can't be located.
		 catch(Exception e){
			 System.out.println("File not found.");
			 System.exit(0);
		 }
		 //add data to input list.
		 while(scanner.hasNext()){
			 input.add(scanner.next()); 
	     }
		 scanner.close();
	}
}
