package MD5Dylan;
/*
 * Authors: Dylan Lynn and Matthew Sagen
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    		//get input from input.txt
        ArrayList<String> input = new ArrayList<String>();
        //get attack dictionary
        ArrayList<String> dictionary = new ArrayList<String>();
        //printwriter to output results to Output.txt
        PrintWriter w = new PrintWriter("src/MD5Dylan/Output.txt", "UTF-8");
        getInput(input, dictionary);
        double duration;
        long startTime = System.currentTimeMillis();
        long finishTime;
        //for each word in the dictionary compare the md5 for that word with the word from the input.txt file
        for (String s : dictionary) {
            String test = Test.getMd5(s);
            for (String s1 : input) {
            		//if there is a match print out the value and time that it took to find the answer.
                if (s1.equals(test)) {
                    finishTime=System.currentTimeMillis();
                    duration=(double)(finishTime - startTime)/1000;
                    System.out.print("The password for hash value " + s1 + " is " + s);
                    w.print("The password for hash value " + s1 + " is " + s);
                    System.out.print(", it takes the program " + duration + " sec to recover the password\n");
                    w.print(", it takes the program " + duration + " sec to recover the password\n");
                } 
                else {
                    continue;
                }
            }
        }
        w.close();
        return;
    }

    //helper method to get input text from input.txt
    public static void getInput(ArrayList<String> input, ArrayList<String> dictionary) {
        Scanner scanner1 = null;
        Scanner scanner2 = null;
        try{
            scanner1 = new Scanner(new File("src/MD5Dylan/input.txt"));
            scanner2 = new Scanner(new File("src/MD5Dylan/dictionary.txt"));
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