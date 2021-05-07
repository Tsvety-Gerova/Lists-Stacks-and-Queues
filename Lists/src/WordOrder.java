import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WordOrder {

	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<>();
		File myFile = new File("words.txt"); 
		
		try {
			Scanner sc = new Scanner (myFile);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String lineWords[] = line.split("[\\s.,]+ ");
				words.addAll(Arrays.asList(lineWords));
				}
			
		   sc.close();
		} catch (FileNotFoundException e) {
			try {
				myFile.createNewFile();	
			
			} catch (IOException el) {
				el.printStackTrace();
			}
		}
		
		Collections.sort(words);
		System.out.println(words);
	}
	
}
