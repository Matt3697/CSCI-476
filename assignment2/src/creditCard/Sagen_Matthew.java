package creditCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Authors: Matthew Sagen, Dylan Lynn, and Andrew Smith 
 */

public class Sagen_Matthew {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("src/creditCard/Sagen_Matthew.output", "UTF-8"); //this is used to print to output file
		ArrayList<String> input = get_inputFileArray();
		ArrayList<String> cards = new ArrayList<String>();
		ArrayList<String> cards2 = new ArrayList<String>();
		ArrayList<String> track1 = new ArrayList<String>();
		//use regular expressions to extract data from .dmp file.
		String sp = "%";
		String semi = ";";
		String regex = "B[0-9]{16}\\^[a-zA-Z]+/[a-zA-Z]+\\^[0-9]{33}\\?"; 
		//parse out strings beginning with %
		for(String i : input) {
			for(String s : i.split(sp)) {
				cards.add(s);
			}
		}
		//parse out string ending with semi colon
		for(String c : cards) {
			for(String s: c.split(semi)) {
				cards2.add(s);
			}
		}
		//loop through remaining strings and find strings that match the regex
		for(String str : cards2) {
			boolean matched = Pattern.matches(regex, str);
			if(matched) {
				track1.add(str);
				//System.out.println(str);
			}
			
		}
		System.out.println("There are " + track1.size() + " track 1 records in the memory data");
		writer.println("There are " + track1.size() + " track 1 records in the memory data");
		//Loop through the track data structure and print each card holders information.
		for(String track : track1) {
			System.out.println("Cardholder's name: " + track.split("\\^")[1]);
			System.out.println("Card Number: " + track.split("\\^")[0].substring(1, 5) + " " +track.split("\\^")[0].substring(5, 9) + " "+ track.split("\\^")[0].substring(9, 13)+ " "+ track.split("\\^")[0].substring(13, 17));
			System.out.println("Expiration Date: " + track.split("\\^")[2].substring(2, 4) + "/" + "20" + track.split("\\^")[2].substring(0, 2));
			System.out.println("CVC Number: " +  track.split("\\^")[2].substring(4, 7));
			
			writer.println("Cardholder's name: " + track.split("\\^")[1]);
			writer.println("Card Number: " + track.split("\\^")[0].substring(1, 5) + " " +track.split("\\^")[0].substring(5, 9) + " "+ track.split("\\^")[0].substring(9, 13)+ " "+ track.split("\\^")[0].substring(13, 17));
			writer.println("Expiration Date: " + track.split("\\^")[2].substring(2, 4) + "/" + "20" + track.split("\\^")[2].substring(0, 2));
			writer.println("CVC Number: " +  track.split("\\^")[2].substring(4, 7));

			writer.println();
			System.out.println();
		}
		writer.close();
	}
	
	//helper method to get input information
	public static ArrayList<String> get_inputFileArray() throws FileNotFoundException, UnsupportedEncodingException{ //helper method creates jobs from input.txt
		Scanner scanner = null;
		ArrayList<String> input = new ArrayList<String>();	//holds data from input.txt in the form of Job# | Arrival_Time | Processing_Time
		//ArrayList<Job> jobs = new ArrayList<Job>();			//holds individual jobs from input.
		
        try{
            scanner = new Scanner(new File("memorydump.dmp"));
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
