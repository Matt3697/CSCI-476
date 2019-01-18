package decryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PrintWriter writer = null;
		//use PrintWriter to output results to Sagen_Matthew.txt
		try {
			writer = new PrintWriter("src/decryption/Sagen_Matthew.txt", "UTF-8");	
		} 
		catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();	
		}
		//input: An array to hold input file text.
		//output: an array to hold output file text.
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> output = new ArrayList<String>();
		//get the input from the input file
		getInput(input);
		//for each word in the input array, decrypt the word.
		for(String word : input) {
			analyzeWord(word, output);
		}
		//for each word in the output array, output the decrypted message to the output file
		/*for(String word: output) {
			System.out.println(word);
			writer.println(word);
		}*/
		for(int i = 0; i < input.size(); i++) {
			System.out.println(input.get(i) + " --> " + output.get(i));
			writer.println(input.get(i) + " --> " + output.get(i));
		}
		writer.close();
	}
	
	public static void analyzeWord(String word, ArrayList<String> output) {
		String finalWord;								//string to add to output array
		char[] originalWord = word.toCharArray();		//the original word changed to a character array
		char[] newWord = new char[originalWord.length];	//create a char array to represent the decrypted word
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		map.put('a', 'm');//done
		map.put('b', 'l');//done
		map.put('c', 'k');//done
		map.put('d', 'j');//done
		map.put('e', 'i');//done
		map.put('f', 'h');//done
		map.put('g', 'g');//done
		map.put('h', 'f');//done
		map.put('i', 'e');//done
		map.put('j', 'd');//done
		map.put('k', 'c');//done
		map.put('l', 'b');//done
		map.put('m', 'a');//done
		map.put('n', 'z');//done
		map.put('o', 'y');//done
		map.put('p', 'x');//done
		map.put('q', 'w');//done
		map.put('r', 'v');//done
		map.put('s', 'u');//done
		map.put('t', 't');//done
		map.put('u', 's');//done
		map.put('v', 'r');//done
		map.put('w', 'q');//done
		map.put('x', 'p');//done
		map.put('y', 'o');//done
		map.put('z', 'n');//done
		//for each character in the original text, decrypt the character.
		for(int i = 0; i < originalWord.length; i++) {
			int val = (int) originalWord[i];
			if(originalWord[i] == ',' || originalWord[i] == '.') {
				newWord[i] = originalWord[i];
			}
			else {
				newWord[i] = map.get(originalWord[i]);
			}			
		}
		finalWord = new String(newWord);
		output.add(finalWord);
	}
	//helper method to get input text from input.txt
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
