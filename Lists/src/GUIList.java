import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIList {

	public static void main(String[] args) {

		LinkedList<Integer> numbers = new LinkedList<>();
		//System.out.println("Enter numbers: ");
//		Scanner sc = new Scanner(System.in);
//		   for (int i = 0; i < 5; i ++ ) {
//			   Integer number = sc.nextInt();
//			   if ( ! numbers.contains(number)) { // if the list doesn't contain the number it will be added 
//				   numbers.add(number);
//			   }
//
//		   }
//		System.out.println(numbers);
//		Collections.sort(numbers); 
//		System.out.println(numbers);
//		Collections.sort(numbers, Collections.reverseOrder()); // sorting it reversed 
//		System.out.println(numbers);
//		Collections.shuffle(numbers);
//		System.out.println(numbers);
		
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel ();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // arranges the elements vertically
		

		 // regular set-up stuff
		frame.add(panel, BorderLayout.CENTER); // add panel to the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Numbers");
		frame.pack(); // set the window to match a certain size
		
		
		JTextArea numbersArea = new JTextArea(); // where the numbers are saved
		numbersArea.setEditable(false);
		panel.add(numbersArea);
		
		// detects the input of a number with ENTER click
		JTextField inputNumbers = new JTextField(); // entered numbers 
		inputNumbers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Integer number = Integer.parseInt(inputNumbers.getText()); // number = inputNumber
				   if ( ! numbers.contains(number)) { // if the list numbers doesn't contain the number
					   numbers.add(number);             // it is being added to the list
				   }
				   inputNumbers.setText(""); // deletes the number after it's been added to the list
				   numbersArea.setText(numbers.toString());
				   System.out.println(numbers);
			}
			
		});
		panel.add(inputNumbers);
		
		JButton sortB = new JButton("Sort");
		panel.add(sortB);
		sortB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent c) {
				
				Collections.sort(numbers);
				numbersArea.setText(numbers.toString());
				
			}
		
		});
		
		JButton reverseSortB = new JButton("Reverse Sort");
		panel.add(reverseSortB);
		reverseSortB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent c) {
				
				Collections.sort(numbers, Collections.reverseOrder());
				numbersArea.setText(numbers.toString());
				
			}
		
		});
		
		JButton shuffleB = new JButton("Shuffle");
		panel.add(shuffleB);
		shuffleB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent c) {
				
				Collections.shuffle(numbers);
				numbersArea.setText(numbers.toString());
				
			}
		
		});
		frame.setVisible(true); // set the window to be visible
	}

}
