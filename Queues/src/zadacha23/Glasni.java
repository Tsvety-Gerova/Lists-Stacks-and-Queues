package zadacha23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Glasni {
	
	public static void main(String[] args) throws Exception {

		File file = new File ("src/zadacha23/Ball.java");		

		if (file.exists()) {
	System.out.println("The number of vowels is " + countVowels(file));
} else {
	System.out.println("File does not exis");
}

	}

	public static int countVowels (File file) throws Exception {
		//char[] vowels = {'a', 'e'};
		Set<Character> vowelsSet = new HashSet<Character>(Arrays.asList('a'));
		int count = 0;
		
		FileReader fr = new FileReader(file);
    	BufferedReader br = new BufferedReader(fr); // allows it to not open the file every single time to read an element; loads more than 1 element
    	int c = 0;
    	boolean conflict = false;
    	// c = br.read()
    	while ((c = br.read()) != -1) { // returns the ascii code of the element
    		// za c = br.read
    		char character = (char) c;  
    		
    		if (vowelsSet.contains(character)) {
    			count++;
    		}
    	}
		return count;
	}
	
	
	
}