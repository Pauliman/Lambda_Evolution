package lambda_evolution;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Controller {
	
	ArrayList<String> al;

	public static void main(String[] args) {
		// This is done to leave the static context
		Controller c = new Controller();
	} // end of main()
	
	public Controller() {
		al = new ArrayList<>();
		al.add("Jonny");
		al.add("Carl");
		al.add("James");
		al.add("Gordon");
		al.add("Shane");
		al.add("Barney");
		al.add("Bill");
		al.add("Anthony");
		al.add("Jay");
		al.add("Ty");
		start();		
	} // end of constructor()
	
	/**
	 * In this code block three versions of the use of the Comparator will be shown.
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Version 1. The fully implemented Comparator object which clearly follows the old style
	 * of passing on data. The Comparator_Class class gets instantiated and must be considered
	 * part of this code. Its object is passed on to the static sort method of the Collections class
	 * that takes as second argument a Comparator object. The compare()-method of the cc-object is employed 
	 * to sort the array. If you need those Comparator object a lot in your code, this could be a reason to 
	 * have a full implementation of the interface.
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Version 2. The use of an anonymous Comparator object represents a shorter version but still 
	 * passes on an object or data from which to derive methods or behavior. The only difference to 
	 * version 1 is that no distinct class was created and that creating a new class and implementing 
	 * the Comparator interface is mixed together in one place. This used to be the most common way before 
	 * the advent of Lambdas in Java 1.8
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Version 3. The Lambda way of doing it is even shorter and passes on a method directly thus 
	 * it passes on behavior which is one of the key targets of Lambda. 
	 * The structure is as follows: (param_1, param_2) -> code body
	 * The context, being at the point in the Collections.sort()-method's signature where a 
	 * Comparator object is expected, plus the fact that two parameters are stated by the Lambda expression
	 * provides enough information for the compiler to interpret the situation correctly and 
	 * do what is expected.
	 */
	private void start() {
		System.out.println("Unsorted: " + al.toString());
		
		// ++++++ Version 1 +++++++
		Comparator_Class cc = new Comparator_Class();
		Collections.sort(al, cc);
		System.out.println("Version 1: " + al.toString());	
		
		
		// +++++++ Version 2 +++++++
		Collections.sort(al, new Comparator<String>() {
			public int compare(String o1, String o2) {				
				return o2.length() - o1.length();   
			}
		});
		System.out.println("Version 2: " + al.toString());
		
	
		// +++++++ Version 3 +++++++
		Collections.sort(al, (a,b) -> a.length() - b.length());		
		System.out.println("Version 3: " + al.toString());		
	} // end of start()
} // end of class
