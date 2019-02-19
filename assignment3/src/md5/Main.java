package md5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		getInput(input);
		for(String s: input) {
			System.out.println(s);
		}
		
	}
	
	//helper method to get input text from input.txt
	public static void getInput(ArrayList<String> input) {
		Scanner scanner = null;
		try{
			scanner = new Scanner(new File("src/md5/input.txt"));
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
