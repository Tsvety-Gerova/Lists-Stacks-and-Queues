package zadacha23;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueZad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//the interface Comparable is needed to use PriorityQueue 
		
		PriorityQueue<String> q1 = new PriorityQueue<>(Arrays.asList( "George" , "Jim" , "John" , "Blake" , "Kevin" , "Michael" ));
		PriorityQueue<String> q2 = new PriorityQueue<>(Arrays.asList( "George" , "Katie" , "Kevin" , "Michelle" , "Ryan" ));
		
		System.out.println("Set 1: " + q1);
		System.out.println("Set 2: " + q2);
		
		//creating 3 list for every category
		PriorityQueue<String> united = new PriorityQueue<>(q1);// united contains all elements of q1
		united.addAll(q2); // to unite them we add q2 to q1 (united) 
		
		PriorityQueue<String> intersection = new PriorityQueue<>(q1);
		intersection.retainAll(q2); // shared part; take the elements that both q1 and q2 have
		
		PriorityQueue<String> difference = new PriorityQueue<>(united);
		difference.removeAll(intersection); // difference = the different elements = united - intersection
		
		System.out.println("union: " + united);
		System.out.println("intersection: " + intersection);
		System.out.println("diffenrence: " + difference);

	}

}
