package md5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> dictionary = new ArrayList<String>();
		getInput(input, dictionary);
		for(String s : input) {
			dictionaryAttack(input, dictionary);
		}
		
	}
	
	public static void dictionaryAttack(ArrayList<String> input, ArrayList<String> dictionary) {
		double duration;
		String solution = null;
		//get current system time.
		long startTime = System.nanoTime();
		while(solution != input.get(0)) {
			//do algorithm
			for(String pass : dictionary) {
				//convert pass using to md5
			}
		}
		input.remove(0);
		long finishTime = System.nanoTime();
		//calculate duration based on start and finish system times.
		duration = (double)(finishTime - startTime)/ 1000000000.0;
		System.out.print("The password for hash value " + input.get(0) + " is " + solution);
		System.out.print(", it takes the program " + duration + " sec to recover the password\n");
	}
	//helper method to get input text from input.txt
	public static void getInput(ArrayList<String> input, ArrayList<String> dictionary) {
		Scanner scanner1 = null;
		Scanner scanner2 = null;
		try{
			scanner1 = new Scanner(new File("src/md5/input.txt"));
			scanner2 = new Scanner(new File("src/md5/dictionary.txt"));
	    }
		//throws error if the file can't be located.
		catch(Exception e){
			System.out.println("File not found.");
			System.exit(0);
		}
		//add data to input list.
		while(scanner1.hasNext()){
			input.add(scanner1.next()); 
	    }
		while(scanner2.hasNext()) {
			dictionary.add(scanner2.next());
		}
		scanner1.close();
		scanner2.close();
	}
}
