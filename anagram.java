/*

 •	Bountang Her
 
 •	Class Time:  MW 5:30pm - 6:45pm

 •	Purpose of program:  Creating an anagram, which is a permutation of letters found in
		the original word. This program also helps to familiarize and gain experience 
		with string objects, arrays, come up with generic algorithms, and opening files
		for input and output.
	
 •	Solution for program:  The program will remove any punctuations and uppercase letters
		in order to find and match the anagram of that word. The program will print the 
		original words and the signatures as a result. It will also be displayed on the
		newly created output file "output.txt". If there are more than 50 words in the
		input file, the program will print a warning and close. The program will ignore
		words that are greater than 15 letters.
	 
 •  Data Structures:  The data structure used to find the solution is an array.   
 
 •	Expected input/output:  The program will prompt the user to input a file. The program
  		will read the input words directly from the file and compute series of anagram of 
 		of words.
 	
 •	Purpose of each classes:  The arrays is used to organize and structure the String of
 		characters and words.
 		
 */

import java.io.*;
import java.util.*;

public class anagram {

    public static void main(String[] args) {
       anagSolver a = new anagSolver();
       System.out.println();
    }
}
    
class anagSolver {
    
    //creates used throughout the entire program constants variables
    //constant variables will not change
    
    //initialize max character = 15
    private int maxChar = 15;
    
    //initialize max amount words = 50
    private int maxWords = 50;
    
    public anagSolver() {
    
    //creates a scanner in order to take the input of the file
	Scanner keyboard = new Scanner(System.in);
	
	//asks for an input file
	System.out.print("Please input the desired file: ");
	
	//transfers input into a filename
	String fileName = keyboard.nextLine();
	
	//creates a file object in order to read each line and character of the input file
	File inFile = new File(fileName);
		
	//declaring a string array for the words with size 50
	//array size is set at 50 because 50 is the max number of words allowed
	String[] words = new String[50];
	
	//declaring a string array for the signatures with size 50
	String[] signatures = new String[50];
		
	//opening loop 
	//reads file with a try catch statement to handle if any errors are to occur
	try {
            //scanner called to read the file
            Scanner readFile = new Scanner(inFile);
            
            //declaring int for position and initialize it to 0
            int position = 0;
			
            //while loop called to remove any unwanted characters
            while(readFile.hasNextLine()) {
            String line = readFile.nextLine();
            
            //creates an array called spacing
            //used to remove any unwanted characters and changes all characters to lowercase
            //and to split each words
            String[] spacing = line.replaceAll("[^A-Z a-z]", "").toLowerCase().split("\\s+");
			
            //for loop called for the array "spacing"
            for (int i = 0; i < spacing.length; i++) {
                //String spacing = words[i].replaceAll("[^\\W a-z]", "");
                //only collects the words if it is larger than 0 and less than
                //the max character set for the program
                if((spacing[i].length() > 0) && (spacing[i].length() < maxChar)) {
                    if((position == 0) && (position < maxWords)) {
                    //stores each word in an array 
                    //keeps track of current positions for each word tested
                    words[position] = spacing[i].substring(0);
                    position++;
                    //prints a warning if there are more than 50 words found in the input file
                    //it will exit out of the program if it is over 50 words
                } else if(position > (maxWords - 1)) {
                    System.out.println("There are more than 50 words in your file!");
                    System.exit(0);
				} else {
                    words[position] = spacing[i];
                    position++;
                }
            }
		}
    }
			
    if(words[1] == null) {
        System.out.println("File is empty!");
        System.out.println("Program is closing. Please try again!");
    }
			
    //for loop called to move the words in the signature array
    for (int i = 0; i < words.length; i++) {
    //loops stops once it tests each word found in the input file
        if(words[i] != null) {
            String spacing = words[i].toLowerCase().replaceAll("\\W", "");
            //changes the data type to char
            char[] transfer = spacing.toCharArray();
            String tempSig = new String(transfer);
            signatures[i] = tempSig;	
        }
    }
			
    //creates an array with size 50
    String[] anagrams = new String[50];
			
    //declaring int for the object which is set to 0
    int wordSize = 0;
    
    //for loop called to find number words used in the array
    //stops count once it reaches the null value
    for (int i = 0; i < words.length; i++) {
        if(words[i] == null) {
            wordSize = i;
            break;
        }
    }
			
    //boolean used to find out which signatures in the array are different
    //from the original word found in the input file
    int result = 0;
    
    //compares each word
    boolean different = true;
    
    for (int i = 0; i < words.length; i++) {
        //boolean different = false;
        for (int j = 0; j < i; j++) {
            //compares signature at position i and j for different values
            if (signatures[i] != (signatures[j])) {
                different = false;
                break;
            }
		}
		//if the words are different (false), it will store them into signature
		//at a fixed position
		if (!different) {
            anagrams[result] = signatures[i];
            result++;
        }
    }
    
    //finds the length of the words that are different from the original
    int length = 0;
    
    for(int i = 0; i < anagrams.length; i++) {
    //stops loop once it reaches the null value
        if(anagrams[i] == null) {
            length = i;
            break;
		}
    }
			
    //prints header for the output of the program
    /*
      prints the anagram of the word on the same line as the original word to show a
      comparison
    */
    System.out.print("Original" + " " + "Signature" + "\n");
    
    for(int i = 0; i < length; i++) {
        for(int j = i; j < wordSize; j++) {
            if(anagrams[i].equals(anagrams[j])) {
                System.out.print(words[i] + "     " + anagrams[j]);
            }
            if(j == (wordSize - 1)) {
                System.out.println();
            } 
        } 
    } 
			
    try {
        //calls the PrintWriter class to write on the output file
        PrintWriter printing = new PrintWriter(new FileWriter("output.txt"));
        printing.print(anagrams);
        //closes the PrintWriter
        printing.close();
        //catches error if there is a problem writing an output file
    } catch(java.io.IOException e) {
        e.printStackTrace();
    }	
    //catches error when the user inputs a file in the scanner class used in the 
    //beginning of the program
    } catch(FileNotFoundException e) {
        e.printStackTrace();
    }
    }
}