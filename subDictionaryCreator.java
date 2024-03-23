package part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.EOFException;
import java.util.Scanner;
import java.util.ArrayList;

public class subDictionaryCreator {
	static ArrayList<String> dictionary = new ArrayList<>();	// Arraylist to be filled with words found in file
	final static String[] invalidCharacter = {"0","1","2","3","4","5","6","7","8","9","?",":","\"",",","=",";","!","."};
																// Invalid characters 
	protected static String standardizeWord(String s) {
		String temp = s.toUpperCase();
		
		for (int i=0; i < 10; i++)								// Get rid of strings with at least 1 digit from 0 to 9
			if (temp.contains(invalidCharacter[i]))
				return null;
		
		if (temp.length() <2)									// Get rid of single character Strings except A and I
			if (temp.equalsIgnoreCase("A") || temp.equalsIgnoreCase("I"))
				return temp;
			else return null;
		
		if (temp.endsWith("’S") || temp.endsWith("’M"))			// Get rid of the 'm and 's at the end of words
			temp = temp.substring(0, temp.indexOf('’'));
		
		for (int i=0; i < invalidCharacter.length; i++) 		// Get rid of ponctuation at the end of strings
			if (temp.endsWith(invalidCharacter[i]))
				temp = temp.substring(0, temp.length()-1);
		
		return temp;
	}
	
	public static ArrayList<String> getListOfWords(File f) {
		try {
			if (f.isFile()) {								// If file exists
				Scanner in = new Scanner (f);
				if (in.hasNext()) {							// If file is not empty
					
					String temp = standardizeWord(in.next());	// Stores temporarily the word pointed at in capital letters without invalid characters
					
					if (temp != null)
						dictionary.add(temp);				// Add word to dictionary if it is valid
					
					while(in.hasNext()) {					// While there are more words in the file
						
						temp = standardizeWord(in.next());	// Stores temporarily the word pointed at in capital letters without invalid characters
						if (temp != null && !dictionary.contains(temp))		
							dictionary.add(temp);			// Add word to dictionary if it is valid and it is not already there
					}
				}
				else System.out.println("File is empty");	// If file is empty
				in.close();									// Close stream and throw exception
				throw new EOFException();
			}
			else throw new FileNotFoundException();			// If file does not exist
		} 
		catch (EOFException e) {
			
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			return null;
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		return dictionary;								// Returns arraylist with words found
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the SubDictionaryCreator program!\n");
		
		File f1 = new File("PersonOfTheCentury.txt");		// Create file access
		ArrayList<String> dictionary = getListOfWords(f1);	// Store words found in given file into a dictionary
		dictionary.sort(null);								// Sorts the dictionary words in alphabetical order
		
		try {
			File f2 = new File("SubDictionary.txt");
			PrintWriter out = new PrintWriter(f2);
			System.out.println("The document produced this sub-dictionary, which includes "+dictionary.size()+" entries.\n");
			out.println("The document produced this sub-dictionary, which includes "+dictionary.size()+" entries.\n");
			
			for (int j=0; j<26; j++) {							// For all letters in alphabet
				out.append((char)('A'+j)+"\n==\n");
				System.out.print((char)('A'+j)+"\n==\n");
				for (int i=0; i < dictionary.size(); i++)		// Print the words from the dictionary that start with that letter in alphabetical order
					if (dictionary.get(i).charAt(0) == ('A'+j)) {
						out.append(dictionary.get(i)+"\n");
						System.out.print(dictionary.get(i)+"\n");
					}
				out.append("\n");								// Prints an empty line to separate different letters
				System.out.println();
			}
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		System.out.println("SubDictionary Created\n\n"+"End of program");
		System.exit(0);
	}
}