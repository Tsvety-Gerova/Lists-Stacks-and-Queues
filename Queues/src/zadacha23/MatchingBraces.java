package zadacha23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MatchingBraces {

	public static void main(String[] args) {

        Stack<Character> braces = new Stack<>();
		File myObj = new File("src/zadacha23/Ball.java");
		FileReader fr;
		
	    try {
	    	fr = new FileReader(myObj);
	    	BufferedReader br = new BufferedReader(fr); // allows it to not open the file every single time to read an element; loads more than 1 element
	    	int c = 0;
	    	boolean conflict = false;
	    	// c = br.read()
	    	while ((c = br.read()) != -1) { // returns the ascii code of the element
	    		// za c = br.read
	    		char character = (char) c;        // if we've reached the end of the file br will be -1
	    		
	    		if (character == '{' || character == '[' || character == '(') { // check if a character isn't one of the following 
	    			braces.add(character); // save the character
	    		} else if (character == '}') {
	    			conflict = braces.pop() != '{'; // if the last element in the stack is different than the one that fits into the pair
	    		} else if (character == ']') {      // conflict = true; the braces aren't balanced
    			    conflict = braces.pop() != '['; 
 	    		} else if (character == ')') {
	    			conflict = braces.pop() != '(';
 	    		}
	    		
	    		if (conflict) {
	    		break;
	    		}
	    		
	    		// c = br.read();	    		
	    	}
	    
	    	if (conflict || ! braces.isEmpty()) {
	    		System.out.println("Mismatched braces");
	    	} else {
	    		System.out.println("No mismatched braces");
	    	}
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	
	   }
		
	}


